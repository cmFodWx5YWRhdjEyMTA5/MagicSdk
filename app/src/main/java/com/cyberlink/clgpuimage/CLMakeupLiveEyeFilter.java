package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;

import com.het.facesdk.utils.OpenGlUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class CLMakeupLiveEyeFilter extends GPUImageFilter {
    protected static final float[] au = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    protected int[] A;
    protected int[] bright_texture;
    protected ByteBuffer[] C;
    protected int[] D;
    protected int[] glitter_texture;
    protected Rect shadowRect;
    protected Rect eyeLinerRect;
    protected Rect eyeLashRect;
    protected Rect shadowRectN;
    protected Rect eyeLinerRectN;
    protected Rect eyeLashRectN;
    protected int frame_to_template_y_remapping_factor;
    protected int target_eye_lower_lid_luma;
    protected int level_orient_cos_sin;
    protected int oriented_upper_lid_center;
    protected int oriented_lower_lid_center;
    protected int similarity_origin;
    protected int similarity_shift;
    protected int similarity_scale;
    protected int top_spline_transform_src_dst_center;
    protected int top_left_spline_transform_src_dst_aligned_parabolic_coeff;
    protected int top_right_spline_transform_src_dst_aligned_parabolic_coeff;
    protected int bottom_spline_transform_src_dst_center;
    protected int bottom_left_spline_transform_src_dst_aligned_parabolic_coeff;
    protected int bottom_right_spline_transform_src_dst_aligned_parabolic_coeff;
    protected int environment_luma;
    protected int inputTemplateTextureCoordinate;
    private Object drawShadowLock;
    private boolean needToDrawShadow;
    private Object needDrawEyeLinerLock;
    private boolean needDrawEyeLiner;
    private Object aI;
    private boolean mHasEyeLash;
    private int aK;
    protected boolean mIsEyeShadowEnable;
    protected boolean mIsEyeLinerEnable;
    protected boolean mIsEyelashEnable;
    protected int mIsEnableEyeShadowLocation;
    protected int mIsEnableEyeLinerLocation;
    protected int mIsEnableEyelashLocation;
    protected float ag;
    protected float ah;
    protected int shimmer_model_scale;
    protected int environment_brightest;
    protected int environment_compress;
    protected Object al;
    LiveEyeMakeupMetadata eyeMakeupData;
    protected boolean an;
    protected int left_right_flip;
    protected float[] centerPointControlFactors;
    protected int roi;
    protected int eyeshadow_multiply_correction;
    protected int analyzing_frame_width_height_in_pixel;
    protected int upper_lid_eyelash_y_scale_adjuster;
    protected FloatBuffer b;
    protected Bitmap eyeShadow;
    protected int eyeshadowTextures;
    protected int eyeshadow_texture;
    protected int eyeliner_template_color;
    protected float[] g;
    protected float[] h;
    protected int eyeLinerTextures;
    protected int eyeliner_texture;
    protected ByteBuffer k;
    protected int eyelash_template_color;
    protected float[] m;
    protected float[] n;
    protected int eyelashTextures;
    protected int eyelash_texture;
    protected ByteBuffer q;
    protected boolean r;
    protected PointF[] eyeLinerLashPointInBitmapFacts;
    protected PointF[] eyeInitPoints;
    protected int eyeLinerLashBitmapWidth;//眼线,睫毛宽
    protected int eyeLinerLashBitmapHeight;//眼线,睫毛高
    protected int w;//眼影宽
    protected int x;//眼影高
    protected int y;
    protected ByteBuffer[] z;

    public static class LiveEyeMakeupMetadata {
        int m_analyzing_frame_height;
        int m_analyzing_frame_width;
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        PointF[] m_eye_points = new PointF[4];
        public boolean m_is_flipped;
        public EyeMode m_mode;
        PointF[] m_oriented_eye_centers;
        PointF[] m_oriented_eye_points;
        float[] m_parabolic_polar_transform_bottom_left_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_left_dst_center;
        float[] m_parabolic_polar_transform_bottom_left_src_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_left_src_center;
        float[] m_parabolic_polar_transform_bottom_right_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_right_dst_center;
        float[] m_parabolic_polar_transform_bottom_right_src_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_right_src_center;
        float[] m_parabolic_polar_transform_top_left_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_top_left_dst_center;
        float[] m_parabolic_polar_transform_top_left_src_aligned_coeff;
        PointF m_parabolic_polar_transform_top_left_src_center;
        float[] m_parabolic_polar_transform_top_right_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_top_right_dst_center;
        float[] m_parabolic_polar_transform_top_right_src_aligned_coeff;
        PointF m_parabolic_polar_transform_top_right_src_center;
        public float m_ratio_of_actual_lower_lid_height_to_limited_height;
        public float m_ratio_of_actual_upper_lid_height_to_limited_height;
        public int m_rotation;
        float m_target_eye_lower_lid_luma;
        float m_target_level_orientation_cos;
        float m_target_level_orientation_sin;

        public enum EyeMode {
            NORMAL,
            BLINK
        }

        public LiveEyeMakeupMetadata() {
            int i;
            int i2 = 0;
            for (i = 0; i < 4; i++) {
                this.m_eye_points[i] = new PointF();
            }
            this.m_oriented_eye_points = new PointF[4];
            for (i = 0; i < 4; i++) {
                this.m_oriented_eye_points[i] = new PointF();
            }
            this.m_oriented_eye_centers = new PointF[2];
            while (i2 < 2) {
                this.m_oriented_eye_centers[i2] = new PointF();
                i2++;
            }
            this.m_parabolic_polar_transform_top_left_src_center = new PointF();
            this.m_parabolic_polar_transform_top_left_dst_center = new PointF();
            this.m_parabolic_polar_transform_top_left_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_top_left_dst_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_top_right_src_center = new PointF();
            this.m_parabolic_polar_transform_top_right_dst_center = new PointF();
            this.m_parabolic_polar_transform_top_right_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_top_right_dst_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_left_src_center = new PointF();
            this.m_parabolic_polar_transform_bottom_left_dst_center = new PointF();
            this.m_parabolic_polar_transform_bottom_left_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_right_src_center = new PointF();
            this.m_parabolic_polar_transform_bottom_right_dst_center = new PointF();
            this.m_parabolic_polar_transform_bottom_right_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff = new float[2];
        }

        public void Copy(LiveEyeMakeupMetadata liveEyeMakeupMetadata) {
            int i;
            int i2 = 0;
            this.m_target_eye_lower_lid_luma = liveEyeMakeupMetadata.m_target_eye_lower_lid_luma;
            this.m_analyzing_frame_width = liveEyeMakeupMetadata.m_analyzing_frame_width;
            this.m_analyzing_frame_height = liveEyeMakeupMetadata.m_analyzing_frame_height;
            this.m_target_level_orientation_cos = liveEyeMakeupMetadata.m_target_level_orientation_cos;
            this.m_target_level_orientation_sin = liveEyeMakeupMetadata.m_target_level_orientation_sin;
            for (i = 0; i < 4; i++) {
                this.m_eye_points[i].x = liveEyeMakeupMetadata.m_eye_points[i].x;
                this.m_eye_points[i].y = liveEyeMakeupMetadata.m_eye_points[i].y;
                this.m_oriented_eye_points[i].x = liveEyeMakeupMetadata.m_oriented_eye_points[i].x;
                this.m_oriented_eye_points[i].y = liveEyeMakeupMetadata.m_oriented_eye_points[i].y;
            }
            for (i = 0; i < 2; i++) {
                this.m_oriented_eye_centers[i].x = liveEyeMakeupMetadata.m_oriented_eye_centers[i].x;
                this.m_oriented_eye_centers[i].y = liveEyeMakeupMetadata.m_oriented_eye_centers[i].y;
            }
            this.m_parabolic_polar_transform_top_left_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_src_center.x;
            this.m_parabolic_polar_transform_top_left_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_src_center.y;
            this.m_parabolic_polar_transform_top_left_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_dst_center.x;
            this.m_parabolic_polar_transform_top_left_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_dst_center.y;
            for (i = 0; i < 2; i++) {
                this.m_parabolic_polar_transform_top_left_src_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_src_aligned_coeff[i];
                this.m_parabolic_polar_transform_top_left_dst_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_dst_aligned_coeff[i];
            }
            this.m_parabolic_polar_transform_top_right_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_src_center.x;
            this.m_parabolic_polar_transform_top_right_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_src_center.y;
            this.m_parabolic_polar_transform_top_right_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_dst_center.x;
            this.m_parabolic_polar_transform_top_right_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_dst_center.y;
            for (i = 0; i < 2; i++) {
                this.m_parabolic_polar_transform_top_right_src_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_src_aligned_coeff[i];
                this.m_parabolic_polar_transform_top_right_dst_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_dst_aligned_coeff[i];
            }
            this.m_parabolic_polar_transform_bottom_left_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_src_center.x;
            this.m_parabolic_polar_transform_bottom_left_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_src_center.y;
            this.m_parabolic_polar_transform_bottom_left_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_dst_center.x;
            this.m_parabolic_polar_transform_bottom_left_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_dst_center.y;
            for (i = 0; i < 2; i++) {
                this.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[i];
                this.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[i];
            }
            this.m_parabolic_polar_transform_bottom_right_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_src_center.x;
            this.m_parabolic_polar_transform_bottom_right_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_src_center.y;
            this.m_parabolic_polar_transform_bottom_right_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_dst_center.x;
            this.m_parabolic_polar_transform_bottom_right_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_dst_center.y;
            while (i2 < 2) {
                this.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[i2] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[i2];
                this.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[i2] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[i2];
                i2++;
            }
            this.m_environment_darkest_reference_normalized_luma = liveEyeMakeupMetadata.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = liveEyeMakeupMetadata.m_environment_brightest_reference_normalized_luma;
            this.m_rotation = liveEyeMakeupMetadata.m_rotation;
            this.m_is_flipped = liveEyeMakeupMetadata.m_is_flipped;
            this.m_mode = liveEyeMakeupMetadata.m_mode;
            this.m_ratio_of_actual_upper_lid_height_to_limited_height = liveEyeMakeupMetadata.m_ratio_of_actual_upper_lid_height_to_limited_height;
            this.m_ratio_of_actual_lower_lid_height_to_limited_height = liveEyeMakeupMetadata.m_ratio_of_actual_lower_lid_height_to_limited_height;
        }
    }

    public CLMakeupLiveEyeFilter(boolean z) {
        super(OpenGlUtils.file2Glsl("face/eye.vert"),
                OpenGlUtils.file2Glsl("face/eye.frag"));
        int i = 0;
        this.eyeshadowTextures = -1;
        this.g = new float[]{0.0f, 0.0f, 0.0f};
        this.h = new float[]{0.0f, 0.0f, 0.0f};
        this.eyeLinerTextures = -1;
        this.m = new float[]{0.0f, 0.0f, 0.0f};
        this.n = new float[]{0.0f, 0.0f, 0.0f};
        this.eyelashTextures = -1;
        this.r = false;
        this.eyeLinerLashPointInBitmapFacts = new PointF[4];
        this.eyeInitPoints = new PointF[4];
        this.z = new ByteBuffer[2];
        this.A = new int[2];
        this.bright_texture = new int[2];
        this.C = new ByteBuffer[2];
        this.D = new int[2];
        this.glitter_texture = new int[2];
        this.shadowRect = new Rect();
        this.eyeLinerRect = new Rect();
        this.eyeLashRect = new Rect();
        this.shadowRectN = new Rect();
        this.eyeLinerRectN = new Rect();
        this.eyeLashRectN = new Rect();
        this.mIsEyeShadowEnable = false;
        this.mIsEyeLinerEnable = false;
        this.mIsEyelashEnable = false;
        this.al = new Object();
        this.eyeMakeupData = new LiveEyeMakeupMetadata();
        this.an = true;
        this.centerPointControlFactors = new float[4];
        this.drawShadowLock = new Object();
        this.needToDrawShadow = false;
        this.needDrawEyeLinerLock = new Object();
        this.needDrawEyeLiner = false;
        this.aI = new Object();
        this.mHasEyeLash = false;
        this.aK = 90;
        this.b = ByteBuffer.allocateDirect(au.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i2 = 0; i2 < 4; i2++) {
            this.eyeLinerLashPointInBitmapFacts[i2] = new PointF();
            this.eyeInitPoints[i2] = new PointF();
        }
        this.an = z;
        while (i < 2) {
            this.A[i] = -1;
            this.D[i] = -1;
            i++;
        }
    }

    protected CLMakeupLiveEyeFilter(boolean z, String str, String str2) {
        super(str, str2);
        int i = 0;
        this.eyeshadowTextures = -1;
        this.g = new float[]{0.0f, 0.0f, 0.0f};
        this.h = new float[]{0.0f, 0.0f, 0.0f};
        this.eyeLinerTextures = -1;
        this.m = new float[]{0.0f, 0.0f, 0.0f};
        this.n = new float[]{0.0f, 0.0f, 0.0f};
        this.eyelashTextures = -1;
        this.r = false;
        this.eyeLinerLashPointInBitmapFacts = new PointF[4];
        this.eyeInitPoints = new PointF[4];
        this.z = new ByteBuffer[2];
        this.A = new int[2];
        this.bright_texture = new int[2];
        this.C = new ByteBuffer[2];
        this.D = new int[2];
        this.glitter_texture = new int[2];
        this.shadowRect = new Rect();
        this.eyeLinerRect = new Rect();
        this.eyeLashRect = new Rect();
        this.shadowRectN = new Rect();
        this.eyeLinerRectN = new Rect();
        this.eyeLashRectN = new Rect();
        this.mIsEyeShadowEnable = false;
        this.mIsEyeLinerEnable = false;
        this.mIsEyelashEnable = false;
        this.al = new Object();
        this.eyeMakeupData = new LiveEyeMakeupMetadata();
        this.an = true;
        this.centerPointControlFactors = new float[4];
        this.drawShadowLock = new Object();
        this.needToDrawShadow = false;
        this.needDrawEyeLinerLock = new Object();
        this.needDrawEyeLiner = false;
        this.aI = new Object();
        this.mHasEyeLash = false;
        this.aK = 90;
        this.b = ByteBuffer.allocateDirect(au.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i2 = 0; i2 < 4; i2++) {
            this.eyeLinerLashPointInBitmapFacts[i2] = new PointF();
            this.eyeInitPoints[i2] = new PointF();
        }
        this.an = z;
        while (i < 2) {
            this.A[i] = -1;
            this.D[i] = -1;
            i++;
        }
    }

    public void f() {
//        inputTemplateTextureCoordinate(b.inputTemplateTextureCoordinate(eyelash_template_color.inputTemplateTextureCoordinate), b.inputTemplateTextureCoordinate(k.inputTemplateTextureCoordinate));
    }

    @Override
    public void onInit() {
        super.onInit();
        this.inputTemplateTextureCoordinate = GLES20.glGetAttribLocation(getProgram(), "inputTemplateTextureCoordinate");
        this.eyeshadow_texture = GLES20.glGetUniformLocation(getProgram(), "eyeshadow_texture");
        this.eyeliner_texture = GLES20.glGetUniformLocation(getProgram(), "eyeliner_texture");
        this.eyelash_texture = GLES20.glGetUniformLocation(getProgram(), "eyelash_texture");
        this.left_right_flip = GLES20.glGetUniformLocation(getProgram(), "left_right_flip");
        this.eyeliner_template_color = GLES20.glGetUniformLocation(getProgram(), "eyeliner_template_color");
        this.eyelash_template_color = GLES20.glGetUniformLocation(getProgram(), "eyelash_template_color");
        this.frame_to_template_y_remapping_factor = GLES20.glGetUniformLocation(getProgram(), "frame_to_template_y_remapping_factor");
        this.target_eye_lower_lid_luma = GLES20.glGetUniformLocation(getProgram(), "target_eye_lower_lid_luma");
        this.level_orient_cos_sin = GLES20.glGetUniformLocation(getProgram(), "level_orient_cos_sin");
        this.oriented_upper_lid_center = GLES20.glGetUniformLocation(getProgram(), "oriented_upper_lid_center");
        this.oriented_lower_lid_center = GLES20.glGetUniformLocation(getProgram(), "oriented_lower_lid_center");
        this.similarity_origin = GLES20.glGetUniformLocation(getProgram(), "similarity_origin");
        this.similarity_shift = GLES20.glGetUniformLocation(getProgram(), "similarity_shift");
        this.similarity_scale = GLES20.glGetUniformLocation(getProgram(), "similarity_scale");
        this.top_spline_transform_src_dst_center = GLES20.glGetUniformLocation(getProgram(), "top_spline_transform_src_dst_center");
        this.top_left_spline_transform_src_dst_aligned_parabolic_coeff = GLES20.glGetUniformLocation(getProgram(), "top_left_spline_transform_src_dst_aligned_parabolic_coeff");
        this.top_right_spline_transform_src_dst_aligned_parabolic_coeff = GLES20.glGetUniformLocation(getProgram(), "top_right_spline_transform_src_dst_aligned_parabolic_coeff");
        this.bottom_spline_transform_src_dst_center = GLES20.glGetUniformLocation(getProgram(), "bottom_spline_transform_src_dst_center");
        this.bottom_left_spline_transform_src_dst_aligned_parabolic_coeff = GLES20.glGetUniformLocation(getProgram(), "bottom_left_spline_transform_src_dst_aligned_parabolic_coeff");
        this.bottom_right_spline_transform_src_dst_aligned_parabolic_coeff = GLES20.glGetUniformLocation(getProgram(), "bottom_right_spline_transform_src_dst_aligned_parabolic_coeff");
        this.mIsEnableEyeShadowLocation = GLES20.glGetUniformLocation(getProgram(), "enable_eyeshadow");
        this.mIsEnableEyeLinerLocation = GLES20.glGetUniformLocation(getProgram(), "enable_eyeliner");
        this.mIsEnableEyelashLocation = GLES20.glGetUniformLocation(getProgram(), "enable_eyelash");
        setEyeShadowEnable(this.mIsEyeShadowEnable);
        setEyeLinerEnable(this.mIsEyeLinerEnable);
        setEyeLashEnable(this.mIsEyelashEnable);
        this.roi = GLES20.glGetUniformLocation(getProgram(), "roi");
        this.eyeshadow_multiply_correction = GLES20.glGetUniformLocation(getProgram(), "eyeshadow_multiply_correction");
        this.analyzing_frame_width_height_in_pixel = GLES20.glGetUniformLocation(getProgram(), "analyzing_frame_width_height_in_pixel");
        this.environment_luma = GLES20.glGetUniformLocation(getProgram(), "environment_luma");
        this.upper_lid_eyelash_y_scale_adjuster = GLES20.glGetUniformLocation(getProgram(), "upper_lid_eyelash_y_scale_adjuster");
        this.shimmer_model_scale = GLES20.glGetUniformLocation(getProgram(), "shimmer_model_scale");
        this.environment_brightest = GLES20.glGetUniformLocation(getProgram(), "environment_brightest");
        this.environment_compress = GLES20.glGetUniformLocation(getProgram(), "environment_compress");
        this.bright_texture[0] = GLES20.glGetUniformLocation(getProgram(), "bright_texture");
        this.glitter_texture[0] = GLES20.glGetUniformLocation(getProgram(), "glitter0_texture");
        this.bright_texture[1] = GLES20.glGetUniformLocation(getProgram(), "bright1_texture");
        this.glitter_texture[1] = GLES20.glGetUniformLocation(getProgram(), "glitter1_texture");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.eyeshadowTextures != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.eyeshadowTextures}, 0);
            this.eyeshadowTextures = -1;
        }
        if (this.eyeLinerTextures != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.eyeLinerTextures}, 0);
            this.eyeLinerTextures = -1;
        }
        if (this.eyelashTextures != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.eyelashTextures}, 0);
            this.eyelashTextures = -1;
        }
        for (int i = 0; i < 2; i++) {
            if (this.A[i] != -1) {
                GLES20.glDeleteTextures(1, new int[]{this.A[i]}, 0);
                this.A[i] = -1;
            }
            if (this.D[i] != -1) {
                GLES20.glDeleteTextures(1, new int[]{this.D[i]}, 0);
                this.D[i] = -1;
            }
        }
    }

    @Override
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
    }

    //小心了..这个
    @Override
    public void onDrawArraysPre() {
        int i;
        float f;
        int i2 = 33985;
        if (this.eyeshadowTextures != -1) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.eyeshadowTextures);
            GLES20.glUniform1i(this.eyeshadow_texture, 1);
            i2 = 33986;
            i = 2;
        } else {
            i = 1;
        }
        int i3 = i2 + 1;
        if (this.eyeLinerTextures != -1) {
            GLES20.glActiveTexture(i2);
            GLES20.glBindTexture(3553, this.eyeLinerTextures);
            i2 = i + 1;
            GLES20.glUniform1i(this.eyeliner_texture, i);
            i = i2;
            i2 = i3;
        }
        if (this.eyelashTextures != -1) {
            i3 = i2 + 1;
            GLES20.glActiveTexture(i2);
            GLES20.glBindTexture(3553, this.eyelashTextures);
            i2 = i + 1;
            GLES20.glUniform1i(this.eyelash_texture, i);
            i = i2;
            i2 = i3;
        }
        int i4 = 0;
        int i5 = i;
        i = i2;
        i2 = i5;
        while (i4 < 2) {
            if (this.A[i4] != -1) {
                i3 = i + 1;
                GLES20.glActiveTexture(i);
                GLES20.glBindTexture(3553, this.A[i4]);
                i = i2 + 1;
                GLES20.glUniform1i(this.bright_texture[i4], i2);
                i2 = i3;
            } else {
                i5 = i2;
                i2 = i;
                i = i5;
            }
            if (this.D[i4] != -1) {
                i3 = i2 + 1;
                GLES20.glActiveTexture(i2);
                GLES20.glBindTexture(3553, this.D[i4]);
                i2 = i + 1;
                GLES20.glUniform1i(this.glitter_texture[i4], i);
                i = i2;
                i2 = i3;
            }
            i4++;
            i5 = i;
            i = i2;
            i2 = i5;
        }
        synchronized (this.al) {
            f = this.eyeMakeupData.m_environment_darkest_reference_normalized_luma;
            float f2 = this.eyeMakeupData.m_environment_brightest_reference_normalized_luma;
            this.ag = f2;
            this.ah = f2 - f;
            this.h[0] = ((f2 - f) * this.g[0]) + f;
            this.h[1] = ((f2 - f) * this.g[1]) + f;
            this.h[2] = ((f2 - f) * this.g[2]) + f;
            this.n[0] = ((f2 - f) * this.m[0]) + f;
            this.n[1] = ((f2 - f) * this.m[1]) + f;
            this.n[2] = f + ((f2 - f) * this.m[2]);
        }
        GLES20.glUniform3fv(this.eyeliner_template_color, 1, FloatBuffer.wrap(this.h));
        GLES20.glUniform3fv(this.eyelash_template_color, 1, FloatBuffer.wrap(this.n));
        GLES20.glUniform1f(this.environment_brightest, this.ag);
        GLES20.glUniform1f(this.environment_compress, this.ah);
        int i6 = this.left_right_flip;
        if (this.an) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        GLES20.glUniform1f(i6, f);
        synchronized (this.al) {
            this.b.clear();
            this.b.put(a(au, this.eyeMakeupData.m_rotation));
            this.b.position(0);
            GLES20.glVertexAttribPointer(this.inputTemplateTextureCoordinate, 2, 5126, false, 0, this.b);
            GLES20.glEnableVertexAttribArray(this.inputTemplateTextureCoordinate);
            for (i = 0; i < 4; i++) {
                this.eyeLinerLashPointInBitmapFacts[i].x = this.eyeInitPoints[i].x / ((float) this.eyeLinerLashBitmapWidth);
                this.eyeLinerLashPointInBitmapFacts[i].y = this.eyeInitPoints[i].y / ((float) this.eyeLinerLashBitmapHeight);
            }
            GLES20.glUniform2f(this.analyzing_frame_width_height_in_pixel, (float) this.eyeMakeupData.m_analyzing_frame_width, (float) this.eyeMakeupData.m_analyzing_frame_height);
            if (this.eyeLinerLashBitmapWidth * this.eyeMakeupData.m_analyzing_frame_height <= 0 || this.eyeLinerLashBitmapHeight * this.eyeMakeupData.m_analyzing_frame_width <= 0) {
                f = 1.0f;
            } else {
                f = ((float) (this.eyeLinerLashBitmapHeight * this.eyeMakeupData.m_analyzing_frame_width)) / ((float) (this.eyeLinerLashBitmapWidth * this.eyeMakeupData.m_analyzing_frame_height));
            }
            for (i6 = 0; i6 < 4; i6++) {
                PointF pointF = this.eyeLinerLashPointInBitmapFacts[i6];
                pointF.y *= f;
            }
            GLES20.glUniform1f(this.frame_to_template_y_remapping_factor, 1.0f / f);
            float similarScale = (this.eyeLinerLashPointInBitmapFacts[2].x - this.eyeLinerLashPointInBitmapFacts[0].x) / (this.eyeMakeupData.m_oriented_eye_points[2].x - this.eyeMakeupData.m_oriented_eye_points[0].x);
            GLES20.glUniform1f(this.shimmer_model_scale, Math.max(0.0f, Math.min(1.0f, ((((1.0f / similarScale) * ((float) this.eyeLinerLashBitmapWidth)) / ((float) this.w)) - 0.35f) / 0.3f)));

            //眼线,睫毛,眼影重叠区域
            Rect unionRect = new Rect();
            unionRect.union(this.shadowRect);
            unionRect.union(this.eyeLinerRect);
            unionRect.union(this.eyeLashRect);


            PointF pointF2 = new PointF(this.eyeInitPoints[1].x, this.eyeInitPoints[0].y);
            this.centerPointControlFactors[0] = (pointF2.x - ((float) unionRect.left)) / (pointF2.x - this.eyeInitPoints[0].x);
            this.centerPointControlFactors[1] = (pointF2.y - ((float) unionRect.top)) / (pointF2.y - this.eyeInitPoints[1].y);
            this.centerPointControlFactors[2] = (((float) unionRect.right) - pointF2.x) / (this.eyeInitPoints[2].x - pointF2.x);
            this.centerPointControlFactors[3] = (((float) unionRect.bottom) - pointF2.y) / (this.eyeInitPoints[3].y - pointF2.y);
            GLES20.glUniform4f(this.roi,
                    Math.min( Math.max(this.eyeMakeupData.m_oriented_eye_centers[0].x, this.eyeMakeupData.m_oriented_eye_centers[1].x)
                                    + (this.centerPointControlFactors[0] * (this.eyeMakeupData.m_oriented_eye_points[0].x - Math.max(this.eyeMakeupData.m_oriented_eye_centers[0].x, this.eyeMakeupData.m_oriented_eye_centers[1].x))),
                            this.eyeMakeupData.m_oriented_eye_centers[0].x - ((this.eyeLinerLashPointInBitmapFacts[1].x - (((float) unionRect.left) / ((float) this.eyeLinerLashBitmapWidth))) / similarScale)),
                    Math.max(Math.min(this.eyeMakeupData.m_oriented_eye_centers[0].x, this.eyeMakeupData.m_oriented_eye_centers[1].x) + (this.centerPointControlFactors[2] * (this.eyeMakeupData.m_oriented_eye_points[2].x - Math.min(this.eyeMakeupData.m_oriented_eye_centers[0].x, this.eyeMakeupData.m_oriented_eye_centers[1].x))), this.eyeMakeupData.m_oriented_eye_centers[0].x + ((((float) (unionRect.right / this.eyeLinerLashBitmapWidth)) - this.eyeLinerLashPointInBitmapFacts[1].x) / similarScale)),
                    Math.min(this.eyeMakeupData.m_oriented_eye_centers[0].y + (this.centerPointControlFactors[1] * (this.eyeMakeupData.m_oriented_eye_points[1].y - this.eyeMakeupData.m_oriented_eye_centers[0].y)), this.eyeMakeupData.m_oriented_eye_centers[0].y - ((this.eyeLinerLashPointInBitmapFacts[0].y - (f * (((float) unionRect.top) / ((float) this.eyeLinerLashBitmapHeight)))) / similarScale)),
                    this.eyeMakeupData.m_oriented_eye_points[3].y + (((this.eyeLinerLashPointInBitmapFacts[3].y - this.eyeLinerLashPointInBitmapFacts[0].y) * (this.centerPointControlFactors[3] - 1.0f)) / similarScale)
            );
            GLES20.glUniform1f(this.target_eye_lower_lid_luma, this.eyeMakeupData.m_target_eye_lower_lid_luma);
            GLES20.glUniform1f(this.eyeshadow_multiply_correction, Math.max(1.0f, Math.min(5.0f, (((float) Math.pow((double) Math.max(0.0f, (0.5f - this.eyeMakeupData.m_target_eye_lower_lid_luma) / 0.5f), 0.25d)) + 1.0f) * (0.5f / Math.max(this.eyeMakeupData.m_target_eye_lower_lid_luma, 0.001f)))));
            GLES20.glUniform2f(this.level_orient_cos_sin, this.eyeMakeupData.m_target_level_orientation_cos, this.eyeMakeupData.m_target_level_orientation_sin);
            GLES20.glUniform2f(this.oriented_upper_lid_center, this.eyeMakeupData.m_oriented_eye_centers[0].x, this.eyeMakeupData.m_oriented_eye_centers[0].y);
            GLES20.glUniform2f(this.oriented_lower_lid_center, this.eyeMakeupData.m_oriented_eye_centers[1].x, this.eyeMakeupData.m_oriented_eye_centers[1].y);
            GLES20.glUniform2f(this.similarity_origin, this.eyeMakeupData.m_oriented_eye_points[0].x, this.eyeMakeupData.m_oriented_eye_points[0].y);
            GLES20.glUniform2f(this.similarity_shift, this.eyeLinerLashPointInBitmapFacts[0].x - this.eyeMakeupData.m_oriented_eye_points[0].x, this.eyeLinerLashPointInBitmapFacts[0].y - this.eyeMakeupData.m_oriented_eye_points[0].y);
            GLES20.glUniform1f(this.similarity_scale, similarScale);
            GLES20.glUniform4f(this.top_spline_transform_src_dst_center, this.eyeMakeupData.m_parabolic_polar_transform_top_left_src_center.x, this.eyeMakeupData.m_parabolic_polar_transform_top_left_src_center.y, this.eyeMakeupData.m_parabolic_polar_transform_top_left_dst_center.x, this.eyeMakeupData.m_parabolic_polar_transform_top_left_dst_center.y);
            GLES20.glUniform4f(this.top_left_spline_transform_src_dst_aligned_parabolic_coeff, this.eyeMakeupData.m_parabolic_polar_transform_top_left_src_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_top_left_src_aligned_coeff[1], this.eyeMakeupData.m_parabolic_polar_transform_top_left_dst_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]);
            GLES20.glUniform4f(this.top_right_spline_transform_src_dst_aligned_parabolic_coeff, this.eyeMakeupData.m_parabolic_polar_transform_top_right_src_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_top_right_src_aligned_coeff[1], this.eyeMakeupData.m_parabolic_polar_transform_top_right_dst_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_top_right_dst_aligned_coeff[1]);
            GLES20.glUniform4f(this.bottom_spline_transform_src_dst_center, this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_src_center.x, this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_src_center.y, this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_dst_center.x, this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_dst_center.y);
            GLES20.glUniform4f(this.bottom_left_spline_transform_src_dst_aligned_parabolic_coeff, this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[1], this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[1]);
            GLES20.glUniform4f(this.bottom_right_spline_transform_src_dst_aligned_parabolic_coeff, this.eyeMakeupData.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[1], this.eyeMakeupData.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[0], this.eyeMakeupData.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[1]);
            GLES20.glUniform2f(this.environment_luma, this.eyeMakeupData.m_environment_darkest_reference_normalized_luma, this.eyeMakeupData.m_environment_brightest_reference_normalized_luma);
            GLES20.glUniform1f(this.upper_lid_eyelash_y_scale_adjuster, Math.max(0.2f, Math.min(1.0f, ((this.eyeMakeupData.m_parabolic_polar_transform_top_left_src_aligned_coeff[1] * similarScale) / this.eyeMakeupData.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]) * 1.2f)));
        }
    }

    @Override
    public void runPendingOnDrawTasks() {
        super.runPendingOnDrawTasks();
        drawShadow();
        o();
        n();
    }

    public void setEyeShadowEnable(boolean z) {
        this.mIsEyeShadowEnable = z;
        setInteger(this.mIsEnableEyeShadowLocation, z ? 1 : 0);
    }

    public void setEyeLinerEnable(boolean z) {
        this.mIsEyeLinerEnable = z;
        setInteger(this.mIsEnableEyeLinerLocation, z ? 1 : 0);
    }

    public void setEyeLashEnable(boolean z) {
        this.mIsEyelashEnable = z;
        setInteger(this.mIsEnableEyelashLocation, z ? 1 : 0);
    }

//    initEyePoints(mEyePoints, 450, 300, 480, 320, 2)
//    在每个控制过程有一个控制变量
    public void initPoints(PointF[] pointFArr, int normalBitmapWidth, int normalBitmapHeight, int i3, int i4, int i5) {
        if (i5 == 2) {
            int i6;
            this.eyeLinerLashBitmapWidth = normalBitmapWidth;
            this.eyeLinerLashBitmapHeight = normalBitmapHeight;
            this.w = i3;
            this.x = i4;
            this.k = ByteBuffer.allocate(normalBitmapWidth * normalBitmapHeight);
            this.q = ByteBuffer.allocate(normalBitmapWidth * normalBitmapHeight);
            this.y = 0;
            for (i6 = 0; i6 < i5; i6++) {
                this.y += (i3 >> i6) * (i4 >> i6);
            }
            for (i6 = 0; i6 < 2; i6++) {
                this.z[i6] = ByteBuffer.allocate((i3 >> i6) * (i4 >> i6));
                this.C[i6] = ByteBuffer.allocate((i3 >> i6) * (i4 >> i6));
            }
            for (i6 = 0; i6 < 4; i6++) {
                this.eyeInitPoints[i6] = pointFArr[i6];
            }
            PointF centerPointer = new PointF(this.eyeInitPoints[1].x, this.eyeInitPoints[0].y);
            this.centerPointControlFactors[0] = centerPointer.x / (centerPointer.x - this.eyeInitPoints[0].x);
            this.centerPointControlFactors[1] = centerPointer.y / (centerPointer.y - this.eyeInitPoints[1].y);
            this.centerPointControlFactors[2] = (((float) normalBitmapWidth) - centerPointer.x) / (this.eyeInitPoints[2].x - centerPointer.x);
            this.centerPointControlFactors[3] = (((float) normalBitmapHeight) - centerPointer.y) / (this.eyeInitPoints[3].y - centerPointer.y);
            this.shadowRect.set(Math.round(centerPointer.x), Math.round(centerPointer.y), Math.round(centerPointer.x), Math.round(centerPointer.y));
            this.eyeLinerRect.set(Math.round(centerPointer.x), Math.round(centerPointer.y), Math.round(centerPointer.x), Math.round(centerPointer.y));
            this.eyeLashRect.set(Math.round(centerPointer.x), Math.round(centerPointer.y), Math.round(centerPointer.x), Math.round(centerPointer.y));
            this.r = true;
        }
    }

    boolean calculateRectFromGray(Rect rect, int[] iArr, int i) {
        if (rect == null) {
            return false;
        }
        rect.top = this.eyeLinerLashBitmapHeight;
        rect.bottom = -1;
        rect.left = this.eyeLinerLashBitmapWidth;
        rect.right = -1;
        for (int i2 = 0; i2 < this.eyeLinerLashBitmapHeight; i2++) {
            int i3 = i2 * this.eyeLinerLashBitmapWidth;
            for (int i4 = 0; i4 < this.eyeLinerLashBitmapWidth; i4++) {
                if (Color.alpha(iArr[i3 + i4]) > i) {
                    rect.top = Math.min(rect.top, i2);
                    rect.bottom = Math.max(rect.bottom, i2);
                    rect.left = Math.min(rect.left, i4);
                    rect.right = Math.max(rect.right, i4);
                }
            }
        }
        if (rect.top == this.eyeLinerLashBitmapHeight || rect.bottom == -1 || rect.left == this.eyeLinerLashBitmapWidth || rect.right == -1) {
            rect.top = 0;
            rect.bottom = this.eyeLinerLashBitmapHeight;
            rect.left = 0;
            rect.right = this.eyeLinerLashBitmapWidth;
        }
        return true;
    }

    public boolean setEyeShadow(int[] iArr, byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (!this.r) {
            return false;
        }
        if (iArr.length != this.eyeLinerLashBitmapWidth * this.eyeLinerLashBitmapHeight) {
            return false;
        }
        if (bArr.length != this.y) {
            return false;
        }
        if (bArr2.length != this.y) {
            return false;
        }
        synchronized (this.drawShadowLock) {
            calculateRectFromGray(this.shadowRectN, iArr, 0);
            this.eyeShadow = Bitmap.createBitmap(this.eyeLinerLashBitmapWidth, this.eyeLinerLashBitmapHeight, Config.ARGB_8888);
            this.eyeShadow.setPixels(iArr, 0, this.eyeLinerLashBitmapWidth, 0, 0, this.eyeLinerLashBitmapWidth, this.eyeLinerLashBitmapHeight);
            int i2 = 0;
            while (i < 2) {
                int i3 = (this.w >> i) * (this.x >> i);
                this.z[i].clear();
                this.z[i].put(bArr, i2, i3);
                this.z[i].position(0);
                this.C[i].clear();
                this.C[i].put(bArr2, i2, i3);
                this.C[i].position(0);
                i2 += i3;
                i++;
            }
            this.needToDrawShadow = true;
        }
        return true;
    }

    private void drawShadow() {
        synchronized (this.drawShadowLock) {
            if (this.needToDrawShadow) {
                if (this.eyeshadowTextures != -1) {
                    GLES20.glDeleteTextures(1, new int[]{this.eyeshadowTextures}, 0);
                    this.eyeshadowTextures = -1;
                }
                if (!(this.eyeShadow == null || this.eyeShadow.isRecycled())) {
                    this.eyeshadowTextures = af.a(this.eyeShadow, -1, false);
                }
                this.shadowRect.set(this.shadowRectN);
                IntBuffer allocate = IntBuffer.allocate(1);
                GLES20.glGetIntegerv(3317, allocate);
                GLES20.glPixelStorei(3317, 1);
                for (int i = 0; i < 2; i++) {
                    int[] iArr;
                    if (this.A[i] == -1) {
                        iArr = new int[1];
                        GLES20.glGenTextures(1, iArr, 0);
                        this.A[i] = iArr[0];
                        GLES20.glBindTexture(3553, this.A[i]);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glTexImage2D(3553, 0, 6406, this.w >> i, this.x >> i, 0, 6406, 5121, this.z[i]);
                    } else {
                        GLES20.glBindTexture(3553, this.A[i]);
                        GLES20.glTexSubImage2D(3553, 0, 0, 0, this.w >> i, this.x >> i, 6406, 5121, this.z[i]);
                    }
                    if (this.D[i] == -1) {
                        iArr = new int[1];
                        GLES20.glGenTextures(1, iArr, 0);
                        this.D[i] = iArr[0];
                        GLES20.glBindTexture(3553, this.D[i]);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glTexImage2D(3553, 0, 6406, this.w >> i, this.x >> i, 0, 6406, 5121, this.C[i]);
                    } else {
                        GLES20.glBindTexture(3553, this.D[i]);
                        GLES20.glTexSubImage2D(3553, 0, 0, 0, this.w >> i, this.x >> i, 6406, 5121, this.C[i]);
                    }
                }
                GLES20.glPixelStorei(3317, allocate.get(0));
                this.needToDrawShadow = false;
            }
        }
    }

    public boolean setEyeLash(byte[] bArr, int i) {
        int i2 = 0;
        if (!this.r || bArr.length != this.eyeLinerLashBitmapWidth * this.eyeLinerLashBitmapHeight) {
            return false;
        }
        this.m[0] = ((float) Color.red(i)) / 255.0f;
        this.m[1] = ((float) Color.green(i)) / 255.0f;
        this.m[2] = ((float) Color.blue(i)) / 255.0f;
        int[] iArr = new int[(this.eyeLinerLashBitmapWidth * this.eyeLinerLashBitmapHeight)];
        while (i2 < this.eyeLinerLashBitmapWidth * this.eyeLinerLashBitmapHeight) {
            iArr[i2] = bArr[i2] << 24;
            i2++;
        }
        synchronized (this.aI) {
            calculateRectFromGray(this.eyeLashRectN, iArr, 0);
            this.q.clear();
            this.q.put(bArr);
            this.q.position(0);
            this.mHasEyeLash = true;
        }
        return true;
    }

    private void n() {
        synchronized (this.aI) {
            if (this.mHasEyeLash) {
                IntBuffer allocate = IntBuffer.allocate(1);
                GLES20.glGetIntegerv(3317, allocate);
                GLES20.glPixelStorei(3317, 1);
                if (this.eyelashTextures == -1) {
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    this.eyelashTextures = iArr[0];
                    GLES20.glBindTexture(3553, this.eyelashTextures);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glTexImage2D(3553, 0, 6406, this.eyeLinerLashBitmapWidth, this.eyeLinerLashBitmapHeight, 0, 6406, 5121, this.q);
                } else {
                    GLES20.glBindTexture(3553, this.eyelashTextures);
                    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.eyeLinerLashBitmapWidth, this.eyeLinerLashBitmapHeight, 6406, 5121, this.q);
                }
                GLES20.glPixelStorei(3317, allocate.get(0));
                this.eyeLashRect.set(this.eyeLashRectN);
                this.mHasEyeLash = false;
            }
        }
    }

    public boolean setEyeLiner(byte[] bArr, int i) {
        int i2 = 0;
        if (!this.r || bArr.length != this.eyeLinerLashBitmapWidth * this.eyeLinerLashBitmapHeight) {
            return false;
        }
        this.g[0] = ((float) Color.red(i)) / 255.0f;
        this.g[1] = ((float) Color.green(i)) / 255.0f;
        this.g[2] = ((float) Color.blue(i)) / 255.0f;
        int[] iArr = new int[(this.eyeLinerLashBitmapWidth * this.eyeLinerLashBitmapHeight)];
        while (i2 < this.eyeLinerLashBitmapWidth * this.eyeLinerLashBitmapHeight) {
            iArr[i2] = bArr[i2] << 24;
            i2++;
        }
        synchronized (this.needDrawEyeLinerLock) {
            calculateRectFromGray(this.eyeLinerRectN, iArr, 0);
            this.k.clear();
            this.k.put(bArr);
            this.k.position(0);
            this.needDrawEyeLiner = true;
        }
        return true;
    }

    private void o() {
        synchronized (this.needDrawEyeLinerLock) {
            if (this.needDrawEyeLiner) {
                IntBuffer allocate = IntBuffer.allocate(1);
                GLES20.glGetIntegerv(3317, allocate);
                GLES20.glPixelStorei(3317, 1);
                if (this.eyeLinerTextures == -1) {
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    this.eyeLinerTextures = iArr[0];
                    GLES20.glBindTexture(3553, this.eyeLinerTextures);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glTexImage2D(3553, 0, 6406, this.eyeLinerLashBitmapWidth, this.eyeLinerLashBitmapHeight, 0, 6406, 5121, this.k);
                } else {
                    GLES20.glBindTexture(3553, this.eyeLinerTextures);
                    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.eyeLinerLashBitmapWidth, this.eyeLinerLashBitmapHeight, 6406, 5121, this.k);
                }
                GLES20.glPixelStorei(3317, allocate.get(0));
                this.eyeLinerRect.set(this.eyeLinerRectN);
                this.needDrawEyeLiner = false;
            }
        }
    }

    public void freshData(LiveEyeMakeupMetadata liveEyeMakeupMetadata) {
        synchronized (this.al) {
            this.eyeMakeupData.Copy(liveEyeMakeupMetadata);
        }
    }

    public void a(int i) {
        this.aK = i;
    }

    protected float[] a(float[] fArr, int i) {
        if (i == (this.aK + 270) % 360) {
            return new float[]{fArr[4], fArr[5], fArr[0], fArr[1], fArr[6], fArr[7], fArr[2], fArr[3]};
        } else if (i == (this.aK + 180) % 360) {
            return new float[]{fArr[6], fArr[7], fArr[4], fArr[5], fArr[2], fArr[3], fArr[0], fArr[1]};
        } else if (i == (this.aK + 90) % 360) {
            return new float[]{fArr[2], fArr[3], fArr[6], fArr[7], fArr[0], fArr[1], fArr[4], fArr[5]};
        } else {
            return new float[]{fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]};
        }
    }
}
