/*
 * Copyright (C) 2012 CyberAgent
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyberlink.clgpuimage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;

import com.cyberlink.clgpuimage.util.TextureRotationUtil;
import com.het.facesdk.makeup.BeautyManager;
import com.het.facesdk.utils.CameraUtil;
import com.het.facesdk.utils.OpenGlUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static com.cyberlink.clgpuimage.util.TextureRotationUtil.TEXTURE_NO_ROTATION;
import static com.cyberlink.clgpuimage.util.TextureRotationUtil.TEXTURE_ROTATED_90;


@TargetApi(11)
public class GPUImageRenderer implements Renderer, PreviewCallback {
    private static final String TAG = "GPUImageRender";
    public static final int NO_IMAGE = -1;
    public static final float[] CUBE = new float[]{
            -1.0f, 1.0f,
            1.0f, 1.0f,
            -1.0f, -1.0f,
            1.0f, -1.0f
    };


    public final Object mSurfaceChangedWaiter = new Object();

    private int mGLTextureId = NO_IMAGE;
    private SurfaceTexture mCameraTexture = null;
    private int mCameraTextureId;
    private final FloatBuffer mGLCubeBuffer;
    private final FloatBuffer mGLTextureBuffer;
    private final FloatBuffer mGLCLMakeUpVertexBuffer;
    private final FloatBuffer mGLCLMakeUpFragBuffer;
    private IntBuffer mGLRgbBuffer;

    private int mOutputWidth;
    private int mOutputHeight;
    private int mImageWidth;
    private int mImageHeight;
    private int mAddedPadding;

    private final Queue<Runnable> mRunOnDraw;
    private final Queue<Runnable> mRunOnDrawEnd;
    private Rotation mRotation;
    private boolean mFlipHorizontal;
    private boolean mFlipVertical;
    private GPUImage.ScaleType mScaleType = GPUImage.ScaleType.CENTER_CROP;

    private float mBackgroundRed = 0;
    private float mBackgroundGreen = 0;
    private float mBackgroundBlue = 0;

    private BeautyManager mBeautyManager;
    private Context mContext;
    private Camera mCamera;
    private CameraFilter mCameraFilter;
    private GPUImageFilter mFilter;
    private GLSurfaceView mGLSurfaceView;

    private Bitmap[] mBitmapCaches = new Bitmap[2];

    public GPUImageRenderer(final GPUImageFilter filter, Context context) {

        mContext = context;
        mBeautyManager = BeautyManager.getInstance(mContext);

        mCameraFilter = new CameraFilter();
        mFilter = filter;

        mRunOnDraw = new LinkedList<Runnable>();
        mRunOnDrawEnd = new LinkedList<Runnable>();

        mGLCubeBuffer = ByteBuffer.allocateDirect(CUBE.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        mGLCubeBuffer.put(CUBE).position(0);

        mGLTextureBuffer = ByteBuffer.allocateDirect(TEXTURE_NO_ROTATION.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        mGLTextureBuffer.put(TEXTURE_NO_ROTATION);
        mGLTextureBuffer.position(0);

        mGLCLMakeUpVertexBuffer = ByteBuffer.allocateDirect(CUBE.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        mGLCLMakeUpVertexBuffer.put(CUBE).position(0);

        mGLCLMakeUpFragBuffer = ByteBuffer.allocateDirect(TEXTURE_NO_ROTATION.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        mGLCLMakeUpFragBuffer.put(TEXTURE_NO_ROTATION);
        mGLCLMakeUpFragBuffer.position(0);
//        setRotation(Rotation.NORMAL, false, false);

        initBlushBitmaps();
    }

    private void initBlushBitmaps() {
        try {
            mBitmapCaches[0] = BitmapFactory.decodeStream(mContext.getAssets().open("blush/01_l.png"));
            mBitmapCaches[1] = BitmapFactory.decodeStream(mContext.getAssets().open("blush/01_r.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGLSurfaceView(GLSurfaceView glSurfaceView) {
        mGLSurfaceView = glSurfaceView;
    }

    private int genCameraTexture() {
        int[] cameraTexture = new int[1];
        GLES20.glGenTextures(1, cameraTexture, 0);
        return cameraTexture[0];
    }

    private void releaseCameraTexture() {
        GLES20.glDeleteTextures(1, new int[]{mCameraTextureId}, 0);
    }

    @Override
    public void onSurfaceCreated(final GL10 unused, final EGLConfig config) {
        GLES20.glClearColor(mBackgroundRed, mBackgroundGreen, mBackgroundBlue, 1);
        GLES20.glDisable(GLES20.GL_DEPTH_TEST);

        mCameraFilter.init();
        mFilter.init();

        mCameraTextureId = genCameraTexture();
        mCameraTexture = new SurfaceTexture(mCameraTextureId);
        mCameraTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            @Override
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                mGLSurfaceView.requestRender();
            }
        });
        mCamera = CameraUtil.openCamera(mGLSurfaceView.getMeasuredWidth(),
                mGLSurfaceView.getMeasuredHeight());
        mCamera.setDisplayOrientation(90);
        if (mCamera != null) {
            try {
                mCamera.setPreviewTexture(mCameraTexture);
                mCamera.setPreviewCallback(this);
                mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (mFilter instanceof CLMakeupLiveFilter) {
            CLMakeupLiveFilter clMakeupLiveFilter = (CLMakeupLiveFilter) mFilter;
            clMakeupLiveFilter.setBlushBitmaps(mBitmapCaches);
            clMakeupLiveFilter.setEyelinerEnable(true);
            clMakeupLiveFilter.setEyelinerModel(mBeautyManager.getEyeLiner(), 0xFF333333);
            clMakeupLiveFilter.setEyeLashEnable(true);
            clMakeupLiveFilter.setEyeLashModel(mBeautyManager.getEyeLash(), 0xFF333333);
        }
    }

    @Override
    public void onSurfaceChanged(final GL10 gl, final int width, final int height) {
        mOutputWidth = width;
        mOutputHeight = height;
        GLES20.glViewport(0, 0, width, height);
        GLES20.glUseProgram(mCameraFilter.getProgram());
        mCameraFilter.onOutputSizeChanged(width, height);
        GLES20.glUseProgram(mFilter.getProgram());
        mFilter.onOutputSizeChanged(width, height);
//        adjustImageScaling();
        synchronized (mSurfaceChangedWaiter) {
            mSurfaceChangedWaiter.notifyAll();
        }
    }

    @Override
    public void onDrawFrame(final GL10 gl) {
        if (mCameraTexture == null) {
            return;
        }
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        runAll(mRunOnDraw);

        mCameraTexture.updateTexImage();
        float[] matrix = new float[16];
        mCameraTexture.getTransformMatrix(matrix);
        mCameraFilter.setUniformMatrix4f(mCameraFilter.getTransformMatrixLocation(), matrix);
//        mCameraFilter.onDraw(mCameraTextureId, mGLCubeBuffer, mGLTextureBuffer);
        int outCameraId = mCameraFilter.drawWithFrameBuffer(mCameraTextureId, mGLCubeBuffer, mGLTextureBuffer);
        mFilter.onDraw(outCameraId, mGLCLMakeUpVertexBuffer, mGLCLMakeUpFragBuffer);


        runAll(mRunOnDrawEnd);

    }

    /**
     * Sets the background color
     *
     * @param red   red color value
     * @param green green color value
     * @param blue  red color value
     */
    public void setBackgroundColor(float red, float green, float blue) {
        mBackgroundRed = red;
        mBackgroundGreen = green;
        mBackgroundBlue = blue;
    }

    private void runAll(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }


    Rect rect = new Rect();

    @Override
    public void onPreviewFrame(final byte[] data, final Camera camera) {

        final Size previewSize = camera.getParameters().getPreviewSize();
        BeautyManager.getInstance(mContext).sendFrameBuffer(data, previewSize.width, previewSize.height, 270, true);
        boolean result = BeautyManager.getInstance(mContext).getFaceRect(rect);
        Log.d(TAG, result + "");
        if (result) {
            if (mFilter instanceof CLMakeupLiveFilter) {
                mBeautyManager.getMakeUpData();
                CLMakeupLiveFilter clMakeupLiveFilter = (CLMakeupLiveFilter) mFilter;
                clMakeupLiveFilter.handleData(mBeautyManager.liveEyeMakeupMetadata, mBeautyManager.lipstickData, mBeautyManager.liveBlushMakeupdata, mBeautyManager.liveSmoothMetadata, mBeautyManager.liveFrameInformation);
                clMakeupLiveFilter.setHasData(true);
            }
        } else {
            if (mFilter instanceof CLMakeupLiveFilter) {
                CLMakeupLiveFilter clMakeupLiveFilter = (CLMakeupLiveFilter) mFilter;
                clMakeupLiveFilter.setHasData(false);
            }
        }
    }


    public void setFilter(final GPUImageFilter filter) {
        runOnDraw(new Runnable() {

            @Override
            public void run() {
                final GPUImageFilter oldFilter = mFilter;
                mFilter = filter;
                if (oldFilter != null) {
                    oldFilter.destroy();
                }
                mFilter.init();
                GLES20.glUseProgram(mFilter.getProgram());
                mFilter.onOutputSizeChanged(mOutputWidth, mOutputHeight);
            }
        });
    }

    public void deleteImage() {
        runOnDraw(new Runnable() {

            @Override
            public void run() {
                GLES20.glDeleteTextures(1, new int[]{
                        mGLTextureId
                }, 0);
                mGLTextureId = NO_IMAGE;
            }
        });
    }

    public void setImageBitmap(final Bitmap bitmap) {
        setImageBitmap(bitmap, true);
    }

    public void setImageBitmap(final Bitmap bitmap, final boolean recycle) {
        if (bitmap == null) {
            return;
        }

        runOnDraw(new Runnable() {

            @Override
            public void run() {
                Bitmap resizedBitmap = null;
                if (bitmap.getWidth() % 2 == 1) {
                    resizedBitmap = Bitmap.createBitmap(bitmap.getWidth() + 1, bitmap.getHeight(),
                            Bitmap.Config.ARGB_8888);
                    Canvas can = new Canvas(resizedBitmap);
                    can.drawARGB(0x00, 0x00, 0x00, 0x00);
                    can.drawBitmap(bitmap, 0, 0, null);
                    mAddedPadding = 1;
                } else {
                    mAddedPadding = 0;
                }

                mGLTextureId = OpenGlUtils.loadTexture(
                        resizedBitmap != null ? resizedBitmap : bitmap, mGLTextureId, recycle);
                if (resizedBitmap != null) {
                    resizedBitmap.recycle();
                }
                mImageWidth = bitmap.getWidth();
                mImageHeight = bitmap.getHeight();
                adjustImageScaling();
            }
        });
    }

    public void setScaleType(GPUImage.ScaleType scaleType) {
        mScaleType = scaleType;
    }

    protected int getFrameWidth() {
        return mOutputWidth;
    }

    protected int getFrameHeight() {
        return mOutputHeight;
    }

    private void adjustImageScaling() {
//        float outputWidth = mOutputWidth;
//        float outputHeight = mOutputHeight;
//        if (mRotation == Rotation.ROTATION_270 || mRotation == Rotation.ROTATION_90) {
//            outputWidth = mOutputHeight;
//            outputHeight = mOutputWidth;
//        }
//
//        float ratio1 = outputWidth / mImageWidth;
//        float ratio2 = outputHeight / mImageHeight;
//        float ratioMax = Math.max(ratio1, ratio2);
//        int imageWidthNew = Math.round(mImageWidth * ratioMax);
//        int imageHeightNew = Math.round(mImageHeight * ratioMax);
//
//        float ratioWidth = imageWidthNew / outputWidth;
//        float ratioHeight = imageHeightNew / outputHeight;
//
//        float[] cube = CUBE;
//        float[] textureCords = TextureRotationUtil.getRotation(mRotation, mFlipHorizontal, mFlipVertical);
//        if (mScaleType == GPUImage.ScaleType.CENTER_CROP) {
//            float distHorizontal = (1 - 1 / ratioWidth) / 2;
//            float distVertical = (1 - 1 / ratioHeight) / 2;
//            textureCords = new float[]{
//                    addDistance(textureCords[0], distHorizontal), addDistance(textureCords[1], distVertical),
//                    addDistance(textureCords[2], distHorizontal), addDistance(textureCords[3], distVertical),
//                    addDistance(textureCords[4], distHorizontal), addDistance(textureCords[5], distVertical),
//                    addDistance(textureCords[6], distHorizontal), addDistance(textureCords[7], distVertical),
//            };
//        } else {
//            cube = new float[]{
//                    CUBE[0] / ratioHeight, CUBE[1] / ratioWidth,
//                    CUBE[2] / ratioHeight, CUBE[3] / ratioWidth,
//                    CUBE[4] / ratioHeight, CUBE[5] / ratioWidth,
//                    CUBE[6] / ratioHeight, CUBE[7] / ratioWidth,
//            };
//        }
//
//        mGLCubeBuffer.clear();
//        mGLCubeBuffer.put(cube).position(0);
//        mGLTextureBuffer.clear();
//        mGLTextureBuffer.put(textureCords).position(0);
    }

    private float addDistance(float coordinate, float distance) {
        return coordinate == 0.0f ? distance : 1 - distance;
    }

    public void setRotationCamera(final Rotation rotation, final boolean flipHorizontal,
                                  final boolean flipVertical) {
        setRotation(rotation, flipVertical, flipHorizontal);
    }

    public void setRotation(final Rotation rotation) {
        mRotation = rotation;
        adjustImageScaling();
    }

    public void setRotation(final Rotation rotation,
                            final boolean flipHorizontal, final boolean flipVertical) {
        mFlipHorizontal = flipHorizontal;
        mFlipVertical = flipVertical;
        setRotation(rotation);
    }

    public Rotation getRotation() {
        return mRotation;
    }

    public boolean isFlippedHorizontally() {
        return mFlipHorizontal;
    }

    public boolean isFlippedVertically() {
        return mFlipVertical;
    }

    protected void runOnDraw(final Runnable runnable) {
        synchronized (mRunOnDraw) {
            mRunOnDraw.add(runnable);
        }
    }

    protected void runOnDrawEnd(final Runnable runnable) {
        synchronized (mRunOnDrawEnd) {
            mRunOnDrawEnd.add(runnable);
        }
    }


}
