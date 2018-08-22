package com.cyberlink.youcammakeup.jniproxy;

public class UIUserProfile {
    protected boolean a;
    private long b;

    protected UIUserProfile(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIUserProfile UIUserProfileVar) {
        return UIUserProfileVar == null ? 0 : UIUserProfileVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIUserProfile(this.b);
            }
            this.b = 0;
        }
    }

    public UIUserProfile() {
        this(UIVenusJNI.new_UIUserProfile__SWIG_0(), true);
    }

    public int b() {
        return UIVenusJNI.UIUserProfile_getStatus(this.b, this);
    }

    public int c() {
        return UIVenusJNI.UIUserProfile_getGender(this.b, this);
    }

    public int d() {
        return UIVenusJNI.UIUserProfile_getSkinColor(this.b, this);
    }

    public int e() {
        return UIVenusJNI.UIUserProfile_getHairColor(this.b, this);
    }

    public int f() {
        return UIVenusJNI.UIUserProfile_getEyebrowColor(this.b, this);
    }

    public int g() {
        return UIVenusJNI.UIUserProfile_getIrisColor(this.b, this);
    }

    public int h() {
        return UIVenusJNI.UIUserProfile_getLipColor(this.b, this);
    }
}
