package com.het.facesdk.makeup.matrix;

import android.opengl.GLES30;

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


    public BiMatrix(int textureId) {
        super(textureId, VERTEX_SHADER_GLSL, FRAG_SHADER_GLSL);
    }



    @Override
    public void onSurfaceCreated() {

    }

    @Override
    public void onFinishInit() {
        super.onFinishInit();
    }

    @Override
    public void onBindTexture() {
        super.onBindTexture();
    }

    private float mDistanceNormalizationFactor;
    private int mDisFactorLocation;
    private int mSingleStepOffsetLocation;
    private int mTextureLocation;

//    public void setDistanceNormalizationFactor(final float newValue) {
//        mDistanceNormalizationFactor = newValue;
//        setFloat(mDisFactorLocation, newValue);
//    }
//
//    private void setTexelSize(final float w, final float h) {
//        GLES30.glUseProgram(program);
//        setFloatVec2(mSingleStepOffsetLocation, new float[]{1.0f / w, 1.0f / h});
//    }
//
//    private void setInt(final int location, final int value) {
//        GLES30.glUseProgram(program);
//        GLES30.glUniform1i(location, value);
//    }
//
//    private void setFloat(final int location, final float floatValue) {
//        GLES30.glUseProgram(program);
//        GLES30.glUniform1f(location, floatValue);
//    }
//
//    private void setFloatVec2(final int location, final float[] arrayValue) {
//        GLES30.glUseProgram(program);
//        GLES30.glUniform2fv(location, 1, FloatBuffer.wrap(arrayValue));
//    }

}
