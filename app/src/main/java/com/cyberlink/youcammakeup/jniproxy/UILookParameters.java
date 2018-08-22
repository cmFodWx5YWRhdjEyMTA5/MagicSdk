package com.cyberlink.youcammakeup.jniproxy;

public class UILookParameters {
    protected boolean a;
    private long b;

    protected UILookParameters(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UILookParameters UILookParametersVar) {
        return UILookParametersVar == null ? 0 : UILookParametersVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UILookParameters(this.b);
            }
            this.b = 0;
        }
    }

    public UILookParameters() {
        this(UIVenusJNI.new_UILookParameters(), true);
    }

    public void a(int i) {
        UIVenusJNI.UILookParameters_setAntiShineIntensity(this.b, this, i);
    }

    public void b(int i) {
        UIVenusJNI.UILookParameters_setSkinSmoothIntensity(this.b, this, i);
    }

    public void c(int i) {
        UIVenusJNI.UILookParameters_setFaceContourIntensity(this.b, this, i);
    }

    public void d(int i) {
        UIVenusJNI.UILookParameters_setNoseEnhancementIntentsity(this.b, this, i);
    }

    public void e(int i) {
        UIVenusJNI.UILookParameters_setSparkleEyeIntensity(this.b, this, i);
    }

    public void f(int i) {
        UIVenusJNI.UILookParameters_setEyeBrowIntensity(this.b, this, i);
    }

    public void g(int i) {
        UIVenusJNI.UILookParameters_setEyeBrowHiddenIntensity(this.b, this, i);
    }

    public void h(int i) {
        UIVenusJNI.UILookParameters_setDoubleEyelidsIntensity(this.b, this, i);
    }

    public void i(int i) {
        UIVenusJNI.UILookParameters_setEyeContactsIntensity(this.b, this, i);
    }

    public void j(int i) {
        UIVenusJNI.UILookParameters_setEyeShadowCount(this.b, this, i);
    }

    public void a(UIIntVector UIIntVectorVar) {
        UIVenusJNI.UILookParameters_setEyeShadowIntensity(this.b, this, UIIntVector.a(UIIntVectorVar), UIIntVectorVar);
    }

    public void b(UIIntVector UIIntVectorVar) {
        UIVenusJNI.UILookParameters_setEyeShadowShimmerIntensity(this.b, this, UIIntVector.a(UIIntVectorVar), UIIntVectorVar);
    }

    public void k(int i) {
        UIVenusJNI.UILookParameters_setEyeLinerIntensity(this.b, this, i);
    }

    public void l(int i) {
        UIVenusJNI.UILookParameters_setEyeLashIntensity(this.b, this, i);
    }

    public void m(int i) {
        UIVenusJNI.UILookParameters_setLipStickIntensity(this.b, this, i);
    }

    public void n(int i) {
        UIVenusJNI.UILookParameters_setHairDyeIntensity(this.b, this, i);
    }

    public void o(int i) {
        UIVenusJNI.UILookParameters_setSkinToneIntensity(this.b, this, i);
    }

    public void p(int i) {
        UIVenusJNI.UILookParameters_setBlushIntensity(this.b, this, i);
    }

    public int b() {
        return UIVenusJNI.UILookParameters_getAntiShineIntensity(this.b, this);
    }

    public int c() {
        return UIVenusJNI.UILookParameters_getSkinSmoothIntensity(this.b, this);
    }

    public int d() {
        return UIVenusJNI.UILookParameters_getFaceContourIntensity(this.b, this);
    }

    public int e() {
        return UIVenusJNI.UILookParameters_getNoseEnhancementIntentsity(this.b, this);
    }

    public int f() {
        return UIVenusJNI.UILookParameters_getSparkleEyeIntensity(this.b, this);
    }

    public int g() {
        return UIVenusJNI.UILookParameters_getEyeBrowIntensity(this.b, this);
    }

    public int h() {
        return UIVenusJNI.UILookParameters_getEyeBrowHiddenIntensity(this.b, this);
    }

    public int i() {
        return UIVenusJNI.UILookParameters_getDoubleEyelidsIntensity(this.b, this);
    }

    public int j() {
        return UIVenusJNI.UILookParameters_getEyeContactsIntensity(this.b, this);
    }

    public int k() {
        return UIVenusJNI.UILookParameters_getEyeShadowCount(this.b, this);
    }

    public void c(UIIntVector UIIntVectorVar) {
        UIVenusJNI.UILookParameters_getEyeShadowIntensity(this.b, this, UIIntVector.a(UIIntVectorVar), UIIntVectorVar);
    }

    public void d(UIIntVector UIIntVectorVar) {
        UIVenusJNI.UILookParameters_getEyeShadowShimmerIntensity(this.b, this, UIIntVector.a(UIIntVectorVar), UIIntVectorVar);
    }

    public int l() {
        return UIVenusJNI.UILookParameters_getEyeLinerIntensity(this.b, this);
    }

    public int m() {
        return UIVenusJNI.UILookParameters_getEyeLashIntensity(this.b, this);
    }

    public int n() {
        return UIVenusJNI.UILookParameters_getLipStickIntensity(this.b, this);
    }

    public int o() {
        return UIVenusJNI.UILookParameters_getHairDyeIntensity(this.b, this);
    }

    public int p() {
        return UIVenusJNI.UILookParameters_getSkinToneIntensity(this.b, this);
    }

    public int q() {
        return UIVenusJNI.UILookParameters_getBlushIntensity(this.b, this);
    }

    public void r() {
        UIVenusJNI.UILookParameters_dumpDebugString(this.b, this);
    }
}
