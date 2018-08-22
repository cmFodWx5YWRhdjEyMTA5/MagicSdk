package com.cyberlink.youcammakeup.jniproxy;

public class UIColor {
    protected boolean a;
    private long b;

    protected UIColor(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIColor UIColorVar) {
        return UIColorVar == null ? 0 : UIColorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIColor(this.b);
            }
            this.b = 0;
        }
    }

    public UIColor() {
        this(UIVenusJNI.new_UIColor__SWIG_0(), true);
    }

    public UIColor(int i, int i2, int i3) {
        this(UIVenusJNI.new_UIColor__SWIG_1(i, i2, i3), true);
    }

    public void a(int i) {
        UIVenusJNI.UIColor_setRLevel(this.b, this, i);
    }

    public void b(int i) {
        UIVenusJNI.UIColor_setGLevel(this.b, this, i);
    }

    public void c(int i) {
        UIVenusJNI.UIColor_setBLevel(this.b, this, i);
    }
}
