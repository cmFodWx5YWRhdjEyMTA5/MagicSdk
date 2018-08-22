package com.cyberlink.youcammakeup.jniproxy;

public class UIFacePoint {
    protected boolean a;
    private long b;

    protected UIFacePoint(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFacePoint UIFacePointVar) {
        return UIFacePointVar == null ? 0 : UIFacePointVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFacePoint(this.b);
            }
            this.b = 0;
        }
    }

    public void a(float f) {
        UIVenusJNI.UIFacePoint_x_set(this.b, this, f);
    }

    public float b() {
        return UIVenusJNI.UIFacePoint_x_get(this.b, this);
    }

    public void b(float f) {
        UIVenusJNI.UIFacePoint_y_set(this.b, this, f);
    }

    public float c() {
        return UIVenusJNI.UIFacePoint_y_get(this.b, this);
    }

    public UIFacePoint() {
        this(UIVenusJNI.new_UIFacePoint__SWIG_0(), true);
    }

    public UIFacePoint(UIFacePoint UIFacePointVar) {
        this(UIVenusJNI.new_UIFacePoint__SWIG_1(a(UIFacePointVar), UIFacePointVar), true);
    }
}
