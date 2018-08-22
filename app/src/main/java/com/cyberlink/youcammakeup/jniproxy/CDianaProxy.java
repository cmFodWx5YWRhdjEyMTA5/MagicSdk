package com.cyberlink.youcammakeup.jniproxy;

public class CDianaProxy {
    protected boolean a;
    private long b;

    protected CDianaProxy(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                DianaProxyJNI.delete_CDianaProxy(this.b);
            }
            this.b = 0;
        }
    }

    public CDianaProxy(String str) {
        this(DianaProxyJNI.new_CDianaProxy(str), true);
    }

    public boolean a(int i) {
        return DianaProxyJNI.CDianaProxy_SetImage(this.b, this, i);
    }

    public boolean b(int i) {
        return DianaProxyJNI.CDianaProxy_ReleaseImage(this.b, this, i);
    }

    public boolean a(int i, int i2, float f, UIFaceEye UIFaceEyeVar, UIFaceEye UIFaceEyeVar2, UIFaceMouth UIFaceMouthVar, UIFaceEar UIFaceEarVar, UIFaceEar UIFaceEarVar2, UIFaceShape UIFaceShapeVar, UIFaceShape UIFaceShapeVar2, UIFaceChin UIFaceChinVar, UIFacePoint UIFacePointVar, UIFacePoint UIFacePointVar2) {
        return DianaProxyJNI.CDianaProxy_QueryFaceThinningPoint(this.b, this, i, i2, f, UIFaceEye.a(UIFaceEyeVar), UIFaceEyeVar, UIFaceEye.a(UIFaceEyeVar2), UIFaceEyeVar2, UIFaceMouth.a(UIFaceMouthVar), UIFaceMouthVar, UIFaceEar.a(UIFaceEarVar), UIFaceEarVar, UIFaceEar.a(UIFaceEarVar2), UIFaceEarVar2, UIFaceShape.a(UIFaceShapeVar), UIFaceShapeVar, UIFaceShape.a(UIFaceShapeVar2), UIFaceShapeVar2, UIFaceChin.a(UIFaceChinVar), UIFaceChinVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar, UIFacePoint.a(UIFacePointVar2), UIFacePointVar2);
    }

    public boolean a(int i, int i2, float f, UIFaceEye UIFaceEyeVar, UIFacePoint UIFacePointVar, UIFacePoint UIFacePointVar2) {
        return DianaProxyJNI.CDianaProxy_QueryEyeEnlargePoint(this.b, this, i, i2, f, UIFaceEye.a(UIFaceEyeVar), UIFaceEyeVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar, UIFacePoint.a(UIFacePointVar2), UIFacePointVar2);
    }

    public boolean a(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2, UIDianaPipelineSettings UIDianaPipelineSettingsVar) {
        return DianaProxyJNI.CDianaProxy_ApplyPipelineEffects(this.b, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, CImageBuffer.a(CImageBufferVar2), CImageBufferVar2, UIDianaPipelineSettings.a(UIDianaPipelineSettingsVar), UIDianaPipelineSettingsVar);
    }
}
