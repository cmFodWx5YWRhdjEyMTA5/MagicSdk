package com.cyberlink.youcammakeup.jniproxy;

public enum PixelFormat {
    Format32bppRGBA(0),
    Format32bppBGRA(1),
    Format64bppRGBA(2),
    Format64bppBGRA(3);
    
    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    public static PixelFormat a(int i) {
        PixelFormat[] pixelFormatArr = (PixelFormat[]) PixelFormat.class.getEnumConstants();
        if (i < pixelFormatArr.length && i >= 0 && pixelFormatArr[i].swigValue == i) {
            return pixelFormatArr[i];
        }
        for (PixelFormat pixelFormat : pixelFormatArr) {
            if (pixelFormat.swigValue == i) {
                return pixelFormat;
            }
        }
        throw new IllegalArgumentException("No enum " + PixelFormat.class + " with value " + i);
    }

    private PixelFormat(int i) {
        this.swigValue = i;
        PixelFormatCache.a = i + 1;
    }
}
