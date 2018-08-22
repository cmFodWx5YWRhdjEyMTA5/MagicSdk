package com.cyberlink.youcammakeup.jniproxy;

import java.nio.ByteBuffer;

public class CUIVenus {
    static final /* synthetic */ boolean b = (!CUIVenus.class.desiredAssertionStatus());
    protected boolean a;
    private long mAddr;

    protected CUIVenus(long j, boolean z) {
        this.a = z;
        this.mAddr = j;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.mAddr != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_CUIVenus(this.mAddr);
            }
            this.mAddr = 0;
        }
    }

    public CUIVenus(String str, String str2, String str3, String str4) {
        this(UIVenusJNI.new_CUIVenus(str, str2, str3, str4), true);
    }

    public int CUIVenus_SetUserProfileFolder(String str) {
        return UIVenusJNI.CUIVenus_SetUserProfileFolder(this.mAddr, this, str);
    }

    public int CUIVenus_ExtractUserProfile(UIUserProfile UIUserProfileVar) {
        return UIVenusJNI.CUIVenus_ExtractUserProfile(this.mAddr, this, UIUserProfile.a(UIUserProfileVar), UIUserProfileVar);
    }

    public boolean CUIVenus_IsModelLoaded() {
        return UIVenusJNI.CUIVenus_IsModelLoaded(this.mAddr, this);
    }

    public int CUIVenus_AnalyzeImage(CImageBuffer CImageBufferVar) {
        return UIVenusJNI.CUIVenus_AnalyzeImage(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar);
    }

    public int CUIVenus_GetFaceInfos__SWIG_0(int i, UIFaceRectVector UIFaceRectVectorVar) {
        return UIVenusJNI.CUIVenus_GetFaceInfos__SWIG_0(this.mAddr, this, i, UIFaceRectVector.a(UIFaceRectVectorVar), UIFaceRectVectorVar);
    }

    public int CUIVenus_GetFaceAlignmentData__SWIG_0(UIFaceRect UIFaceRectVar, UIFaceAlignmentData UIFaceAlignmentDataVar) {
        return UIVenusJNI.CUIVenus_GetFaceAlignmentData__SWIG_0(this.mAddr, this, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar);
    }

    public int CUIVenus_ManualGetFaceAlignmentData(CImageBuffer CImageBufferVar, UIFacePoint UIFacePointVar, UIFacePoint UIFacePointVar2, UIFacePoint UIFacePointVar3, UIFaceAlignmentData UIFaceAlignmentDataVar) {
        return UIVenusJNI.CUIVenus_ManualGetFaceAlignmentData(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar, UIFacePoint.a(UIFacePointVar2), UIFacePointVar2, UIFacePoint.a(UIFacePointVar3), UIFacePointVar3, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar);
    }

    public int CUIVenus_GetIrisRadius__SWIG_0(UIFaceRect UIFaceRectVar, UIIrisRadius UIIrisRadiusVar) {
        return UIVenusJNI.CUIVenus_GetIrisRadius__SWIG_0(this.mAddr, this, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIIrisRadius.a(UIIrisRadiusVar), UIIrisRadiusVar);
    }

    public int CUIVenus_GetAutoWigLuminanceParameter(UIFaceRect UIFaceRectVar, UIWigLuminance UIWigLuminanceVar) {
        return UIVenusJNI.CUIVenus_GetAutoWigLuminanceParameter(this.mAddr, this, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIWigLuminance.a(UIWigLuminanceVar), UIWigLuminanceVar);
    }

    public int CUIVenus_GetEyebrowOriginalColor(UIFaceRect UIFaceRectVar, UIIntVector UIIntVectorVar) {
        return UIVenusJNI.CUIVenus_GetEyebrowOriginalColor(this.mAddr, this, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIIntVector.a(UIIntVectorVar), UIIntVectorVar);
    }

    public boolean CUIVenus_DetectOpenMouth(UIFaceRect UIFaceRectVar) {
        return UIVenusJNI.CUIVenus_DetectOpenMouth(this.mAddr, this, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar);
    }

    public int CUIVenus_GetWarpedWigModel(UIWarpedWigImageInfo UIWarpedWigImageInfoVar, CImageBuffer CImageBufferVar) {
        return UIVenusJNI.CUIVenus_GetWarpedWigModel(this.mAddr, this, UIWarpedWigImageInfo.a(UIWarpedWigImageInfoVar), UIWarpedWigImageInfoVar, CImageBuffer.a(CImageBufferVar), CImageBufferVar);
    }

    public int CUIVenus_StartWarpWigInLocal(UITransform UITransformVar, UIFacePoint UIFacePointVar) {
        return UIVenusJNI.CUIVenus_StartWarpWigInLocal(this.mAddr, this, UITransform.a(UITransformVar), UITransformVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public int CUIVenus_ContinueWarpWigInLocal(UIFacePoint UIFacePointVar) {
        return UIVenusJNI.CUIVenus_ContinueWarpWigInLocal(this.mAddr, this, UIFacePoint.a(UIFacePointVar), UIFacePointVar);
    }

    public int CUIVenus_EndWarpWigInLocal(UIWarpedWigImageInfo UIWarpedWigImageInfoVar, CImageBuffer CImageBufferVar) {
        return UIVenusJNI.CUIVenus_EndWarpWigInLocal(this.mAddr, this, UIWarpedWigImageInfo.a(UIWarpedWigImageInfoVar), UIWarpedWigImageInfoVar, CImageBuffer.a(CImageBufferVar), CImageBufferVar);
    }

    public boolean CUIVenus_IsLocalMoveWigDone() {
        return UIVenusJNI.CUIVenus_IsLocalMoveWigDone(this.mAddr, this);
    }

    public boolean CUIVenus_DumpWigOffsetData(String str) {
        return UIVenusJNI.CUIVenus_DumpWigOffsetData(this.mAddr, this, str);
    }

    public boolean CUIVenus_LoadWigOffsetData(String str) {
        return UIVenusJNI.CUIVenus_LoadWigOffsetData(this.mAddr, this, str);
    }

    public void CUIVenus_ReleaseWigOffsetData() {
        UIVenusJNI.CUIVenus_ReleaseWigOffsetData(this.mAddr, this);
    }

    public void CUIVenus_UndoWarpWig() {
        UIVenusJNI.CUIVenus_UndoWarpWig(this.mAddr, this);
    }

    public void CUIVenus_RedoWarpWig() {
        UIVenusJNI.CUIVenus_RedoWarpWig(this.mAddr, this);
    }

    public void CUIVenus_ResetWarpWig() {
        UIVenusJNI.CUIVenus_ResetWarpWig(this.mAddr, this);
    }

    public void CUIVenus_FlipWig(boolean z) {
        UIVenusJNI.CUIVenus_FlipWig(this.mAddr, this, z);
    }

    public int CUIVenus_ChangeWigColor(UIWigColor UIWigColorVar, float f) {
        return UIVenusJNI.CUIVenus_ChangeWigColor(this.mAddr, this, UIWigColor.a(UIWigColorVar), UIWigColorVar, f);
    }

    public void CUIVenus_setIsHoudini(boolean z) {
        UIVenusJNI.CUIVenus_setIsHoudini(this.mAddr, this, z);
    }

    public int CUIVenus_GetEyewearNaturalLookingModelAndTranslation(CImageBuffer CImageBufferVar, UIFacePoint UIFacePointVar, UIFacePoint UIFacePointVar2, int i, UIFaceRect UIFaceRectVar, UIFaceAlignmentData UIFaceAlignmentDataVar, UITransform UITransformVar) {
        return UIVenusJNI.CUIVenus_GetEyewearNaturalLookingModelAndTranslation(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar, UIFacePoint.a(UIFacePointVar2), UIFacePointVar2, i, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar, UITransform.a(UITransformVar), UITransformVar);
    }

    public int CUIVenus_GetHairbandNaturalLookingModelAndTranslation(CImageBuffer CImageBufferVar, UIFacePoint UIFacePointVar, UIFacePoint UIFacePointVar2, UIFaceRect UIFaceRectVar, UIFaceAlignmentData UIFaceAlignmentDataVar, UITransform UITransformVar) {
        return UIVenusJNI.CUIVenus_GetHairbandNaturalLookingModelAndTranslation(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar, UIFacePoint.a(UIFacePointVar2), UIFacePointVar2, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar, UITransform.a(UITransformVar), UITransformVar);
    }

    public int CUIVenus_GetNecklaceNaturalLookingModelAndTranslation(CImageBuffer CImageBufferVar, UIFacePoint UIFacePointVar, UIFacePoint UIFacePointVar2, UIFaceRect UIFaceRectVar, UIFaceAlignmentData UIFaceAlignmentDataVar, UITransform UITransformVar) {
        return UIVenusJNI.CUIVenus_GetNecklaceNaturalLookingModelAndTranslation(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar, UIFacePoint.a(UIFacePointVar2), UIFacePointVar2, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar, UITransform.a(UITransformVar), UITransformVar);
    }

    public int CUIVenus_GetEarringNaturalLookingModelAndTranslation(CImageBuffer CImageBufferVar, UIFacePoint UIFacePointVar, UIFacePoint UIFacePointVar2, UIFacePoint UIFacePointVar3, UIFacePoint UIFacePointVar4, UIFaceRect UIFaceRectVar, UIFaceAlignmentData UIFaceAlignmentDataVar, UITransform UITransformVar, UITransform UITransformVar2) {
        return UIVenusJNI.CUIVenus_GetEarringNaturalLookingModelAndTranslation(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIFacePoint.a(UIFacePointVar), UIFacePointVar, UIFacePoint.a(UIFacePointVar2), UIFacePointVar2, UIFacePoint.a(UIFacePointVar3), UIFacePointVar3, UIFacePoint.a(UIFacePointVar4), UIFacePointVar4, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar, UITransform.a(UITransformVar), UITransformVar, UITransform.a(UITransformVar2), UITransformVar2);
    }

    public int CUIVenus_AutoDetectHairDyeMask(CImageBuffer CImageBufferVar, UIFaceRect UIFaceRectVar, UIFaceAlignmentData UIFaceAlignmentDataVar) {
        return UIVenusJNI.CUIVenus_AutoDetectHairDyeMask(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIFaceRect.a(UIFaceRectVar), UIFaceRectVar, UIFaceAlignmentData.a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar);
    }

    public int CUIVenus_QueryHairDetectionProgress() {
        return UIVenusJNI.CUIVenus_QueryHairDetectionProgress(this.mAddr, this);
    }

    public int CUIVenus_UpdateHairDyeMask(CImageBuffer CImageBufferVar, ByteBuffer byteBuffer, boolean z, int i) {
        if (b || byteBuffer.isDirect()) {
            return UIVenusJNI.CUIVenus_UpdateHairDyeMask(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, byteBuffer, z, i);
        }
        throw new AssertionError("Buffer must be allocated direct.");
    }

    public int CUIVenus_GetHairDyeMask(CImageBuffer CImageBufferVar) {
        return UIVenusJNI.CUIVenus_GetHairDyeMask(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar);
    }

    public int CUIVenus_SetHairDyeMask(CImageBuffer CImageBufferVar) {
        return UIVenusJNI.CUIVenus_SetHairDyeMask(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar);
    }

    public int CUIVenus_GenerateHairDyeThumbnail(CImageBuffer CImageBufferVar, UIColor UIColorVar) {
        return UIVenusJNI.CUIVenus_GenerateHairDyeThumbnail(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIColor.a(UIColorVar), UIColorVar);
    }

    public int CUIVenus_GetLookParameters(UILookParameters UILookParametersVar, int i, UILookParameters UILookParametersVar2) {
        return UIVenusJNI.CUIVenus_GetLookParameters(this.mAddr, this, UILookParameters.a(UILookParametersVar), UILookParametersVar, i, UILookParameters.a(UILookParametersVar2), UILookParametersVar2);
    }

    public boolean CUIVenus_GetMakeupImage(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2, UIVenusPipelineSettings UIVenusPipelineSettingsVar) {
        return UIVenusJNI.CUIVenus_GetMakeupImage(this.mAddr, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, CImageBuffer.a(CImageBufferVar2), CImageBufferVar2, UIVenusPipelineSettings.a(UIVenusPipelineSettingsVar), UIVenusPipelineSettingsVar);
    }

    public boolean CUIVenus_ReleaseMakeupBuffer() {
        return UIVenusJNI.CUIVenus_ReleaseMakeupBuffer(this.mAddr, this);
    }

    public boolean CUIVenus_MakeupLiveInitialize() {
        return UIVenusJNI.CUIVenus_MakeupLiveInitialize(this.mAddr, this);
    }

    public boolean CUIVenus_MakeupLiveUnInitialize() {
        return UIVenusJNI.CUIVenus_MakeupLiveUnInitialize(this.mAddr, this);
    }

    public boolean CUIVenus_SetInternalModelPaths(String str, String str2) {
        return UIVenusJNI.CUIVenus_SetInternalModelPaths(this.mAddr, this, str, str2);
    }

    public boolean CUIVenus_GetInternalModelState(Object obj) {
        return UIVenusJNI.CUIVenus_GetInternalModelState(this.mAddr, this, obj);
    }

    public void CUIVenus_SendFrameBuffer(byte[] bArr, int i, int i2, int i3, boolean z) {
        UIVenusJNI.CUIVenus_SendFrameBuffer(this.mAddr, this, bArr, i, i2, i3, z);
    }

    public boolean CUIVenus_GetFaceRectangle(Object obj) {
        return UIVenusJNI.CUIVenus_GetFaceRectangle(this.mAddr, this, obj);
    }

    public boolean CUIVenus_GetMakeupMetadata(Object[] objArr, Object obj, Object obj2, Object obj3, Object obj4) {
        return UIVenusJNI.CUIVenus_GetMakeupMetadata(this.mAddr, this, objArr, obj, obj2, obj3, obj4);
    }

    public boolean CUIVenus_SetLipstickProfile(Object obj) {
        return UIVenusJNI.CUIVenus_SetLipstickProfile(this.mAddr, this, obj);
    }

    public boolean CUIVenus_SetLipstickIntensity(int i) {
        return UIVenusJNI.CUIVenus_SetLipstickIntensity(this.mAddr, this, i);
    }

    public void CUIVenus_InitialEyeModelCommonInfo(Object[] objArr, int i, int i2) {
        UIVenusJNI.CUIVenus_InitialEyeModelCommonInfo(this.mAddr, this, objArr, i, i2);
    }

    public boolean CUIVenus_PreprocessEyeshadowModel(int[] iArr, Object[] objArr, int[] iArr2, int[] iArr3, int i, int i2, int i3, int i4, int i5, int[] iArr4, int i6, int i7, int i8, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return UIVenusJNI.CUIVenus_PreprocessEyeshadowModel(this.mAddr, this, iArr, objArr, iArr2, iArr3, i, i2, i3, i4, i5, iArr4, i6, i7, i8, bArr, bArr2, bArr3);
    }

    public boolean CUIVenus_PreprocessEyelinerModel(byte[] bArr, Object[] objArr, int i, int i2, int i3, int i4, int i5) {
        return UIVenusJNI.CUIVenus_PreprocessEyelinerModel(this.mAddr, this, bArr, objArr, i, i2, i3, i4, i5);
    }

    public boolean CUIVenus_PreprocessEyelashModel(byte[] bArr, Object[] objArr, int i, int i2, int i3, int i4, int i5) {
        return UIVenusJNI.CUIVenus_PreprocessEyelashModel(this.mAddr, this, bArr, objArr, i, i2, i3, i4, i5);
    }

    public void CUIVenus_SetSkinSmoothFilterStatus(boolean z, float f) {
        UIVenusJNI.CUIVenus_SetSkinSmoothFilterStatus(this.mAddr, this, z, f);
    }

    public boolean CUIVenus_AnalyzeLiveImage(Object obj, Object obj2, int i, int i2, int i3, int[] iArr, float f, float f2, boolean z) {
        return UIVenusJNI.CUIVenus_AnalyzeLiveImage(this.mAddr, this, obj, obj2, i, i2, i3, iArr, f, f2, z);
    }

    public boolean CUIVenus_GetFaceInfos__SWIG_1(Object obj, int i) {
        return UIVenusJNI.CUIVenus_GetFaceInfos__SWIG_1(this.mAddr, this, obj, i);
    }

    public boolean CUIVenus_GetFaceAlignmentData__SWIG_1(Object obj, Object obj2) {
        return UIVenusJNI.CUIVenus_GetFaceAlignmentData__SWIG_1(this.mAddr, this, obj, obj2);
    }

    public boolean CUIVenus_GetIrisRadius__SWIG_1(Object obj, Object obj2) {
        return UIVenusJNI.CUIVenus_GetIrisRadius__SWIG_1(this.mAddr, this, obj, obj2);
    }
}
