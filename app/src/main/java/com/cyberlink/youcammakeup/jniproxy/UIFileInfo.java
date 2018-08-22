package com.cyberlink.youcammakeup.jniproxy;

public class UIFileInfo {
    protected boolean a;
    private long b;

    protected UIFileInfo(long j, boolean z) {
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
                UIImageCodecJNI.delete_UIFileInfo(this.b);
            }
            this.b = 0;
        }
    }

    public UIImageFormat b() {
        return UIImageFormat.a(UIImageCodecJNI.UIFileInfo_nFormat_get(this.b, this));
    }

    public void a(long j) {
        UIImageCodecJNI.UIFileInfo_ulWidth_set(this.b, this, j);
    }

    public long c() {
        return UIImageCodecJNI.UIFileInfo_ulWidth_get(this.b, this);
    }

    public void b(long j) {
        UIImageCodecJNI.UIFileInfo_ulHeight_set(this.b, this, j);
    }

    public long d() {
        return UIImageCodecJNI.UIFileInfo_ulHeight_get(this.b, this);
    }

    public UIImageOrientation e() {
        return UIImageOrientation.a(UIImageCodecJNI.UIFileInfo_nOrientation_get(this.b, this));
    }

    public UIFileInfo() {
        this(UIImageCodecJNI.new_UIFileInfo(), true);
    }
}
