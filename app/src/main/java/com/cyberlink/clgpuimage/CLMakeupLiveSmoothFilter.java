package com.cyberlink.clgpuimage;


/**
 * 美颜滤镜
 * @author galis
 */
public class CLMakeupLiveSmoothFilter extends CLBeautyFilterBasicWithTwoPassBlendSource2 {

    public static class LiveSmoothMetadata {
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        public float m_intensity;

        public void Copy(LiveSmoothMetadata liveSmoothMetadata) {
            this.m_environment_darkest_reference_normalized_luma = liveSmoothMetadata.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = liveSmoothMetadata.m_environment_brightest_reference_normalized_luma;
            this.m_intensity = liveSmoothMetadata.m_intensity;
        }
    }
}
