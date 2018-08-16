package com.het.facesdk.makeup.matrix;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLES30;

import com.het.facesdk.makeup.MakeUpEngine;
import com.het.facesdk.utils.OpenGlUtil;

public class CommonMatrix implements MakeUpEngine.IMatrix {

    private int mTextureId;
    private int mProgram;
    private int mVao;
    private int mTextureLocation;

    public static final String DEFAULT_VERTEX_SHADER_GLSL = "# version 300 es\n" +
            "layout (location = 0) in vec4 vPosition; \n" +
            "layout (location = 1) in vec2 vTexture; \n" +
            "out vec2 textureCoordinate; \n" +
            "void main() { \n" +
            "   gl_Position = vPosition; \n" +
            "   textureCoordinate = vTexture; \n" +
            "}\n";

    public static final String DEFAULT_FRAG_SHADER_GLSL =
            "# version 300 es\n" +
                    "precision mediump float;\n" +
                    "uniform sampler2D inputImageTexture;\n" +
                    "in lowp vec2 textureCoordinate;\n" +
                    "out lowp vec4 out_color;\n" +
                    "void main() {\n" +
                    "   out_color = texture(inputImageTexture,textureCoordinate);\n" +
//                    "   out_color = vec4(1.0,1.0,0.0,1.0);\n" +
                    "}\n";


    public static final float[] DEFAULT_VERTEXS = new float[]{
            1.0f, 1.0f, 1.0f, 1.0f,
            -1.0f, 1.0f, 0.0f, 1.0f,
            -1.0f, -1.0f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
            -1.0f, -1.0f, 0.0f, 0.0f,
            1.0f, -1.0f, 1.0f, 0.0f
    };

    public CommonMatrix(int textureId) {
        this(textureId, DEFAULT_VERTEXS);
    }

    public CommonMatrix(int textureId, String vertexGlsl, String fragGlsl) {
        this(textureId, DEFAULT_VERTEXS, vertexGlsl, fragGlsl);
    }


    public CommonMatrix(int textureId, float[] vertexs) {
        this(textureId, vertexs, DEFAULT_VERTEX_SHADER_GLSL, DEFAULT_FRAG_SHADER_GLSL);
    }

    public CommonMatrix(int textureId, float[] vertexs, String vertexGlsl, String fragGlsl) {
        mProgram = OpenGlUtil.loadProgram(vertexGlsl, fragGlsl);
        mVao = OpenGlUtil.genVAO(vertexs);
        mTextureId = textureId;
        onFinishInit();
    }

    @Override
    public int textureId() {
        return mTextureId;
    }

    @Override
    public void draw() {
        GLES30.glUseProgram(mProgram);
        GLES30.glBindVertexArray(mVao);
        onBindTexture();
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, 6);
        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, 0);
    }

    @Override
    public void onSurfaceChanged(int w, int h) {
        GLES30.glViewport(0, 0, w, h);
    }

    @Override
    public void onSurfaceCreated() {

    }

    public void onFinishInit() {
        mTextureLocation = uniformLocation("inputImageTexture");
    }

    public void onBindTexture() {
        GLES30.glActiveTexture(GLES30.GL_TEXTURE1);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, textureId());
        GLES30.glUniform1i(mTextureLocation, 1);
    }

    public int uniformLocation(String location) {
        return GLES30.glGetUniformLocation(mProgram, location);
    }

    protected void setInteger(final int location, final int intValue) {
        GLES30.glUseProgram(mProgram);
        GLES30.glUniform1i(location, intValue);
    }

    protected void setFloat(final int location, final float floatValue) {
        GLES30.glUseProgram(mProgram);
        GLES30.glUniform1f(location, floatValue);
    }
}
