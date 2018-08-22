package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceShape {
    protected boolean a;
    private long b;

    protected UIFaceShape(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceShape UIFaceShapeVar) {
        return UIFaceShapeVar == null ? 0 : UIFaceShapeVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceShape(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceShape_shape1_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint b() {
        long UIFaceShape_shape1_get = UIVenusJNI.UIFaceShape_shape1_get(this.b, this);
        return UIFaceShape_shape1_get == 0 ? null : new UIFacePoint(UIFaceShape_shape1_get, false);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIFaceShape_shape2_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIFacePoint c() {
        long UIFaceShape_shape2_get = UIVenusJNI.UIFaceShape_shape2_get(this.b, this);
        return UIFaceShape_shape2_get == 0 ? null : new UIFacePoint(UIFaceShape_shape2_get, false);
    }

    public UIFaceShape() {
        this(UIVenusJNI.new_UIFaceShape(), true);
    }
}
