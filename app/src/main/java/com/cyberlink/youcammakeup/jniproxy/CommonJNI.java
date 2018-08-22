package com.cyberlink.youcammakeup.jniproxy;


public class CommonJNI {
    public static final native boolean CImageBuffer_ApplyMaskBitmap(long j, CImageBuffer CImageBufferVar, Object obj);

    public static final native boolean CImageBuffer_AttachAndroidBitmap(long j, CImageBuffer CImageBufferVar, Object obj);

    public static final native boolean CImageBuffer_ClearAlphaChannel(long j, CImageBuffer CImageBufferVar);

    public static final native boolean CImageBuffer_ConvertColorDepth(long j, CImageBuffer CImageBufferVar, long j2, CImageBuffer CImageBufferVar2);

    public static final native boolean CImageBuffer_CopyImageBufferToImageBuffer__SWIG_0(long j, CImageBuffer CImageBufferVar, long j2, CImageBuffer CImageBufferVar2, long j3, UIImageROI UIImageROIVar);

    public static final native boolean CImageBuffer_CopyToAndroidBitmap(long j, CImageBuffer CImageBufferVar, Object obj);

    public static final native boolean CImageBuffer_CreateBuffer(long j, CImageBuffer CImageBufferVar, long j2, long j3, long j4);

    public static final native boolean CImageBuffer_CreateFromImageBuffer(long j, CImageBuffer CImageBufferVar, long j2, CImageBuffer CImageBufferVar2, long j3, UIImageROI UIImageROIVar);

    public static final native void CImageBuffer_Destroy(long j, CImageBuffer CImageBufferVar);

    public static final native boolean CImageBuffer_DetachAndroidBitmap(long j, CImageBuffer CImageBufferVar);

    public static final native boolean CImageBuffer_DumpToFile(long j, CImageBuffer CImageBufferVar, String str);

    public static final native long CImageBuffer_GetBytesPerPixel(long j, CImageBuffer CImageBufferVar);

    public static final native boolean CImageBuffer_GetCacheFileInfo(String str, long j, UICacheFileInfo UICacheFileInfoVar);

    public static final native long CImageBuffer_GetHeight(long j, CImageBuffer CImageBufferVar);

    public static final native int CImageBuffer_GetPixelFormat(long j, CImageBuffer CImageBufferVar);

    public static final native long CImageBuffer_GetWidth(long j, CImageBuffer CImageBufferVar);

    public static final native boolean CImageBuffer_LoadFromFile(long j, CImageBuffer CImageBufferVar, String str);

    public static final native long CImageBuffer_SWIGUpcast(long j);

    public static final native void CImageBuffer_SetAccessMode(long j, CImageBuffer CImageBufferVar, int i);

    public static final native void CImageBuffer_SetPixelFormat(long j, CImageBuffer CImageBufferVar, int i);

    public static final native boolean CImageBuffer_SwapColorChannel__SWIG_0(long j, CImageBuffer CImageBufferVar);

    public static final native boolean CImageBuffer_SwapColorChannel__SWIG_1(long j, CImageBuffer CImageBufferVar, long j2, CImageBuffer CImageBufferVar2);

    public static final native void IDestroyable_Destroy(long j, IDestroyable IDestroyableVar);

    public static final native long IImageBuffer_GetBytesPerPixel(long j, IImageBuffer IImageBufferVar);

    public static final native long IImageBuffer_GetHeight(long j, IImageBuffer IImageBufferVar);

    public static final native long IImageBuffer_GetWidth(long j, IImageBuffer IImageBufferVar);

    public static final native long IImageBuffer_SWIGUpcast(long j);

    public static final native void IImageBuffer_SetAccessMode(long j, IImageBuffer IImageBufferVar, int i);

    public static final native boolean RuntimeHelper_IsARMArch();

    public static final native boolean RuntimeHelper_IsSupportNeon();

    public static final native long UICacheFileInfo_ulBpp_get(long j, UICacheFileInfo UICacheFileInfoVar);

    public static final native long UICacheFileInfo_ulHeight_get(long j, UICacheFileInfo UICacheFileInfoVar);

    public static final native long UICacheFileInfo_ulWidth_get(long j, UICacheFileInfo UICacheFileInfoVar);

    public static final native void delete_CImageBuffer(long j);

    public static final native void delete_IDestroyable(long j);

    public static final native void delete_IImageBuffer(long j);

    public static final native void delete_RuntimeHelper(long j);

    public static final native void delete_UICacheFileInfo(long j);

    public static final native void delete_UIImageROI(long j);

    public static final native long new_CImageBuffer__SWIG_0(int i);

    public static final native long new_CImageBuffer__SWIG_1();

    public static final native long new_UICacheFileInfo();

    public static final native long new_UIImageROI(long j, long j2, long j3, long j4);

}
