package com.cyberlink.youcammakeup.jniproxy;

public enum UIImageOrientation {
    ImageUnknownOrientation(0),
    ImageRotate0(1),
    ImageFlipHorizontal(2),
    ImageRotate180(3),
    ImageFlipVertical(4),
    ImageRotate90AndFlipHorizontal(5),
    ImageRotate90(6),
    ImageRotate270AndFlipHorizontal(7),
    ImageRotate270(8);
    
    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    public static UIImageOrientation a(int i) {
        UIImageOrientation[] uIImageOrientationArr = (UIImageOrientation[]) UIImageOrientation.class.getEnumConstants();
        if (i < uIImageOrientationArr.length && i >= 0 && uIImageOrientationArr[i].swigValue == i) {
            return uIImageOrientationArr[i];
        }
        for (UIImageOrientation uIImageOrientation : uIImageOrientationArr) {
            if (uIImageOrientation.swigValue == i) {
                return uIImageOrientation;
            }
        }
        throw new IllegalArgumentException("No enum " + UIImageOrientation.class + " with value " + i);
    }

    private UIImageOrientation(int i) {
        this.swigValue = i;
        UIImageOrientationCache.a = i + 1;
    }
}
