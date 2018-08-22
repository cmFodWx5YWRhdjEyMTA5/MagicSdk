package com.cyberlink.youcammakeup.jniproxy;

public class UIModelBrowEngineRect {
    protected boolean a;
    private long b;

    protected UIModelBrowEngineRect(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIModelBrowEngineRect UIModelBrowEngineRectVar) {
        return UIModelBrowEngineRectVar == null ? 0 : UIModelBrowEngineRectVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIModelBrowEngineRect(this.b);
            }
            this.b = 0;
        }
    }

    public void a(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIModelBrowEngineRect_head_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public void b(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIModelBrowEngineRect_top_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public void c(UIFacePoint UIFacePointVar) {
        UIVenusJNI.UIModelBrowEngineRect_tail_set(this.b, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public UIModelBrowEngineRect() {
        this(UIVenusJNI.new_UIModelBrowEngineRect(), true);
    }
}
