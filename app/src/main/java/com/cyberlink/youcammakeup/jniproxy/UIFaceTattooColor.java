package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceTattooColor {
    protected boolean a;
    private long b;

    protected UIFaceTattooColor(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceTattooColor UIFaceTattooColorVar) {
        return UIFaceTattooColorVar == null ? 0 : UIFaceTattooColorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceTattooColor(this.b);
            }
            this.b = 0;
        }
    }

    public UIFaceTattooColor() {
        this(UIVenusJNI.new_UIFaceTattooColor(), true);
    }

    public void a(boolean z) {
        UIVenusJNI.UIFaceTattooColor_setColorAdjustable(this.b, this, z);
    }

    public void a(int i) {
        UIVenusJNI.UIFaceTattooColor_setRRatio(this.b, this, i);
    }

    public void b(int i) {
        UIVenusJNI.UIFaceTattooColor_setGRatio(this.b, this, i);
    }

    public void c(int i) {
        UIVenusJNI.UIFaceTattooColor_setBRatio(this.b, this, i);
    }

    public void d(int i) {
        UIVenusJNI.UIFaceTattooColor_setBrightness(this.b, this, i);
    }

    public void e(int i) {
        UIVenusJNI.UIFaceTattooColor_setContrastFirstOldy(this.b, this, i);
    }

    public void f(int i) {
        UIVenusJNI.UIFaceTattooColor_setContrastFirstNewy(this.b, this, i);
    }

    public void g(int i) {
        UIVenusJNI.UIFaceTattooColor_setContrastSecondOldy(this.b, this, i);
    }

    public void h(int i) {
        UIVenusJNI.UIFaceTattooColor_setContrastSecondNewy(this.b, this, i);
    }

    public void i(int i) {
        UIVenusJNI.UIFaceTattooColor_setLuminanceParameter(this.b, this, i);
    }
}
