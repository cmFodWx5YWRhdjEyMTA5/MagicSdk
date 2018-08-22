package com.cyberlink.youcammakeup.jniproxy;

public class UIImageCodecJNI {
    public static final native boolean ImageCodec_CalcOutputDimension(long j, ImageCodec imageCodecVar, String str, int i, long j2, long j3, UIImageDimension UIImageDimensionVar);

    public static final native boolean ImageCodec_CalcOutputDimensionFromBuffer(long j, ImageCodec imageCodecVar, byte[] bArr, int i, int i2, long j2, long j3, UIImageDimension UIImageDimensionVar);

    public static final native int ImageCodec_DecodeFromBuffer__SWIG_1(long j, ImageCodec imageCodecVar, byte[] bArr, int i, long j2, CImageBuffer CImageBufferVar, long j3, UIDecodeParamRef UIDecodeParamRefVar);

    public static final native int ImageCodec_DecodeFromFile__SWIG_0(long j, ImageCodec imageCodecVar, String str, long j2, CImageBuffer CImageBufferVar, long j3, UIDecodeParamRef UIDecodeParamRefVar, long j4, UICancellationToken UICancellationTokenVar);

    public static final native int ImageCodec_DecodeFromFile__SWIG_1(long j, ImageCodec imageCodecVar, String str, long j2, CImageBuffer CImageBufferVar, long j3, UIDecodeParamRef UIDecodeParamRefVar);

    public static final native void ImageCodec_DumpMetadata(long j, ImageCodec imageCodecVar, long j2, UIMetadata UIMetadataVar);

    public static final native int ImageCodec_EncodeToFile__SWIG_0(long j, ImageCodec imageCodecVar, String str, long j2, CImageBuffer CImageBufferVar, long j3, UIEncodeParamRef UIEncodeParamRefVar, long j4, UIMetadata UIMetadataVar, long j5, UICancellationToken UICancellationTokenVar);

    public static final native int ImageCodec_EncodeToFile__SWIG_1(long j, ImageCodec imageCodecVar, String str, long j2, CImageBuffer CImageBufferVar, long j3, UIEncodeParamRef UIEncodeParamRefVar, long j4, UIMetadata UIMetadataVar);

    public static final native boolean ImageCodec_GetMetadataFromBuffer(long j, ImageCodec imageCodecVar, byte[] bArr, int i, long j2, UIMetadata UIMetadataVar);

    public static final native boolean ImageCodec_GetMetadataFromFile(long j, ImageCodec imageCodecVar, String str, long j2, UIMetadata UIMetadataVar);

    public static final native boolean ImageCodec_GetThumbnailFromFile__SWIG_0(long j, ImageCodec imageCodecVar, String str, long j2, CImageBuffer CImageBufferVar, boolean z);

    public static final native boolean ImageCodec_GetThumbnailFromFile__SWIG_1(long j, ImageCodec imageCodecVar, String str, long j2, CImageBuffer CImageBufferVar);

    public static final native boolean ImageCodec_GetThumbnailPropertyFromFile(long j, ImageCodec imageCodecVar, String str, long j2, UIThumbnailProperty UIThumbnailPropertyVar);

    public static final native boolean ImageCodec_RotateFlip(long j, ImageCodec imageCodecVar, long j2, CImageBuffer CImageBufferVar, long j3, CImageBuffer CImageBufferVar2, int i);

    public static final native boolean ImageCodec_Stretch__SWIG_0(long j, ImageCodec imageCodecVar, long j2, CImageBuffer CImageBufferVar, long j3, CImageBuffer CImageBufferVar2, int i);

    public static final native boolean ImageCodec_Stretch__SWIG_1(long j, ImageCodec imageCodecVar, long j2, CImageBuffer CImageBufferVar, long j3, CImageBuffer CImageBufferVar2);

    public static final native void UICancellationToken_Cancel(long j, UICancellationToken UICancellationTokenVar);

    public static final native boolean UICancellationToken_IsCancelled(long j, UICancellationToken UICancellationTokenVar);

    public static final native void UIDecodeParamRef_nBytePerPixel_set(long j, UIDecodeParamRef UIDecodeParamRefVar, int i);

    public static final native void UIDecodeParamRef_nFormat_set(long j, UIDecodeParamRef UIDecodeParamRefVar, int i);

    public static final native void UIDecodeParamRef_ulHeight_set(long j, UIDecodeParamRef UIDecodeParamRefVar, long j2);

    public static final native void UIDecodeParamRef_ulSampleSize_set(long j, UIDecodeParamRef UIDecodeParamRefVar, long j2);

    public static final native void UIDecodeParamRef_ulWidth_set(long j, UIDecodeParamRef UIDecodeParamRefVar, long j2);

    public static final native int UIEncodeParamRef_GetFormat(long j, UIEncodeParamRef UIEncodeParamRefVar);

    public static final native void UIEncodeParamRef_SetFormat(long j, UIEncodeParamRef UIEncodeParamRefVar, int i);

    public static final native void UIEncodeParamRef_SetImageOrientation(long j, UIEncodeParamRef UIEncodeParamRefVar, int i);

    public static final native void UIEncodeParamRef_SetQuality(long j, UIEncodeParamRef UIEncodeParamRefVar, int i);

    public static final native int UIExifInfo_nColorSpace_get(long j, UIExifInfo UIExifInfoVar);

    public static final native int UIFileInfo_nFormat_get(long j, UIFileInfo UIFileInfoVar);

    public static final native int UIFileInfo_nOrientation_get(long j, UIFileInfo UIFileInfoVar);

    public static final native long UIFileInfo_ulHeight_get(long j, UIFileInfo UIFileInfoVar);

    public static final native void UIFileInfo_ulHeight_set(long j, UIFileInfo UIFileInfoVar, long j2);

    public static final native long UIFileInfo_ulWidth_get(long j, UIFileInfo UIFileInfoVar);

    public static final native void UIFileInfo_ulWidth_set(long j, UIFileInfo UIFileInfoVar, long j2);

    public static final native long UIImageDimension_ulHeight_get(long j, UIImageDimension UIImageDimensionVar);

    public static final native void UIImageDimension_ulHeight_set(long j, UIImageDimension UIImageDimensionVar, long j2);

    public static final native long UIImageDimension_ulWidth_get(long j, UIImageDimension UIImageDimensionVar);

    public static final native void UIImageDimension_ulWidth_set(long j, UIImageDimension UIImageDimensionVar, long j2);

    public static final native long UIMetadata_exifInfo_get(long j, UIMetadata UIMetadataVar);

    public static final native long UIMetadata_fileInfo_get(long j, UIMetadata UIMetadataVar);

    public static final native long UIThumbnailPropertyItemVector_get(long j, UIThumbnailPropertyItemVector UIThumbnailPropertyItemVectorVar, int i);

    public static final native long UIThumbnailPropertyItemVector_size(long j, UIThumbnailPropertyItemVector UIThumbnailPropertyItemVectorVar);

    public static final native long UIThumbnailPropertyItem_nHeight_get(long j, UIThumbnailPropertyItem UIThumbnailPropertyItemVar);

    public static final native int UIThumbnailPropertyItem_nOrientation_get(long j, UIThumbnailPropertyItem UIThumbnailPropertyItemVar);

    public static final native int UIThumbnailPropertyItem_nType_get(long j, UIThumbnailPropertyItem UIThumbnailPropertyItemVar);

    public static final native long UIThumbnailPropertyItem_nWidth_get(long j, UIThumbnailPropertyItem UIThumbnailPropertyItemVar);

    public static final native long UIThumbnailProperty_items_get(long j, UIThumbnailProperty UIThumbnailPropertyVar);

    public static final native void delete_ImageCodec(long j);

    public static final native void delete_UICancellationToken(long j);

    public static final native void delete_UIDecodeParamRef(long j);

    public static final native void delete_UIEncodeParamRef(long j);

    public static final native void delete_UIExifInfo(long j);

    public static final native void delete_UIFileInfo(long j);

    public static final native void delete_UIImageDimension(long j);

    public static final native void delete_UIMetadata(long j);

    public static final native void delete_UIThumbnailProperty(long j);

    public static final native void delete_UIThumbnailPropertyItem(long j);

    public static final native void delete_UIThumbnailPropertyItemVector(long j);

    public static final native long new_ImageCodec(String str);

    public static final native long new_UICancellationToken();

    public static final native long new_UIDecodeParamRef();

    public static final native long new_UIEncodeParamRef__SWIG_0();

    public static final native long new_UIEncodeParamRef__SWIG_1(int i, int i2, int i3, int i4, int i5, int i6);

    public static final native long new_UIExifInfo();

    public static final native long new_UIFileInfo();

    public static final native long new_UIImageDimension__SWIG_0();

    public static final native long new_UIMetadata();

    public static final native long new_UIThumbnailProperty();

    public static final native long new_UIThumbnailPropertyItem();

    public static final native long new_UIThumbnailPropertyItemVector__SWIG_0();

}
