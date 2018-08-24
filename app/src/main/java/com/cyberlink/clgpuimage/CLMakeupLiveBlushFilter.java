package com.cyberlink.clgpuimage;

import android.graphics.PointF;

public class CLMakeupLiveBlushFilter extends GPUImageFilter {


    public static class LiveBlushMakeupdata {
        public PointF m_center = new PointF();
        public float m_cos_val;
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        public boolean m_is_flipped;
        public BlushRect m_left_blush_roi = new BlushRect();
        public BlushRect m_right_blush_roi = new BlushRect();
        public int m_rotation;
        public float m_sin_val;

        public void SetBlushFeaturePts(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8, PointF pointF9, PointF pointF10) {
            ComputeData(CLMakeupLiveBlushFilter.a(pointF), CLMakeupLiveBlushFilter.a(pointF2), CLMakeupLiveBlushFilter.a(pointF3), CLMakeupLiveBlushFilter.a(pointF4), CLMakeupLiveBlushFilter.a(pointF5), CLMakeupLiveBlushFilter.a(pointF6), CLMakeupLiveBlushFilter.a(pointF7), CLMakeupLiveBlushFilter.a(pointF8), CLMakeupLiveBlushFilter.a(pointF9), CLMakeupLiveBlushFilter.a(pointF10));
        }

        public void ComputeData(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8, PointF pointF9, PointF pointF10) {
            double atan2 = Math.atan2((double) (pointF10.y - pointF5.y), (double) (pointF10.x - pointF5.x));
            this.m_cos_val = (float) Math.cos(-atan2);
            this.m_sin_val = (float) Math.sin(-atan2);
            this.m_center.x = (pointF2.x + pointF7.x) * 0.5f;
            this.m_center.y = (pointF2.y + pointF7.y) * 0.5f;
            this.m_left_blush_roi.c();
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF2));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF3));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF4));
            this.m_left_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF5));
            this.m_right_blush_roi.c();
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF6));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF7));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF8));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF9));
            this.m_right_blush_roi.a(CLMakeupLiveBlushFilter.a(this.m_cos_val, this.m_sin_val, this.m_center, pointF10));
        }

        public void Copy(LiveBlushMakeupdata liveBlushMakeupdata) {
            this.m_cos_val = liveBlushMakeupdata.m_cos_val;
            this.m_sin_val = liveBlushMakeupdata.m_sin_val;
            this.m_center.x = liveBlushMakeupdata.m_center.x;
            this.m_center.y = liveBlushMakeupdata.m_center.y;
            this.m_left_blush_roi.l = liveBlushMakeupdata.m_left_blush_roi.l;
            this.m_left_blush_roi.r = liveBlushMakeupdata.m_left_blush_roi.r;
            this.m_left_blush_roi.t = liveBlushMakeupdata.m_left_blush_roi.t;
            this.m_left_blush_roi.b = liveBlushMakeupdata.m_left_blush_roi.b;
            this.m_right_blush_roi.l = liveBlushMakeupdata.m_right_blush_roi.l;
            this.m_right_blush_roi.r = liveBlushMakeupdata.m_right_blush_roi.r;
            this.m_right_blush_roi.t = liveBlushMakeupdata.m_right_blush_roi.t;
            this.m_right_blush_roi.b = liveBlushMakeupdata.m_right_blush_roi.b;
            this.m_environment_darkest_reference_normalized_luma = liveBlushMakeupdata.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = liveBlushMakeupdata.m_environment_brightest_reference_normalized_luma;
            this.m_rotation = liveBlushMakeupdata.m_rotation;
            this.m_is_flipped = liveBlushMakeupdata.m_is_flipped;
        }
    }


    public static PointF a(float f, float f2, PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        pointF3.x = (pointF.x + ((pointF2.x - pointF.x) * f)) + ((pointF2.y - pointF.y) * (-f2));
        pointF3.y = (pointF.y + ((pointF2.x - pointF.x) * f2)) + ((pointF2.y - pointF.y) * f);
        return pointF3;
    }

    public static PointF a(PointF pointF) {
        return new PointF(pointF.x, 1.0f - pointF.y);
    }

}
