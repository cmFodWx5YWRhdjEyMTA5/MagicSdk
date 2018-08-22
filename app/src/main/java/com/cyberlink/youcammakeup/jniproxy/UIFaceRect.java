package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceRect {
    protected boolean a;
    private long b;

    protected UIFaceRect(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceRect UIFaceRectVar) {
        return UIFaceRectVar == null ? 0 : UIFaceRectVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceRect(this.b);
            }
            this.b = 0;
        }
    }

    public UIFaceRect() {
        this(UIVenusJNI.new_UIFaceRect__SWIG_0(), true);
    }

    public UIFaceRect(UIFaceRect UIFaceRectVar) {
        this(UIVenusJNI.new_UIFaceRect__SWIG_1(a(UIFaceRectVar), UIFaceRectVar), true);
    }

    public int b() {
        return UIVenusJNI.UIFaceRect_getLeft(this.b, this);
    }

    public void a(int i) {
        UIVenusJNI.UIFaceRect_setLeft(this.b, this, i);
    }

    public int c() {
        return UIVenusJNI.UIFaceRect_getTop(this.b, this);
    }

    public void b(int i) {
        UIVenusJNI.UIFaceRect_setTop(this.b, this, i);
    }

    public int d() {
        return UIVenusJNI.UIFaceRect_getRight(this.b, this);
    }

    public void c(int i) {
        UIVenusJNI.UIFaceRect_setRight(this.b, this, i);
    }

    public int e() {
        return UIVenusJNI.UIFaceRect_getBottom(this.b, this);
    }

    public void d(int i) {
        UIVenusJNI.UIFaceRect_setBottom(this.b, this, i);
    }
}
