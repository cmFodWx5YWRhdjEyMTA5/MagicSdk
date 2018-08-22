package com.cyberlink.youcammakeup.jniproxy;

public enum UIBytePerPixel {
    PIXEL_4BYTE(4),
    PIXEL_8BYTE(8);
    
    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    private UIBytePerPixel(int i) {
        this.swigValue = i;
        UIBytePerPixelCache.a = i + 1;
    }
}
