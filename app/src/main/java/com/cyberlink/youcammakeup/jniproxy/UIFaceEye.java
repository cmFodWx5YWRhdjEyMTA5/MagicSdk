package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceEye {
    protected boolean a;
    private long b;

    protected UIFaceEye(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceEye UIFaceEyeVar) {
        return UIFaceEyeVar == null ? 0 : UIFaceEyeVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceEye(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceEye_left_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceEye_left_get = UIVenusJNI.UIFaceEye_left_get(this.b, this);
        return UIFaceEye_left_get == 0 ? null : new UIFacePoint(UIFaceEye_left_get, false);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceEye_top_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint c() {
        long UIFaceEye_top_get = UIVenusJNI.UIFaceEye_top_get(this.b, this);
        return UIFaceEye_top_get == 0 ? null : new UIFacePoint(UIFaceEye_top_get, false);
    }

    public void c(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceEye_right_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint d() {
        long UIFaceEye_right_get = UIVenusJNI.UIFaceEye_right_get(this.b, this);
        return UIFaceEye_right_get == 0 ? null : new UIFacePoint(UIFaceEye_right_get, false);
    }

    public void d(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceEye_bottom_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint e() {
        long UIFaceEye_bottom_get = UIVenusJNI.UIFaceEye_bottom_get(this.b, this);
        return UIFaceEye_bottom_get == 0 ? null : new UIFacePoint(UIFaceEye_bottom_get, false);
    }

    public void e(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceEye_center_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint f() {
        long UIFaceEye_center_get = UIVenusJNI.UIFaceEye_center_get(this.b, this);
        return UIFaceEye_center_get == 0 ? null : new UIFacePoint(UIFaceEye_center_get, false);
    }

    public UIFaceEye() {
        this(UIVenusJNI.new_UIFaceEye(), true);
    }
}
