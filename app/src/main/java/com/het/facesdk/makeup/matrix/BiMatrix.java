package com.het.facesdk.makeup.matrix;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;

import com.het.facesdk.makeup.MakeUpEngine;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class BiMatrix extends CommonMatrix {
    private static final String TAG = BiMatrix.class.getSimpleName();

    public static final String VERTEX_SHADER_GLSL = "#version 300 es\n" +
            "layout(location = 0)  in vec4 position;\n" +
            "layout(location = 1)  in vec4 inputTextureCoordinate;\n" +

            "const int GAUSSIAN_SAMPLES = 9;\n" +

            "uniform vec2 singleStepOffset;\n" +

            "out vec2 textureCoordinate;\n" +
            "out vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n" +

            "void main()\n" +
            "{\n" +
            "	gl_Position = position;\n" +
            "	textureCoordinate = inputTextureCoordinate.xy;\n" +

            "	int multiplier = 0;\n" +
            "	vec2 blurStep;\n" +

            "	for (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n" +
            "	{\n" +
            "		multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n" +

            "		blurStep = float(multiplier) * singleStepOffset;\n" +
            "		blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n" +
            "	}\n" +
            "}";

    public static final String FRAG_SHADER_GLSL = "#version 300 es\n" +
            " uniform sampler2D inputImageTexture;\n" +

            " const lowp int GAUSSIAN_SAMPLES = 9;\n" +

            " in highp vec2 textureCoordinate;\n" +
            " in highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n" +
            " uniform mediump float distanceNormalizationFactor;\n" +
            " out mediump vec4 out_color;\n" +

            " void main()\n" +
            " {\n" +
            "     lowp vec4 centralColor;\n" +
            "     lowp float gaussianWeightTotal;\n" +
            "     lowp vec4 sum;\n" +
            "     lowp vec4 sampleColor;\n" +
            "     lowp float distanceFromCentralColor;\n" +
            "     lowp float gaussianWeight;\n" +
            "     \n" +
            "     centralColor = texture(inputImageTexture, blurCoordinates[4]);\n" +
            "     gaussianWeightTotal = 0.18;\n" +
            "     sum = centralColor * 0.18;\n" +
            "     \n" +
            "     sampleColor = texture(inputImageTexture, blurCoordinates[0]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +

            "     sampleColor = texture(inputImageTexture, blurCoordinates[1]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.09 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +

            "     sampleColor = texture(inputImageTexture, blurCoordinates[2]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +

            "     sampleColor = texture(inputImageTexture, blurCoordinates[3]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.15 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +

            "     sampleColor = texture(inputImageTexture, blurCoordinates[5]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.15 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +

            "     sampleColor = texture(inputImageTexture, blurCoordinates[6]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +

            "     sampleColor = texture(inputImageTexture, blurCoordinates[7]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.09 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +

            "     sampleColor = texture(inputImageTexture, blurCoordinates[8]);\n" +
            "     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n" +
            "     gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n" +
            "     gaussianWeightTotal += gaussianWeight;\n" +
            "     sum += sampleColor * gaussianWeight;\n" +
            "     out_color = sum / gaussianWeightTotal;\n" +
//			" gl_FragColor.r = distanceNormalizationFactor / 20.0;" +
            " }";


    private float[] vertexs = new float[]{
            1.0f, 1.0f, 1.0f, 1.0f,
            -1.0f, 1.0f, 0.0f, 1.0f,
            -1.0f, -1.0f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
            -1.0f, -1.0f, 0.0f, 0.0f,
            1.0f, -1.0f, 1.0f, 0.0f
    };

    private int program;
    private int vertexShaderId;
    private int fragShaderId;
    int[] vao = new int[1];
    int[] vbo = new int[1];


    public BiMatrix(int textureId) {
        super(textureId);
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

        mDisFactorLocation = GLES30.glGetUniformLocation(program, "distanceNormalizationFactor");
        mSingleStepOffsetLocation = GLES20.glGetUniformLocation(program, "singleStepOffset");
        mTextureLocation = GLES30.glGetUniformLocation(program, "inputImageTexture");


    }


    private void createVBO() {

        GLES30.glUseProgram(program);
        vao = new int[1];
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

        GLES30.glBindVertexArray(0);
    }

    @Override
    public void draw() {
        GLES30.glUseProgram(program);

        GLES30.glBindVertexArray(vao[0]);
        GLES30.glActiveTexture(GLES30.GL_TEXTURE1);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, textureId());

        setInt(mTextureLocation, 1);
        setDistanceNormalizationFactor(8.0f);

        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, 0, 6);
    }

    @Override
    public void onSurfaceChanged(int w, int h) {
        setTexelSize(w, h);
    }

    @Override
    public void onSurfaceCreated() {

    }


    private float mDistanceNormalizationFactor;
    private int mDisFactorLocation;
    private int mSingleStepOffsetLocation;
    private int mTextureLocation;

    public void setDistanceNormalizationFactor(final float newValue) {
        mDistanceNormalizationFactor = newValue;
        setFloat(mDisFactorLocation, newValue);
    }

    private void setTexelSize(final float w, final float h) {
        GLES30.glUseProgram(program);
        setFloatVec2(mSingleStepOffsetLocation, new float[]{1.0f / w, 1.0f / h});
    }

    private void setInt(final int location, final int value) {
        GLES30.glUseProgram(program);
        GLES30.glUniform1i(location, value);
    }

    private void setFloat(final int location, final float floatValue) {
        GLES30.glUseProgram(program);
        GLES30.glUniform1f(location, floatValue);
    }

    private void setFloatVec2(final int location, final float[] arrayValue) {
        GLES30.glUseProgram(program);
        GLES30.glUniform2fv(location, 1, FloatBuffer.wrap(arrayValue));
    }

}
