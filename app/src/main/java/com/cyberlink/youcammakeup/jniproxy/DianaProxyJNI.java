package com.cyberlink.youcammakeup.jniproxy;


public class DianaProxyJNI {
    public static final native boolean CDianaProxy_ApplyPipelineEffects(long j, CDianaProxy CDianaProxyVar, long j2, CImageBuffer CImageBufferVar, long j3, CImageBuffer CImageBufferVar2, long j4, UIDianaPipelineSettings UIDianaPipelineSettingsVar);

    public static final native boolean CDianaProxy_QueryEyeEnlargePoint(long j, CDianaProxy CDianaProxyVar, int i, int i2, float f, long j2, UIFaceEye UIFaceEyeVar, long j3, UIFacePoint UIFacePointVar, long j4, UIFacePoint UIFacePointVar2);

    public static final native boolean CDianaProxy_QueryFaceThinningPoint(long j, CDianaProxy CDianaProxyVar, int i, int i2, float f, long j2, UIFaceEye UIFaceEyeVar, long j3, UIFaceEye UIFaceEyeVar2, long j4, UIFaceMouth UIFaceMouthVar, long j5, UIFaceEar UIFaceEarVar, long j6, UIFaceEar UIFaceEarVar2, long j7, UIFaceShape UIFaceShapeVar, long j8, UIFaceShape UIFaceShapeVar2, long j9, UIFaceChin UIFaceChinVar, long j10, UIFacePoint UIFacePointVar, long j11, UIFacePoint UIFacePointVar2);

    public static final native boolean CDianaProxy_ReleaseImage(long j, CDianaProxy CDianaProxyVar, int i);

    public static final native boolean CDianaProxy_SetImage(long j, CDianaProxy CDianaProxyVar, int i);

    public static final native void UIDianaPipelineSettings_configCacheMode(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar, int i);

    public static final native void UIDianaPipelineSettings_configEyeBagRemoval(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar, int i);

    public static final native void UIDianaPipelineSettings_configEyeEnlargement(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar, int i);

    public static final native void UIDianaPipelineSettings_configFaceThinning(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar, int i);

    public static final native void UIDianaPipelineSettings_configFeaturePoints(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar, long j2, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static final native void UIDianaPipelineSettings_configRedEyeRemoval(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar, boolean z);

    public static final native void UIDianaPipelineSettings_configTeethWhitening(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar, int i, boolean z);

    public static final native long UIDianaPipelineSettings_queryFeaturePoints(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar);

    public static final native void delete_CDianaProxy(long j);

    public static final native void delete_UIDianaPipelineSettings(long j);

    public static final native long new_CDianaProxy(String str);

    public static final native long new_UIDianaPipelineSettings__SWIG_0();

    public static final native long new_UIDianaPipelineSettings__SWIG_1(long j, UIDianaPipelineSettings UIDianaPipelineSettingsVar);


}
