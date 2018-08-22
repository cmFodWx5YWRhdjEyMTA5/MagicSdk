package com.cyberlink.youcammakeup.jniproxy;

public enum UIExifColorSpace {
    COLOR_SPACE_NONE,
    COLOR_SPACE_SRGB,
    COLOR_SPACE_PROPHOTO,
    COLOR_SPACE_AdobeRGB,
    COLOR_SPACE_CUSTOM;
    
    private final int swigValue = 0 ;

    public final int a() {
        return this.swigValue;
    }

    public static UIExifColorSpace a(int i) {
        UIExifColorSpace[] uIExifColorSpaceArr = (UIExifColorSpace[]) UIExifColorSpace.class.getEnumConstants();
        if (i < uIExifColorSpaceArr.length && i >= 0 && uIExifColorSpaceArr[i].swigValue == i) {
            return uIExifColorSpaceArr[i];
        }
        for (UIExifColorSpace uIExifColorSpace : uIExifColorSpaceArr) {
            if (uIExifColorSpace.swigValue == i) {
                return uIExifColorSpace;
            }
        }
        throw new IllegalArgumentException("No enum " + UIExifColorSpace.class + " with value " + i);
    }
}
