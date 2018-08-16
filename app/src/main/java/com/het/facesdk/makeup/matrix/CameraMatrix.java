package com.het.facesdk.makeup.matrix;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;

import com.het.facesdk.makeup.MakeUpEngine;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class CameraMatrix extends CommonMatrix {
    private static final String TAG = CameraMatrix.class.getSimpleName();

    private static final String VERTEX_SHADER_GLSL = "# version 300 es\n" +
            "layout (location = 0) in vec4 vPosition; \n" +
            "layout (location = 1) in vec2 vTexture; \n" +
            "out vec2 rTexture; \n" +
            "void main() { \n" +
            "   gl_Position = vPosition; \n" +
            "   rTexture = vTexture; \n" +
            "}\n";

    private static final String FRAG_SHADER_GLSL =
            "# version 300 es\n" +
                    "#extension GL_OES_EGL_image_external : require\n" +
                    "precision mediump float;\n" +
                    "uniform samplerExternalOES camera_texture;\n" +
                    "in lowp vec2 rTexture;\n" +
                    "out lowp vec4 out_color;\n" +
                    "void main() {\n" +
                    "   out_color = texture(camera_texture,rTexture);\n" +
                    "   if(rTexture.x<0.3){ out_color.r = 0.8;}\n" +
//                    "   out_color.r = texture(camera_texture,rTexture);\n" +
//                    "   out_color = vec4(1.0,1.0,0.0,1.0);\n" +
                    "}\n";


    private float[] vertexs = new float[]{
            1.0f, 1.0f, 1.0f, 0.0f,
            -1.0f, 1.0f, 1.0f, 1.0f,
            -1.0f, -1.0f, 0.0f, 1.0f,
            1.0f, 1.0f, 1.0f, 0.0f,
            -1.0f, -1.0f, 0.0f, 1.0f,
            1.0f, -1.0f, 0.0f, 0.0f
    };

    private int maskTextureId;
    private int program;
    private int vertexShaderId;
    private int fragShaderId;


    public CameraMatrix(int cameraTextureId) {
        super(cameraTextureId);
        createShader();
        createVBO();
    }


    private void createShader() {

        program = GLES30.glCreateProgram();

        vertexShaderId = GLES30.glCreateShader(GLES30.GL_VERTEX_SHADER);
        GLES30.glShaderSource(vertexShaderId, VERTEX_SHADER_GLSL);
        GLES30.glCompileShader(vertexShaderId);
        int[] result = new int[1];
        GLES30.glGetShaderiv(vertexShaderId, GLES30.GL_COMPILE_STATUS, result, 0);
        if (result[0] == 0) {
            Log.d(TAG, GLES30.glGetShaderInfoLog(vertexShaderId) + "");
            GLES30.glDeleteShader(vertexShaderId);
            return;
        }
        GLES30.glAttachShader(program, vertexShaderId);


        fragShaderId = GLES30.glCreateShader(GLES30.GL_FRAGMENT_SHADER);
        GLES30.glShaderSource(fragShaderId, FRAG_SHADER_GLSL);
        GLES30.glCompileShader(fragShaderId);

        GLES30.glGetShaderiv(fragShaderId, GLES30.GL_COMPILE_STATUS, result, 0);
        if (result[0] == 0) {
            Log.d(TAG, GLES30.glGetShaderInfoLog(fragShaderId) + "");
            GLES30.glDeleteShader(fragShaderId);
            return;
        }

        GLES30.glAttachShader(program, fragShaderId);
        GLES30.glLinkProgram(program);
        GLES30.glGetProgramiv(program, GLES30.GL_LINK_STATUS, result, 0);
        if (result[0] == 0) {
            Log.d(TAG, GLES30.glGetProgramInfoLog(program) + "");
            GLES30.glDeleteProgram(program);
            return;
        }


    }


    int[] vao = new int[1];
    int[] vbo = new int[1];

    private void createVBO() {

        GLES30.glUseProgram(program);
        GLES30.glGenVertexArrays(1, vao, 0);
        GLES30.glBindVertexArray(vao[0]);

        FloatBuffer vertexBuffer = ByteBuffer.allocateDirect(vertexs.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        vertexBuffer.put(vertexs);
        vertexBuffer.position(0);
        GLES30.glGenBuffers(1, vbo, 0);
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, vbo[0]);
        GLES30.glBufferData(GLES30.GL_ARRAY_BUFFER, vertexs.length * 4, vertexBuffer, GLES30.GL_STATIC_DRAW);
        GLES30.glVertexAttribPointer(0, 2, GLES20.GL_FLOAT, false, 16, 0);
        GLES30.glEnableVertexAttribArray(0);
        GLES30.glVertexAttribPointer(1, 2, GLES20.GL_FLOAT, false, 16, 8);
        GLES30.glEnableVertexAttribArray(1);


        int error = GLES30.glGetError();
        if (error != GLES30.GL_NO_ERROR) {
            Log.d(TAG, error + "");
            return;
        }

        int cameraLocation = GLES30.glGetUniformLocation(program, "camera_texture");
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textureId());
        GLES30.glUniform1i(cameraLocation, 0);
        GLES30.glBindVertexArray(0);

    }

    @Override
    public void draw() {
        GLES30.glUseProgram(program);
        GLES30.glBindVertexArray(vao[0]);
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, 6);
    }
}
