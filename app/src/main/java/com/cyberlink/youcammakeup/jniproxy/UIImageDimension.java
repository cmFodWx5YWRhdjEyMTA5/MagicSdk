package com.cyberlink.youcammakeup.jniproxy;

public class UIImageDimension {
    protected boolean a;
    private long b;

    protected UIImageDimension(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIImageDimension UIImageDimensionVar) {
        return UIImageDimensionVar == null ? 0 : UIImageDimensionVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UIImageDimension(this.b);
            }
            this.b = 0;
        }
    }

    public void a(long j) {
        UIImageCodecJNI.UIImageDimension_ulWidth_set(this.b, this, j);
    }

    public long b() {
        return UIImageCodecJNI.UIImageDimension_ulWidth_get(this.b, this);
    }

    public void b(long j) {
        UIImageCodecJNI.UIImageDimension_ulHeight_set(this.b, this, j);
    }

    public long c() {
        return UIImageCodecJNI.UIImageDimension_ulHeight_get(this.b, this);
    }

    public UIImageDimension() {
        this(UIImageCodecJNI.new_UIImageDimension__SWIG_0(), true);
    }
}
