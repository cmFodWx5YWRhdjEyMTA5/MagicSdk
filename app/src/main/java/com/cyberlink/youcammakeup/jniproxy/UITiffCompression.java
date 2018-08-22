package com.cyberlink.youcammakeup.jniproxy;

public enum UITiffCompression {
    ENC_TIFF_COMPRESS_NONE,
    ENC_TIFF_COMPRESS_ZIP,
    ENC_TIFF_COMPRESS_LZW;
    
    private final int swigValue = 0;

    public final int a() {
        return this.swigValue;
    }
}
