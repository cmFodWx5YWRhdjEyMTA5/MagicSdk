package com.cyberlink.youcammakeup.jniproxy;

import java.nio.ByteBuffer;

public class UIVenusJNI {
    public static  native int CUIVenus_AnalyzeImage(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar);

    public static  native boolean CUIVenus_AnalyzeLiveImage(long j, CUIVenus CUIVenusVar, Object obj, Object obj2, int i, int i2, int i3, int[] iArr, float f, float f2, boolean z);

    public static  native int CUIVenus_AutoDetectHairDyeMask(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, UIFaceRect UIFaceRectVar, long j4, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native int CUIVenus_ChangeWigColor(long j, CUIVenus CUIVenusVar, long j2, UIWigColor UIWigColorVar, float f);

    public static  native int CUIVenus_ContinueWarpWigInLocal(long j, CUIVenus CUIVenusVar, long j2, UIFacePoint UIFacePointVar);

    public static  native boolean CUIVenus_DetectOpenMouth(long j, CUIVenus CUIVenusVar, long j2, UIFaceRect UIFaceRectVar);

    public static  native boolean CUIVenus_DumpWigOffsetData(long j, CUIVenus CUIVenusVar, String str);

    public static  native int CUIVenus_EndWarpWigInLocal(long j, CUIVenus CUIVenusVar, long j2, UIWarpedWigImageInfo UIWarpedWigImageInfoVar, long j3, CImageBuffer CImageBufferVar);

    public static  native int CUIVenus_ExtractUserProfile(long j, CUIVenus CUIVenusVar, long j2, UIUserProfile UIUserProfileVar);

    public static  native void CUIVenus_FlipWig(long j, CUIVenus CUIVenusVar, boolean z);

    public static  native int CUIVenus_GenerateHairDyeThumbnail(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, UIColor UIColorVar);

    public static  native int CUIVenus_GetAutoWigLuminanceParameter(long j, CUIVenus CUIVenusVar, long j2, UIFaceRect UIFaceRectVar, long j3, UIWigLuminance UIWigLuminanceVar);

    public static  native int CUIVenus_GetEarringNaturalLookingModelAndTranslation(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, UIFacePoint UIFacePointVar, long j4, UIFacePoint UIFacePointVar2, long j5, UIFacePoint UIFacePointVar3, long j6, UIFacePoint UIFacePointVar4, long j7, UIFaceRect UIFaceRectVar, long j8, UIFaceAlignmentData UIFaceAlignmentDataVar, long j9, UITransform UITransformVar, long j10, UITransform UITransformVar2);

    public static  native int CUIVenus_GetEyebrowOriginalColor(long j, CUIVenus CUIVenusVar, long j2, UIFaceRect UIFaceRectVar, long j3, UIIntVector UIIntVectorVar);

    public static  native int CUIVenus_GetEyewearNaturalLookingModelAndTranslation(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, UIFacePoint UIFacePointVar, long j4, UIFacePoint UIFacePointVar2, int i, long j5, UIFaceRect UIFaceRectVar, long j6, UIFaceAlignmentData UIFaceAlignmentDataVar, long j7, UITransform UITransformVar);

    public static  native int CUIVenus_GetFaceAlignmentData__SWIG_0(long j, CUIVenus CUIVenusVar, long j2, UIFaceRect UIFaceRectVar, long j3, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native boolean CUIVenus_GetFaceAlignmentData__SWIG_1(long j, CUIVenus CUIVenusVar, Object obj, Object obj2);

    public static  native int CUIVenus_GetFaceInfos__SWIG_0(long j, CUIVenus CUIVenusVar, int i, long j2, UIFaceRectVector UIFaceRectVectorVar);

    public static  native boolean CUIVenus_GetFaceInfos__SWIG_1(long j, CUIVenus CUIVenusVar, Object obj, int i);

    public static  native boolean CUIVenus_GetFaceRectangle(long j, CUIVenus CUIVenusVar, Object obj);

    public static  native int CUIVenus_GetHairDyeMask(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar);

    public static  native int CUIVenus_GetHairbandNaturalLookingModelAndTranslation(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, UIFacePoint UIFacePointVar, long j4, UIFacePoint UIFacePointVar2, long j5, UIFaceRect UIFaceRectVar, long j6, UIFaceAlignmentData UIFaceAlignmentDataVar, long j7, UITransform UITransformVar);

    public static  native boolean CUIVenus_GetInternalModelState(long j, CUIVenus CUIVenusVar, Object obj);

    public static  native int CUIVenus_GetIrisRadius__SWIG_0(long j, CUIVenus CUIVenusVar, long j2, UIFaceRect UIFaceRectVar, long j3, UIIrisRadius UIIrisRadiusVar);

    public static  native boolean CUIVenus_GetIrisRadius__SWIG_1(long j, CUIVenus CUIVenusVar, Object obj, Object obj2);

    public static  native int CUIVenus_GetLookParameters(long j, CUIVenus CUIVenusVar, long j2, UILookParameters UILookParametersVar, int i, long j3, UILookParameters UILookParametersVar2);

    public static  native boolean CUIVenus_GetMakeupImage(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, CImageBuffer CImageBufferVar2, long j4, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean CUIVenus_GetMakeupMetadata(long j, CUIVenus CUIVenusVar, Object[] objArr, Object obj, Object obj2, Object obj3, Object obj4);

    public static  native int CUIVenus_GetNecklaceNaturalLookingModelAndTranslation(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, UIFacePoint UIFacePointVar, long j4, UIFacePoint UIFacePointVar2, long j5, UIFaceRect UIFaceRectVar, long j6, UIFaceAlignmentData UIFaceAlignmentDataVar, long j7, UITransform UITransformVar);

    public static  native int CUIVenus_GetWarpedWigModel(long j, CUIVenus CUIVenusVar, long j2, UIWarpedWigImageInfo UIWarpedWigImageInfoVar, long j3, CImageBuffer CImageBufferVar);

    public static  native void CUIVenus_InitialEyeModelCommonInfo(long j, CUIVenus CUIVenusVar, Object[] objArr, int i, int i2);

    public static  native boolean CUIVenus_IsLocalMoveWigDone(long j, CUIVenus CUIVenusVar);

    public static  native boolean CUIVenus_IsModelLoaded(long j, CUIVenus CUIVenusVar);

    public static  native boolean CUIVenus_LoadWigOffsetData(long j, CUIVenus CUIVenusVar, String str);

    public static  native boolean CUIVenus_MakeupLiveInitialize(long j, CUIVenus CUIVenusVar);

    public static  native boolean CUIVenus_MakeupLiveUnInitialize(long j, CUIVenus CUIVenusVar);

    public static  native int CUIVenus_ManualGetFaceAlignmentData(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, long j3, UIFacePoint UIFacePointVar, long j4, UIFacePoint UIFacePointVar2, long j5, UIFacePoint UIFacePointVar3, long j6, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native boolean CUIVenus_PreprocessEyelashModel(long j, CUIVenus CUIVenusVar, byte[] bArr, Object[] objArr, int i, int i2, int i3, int i4, int i5);

    public static  native boolean CUIVenus_PreprocessEyelinerModel(long j, CUIVenus CUIVenusVar, byte[] bArr, Object[] objArr, int i, int i2, int i3, int i4, int i5);

    public static  native boolean CUIVenus_PreprocessEyeshadowModel(long j, CUIVenus CUIVenusVar, int[] iArr, Object[] objArr, int[] iArr2, int[] iArr3, int i, int i2, int i3, int i4, int i5, int[] iArr4, int i6, int i7, int i8, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static  native int CUIVenus_QueryHairDetectionProgress(long j, CUIVenus CUIVenusVar);

    public static  native void CUIVenus_RedoWarpWig(long j, CUIVenus CUIVenusVar);

    public static  native boolean CUIVenus_ReleaseMakeupBuffer(long j, CUIVenus CUIVenusVar);

    public static  native void CUIVenus_ReleaseWigOffsetData(long j, CUIVenus CUIVenusVar);

    public static  native void CUIVenus_ResetWarpWig(long j, CUIVenus CUIVenusVar);

    public static  native void CUIVenus_SendFrameBuffer(long j, CUIVenus CUIVenusVar, byte[] bArr, int i, int i2, int i3, boolean z);

    public static  native int CUIVenus_SetHairDyeMask(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar);

    public static  native boolean CUIVenus_SetInternalModelPaths(long j, CUIVenus CUIVenusVar, String str, String str2);

    public static  native boolean CUIVenus_SetLipstickIntensity(long j, CUIVenus CUIVenusVar, int i);

    public static  native boolean CUIVenus_SetLipstickProfile(long j, CUIVenus CUIVenusVar, Object obj);

    public static  native void CUIVenus_SetSkinSmoothFilterStatus(long j, CUIVenus CUIVenusVar, boolean z, float f);

    public static  native int CUIVenus_SetUserProfileFolder(long j, CUIVenus CUIVenusVar, String str);

    public static  native int CUIVenus_StartWarpWigInLocal(long j, CUIVenus CUIVenusVar, long j2, UITransform UITransformVar, long j3, UIFacePoint UIFacePointVar);

    public static  native void CUIVenus_UndoWarpWig(long j, CUIVenus CUIVenusVar);

    public static  native int CUIVenus_UpdateHairDyeMask(long j, CUIVenus CUIVenusVar, long j2, CImageBuffer CImageBufferVar, ByteBuffer byteBuffer, boolean z, int i);

    public static  native void CUIVenus_setIsHoudini(long j, CUIVenus CUIVenusVar, boolean z);

    public static  native void UIColorVector_add(long j, UIColorVector UIColorVectorVar, long j2, UIColor UIColorVar);

    public static  native void UIColor_setBLevel(long j, UIColor UIColorVar, int i);

    public static  native void UIColor_setGLevel(long j, UIColor UIColorVar, int i);

    public static  native void UIColor_setRLevel(long j, UIColor UIColorVar, int i);

    public static  native boolean UIFaceAlignmentData_equals(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceAlignmentData UIFaceAlignmentDataVar2);

    public static  native long UIFaceAlignmentData_getChin(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getForehead(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getLeftBrow(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getLeftEar(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getLeftEye(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getLeftShape(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getMouth(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getNose(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getRightBrow(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getRightEar(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getRightEye(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long UIFaceAlignmentData_getRightShape(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native void UIFaceAlignmentData_setChin(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceChin UIFaceChinVar);

    public static  native void UIFaceAlignmentData_setForehead(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceForehead UIFaceForeheadVar);

    public static  native void UIFaceAlignmentData_setLeftBrow(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceBrow UIFaceBrowVar);

    public static  native void UIFaceAlignmentData_setLeftEar(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceEar UIFaceEarVar);

    public static  native void UIFaceAlignmentData_setLeftEye(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceEye UIFaceEyeVar);

    public static  native void UIFaceAlignmentData_setLeftShape(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceShape UIFaceShapeVar);

    public static  native void UIFaceAlignmentData_setMouth(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceAlignmentData_setNose(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceNose UIFaceNoseVar);

    public static  native void UIFaceAlignmentData_setRightBrow(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceBrow UIFaceBrowVar);

    public static  native void UIFaceAlignmentData_setRightEar(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceEar UIFaceEarVar);

    public static  native void UIFaceAlignmentData_setRightEye(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceEye UIFaceEyeVar);

    public static  native void UIFaceAlignmentData_setRightShape(long j, UIFaceAlignmentData UIFaceAlignmentDataVar, long j2, UIFaceShape UIFaceShapeVar);

    public static  native long UIFaceBrow_bottom_get(long j, UIFaceBrow UIFaceBrowVar);

    public static  native void UIFaceBrow_bottom_set(long j, UIFaceBrow UIFaceBrowVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceBrow_left_get(long j, UIFaceBrow UIFaceBrowVar);

    public static  native void UIFaceBrow_left_set(long j, UIFaceBrow UIFaceBrowVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceBrow_right_get(long j, UIFaceBrow UIFaceBrowVar);

    public static  native void UIFaceBrow_right_set(long j, UIFaceBrow UIFaceBrowVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceBrow_top_get(long j, UIFaceBrow UIFaceBrowVar);

    public static  native void UIFaceBrow_top_set(long j, UIFaceBrow UIFaceBrowVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceChin_center_get(long j, UIFaceChin UIFaceChinVar);

    public static  native void UIFaceChin_center_set(long j, UIFaceChin UIFaceChinVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceEar_bottom_get(long j, UIFaceEar UIFaceEarVar);

    public static  native void UIFaceEar_bottom_set(long j, UIFaceEar UIFaceEarVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceEar_top_get(long j, UIFaceEar UIFaceEarVar);

    public static  native void UIFaceEar_top_set(long j, UIFaceEar UIFaceEarVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceEye_bottom_get(long j, UIFaceEye UIFaceEyeVar);

    public static  native void UIFaceEye_bottom_set(long j, UIFaceEye UIFaceEyeVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceEye_center_get(long j, UIFaceEye UIFaceEyeVar);

    public static  native void UIFaceEye_center_set(long j, UIFaceEye UIFaceEyeVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceEye_left_get(long j, UIFaceEye UIFaceEyeVar);

    public static  native void UIFaceEye_left_set(long j, UIFaceEye UIFaceEyeVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceEye_right_get(long j, UIFaceEye UIFaceEyeVar);

    public static  native void UIFaceEye_right_set(long j, UIFaceEye UIFaceEyeVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceEye_top_get(long j, UIFaceEye UIFaceEyeVar);

    public static  native void UIFaceEye_top_set(long j, UIFaceEye UIFaceEyeVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceForehead_left_get(long j, UIFaceForehead UIFaceForeheadVar);

    public static  native void UIFaceForehead_left_set(long j, UIFaceForehead UIFaceForeheadVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceForehead_middle_get(long j, UIFaceForehead UIFaceForeheadVar);

    public static  native void UIFaceForehead_middle_set(long j, UIFaceForehead UIFaceForeheadVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceForehead_right_get(long j, UIFaceForehead UIFaceForeheadVar);

    public static  native void UIFaceForehead_right_set(long j, UIFaceForehead UIFaceForeheadVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIFaceModelCacheVector_add(long j, UIFaceModelCacheVector UIFaceModelCacheVectorVar, String str);

    public static  native void UIFaceModelCacheVector_clear(long j, UIFaceModelCacheVector UIFaceModelCacheVectorVar);

    public static  native String UIFaceModelCacheVector_get(long j, UIFaceModelCacheVector UIFaceModelCacheVectorVar, int i);

    public static  native long UIFaceModelCacheVector_size(long j, UIFaceModelCacheVector UIFaceModelCacheVectorVar);

    public static  native long UIFaceMouth_bottomLip1_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_bottomLip1_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_bottomLip2_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_bottomLip2_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpBottomLeft_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpBottomLeft_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpBottomRight_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpBottomRight_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpInnerLeft_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpInnerLeft_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpInnerRight_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpInnerRight_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpLowerLeft_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpLowerLeft_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpLowerRight_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpLowerRight_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpTopLeft_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpTopLeft_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpTopRight_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpTopRight_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpUpperLeft_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpUpperLeft_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_interpUpperRight_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_interpUpperRight_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_leftCorner_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_leftCorner_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_rightCorner_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_rightCorner_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_topLip1_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_topLip1_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceMouth_topLip2_get(long j, UIFaceMouth UIFaceMouthVar);

    public static  native void UIFaceMouth_topLip2_set(long j, UIFaceMouth UIFaceMouthVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceNose_bottom_get(long j, UIFaceNose UIFaceNoseVar);

    public static  native void UIFaceNose_bottom_set(long j, UIFaceNose UIFaceNoseVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceNose_bridgeTop_get(long j, UIFaceNose UIFaceNoseVar);

    public static  native void UIFaceNose_bridgeTop_set(long j, UIFaceNose UIFaceNoseVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceNose_left_get(long j, UIFaceNose UIFaceNoseVar);

    public static  native void UIFaceNose_left_set(long j, UIFaceNose UIFaceNoseVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceNose_right_get(long j, UIFaceNose UIFaceNoseVar);

    public static  native void UIFaceNose_right_set(long j, UIFaceNose UIFaceNoseVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceNose_top_get(long j, UIFaceNose UIFaceNoseVar);

    public static  native void UIFaceNose_top_set(long j, UIFaceNose UIFaceNoseVar, long j2, UIFacePoint UIFacePointVar);

    public static  native float UIFacePoint_x_get(long j, UIFacePoint UIFacePointVar);

    public static  native void UIFacePoint_x_set(long j, UIFacePoint UIFacePointVar, float f);

    public static  native float UIFacePoint_y_get(long j, UIFacePoint UIFacePointVar);

    public static  native void UIFacePoint_y_set(long j, UIFacePoint UIFacePointVar, float f);

    public static  native long UIFaceRectVector_get(long j, UIFaceRectVector UIFaceRectVectorVar, int i);

    public static  native long UIFaceRectVector_size(long j, UIFaceRectVector UIFaceRectVectorVar);

    public static  native int UIFaceRect_getBottom(long j, UIFaceRect UIFaceRectVar);

    public static  native int UIFaceRect_getLeft(long j, UIFaceRect UIFaceRectVar);

    public static  native int UIFaceRect_getRight(long j, UIFaceRect UIFaceRectVar);

    public static  native int UIFaceRect_getTop(long j, UIFaceRect UIFaceRectVar);

    public static  native void UIFaceRect_setBottom(long j, UIFaceRect UIFaceRectVar, int i);

    public static  native void UIFaceRect_setLeft(long j, UIFaceRect UIFaceRectVar, int i);

    public static  native void UIFaceRect_setRight(long j, UIFaceRect UIFaceRectVar, int i);

    public static  native void UIFaceRect_setTop(long j, UIFaceRect UIFaceRectVar, int i);

    public static  native long UIFaceShape_shape1_get(long j, UIFaceShape UIFaceShapeVar);

    public static  native void UIFaceShape_shape1_set(long j, UIFaceShape UIFaceShapeVar, long j2, UIFacePoint UIFacePointVar);

    public static  native long UIFaceShape_shape2_get(long j, UIFaceShape UIFaceShapeVar);

    public static  native void UIFaceShape_shape2_set(long j, UIFaceShape UIFaceShapeVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIFaceTattooColorVector_add(long j, UIFaceTattooColorVector UIFaceTattooColorVectorVar, long j2, UIFaceTattooColor UIFaceTattooColorVar);

    public static  native void UIFaceTattooColor_setBRatio(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setBrightness(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setColorAdjustable(long j, UIFaceTattooColor UIFaceTattooColorVar, boolean z);

    public static  native void UIFaceTattooColor_setContrastFirstNewy(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setContrastFirstOldy(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setContrastSecondNewy(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setContrastSecondOldy(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setGRatio(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setLuminanceParameter(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIFaceTattooColor_setRRatio(long j, UIFaceTattooColor UIFaceTattooColorVar, int i);

    public static  native void UIIntPointVector_add(long j, UIIntPointVector UIIntPointVectorVar, long j2, UIIntPoint UIIntPointVar);

    public static  native void UIIntPoint_x_set(long j, UIIntPoint UIIntPointVar, int i);

    public static  native void UIIntPoint_y_set(long j, UIIntPoint UIIntPointVar, int i);

    public static  native void UIIntVector_add(long j, UIIntVector UIIntVectorVar, int i);

    public static  native int UIIntVector_get(long j, UIIntVector UIIntVectorVar, int i);

    public static  native long UIIntVector_size(long j, UIIntVector UIIntVectorVar);

    public static  native int UIIrisRadius_getValue(long j, UIIrisRadius UIIrisRadiusVar);

    public static  native void UIIrisRadius_setValue(long j, UIIrisRadius UIIrisRadiusVar, int i);

    public static  native void UILookParameters_dumpDebugString(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getAntiShineIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getBlushIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getDoubleEyelidsIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getEyeBrowHiddenIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getEyeBrowIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getEyeContactsIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getEyeLashIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getEyeLinerIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getEyeShadowCount(long j, UILookParameters UILookParametersVar);

    public static  native void UILookParameters_getEyeShadowIntensity(long j, UILookParameters UILookParametersVar, long j2, UIIntVector UIIntVectorVar);

    public static  native void UILookParameters_getEyeShadowShimmerIntensity(long j, UILookParameters UILookParametersVar, long j2, UIIntVector UIIntVectorVar);

    public static  native int UILookParameters_getFaceContourIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getHairDyeIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getLipStickIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getNoseEnhancementIntentsity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getSkinSmoothIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getSkinToneIntensity(long j, UILookParameters UILookParametersVar);

    public static  native int UILookParameters_getSparkleEyeIntensity(long j, UILookParameters UILookParametersVar);

    public static  native void UILookParameters_setAntiShineIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setBlushIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setDoubleEyelidsIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setEyeBrowHiddenIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setEyeBrowIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setEyeContactsIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setEyeLashIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setEyeLinerIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setEyeShadowCount(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setEyeShadowIntensity(long j, UILookParameters UILookParametersVar, long j2, UIIntVector UIIntVectorVar);

    public static  native void UILookParameters_setEyeShadowShimmerIntensity(long j, UILookParameters UILookParametersVar, long j2, UIIntVector UIIntVectorVar);

    public static  native void UILookParameters_setFaceContourIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setHairDyeIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setLipStickIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setNoseEnhancementIntentsity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setSkinSmoothIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setSkinToneIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UILookParameters_setSparkleEyeIntensity(long j, UILookParameters UILookParametersVar, int i);

    public static  native void UIModelBrowEngineRect_head_set(long j, UIModelBrowEngineRect UIModelBrowEngineRectVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIModelBrowEngineRect_tail_set(long j, UIModelBrowEngineRect UIModelBrowEngineRectVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIModelBrowEngineRect_top_set(long j, UIModelBrowEngineRect UIModelBrowEngineRectVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIModelEyeRect_bottom_set(long j, UIModelEyeRect UIModelEyeRectVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIModelEyeRect_left_set(long j, UIModelEyeRect UIModelEyeRectVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIModelEyeRect_right_set(long j, UIModelEyeRect UIModelEyeRectVar, long j2, UIFacePoint UIFacePointVar);

    public static  native void UIModelEyeRect_top_set(long j, UIModelEyeRect UIModelEyeRectVar, long j2, UIFacePoint UIFacePointVar);

    public static  native float UITransform_getRotation(long j, UITransform UITransformVar);

    public static  native float UITransform_getScale(long j, UITransform UITransformVar);

    public static  native float UITransform_getShiftX(long j, UITransform UITransformVar);

    public static  native float UITransform_getShiftY(long j, UITransform UITransformVar);

    public static  native void UITransform_setRotation(long j, UITransform UITransformVar, float f);

    public static  native void UITransform_setScale(long j, UITransform UITransformVar, float f);

    public static  native void UITransform_setShiftX(long j, UITransform UITransformVar, float f);

    public static  native void UITransform_setShiftY(long j, UITransform UITransformVar, float f);

    public static  native int UIUserProfile_getEyebrowColor(long j, UIUserProfile UIUserProfileVar);

    public static  native int UIUserProfile_getGender(long j, UIUserProfile UIUserProfileVar);

    public static  native int UIUserProfile_getHairColor(long j, UIUserProfile UIUserProfileVar);

    public static  native int UIUserProfile_getIrisColor(long j, UIUserProfile UIUserProfileVar);

    public static  native int UIUserProfile_getLipColor(long j, UIUserProfile UIUserProfileVar);

    public static  native int UIUserProfile_getSkinColor(long j, UIUserProfile UIUserProfileVar);

    public static  native int UIUserProfile_getStatus(long j, UIUserProfile UIUserProfileVar);

    public static  native void UIVenusPipelineSettings_UpdateEyeBrowAutoHiddenFlag(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z);

    public static  native void UIVenusPipelineSettings_UpdateEyeBrowAutoMatchFlag(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z);

    public static  native void UIVenusPipelineSettings_configAntiShine(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i);

    public static  native void UIVenusPipelineSettings_configAutoSpotRemoval(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z);

    public static  native void UIVenusPipelineSettings_configBlush(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, long j2, UIColor UIColorVar, String str, String str2, boolean z);

    public static  native void UIVenusPipelineSettings_configBrow(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIColor UIColorVar, long j3, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j4, UIFaceModelCacheVector UIFaceModelCacheVectorVar2, long j5, UIModelBrowEngineRect UIModelBrowEngineRectVar, long j6, UIModelBrowEngineRect UIModelBrowEngineRectVar2, long j7, UIModelBrowEngineRect UIModelBrowEngineRectVar3, String str, boolean z, boolean z2, int i3, long j8, UIFaceBrow UIFaceBrowVar, long j9, UIFaceBrow UIFaceBrowVar2);

    public static  native void UIVenusPipelineSettings_configCacheMode(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i);

    public static  native void UIVenusPipelineSettings_configClassicLipstick(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, boolean z, int i2, int i3, int i4, int i5);

    public static  native void UIVenusPipelineSettings_configDoubleEyelid(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, long j2, UIColor UIColorVar, long j3, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j4, UIModelEyeRect UIModelEyeRectVar, String str);

    public static  native void UIVenusPipelineSettings_configEyeContact(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, float f, int i2, long j2, UIColorVector UIColorVectorVar, long j3, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j4, UIFaceModelCacheVector UIFaceModelCacheVectorVar2);

    public static  native void UIVenusPipelineSettings_configEyebrowTattooLeft(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyebrowTattooRight(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyelash(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, long j2, UIColor UIColorVar, long j3, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j4, UIModelEyeRect UIModelEyeRectVar, String str, int i2);

    public static  native void UIVenusPipelineSettings_configEyelashTattooLeftLower(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyelashTattooLeftUpper(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyelashTattooResetAll(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native void UIVenusPipelineSettings_configEyelashTattooRightLower(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyelashTattooRightUpper(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyeliner(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, long j2, UIColor UIColorVar, long j3, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j4, UIModelEyeRect UIModelEyeRectVar, String str, int i2);

    public static  native void UIVenusPipelineSettings_configEyelinerTattooLeft(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyelinerTattooRight(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyeshadow(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UIIntVector UIIntVectorVar, long j3, UIColorVector UIColorVectorVar, long j4, UIIntVector UIIntVectorVar2, long j5, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j6, UIModelEyeRect UIModelEyeRectVar, String str, long j7, UIFaceModelCacheVector UIFaceModelCacheVectorVar2, long j8, UIIntVector UIIntVectorVar3, int i);

    public static  native void UIVenusPipelineSettings_configEyeshadowTattooLeft(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configEyeshadowTattooRight(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, int i2, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIModelEyeRect UIModelEyeRectVar);

    public static  native void UIVenusPipelineSettings_configFaceArt(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIIntPointVector UIIntPointVectorVar, long j4, UIFaceTattooColorVector UIFaceTattooColorVectorVar);

    public static  native void UIVenusPipelineSettings_configFaceContour(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i);

    public static  native void UIVenusPipelineSettings_configFaceData(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UIFaceRect UIFaceRectVar, long j3, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native void UIVenusPipelineSettings_configFaceWidget(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UIFaceModelCacheVector UIFaceModelCacheVectorVar, long j3, UIIntPointVector UIIntPointVectorVar, long j4, UIFaceTattooColorVector UIFaceTattooColorVectorVar);

    public static  native void UIVenusPipelineSettings_configHairDye(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, float f, long j2, UIColor UIColorVar);

    public static  native void UIVenusPipelineSettings_configKoreanStyleLipstick(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public static  native void UIVenusPipelineSettings_configMouthOpen(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z);

    public static  native void UIVenusPipelineSettings_configNoseEnhancement(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i);

    public static  native void UIVenusPipelineSettings_configOriginalEyeBrow(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UIFaceBrow UIFaceBrowVar, long j3, UIFaceBrow UIFaceBrowVar2);

    public static  native void UIVenusPipelineSettings_configSkinSmooth(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i);

    public static  native void UIVenusPipelineSettings_configSkinTone(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i, long j2, UIColor UIColorVar);

    public static  native void UIVenusPipelineSettings_configSparkleEye(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, int i);

    public static  native void UIVenusPipelineSettings_configWig(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j2, UITransform UITransformVar, long j3, UIWigColor UIWigColorVar, long j4, UIFaceModelCacheVector UIFaceModelCacheVectorVar, int i);

    public static  native void UIVenusPipelineSettings_configWigTransform(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UITransform UITransformVar);

    public static  native boolean UIVenusPipelineSettings_getBrowAutoHiddenFlag(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_getBrowAutoMatchFlag(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native int UIVenusPipelineSettings_getBrowHiddenIntensity(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_getEnableEyeBrow(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_getEnableEyeContact(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_getEnableHairDye(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_getEnableWig(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native long UIVenusPipelineSettings_getEyeContactColor(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native int UIVenusPipelineSettings_getEyeContactIntensity(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native float UIVenusPipelineSettings_getEyeContactIntensitySize(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native int UIVenusPipelineSettings_getEyeContactIrisRadius(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native long UIVenusPipelineSettings_getEyeContactMaskModelCache(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native long UIVenusPipelineSettings_getEyeContactModelCache(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_getIsWigModelChange(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native void UIVenusPipelineSettings_getOriginalEyeBrow(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UIFaceBrow UIFaceBrowVar, long j3, UIFaceBrow UIFaceBrowVar2);

    public static  native void UIVenusPipelineSettings_getWarpedWigImageInfo(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UIWarpedWigImageInfo UIWarpedWigImageInfoVar);

    public static  native void UIVenusPipelineSettings_getWarpedWigTransform(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, long j2, UITransform UITransformVar);

    public static  native long UIVenusPipelineSettings_getWigCache(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_isForceApplyWigPosition(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native boolean UIVenusPipelineSettings_isModelBrowRectAllZero(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native int UIVenusPipelineSettings_queryCacheMode(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native long UIVenusPipelineSettings_queryFaceRect(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native long UIVenusPipelineSettings_queryFeaturePoints(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native void UIVenusPipelineSettings_setEnableWig(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z);

    public static  native void UIVenusPipelineSettings_setForceApplyWigPosition(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z);

    public static  native void UIVenusPipelineSettings_setIsWigModelChange(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar, boolean z);

    public static  native int UIWarpedWigImageInfo_height_get(long j, UIWarpedWigImageInfo UIWarpedWigImageInfoVar);

    public static  native int UIWarpedWigImageInfo_width_get(long j, UIWarpedWigImageInfo UIWarpedWigImageInfoVar);

    public static  native void UIWigColor_setBRatio(long j, UIWigColor UIWigColorVar, int i);

    public static  native void UIWigColor_setBrightness(long j, UIWigColor UIWigColorVar, int i);

    public static  native void UIWigColor_setContrastFirstNewy(long j, UIWigColor UIWigColorVar, int i);

    public static  native void UIWigColor_setContrastFirstOldy(long j, UIWigColor UIWigColorVar, int i);

    public static  native void UIWigColor_setContrastSecondNewy(long j, UIWigColor UIWigColorVar, int i);

    public static  native void UIWigColor_setContrastSecondOldy(long j, UIWigColor UIWigColorVar, int i);

    public static  native void UIWigColor_setGRatio(long j, UIWigColor UIWigColorVar, int i);

    public static  native void UIWigColor_setRRatio(long j, UIWigColor UIWigColorVar, int i);

    public static  native int UIWigLuminance_getValue(long j, UIWigLuminance UIWigLuminanceVar);

    public static  native void UIWigLuminance_setValue(long j, UIWigLuminance UIWigLuminanceVar, int i);

    public static  native void delete_CUIVenus(long j);

    public static  native void delete_UIColor(long j);

    public static  native void delete_UIColorVector(long j);

    public static  native void delete_UIFaceAlignmentData(long j);

    public static  native void delete_UIFaceBrow(long j);

    public static  native void delete_UIFaceChin(long j);

    public static  native void delete_UIFaceEar(long j);

    public static  native void delete_UIFaceEye(long j);

    public static  native void delete_UIFaceForehead(long j);

    public static  native void delete_UIFaceModelCacheVector(long j);

    public static  native void delete_UIFaceMouth(long j);

    public static  native void delete_UIFaceNose(long j);

    public static  native void delete_UIFacePoint(long j);

    public static  native void delete_UIFaceRect(long j);

    public static  native void delete_UIFaceRectVector(long j);

    public static  native void delete_UIFaceShape(long j);

    public static  native void delete_UIFaceTattooColor(long j);

    public static  native void delete_UIFaceTattooColorVector(long j);

    public static  native void delete_UIIntPoint(long j);

    public static  native void delete_UIIntPointVector(long j);

    public static  native void delete_UIIntVector(long j);

    public static  native void delete_UIIrisRadius(long j);

    public static  native void delete_UILookParameters(long j);

    public static  native void delete_UIModelBrowEngineRect(long j);

    public static  native void delete_UIModelEyeRect(long j);

    public static  native void delete_UITransform(long j);

    public static  native void delete_UIUserProfile(long j);

    public static  native void delete_UIVenusPipelineSettings(long j);

    public static  native void delete_UIWarpedWigImageInfo(long j);

    public static  native void delete_UIWigColor(long j);

    public static  native void delete_UIWigLuminance(long j);

    public static  native long new_CUIVenus(String str, String str2, String str3, String str4);

    public static  native long new_UIColorVector__SWIG_0();

    public static  native long new_UIColor__SWIG_0();

    public static  native long new_UIColor__SWIG_1(int i, int i2, int i3);

    public static  native long new_UIFaceAlignmentData__SWIG_0();

    public static  native long new_UIFaceAlignmentData__SWIG_1(long j, UIFaceAlignmentData UIFaceAlignmentDataVar);

    public static  native long new_UIFaceBrow();

    public static  native long new_UIFaceChin();

    public static  native long new_UIFaceEar();

    public static  native long new_UIFaceEye();

    public static  native long new_UIFaceForehead();

    public static  native long new_UIFaceModelCacheVector__SWIG_0();

    public static  native long new_UIFaceMouth();

    public static  native long new_UIFaceNose();

    public static  native long new_UIFacePoint__SWIG_0();

    public static  native long new_UIFacePoint__SWIG_1(long j, UIFacePoint UIFacePointVar);

    public static  native long new_UIFaceRectVector__SWIG_0();

    public static  native long new_UIFaceRect__SWIG_0();

    public static  native long new_UIFaceRect__SWIG_1(long j, UIFaceRect UIFaceRectVar);

    public static  native long new_UIFaceShape();

    public static  native long new_UIFaceTattooColor();

    public static  native long new_UIFaceTattooColorVector__SWIG_0();

    public static  native long new_UIIntPointVector__SWIG_0();

    public static  native long new_UIIntPoint__SWIG_0();

    public static  native long new_UIIntVector__SWIG_0();

    public static  native long new_UIIrisRadius__SWIG_0();

    public static  native long new_UIIrisRadius__SWIG_1(long j, UIIrisRadius UIIrisRadiusVar);

    public static  native long new_UILookParameters();

    public static  native long new_UIModelBrowEngineRect();

    public static  native long new_UIModelEyeRect();

    public static  native long new_UITransform__SWIG_0();

    public static  native long new_UITransform__SWIG_1(long j, UITransform UITransformVar);

    public static  native long new_UIUserProfile__SWIG_0();

    public static  native long new_UIVenusPipelineSettings__SWIG_0();

    public static  native long new_UIVenusPipelineSettings__SWIG_1(long j, UIVenusPipelineSettings UIVenusPipelineSettingsVar);

    public static  native long new_UIWarpedWigImageInfo__SWIG_0();

    public static  native long new_UIWigColor__SWIG_0();

    public static  native long new_UIWigLuminance__SWIG_0();

    public static  native long new_UIWigLuminance__SWIG_1(long j, UIWigLuminance UIWigLuminanceVar);


}
