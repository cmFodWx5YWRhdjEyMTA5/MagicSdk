package com.cyberlink.clgpuimage;

import android.graphics.Color;
import android.opengl.GLES20;

import com.het.facesdk.utils.OpenGlUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * 唇彩Filter
 */
public class CLMakeupLiveLipStickFilter extends GPUImageFilter {

    private static final float[] V = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    private int mReflectionTextureLocation;
    private int mBlendWeightTextureId = -1;
    private int mBlendWeightTextureLocation;
    private int mLevelMapTextureId = -1;
    private int mLevelMapTextureLocation;
    private int mInputLipStickTextureCoordLocation;
    private int mCenterXLocation;
    private int mCenterYLocation;
    private int mLipStickWidthLocation;
    private int mLipStickHeightLocation;
    private int mBackgroundImageWidthLocation;
    private int mBackgroundImageHeightLocation;
    private int mLipstickColorLocation;
    private int mGloassContrastScaleLocation;
    private int mGlossContrastShiftLocation;
    private int mForceBrightThresholdLocation;
    private FloatBuffer G = ByteBuffer.allocateDirect(V.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private FloatBuffer H = ByteBuffer.allocateDirect(V.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private float[] mSaveRgb = new float[]{0.0f, 0.0f, 0.0f};
    private float[] T = new float[]{0.0f, 0.0f, 0.0f};
    private int U = 90;
    int mMaskWidth = 0;
    int mMaskHeight = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    int f = 0;
    float m_gloss_contrast_scale = 0.0f;
    float mGlossContrastShift = 0.0f;
    float ForceBrightThreshold = 0.0f;
    byte[] mMaskBytes = null;
    byte[] mReflectBytes;
    byte[] m_blend_weight = null;
    byte[] m_level_map = null;
    ByteBuffer mMaskBuffer = null;
    ByteBuffer mReflectBuffer = null;
    ByteBuffer mBlendWeightBuffer = null;
    ByteBuffer mLevelMapBuffer = null;
    public float r = 0.0f;
    public float s = 1.0f;
    int mRotation = 0;
    boolean mIsFlipped = false;
    private final int v = 256;
    private final int w = 1;
    private int mLipStickTextureId = -1;
    private int mLipStickTextureLocation;
    private int mReflectionTextureId = -1;


    public CLMakeupLiveLipStickFilter() {
        super(OpenGlUtils.file2Glsl("face/mouth.vert"),
                OpenGlUtils.file2Glsl("face/mouth.frag"));
    }

    public static enum BlendMode {
        THICK,
        BRIGHT,
        GLOSS
    }

    public static class LipStickProfile {
        public BlendMode blend_mode;
        public int color;
        public int level_default;
        public int level_max;

        public LipStickProfile(BlendMode blendMode, int color, int level_max, int level_default) {
            this.blend_mode = blendMode;
            this.color = color;
            this.level_max = level_max;
            this.level_default = level_default;
        }
    }

    public static class LipstickData {
        public int m_background_image_height;
        public int m_background_image_width;
        public byte[] m_blend_weight = new byte[256];
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        public int m_force_bright_threshold;
        public float m_gloss_contrast_scale;
        public int m_gloss_contrast_shift;
        public boolean m_is_flipped;
        public byte[] m_level_map = new byte[256];
        public int m_mask_height;
        public int m_mask_width;
        public byte[] m_mouth_mask_data;
        public byte[] m_reflection_data;
        public int m_roi_height;
        public int m_roi_width;
        public int m_roi_x;
        public int m_roi_y;
        public int m_rotation;

        public void AllocByteArray(int i, int i2) {
            if (this.m_mask_width != i || this.m_mask_height != i2) {
                this.m_mask_width = i;
                this.m_mask_height = i2;
                this.m_mouth_mask_data = new byte[(i * i2)];
                this.m_reflection_data = new byte[(i * i2)];
            }
        }

        public void Copy(LipstickData lipstickData) {
            if (!(lipstickData.m_mask_width == 0 || lipstickData.m_mask_height == 0)) {
                this.m_mouth_mask_data = (byte[]) lipstickData.m_mouth_mask_data.clone();
                this.m_reflection_data = (byte[]) lipstickData.m_reflection_data.clone();
            }
            this.m_mask_width = lipstickData.m_mask_width;
            this.m_mask_height = lipstickData.m_mask_height;
            this.m_roi_x = lipstickData.m_roi_x;
            this.m_roi_y = lipstickData.m_roi_y;
            this.m_roi_width = lipstickData.m_roi_width;
            this.m_roi_height = lipstickData.m_roi_height;
            this.m_background_image_width = lipstickData.m_background_image_width;
            this.m_background_image_height = lipstickData.m_background_image_height;
            this.m_gloss_contrast_scale = lipstickData.m_gloss_contrast_scale;
            this.m_gloss_contrast_shift = lipstickData.m_gloss_contrast_shift;
            this.m_force_bright_threshold = lipstickData.m_force_bright_threshold;
            this.m_blend_weight = (byte[]) lipstickData.m_blend_weight.clone();
            this.m_level_map = (byte[]) lipstickData.m_level_map.clone();
            this.m_environment_darkest_reference_normalized_luma = lipstickData.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = lipstickData.m_environment_brightest_reference_normalized_luma;
            this.m_rotation = lipstickData.m_rotation;
            this.m_is_flipped = lipstickData.m_is_flipped;
        }
    }

    @Override
    public void onInit() {
        super.onInit();

        mInputLipStickTextureCoordLocation = GLES20.glGetAttribLocation(getProgram(), "input_lipstick_texture_coordinate");
        mLipStickTextureLocation = GLES20.glGetUniformLocation(getProgram(), "lipstick_texture");
        mReflectionTextureLocation = GLES20.glGetUniformLocation(getProgram(), "reflection_texture");
        mBlendWeightTextureLocation = GLES20.glGetUniformLocation(getProgram(), "blend_weight_texture");
        mLevelMapTextureLocation = GLES20.glGetUniformLocation(getProgram(), "level_map_texture");
        mCenterXLocation = GLES20.glGetUniformLocation(getProgram(), "center_x");
        mCenterYLocation = GLES20.glGetUniformLocation(getProgram(), "center_y");
        mLipStickWidthLocation = GLES20.glGetUniformLocation(getProgram(), "lipstick_width");
        mLipStickHeightLocation = GLES20.glGetUniformLocation(getProgram(), "lipstick_height");
        mBackgroundImageWidthLocation = GLES20.glGetUniformLocation(getProgram(), "background_image_width");
        mBackgroundImageHeightLocation = GLES20.glGetUniformLocation(getProgram(), "background_image_height");
        mLipstickColorLocation = GLES20.glGetUniformLocation(getProgram(), "lipstick_color");
        mGloassContrastScaleLocation = GLES20.glGetUniformLocation(getProgram(), "gloss_contrast_scale");
        mGlossContrastShiftLocation = GLES20.glGetUniformLocation(getProgram(), "gloss_contrast_shift");
        mForceBrightThresholdLocation = GLES20.glGetUniformLocation(getProgram(), "force_bright_threshold");

        int[] textures = new int[4];
        GLES20.glGenTextures(4, textures, 0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textures[0]);
        OpenGlUtils.useTexParameter();
        this.mLipStickTextureId = textures[0];
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textures[1]);
        OpenGlUtils.useTexParameter();
        this.mReflectionTextureId = textures[1];
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textures[2]);
        OpenGlUtils.useTexParameter();
        this.mBlendWeightTextureId = textures[2];
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textures[3]);
        OpenGlUtils.useTexParameter();
        this.mLevelMapTextureId = textures[3];
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        GLES20.glDeleteTextures(1, new int[]{this.mLipStickTextureId}, 0);
        this.mLipStickTextureId = -1;
        GLES20.glDeleteTextures(1, new int[]{this.mReflectionTextureId}, 0);
        this.mReflectionTextureId = -1;
        GLES20.glDeleteTextures(1, new int[]{this.mBlendWeightTextureId}, 0);
        this.mBlendWeightTextureId = -1;
        GLES20.glDeleteTextures(1, new int[]{this.mLevelMapTextureId}, 0);
        this.mLevelMapTextureId = -1;
    }

    public void freshData(LipstickData lipstickData) {
        this.mMaskBytes = lipstickData.m_mouth_mask_data;
        this.mReflectBytes = lipstickData.m_reflection_data;
        this.m_blend_weight = lipstickData.m_blend_weight;
        this.m_level_map = lipstickData.m_level_map;
        setUp(lipstickData.m_mask_width, lipstickData.m_mask_height, lipstickData.m_roi_x, lipstickData.m_roi_y, lipstickData.m_roi_width, lipstickData.m_roi_height, lipstickData.m_background_image_width, lipstickData.m_background_image_height);
        this.m_gloss_contrast_scale = lipstickData.m_gloss_contrast_scale;
        this.mGlossContrastShift = ((float) lipstickData.m_gloss_contrast_shift) / 255.0f;
        this.ForceBrightThreshold = ((float) lipstickData.m_force_bright_threshold) / 255.0f;
        setFloat(this.mGloassContrastScaleLocation, this.m_gloss_contrast_scale);
        setFloat(this.mGlossContrastShiftLocation, this.mGlossContrastShift);
        setFloat(this.mForceBrightThresholdLocation, this.ForceBrightThreshold);
        this.mMaskBuffer = ByteBuffer.allocate(mMaskWidth * mMaskHeight);
        this.mMaskBuffer.put(this.mMaskBytes, 0, mMaskWidth * mMaskHeight);
        this.mMaskBuffer.position(0);
        this.mReflectBuffer = ByteBuffer.allocate(mMaskWidth * mMaskHeight);
        this.mReflectBuffer.put(this.mReflectBytes, 0, mMaskWidth * mMaskHeight);
        this.mReflectBuffer.position(0);
        this.mBlendWeightBuffer = ByteBuffer.allocate(256);
        this.mBlendWeightBuffer.put(this.m_blend_weight, 0, 256);
        this.mBlendWeightBuffer.position(0);
        this.mLevelMapBuffer = ByteBuffer.allocate(256);
        this.mLevelMapBuffer.put(this.m_level_map, 0, 256);
        this.mLevelMapBuffer.position(0);
        this.mRotation = lipstickData.m_rotation;
        this.mIsFlipped = lipstickData.m_is_flipped;
        this.r = lipstickData.m_environment_darkest_reference_normalized_luma;
        this.s = lipstickData.m_environment_brightest_reference_normalized_luma;
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mLipStickTextureId);
                GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_LUMINANCE, mMaskWidth, mMaskHeight, 0, GLES20.GL_LUMINANCE, 5121, mMaskBuffer);
                GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mReflectionTextureId);
                GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_LUMINANCE, mMaskWidth, mMaskHeight, 0, GLES20.GL_LUMINANCE, 5121, mReflectBuffer);
                GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mBlendWeightTextureId);
                GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_LUMINANCE, 256, 1, 0, GLES20.GL_LUMINANCE, 5121, mBlendWeightBuffer);
                GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mLevelMapTextureId);
                GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_LUMINANCE, 256, 1, 0, GLES20.GL_LUMINANCE, 5121, mLevelMapBuffer);
            }
        });
    }

    public void a(int i) {
        this.mSaveRgb[0] = ((float) Color.red(i)) / 255.0f;
        this.mSaveRgb[1] = ((float) Color.green(i)) / 255.0f;
        this.mSaveRgb[2] = ((float) Color.blue(i)) / 255.0f;
    }

    private void setUp(int maskWidth, int maskHeight, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mMaskWidth = maskWidth;
        this.mMaskHeight = maskHeight;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        setFloat(this.mLipStickWidthLocation, (float) this.e);
        setFloat(this.mLipStickHeightLocation, (float) this.f);
        if (this.mRotation == 0 || this.mRotation == 180) {
            setFloat(this.mBackgroundImageWidthLocation, (float) i7);
            setFloat(this.mBackgroundImageHeightLocation, (float) i8);
            setFloat(this.mCenterXLocation, (((float) this.c) + (((float) this.e) * 0.5f)) / ((float) i7));
            setFloat(this.mCenterYLocation, (((float) this.d) + (((float) this.f) * 0.5f)) / ((float) i8));
            return;
        }
        setFloat(this.mBackgroundImageWidthLocation, (float) i8);
        setFloat(this.mBackgroundImageHeightLocation, (float) i7);
        setFloat(this.mCenterXLocation, (((float) this.c) + (((float) this.e) * 0.5f)) / ((float) i8));
        setFloat(this.mCenterYLocation, (((float) this.d) + (((float) this.f) * 0.5f)) / ((float) i7));
    }

    @Override
    public void onDrawArraysPre() {

        this.G.clear();
        this.G.put(a(V, this.mRotation));
        this.G.position(0);
        this.H.clear();
        this.H.put(a(V, this.mRotation));
        this.H.position(0);
        GLES20.glVertexAttribPointer(this.mInputLipStickTextureCoordLocation, 2, 5126, false, 0, this.G);
        GLES20.glEnableVertexAttribArray(this.mInputLipStickTextureCoordLocation);
        float f = this.r;
        float f2 = this.s;
        this.T[0] = ((f2 - f) * this.mSaveRgb[0]) + f;
        this.T[1] = ((f2 - f) * this.mSaveRgb[1]) + f;
        this.T[2] = f + ((f2 - f) * this.mSaveRgb[2]);
        GLES20.glUniform3fv(this.mLipstickColorLocation, 1, FloatBuffer.wrap(this.T));
        if (this.mLipStickTextureId != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mLipStickTextureId);
            GLES20.glUniform1i(this.mLipStickTextureLocation, 3);
        }
        if (this.mReflectionTextureId != -1) {
            GLES20.glActiveTexture(33990);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mReflectionTextureId);
            GLES20.glUniform1i(this.mReflectionTextureLocation, 6);
        }
        if (this.mBlendWeightTextureId != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mBlendWeightTextureId);
            GLES20.glUniform1i(this.mBlendWeightTextureLocation, 4);
        }
        if (this.mLevelMapTextureId != -1) {
            GLES20.glActiveTexture(33989);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mLevelMapTextureId);
            GLES20.glUniform1i(this.mLevelMapTextureLocation, 5);
        }
    }

    public void b(int i) {
        this.U = i;
    }

    protected float[] a(float[] fArr, int i) {
        if (i == (this.U + 270) % 360) {
            return new float[]{fArr[4], fArr[5], fArr[0], fArr[1], fArr[6], fArr[7], fArr[2], fArr[3]};
        } else if (i == (this.U + 180) % 360) {
            return new float[]{fArr[6], fArr[7], fArr[4], fArr[5], fArr[2], fArr[3], fArr[0], fArr[1]};
        } else if (i == (this.U + 90) % 360) {
            return new float[]{fArr[2], fArr[3], fArr[6], fArr[7], fArr[0], fArr[1], fArr[4], fArr[5]};
        } else {
            return new float[]{fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]};
        }
    }
}
