package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.opengl.GLES20;

import com.het.facesdk.makeup.BeautyManager;
import com.het.facesdk.utils.OpenGlUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static com.cyberlink.clgpuimage.CLMakeupLiveBlushFilter.LiveBlushMakeupdata;
import static com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata;
import static com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipstickData;
import static com.cyberlink.clgpuimage.CLMakeupLiveSmoothFilter.LiveSmoothMetadata;

/**
 * MakeUp总滤镜
 *
 * @author galis
 */

public class CLMakeupLiveFilter extends GPUImageFilter {

    private static final int EYELINER = MakeupLiveFeatures.EYELINER.ordinal();
    private static final int EYESHADOW = MakeupLiveFeatures.EYESHADOW.ordinal();
    private static final int LIPSTICK = MakeupLiveFeatures.LIPSTICK.ordinal();
    private static final int SMOOTH = MakeupLiveFeatures.SMOOTH.ordinal();
    private static final int BLUSH = MakeupLiveFeatures.BLUSH.ordinal();
    private static final int EYELASH = MakeupLiveFeatures.EYELASH.ordinal();

    private static final int FBO_SIZE = 7;

    public static enum CaptureFrameType {
        NONE,
        CAPTURE_SOURCE,
        CAPTURE_AFTER_MAKEUP_FILTERS,
        CAPTURE_BOTH
    }

    public static enum FLIP_MODE {
        NONE,
        FOR_PORTRAIT_ORIENTATION,
        FOR_LANDSCAPE_ORIENTATION
    }

    public static class LiveFrameInformation {
        public ArrayList<PointF> feature_points = new ArrayList();
        public boolean is_flipped;
        public int rotation;

        public void Copy(LiveFrameInformation liveFrameInformation) {
            feature_points = new ArrayList(liveFrameInformation.feature_points);
            rotation = liveFrameInformation.rotation;
            is_flipped = liveFrameInformation.is_flipped;
        }
    }

    public static enum MakeupLiveFeatures {
        EYELINER,
        EYESHADOW,
        LIPSTICK,
        SMOOTH,
        BLUSH,
        EYELASH
    }

    private boolean mEnableSmooth;
    private FeatureHolder mCurrentFeatureHolder;
    private FeatureHolder mNewFeatureHolder;
    private LiveEyeMakeupMetadata[] liveEyeMakeupMetaData;
    private LipstickData mLipstickData;
    private LiveBlushMakeupdata mLiveBlushMakeupData;
    private LiveSmoothMetadata liveSmoothMetaData;
    private LiveFrameInformation liveFrameInfomation;

    private CLMakeupLiveEyeFilter clMakeupLiveEyeFilterLeft;
    private CLMakeupLiveEyeFilter clMakeupLiveEyeFilterRight;
    private CLMakeupLiveSmoothFilter clMakeupLiveSmotthFilter;
    private CLMakeupLiveBlushFilter clMakeupLiveBlushFilter;
    private CLMakeupLiveLipStickFilter clMakeupLiveLipStickFilter;
    private GPUImageFilter mWindowFilter;
    private List<GPUImageFilter> mFilters;
    private int[] mFrameBuffers;
    private int[] mFrameColorTextures;
    private float darkestLuma;
    private float brightestLuma;
    private final Object mDataLock;
    private final Object mSetDataLock;

    private Bitmap[] mBitmapCaches;
    private PointF[] mEyePoints;


    public CLMakeupLiveFilter() {
        this(true, true, true, true, true);
    }

    public CLMakeupLiveFilter(boolean eyeLinear, boolean eyeShadow, boolean lipStick, boolean smooth, boolean eyelash) {
        this(eyeLinear, eyeShadow, lipStick, smooth, eyelash, false);
    }

    public CLMakeupLiveFilter(boolean eyeLinear, boolean eyeShadow, boolean lipStick, boolean smooth, boolean blush, boolean eyelash) {

        mDataLock = new Object();
        mSetDataLock = new Object();
        mFilters = new ArrayList<>();


        mCurrentFeatureHolder = new FeatureHolder(this);
        mNewFeatureHolder = new FeatureHolder(this);
        mCurrentFeatureHolder.features[EYELINER] = eyeLinear;
        mCurrentFeatureHolder.features[EYESHADOW] = eyeShadow;
        mCurrentFeatureHolder.features[LIPSTICK] = lipStick;
        mCurrentFeatureHolder.features[SMOOTH] = smooth;
        mCurrentFeatureHolder.features[BLUSH] = blush;
        mCurrentFeatureHolder.features[EYELASH] = eyelash;


        clMakeupLiveSmotthFilter = new CLMakeupLiveSmoothFilter();
        clMakeupLiveEyeFilterLeft = new CLMakeupLiveEyeFilter(true);
        clMakeupLiveEyeFilterRight = new CLMakeupLiveEyeFilter(false);
        clMakeupLiveLipStickFilter = new CLMakeupLiveLipStickFilter();
        clMakeupLiveBlushFilter = new CLMakeupLiveBlushFilter();
        mWindowFilter = new GPUImageFilter();

        liveEyeMakeupMetaData = new LiveEyeMakeupMetadata[2];
        liveEyeMakeupMetaData[0] = new LiveEyeMakeupMetadata();
        liveEyeMakeupMetaData[1] = new LiveEyeMakeupMetadata();
        mLipstickData = new LipstickData();
        mLiveBlushMakeupData = new LiveBlushMakeupdata();
        liveSmoothMetaData = new LiveSmoothMetadata();
        liveFrameInfomation = new LiveFrameInformation();

        //确定素材关键点.用于变形?
        mEyePoints = new PointF[4];
        mEyePoints[0] = new PointF(142.0f, 143.5f);
        mEyePoints[1] = new PointF(229.0f, 106.5f);
        mEyePoints[2] = new PointF(316.5f, 143.5f);
        mEyePoints[3] = new PointF(229.0f, 181.0f);
//        for (int eyeLinerTextures = 0; eyeLinerTextures < mBitmapCaches.length; eyeLinerTextures++) {
//            mBitmapCaches[]
//        }
    }

    @Override
    public void onInit() {
        super.onInit();
        clMakeupLiveSmotthFilter.init();
        clMakeupLiveEyeFilterLeft.init();
        clMakeupLiveEyeFilterRight.init();
        clMakeupLiveLipStickFilter.init();
        clMakeupLiveBlushFilter.init();
        mWindowFilter.init();

        initEyePoints(mEyePoints, 450, 300, 480, 320, 2);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clMakeupLiveSmotthFilter.onDestroy();
        clMakeupLiveEyeFilterLeft.onDestroy();
        clMakeupLiveEyeFilterRight.onDestroy();
        clMakeupLiveLipStickFilter.onDestroy();
        clMakeupLiveBlushFilter.onDestroy();
        mWindowFilter.onDestroy();
        release();
    }

    @Override
    public void onOutputSizeChanged(int width, int height) {
        super.onOutputSizeChanged(width, height);
        clMakeupLiveSmotthFilter.onOutputSizeChanged(width, height);
        clMakeupLiveEyeFilterLeft.onOutputSizeChanged(width, height);
        clMakeupLiveEyeFilterRight.onOutputSizeChanged(width, height);
        clMakeupLiveLipStickFilter.onOutputSizeChanged(width, height);
        clMakeupLiveBlushFilter.onOutputSizeChanged(width, height);
        mWindowFilter.onOutputSizeChanged(width, height);


        if (mFrameBuffers != null) {
            release();
        }

        initImage2Ds();

    }

    @Override
    public void onDraw(int textureId, FloatBuffer cubeBuffer, FloatBuffer textureBuffer) {
//        super.onDraw(textureId, cubeBuffer, textureBuffer);
//        synchronized (mDataLock) {
//            freshData();
//        }

        synchronized (this.mSetDataLock) {
            this.mCurrentFeatureHolder.isHas = this.mNewFeatureHolder.isHas;
//            this.mCurrentFeatureHolder.features = this.mNewFeatureHolder.features.clone();
//            this.mCurrentFeatureHolder.captureFrameType = this.mNewFeatureHolder.captureFrameType;
//            this.mNewFeatureHolder.captureFrameType = CaptureFrameType.NONE;
        }


        IntBuffer bindingBuffer = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(GLES20.GL_FRAMEBUFFER_BINDING, bindingBuffer);
        IntBuffer viewPortBuffer = IntBuffer.allocate(4);
        GLES20.glGetIntegerv(GLES20.GL_VIEWPORT, viewPortBuffer);

        synchronized (this.mDataLock) {
            if (mCurrentFeatureHolder.isHas) {
                freshData();
            }
        }

        if (mCurrentFeatureHolder.isHas) {
            mFilters.clear();
//            mFilters.add(mWindowFilter);
            if (mCurrentFeatureHolder.features[EYELINER] ||
                    mCurrentFeatureHolder.features[EYESHADOW] ||
                    mCurrentFeatureHolder.features[LIPSTICK] ||
                    mCurrentFeatureHolder.features[SMOOTH] ||
                    mCurrentFeatureHolder.features[BLUSH] ||
                    mCurrentFeatureHolder.features[EYELASH]) {

                if (mCurrentFeatureHolder.features[SMOOTH]) {
//                    mFilters.add(clMakeupLiveSmotthFilter);
                }
                if (mCurrentFeatureHolder.features[BLUSH]) {
                    clMakeupLiveBlushFilter.setBlushColor(Color.parseColor("#FFEB5E6D"));
                    if (mBitmapCaches != null) {
                        clMakeupLiveBlushFilter.setBlushBitmap(mBitmapCaches);
                    }
                    mFilters.add(clMakeupLiveBlushFilter);
                }
                if (mCurrentFeatureHolder.features[EYELINER] ||
                        mCurrentFeatureHolder.features[EYESHADOW] ||
                        mCurrentFeatureHolder.features[EYELASH]) {

//                if (i4 == 1) {
//                    mFilters.add(n);
//                } else {
                    mFilters.add(clMakeupLiveEyeFilterLeft);
//                }
//
//                if (i5 == 1) {
//                    mFilters.add(eyelashTextures);
//                } else {
                    mFilters.add(clMakeupLiveEyeFilterRight);
//                }
                }
                if (mCurrentFeatureHolder.features[LIPSTICK]) {
                    clMakeupLiveLipStickFilter.setLipStickColor(Color.parseColor("#FFA7192F"));
                    mFilters.add(clMakeupLiveLipStickFilter);
                }

            }

//            mFilters.add(mWindowFilter);

            int size = mFilters.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, bindingBuffer.get(0));
                    GLES20.glViewport(viewPortBuffer.get(0), viewPortBuffer.get(1), viewPortBuffer.get(2), viewPortBuffer.get(3));
                } else {
                    GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, mFrameBuffers[i]);
                    GLES20.glViewport(0, 0, getOutputWidth(), getOutputHeight());
                }
                if (i == 0) {
                    mFilters.get(i).onDraw(textureId, cubeBuffer, textureBuffer);
                } else {
                    mFilters.get(i).onDraw(mFrameColorTextures[i - 1], cubeBuffer, textureBuffer);
                }
            }
        } else {
            mFilters.clear();
            mFilters.add(mWindowFilter);
            int size = mFilters.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, bindingBuffer.get(0));
                    GLES20.glViewport(viewPortBuffer.get(0), viewPortBuffer.get(1), viewPortBuffer.get(2), viewPortBuffer.get(3));
                } else {
                    GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, mFrameBuffers[i]);
                    GLES20.glViewport(0, 0, getOutputWidth(), getOutputHeight());
                }
                if (i == 0) {
                    mFilters.get(i).onDraw(textureId, cubeBuffer, textureBuffer);
                } else {
                    mFilters.get(i).onDraw(mFrameColorTextures[i - 1], cubeBuffer, textureBuffer);
                }
            }
        }


    }

    public void setBlushBitmaps(Bitmap[] bitmaps) {
        mBitmapCaches = bitmaps;
    }

    public void setEyelinerEnable(boolean enable) {
        clMakeupLiveEyeFilterLeft.setEyeLinerEnable(enable);
        clMakeupLiveEyeFilterRight.setEyeLinerEnable(enable);
    }

    public void setEyelinerModel(byte[] model, int color) {
        clMakeupLiveEyeFilterLeft.setEyeLiner(model, color);
        clMakeupLiveEyeFilterRight.setEyeLiner(model, color);
    }

    public void setEyeLashEnable(boolean enable) {
        clMakeupLiveEyeFilterLeft.setEyeLashEnable(enable);
        clMakeupLiveEyeFilterRight.setEyeLashEnable(enable);
    }

    public void setEyeLashModel(byte[] model, int color) {
        clMakeupLiveEyeFilterLeft.setEyeLash(model, color);
        clMakeupLiveEyeFilterRight.setEyeLash(model, color);
    }

    public void setEyeShadowModel(int[] iArr, byte[] bArr, byte[] bArr2) {
        clMakeupLiveEyeFilterLeft.setEyeShadow(iArr, bArr, bArr2);
        clMakeupLiveEyeFilterRight.setEyeShadow(iArr, bArr, bArr2);
    }


    public void setEyeshadow(boolean enable) {
        clMakeupLiveEyeFilterLeft.setEyeShadowEnable(enable);
        clMakeupLiveEyeFilterRight.setEyeShadowEnable(enable);
    }

    public void initEyePoints(PointF[] points, int w, int h, int w2, int h2, int tag) {
        clMakeupLiveEyeFilterLeft.initPoints(points, w, h, w2, h2, tag);
        clMakeupLiveEyeFilterRight.initPoints(points, w, h, w2, h2, tag);
    }


    private void initImage2Ds() {
        mFrameBuffers = new int[FBO_SIZE];
        mFrameColorTextures = new int[FBO_SIZE];
        int w = getOutputWidth();
        int h = getOutputHeight();
        for (int i = 0; i < FBO_SIZE; i++) {
            GLES20.glGenFramebuffers(1, mFrameBuffers, i);
            GLES20.glGenTextures(1, mFrameColorTextures, i);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mFrameColorTextures[i]);
            OpenGlUtils.useTexParameter();
            GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, w, h, 0, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, null);
            GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, mFrameBuffers[i]);
            GLES20.glFramebufferTexture2D(GLES20.GL_FRAMEBUFFER, GLES20.GL_COLOR_ATTACHMENT0, GLES20.GL_TEXTURE_2D, mFrameColorTextures[i], 0);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);
            GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
        }
    }

    private void release() {
        if (mFrameColorTextures != null) {
            GLES20.glDeleteTextures(mFrameColorTextures.length, mFrameColorTextures, 0);
            mFrameColorTextures = null;
        }
        if (mFrameBuffers != null) {
            GLES20.glDeleteFramebuffers(mFrameBuffers.length, mFrameBuffers, 0);
            mFrameBuffers = null;
        }
    }

    public void setHasData(boolean isHas) {
        synchronized (mSetDataLock) {
            mNewFeatureHolder.isHas = isHas;
        }
    }

    public void handleData(LiveEyeMakeupMetadata[] liveEyeMakeupMetadataArr, LipstickData lipstickData,
                           LiveBlushMakeupdata liveBlushMakeupdata, LiveSmoothMetadata liveSmoothMetadata,
                           LiveFrameInformation liveFrameInformation) {
        synchronized (mDataLock) {
            liveEyeMakeupMetaData[0].Copy(liveEyeMakeupMetadataArr[0]);
            liveEyeMakeupMetaData[1].Copy(liveEyeMakeupMetadataArr[1]);
            mLipstickData.Copy(lipstickData);
            mLiveBlushMakeupData.Copy(liveBlushMakeupdata);
            liveSmoothMetaData.Copy(liveSmoothMetadata);
            liveFrameInfomation.Copy(liveFrameInformation);
            darkestLuma = liveSmoothMetadata.m_environment_darkest_reference_normalized_luma;
            brightestLuma = liveSmoothMetadata.m_environment_brightest_reference_normalized_luma;
        }
    }


    private void freshData() {
        synchronized (mDataLock) {
            if (mCurrentFeatureHolder.features[EYELINER] ||
                    mCurrentFeatureHolder.features[EYESHADOW] ||
                    mCurrentFeatureHolder.features[EYELASH]) {
                clMakeupLiveEyeFilterLeft.freshData(liveEyeMakeupMetaData[0]);
                clMakeupLiveEyeFilterRight.freshData(liveEyeMakeupMetaData[1]);
//                n.inputTemplateTextureCoordinate(liveEyeMakeupMetaData[0]);
//                eyelashTextures.inputTemplateTextureCoordinate(liveEyeMakeupMetaData[1]);
            }
            if (mCurrentFeatureHolder.features[LIPSTICK]) {
                clMakeupLiveLipStickFilter.freshData(mLipstickData);
            }
            if (mCurrentFeatureHolder.features[BLUSH]) {
                clMakeupLiveBlushFilter.freshData(mLiveBlushMakeupData);
            }
            if (mCurrentFeatureHolder.features[SMOOTH]) {
                clMakeupLiveSmotthFilter.freshData(liveSmoothMetaData);
            }
        }
    }
}
