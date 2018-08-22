package com.cyberlink.youcammakeup.jniproxy;

public class IDestroyable {
    protected boolean a;
    private long b;

    protected IDestroyable(long j, boolean z) {
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
                CommonJNI.delete_IDestroyable(this.b);
            }
            this.b = 0;
        }
    }

    public void b() {
        CommonJNI.IDestroyable_Destroy(this.b, this);
    }
}
