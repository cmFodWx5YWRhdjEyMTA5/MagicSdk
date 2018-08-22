package com.cyberlink.youcammakeup.jniproxy;

public class UIDecodeParamRef {
    protected boolean a;
    private long b;

    protected UIDecodeParamRef(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIDecodeParamRef UIDecodeParamRefVar) {
        return UIDecodeParamRefVar == null ? 0 : UIDecodeParamRefVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UIDecodeParamRef(this.b);
            }
            this.b = 0;
        }
    }

    public void a(long j) {
        UIImageCodecJNI.UIDecodeParamRef_ulWidth_set(this.b, this, j);
    }

    public void b(long j) {
        UIImageCodecJNI.UIDecodeParamRef_ulHeight_set(this.b, this, j);
    }

    public void a(UIImageFormat uIImageFormat) {
        UIImageCodecJNI.UIDecodeParamRef_nFormat_set(this.b, this, uIImageFormat.a());
    }

    public void a(UIBytePerPixel uIBytePerPixel) {
        UIImageCodecJNI.UIDecodeParamRef_nBytePerPixel_set(this.b, this, uIBytePerPixel.a());
    }

    public void c(long j) {
        UIImageCodecJNI.UIDecodeParamRef_ulSampleSize_set(this.b, this, j);
    }

    public UIDecodeParamRef() {
        this(UIImageCodecJNI.new_UIDecodeParamRef(), true);
    }
}
