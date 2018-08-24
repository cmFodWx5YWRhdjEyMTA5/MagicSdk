package com.cyberlink.clgpuimage;

import android.graphics.PointF;

public class BlushRect {

    public float l;
    public float t;
    public float r;
    public float b;

    public float width() {
        return r - l;
    }

    public float height() {
        return b - t;
    }

    public void c() {
        l = Float.MAX_VALUE;
        t = Float.MAX_VALUE;
        r = Float.MIN_VALUE;
        b = Float.MIN_VALUE;
    }

    public void a(PointF pointF) {
        l = Math.min(l, pointF.x);
        t = Math.min(t, pointF.y);
        r = Math.max(r, pointF.x);
        b = Math.max(b, pointF.y);
    }
}
