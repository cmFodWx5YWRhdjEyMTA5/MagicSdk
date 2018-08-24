package com.cyberlink.clgpuimage;

import android.graphics.PointF;

public class CLMakeupLiveEyeFilter extends GPUImageFilter {


    public static class LiveEyeMakeupMetadata {
        int m_analyzing_frame_height;
        int m_analyzing_frame_width;
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        PointF[] m_eye_points = new PointF[4];
        public boolean m_is_flipped;
        public EyeMode m_mode;
        PointF[] m_oriented_eye_centers;
        PointF[] m_oriented_eye_points;
        float[] m_parabolic_polar_transform_bottom_left_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_left_dst_center;
        float[] m_parabolic_polar_transform_bottom_left_src_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_left_src_center;
        float[] m_parabolic_polar_transform_bottom_right_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_right_dst_center;
        float[] m_parabolic_polar_transform_bottom_right_src_aligned_coeff;
        PointF m_parabolic_polar_transform_bottom_right_src_center;
        float[] m_parabolic_polar_transform_top_left_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_top_left_dst_center;
        float[] m_parabolic_polar_transform_top_left_src_aligned_coeff;
        PointF m_parabolic_polar_transform_top_left_src_center;
        float[] m_parabolic_polar_transform_top_right_dst_aligned_coeff;
        PointF m_parabolic_polar_transform_top_right_dst_center;
        float[] m_parabolic_polar_transform_top_right_src_aligned_coeff;
        PointF m_parabolic_polar_transform_top_right_src_center;
        public float m_ratio_of_actual_lower_lid_height_to_limited_height;
        public float m_ratio_of_actual_upper_lid_height_to_limited_height;
        public int m_rotation;
        float m_target_eye_lower_lid_luma;
        float m_target_level_orientation_cos;
        float m_target_level_orientation_sin;

        public enum EyeMode {
            NORMAL,
            BLINK
        }

        public LiveEyeMakeupMetadata() {
            int i;
            int i2 = 0;
            for (i = 0; i < 4; i++) {
                this.m_eye_points[i] = new PointF();
            }
            this.m_oriented_eye_points = new PointF[4];
            for (i = 0; i < 4; i++) {
                this.m_oriented_eye_points[i] = new PointF();
            }
            this.m_oriented_eye_centers = new PointF[2];
            while (i2 < 2) {
                this.m_oriented_eye_centers[i2] = new PointF();
                i2++;
            }
            this.m_parabolic_polar_transform_top_left_src_center = new PointF();
            this.m_parabolic_polar_transform_top_left_dst_center = new PointF();
            this.m_parabolic_polar_transform_top_left_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_top_left_dst_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_top_right_src_center = new PointF();
            this.m_parabolic_polar_transform_top_right_dst_center = new PointF();
            this.m_parabolic_polar_transform_top_right_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_top_right_dst_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_left_src_center = new PointF();
            this.m_parabolic_polar_transform_bottom_left_dst_center = new PointF();
            this.m_parabolic_polar_transform_bottom_left_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_right_src_center = new PointF();
            this.m_parabolic_polar_transform_bottom_right_dst_center = new PointF();
            this.m_parabolic_polar_transform_bottom_right_src_aligned_coeff = new float[2];
            this.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff = new float[2];
        }

        public void Copy(LiveEyeMakeupMetadata liveEyeMakeupMetadata) {
            int i;
            int i2 = 0;
            this.m_target_eye_lower_lid_luma = liveEyeMakeupMetadata.m_target_eye_lower_lid_luma;
            this.m_analyzing_frame_width = liveEyeMakeupMetadata.m_analyzing_frame_width;
            this.m_analyzing_frame_height = liveEyeMakeupMetadata.m_analyzing_frame_height;
            this.m_target_level_orientation_cos = liveEyeMakeupMetadata.m_target_level_orientation_cos;
            this.m_target_level_orientation_sin = liveEyeMakeupMetadata.m_target_level_orientation_sin;
            for (i = 0; i < 4; i++) {
                this.m_eye_points[i].x = liveEyeMakeupMetadata.m_eye_points[i].x;
                this.m_eye_points[i].y = liveEyeMakeupMetadata.m_eye_points[i].y;
                this.m_oriented_eye_points[i].x = liveEyeMakeupMetadata.m_oriented_eye_points[i].x;
                this.m_oriented_eye_points[i].y = liveEyeMakeupMetadata.m_oriented_eye_points[i].y;
            }
            for (i = 0; i < 2; i++) {
                this.m_oriented_eye_centers[i].x = liveEyeMakeupMetadata.m_oriented_eye_centers[i].x;
                this.m_oriented_eye_centers[i].y = liveEyeMakeupMetadata.m_oriented_eye_centers[i].y;
            }
            this.m_parabolic_polar_transform_top_left_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_src_center.x;
            this.m_parabolic_polar_transform_top_left_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_src_center.y;
            this.m_parabolic_polar_transform_top_left_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_dst_center.x;
            this.m_parabolic_polar_transform_top_left_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_dst_center.y;
            for (i = 0; i < 2; i++) {
                this.m_parabolic_polar_transform_top_left_src_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_src_aligned_coeff[i];
                this.m_parabolic_polar_transform_top_left_dst_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_left_dst_aligned_coeff[i];
            }
            this.m_parabolic_polar_transform_top_right_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_src_center.x;
            this.m_parabolic_polar_transform_top_right_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_src_center.y;
            this.m_parabolic_polar_transform_top_right_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_dst_center.x;
            this.m_parabolic_polar_transform_top_right_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_dst_center.y;
            for (i = 0; i < 2; i++) {
                this.m_parabolic_polar_transform_top_right_src_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_src_aligned_coeff[i];
                this.m_parabolic_polar_transform_top_right_dst_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_top_right_dst_aligned_coeff[i];
            }
            this.m_parabolic_polar_transform_bottom_left_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_src_center.x;
            this.m_parabolic_polar_transform_bottom_left_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_src_center.y;
            this.m_parabolic_polar_transform_bottom_left_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_dst_center.x;
            this.m_parabolic_polar_transform_bottom_left_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_dst_center.y;
            for (i = 0; i < 2; i++) {
                this.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_src_aligned_coeff[i];
                this.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[i] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_left_dst_aligned_coeff[i];
            }
            this.m_parabolic_polar_transform_bottom_right_src_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_src_center.x;
            this.m_parabolic_polar_transform_bottom_right_src_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_src_center.y;
            this.m_parabolic_polar_transform_bottom_right_dst_center.x = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_dst_center.x;
            this.m_parabolic_polar_transform_bottom_right_dst_center.y = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_dst_center.y;
            while (i2 < 2) {
                this.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[i2] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_src_aligned_coeff[i2];
                this.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[i2] = liveEyeMakeupMetadata.m_parabolic_polar_transform_bottom_right_dst_aligned_coeff[i2];
                i2++;
            }
            this.m_environment_darkest_reference_normalized_luma = liveEyeMakeupMetadata.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = liveEyeMakeupMetadata.m_environment_brightest_reference_normalized_luma;
            this.m_rotation = liveEyeMakeupMetadata.m_rotation;
            this.m_is_flipped = liveEyeMakeupMetadata.m_is_flipped;
            this.m_mode = liveEyeMakeupMetadata.m_mode;
            this.m_ratio_of_actual_upper_lid_height_to_limited_height = liveEyeMakeupMetadata.m_ratio_of_actual_upper_lid_height_to_limited_height;
            this.m_ratio_of_actual_lower_lid_height_to_limited_height = liveEyeMakeupMetadata.m_ratio_of_actual_lower_lid_height_to_limited_height;
        }
    }

    public CLMakeupLiveEyeFilter(boolean isLeft) {
        super();
    }
}
