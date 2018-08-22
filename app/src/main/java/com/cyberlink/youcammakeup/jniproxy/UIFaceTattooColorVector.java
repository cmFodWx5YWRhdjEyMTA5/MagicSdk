package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceTattooColorVector {
    protected boolean a;
    private long b;

    protected UIFaceTattooColorVector(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceTattooColorVector UIFaceTattooColorVectorVar) {
        return UIFaceTattooColorVectorVar == null ? 0 : UIFaceTattooColorVectorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceTattooColorVector(this.b);
            }
            this.b = 0;
        }
    }

    public UIFaceTattooColorVector() {
        this(UIVenusJNI.new_UIFaceTattooColorVector__SWIG_0(), true);
    }

    public void a(UIFaceTattooColor UIFaceTattooColorVar) {
        UIVenusJNI.UIFaceTattooColorVector_add(this.b, this, UIFaceTattooColor.a(UIFaceTattooColorVar), UIFaceTattooColorVar);
    }
}
