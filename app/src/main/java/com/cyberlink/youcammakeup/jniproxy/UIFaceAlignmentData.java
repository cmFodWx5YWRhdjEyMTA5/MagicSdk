package com.cyberlink.youcammakeup.jniproxy;

public class UIFaceAlignmentData {
    protected boolean a;
    private long b;

    protected UIFaceAlignmentData(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    protected static long a(UIFaceAlignmentData UIFaceAlignmentDataVar) {
        return UIFaceAlignmentDataVar == null ? 0 : UIFaceAlignmentDataVar.b;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        if (this.b != 0) {
            if (this.a) {
                this.a = false;
                UIVenusJNI.delete_UIFaceAlignmentData(this.b);
            }
            this.b = 0;
        }
    }

    public UIFaceAlignmentData() {
        this(UIVenusJNI.new_UIFaceAlignmentData__SWIG_0(), true);
    }

    public UIFaceAlignmentData(UIFaceAlignmentData UIFaceAlignmentDataVar) {
        this(UIVenusJNI.new_UIFaceAlignmentData__SWIG_1(a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar), true);
    }

    public UIFaceBrow b() {
        return new UIFaceBrow(UIVenusJNI.UIFaceAlignmentData_getLeftBrow(this.b, this), true);
    }

    public void a(UIFaceBrow UIFaceBrowVar) {
        UIVenusJNI.UIFaceAlignmentData_setLeftBrow(this.b, this, UIFaceBrow.a(UIFaceBrowVar), UIFaceBrowVar);
    }

    public UIFaceBrow c() {
        return new UIFaceBrow(UIVenusJNI.UIFaceAlignmentData_getRightBrow(this.b, this), true);
    }

    public void b(UIFaceBrow UIFaceBrowVar) {
        UIVenusJNI.UIFaceAlignmentData_setRightBrow(this.b, this, UIFaceBrow.a(UIFaceBrowVar), UIFaceBrowVar);
    }

    public UIFaceEye d() {
        return new UIFaceEye(UIVenusJNI.UIFaceAlignmentData_getLeftEye(this.b, this), true);
    }

    public void a(UIFaceEye UIFaceEyeVar) {
        UIVenusJNI.UIFaceAlignmentData_setLeftEye(this.b, this, UIFaceEye.a(UIFaceEyeVar), UIFaceEyeVar);
    }

    public UIFaceEye e() {
        return new UIFaceEye(UIVenusJNI.UIFaceAlignmentData_getRightEye(this.b, this), true);
    }

    public void b(UIFaceEye UIFaceEyeVar) {
        UIVenusJNI.UIFaceAlignmentData_setRightEye(this.b, this, UIFaceEye.a(UIFaceEyeVar), UIFaceEyeVar);
    }

    public UIFaceEar f() {
        return new UIFaceEar(UIVenusJNI.UIFaceAlignmentData_getLeftEar(this.b, this), true);
    }

    public void a(UIFaceEar UIFaceEarVar) {
        UIVenusJNI.UIFaceAlignmentData_setLeftEar(this.b, this, UIFaceEar.a(UIFaceEarVar), UIFaceEarVar);
    }

    public UIFaceEar g() {
        return new UIFaceEar(UIVenusJNI.UIFaceAlignmentData_getRightEar(this.b, this), true);
    }

    public void b(UIFaceEar UIFaceEarVar) {
        UIVenusJNI.UIFaceAlignmentData_setRightEar(this.b, this, UIFaceEar.a(UIFaceEarVar), UIFaceEarVar);
    }

    public UIFaceShape h() {
        return new UIFaceShape(UIVenusJNI.UIFaceAlignmentData_getLeftShape(this.b, this), true);
    }

    public void a(UIFaceShape UIFaceShapeVar) {
        UIVenusJNI.UIFaceAlignmentData_setLeftShape(this.b, this, UIFaceShape.a(UIFaceShapeVar), UIFaceShapeVar);
    }

    public UIFaceShape i() {
        return new UIFaceShape(UIVenusJNI.UIFaceAlignmentData_getRightShape(this.b, this), true);
    }

    public void b(UIFaceShape UIFaceShapeVar) {
        UIVenusJNI.UIFaceAlignmentData_setRightShape(this.b, this, UIFaceShape.a(UIFaceShapeVar), UIFaceShapeVar);
    }

    public UIFaceNose j() {
        return new UIFaceNose(UIVenusJNI.UIFaceAlignmentData_getNose(this.b, this), true);
    }

    public void a(UIFaceNose UIFaceNoseVar) {
        UIVenusJNI.UIFaceAlignmentData_setNose(this.b, this, UIFaceNose.a(UIFaceNoseVar), UIFaceNoseVar);
    }

    public UIFaceMouth k() {
        return new UIFaceMouth(UIVenusJNI.UIFaceAlignmentData_getMouth(this.b, this), true);
    }

    public void a(UIFaceMouth UIFaceMouthVar) {
        UIVenusJNI.UIFaceAlignmentData_setMouth(this.b, this, UIFaceMouth.a(UIFaceMouthVar), UIFaceMouthVar);
    }

    public UIFaceChin l() {
        return new UIFaceChin(UIVenusJNI.UIFaceAlignmentData_getChin(this.b, this), true);
    }

    public void a(UIFaceChin UIFaceChinVar) {
        UIVenusJNI.UIFaceAlignmentData_setChin(this.b, this, UIFaceChin.a(UIFaceChinVar), UIFaceChinVar);
    }

    public UIFaceForehead m() {
        return new UIFaceForehead(UIVenusJNI.UIFaceAlignmentData_getForehead(this.b, this), true);
    }

    public void a(UIFaceForehead UIFaceForeheadVar) {
        UIVenusJNI.UIFaceAlignmentData_setForehead(this.b, this, UIFaceForehead.a(UIFaceForeheadVar), UIFaceForeheadVar);
    }

    public boolean b(UIFaceAlignmentData UIFaceAlignmentDataVar) {
        return UIVenusJNI.UIFaceAlignmentData_equals(this.b, this, a(UIFaceAlignmentDataVar), UIFaceAlignmentDataVar);
    }
}
