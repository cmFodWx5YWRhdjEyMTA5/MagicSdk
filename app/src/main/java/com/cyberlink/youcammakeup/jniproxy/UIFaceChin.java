package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceChin {
    protected boolean a;
    private long b;

    protected UIFaceChin(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceChin UIFaceChinVar) {
        return UIFaceChinVar == null ? 0 : UIFaceChinVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceChin(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceChin_center_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceChin_center_get = UIVenusJNI.UIFaceChin_center_get(this.b, this);
        return UIFaceChin_center_get == 0 ? null : new UIFacePoint(UIFaceChin_center_get, false);
    }

    public UIFaceChin() {
        this(UIVenusJNI.new_UIFaceChin(), true);
    }
}
