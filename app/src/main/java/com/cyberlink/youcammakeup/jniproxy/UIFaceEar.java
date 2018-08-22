package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceEar {
    protected boolean a;
    private long b;

    protected UIFaceEar(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceEar UIFaceEarVar) {
        return UIFaceEarVar == null ? 0 : UIFaceEarVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceEar(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceEar_top_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceEar_top_get = UIVenusJNI.UIFaceEar_top_get(this.b, this);
        return UIFaceEar_top_get == 0 ? null : new UIFacePoint(UIFaceEar_top_get, false);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceEar_bottom_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint c() {
        long UIFaceEar_bottom_get = UIVenusJNI.UIFaceEar_bottom_get(this.b, this);
        return UIFaceEar_bottom_get == 0 ? null : new UIFacePoint(UIFaceEar_bottom_get, false);
    }

    public UIFaceEar() {
        this(UIVenusJNI.new_UIFaceEar(), true);
    }
}
