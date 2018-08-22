package com.cyberlink.youcammakeup.jniproxy;

public class CImageBuffer extends IImageBuffer {
    private long b;

    protected CImageBuffer(long j, boolean z) {
        super(CommonJNI.CImageBuffer_SWIGUpcast(j), z);
        this.b = j;
    }

    protected static long a(CImageBuffer CImageBufferVar) {
        return CImageBufferVar == null ? 0 : CImageBufferVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                CommonJNI.delete_CImageBuffer(this.b);
            }
            this.b = 0;
        }
        super.a();
    }

    public CImageBuffer(PixelFormat pixelFormat) {
        this(CommonJNI.new_CImageBuffer__SWIG_0(pixelFormat.a()), true);
    }

    public CImageBuffer() {
        this(CommonJNI.new_CImageBuffer__SWIG_1(), true);
    }

    public void b() {
        CommonJNI.CImageBuffer_Destroy(this.b, this);
    }

    public boolean a(Object obj) {
        return CommonJNI.CImageBuffer_AttachAndroidBitmap(this.b, this, obj);
    }

    public boolean c() {
        return CommonJNI.CImageBuffer_DetachAndroidBitmap(this.b, this);
    }

    public boolean a(long j, long j2, long j3) {
        return CommonJNI.CImageBuffer_CreateBuffer(this.b, this, j, j2, j3);
    }

    public boolean a(CImageBuffer CImageBufferVar, UIImageROI UIImageROIVar) {
        return CommonJNI.CImageBuffer_CreateFromImageBuffer(this.b, this, a(CImageBufferVar), CImageBufferVar, UIImageROI.a(UIImageROIVar), UIImageROIVar);
    }

    public boolean a(String str) {
        return CommonJNI.CImageBuffer_LoadFromFile(this.b, this, str);
    }

    public boolean b(String str) {
        return CommonJNI.CImageBuffer_DumpToFile(this.b, this, str);
    }

    public static boolean a(String str, UICacheFileInfo UICacheFileInfoVar) {
        return CommonJNI.CImageBuffer_GetCacheFileInfo(str, UICacheFileInfo.a(UICacheFileInfoVar), UICacheFileInfoVar);
    }

    public boolean b(Object obj) {
        return CommonJNI.CImageBuffer_CopyToAndroidBitmap(this.b, this, obj);
    }

    public boolean c(Object obj) {
        return CommonJNI.CImageBuffer_ApplyMaskBitmap(this.b, this, obj);
    }

    public boolean d() {
        return CommonJNI.CImageBuffer_ClearAlphaChannel(this.b, this);
    }

    public static boolean a(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2, UIImageROI UIImageROIVar) {
        return CommonJNI.CImageBuffer_CopyImageBufferToImageBuffer__SWIG_0(a(CImageBufferVar), CImageBufferVar, a(CImageBufferVar2), CImageBufferVar2, UIImageROI.a(UIImageROIVar), UIImageROIVar);
    }

    public void a(AccessMode accessMode) {
        CommonJNI.CImageBuffer_SetAccessMode(this.b, this, accessMode.a());
    }

    public long e() {
        return CommonJNI.CImageBuffer_GetWidth(this.b, this);
    }

    public long f() {
        return CommonJNI.CImageBuffer_GetHeight(this.b, this);
    }

    public long g() {
        return CommonJNI.CImageBuffer_GetBytesPerPixel(this.b, this);
    }

    public static boolean b(CImageBuffer CImageBufferVar) {
        return CommonJNI.CImageBuffer_SwapColorChannel__SWIG_0(a(CImageBufferVar), CImageBufferVar);
    }

    public static boolean a(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2) {
        return CommonJNI.CImageBuffer_SwapColorChannel__SWIG_1(a(CImageBufferVar), CImageBufferVar, a(CImageBufferVar2), CImageBufferVar2);
    }

    public static boolean b(CImageBuffer CImageBufferVar, CImageBuffer CImageBufferVar2) {
        return CommonJNI.CImageBuffer_ConvertColorDepth(a(CImageBufferVar), CImageBufferVar, a(CImageBufferVar2), CImageBufferVar2);
    }

    public PixelFormat h() {
        return PixelFormat.a(CommonJNI.CImageBuffer_GetPixelFormat(this.b, this));
    }

    public void a(PixelFormat pixelFormat) {
        CommonJNI.CImageBuffer_SetPixelFormat(this.b, this, pixelFormat.a());
    }
}
