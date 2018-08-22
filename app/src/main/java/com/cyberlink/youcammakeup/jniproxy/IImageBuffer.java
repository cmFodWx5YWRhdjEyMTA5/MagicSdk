package com.cyberlink.youcammakeup.jniproxy;

public class IImageBuffer extends IDestroyable {
    private long b;

    protected IImageBuffer(long j, boolean z) {
        super(CommonJNI.IImageBuffer_SWIGUpcast(j), z);
        this.b = j;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                CommonJNI.delete_IImageBuffer(this.b);
            }
            this.b = 0;
        }
        super.a();
    }

    public void a(AccessMode accessMode) {
        CommonJNI.IImageBuffer_SetAccessMode(this.b, this, accessMode.a());
    }

    public long e() {
        return CommonJNI.IImageBuffer_GetWidth(this.b, this);
    }

    public long f() {
        return CommonJNI.IImageBuffer_GetHeight(this.b, this);
    }

    public long g() {
        return CommonJNI.IImageBuffer_GetBytesPerPixel(this.b, this);
    }
}
