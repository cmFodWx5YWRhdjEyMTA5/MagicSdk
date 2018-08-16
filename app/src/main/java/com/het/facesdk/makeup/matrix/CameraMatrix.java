package com.het.facesdk.makeup.matrix;

import android.opengl.GLES11Ext;
import android.opengl.GLES30;

public class CameraMatrix extends CommonMatrix {
    private static final String TAG = CameraMatrix.class.getSimpleName();

    private static final String FRAG_SHADER_GLSL =
            "# version 300 es\n" +
                    "#extension GL_OES_EGL_image_external : require\n" +
                    "precision mediump float;\n" +
                    "uniform samplerExternalOES camera_texture;\n" +
                    "in lowp vec2 rTexture;\n" +
                    "out lowp vec4 out_color;\n" +
                    "void main() {\n" +
                    "   out_color = texture(camera_texture,rTexture);\n" +
//                    "   if(rTexture.x<0.3){ out_color.r = 0.8;}\n" +
//                    "   out_color.r = texture(camera_texture,rTexture);\n" +
//                    "   out_color = vec4(1.0,1.0,0.0,1.0);\n" +
                    "}\n";

    private static float[] CAMERA_VERTEXS = new float[]{
            1.0f, 1.0f, 1.0f, 0.0f,
            -1.0f, 1.0f, 1.0f, 1.0f,
            -1.0f, -1.0f, 0.0f, 1.0f,
            1.0f, 1.0f, 1.0f, 0.0f,
            -1.0f, -1.0f, 0.0f, 1.0f,
            1.0f, -1.0f, 0.0f, 0.0f
    };


    public CameraMatrix(int cameraTextureId) {
        super(cameraTextureId, CAMERA_VERTEXS, DEFAULT_VERTEX_SHADER_GLSL, FRAG_SHADER_GLSL);
    }


    @Override
    public void afterLoadProgram() {

    }


    @Override
    public void onBindTexture() {
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textureId());
        int cameraLocation = uniformLocation("camera_texture");
        GLES30.glUniform1i(cameraLocation, 0);
    }

    @Override
    public void onSurfaceChanged(int w, int h) {

    }

    @Override
    public void onSurfaceCreated() {

    }
}
