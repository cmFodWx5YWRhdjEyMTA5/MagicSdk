package com.cyberlink.youcammakeup.jniproxy;

public class UIWigLuminance {
    protected boolean a;
    private long b;

    protected UIWigLuminance(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIWigLuminance UIWigLuminanceVar) {
        return UIWigLuminanceVar == null ? 0 : UIWigLuminanceVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIWigLuminance(this.b);
            }
            this.b = 0;
        }
    }

    public UIWigLuminance() {
        this(UIVenusJNI.new_UIWigLuminance__SWIG_0(), true);
    }

    public UIWigLuminance(UIWigLuminance UIWigLuminanceVar) {
        this(UIVenusJNI.new_UIWigLuminance__SWIG_1(a(UIWigLuminanceVar), UIWigLuminanceVar), true);
    }

    public int b() {
        return UIVenusJNI.UIWigLuminance_getValue(this.b, this);
    }

    public void a(int i) {
        UIVenusJNI.UIWigLuminance_setValue(this.b, this, i);
    }
}
