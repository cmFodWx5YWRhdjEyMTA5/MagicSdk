package com.cyberlink.youcammakeup.jniproxy;

public class UIVenusPipelineSettings {
    protected boolean a;
    private long b;

    protected UIVenusPipelineSettings(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIVenusPipelineSettings UIVenusPipelineSettingsVar) {
        return UIVenusPipelineSettingsVar == null ? 0 : UIVenusPipelineSettingsVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIVenusPipelineSettings(this.b);
            }
            this.b = 0;
        }
    }

    public UIVenusPipelineSettings() {
        this(UIVenusJNI.new_UIVenusPipelineSettings__SWIG_0(), true);
    }

    public UIVenusPipelineSettings(UIVenusPipelineSettings UIVenusPipelineSettingsVar) {
        this(UIVenusJNI.new_UIVenusPipelineSettings__SWIG_1(a(UIVenusPipelineSettingsVar), UIVenusPipelineSettingsVar), true);
    }

    public void a(int i) {
        UIVenusJNI.UIVenusPipelineSettings_configCacheMode(this.b, this, i);
    }

    public int b() {
        return UIVenusJNI.UIVenusPipelineSettings_queryCacheMode(this.b, this);
    }

    public void a(UIFaceRect UIFaceRectVar, UIFaceAlignmentData UIFaceAlignmentDataVar) {
        UIVenusJNI.UIVenusPipelineSettings_configFaceData(this.b, this, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar);
    }

    public UIFaceRect c() {
        return new UIFaceRect(UIVenusJNI.UIVenusPipelineSettings_queryFaceRect(this.b, this), true);
    }

    public UIFaceAlignmentData d() {
        return new UIFaceAlignmentData(UIVenusJNI.UIVenusPipelineSettings_queryFeaturePoints(this.b, this), true);
    }

    public void a(boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_configAutoSpotRemoval(this.b, this, z);
    }

    public void b(int i) {
        UIVenusJNI.UIVenusPipelineSettings_configAntiShine(this.b, this, i);
    }

    public void c(int i) {
        UIVenusJNI.UIVenusPipelineSettings_configSkinSmooth(this.b, this, i);
    }

    public void d(int i) {
        UIVenusJNI.UIVenusPipelineSettings_configFaceContour(this.b, this, i);
    }

    public void e(int i) {
        UIVenusJNI.UIVenusPipelineSettings_configNoseEnhancement(this.b, this, i);
    }

    public void a(int i, int i2, UIColor UIColorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar2, UIModelBrowEngineRect UIModelBrowEngineRectVar, UIModelBrowEngineRect UIModelBrowEngineRectVar2, UIModelBrowEngineRect UIModelBrowEngineRectVar3, String str, boolean z, boolean z2, int i3, UIFaceBrow UIFaceBrowVar, UIFaceBrow UIFaceBrowVar2) {
        UIVenusJNI.UIVenusPipelineSettings_configBrow(this.b, this, i, i2, UIColor.a(UIColorVar), UIColorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar2), UIFaceModelCacheVectorVar2, UIModelBrowEngineRect.a(UIModelBrowEngineRectVar), UIModelBrowEngineRectVar, UIModelBrowEngineRect.a(UIModelBrowEngineRectVar2), UIModelBrowEngineRectVar2, UIModelBrowEngineRect.a(UIModelBrowEngineRectVar3), UIModelBrowEngineRectVar3, str, z, z2, i3, UIFaceBrow.a(UIFaceBrowVar), UIFaceBrowVar, UIFaceBrow.a(UIFaceBrowVar2), UIFaceBrowVar2);
    }

    public boolean e() {
        return UIVenusJNI.UIVenusPipelineSettings_getBrowAutoHiddenFlag(this.b, this);
    }

    public boolean f() {
        return UIVenusJNI.UIVenusPipelineSettings_getBrowAutoMatchFlag(this.b, this);
    }

    public int g() {
        return UIVenusJNI.UIVenusPipelineSettings_getBrowHiddenIntensity(this.b, this);
    }

    public boolean h() {
        return UIVenusJNI.UIVenusPipelineSettings_isModelBrowRectAllZero(this.b, this);
    }

    public void b(boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_UpdateEyeBrowAutoHiddenFlag(this.b, this, z);
    }

    public void c(boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_UpdateEyeBrowAutoMatchFlag(this.b, this, z);
    }

    public void a(UIIntVector UIIntVectorVar, UIColorVector UIColorVectorVar, UIIntVector UIIntVectorVar2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar, String str, UIFaceModelCacheVector UIFaceModelCacheVectorVar2, UIIntVector UIIntVectorVar3, int i) {
        UIVenusJNI.UIVenusPipelineSettings_configEyeshadow(this.b, this, UIIntVector.a(UIIntVectorVar), UIIntVectorVar, UIColorVector.a(UIColorVectorVar), UIColorVectorVar, UIIntVector.a(UIIntVectorVar2), UIIntVectorVar2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar, str, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar2), UIFaceModelCacheVectorVar2, UIIntVector.a(UIIntVectorVar3), UIIntVectorVar3, i);
    }

    public void a(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyeshadowTattooLeft(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void b(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyeshadowTattooRight(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void a(int i, UIColor UIColorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar, String str) {
        UIVenusJNI.UIVenusPipelineSettings_configDoubleEyelid(this.b, this, i, UIColor.a(UIColorVar), UIColorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar, str);
    }

    public void a(int i, UIColor UIColorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar, String str, int i2) {
        UIVenusJNI.UIVenusPipelineSettings_configEyeliner(this.b, this, i, UIColor.a(UIColorVar), UIColorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar, str, i2);
    }

    public void c(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyelinerTattooLeft(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void d(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyelinerTattooRight(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void b(int i, UIColor UIColorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar, String str, int i2) {
        UIVenusJNI.UIVenusPipelineSettings_configEyelash(this.b, this, i, UIColor.a(UIColorVar), UIColorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar, str, i2);
    }

    public void e(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooLeftUpper(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void f(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooLeftLower(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void g(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooRightUpper(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void h(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooRightLower(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void i() {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooResetAll(this.b, this);
    }

    public void i(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyebrowTattooLeft(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void j(int i, int i2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIModelEyeRect UIModelEyeRectVar) {
        UIVenusJNI.UIVenusPipelineSettings_configEyebrowTattooRight(this.b, this, i, i2, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIModelEyeRect.a(UIModelEyeRectVar), UIModelEyeRectVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        UIVenusJNI.UIVenusPipelineSettings_configClassicLipstick(this.b, this, i, z, i2, i3, i4, i5);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        UIVenusJNI.UIVenusPipelineSettings_configKoreanStyleLipstick(this.b, this, i, z, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public void a(int i, float f, int i2, UIColorVector UIColorVectorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar2) {
        UIVenusJNI.UIVenusPipelineSettings_configEyeContact(this.b, this, i, f, i2, UIColorVector.a(UIColorVectorVar), UIColorVectorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar2), UIFaceModelCacheVectorVar2);
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, UITransform UITransformVar, UIWigColor UIWigColorVar, UIFaceModelCacheVector UIFaceModelCacheVectorVar, int i) {
        UIVenusJNI.UIVenusPipelineSettings_configWig(this.b, this, z, z2, z3, z4, z5, UITransform.a(UITransformVar), UITransformVar, UIWigColor.a(UIWigColorVar), UIWigColorVar, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, i);
    }

    public void a(UITransform UITransformVar) {
        UIVenusJNI.UIVenusPipelineSettings_configWigTransform(this.b, this, UITransform.a(UITransformVar), UITransformVar);
    }

    public void d(boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_setForceApplyWigPosition(this.b, this, z);
    }

    public UIFaceModelCacheVector j() {
        return new UIFaceModelCacheVector(UIVenusJNI.UIVenusPipelineSettings_getWigCache(this.b, this), true);
    }

    public void e(boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_setEnableWig(this.b, this, z);
    }

    public boolean k() {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableWig(this.b, this);
    }

    public boolean l() {
        return UIVenusJNI.UIVenusPipelineSettings_getIsWigModelChange(this.b, this);
    }

    public void f(boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_setIsWigModelChange(this.b, this, z);
    }

    public void a(UIWarpedWigImageInfo UIWarpedWigImageInfoVar) {
        UIVenusJNI.UIVenusPipelineSettings_getWarpedWigImageInfo(this.b, this, UIWarpedWigImageInfo.a(UIWarpedWigImageInfoVar), UIWarpedWigImageInfoVar);
    }

    public void b(UITransform UITransformVar) {
        UIVenusJNI.UIVenusPipelineSettings_getWarpedWigTransform(this.b, this, UITransform.a(UITransformVar), UITransformVar);
    }

    public boolean m() {
        return UIVenusJNI.UIVenusPipelineSettings_isForceApplyWigPosition(this.b, this);
    }

    public boolean n() {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableEyeContact(this.b, this);
    }

    public UIColorVector o() {
        return new UIColorVector(UIVenusJNI.UIVenusPipelineSettings_getEyeContactColor(this.b, this), true);
    }

    public int p() {
        return UIVenusJNI.UIVenusPipelineSettings_getEyeContactIntensity(this.b, this);
    }

    public float q() {
        return UIVenusJNI.UIVenusPipelineSettings_getEyeContactIntensitySize(this.b, this);
    }

    public int r() {
        return UIVenusJNI.UIVenusPipelineSettings_getEyeContactIrisRadius(this.b, this);
    }

    public UIFaceModelCacheVector s() {
        return new UIFaceModelCacheVector(UIVenusJNI.UIVenusPipelineSettings_getEyeContactModelCache(this.b, this), true);
    }

    public UIFaceModelCacheVector t() {
        return new UIFaceModelCacheVector(UIVenusJNI.UIVenusPipelineSettings_getEyeContactMaskModelCache(this.b, this), true);
    }

    public boolean u() {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableEyeBrow(this.b, this);
    }

    public void a(UIFaceBrow UIFaceBrowVar, UIFaceBrow UIFaceBrowVar2) {
        UIVenusJNI.UIVenusPipelineSettings_getOriginalEyeBrow(this.b, this, UIFaceBrow.a(UIFaceBrowVar), UIFaceBrowVar, UIFaceBrow.a(UIFaceBrowVar2), UIFaceBrowVar2);
    }

    public void b(UIFaceBrow UIFaceBrowVar, UIFaceBrow UIFaceBrowVar2) {
        UIVenusJNI.UIVenusPipelineSettings_configOriginalEyeBrow(this.b, this, UIFaceBrow.a(UIFaceBrowVar), UIFaceBrowVar, UIFaceBrow.a(UIFaceBrowVar2), UIFaceBrowVar2);
    }

    public void a(UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIIntPointVector UIIntPointVectorVar, UIFaceTattooColorVector UIFaceTattooColorVectorVar) {
        UIVenusJNI.UIVenusPipelineSettings_configFaceArt(this.b, this, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIIntPointVector.a(UIIntPointVectorVar), UIIntPointVectorVar, UIFaceTattooColorVector.a(UIFaceTattooColorVectorVar), UIFaceTattooColorVectorVar);
    }

    public void b(UIFaceModelCacheVector UIFaceModelCacheVectorVar, UIIntPointVector UIIntPointVectorVar, UIFaceTattooColorVector UIFaceTattooColorVectorVar) {
        UIVenusJNI.UIVenusPipelineSettings_configFaceWidget(this.b, this, UIFaceModelCacheVector.a(UIFaceModelCacheVectorVar), UIFaceModelCacheVectorVar, UIIntPointVector.a(UIIntPointVectorVar), UIIntPointVectorVar, UIFaceTattooColorVector.a(UIFaceTattooColorVectorVar), UIFaceTattooColorVectorVar);
    }

    public void a(int i, float f, UIColor UIColorVar) {
        UIVenusJNI.UIVenusPipelineSettings_configHairDye(this.b, this, i, f, UIColor.a(UIColorVar), UIColorVar);
    }

    public boolean v() {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableHairDye(this.b, this);
    }

    public void f(int i) {
        UIVenusJNI.UIVenusPipelineSettings_configSparkleEye(this.b, this, i);
    }

    public void a(int i, UIColor UIColorVar) {
        UIVenusJNI.UIVenusPipelineSettings_configSkinTone(this.b, this, i, UIColor.a(UIColorVar), UIColorVar);
    }

    public void a(int i, UIColor UIColorVar, String str, String str2, boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_configBlush(this.b, this, i, UIColor.a(UIColorVar), UIColorVar, str, str2, z);
    }

    public void g(boolean z) {
        UIVenusJNI.UIVenusPipelineSettings_configMouthOpen(this.b, this, z);
    }
}
