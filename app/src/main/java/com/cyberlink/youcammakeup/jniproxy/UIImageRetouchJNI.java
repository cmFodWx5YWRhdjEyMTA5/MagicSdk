package com.cyberlink.youcammakeup.jniproxy;


public class UIImageRetouchJNI {
    public static final native boolean CropRotateParam_ChangeResolution(long j, CropRotateParam cropRotateParamVar, int i, int i2);

    public static final native boolean CropRotateParam_Compare(long j, CropRotateParam cropRotateParamVar, long j2, IParamBase IParamBaseVar);

    public static final native void CropRotateParam_DecodeString(long j, CropRotateParam cropRotateParamVar, String str);

    public static final native String CropRotateParam_EncodeString(long j, CropRotateParam cropRotateParamVar);

    public static final native void CropRotateParam_InitFrom(long j, CropRotateParam cropRotateParamVar, long j2, IParamBase IParamBaseVar);

    public static final native boolean CropRotateParam_IsDefault(long j, CropRotateParam cropRotateParamVar);

    public static final native long CropRotateParam_SWIGUpcast(long j);

    public static final native float CropRotateParam_fAngle_get(long j, CropRotateParam cropRotateParamVar);

    public static final native int CropRotateParam_nHeight_get(long j, CropRotateParam cropRotateParamVar);

    public static final native int CropRotateParam_nLeft_get(long j, CropRotateParam cropRotateParamVar);

    public static final native int CropRotateParam_nTop_get(long j, CropRotateParam cropRotateParamVar);

    public static final native int CropRotateParam_nWidth_get(long j, CropRotateParam cropRotateParamVar);

    public static final native boolean IParamBase_Compare(long j, IParamBase IParamBaseVar, long j2, IParamBase IParamBaseVar2);

    public static final native void IParamBase_DecodeString(long j, IParamBase IParamBaseVar, String str);

    public static final native String IParamBase_EncodeString(long j, IParamBase IParamBaseVar);

    public static final native void IParamBase_InitFrom(long j, IParamBase IParamBaseVar, long j2, IParamBase IParamBaseVar2);

    public static final native boolean IParamBase_IsDefault(long j, IParamBase IParamBaseVar);

    public static final native void delete_CropRotateParam(long j);

    public static final native void delete_IParamBase(long j);

    public static final native long new_CropRotateParam__SWIG_0();

}
