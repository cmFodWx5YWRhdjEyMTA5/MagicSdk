package com.cyberlink.youcammakeup.jniproxy;

public class UIWigColor {
    protected boolean a;
    private long b;

    protected UIWigColor(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIWigColor UIWigColorVar) {
        return UIWigColorVar == null ? 0 : UIWigColorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIWigColor(this.b);
            }
            this.b = 0;
        }
    }

    public UIWigColor() {
        this(UIVenusJNI.new_UIWigColor__SWIG_0(), true);
    }

    public void a(int i) {
        UIVenusJNI.UIWigColor_setBrightness(this.b, this, i);
    }

    public void b(int i) {
        UIVenusJNI.UIWigColor_setRRatio(this.b, this, i);
    }

    public void c(int i) {
        UIVenusJNI.UIWigColor_setGRatio(this.b, this, i);
    }

    public void d(int i) {
        UIVenusJNI.UIWigColor_setBRatio(this.b, this, i);
    }

    public void e(int i) {
        UIVenusJNI.UIWigColor_setContrastFirstOldy(this.b, this, i);
    }

    public void f(int i) {
        UIVenusJNI.UIWigColor_setContrastFirstNewy(this.b, this, i);
    }

    public void g(int i) {
        UIVenusJNI.UIWigColor_setContrastSecondOldy(this.b, this, i);
    }

    public void h(int i) {
        UIVenusJNI.UIWigColor_setContrastSecondNewy(this.b, this, i);
    }
}
