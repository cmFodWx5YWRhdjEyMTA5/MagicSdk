package com.cyberlink.clgpuimage;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.util.Log;

import com.cyberlink.clgpuimage.IBeautyFilter2.FilterType;
import com.cyberlink.clgpuimage.util.TextureRotationUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class CLBeautyFilterBasicWithTwoPassBlendSource2 extends GPUImageFilter {

    static String k = "color_effect_table/";
    private boolean A;
    private byte[] B;
    private final int C = 256;
    private final int D = 128;
    private final int E = 256;
    private final int F = 1;
    private final int G = 3;
    private int[] H;
    private int I;
    private ByteBuffer J;
    protected FilterType a;
    protected int b = 960;
    protected int c = 720;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    private final FloatBuffer l;
    private final FloatBuffer m;
    private String n;
    private String o;
    private String p;
    private String q;
    private int r;
    private int[] s;
    private int[] t;
    private int u;
    private int v;
    private int w;
    private int x;
    private float y;
    private TableMode z;


    public static enum TableMode {
        TABLE_NONE,
        TABLE_3D,
        TABLE_1D
    }

    public CLBeautyFilterBasicWithTwoPassBlendSource2(String str, String str2, String str3, String str4, FilterType filterType) {
        super(str3, str4);
        this.n = str;
        this.o = str2;
        this.p = str3;
        this.q = str4;
        this.a = filterType;
        if (this.a == FilterType.LIVE_SMOOTH) {
            this.y = 6.0f;
        } else {
            this.y = 2.0f;
        }
        this.l = ByteBuffer.allocateDirect(GPUImageRenderer.CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.l.put(GPUImageRenderer.CUBE).position(0);
        this.m = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.m.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
        this.z = TableMode.TABLE_NONE;
        this.A = false;
        this.B = null;
    }

    public void a(AssetManager assetManager, String str, byte[] bArr, TableMode tableMode, boolean z) {
        int i = 256;
        this.z = tableMode;
        this.A = z;
        this.B = bArr;
        if (tableMode != TableMode.TABLE_NONE) {
            int i2;
            if (tableMode == TableMode.TABLE_3D) {
                i2 = 128;
            } else if (tableMode == TableMode.TABLE_1D) {
                i2 = 1;
            } else {
                Log.v("Aphrodite Log", "Invalid table_lookup_mode");
                i2 = 0;
                i = 0;
            }
            i2 = (i2 * i) * 3;
            byte[] bArr2 = new byte[i2];
            if (bArr == null || tableMode != TableMode.TABLE_1D) {
                try {
                    assetManager.open(str).read(bArr2, 0, i2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(i2, bArr.length));
            }
            if (this.A) {
                a(bArr2);
            }
            this.J = ByteBuffer.allocate(bArr2.length);
            this.J.put(bArr2, 0, bArr2.length);
            this.J.position(0);
        }
    }

    @Override
    public void onInit() {
        this.d = af.a(this.n, this.o);
        this.e = GLES20.glGetAttribLocation(this.d, "position");
        this.f = GLES20.glGetUniformLocation(this.d, "inputImageTexture");
        this.g = GLES20.glGetAttribLocation(this.d, "inputTextureCoordinate");
        this.u = GLES20.glGetUniformLocation(this.d, "sampling_offset_start");
        this.v = GLES20.glGetUniformLocation(this.d, "sampling_step");
        super.onInit();
        this.w = GLES20.glGetUniformLocation(getProgram(), "sampling_offset_start");
        this.x = GLES20.glGetUniformLocation(getProgram(), "sampling_step");
        this.h = GLES20.glGetUniformLocation(getProgram(), "smooth_strength");
        this.i = GLES20.glGetUniformLocation(getProgram(), "color_strength");
        this.j = GLES20.glGetUniformLocation(getProgram(), "fade_strength");
        this.r = GLES20.glGetUniformLocation(getProgram(), "rootImageTexture");
        if (this.z != TableMode.TABLE_NONE) {
            int i;
            int i2;
            if (this.z == TableMode.TABLE_3D) {
                i = 256;
                i2 = 128;
            } else if (this.z == TableMode.TABLE_1D) {
                i = 256;
                i2 = 1;
            } else {
                Log.v("Aphrodite Log", "Invalid table_lookup_mode");
                i2 = 0;
                i = 0;
            }
            this.H = new int[1];
            GLES20.glGenTextures(1, this.H, 0);
            GLES20.glBindTexture(3553, this.H[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6407, i, i2, 0, 6407, 5121, this.J);
            this.I = GLES20.glGetUniformLocation(getProgram(), "mapping_table_texture");
        }
    }

    @Override
    public void onDrawArraysPre() {
        super.onDrawArraysPre();
        b(this.b, this.c);
    }

    @Override
    public void onDestroy() {
        f();
        GLES20.glDeleteProgram(this.d);
        if (this.z != TableMode.TABLE_NONE) {
            GLES20.glDeleteTextures(this.H.length, this.H, 0);
        }
        super.onDestroy();
    }

    private void f() {
        if (this.t != null) {
            GLES20.glDeleteTextures(this.t.length, this.t, 0);
            this.t = null;
        }
        if (this.s != null) {
            GLES20.glDeleteFramebuffers(this.s.length, this.s, 0);
            this.s = null;
        }
    }

    private void e(int i, int i2) {
        this.s = new int[1];
        this.t = new int[1];
        GLES20.glGenFramebuffers(1, this.s, 0);
        GLES20.glGenTextures(1, this.t, 0);
        GLES20.glBindTexture(3553, this.t[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, this.s[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.t[0], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        if (this.s != null) {
            f();
        }
        e(i, i2);
        b(i, i2);
    }

    protected void d() {
    }

    protected void c_() {
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        IntBuffer allocate = IntBuffer.allocate(1024);
        GLES20.glGetIntegerv(36006, allocate);
        IntBuffer allocate2 = IntBuffer.allocate(4);
        GLES20.glGetIntegerv(2978, allocate2);
        GLES20.glUseProgram(this.d);
        GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
        GLES20.glBindFramebuffer(36160, this.s[0]);
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.e);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 0, floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.g);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(this.f, 0);
        }
        float min = ((float) Math.min(this.b, this.c)) / 720.0f;
        if (this.a == FilterType.LIVE_SMOOTH) {
            min = (float) Math.max(1.0d, Math.floor((double) (min * this.y)));
        } else {
            min = (float) Math.max(1.0d, (double) (min * this.y));
        }
        GLES20.glUniform2f(this.u, (min - 0.5f) / ((float) this.b), 0.0f);
        GLES20.glUniform2f(this.v, min / ((float) this.b), 0.0f);
        d();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, allocate.get(0));
        GLES20.glViewport(allocate2.get(0), allocate2.get(1), allocate2.get(2), allocate2.get(3));
    }

    @Override
    public void onDraw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized() && this.s != null && this.t != null) {
            a(i, this.l, this.m);
            GLES20.glUseProgram(this.mGLProgId);
            runPendingOnDrawTasks();
            if (isInitialized()) {
                floatBuffer.position(0);
                GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, floatBuffer);
                GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
                floatBuffer2.position(0);
                GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, floatBuffer2);
                GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
                if (this.t[0] != -1) {
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(3553, this.t[0]);
                    GLES20.glUniform1i(this.mGLUniformTexture, 3);
                }
                if (i != -1) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i);
                    GLES20.glUniform1i(this.r, 0);
                }
                if (!(this.z == TableMode.TABLE_NONE || this.H[0] == -1)) {
                    GLES20.glActiveTexture(33988);
                    GLES20.glBindTexture(3553, this.H[0]);
                    GLES20.glUniform1i(this.I, 4);
                }
                c_();
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
                GLES20.glBindTexture(3553, 0);
            }
        }
    }

    protected void b(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.b = i;
            this.c = i2;
            float min = ((float) Math.min(this.b, this.c)) / 720.0f;
            if (this.a == FilterType.LIVE_SMOOTH) {
                min = (float) Math.max(1.0d, Math.floor((double) (min * this.y)));
            } else {
                min = (float) Math.max(1.0d, (double) (min * this.y));
            }
            final float f = min - 0.5f;
            final float finalMin = min;
            runOnDraw(new Runnable() {
                @Override
                public void run() {
                    setFloatVec2(w, new float[]{0.0f, f / ((float) c)});
                    setFloatVec2(x, new float[]{0.0f, finalMin / ((float) c)});
                }
            });
        }
    }

    private void a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = a(bArr[i]);
        }
    }

    private byte a(byte b) {
        byte b2 = (byte) (((b & 240) >> 4) | ((b & 15) << 4));
        b2 = (byte) (((b2 & 51) << 2) | ((b2 & 204) >> 2));
        return (byte) (((b2 & 85) << 1) | ((b2 & 170) >> 1));
    }
}
