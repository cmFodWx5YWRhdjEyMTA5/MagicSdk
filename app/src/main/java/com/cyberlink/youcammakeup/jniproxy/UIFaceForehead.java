package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceForehead {
    protected boolean a;
    private long b;

    protected UIFaceForehead(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceForehead UIFaceForeheadVar) {
        return UIFaceForeheadVar == null ? 0 : UIFaceForeheadVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceForehead(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceForehead_middle_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceForehead_middle_get = UIVenusJNI.UIFaceForehead_middle_get(this.b, this);
        return UIFaceForehead_middle_get == 0 ? null : new UIFacePoint(UIFaceForehead_middle_get, false);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceForehead_left_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint c() {
        long UIFaceForehead_left_get = UIVenusJNI.UIFaceForehead_left_get(this.b, this);
        return UIFaceForehead_left_get == 0 ? null : new UIFacePoint(UIFaceForehead_left_get, false);
    }

    public void c(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceForehead_right_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint d() {
        long UIFaceForehead_right_get = UIVenusJNI.UIFaceForehead_right_get(this.b, this);
        return UIFaceForehead_right_get == 0 ? null : new UIFacePoint(UIFaceForehead_right_get, false);
    }

    public UIFaceForehead() {
        this(UIVenusJNI.new_UIFaceForehead(), true);
    }
}
