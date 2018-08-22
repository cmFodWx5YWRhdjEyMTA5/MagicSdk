package com.cyberlink.youcammakeup.jniproxy;

public class UIEncodeParamRef {
    protected boolean a;
    private long b;

    protected UIEncodeParamRef(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIEncodeParamRef UIEncodeParamRefVar) {
        return UIEncodeParamRefVar == null ? 0 : UIEncodeParamRefVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UIEncodeParamRef(this.b);
            }
            this.b = 0;
        }
    }

    public UIEncodeParamRef() {
        this(UIImageCodecJNI.new_UIEncodeParamRef__SWIG_0(), true);
    }

    public UIEncodeParamRef(UIImageFormat uIImageFormat, int i, UITiffCompression uITiffCompression, UIJPEGSubSampling uIJPEGSubSampling, UIBytePerPixel uIBytePerPixel, UIImageOrientation uIImageOrientation) {
        this(UIImageCodecJNI.new_UIEncodeParamRef__SWIG_1(uIImageFormat.a(), i, uITiffCompression.a(), uIJPEGSubSampling.a(), uIBytePerPixel.a(), uIImageOrientation.a()), true);
    }

    public UIImageFormat b() {
        return UIImageFormat.a(UIImageCodecJNI.UIEncodeParamRef_GetFormat(this.b, this));
    }

    public void a(UIImageFormat uIImageFormat) {
        UIImageCodecJNI.UIEncodeParamRef_SetFormat(this.b, this, uIImageFormat.a());
    }

    public void a(UIImageOrientation uIImageOrientation) {
        UIImageCodecJNI.UIEncodeParamRef_SetImageOrientation(this.b, this, uIImageOrientation.a());
    }

    public void a(int i) {
        UIImageCodecJNI.UIEncodeParamRef_SetQuality(this.b, this, i);
    }
}
