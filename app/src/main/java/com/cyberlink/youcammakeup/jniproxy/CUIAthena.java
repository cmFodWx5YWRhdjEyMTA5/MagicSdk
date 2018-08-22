package com.cyberlink.youcammakeup.jniproxy;

public class CUIAthena {
    protected boolean a;
    private long b;

    protected CUIAthena(long j, boolean z) {
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
                UIAthenaJNI.delete_CUIAthena(this.b);
            }
            this.b = 0;
        }
    }

    public CUIAthena(String str) {
        this(UIAthenaJNI.new_CUIAthena(str), true);
    }

    public boolean a(CImageBuffer CImageBufferVar) {
        return UIAthenaJNI.CUIAthena_initialize(this.b, this, CImageBuffer.a(CImageBufferVar), CImageBufferVar);
    }

    public boolean b() {
        return UIAthenaJNI.CUIAthena_uninitialize(this.b, this);
    }

    public boolean c() {
        return UIAthenaJNI.CUIAthena_clear(this.b, this);
    }

    public boolean a(AthenaStrokeType athenaStrokeType, int i) {
        return UIAthenaJNI.CUIAthena_beginStroke(this.b, this, athenaStrokeType.a(), i);
    }

    public boolean a(float f, float f2) {
        return UIAthenaJNI.CUIAthena_addStrokePoint(this.b, this, f, f2);
    }

    public boolean d() {
        return UIAthenaJNI.CUIAthena_endStroke(this.b, this);
    }

    public boolean e() {
        return UIAthenaJNI.CUIAthena_invert(this.b, this);
    }

    public Object a(boolean z) {
        return UIAthenaJNI.CUIAthena_getMask(this.b, this, z);
    }
}
