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
    protected int[] B;
    protected ByteBuffer[] C;
    protected int[] D;
    protected int[] E;
    protected Rect F;
    protected Rect G;
    protected Rect H;
    protected Rect I;
    protected Rect J;
    protected Rect K;
    protected int L;
    protected int M;
    protected int N;
    protected int O;
    protected int P;
    protected int Q;
    protected int R;
    protected int S;
    protected int T;
    protected int U;
    protected int V;
    protected int W;
    protected int X;
    protected int Y;
    protected int Z;
    protected int a;
    private Object aE;
    private boolean aF;
    private Object aG;
    private boolean aH;
    private Object aI;
    private boolean aJ;
    private int aK;
    protected boolean mIsEyeShadowEnable;
    protected boolean mIsEyeLinerEnable;
    protected boolean mIsEyelashEnable;
    protected int mIsEnableEyeShadowLocation;
    protected int mIsEnableEyeLinerLocation;
    protected int mIsEnableEyelashLocation;
    protected float ag;
    protected float ah;
    protected int ai;
    protected int aj;
    protected int ak;
    protected Object al;
    LiveEyeMakeupMetadata am;
    protected boolean an;
    protected int ao;
    protected float[] ap;
    protected int aq;
    protected int ar;
    protected int as;
    protected int at;
    protected FloatBuffer b;
    protected Bitmap c;
    protected int d;
    protected int e;
    protected int f;
    protected float[] g;
    protected float[] h;
    protected int i;
    protected int j;
    protected ByteBuffer k;
    protected int l;
    protected float[] m;
    protected float[] n;
    protected int o;
    protected int p;
    protected ByteBuffer q;
    protected boolean r;
    protected PointF[] s;
    protected PointF[] t;
    protected int u;
    protected int v;
    protected int w;
    protected int x;
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
        this.d = -1;
        this.g = new float[]{0.0f, 0.0f, 0.0f};
        this.h = new float[]{0.0f, 0.0f, 0.0f};
        this.i = -1;
        this.m = new float[]{0.0f, 0.0f, 0.0f};
        this.n = new float[]{0.0f, 0.0f, 0.0f};
        this.o = -1;
        this.r = false;
        this.s = new PointF[4];
        this.t = new PointF[4];
        this.z = new ByteBuffer[2];
        this.A = new int[2];
        this.B = new int[2];
        this.C = new ByteBuffer[2];
        this.D = new int[2];
        this.E = new int[2];
        this.F = new Rect();
        this.G = new Rect();
        this.H = new Rect();
        this.I = new Rect();
        this.J = new Rect();
        this.K = new Rect();
        this.mIsEyeShadowEnable = false;
        this.mIsEyeLinerEnable = false;
        this.mIsEyelashEnable = false;
        this.al = new Object();
        this.am = new LiveEyeMakeupMetadata();
        this.an = true;
        this.ap = new float[4];
        this.aE = new Object();
        this.aF = false;
        this.aG = new Object();
        this.aH = false;
        this.aI = new Object();
        this.aJ = false;
        this.aK = 90;
        this.b = ByteBuffer.allocateDirect(au.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i2 = 0; i2 < 4; i2++) {
            this.s[i2] = new PointF();
            this.t[i2] = new PointF();
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
        this.d = -1;
        this.g = new float[]{0.0f, 0.0f, 0.0f};
        this.h = new float[]{0.0f, 0.0f, 0.0f};
        this.i = -1;
        this.m = new float[]{0.0f, 0.0f, 0.0f};
        this.n = new float[]{0.0f, 0.0f, 0.0f};
        this.o = -1;
        this.r = false;
        this.s = new PointF[4];
        this.t = new PointF[4];
        this.z = new ByteBuffer[2];
        this.A = new int[2];
        this.B = new int[2];
        this.C = new ByteBuffer[2];
        this.D = new int[2];
        this.E = new int[2];
        this.F = new Rect();
        this.G = new Rect();
        this.H = new Rect();
        this.I = new Rect();
        this.J = new Rect();
        this.K = new Rect();
        this.mIsEyeShadowEnable = false;
        this.mIsEyeLinerEnable = false;
        this.mIsEyelashEnable = false;
        this.al = new Object();
        this.am = new LiveEyeMakeupMetadata();
        this.an = true;
        this.ap = new float[4];
        this.aE = new Object();
        this.aF = false;
        this.aG = new Object();
        this.aH = false;
        this.aI = new Object();
        this.aJ = false;
        this.aK = 90;
        this.b = ByteBuffer.allocateDirect(au.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i2 = 0; i2 < 4; i2++) {
            this.s[i2] = new PointF();
            this.t[i2] = new PointF();
        }
        this.an = z;
        while (i < 2) {
            this.A[i] = -1;
            this.D[i] = -1;
            i++;
        }
    }

    public void f() {
//        a(b.a(l.a), b.a(k.a));
    }

    @Override
    public void onInit() {
        super.onInit();
        this.a = GLES20.glGetAttribLocation(getProgram(), "inputTemplateTextureCoordinate");
        this.e = GLES20.glGetUniformLocation(getProgram(), "eyeshadow_texture");
        this.j = GLES20.glGetUniformLocation(getProgram(), "eyeliner_texture");
        this.p = GLES20.glGetUniformLocation(getProgram(), "eyelash_texture");
        this.ao = GLES20.glGetUniformLocation(getProgram(), "left_right_flip");
        this.f = GLES20.glGetUniformLocation(getProgram(), "eyeliner_template_color");
        this.l = GLES20.glGetUniformLocation(getProgram(), "eyelash_template_color");
        this.L = GLES20.glGetUniformLocation(getProgram(), "frame_to_template_y_remapping_factor");
        this.M = GLES20.glGetUniformLocation(getProgram(), "target_eye_lower_lid_luma");
        this.N = GLES20.glGetUniformLocation(getProgram(), "level_orient_cos_sin");
        this.O = GLES20.glGetUniformLocation(getProgram(), "oriented_upper_lid_center");
        this.P = GLES20.glGetUniformLocation(getProgram(), "oriented_lower_lid_center");
        this.Q = GLES20.glGetUniformLocation(getProgram(), "similarity_origin");
        this.R = GLES20.glGetUniformLocation(getProgram(), "similarity_shift");
        this.S = GLES20.glGetUniformLocation(getProgram(), "similarity_scale");
        this.T = GLES20.glGetUniformLocation(getProgram(), "top_spline_transform_src_dst_center");
        this.U = GLES20.glGetUniformLocation(getProgram(), "top_left_spline_transform_src_dst_aligned_parabolic_coeff");
        this.V = GLES20.glGetUniformLocation(getProgram(), "top_right_spline_transform_src_dst_aligned_parabolic_coeff");
        this.W = GLES20.glGetUniformLocation(getProgram(), "bottom_spline_transform_src_dst_center");
        this.X = GLES20.glGetUniformLocation(getProgram(), "bottom_left_spline_transform_src_dst_aligned_parabolic_coeff");
        this.Y = GLES20.glGetUniformLocation(getProgram(), "bottom_right_spline_transform_src_dst_aligned_parabolic_coeff");
        this.mIsEnableEyeShadowLocation = GLES20.glGetUniformLocation(getProgram(), "enable_eyeshadow");
        this.mIsEnableEyeLinerLocation = GLES20.glGetUniformLocation(getProgram(), "enable_eyeliner");
        this.mIsEnableEyelashLocation = GLES20.glGetUniformLocation(getProgram(), "enable_eyelash");
        setEyeShadowEnable(this.mIsEyeShadowEnable);
        setEyeLinerEnable(this.mIsEyeLinerEnable);
        setEyeLashEnable(this.mIsEyelashEnable);
        this.aq = GLES20.glGetUniformLocation(getProgram(), "roi");
        this.ar = GLES20.glGetUniformLocation(getProgram(), "eyeshadow_multiply_correction");
        this.as = GLES20.glGetUniformLocation(getProgram(), "analyzing_frame_width_height_in_pixel");
        this.Z = GLES20.glGetUniformLocation(getProgram(), "environment_luma");
        this.at = GLES20.glGetUniformLocation(getProgram(), "upper_lid_eyelash_y_scale_adjuster");
        this.ai = GLES20.glGetUniformLocation(getProgram(), "shimmer_model_scale");
        this.aj = GLES20.glGetUniformLocation(getProgram(), "environment_brightest");
        this.ak = GLES20.glGetUniformLocation(getProgram(), "environment_compress");
        this.B[0] = GLES20.glGetUniformLocation(getProgram(), "bright0_texture");
        this.E[0] = GLES20.glGetUniformLocation(getProgram(), "glitter0_texture");
        this.B[1] = GLES20.glGetUniformLocation(getProgram(), "bright1_texture");
        this.E[1] = GLES20.glGetUniformLocation(getProgram(), "glitter1_texture");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.d != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.d}, 0);
            this.d = -1;
        }
        if (this.i != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.i}, 0);
            this.i = -1;
        }
        if (this.o != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.o}, 0);
            this.o = -1;
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
        if (this.d != -1) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.d);
            GLES20.glUniform1i(this.e, 1);
            i2 = 33986;
            i = 2;
        } else {
            i = 1;
        }
        int i3 = i2 + 1;
        if (this.i != -1) {
            GLES20.glActiveTexture(i2);
            GLES20.glBindTexture(3553, this.i);
            i2 = i + 1;
            GLES20.glUniform1i(this.j, i);
            i = i2;
            i2 = i3;
        }
        if (this.o != -1) {
            i3 = i2 + 1;
            GLES20.glActiveTexture(i2);
            GLES20.glBindTexture(3553, this.o);
            i2 = i + 1;
            GLES20.glUniform1i(this.p, i);
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
                GLES20.glUniform1i(this.B[i4], i2);
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
                GLES20.glUniform1i(this.E[i4], i);
                i = i2;
                i2 = i3;
            }
            i4++;
            i5 = i;
            i = i2;
            i2 = i5;
        }
        synchronized (this.al) {
            f = this.am.m_environment_darkest_reference_normalized_luma;
            float f2 = this.am.m_environment_brightest_reference_normalized_luma;
            this.ag = f2;
            this.ah = f2 - f;
            this.h[0] = ((f2 - f) * this.g[0]) + f;
            this.h[1] = ((f2 - f) * this.g[1]) + f;
            this.h[2] = ((f2 - f) * this.g[2]) + f;
            this.n[0] = ((f2 - f) * this.m[0]) + f;
            this.n[1] = ((f2 - f) * this.m[1]) + f;
            this.n[2] = f + ((f2 - f) * this.m[2]);
        }
        GLES20.glUniform3fv(this.f, 1, FloatBuffer.wrap(this.h));
        GLES20.glUniform3fv(this.l, 1, FloatBuffer.wrap(this.n));
        GLES20.glUniform1f(this.aj, this.ag);
        GLES20.glUniform1f(this.ak, this.ah);
        int i6 = this.ao;
        if (this.an) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        GLES20.glUniform1f(i6, f);
        synchronized (this.al) {
            this.b.clear();
            this.b.put(a(au, this.am.m_rotation));
            this.b.position(0);
            GLES20.glVertexAttribPointer(this.a, 2, 5126, false, 0, this.b);
            GLES20.glEnableVertexAttribArray(this.a);
            for (i = 0; i < 4; i++) {
                this.s[i].x = this.t[i].x / ((float) this.u);
                this.s[i].y = this.t[i].y / ((float) this.v);
            }
            GLES20.glUniform2f(this.as, (float) this.am.m_analyzing_frame_width, (float) this.am.m_analyzing_frame_height);
            if (this.u * this.am.m_analyzing_frame_height <= 0 || this.v * this.am.m_analyzing_frame_width <= 0) {
                f = 1.0f;
            } else {
                f = ((float) (this.v * this.am.m_analyzing_frame_width)) / ((float) (this.u * this.am.m_analyzing_frame_height));
            }
            for (i6 = 0; i6 < 4; i6++) {
                PointF pointF = this.s[i6];
                pointF.y *= f;
            }
            GLES20.glUniform1f(this.L, 1.0f / f);
            float f3 = (this.s[2].x - this.s[0].x) / (this.am.m_oriented_eye_points[2].x - this.am.m_oriented_eye_points[0].x);
            GLES20.glUniform1f(this.ai, Math.max(0.0f, Math.min(1.0f, ((((1.0f / f3) * ((float) this.u)) / ((float) this.w)) - 0.35f) / 0.3f)));
            Rect rect = new Rect();
            rect.union(this.F);
            rect.union(this.G);
            rect.union(this.H);
            PointF pointF2 = new PointF(this.t[1].x, this.t[0].y);
            this.ap[0] = (pointF2.x - ((float) rect.left)) / (pointF2.x - this.t[0].x);
            this.ap[1] = (pointF2.y - ((float) rect.top)) / (pointF2.y - this.t[1].y);
            this.ap[2] = (((float) rect.right) - pointF2.x) / (this.t[2].x - pointF2.x);
            this.ap[3] = (((float) rect.bottom) - pointF2.y) / (this.t[3].y - pointF2.y);
            GLES20.glUniform4f(this.aq, Math.min(Math.max(this.am.m_oriented_eye_centers[0].x, this.am.m_oriented_eye_centers[1].x) + (this.ap[0] * (this.am.m_oriented_eye_points[0].x - Math.max(this.am.m_oriented_eye_centers[0].x, this.am.m_oriented_eye_centers[1].x))), this.am.m_oriented_eye_centers[0].x - ((this.s[1].x - (((float) rect.left) / ((float) this.u))) / f3)), Math.max(Math.min(this.am.m_oriented_eye_centers[0].x, this.am.m_oriented_eye_centers[1].x) + (this.ap[2] * (this.am.m_oriented_eye_points[2].x - Math.min(this.am.m_oriented_eye_centers[0].x, this.am.m_oriented_eye_centers[1].x))), this.am.m_oriented_eye_centers[0].x + ((((float) (rect.right / this.u)) - this.s[1].x) / f3)), Math.min(this.am.m_oriented_eye_centers[0].y + (this.ap[1] * (this.am.m_oriented_eye_points[1].y - this.am.m_oriented_eye_centers[0].y)), this.am.m_oriented_eye_centers[0].y - ((this.s[0].y - (f * (((float) rect.top) / ((float) this.v)))) / f3)), this.am.m_oriented_eye_points[3].y + (((this.s[3].y - this.s[0].y) * (this.ap[3] - 1.0f)) / f3));
            GLES20.glUniform1f(this.M, this.am.m_target_eye_lower_lid_luma);
            GLES20.glUniform1f(this.ar, Math.max(1.0f, Math.min(5.0f, (((float) Math.pow((double) Math.max(0.0f, (0.5f - this.am.m_target_eye_lower_lid_luma) / 0.5f), 0.25d)) + 1.0f) * (0.5f / Math.max(this.am.m_target_eye_lower_lid_luma, 0.001f)))));
            GLES20.glUniform2f(this.N, this.am.m_target_level_orientation_cos, this.am.m_target_level_orientation_sin);
            GLES20.glUniform2f(this.O, this.am.m_oriented_eye_centers[0].x, this.am.m_oriented_eye_centers[0].y);
            GLES20.glUniform2f(this.P, this.am.m_oriented_eye_centers[1].x, this.am.m_oriented_eye_centers[1].y);
            GLES20.glUniform2f(this.Q, this.am.m_oriented_eye_points[0].x, this.am.m_oriented_eye_points[0].y);
            GLES20.glUniform2f(this.R, this.s[0].x - this.am.m_oriented_eye_points[0].x, this.s[0].y - this.am.m_oriented_eye_points[0].y);
            GLES20.glUniform1f(this.S, f3);
            GLES20.glUniform4f(this.T, this.am.m_parabolic_polar_transform_top_left_src_center.x, this.am.m_parabolic_polar_transform_top_left_src_center.y, this.am.m_parabolic_polar_transform_top_left_dst_center.x, this.am.m_parabolic_polar_transform_top_left_dst_center.y);
            GLES20.glUniform4f(this.U, this.am.m_parabolic_polar_transform_top_left_src_aligned_coeff[0], this.am.m_parabolic_polar_transform_top_left_src_aligned_coeff[1], this.am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[0], this.am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]);
            GLES20.glUniform4f(this.V, this.am.m_parabolic_polar_transform_top_right_src_aligned_coeff[0], this.am.m_parabolic_polar_transform_top_right_src_aligned_coeff[1], this.am.m_parabolic_polar_transform_top_right_dst_aligned_coeff[0], this.am.m_parabolic_polar_transform_top_right_dst_aligned_coeff[1]);
            GLES20.glUniform4f(this.W, this.am.m_parabolic_polar_transform_bottom_left_src_center.x, this.am.m_parabolic_polar_transform_bottom_left_src_center.y, this.am.m_parabolic_polar_transform_bottom_left_dst_center.x, this.am.m_parabolic_polar_transform_bottom_left_dst_center.y);
            GLES20.glUniform4f(this.X, this.am.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[0], this.am.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[1], this.am.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[0], this.am.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[1]);
            GLES20.glUniform4f(this.Y, this.am.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[0], this.am.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[1], this.am.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[0], this.am.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[1]);
            GLES20.glUniform2f(this.Z, this.am.m_environment_darkest_reference_normalized_luma, this.am.m_environment_brightest_reference_normalized_luma);
            GLES20.glUniform1f(this.at, Math.max(0.2f, Math.min(1.0f, ((this.am.m_parabolic_polar_transform_top_left_src_aligned_coeff[1] * f3) / this.am.m_parabolic_polar_transform_top_left_dst_aligned_coeff[1]) * 1.2f)));
        }
    }

    @Override
    public void runPendingOnDrawTasks() {
        super.runPendingOnDrawTasks();
        m();
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

    public void initPoints(PointF[] pointFArr, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 2) {
            int i6;
            this.u = i;
            this.v = i2;
            this.w = i3;
            this.x = i4;
            this.k = ByteBuffer.allocate(i * i2);
            this.q = ByteBuffer.allocate(i * i2);
            this.y = 0;
            for (i6 = 0; i6 < i5; i6++) {
                this.y += (i3 >> i6) * (i4 >> i6);
            }
            for (i6 = 0; i6 < 2; i6++) {
                this.z[i6] = ByteBuffer.allocate((i3 >> i6) * (i4 >> i6));
                this.C[i6] = ByteBuffer.allocate((i3 >> i6) * (i4 >> i6));
            }
            for (i6 = 0; i6 < 4; i6++) {
                this.t[i6] = pointFArr[i6];
            }
            PointF pointF = new PointF(this.t[1].x, this.t[0].y);
            this.ap[0] = pointF.x / (pointF.x - this.t[0].x);
            this.ap[1] = pointF.y / (pointF.y - this.t[1].y);
            this.ap[2] = (((float) i) - pointF.x) / (this.t[2].x - pointF.x);
            this.ap[3] = (((float) i2) - pointF.y) / (this.t[3].y - pointF.y);
            this.F.set(Math.round(pointF.x), Math.round(pointF.y), Math.round(pointF.x), Math.round(pointF.y));
            this.G.set(Math.round(pointF.x), Math.round(pointF.y), Math.round(pointF.x), Math.round(pointF.y));
            this.H.set(Math.round(pointF.x), Math.round(pointF.y), Math.round(pointF.x), Math.round(pointF.y));
            this.r = true;
        }
    }

    boolean a(Rect rect, int[] iArr, int i) {
        if (rect == null) {
            return false;
        }
        rect.top = this.v;
        rect.bottom = -1;
        rect.left = this.u;
        rect.right = -1;
        for (int i2 = 0; i2 < this.v; i2++) {
            int i3 = i2 * this.u;
            for (int i4 = 0; i4 < this.u; i4++) {
                if (Color.alpha(iArr[i3 + i4]) > i) {
                    rect.top = Math.min(rect.top, i2);
                    rect.bottom = Math.max(rect.bottom, i2);
                    rect.left = Math.min(rect.left, i4);
                    rect.right = Math.max(rect.right, i4);
                }
            }
        }
        if (rect.top == this.v || rect.bottom == -1 || rect.left == this.u || rect.right == -1) {
            rect.top = 0;
            rect.bottom = this.v;
            rect.left = 0;
            rect.right = this.u;
        }
        return true;
    }

    public boolean setEyeShadow(int[] iArr, byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (!this.r) {
            return false;
        }
        if (iArr.length != this.u * this.v) {
            return false;
        }
        if (bArr.length != this.y) {
            return false;
        }
        if (bArr2.length != this.y) {
            return false;
        }
        synchronized (this.aE) {
            a(this.I, iArr, 0);
            this.c = Bitmap.createBitmap(this.u, this.v, Config.ARGB_8888);
            this.c.setPixels(iArr, 0, this.u, 0, 0, this.u, this.v);
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
            this.aF = true;
        }
        return true;
    }

    private void m() {
        synchronized (this.aE) {
            if (this.aF) {
                if (this.d != -1) {
                    GLES20.glDeleteTextures(1, new int[]{this.d}, 0);
                    this.d = -1;
                }
                if (!(this.c == null || this.c.isRecycled())) {
                    this.d = af.a(this.c, -1, false);
                }
                this.F.set(this.I);
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
                this.aF = false;
            }
        }
    }

    public boolean setEyeLash(byte[] bArr, int i) {
        int i2 = 0;
        if (!this.r || bArr.length != this.u * this.v) {
            return false;
        }
        this.m[0] = ((float) Color.red(i)) / 255.0f;
        this.m[1] = ((float) Color.green(i)) / 255.0f;
        this.m[2] = ((float) Color.blue(i)) / 255.0f;
        int[] iArr = new int[(this.u * this.v)];
        while (i2 < this.u * this.v) {
            iArr[i2] = bArr[i2] << 24;
            i2++;
        }
        synchronized (this.aI) {
            a(this.K, iArr, 0);
            this.q.clear();
            this.q.put(bArr);
            this.q.position(0);
            this.aJ = true;
        }
        return true;
    }

    private void n() {
        synchronized (this.aI) {
            if (this.aJ) {
                IntBuffer allocate = IntBuffer.allocate(1);
                GLES20.glGetIntegerv(3317, allocate);
                GLES20.glPixelStorei(3317, 1);
                if (this.o == -1) {
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    this.o = iArr[0];
                    GLES20.glBindTexture(3553, this.o);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glTexImage2D(3553, 0, 6406, this.u, this.v, 0, 6406, 5121, this.q);
                } else {
                    GLES20.glBindTexture(3553, this.o);
                    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.u, this.v, 6406, 5121, this.q);
                }
                GLES20.glPixelStorei(3317, allocate.get(0));
                this.H.set(this.K);
                this.aJ = false;
            }
        }
    }

    public boolean setEyeLiner(byte[] bArr, int i) {
        int i2 = 0;
        if (!this.r || bArr.length != this.u * this.v) {
            return false;
        }
        this.g[0] = ((float) Color.red(i)) / 255.0f;
        this.g[1] = ((float) Color.green(i)) / 255.0f;
        this.g[2] = ((float) Color.blue(i)) / 255.0f;
        int[] iArr = new int[(this.u * this.v)];
        while (i2 < this.u * this.v) {
            iArr[i2] = bArr[i2] << 24;
            i2++;
        }
        synchronized (this.aG) {
            a(this.J, iArr, 0);
            this.k.clear();
            this.k.put(bArr);
            this.k.position(0);
            this.aH = true;
        }
        return true;
    }

    private void o() {
        synchronized (this.aG) {
            if (this.aH) {
                IntBuffer allocate = IntBuffer.allocate(1);
                GLES20.glGetIntegerv(3317, allocate);
                GLES20.glPixelStorei(3317, 1);
                if (this.i == -1) {
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    this.i = iArr[0];
                    GLES20.glBindTexture(3553, this.i);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glTexImage2D(3553, 0, 6406, this.u, this.v, 0, 6406, 5121, this.k);
                } else {
                    GLES20.glBindTexture(3553, this.i);
                    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.u, this.v, 6406, 5121, this.k);
                }
                GLES20.glPixelStorei(3317, allocate.get(0));
                this.G.set(this.J);
                this.aH = false;
            }
        }
    }

    public void freshData(LiveEyeMakeupMetadata liveEyeMakeupMetadata) {
        synchronized (this.al) {
            this.am.Copy(liveEyeMakeupMetadata);
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
