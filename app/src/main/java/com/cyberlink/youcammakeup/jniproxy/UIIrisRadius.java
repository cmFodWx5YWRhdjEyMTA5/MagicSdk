package com.cyberlink.youcammakeup.jniproxy;

public class UIIrisRadius {
    protected boolean a;
    private long b;

    protected UIIrisRadius(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIIrisRadius UIIrisRadiusVar) {
        return UIIrisRadiusVar == null ? 0 : UIIrisRadiusVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIIrisRadius(this.b);
            }
            this.b = 0;
        }
    }

    public UIIrisRadius() {
        this(UIVenusJNI.new_UIIrisRadius__SWIG_0(), true);
    }

    public UIIrisRadius(UIIrisRadius UIIrisRadiusVar) {
        this(UIVenusJNI.new_UIIrisRadius__SWIG_1(a(UIIrisRadiusVar), UIIrisRadiusVar), true);
    }

    public int b() {
        return UIVenusJNI.UIIrisRadius_getValue(this.b, this);
    }

    public void a(int i) {
        UIVenusJNI.UIIrisRadius_setValue(this.b, this, i);
    }
}
