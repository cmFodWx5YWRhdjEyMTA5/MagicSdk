package com.cyberlink.youcammakeup.jniproxy;

public class UIImageROI {
    protected boolean a;
    private long b;

    protected UIImageROI(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIImageROI UIImageROIVar) {
        return UIImageROIVar == null ? 0 : UIImageROIVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                CommonJNI.delete_UIImageROI(this.b);
            }
            this.b = 0;
        }
    }

    public UIImageROI(long j, long j2, long j3, long j4) {
        this(CommonJNI.new_UIImageROI(j, j2, j3, j4), true);
    }
}
