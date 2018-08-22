package com.cyberlink.youcammakeup.jniproxy;

public class UICacheFileInfo {
    protected boolean a;
    private long b;

    protected UICacheFileInfo(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UICacheFileInfo UICacheFileInfoVar) {
        return UICacheFileInfoVar == null ? 0 : UICacheFileInfoVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                CommonJNI.delete_UICacheFileInfo(this.b);
            }
            this.b = 0;
        }
    }

    public long b() {
        return CommonJNI.UICacheFileInfo_ulWidth_get(this.b, this);
    }

    public long c() {
        return CommonJNI.UICacheFileInfo_ulHeight_get(this.b, this);
    }

    public long d() {
        return CommonJNI.UICacheFileInfo_ulBpp_get(this.b, this);
    }

    public UICacheFileInfo() {
        this(CommonJNI.new_UICacheFileInfo(), true);
    }
}
