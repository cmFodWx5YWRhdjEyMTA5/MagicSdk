package com.cyberlink.youcammakeup.jniproxy;

public enum UIImageFormat {
    FORMAT_UNKNOWN,
    FORMAT_JPEG,
    FORMAT_TIFF,
    FORMAT_RAW,
    FORMAT_ARGB,
    FORMAT_PNG,
    FORMAT_BMP;
    
    private final int swigValue = 0;

    public final int a() {
        return this.swigValue;
    }

    public static UIImageFormat a(int i) {
        UIImageFormat[] uIImageFormatArr = (UIImageFormat[]) UIImageFormat.class.getEnumConstants();
        if (i < uIImageFormatArr.length && i >= 0 && uIImageFormatArr[i].swigValue == i) {
            return uIImageFormatArr[i];
        }
        for (UIImageFormat uIImageFormat : uIImageFormatArr) {
            if (uIImageFormat.swigValue == i) {
                return uIImageFormat;
            }
        }
        throw new IllegalArgumentException("No enum " + UIImageFormat.class + " with value " + i);
    }
}
