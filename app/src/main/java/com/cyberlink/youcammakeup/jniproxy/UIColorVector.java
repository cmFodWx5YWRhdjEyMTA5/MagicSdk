package com.cyberlink.youcammakeup.jniproxy;

public class UIColorVector {
    protected boolean a;
    private long b;

    protected UIColorVector(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIColorVector UIColorVectorVar) {
        return UIColorVectorVar == null ? 0 : UIColorVectorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIColorVector(this.b);
            }
            this.b = 0;
        }
    }

    public UIColorVector() {
        this(UIVenusJNI.new_UIColorVector__SWIG_0(), true);
    }

    public void a(UIColor UIColorVar) {
        UIVenusJNI.UIColorVector_add(this.b, this, UIColor.a(UIColorVar), UIColorVar);
    }
}
