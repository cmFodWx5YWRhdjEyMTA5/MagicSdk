package com.het.facesdk.makeup.matrix;

import android.opengl.GLES30;

import com.het.facesdk.utils.OpenGlUtil;

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
                OpenGlUtil.file2Glsl("lookup/lookup.vert"),
                OpenGlUtil.file2Glsl("lookup/lookup.frag"));
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
    public void onBindTexture() {
        super.onBindTexture();
        GLES30.glActiveTexture(GLES30.GL_TEXTURE2);//As mask
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, maskTextures[0]);
        GLES30.glUniform1f(mHIntensity, intensity);
    }

    public void setIntensity(float value) {
        this.intensity = value;
    }

    private void setUpMask() {
        GLES30.glActiveTexture(GLES30.GL_TEXTURE2);//As mask
        GLES30.glGenTextures(1, maskTextures, 0);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, maskTextures[0]);
        OpenGlUtil.useTexParameter();
        OpenGlUtil.texImage2D("lookup/purity.png");
        GLES30.glUniform1i(mHMaskImage, 2);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, 0);
    }


}
