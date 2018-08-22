package com.cyberlink.youcammakeup.jniproxy;


public class UIAthenaJNI {
    public static final native boolean CUIAthena_addStrokePoint(long j, CUIAthena CUIAthenaVar, float f, float f2);

    public static final native boolean CUIAthena_beginStroke(long j, CUIAthena CUIAthenaVar, int i, int i2);

    public static final native boolean CUIAthena_clear(long j, CUIAthena CUIAthenaVar);

    public static final native boolean CUIAthena_endStroke(long j, CUIAthena CUIAthenaVar);

    public static final native Object CUIAthena_getMask(long j, CUIAthena CUIAthenaVar, boolean z);

    public static final native boolean CUIAthena_initialize(long j, CUIAthena CUIAthenaVar, long j2, CImageBuffer CImageBufferVar);

    public static final native boolean CUIAthena_invert(long j, CUIAthena CUIAthenaVar);

    public static final native boolean CUIAthena_uninitialize(long j, CUIAthena CUIAthenaVar);

    public static final native void delete_CUIAthena(long j);

    public static final native long new_CUIAthena(String str);


}
