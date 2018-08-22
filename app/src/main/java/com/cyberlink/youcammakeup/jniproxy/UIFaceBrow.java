package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceBrow {
    protected boolean a;
    private long b;

    protected UIFaceBrow(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceBrow UIFaceBrowVar) {
        return UIFaceBrowVar == null ? 0 : UIFaceBrowVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceBrow(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceBrow_left_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceBrow_left_get = UIVenusJNI.UIFaceBrow_left_get(this.b, this);
        return UIFaceBrow_left_get == 0 ? null : new UIFacePoint(UIFaceBrow_left_get, false);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceBrow_top_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint c() {
        long UIFaceBrow_top_get = UIVenusJNI.UIFaceBrow_top_get(this.b, this);
        return UIFaceBrow_top_get == 0 ? null : new UIFacePoint(UIFaceBrow_top_get, false);
    }

    public void c(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceBrow_right_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint d() {
        long UIFaceBrow_right_get = UIVenusJNI.UIFaceBrow_right_get(this.b, this);
        return UIFaceBrow_right_get == 0 ? null : new UIFacePoint(UIFaceBrow_right_get, false);
    }

    public void d(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceBrow_bottom_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint e() {
        long UIFaceBrow_bottom_get = UIVenusJNI.UIFaceBrow_bottom_get(this.b, this);
        return UIFaceBrow_bottom_get == 0 ? null : new UIFacePoint(UIFaceBrow_bottom_get, false);
    }

    public UIFaceBrow() {
        this(UIVenusJNI.new_UIFaceBrow(), true);
    }
}
