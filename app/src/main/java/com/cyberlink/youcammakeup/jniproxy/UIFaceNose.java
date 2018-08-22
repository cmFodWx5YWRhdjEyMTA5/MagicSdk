package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceNose {
    protected boolean a;
    private long b;

    protected UIFaceNose(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceNose UIFaceNoseVar) {
        return UIFaceNoseVar == null ? 0 : UIFaceNoseVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceNose(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceNose_left_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceNose_left_get = UIVenusJNI.UIFaceNose_left_get(this.b, this);
        return UIFaceNose_left_get == 0 ? null : new UIFacePoint(UIFaceNose_left_get, false);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceNose_top_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint c() {
        long UIFaceNose_top_get = UIVenusJNI.UIFaceNose_top_get(this.b, this);
        return UIFaceNose_top_get == 0 ? null : new UIFacePoint(UIFaceNose_top_get, false);
    }

    public void c(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceNose_right_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint d() {
        long UIFaceNose_right_get = UIVenusJNI.UIFaceNose_right_get(this.b, this);
        return UIFaceNose_right_get == 0 ? null : new UIFacePoint(UIFaceNose_right_get, false);
    }

    public void d(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceNose_bottom_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint e() {
        long UIFaceNose_bottom_get = UIVenusJNI.UIFaceNose_bottom_get(this.b, this);
        return UIFaceNose_bottom_get == 0 ? null : new UIFacePoint(UIFaceNose_bottom_get, false);
    }

    public void e(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceNose_bridgeTop_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint f() {
        long UIFaceNose_bridgeTop_get = UIVenusJNI.UIFaceNose_bridgeTop_get(this.b, this);
        return UIFaceNose_bridgeTop_get == 0 ? null : new UIFacePoint(UIFaceNose_bridgeTop_get, false);
    }

    public UIFaceNose() {
        this(UIVenusJNI.new_UIFaceNose(), true);
    }
}
