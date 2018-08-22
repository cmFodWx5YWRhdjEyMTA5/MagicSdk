package com.cyberlink.youcammakeup.jniproxy;

public class UICancellationToken {
    protected boolean a;
    private long b;

    protected UICancellationToken(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UICancellationToken UICancellationTokenVar) {
        return UICancellationTokenVar == null ? 0 : UICancellationTokenVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageCodecJNI.delete_UICancellationToken(this.b);
            }
            this.b = 0;
        }
    }

    public UICancellationToken() {
        this(UIImageCodecJNI.new_UICancellationToken(), true);
    }

    public void b() {
        UIImageCodecJNI.UICancellationToken_Cancel(this.b, this);
    }

    public boolean c() {
        return UIImageCodecJNI.UICancellationToken_IsCancelled(this.b, this);
    }
}
