package com.het.facesdk.makeup.matrix;

public class PosterizeMatrix extends CommonMatrix {

    private static final String TAG = PosterizeMatrix.class.getSimpleName();

    public static final String POSTERIZE_FRAG_SHADER_GLSL = "# version 300 es\n" +
            "varying highp vec2 textureCoordinate;\n" +
            "\n" +
            "uniform sampler2D inputImageTexture;\n" +
            "uniform highp float colorLevels;\n" +
            "lowp out vec4 out_color;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "   highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n" +
            "   \n" +
            "   out_color = floor((textureColor * colorLevels) + vec4(0.5)) / colorLevels;\n" +
            "}";

    private int mGLUniformColorLevels;
    private int mColorLevels;

    public PosterizeMatrix(int textureId) {
        this(textureId, 10);
    }

    public PosterizeMatrix(int textureId, final int colorLevels) {
        super(textureId, DEFAULT_VERTEX_SHADER_GLSL, DEFAULT_FRAG_SHADER_GLSL);
        mColorLevels = colorLevels;
    }


    @Override
    public void onFinishInit() {
        super.onFinishInit();
        mGLUniformColorLevels = uniformLocation("colorLevels");
        setColorLevels(mColorLevels);
    }

    public void setColorLevels(final int colorLevels) {
        mColorLevels = colorLevels;
        setFloat(mGLUniformColorLevels, colorLevels);
    }

}
