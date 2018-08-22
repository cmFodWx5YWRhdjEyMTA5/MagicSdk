package com.cyberlink.youcammakeup.jniproxy;

public class UIExifInfo {
    protected boolean a;
    private long b;

    protected UIExifInfo(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UIExifInfo(this.b);
            }
            this.b = 0;
        }
    }

    public UIExifColorSpace b() {
        return UIExifColorSpace.a(UIImageCodecJNI.UIExifInfo_nColorSpace_get(this.b, this));
    }

    public UIExifInfo() {
        this(UIImageCodecJNI.new_UIExifInfo(), true);
    }
}
