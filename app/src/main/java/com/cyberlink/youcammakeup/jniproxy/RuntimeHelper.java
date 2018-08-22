package com.cyberlink.youcammakeup.jniproxy;

public class RuntimeHelper {
    protected boolean a;
    private long b;

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                CommonJNI.delete_RuntimeHelper(this.b);
            }
            this.b = 0;
        }
    }

    public static boolean b() {
        return CommonJNI.RuntimeHelper_IsARMArch();
    }

    public static boolean c() {
        return CommonJNI.RuntimeHelper_IsSupportNeon();
    }
}
