package com.cyberlink.youcammakeup.jniproxy;

public enum AthenaStrokeType {
    ATN_FOREGROUND(0),
    ATN_BACKGROUND(1),
    ATN_ERASER(2);

    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    private AthenaStrokeType(int i) {
        this.swigValue = i;
        AthenaStrokeTypebCache.a = i + 1;
    }
}
