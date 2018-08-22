package com.cyberlink.youcammakeup.jniproxy;

public class UITransform {
    protected boolean a;
    private long b;

    protected UITransform(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UITransform UITransformVar) {
        return UITransformVar == null ? 0 : UITransformVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UITransform(this.b);
            }
            this.b = 0;
        }
    }

    public UITransform() {
        this(UIVenusJNI.new_UITransform__SWIG_0(), true);
    }

    public UITransform(UITransform UITransformVar) {
        this(UIVenusJNI.new_UITransform__SWIG_1(a(UITransformVar), UITransformVar), true);
    }

    public void a(float f) {
        UIVenusJNI.UITransform_setScale(this.b, this, f);
    }

    public float b() {
        return UIVenusJNI.UITransform_getScale(this.b, this);
    }

    public void b(float f) {
        UIVenusJNI.UITransform_setRotation(this.b, this, f);
    }

    public float c() {
        return UIVenusJNI.UITransform_getRotation(this.b, this);
    }

    public void c(float f) {
        UIVenusJNI.UITransform_setShiftX(this.b, this, f);
    }

    public float d() {
        return UIVenusJNI.UITransform_getShiftX(this.b, this);
    }

    public void d(float f) {
        UIVenusJNI.UITransform_setShiftY(this.b, this, f);
    }

    public float e() {
        return UIVenusJNI.UITransform_getShiftY(this.b, this);
    }
}
