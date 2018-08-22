package com.cyberlink.youcammakeup.jniproxy;

public enum UIImageCodecErrorCode {
    UIIMGCODEC_NOERROR(0),
    UIIMGCODEC_DECODE_ERROR(1),
    UIIMGCODEC_UNSUPPORT_HALF_DECODE(2),
    UIIMGCODEC_DECODE_CANCEL(3),
    UIIMGCODEC_ENCODE_ERROR(4),
    UIIMGCODEC_ENCODE_CANCEL(5),
    UIIMGCODEC_FILE_NOT_FOUND(6),
    UIIMGCODEC_FILE_BEING_USED(7),
    UIIMGCODEC_OUT_OF_MEMORY(8),
    UIIMGCODEC_DISK_FULL(9);
    
    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    public static UIImageCodecErrorCode a(int i) {
        UIImageCodecErrorCode[] uIImageCodecErrorCodeArr = (UIImageCodecErrorCode[]) UIImageCodecErrorCode.class.getEnumConstants();
        if (i < uIImageCodecErrorCodeArr.length && i >= 0 && uIImageCodecErrorCodeArr[i].swigValue == i) {
            return uIImageCodecErrorCodeArr[i];
        }
        for (UIImageCodecErrorCode uIImageCodecErrorCode : uIImageCodecErrorCodeArr) {
            if (uIImageCodecErrorCode.swigValue == i) {
                return uIImageCodecErrorCode;
            }
        }
        throw new IllegalArgumentException("No enum " + UIImageCodecErrorCode.class + " with value " + i);
    }

    private UIImageCodecErrorCode(int i) {
        this.swigValue = i;
        UIImageCodecErrorCodeCache.a = i + 1;
    }
}
