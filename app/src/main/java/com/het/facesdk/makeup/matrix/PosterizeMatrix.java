package com.het.facesdk.makeup.matrix;

import com.het.facesdk.utils.FilterUtil;

public class PosterizeMatrix extends CommonMatrix {

    private static final String TAG = PosterizeMatrix.class.getSimpleName();

    public static final String POSTERIZE_FRAG_SHADER_GLSL = "# version 300 es\n" +
            "in highp vec2 textureCoordinate;\n" +
            "\n" +
            "uniform sampler2D inputImageTexture;\n" +
            "uniform highp float colorLevels;\n" +
            "out lowp vec4 out_color;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "   highp vec4 textureColor = texture(inputImageTexture, textureCoordinate);\n" +
            "   \n" +
            "   out_color = floor((textureColor * colorLevels) + vec4(0.5)) / colorLevels;\n" +
//            "   out_color = vec4(1.0,1.0,0.0,1.0);\n" +
            "}";

    private int mGLUniformColorLevels;
    private int mColorLevels;

    public PosterizeMatrix(int textureId) {
        this(textureId, 10);
    }

    public PosterizeMatrix(int textureId, final int colorLevels) {
        super(textureId, DEFAULT_VERTEX_SHADER_GLSL, POSTERIZE_FRAG_SHADER_GLSL);
        setColorLevels(colorLevels);
    }


    @Override
    public void onFinishInit() {
        super.onFinishInit();
        mGLUniformColorLevels = uniformLocation("colorLevels");
    }

    public void setColorLevels(final int colorLevels) {
        mColorLevels = colorLevels;
        setFloat(mGLUniformColorLevels, colorLevels);
    }

    @Override
    public void control(int progress) {
        setColorLevels(FilterUtil.range(progress, 1, 50));
    }
}
