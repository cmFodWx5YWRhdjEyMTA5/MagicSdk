package com.cyberlink.youcammakeup.jniproxy;

public class UIWarpedWigImageInfo {
    protected boolean a;
    private long b;

    protected UIWarpedWigImageInfo(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIWarpedWigImageInfo UIWarpedWigImageInfoVar) {
        return UIWarpedWigImageInfoVar == null ? 0 : UIWarpedWigImageInfoVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIWarpedWigImageInfo(this.b);
            }
            this.b = 0;
        }
    }

    public int b() {
        return UIVenusJNI.UIWarpedWigImageInfo_width_get(this.b, this);
    }

    public int c() {
        return UIVenusJNI.UIWarpedWigImageInfo_height_get(this.b, this);
    }

    public UIWarpedWigImageInfo() {
        this(UIVenusJNI.new_UIWarpedWigImageInfo__SWIG_0(), true);
    }
}
