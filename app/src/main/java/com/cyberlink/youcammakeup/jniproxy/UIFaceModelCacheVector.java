package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceModelCacheVector {
    protected boolean a;
    private long b;

    protected UIFaceModelCacheVector(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceModelCacheVector UIFaceModelCacheVectorVar) {
        return UIFaceModelCacheVectorVar == null ? 0 : UIFaceModelCacheVectorVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceModelCacheVector(this.b);
            }
            this.b = 0;
        }
    }

    public UIFaceModelCacheVector() {
        this(UIVenusJNI.new_UIFaceModelCacheVector__SWIG_0(), true);
    }

    public long b() {
        return UIVenusJNI.UIFaceModelCacheVector_size(this.b, this);
    }

    public void c() {
        UIVenusJNI.UIFaceModelCacheVector_clear(this.b, this);
    }

    public void a(String str) {
        UIVenusJNI.UIFaceModelCacheVector_add(this.b, this, str);
    }

    public String a(int i) {
        return UIVenusJNI.UIFaceModelCacheVector_get(this.b, this, i);
    }
}
