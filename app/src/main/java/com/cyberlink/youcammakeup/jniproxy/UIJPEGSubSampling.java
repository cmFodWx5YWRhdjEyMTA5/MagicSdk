package com.cyberlink.youcammakeup.jniproxy;

public enum UIJPEGSubSampling {
    JPEG_SUBSAMPLING_DEFAULT(0),
    JPEG_SUBSAMPLING_420(1),
    JPEG_SUBSAMPLING_422(2),
    JPEG_SUBSAMPLING_444(3);
    
    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    private UIJPEGSubSampling(int i) {
        this.swigValue = i;
        UIJPEGSubSamplingCache.a = i + 1;
    }
}
