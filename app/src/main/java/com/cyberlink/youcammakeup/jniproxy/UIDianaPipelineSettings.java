package com.cyberlink.youcammakeup.jniproxy;

public class UIDianaPipelineSettings {
    protected boolean a;
    private long b;

    protected UIDianaPipelineSettings(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIDianaPipelineSettings UIDianaPipelineSettingsVar) {
        return UIDianaPipelineSettingsVar == null ? 0 : UIDianaPipelineSettingsVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                DianaProxyJNI.delete_UIDianaPipelineSettings(this.b);
            }
            this.b = 0;
        }
    }

    public UIDianaPipelineSettings() {
        this(DianaProxyJNI.new_UIDianaPipelineSettings__SWIG_0(), true);
    }

    public UIDianaPipelineSettings(UIDianaPipelineSettings UIDianaPipelineSettingsVar) {
        this(DianaProxyJNI.new_UIDianaPipelineSettings__SWIG_1(a(UIDianaPipelineSettingsVar), UIDianaPipelineSettingsVar), true);
    }

    public void a(int i) {
        DianaProxyJNI.UIDianaPipelineSettings_configCacheMode(this.b, this, i);
    }

    public void a(UIFaceAlignmentData UIFaceAlignmentDataVar) {
        DianaProxyJNI.UIDianaPipelineSettings_configFeaturePoints(this.b, this, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar);
    }

    public UIFaceAlignmentData b() {
        return new UIFaceAlignmentData(DianaProxyJNI.UIDianaPipelineSettings_queryFeaturePoints(this.b, this), true);
    }

    public void a(boolean z) {
        DianaProxyJNI.UIDianaPipelineSettings_configRedEyeRemoval(this.b, this, z);
    }

    public void b(int i) {
        DianaProxyJNI.UIDianaPipelineSettings_configEyeEnlargement(this.b, this, i);
    }

    public void c(int i) {
        DianaProxyJNI.UIDianaPipelineSettings_configEyeBagRemoval(this.b, this, i);
    }

    public void d(int i) {
        DianaProxyJNI.UIDianaPipelineSettings_configFaceThinning(this.b, this, i);
    }

    public void a(int i, boolean z) {
        DianaProxyJNI.UIDianaPipelineSettings_configTeethWhitening(this.b, this, i, z);
    }
}
