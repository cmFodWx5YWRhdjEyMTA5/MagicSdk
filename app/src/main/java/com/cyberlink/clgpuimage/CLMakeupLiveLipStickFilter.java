package com.cyberlink.clgpuimage;
import com.het.facesdk.utils.OpenGlUtils;

/**
 * 唇彩Filter
 */
public class CLMakeupLiveLipStickFilter extends GPUImageFilter {

    public CLMakeupLiveLipStickFilter() {
        super(OpenGlUtils.file2Glsl("face/mouth.vert"),
                OpenGlUtils.file2Glsl("face/mouth.frag"));
    }

    public enum BlendMode {
        THICK,
        BRIGHT,
        GLOSS
    }

    public class LipStickProfile {
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

    public class LipstickData {
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

        public void AllocByteArray(int i, int i2) {
            if (this.m_mask_width != i || this.m_mask_height != i2) {
                this.m_mask_width = i;
                this.m_mask_height = i2;
                this.m_mouth_mask_data = new byte[(i * i2)];
                this.m_reflection_data = new byte[(i * i2)];
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
