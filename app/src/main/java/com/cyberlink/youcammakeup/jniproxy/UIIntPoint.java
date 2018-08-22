package com.cyberlink.youcammakeup.jniproxy;

public class UIIntPoint {
    protected boolean a;
    private long b;

    protected UIIntPoint(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIIntPoint UIIntPointVar) {
        return UIIntPointVar == null ? 0 : UIIntPointVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIIntPoint(this.b);
            }
            this.b = 0;
        }
    }

    public void a(int i) {
        UIVenusJNI.UIIntPoint_x_set(this.b, this, i);
    }

    public void b(int i) {
        UIVenusJNI.UIIntPoint_y_set(this.b, this, i);
    }

    public UIIntPoint() {
        this(UIVenusJNI.new_UIIntPoint__SWIG_0(), true);
    }
}
