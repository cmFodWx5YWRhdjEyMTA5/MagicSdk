package com.cyberlink.clgpuimage;


import android.opengl.GLES20;

import com.cyberlink.clgpuimage.IBeautyFilter2.FilterType;
import com.het.facesdk.utils.OpenGlUtils;

/**
 * 美颜滤镜
 *
 * @author galis
 */
public class CLMakeupLiveSmoothFilter extends CLBeautyFilterBasicWithTwoPassBlendSource2 {

    public static final byte[] l = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, (byte) 64, (byte) 64, (byte) 64, (byte) -64, (byte) -64, (byte) -64, (byte) 32, (byte) 32, (byte) 32, (byte) -96, (byte) -96, (byte) -96, (byte) 96, (byte) 96, (byte) 96, (byte) 16, (byte) 16, (byte) 16, (byte) -112, (byte) -112, (byte) -112, (byte) 80, (byte) 80, (byte) 80, (byte) -48, (byte) -48, (byte) -48, (byte) 48, (byte) 48, (byte) 48, (byte) -80, (byte) -80, (byte) -80, (byte) -16, (byte) 112, (byte) 112, (byte) 8, (byte) 8, (byte) 8, (byte) -120, (byte) -120, (byte) -120, (byte) 72, (byte) 72, (byte) 72, (byte) 40, (byte) -56, (byte) -56, (byte) -88, (byte) -88, (byte) -88, (byte) 104, (byte) 104, (byte) 104, (byte) -24, (byte) -24, (byte) -24, (byte) -104, (byte) 24, (byte) 24, (byte) 88, (byte) 88, (byte) 88, (byte) -40, (byte) -40, (byte) -40, (byte) -72, (byte) 56, (byte) 56, (byte) 120, (byte) 120, (byte) 120, (byte) -8, (byte) -8, (byte) -8, (byte) -124, (byte) 4, (byte) 4, (byte) 68, (byte) -124, (byte) -124, (byte) -60, (byte) -60, (byte) -60, (byte) -92, (byte) 36, (byte) 36, (byte) 100, (byte) -92, (byte) -92, (byte) -28, (byte) -28, (byte) -28, (byte) -108, (byte) 20, (byte) 20, (byte) 84, (byte) -108, (byte) -108, (byte) -44, (byte) 84, (byte) 84, (byte) 52, (byte) -44, (byte) -44, (byte) 116, (byte) -76, (byte) -76, (byte) -12, (byte) 116, (byte) 116, (byte) 12, (byte) -12, (byte) -12, (byte) -116, (byte) 12, (byte) 12, (byte) 76, (byte) -116, (byte) -116, (byte) -52, (byte) 76, (byte) 76, (byte) -84, (byte) 44, (byte) 44, (byte) 108, (byte) -84, (byte) -84, (byte) -20, (byte) 108, (byte) 108, (byte) 28, (byte) -20, (byte) -20, (byte) -100, (byte) 28, (byte) 28, (byte) -36, (byte) -100, (byte) -100, (byte) 60, (byte) -36, (byte) -36, (byte) -68, (byte) 60, (byte) 60, (byte) 124, (byte) -68, (byte) -68, (byte) -4, (byte) 124, (byte) 124, (byte) 2, (byte) -4, (byte) -4, (byte) 66, (byte) 2, (byte) 2, (byte) -62, (byte) -126, (byte) -126, (byte) 34, (byte) -62, (byte) -62, (byte) -94, (byte) 34, (byte) 34, (byte) 98, (byte) -94, (byte) -94, (byte) -30, (byte) 98, (byte) 98, (byte) -110, (byte) -30, (byte) -30, (byte) 82, (byte) 18, (byte) 18, (byte) -46, (byte) -110, (byte) -110, (byte) 50, (byte) 82, (byte) 82, (byte) -78, (byte) 50, (byte) 50, (byte) 114, (byte) -78, (byte) -78, (byte) -14, (byte) 114, (byte) 114, (byte) -118, (byte) -14, (byte) -14, (byte) 74, (byte) 10, (byte) 10, (byte) -54, (byte) -118, (byte) -118, (byte) 42, (byte) 74, (byte) 74, (byte) -86, (byte) 42, (byte) 42, (byte) 106, (byte) -86, (byte) -86, (byte) -22, (byte) 106, (byte) 106, (byte) 26, (byte) -22, (byte) -22, (byte) 90, (byte) 26, (byte) 26, (byte) -38, (byte) -102, (byte) -102, (byte) 58, (byte) 90, (byte) 90, (byte) -70, (byte) -38, (byte) -38, (byte) 122, (byte) 58, (byte) 58, (byte) -6, (byte) -70, (byte) -70, (byte) 6, (byte) -6, (byte) -6, (byte) -122, (byte) 6, (byte) 6, (byte) -58, (byte) -122, (byte) -122, (byte) 38, (byte) 70, (byte) 70, (byte) -90, (byte) -58, (byte) -58, (byte) 102, (byte) 38, (byte) 38, (byte) -26, (byte) -90, (byte) -90, (byte) 22, (byte) 102, (byte) 102, (byte) -106, (byte) -26, (byte) -26, (byte) 86, (byte) 22, (byte) 22, (byte) -42, (byte) 86, (byte) 86, (byte) 54, (byte) -42, (byte) -42, (byte) -74, (byte) 54, (byte) 54, (byte) -10, (byte) -74, (byte) -74, (byte) 14, (byte) 118, (byte) 118, (byte) -114, (byte) -10, (byte) -10, (byte) 78, (byte) 14, (byte) 14, (byte) -50, (byte) -114, (byte) -114, (byte) 46, (byte) 78, (byte) 78, (byte) -82, (byte) -50, (byte) -50, (byte) 110, (byte) 46, (byte) 46, (byte) -18, (byte) -82, (byte) -82, (byte) 30, (byte) 110, (byte) 110, (byte) -98, (byte) -18, (byte) -18, (byte) 94, (byte) -98, (byte) -98, (byte) -34, (byte) 94, (byte) 94, (byte) -66, (byte) -34, (byte) -34, (byte) 126, (byte) 62, (byte) 62, (byte) -2, (byte) -66, (byte) -66, (byte) 1, (byte) 126, (byte) 126, (byte) -127, (byte) -2, (byte) -2, (byte) 65, (byte) 1, (byte) 1, (byte) -63, (byte) -127, (byte) -127, (byte) 33, (byte) 65, (byte) 65, (byte) -95, (byte) -63, (byte) -63, (byte) 97, (byte) 33, (byte) 33, (byte) -31, (byte) -95, (byte) -95, (byte) 17, (byte) 97, (byte) 97, (byte) -111, (byte) -31, (byte) -31, (byte) 81, (byte) 17, (byte) 17, (byte) -47, (byte) -111, (byte) -111, (byte) 49, (byte) 81, (byte) 81, (byte) -79, (byte) -47, (byte) -47, (byte) 113, (byte) 49, (byte) 49, (byte) -15, (byte) -79, (byte) -79, (byte) 9, (byte) 113, (byte) 113, (byte) -119, (byte) 9, (byte) 9, (byte) 73, (byte) -119, (byte) -119, (byte) -55, (byte) 73, (byte) 73, (byte) -87, (byte) -55, (byte) -55, (byte) 105, (byte) 41, (byte) 41, (byte) -23, (byte) -87, (byte) -87, (byte) 25, (byte) 105, (byte) 105, (byte) -103, (byte) -23, (byte) -23, (byte) 89, (byte) 25, (byte) 25, (byte) -39, (byte) -103, (byte) -103, (byte) 57, (byte) 89, (byte) 89, (byte) -71, (byte) -39, (byte) -39, (byte) 121, (byte) 57, (byte) 57, (byte) -7, (byte) -71, (byte) -71, (byte) 5, (byte) 121, (byte) 121, (byte) -123, (byte) -7, (byte) -7, (byte) 69, (byte) 5, (byte) 5, (byte) -59, (byte) -123, (byte) -123, (byte) 37, (byte) 69, (byte) 69, (byte) -91, (byte) -59, (byte) -59, (byte) 101, (byte) 37, (byte) 37, (byte) -27, (byte) -91, (byte) -91, (byte) 21, (byte) 101, (byte) 101, (byte) -107, (byte) -27, (byte) -27, (byte) 85, (byte) 21, (byte) 21, (byte) 85, (byte) -107, (byte) -107, (byte) -43, (byte) 85, (byte) 85, (byte) 53, (byte) -43, (byte) -43, (byte) -75, (byte) 53, (byte) 53, (byte) 117, (byte) -75, (byte) -75, (byte) -11, (byte) 117, (byte) 117, (byte) 13, (byte) -11, (byte) -11, (byte) -115, (byte) 13, (byte) 13, (byte) 77, (byte) 13, (byte) 13, (byte) -51, (byte) -115, (byte) -115, (byte) 45, (byte) 77, (byte) 77, (byte) -83, (byte) -51, (byte) -51, (byte) 109, (byte) 45, (byte) 45, (byte) -19, (byte) -83, (byte) -83, (byte) 29, (byte) 109, (byte) 109, (byte) -99, (byte) -19, (byte) -19, (byte) 93, (byte) 29, (byte) 29, (byte) -35, (byte) -99, (byte) -99, (byte) 61, (byte) 93, (byte) 93, (byte) -67, (byte) -35, (byte) -35, (byte) 125, (byte) 61, (byte) 61, (byte) -3, (byte) -67, (byte) -67, (byte) 3, (byte) 125, (byte) 125, (byte) -125, (byte) -3, (byte) -3, (byte) -125, (byte) 3, (byte) 3, (byte) 67, (byte) -125, (byte) -125, (byte) -61, (byte) 67, (byte) 67, (byte) 35, (byte) -61, (byte) -61, (byte) -93, (byte) 35, (byte) 35, (byte) 99, (byte) -93, (byte) -93, (byte) -29, (byte) 99, (byte) 99, (byte) 19, (byte) 99, (byte) 99, (byte) -109, (byte) -29, (byte) -29, (byte) 83, (byte) 19, (byte) 19, (byte) -45, (byte) -109, (byte) -109, (byte) 51, (byte) 83, (byte) 83, (byte) 51, (byte) -45, (byte) -45, (byte) -77, (byte) 51, (byte) 51, (byte) 115, (byte) -77, (byte) -77, (byte) -13, (byte) 115, (byte) 115, (byte) 11, (byte) -13, (byte) -13, (byte) -117, (byte) 11, (byte) 11, (byte) 75, (byte) -117, (byte) -117, (byte) -53, (byte) 75, (byte) 75, (byte) 43, (byte) 75, (byte) 75, (byte) -85, (byte) -53, (byte) -53, (byte) 107, (byte) 43, (byte) 43, (byte) 107, (byte) -85, (byte) -85, (byte) -21, (byte) 107, (byte) 107, (byte) 27, (byte) -21, (byte) -21, (byte) -101, (byte) 27, (byte) 27, (byte) 91, (byte) -101, (byte) -101, (byte) -37, (byte) 91, (byte) 91, (byte) 59, (byte) -37, (byte) -37, (byte) -69, (byte) 59, (byte) 59, (byte) -69, (byte) 59, (byte) 59, (byte) 123, (byte) -69, (byte) -69, (byte) -5, (byte) 123, (byte) 123, (byte) 7, (byte) -5, (byte) -5, (byte) -121, (byte) 7, (byte) 7, (byte) 71, (byte) -121, (byte) -121, (byte) -57, (byte) 71, (byte) 71, (byte) 39, (byte) -57, (byte) -57, (byte) 39, (byte) 39, (byte) 39, (byte) -89, (byte) 39, (byte) 39, (byte) 103, (byte) -89, (byte) -89, (byte) -25, (byte) 103, (byte) 103, (byte) 23, (byte) -25, (byte) -25, (byte) -105, (byte) 23, (byte) 23, (byte) 87, (byte) -105, (byte) -105, (byte) 87, (byte) 87, (byte) 87, (byte) -41, (byte) -41, (byte) -41, (byte) 55, (byte) -41, (byte) -41, (byte) -73, (byte) 55, (byte) 55, (byte) 119, (byte) -73, (byte) -73, (byte) -9, (byte) 119, (byte) 119, (byte) -9, (byte) -9, (byte) -9, (byte) 15, (byte) 15, (byte) 15, (byte) -113, (byte) -113, (byte) -113, (byte) 79, (byte) -113, (byte) -113, (byte) -49, (byte) 79, (byte) 79, (byte) 47, (byte) -49, (byte) -49, (byte) 47, (byte) 47, (byte) 47, (byte) -81, (byte) -81, (byte) -81, (byte) 111, (byte) 111, (byte) 111, (byte) -17, (byte) -17, (byte) -17, (byte) 31, (byte) -17, (byte) -17, (byte) -97, (byte) 31, (byte) 31, (byte) -97, (byte) -97, (byte) -97, (byte) 95, (byte) 95, (byte) 95, (byte) -33, (byte) -33, (byte) -33, (byte) 63, (byte) 63, (byte) 63, (byte) -65, (byte) 63, (byte) 63, (byte) -65, (byte) -65, (byte) -65, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private float m = 70.0f;
    private float n = 70.0f;
    private Object o = new Object();
    private float p;
    private float q;
    private int r;

    public static class LiveSmoothMetadata {
        public float m_environment_brightest_reference_normalized_luma;
        public float m_environment_darkest_reference_normalized_luma;
        public float m_intensity;

        public void Copy(LiveSmoothMetadata liveSmoothMetadata) {
            this.m_environment_darkest_reference_normalized_luma = liveSmoothMetadata.m_environment_darkest_reference_normalized_luma;
            this.m_environment_brightest_reference_normalized_luma = liveSmoothMetadata.m_environment_brightest_reference_normalized_luma;
            this.m_intensity = liveSmoothMetadata.m_intensity;
        }
    }

    public CLMakeupLiveSmoothFilter() {
        super(OpenGlUtils.file2Glsl("face/smooth.vert1"), OpenGlUtils.file2Glsl("face/smooth.frag1"),
                OpenGlUtils.file2Glsl("face/smooth.vert2"), OpenGlUtils.file2Glsl("face/smooth.frag2"),
                FilterType.LIVE_SMOOTH);
        a(null, null, l, TableMode.TABLE_1D, true);
    }

    @Override
    public void onDrawArraysPre() {
        super.onDrawArraysPre();
        a(this.m);
        b(this.n);
    }

    @Override
    public void onInit() {
        super.onInit();
        this.r = GLES20.glGetUniformLocation(getProgram(), "environment_luma_darkest");
    }

    protected void c_() {
        super.c_();
        synchronized (this.o) {
            GLES20.glUniform1f(this.r, this.p);
        }
    }

    public void freshData(LiveSmoothMetadata liveSmoothMetadata) {
        synchronized (this.o) {
            this.p = liveSmoothMetadata.m_environment_darkest_reference_normalized_luma;
            this.q = liveSmoothMetadata.m_environment_brightest_reference_normalized_luma;
            c(liveSmoothMetadata.m_intensity);
        }
    }

    private void a(float f) {
        this.m = f;
        float max = (this.m + Math.max(0.0f, this.m - 70.0f)) / 100.0f;
        if (this.a == FilterType.ENABLE_SMOOTH) {
            max *= 1.15f;
        }
        max *= 0.05f + (((((float) Math.min(this.b, this.c)) / 720.0f) - 1.0f) * 0.03f);
        final float finalMax = max;
        runOnDraw(new Runnable() {
            @Override
            public void run() {
                setFloat(h, finalMax);
            }
        });
    }

    private void b(float f) {
        this.n = f;
        final float f2 = this.n / 100.0f;
        runOnDraw(new Runnable() {
            @Override
            public void run() {
                setFloat(i, f2);
            }
        });
    }

    private void c(float f) {
        a(f);
        b(f);
    }

    protected void b(int i, int i2) {
        super.b(i, i2);
        a(this.m);
    }
}
