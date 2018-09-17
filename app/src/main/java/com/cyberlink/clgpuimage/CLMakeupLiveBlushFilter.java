package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.opengl.GLES20;

import com.het.facesdk.utils.OpenGlUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * 腮红Filter
 */
public class CLMakeupLiveBlushFilter extends GPUImageFilter {

    public static class LiveBlushMakeupdata {
        public PointF m_center = new PointF();
        public float m_cos_val;
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        public boolean m_is_flipped;
        public BlushRect m_left_blush_roi = new BlushRect();
        public BlushRect m_right_blush_roi = new BlushRect();
        public int m_rotation;
        public float m_sin_val;

        public void SetBlushFeaturePts(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8, PointF pointF9, PointF pointF10) {
            ComputeData(CLMakeupLiveBlushFilter.a(pointF), CLMakeupLiveBlushFilter.a(pointF2), CLMakeupLiveBlushFilter.a(pointF3), CLMakeupLiveBlushFilter.a(pointF4), CLMakeupLiveBlushFilter.a(pointF5), CLMakeupLiveBlushFilter.a(pointF6), CLMakeupLiveBlushFilter.a(pointF7), CLMakeupLiveBlushFilter.a(pointF8), CLMakeupLiveBlushFilter.a(pointF9), CLMakeupLiveBlushFilter.a(pointF10));
        }

        public void ComputeData(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8, PointF pointF9, PointF pointF10) {
            double atan2 = Math.atan2((double) (pointF10.y - pointF5.y), (double) (pointF10.x - pointF5.x));
            this.m_cos_val = (float) Math.cos(-atan2);
            this.m_sin_val = (float) Math.sin(-atan2);
            this.m_center.x = (pointF2.x + pointF7.x) * 0.5f;
            this.m_center.y = (pointF2.y + pointF7.y) * 0.5f;
            this.m_left_blush_roi.c();
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF2));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF3));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF4));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF5));
            this.m_right_blush_roi.c();
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF6));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF7));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF8));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF9));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF10));
        }

        public void Copy(LiveBlushMakeupdata liveBlushMakeupdata) {
            this.m_cos_val = liveBlushMakeupdata.m_cos_val;
            this.m_sin_val = liveBlushMakeupdata.m_sin_val;
            this.m_center.x = liveBlushMakeupdata.m_center.x;
            this.m_center.y = liveBlushMakeupdata.m_center.y;
            this.m_left_blush_roi.l = liveBlushMakeupdata.m_left_blush_roi.l;
            this.m_left_blush_roi.r = liveBlushMakeupdata.m_left_blush_roi.r;
            this.m_left_blush_roi.t = liveBlushMakeupdata.m_left_blush_roi.t;
            this.m_left_blush_roi.b = liveBlushMakeupdata.m_left_blush_roi.b;
            this.m_right_blush_roi.l = liveBlushMakeupdata.m_right_blush_roi.l;
            this.m_right_blush_roi.r = liveBlushMakeupdata.m_right_blush_roi.r;
            this.m_right_blush_roi.t = liveBlushMakeupdata.m_right_blush_roi.t;
            this.m_right_blush_roi.b = liveBlushMakeupdata.m_right_blush_roi.b;
            this.m_environment_darkest_reference_normalized_luma = liveBlushMakeupdata.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = liveBlushMakeupdata.m_environment_brightest_reference_normalized_luma;
            this.m_rotation = liveBlushMakeupdata.m_rotation;
            this.m_is_flipped = liveBlushMakeupdata.m_is_flipped;
        }
    }

    private static final float[] D = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    private int A;
    private boolean B;
    private int C = 90;
    protected int inputTemplateTextureCoordinate;
    private Object b = new Object();
    private boolean c = false;
    private Object d = new Object();
    private FloatBuffer e = ByteBuffer.allocateDirect(D.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private float f = 1.0f;
    private float[] mBlushColor = new float[]{0.0f, 0.0f, 0.0f};
    private float[] h = new float[]{0.0f, 0.0f, 0.0f};
    private int blush_strength;
    private int blush_color;
    private int Mid_X_of_left_right;
    private int RotateCenter;
    private int Cos_Sin;
    private int negSin_Cos;
    private Bitmap o = null;
    private int p = -1;
    private int left_blush_texture;
    private int left_blush_roi;
    private int left_blush_stretch;
    private Bitmap t = null;
    private int u = -1;
    private int right_blush_texture;
    private int right_blush_roi;
    private int right_blush_stretch;
    private float y;
    private float z;

    public CLMakeupLiveBlushFilter() {
        super(OpenGlUtils.file2Glsl("face/blush.vert"),
                OpenGlUtils.file2Glsl("face/blush.frag"));
    }

    @Override
    public void onInit() {
        super.onInit();

        this.inputTemplateTextureCoordinate = GLES20.glGetAttribLocation(getProgram(), "inputTemplateTextureCoordinate");
        this.blush_strength = GLES20.glGetUniformLocation(getProgram(), "blush_strength");
        this.blush_color = GLES20.glGetUniformLocation(getProgram(), "blush_color");
        this.Mid_X_of_left_right = GLES20.glGetUniformLocation(getProgram(), "Mid_X_of_left_right");
        this.RotateCenter = GLES20.glGetUniformLocation(getProgram(), "RotateCenter");
        this.Cos_Sin = GLES20.glGetUniformLocation(getProgram(), "Cos_Sin");
        this.negSin_Cos = GLES20.glGetUniformLocation(getProgram(), "negSin_Cos");
        this.left_blush_texture = GLES20.glGetUniformLocation(getProgram(), "left_blush_texture");
        this.left_blush_roi = GLES20.glGetUniformLocation(getProgram(), "left_blush_roi");
        this.left_blush_stretch = GLES20.glGetUniformLocation(getProgram(), "left_blush_stretch");
        this.right_blush_texture = GLES20.glGetUniformLocation(getProgram(), "right_blush_texture");
        this.right_blush_roi = GLES20.glGetUniformLocation(getProgram(), "right_blush_roi");//开始的坐标点
        this.right_blush_stretch = GLES20.glGetUniformLocation(getProgram(), "right_blush_stretch");//长和宽
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.p != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.p}, 0);
            this.p = -1;
        }
        if (this.u != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.u}, 0);
            this.u = -1;
        }
    }

    @Override
    public void onOutputSizeChanged(int width, int height) {
        super.onOutputSizeChanged(width, height);
    }

    @Override
    public void onDraw(int textureId, FloatBuffer cubeBuffer, FloatBuffer textureBuffer) {
        super.onDraw(textureId, cubeBuffer, textureBuffer);
    }

    @Override
    public void onDrawArraysPre() {
        super.onDrawArraysPre();
        this.e.clear();
        this.e.put(a(D, this.A));
        this.e.position(0);
        GLES20.glVertexAttribPointer(this.inputTemplateTextureCoordinate, 2, 5126, false, 0, this.e);
        GLES20.glEnableVertexAttribArray(this.inputTemplateTextureCoordinate);
        setFloat(this.blush_strength, this.f);
        synchronized (this.d) {
            float f = this.z;
            float f2 = this.y;
            this.h[0] = ((f2 - f) * this.mBlushColor[0]) + f;
            this.h[1] = ((f2 - f) * this.mBlushColor[1]) + f;
            this.h[2] = f + ((f2 - f) * this.mBlushColor[2]);
        }
        GLES20.glUniform3fv(this.blush_color, 1, FloatBuffer.wrap(this.h));
        if (this.p != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.p);
            GLES20.glUniform1i(this.left_blush_texture, 3);
        }
        if (this.u != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, this.u);
            GLES20.glUniform1i(this.right_blush_texture, 4);
        }
    }

    @Override
    public void runPendingOnDrawTasks() {
        super.runPendingOnDrawTasks();
        doSomeTasks();
    }

    public void freshData(LiveBlushMakeupdata liveBlushMakeupdata) {
        synchronized (this.d) {
            setPoint(this.negSin_Cos, new PointF(-liveBlushMakeupdata.m_sin_val, liveBlushMakeupdata.m_cos_val));
            setPoint(this.Cos_Sin, new PointF(liveBlushMakeupdata.m_cos_val, liveBlushMakeupdata.m_sin_val));
            setPoint(this.RotateCenter, liveBlushMakeupdata.m_center);
            setFloat(this.Mid_X_of_left_right, liveBlushMakeupdata.m_center.x);
            setPoint(this.left_blush_stretch, new PointF(b(liveBlushMakeupdata.m_left_blush_roi.width()), b(liveBlushMakeupdata.m_left_blush_roi.height())));
            setPoint(this.left_blush_roi, new PointF(liveBlushMakeupdata.m_left_blush_roi.l, liveBlushMakeupdata.m_left_blush_roi.t));
            setPoint(this.right_blush_stretch, new PointF(b(liveBlushMakeupdata.m_right_blush_roi.width()), b(liveBlushMakeupdata.m_right_blush_roi.height())));
            setPoint(this.right_blush_roi, new PointF(liveBlushMakeupdata.m_right_blush_roi.l, liveBlushMakeupdata.m_right_blush_roi.t));
            this.z = liveBlushMakeupdata.m_environment_darkest_reference_normalized_luma;
            this.y = liveBlushMakeupdata.m_environment_brightest_reference_normalized_luma;
            this.A = liveBlushMakeupdata.m_rotation;
            this.B = liveBlushMakeupdata.m_is_flipped;
        }
    }

    public void a(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            this.f = 0.01f * f;
        }
    }

    public void setBlushColor(int i) {
        this.mBlushColor[0] = ((float) Color.red(i)) / 255.0f;
        this.mBlushColor[1] = ((float) Color.green(i)) / 255.0f;
        this.mBlushColor[2] = ((float) Color.blue(i)) / 255.0f;
    }

    public boolean setBlushBitmap(Bitmap[] bitmapArr) {
        synchronized (this.b) {
            this.o = Bitmap.createBitmap(bitmapArr[0]);
            this.t = Bitmap.createBitmap(bitmapArr[1]);
            this.c = true;
        }
        return true;
    }

    private void doSomeTasks() {
        synchronized (this.b) {
            if (this.c) {
                if (this.p != -1) {
                    GLES20.glDeleteTextures(1, new int[]{this.p}, 0);
                    this.p = -1;
                }
                if (!(this.o == null || this.o.isRecycled())) {
                    this.p = af.a(this.o, -1, false);
                }
                if (this.u != -1) {
                    GLES20.glDeleteTextures(1, new int[]{this.u}, 0);
                    this.u = -1;
                }
                if (!(this.t == null || this.t.isRecycled())) {
                    this.u = af.a(this.t, -1, false);
                }
                this.c = false;
            }
        }
    }

    public float b(float f) {
        return 1.0f / f;
    }

    protected float[] a(float[] fArr, int i) {
        if (i == (this.C + 270) % 360) {
            return new float[]{fArr[4], fArr[5], fArr[0], fArr[1], fArr[6], fArr[7], fArr[2], fArr[3]};
        } else if (i == (this.C + 180) % 360) {
            return new float[]{fArr[6], fArr[7], fArr[4], fArr[5], fArr[2], fArr[3], fArr[0], fArr[1]};
        } else if (i == (this.C + 90) % 360) {
            return new float[]{fArr[2], fArr[3], fArr[6], fArr[7], fArr[0], fArr[1], fArr[4], fArr[5]};
        } else {
            return new float[]{fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]};
        }
    }

    public static PointF a(float f, float f2, PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        pointF3.x = (pointF.x + ((pointF2.x - pointF.x) * f)) + ((pointF2.y - pointF.y) * (-f2));
        pointF3.y = (pointF.y + ((pointF2.x - pointF.x) * f2)) + ((pointF2.y - pointF.y) * f);
        return pointF3;
    }

    public static PointF a(PointF pointF) {
        return new PointF(pointF.x, 1.0f - pointF.y);
    }

}
