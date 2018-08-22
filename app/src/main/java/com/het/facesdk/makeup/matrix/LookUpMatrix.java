package com.het.facesdk.makeup.matrix;

import android.opengl.GLES30;

import com.het.facesdk.utils.OpenGlUtils;

/**
 * 默认GL_TEXTURE10
 * 没其他意思.简单分开来
 */
public class LookUpMatrix extends CommonMatrix {
    private static final String TAG = LookUpMatrix.class.getSimpleName();


    private int mHMaskImage;
    private int mHIntensity;

    private float intensity;

    private static int[] maskTextures = new int[1];

    public LookUpMatrix(int textureId) {
        super(textureId,
                OpenGlUtils.file2Glsl("lookup/lookup.vert"),
                OpenGlUtils.file2Glsl("lookup/lookup.frag"));
    }

//    public static final float[] LOOKUP_VERTEXS = new float[]{
//            1.0f, 1.0f, 1.0f, 0.0f,
//            -1.0f, 1.0f, 0.0f, 1.0f,
//            -1.0f, -1.0f, 0.0f, 0.0f,
//            1.0f, 1.0f, 1.0f, 0.0f,
//            -1.0f, -1.0f, 1.0f, 1.0f,
//            1.0f, -1.0f, 0.0f, 1.0f
//    };


    @Override
    public void onSurfaceChanged(int w, int h) {
        super.onSurfaceChanged(w, h);
    }

    @Override
    public void onFinishInit() {
        super.onFinishInit();
        mHMaskImage = uniformLocation("maskTexture");
        mHIntensity = uniformLocation("intensity");
        setUpMask();
    }

    @Override
    public void onPreDraw() {
        super.onPreDraw();
        GLES30.glActiveTexture(GLES30.GL_TEXTURE10);//As mask
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, maskTextures[0]);
        GLES30.glUniform1f(mHIntensity, intensity);
    }

    public void setIntensity(float value) {
        this.intensity = value;
    }

    private void setUpMask() {
        GLES30.glActiveTexture(GLES30.GL_TEXTURE10);//As mask
        GLES30.glGenTextures(1, maskTextures, 0);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, maskTextures[0]);
        OpenGlUtils.useTexParameter();
        OpenGlUtils.texImage2D("lookup/purity.png");
        GLES30.glUniform1i(mHMaskImage, 10);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, 0);
    }

    @Override
    public void control(int progress) {
        setIntensity(progress / 100.f);
    }
}
