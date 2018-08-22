package com.cyberlink.youcammakeup.jniproxy;

public class CropRotateParam extends IParamBase {
    private long b;

    protected CropRotateParam(long j, boolean z) {
        super(UIImageRetouchJNI.CropRotateParam_SWIGUpcast(j), z);
        this.b = j;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIImageRetouchJNI.delete_CropRotateParam(this.b);
            }
            this.b = 0;
        }
        super.a();
    }

    public CropRotateParam() {
        this(UIImageRetouchJNI.new_CropRotateParam__SWIG_0(), true);
    }

    public boolean a(IParamBase IParamBaseVar) {
        return UIImageRetouchJNI.CropRotateParam_Compare(this.b, this, IParamBase.c(IParamBaseVar), IParamBaseVar);
    }

    public boolean b() {
        return UIImageRetouchJNI.CropRotateParam_IsDefault(this.b, this);
    }

    public void b(IParamBase IParamBaseVar) {
        UIImageRetouchJNI.CropRotateParam_InitFrom(this.b, this, IParamBase.c(IParamBaseVar), IParamBaseVar);
    }

    public String c() {
        return UIImageRetouchJNI.CropRotateParam_EncodeString(this.b, this);
    }

    public void a(String str) {
        UIImageRetouchJNI.CropRotateParam_DecodeString(this.b, this, str);
    }

    public boolean a(int i, int i2) {
        return UIImageRetouchJNI.CropRotateParam_ChangeResolution(this.b, this, i, i2);
    }

    public int d() {
        return UIImageRetouchJNI.CropRotateParam_nLeft_get(this.b, this);
    }

    public int e() {
        return UIImageRetouchJNI.CropRotateParam_nTop_get(this.b, this);
    }

    public int f() {
        return UIImageRetouchJNI.CropRotateParam_nWidth_get(this.b, this);
    }

    public int g() {
        return UIImageRetouchJNI.CropRotateParam_nHeight_get(this.b, this);
    }

    public float h() {
        return UIImageRetouchJNI.CropRotateParam_fAngle_get(this.b, this);
    }
}
