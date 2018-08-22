package com.cyberlink.youcammakeup.jniproxy;

public enum UIThumbnailType {
    THUMBNAIL_UNDEFINED,
    THUMBNAIL_JPEG,
    THUMBNAIL_UNCOMPRESSED_BUFFER;
    
    private final int swigValue = 0;

    public static UIThumbnailType a(int i) {
        UIThumbnailType[] uIThumbnailTypeArr = (UIThumbnailType[]) UIThumbnailType.class.getEnumConstants();
        if (i < uIThumbnailTypeArr.length && i >= 0 && uIThumbnailTypeArr[i].swigValue == i) {
            return uIThumbnailTypeArr[i];
        }
        for (UIThumbnailType uIThumbnailType : uIThumbnailTypeArr) {
            if (uIThumbnailType.swigValue == i) {
                return uIThumbnailType;
            }
        }
        throw new IllegalArgumentException("No enum " + UIThumbnailType.class + " with value " + i);
    }
}
