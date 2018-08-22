package com.cyberlink.youcammakeup.jniproxy;

public class IParamBase {
    protected boolean a;
    private long b;

    protected IParamBase(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long c(IParamBase IParamBaseVar) {
        return IParamBaseVar == null ? 0 : IParamBaseVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageRetouchJNI.delete_IParamBase(this.b);
            }
            this.b = 0;
        }
    }

    public boolean a(IParamBase IParamBaseVar) {
        return UIImageRetouchJNI.IParamBase_Compare(this.b, this, c(IParamBaseVar), IParamBaseVar);
    }

    public boolean b() {
        return UIImageRetouchJNI.IParamBase_IsDefault(this.b, this);
    }

    public void b(IParamBase IParamBaseVar) {
        UIImageRetouchJNI.IParamBase_InitFrom(this.b, this, c(IParamBaseVar), IParamBaseVar);
    }

    public String c() {
        return UIImageRetouchJNI.IParamBase_EncodeString(this.b, this);
    }

    public void a(String str) {
        UIImageRetouchJNI.IParamBase_DecodeString(this.b, this, str);
    }
}
