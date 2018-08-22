package com.cyberlink.youcammakeup.jniproxy;

public enum UIInterpolation {
    DEFAULT(0),
    BILINEAR(1),
    BICUBIC(2),
    LANCZOS(3),
    SUPER(4);

    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    private UIInterpolation(int i) {
        this.swigValue = i;
        UIInterpolationCache.a = i + 1;
    }
}
