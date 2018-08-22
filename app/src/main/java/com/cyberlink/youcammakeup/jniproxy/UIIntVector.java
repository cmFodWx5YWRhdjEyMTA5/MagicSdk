package com.cyberlink.youcammakeup.jniproxy;

public class UIIntVector {
    protected boolean a;
    private long b;

    protected UIIntVector(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIIntVector UIIntVectorVar) {
        return UIIntVectorVar == null ? 0 : UIIntVectorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIIntVector(this.b);
            }
            this.b = 0;
        }
    }

    public UIIntVector() {
        this(UIVenusJNI.new_UIIntVector__SWIG_0(), true);
    }

    public long b() {
        return UIVenusJNI.UIIntVector_size(this.b, this);
    }

    public void a(int i) {
        UIVenusJNI.UIIntVector_add(this.b, this, i);
    }

    public int b(int i) {
        return UIVenusJNI.UIIntVector_get(this.b, this, i);
    }
}
