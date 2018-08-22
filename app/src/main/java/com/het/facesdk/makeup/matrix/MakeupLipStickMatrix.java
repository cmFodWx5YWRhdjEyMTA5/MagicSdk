package com.het.facesdk.makeup.matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class MakeupLipStickMatrix extends CommonMatrix {
    public MakeupLipStickMatrix(int textureId) {
        super(textureId);
    }

    public MakeupLipStickMatrix(int textureId, String vertexGlsl, String fragGlsl) {
        super(textureId, vertexGlsl, fragGlsl);
    }

    public int blendWeightTextureLocation;
    public int texture_2 = -1;
    public int blendWeigthTextureLocation;
    public int texture_3 = -1;
    public int levelMapTextureLocation;
    public int inputLipstickTextureCoordLocation;
    public int centerXLocation;
    public int centerYLocation;
    public int lipstickWidthLocation;
    public int lipstickHeightLocation;
    public int backgroundImageWidthLocation;
    public int backgroundImageHeightLocation;
    public int lipstickColorLocation;
    public int glossContrastScaleLocation;
    public int glossContrastShiftLocation;
    public int forceBrightThresholdLocation;
    public float[] sRgb = new float[]{0.0f, 0.0f, 0.0f};
    public float[] T = new float[]{0.0f, 0.0f, 0.0f};
    public int U = 90;
    int width = 0;
    int height = 0;
    int roiX = 0;
    int roiY = 0;
    int roiWidth = 0;
    int roiHeight = 0;
    float g = 0.0f;
    float h = 0.0f;
    float i = 0.0f;
    byte[] m_mouth_mask_data = null;
    byte[] m_reflection_data;
    byte[] m_blend_weight = null;
    byte[] m_level_map = null;
    ByteBuffer mouthMaskDataBuffer = null;
    ByteBuffer refrectDataBuffer = null;
    ByteBuffer blendWeightBuffer = null;
    ByteBuffer levelMapBuffer = null;
    public float m_environment_darkest_reference_normalized_luma = 0.0f;
    public float m_environment_brightest_reference_normalized_luma = 1.0f;
    int m_rotation = 0;
    boolean m_is_flipped = false;
    public final int v = 256;
    public final int w = 1;
    public int texture_0 = -1;
    public int lipstickTextureLocation;
    public int texturen_1 = -1;

    public enum BlendMode {
        THICK,
        BRIGHT,
        GLOSS
    }

    public static class LipStickProfile {
        public BlendMode blend_mode;
        public int color;
        public int level_default;
        public int level_max;

        public LipStickProfile(BlendMode blendMode, int i, int i2, int i3) {
            this.blend_mode = blendMode;
            this.color = i;
            this.level_max = i2;
            this.level_default = i3;
        }
    }

    public static class LipstickData {
        public int m_background_image_height;
        public int m_background_image_width;
        public byte[] m_blend_weight = new byte[256];
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        public int m_force_bright_threshold;
        public float m_gloss_contrast_scale;
        public int m_gloss_contrast_shift;
        public boolean m_is_flipped;
        public byte[] m_level_map = new byte[256];
        public int m_mask_height;
        public int m_mask_width;
        public byte[] m_mouth_mask_data;
        public byte[] m_reflection_data;
        public int m_roi_height;
        public int m_roi_width;
        public int m_roi_x;
        public int m_roi_y;
        public int m_rotation;

        public void AllocByteArray(int width, int height) {
            if (this.m_mask_width != width || this.m_mask_height != height) {
                this.m_mask_width = width;
                this.m_mask_height = height;
                this.m_mouth_mask_data = new byte[(width * height)];
                this.m_reflection_data = new byte[(width * height)];
            }
        }

        public void Copy(LipstickData lipstickData) {
            if (!(lipstickData.m_mask_width == 0 || lipstickData.m_mask_height == 0)) {
                this.m_mouth_mask_data = (byte[]) lipstickData.m_mouth_mask_data.clone();
                this.m_reflection_data = (byte[]) lipstickData.m_reflection_data.clone();
            }
            this.m_mask_width = lipstickData.m_mask_width;
            this.m_mask_height = lipstickData.m_mask_height;
            this.m_roi_x = lipstickData.m_roi_x;
            this.m_roi_y = lipstickData.m_roi_y;
            this.m_roi_width = lipstickData.m_roi_width;
            this.m_roi_height = lipstickData.m_roi_height;
            this.m_background_image_width = lipstickData.m_background_image_width;
            this.m_background_image_height = lipstickData.m_background_image_height;
            this.m_gloss_contrast_scale = lipstickData.m_gloss_contrast_scale;
            this.m_gloss_contrast_shift = lipstickData.m_gloss_contrast_shift;
            this.m_force_bright_threshold = lipstickData.m_force_bright_threshold;
            this.m_blend_weight = (byte[]) lipstickData.m_blend_weight.clone();
            this.m_level_map = (byte[]) lipstickData.m_level_map.clone();
            this.m_environment_darkest_reference_normalized_luma = lipstickData.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = lipstickData.m_environment_brightest_reference_normalized_luma;
            this.m_rotation = lipstickData.m_rotation;
            this.m_is_flipped = lipstickData.m_is_flipped;
        }
    }


}
