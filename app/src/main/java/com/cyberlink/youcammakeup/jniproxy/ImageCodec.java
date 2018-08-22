package com.cyberlink.youcammakeup.jniproxy;

public class ImageCodec {
    protected boolean a;
    private long b;

    protected ImageCodec(long j, boolean z) {
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
                UIImageCodecJNI.delete_ImageCodec(this.b);
            }
            this.b = 0;
        }
    }

    public ImageCodec(String str) {
        this(UIImageCodecJNI.new_ImageCodec(str), true);
    }

    public boolean a(byte[] bArr, int i, UIMetadata UIMetadataVar) {
        return UIImageCodecJNI.ImageCodec_GetMetadataFromBuffer(this.b, this, bArr, i, UIMetadata.a(UIMetadataVar), UIMetadataVar);
    }

    public boolean a(String str, UIMetadata UIMetadataVar) {
        return UIImageCodecJNI.ImageCodec_GetMetadataFromFile(this.b, this, str, UIMetadata.a(UIMetadataVar), UIMetadataVar);
    }

    public UIImageCodecErrorCode a(String str, CImageBuffer CImageBufferVar, UIDecodeParamRef UIDecodeParamRefVar, UICancellationToken UICancellationTokenVar) {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_DecodeFromFile__SWIG_0(this.b, this, str, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIDecodeParamRef.a(UIDecodeParamRefVar), UIDecodeParamRefVar, UICancellationToken.a(UICancellationTokenVar), UICancellationTokenVar));
    }

    public UIImageCodecErrorCode a(String str, CImageBuffer CImageBufferVar, UIDecodeParamRef UIDecodeParamRefVar) {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_DecodeFromFile__SWIG_1(this.b, this, str, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIDecodeParamRef.a(UIDecodeParamRefVar), UIDecodeParamRefVar));
    }

    public UIImageCodecErrorCode a(byte[] bArr, int i, CImageBuffer CImageBufferVar, UIDecodeParamRef UIDecodeParamRefVar) {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_DecodeFromBuffer__SWIG_1(this.b, this, bArr, i, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIDecodeParamRef.a(UIDecodeParamRefVar), UIDecodeParamRefVar));
    }

    public boolean a(byte[] bArr, int i, UIImageFormat uIImageFormat, long j, UIImageDimension UIImageDimensionVar) {
        return UIImageCodecJNI.ImageCodec_CalcOutputDimensionFromBuffer(this.b, this, bArr, i, uIImageFormat.a(), j, UIImageDimension.a(UIImageDimensionVar), UIImageDimensionVar);
    }

    public boolean a(String str, UIImageFormat uIImageFormat, long j, UIImageDimension UIImageDimensionVar) {
        return UIImageCodecJNI.ImageCodec_CalcOutputDimension(this.b, this, str, uIImageFormat.a(), j, UIImageDimension.a(UIImageDimensionVar), UIImageDimensionVar);
    }

    public boolean a(String str, CImageBuffer CImageBufferVar, boolean z) {
        return UIImageCodecJNI.ImageCodec_GetThumbnailFromFile__SWIG_0(this.b, this, str, CImageBuffer.a(CImageBufferVar), CImageBufferVar, z);
    }

    public boolean a(String str, CImageBuffer CImageBufferVar) {
        return UIImageCodecJNI.ImageCodec_GetThumbnailFromFile__SWIG_1(this.b, this, str, CImageBuffer.a(CImageBufferVar), CImageBufferVar);
    }

    public boolean a(String str, UIThumbnailProperty UIThumbnailPropertyVar) {
        return UIImageCodecJNI.ImageCodec_GetThumbnailPropertyFromFile(this.b, this, str, UIThumbnailProperty.a(UIThumbnailPropertyVar), UIThumbnailPropertyVar);
    }

    public UIImageCodecErrorCode a(String str, CImageBuffer CImageBufferVar, UIEncodeParamRef UIEncodeParamRefVar, UIMetadata UIMetadataVar, UICancellationToken UICancellationTokenVar) {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_EncodeToFile__SWIG_0(this.b, this, str, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIEncodeParamRef.a(UIEncodeParamRefVar), UIEncodeParamRefVar, UIMetadata.a(UIMetadataVar), UIMetadataVar, UICancellationToken.a(UICancellationTokenVar), UICancellationTokenVar));
    }

    public UIImageCodecErrorCode a(String str, CImageBuffer CImageBufferVar, UIEncodeParamRef UIEncodeParamRefVar, UIMetadata UIMetadataVar) {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_EncodeToFile__SWIG_1(this.b, this, str, CImageBuffer.a(CImageBufferVar), CImageBufferVar, UIEncodeParamRef.a(UIEncodeParamRefVar), UIEncodeParamRefVar, UIMetadata.a(UIMetadataVar), UIMetadataVar));
    }

    public boolean a(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2, UIInterpolation uIInterpolation) {
        return UIImageCodecJNI.ImageCodec_Stretch__SWIG_0(this.b, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, CImageBuffer.a(CImageBufferVar2), CImageBufferVar2, uIInterpolation.a());
    }

    public boolean a(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2) {
        return UIImageCodecJNI.ImageCodec_Stretch__SWIG_1(this.b, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, CImageBuffer.a(CImageBufferVar2), CImageBufferVar2);
    }

    public boolean a(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2, UIImageOrientation uIImageOrientation) {
        return UIImageCodecJNI.ImageCodec_RotateFlip(this.b, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar, CImageBuffer.a(CImageBufferVar2), CImageBufferVar2, uIImageOrientation.a());
    }

    public void a(UIMetadata UIMetadataVar) {
        UIImageCodecJNI.ImageCodec_DumpMetadata(this.b, this, UIMetadata.a(UIMetadataVar), UIMetadataVar);
    }
}
