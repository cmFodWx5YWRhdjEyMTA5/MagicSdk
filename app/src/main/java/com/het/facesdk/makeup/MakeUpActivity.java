package com.het.facesdk.makeup;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.SeekBar;

import com.het.facesdk.R;
import com.het.facesdk.SimpleBaseActivity;
import com.het.facesdk.facepp.FaceppEngine;
import com.het.facesdk.makeup.matrix.BiMatrix;
import com.het.facesdk.makeup.matrix.PosterizeMatrix;
import com.het.facesdk.utils.CameraUtil;
import com.het.facesdk.utils.FilterUtil;
import com.megvii.facepp.sdk.Facepp;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MakeUpActivity extends SimpleBaseActivity {


    private static final String TAG = MakeUpActivity.class.getSimpleName();

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MakeUpActivity.class);
        context.startActivity(intent);
    }


    private SeekBar mBiSeekBar;
    private GLSurfaceView mGLSurfaceView;
    private CameraRender mCameraRender;
    private SurfaceTexture mCameraTexture;
    private MakeUpEngine.IMatrix mCameraMatrix;
    private MakeUpEngine.IMatrix mBiMatrix;
    private MakeUpEngine.IMatrix mPosterizeMatrix;
    private Camera mCamera;
    private Camera.Parameters mCamParm;
    private ByteBuffer mCameraBuffer;
//    private int[] mTextureIds = new int[4];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up);

        checkIfSupportOpenGL3();

        mBiSeekBar = findViewById(R.id.bi_seekbar);
        mBiSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, boolean fromUser) {

                mGLSurfaceView.queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "onProgressChanged#" + progress);
//                        BiMatrix matrix = (BiMatrix) mBiMatrix;
//                        matrix.setDistanceNormalizationFactor(FilterUtil.range(progress, 0.0f, 15.0f));
                        PosterizeMatrix posterizeMatrix = (PosterizeMatrix) mPosterizeMatrix;
                        posterizeMatrix.setColorLevels(FilterUtil.range(progress, 1, 50));
                    }
                });
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mGLSurfaceView = findViewById(R.id.glSurfaceView);
        mCameraRender = new CameraRender();
        mGLSurfaceView.setEGLContextClientVersion(3);
        mGLSurfaceView.setRenderer(mCameraRender);
        mGLSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

    }


    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void checkIfSupportOpenGL3() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo info = am.getDeviceConfigurationInfo();
        Log.d(TAG, info.getGlEsVersion());
    }

    private class CameraRender implements GLSurfaceView.Renderer {
        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {


            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);


            mCamera = CameraUtil.openCamera(mGLSurfaceView.getMeasuredWidth(), mGLSurfaceView.getMeasuredHeight());
            if (mCamera != null) {
                mCamParm = mCamera.getParameters();
            }
            final Camera.Size size = mCamParm.getPreviewSize();

            MakeUpEngine.onSurfaceCreated(mGLSurfaceView.getMeasuredWidth(), mGLSurfaceView.getMeasuredWidth());
            mCameraMatrix = MakeUpEngine.create(MakeUpEngine.CAMERA);
//            mBiMatrix = MakeUpEngine.create(MakeUpEngine.BILATERAL);
            mPosterizeMatrix = MakeUpEngine.create(MakeUpEngine.POSTERIZE);
            MakeUpEngine.push(mCameraMatrix);
//            MakeUpEngine.push(mBiMatrix);
            MakeUpEngine.push(mPosterizeMatrix);

            mCameraBuffer = ByteBuffer.allocate(size.width * size.height * 3 / 2);
            mCamera.addCallbackBuffer(mCameraBuffer.array());
            mCamera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
                @Override
                public void onPreviewFrame(byte[] data, Camera camera) {
                    Facepp.Face[] faces = FaceppEngine.detect(data, size.width, size.height, Facepp.IMAGEMODE_NV21);
                    if (faces.length != 0) {
                        Log.d(TAG, "DETECT FACE");
                    } else {
                        Log.d(TAG, "NOT FOUND");
                    }
                    mCamera.addCallbackBuffer(mCameraBuffer.array());
                }
            });

            mCameraTexture = new SurfaceTexture(mCameraMatrix.textureId());
            mCameraTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                @Override
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    mGLSurfaceView.requestRender();
                }
            });
            try {
                mCamera.setPreviewTexture(mCameraTexture);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mCamera.startPreview();
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            gl.glViewport(0, 0, width, height);
            MakeUpEngine.onSurfaceChanged(width, height);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            mCameraTexture.updateTexImage();
            GLES30.glClear(GLES20.GL_COLOR_BUFFER_BIT);
            MakeUpEngine.work();
        }
    }
}
