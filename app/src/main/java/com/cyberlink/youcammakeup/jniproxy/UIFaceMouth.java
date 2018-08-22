package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceMouth {
    protected boolean a;
    private long b;

    protected UIFaceMouth(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceMouth UIFaceMouthVar) {
        return UIFaceMouthVar == null ? 0 : UIFaceMouthVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceMouth(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_leftCorner_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceMouth_leftCorner_get = UIVenusJNI.UIFaceMouth_leftCorner_get(this.b, this);
        return UIFaceMouth_leftCorner_get == 0 ? null : new UIFacePoint(UIFaceMouth_leftCorner_get, false);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_topLip1_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint c() {
        long UIFaceMouth_topLip1_get = UIVenusJNI.UIFaceMouth_topLip1_get(this.b, this);
        return UIFaceMouth_topLip1_get == 0 ? null : new UIFacePoint(UIFaceMouth_topLip1_get, false);
    }

    public void c(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_topLip2_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint d() {
        long UIFaceMouth_topLip2_get = UIVenusJNI.UIFaceMouth_topLip2_get(this.b, this);
        return UIFaceMouth_topLip2_get == 0 ? null : new UIFacePoint(UIFaceMouth_topLip2_get, false);
    }

    public void d(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_rightCorner_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint e() {
        long UIFaceMouth_rightCorner_get = UIVenusJNI.UIFaceMouth_rightCorner_get(this.b, this);
        return UIFaceMouth_rightCorner_get == 0 ? null : new UIFacePoint(UIFaceMouth_rightCorner_get, false);
    }

    public void e(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_bottomLip1_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint f() {
        long UIFaceMouth_bottomLip1_get = UIVenusJNI.UIFaceMouth_bottomLip1_get(this.b, this);
        return UIFaceMouth_bottomLip1_get == 0 ? null : new UIFacePoint(UIFaceMouth_bottomLip1_get, false);
    }

    public void f(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_bottomLip2_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint g() {
        long UIFaceMouth_bottomLip2_get = UIVenusJNI.UIFaceMouth_bottomLip2_get(this.b, this);
        return UIFaceMouth_bottomLip2_get == 0 ? null : new UIFacePoint(UIFaceMouth_bottomLip2_get, false);
    }

    public void g(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpTopLeft_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint h() {
        long UIFaceMouth_interpTopLeft_get = UIVenusJNI.UIFaceMouth_interpTopLeft_get(this.b, this);
        return UIFaceMouth_interpTopLeft_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpTopLeft_get, false);
    }

    public void h(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpTopRight_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint i() {
        long UIFaceMouth_interpTopRight_get = UIVenusJNI.UIFaceMouth_interpTopRight_get(this.b, this);
        return UIFaceMouth_interpTopRight_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpTopRight_get, false);
    }

    public void i(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpBottomLeft_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint j() {
        long UIFaceMouth_interpBottomLeft_get = UIVenusJNI.UIFaceMouth_interpBottomLeft_get(this.b, this);
        return UIFaceMouth_interpBottomLeft_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpBottomLeft_get, false);
    }

    public void j(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpBottomRight_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint k() {
        long UIFaceMouth_interpBottomRight_get = UIVenusJNI.UIFaceMouth_interpBottomRight_get(this.b, this);
        return UIFaceMouth_interpBottomRight_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpBottomRight_get, false);
    }

    public void k(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpInnerLeft_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint l() {
        long UIFaceMouth_interpInnerLeft_get = UIVenusJNI.UIFaceMouth_interpInnerLeft_get(this.b, this);
        return UIFaceMouth_interpInnerLeft_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpInnerLeft_get, false);
    }

    public void l(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpInnerRight_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint m() {
        long UIFaceMouth_interpInnerRight_get = UIVenusJNI.UIFaceMouth_interpInnerRight_get(this.b, this);
        return UIFaceMouth_interpInnerRight_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpInnerRight_get, false);
    }

    public void m(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpUpperLeft_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint n() {
        long UIFaceMouth_interpUpperLeft_get = UIVenusJNI.UIFaceMouth_interpUpperLeft_get(this.b, this);
        return UIFaceMouth_interpUpperLeft_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpUpperLeft_get, false);
    }

    public void n(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpUpperRight_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint o() {
        long UIFaceMouth_interpUpperRight_get = UIVenusJNI.UIFaceMouth_interpUpperRight_get(this.b, this);
        return UIFaceMouth_interpUpperRight_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpUpperRight_get, false);
    }

    public void o(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpLowerLeft_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint p() {
        long UIFaceMouth_interpLowerLeft_get = UIVenusJNI.UIFaceMouth_interpLowerLeft_get(this.b, this);
        return UIFaceMouth_interpLowerLeft_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpLowerLeft_get, false);
    }

    public void p(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceMouth_interpLowerRight_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint q() {
        long UIFaceMouth_interpLowerRight_get = UIVenusJNI.UIFaceMouth_interpLowerRight_get(this.b, this);
        return UIFaceMouth_interpLowerRight_get == 0 ? null : new UIFacePoint(UIFaceMouth_interpLowerRight_get, false);
    }

    public UIFaceMouth() {
        this(UIVenusJNI.new_UIFaceMouth(), true);
    }
}
