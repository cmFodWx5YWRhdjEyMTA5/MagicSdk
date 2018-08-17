package com.het.facesdk.makeup.matrix;

import android.opengl.GLES20;

import com.het.facesdk.utils.OpenGlUtil;

/**
 * 美白
 *
 * @author galis
 */
public class BeautyMatrix extends CommonMatrix {

    private int gHaaCoef;
    private int gHmixCoef;
    private int gHiternum;
    private int gHWidth;
    private int gHHeight;

    private float aaCoef;
    private float mixCoef;
    private int iternum;

    private int mWidth = 720;
    private int mHeight = 1280;


    public BeautyMatrix(int textureId) {
        super(textureId,
                OpenGlUtil.file2Glsl("beauty/beauty.vert"),
                OpenGlUtil.file2Glsl("beauty/beauty.frag"));
    }

    @Override
    public void onFinishInit() {
        super.onFinishInit();
        gHaaCoef = uniformLocation("aaCoef");
        gHmixCoef = uniformLocation("mixCoef");
        gHiternum = uniformLocation("iternum");
        gHWidth = uniformLocation("mWidth");
        gHHeight = uniformLocation("mHeight");
        setFlag(0);

    }

    @Override
    public void onBindTexture() {
        super.onBindTexture();
        GLES20.glUniform1i(gHWidth, mWidth);
        GLES20.glUniform1i(gHHeight, mHeight);
        GLES20.glUniform1f(gHaaCoef, aaCoef);
        GLES20.glUniform1f(gHmixCoef, mixCoef);
        GLES20.glUniform1i(gHiternum, iternum);
    }

    @Override
    public void onSurfaceChanged(int w, int h) {
        super.onSurfaceChanged(w, h);
        this.mWidth = w;
        this.mHeight = h;
    }

    public void setFlag(int flag) {
        switch (flag) {
            case 1:
                a(1, 0.19f, 0.54f);
                break;
            case 2:
                a(2, 0.29f, 0.54f);
                break;
            case 3:
                a(3, 0.17f, 0.39f);
                break;
            case 4:
                a(3, 0.25f, 0.54f);
                break;
            case 5:
                a(4, 0.13f, 0.54f);
                break;
            case 6:
                a(4, 0.19f, 0.69f);
                break;
            default:
                a(0, 0f, 0f);
                break;
        }
    }

    private void a(int a, float b, float c) {
        this.iternum = a;
        this.aaCoef = b;
        this.mixCoef = c;
    }


    @Override
    public void control(int progress) {
        setFlag(progress/20+1);
    }
}
