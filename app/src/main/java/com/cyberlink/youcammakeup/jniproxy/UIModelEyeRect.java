package com.cyberlink.youcammakeup.jniproxy;

public class UIModelEyeRect {
    protected boolean a;
    private long b;

    protected UIModelEyeRect(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIModelEyeRect UIModelEyeRectVar) {
        return UIModelEyeRectVar == null ? 0 : UIModelEyeRectVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIModelEyeRect(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIModelEyeRect_left_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIModelEyeRect_top_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public void c(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIModelEyeRect_right_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public void d(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIModelEyeRect_bottom_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIModelEyeRect() {
        this(UIVenusJNI.new_UIModelEyeRect(), true);
    }
}
