package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceRectVector {
    protected boolean a;
    private long b;

    protected UIFaceRectVector(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceRectVector UIFaceRectVectorVar) {
        return UIFaceRectVectorVar == null ? 0 : UIFaceRectVectorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceRectVector(this.b);
            }
            this.b = 0;
        }
    }

    public UIFaceRectVector() {
        this(UIVenusJNI.new_UIFaceRectVector__SWIG_0(), true);
    }

    public long b() {
        return UIVenusJNI.UIFaceRectVector_size(this.b, this);
    }

    public UIFaceRect a(int i) {
        return new UIFaceRect(UIVenusJNI.UIFaceRectVector_get(this.b, this, i), false);
    }
}
