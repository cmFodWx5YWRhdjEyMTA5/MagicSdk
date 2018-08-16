package com.het.facesdk.makeup;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;

import com.het.facesdk.makeup.matrix.BiMatrix;
import com.het.facesdk.makeup.matrix.CameraMatrix;
import com.het.facesdk.makeup.matrix.WindowMatrix;

import java.util.LinkedList;

/**
 * 化妆MakeUp
 * 1.新建FBO缓冲区,绑定输出纹理
 * 2.逐步执行相关添加进来的动作
 *
 * @Galis
 */
public class MakeUpEngine {


    public static final int CAMERA = 0;
    public static final int BILATERAL = CAMERA + 1;
    public static final int WINDOW = BILATERAL + 1;

    private static final String TAG = MakeUpEngine.class.getSimpleName();
    private static int[] gFrameBuf = new int[1];
    private static int[] gCameraTexture = new int[1];
    private static int[] gTexture = new int[1];
    private static LinkedList<IMatrix> gMatrixs = new LinkedList<>();
    private static IMatrix gWindowMatrix;


    public static MakeUpEngine.IMatrix create(int type) {
        switch (type) {
            case CAMERA:
                return new CameraMatrix(gCameraTexture[0]);
            case BILATERAL:
                return new BiMatrix(gTexture[0]);
            case WINDOW:
                return new WindowMatrix(gTexture[0]);
        }
        return null;
    }


    public static void onSurfaceCreated(int width, int height) {

        GLES30.glGenTextures(1, gCameraTexture, 0);
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, gCameraTexture[0]);

        /**
         * 生成一个纹理对象
         */
        GLES30.glGenTextures(1, gTexture, 0);
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, gTexture[0]);
        GLES30.glTexParameterf(GLES20.GL_TEXTURE_2D,
                GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
        GLES30.glTexParameterf(GLES20.GL_TEXTURE_2D,
                GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
        GLES30.glTexParameterf(GLES20.GL_TEXTURE_2D,
                GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
        GLES30.glTexParameterf(GLES20.GL_TEXTURE_2D,
                GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);

        //确认是个竖直方向的纹理
        if (width > height) {
            GLES30.glTexImage2D(GLES30.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, height, width, 0, GLES20.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, null);
        } else {
            GLES30.glTexImage2D(GLES30.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, width, height, 0, GLES20.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, null);
        }
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, 0);

        GLES30.glGenFramebuffers(1, gFrameBuf, 0);
        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, gFrameBuf[0]);
        GLES30.glFramebufferTexture2D(GLES20.GL_FRAMEBUFFER, GLES20.GL_COLOR_ATTACHMENT0, GLES20.GL_TEXTURE_2D, gTexture[0], 0);
        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, 0);
        int error = GLES30.glCheckFramebufferStatus(GLES20.GL_FRAMEBUFFER);
        if (error == 0) {
            Log.d(TAG, "FBO CREATE ERROR!!");
        }

        gWindowMatrix = MakeUpEngine.create(MakeUpEngine.WINDOW);

    }

    public static void onSurfaceChanged(int w,int h) {
        for (IMatrix matrix:gMatrixs){
            matrix.onSurfaceChanged(w,h);
        }
    }

    public static void onSurfaceDestory() {

    }

    public static void work() {
        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, gFrameBuf[0]);
        GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, 0);
        for (IMatrix matrix : gMatrixs) {
            matrix.draw();
        }
//        gWindowMatrix.draw();
    }

    public static void push(IMatrix iMatrix) {
        gMatrixs.push(iMatrix);
    }

    public static IMatrix pollLast() {
        return gMatrixs.pollLast();
    }

    public static IMatrix pollFirst() {
        return gMatrixs.pollFirst();
    }

    public interface IMatrix {
        void draw();

        int textureId();

        void onSurfaceChanged(int w, int h);

        void onSurfaceCreated();
    }


}
