package com.cyberlink.youcammakeup.jniproxy;

public class UIIntPointVector {
    protected boolean a;
    private long b;

    protected UIIntPointVector(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIIntPointVector UIIntPointVectorVar) {
        return UIIntPointVectorVar == null ? 0 : UIIntPointVectorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIIntPointVector(this.b);
            }
            this.b = 0;
        }
    }

    public UIIntPointVector() {
        this(UIVenusJNI.new_UIIntPointVector__SWIG_0(), true);
    }

    public void a(UIIntPoint UIIntPointVar) {
        UIVenusJNI.UIIntPointVector_add(this.b, this, UIIntPoint.a(UIIntPointVar), UIIntPointVar);
    }
}
