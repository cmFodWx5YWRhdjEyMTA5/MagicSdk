package com.het.facesdk.makeup.matrix;

public class BrightnessMatrix extends CommonMatrix {


    public static final String BRIGHTNESS_FRAGMENT_SHADER = "" +
            " in highp vec2 textureCoordinate;\n" +
            " \n" +
            " uniform sampler2D inputImageTexture;\n" +
            " uniform lowp float brightness;\n" +
            " out lowp vec4 out_color;\n" +
            " \n" +
            " void main()\n" +
            " {\n" +
            "     lowp vec4 textureColor = texture(inputImageTexture, textureCoordinate);\n" +
            "     \n" +
            "     out_color = vec4((textureColor.rgb + vec3(brightness)), textureColor.w);\n" +
            " }";

    private int mBrightnessLocation;
    private float mBrightness;


    public BrightnessMatrix(int textureId) {
        this(textureId, 0.0f);
    }

    public BrightnessMatrix(int textureId, float brightness) {
        super(textureId, DEFAULT_VERTEX_SHADER_GLSL, BRIGHTNESS_FRAGMENT_SHADER);
        setBrightness(brightness);
    }

    @Override
    public void onFinishInit() {
        super.onFinishInit();
        mBrightnessLocation = uniformLocation("brightness");
    }

    public void setBrightness(final float brightness) {
        mBrightness = brightness;
        setFloat(mBrightnessLocation, mBrightness);
    }
}
