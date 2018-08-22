package com.cyberlink.youcammakeup.jniproxy;

public enum AccessMode {
    ReadOnly(0),
    ReadWrite(1);

    private final int swigValue;

    public final int a() {
        return this.swigValue;
    }

    private AccessMode(int i) {
        this.swigValue = i;
        AccessModeCache.a = i + 1;
    }
}
