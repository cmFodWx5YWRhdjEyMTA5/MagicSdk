package com.het.facesdk.makeup;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;

import com.het.facesdk.makeup.matrix.BeautyMatrix;
import com.het.facesdk.makeup.matrix.BiMatrix;
import com.het.facesdk.makeup.matrix.BrightnessMatrix;
import com.het.facesdk.makeup.matrix.CameraMatrix;
import com.het.facesdk.makeup.matrix.LookUpMatrix;
import com.het.facesdk.makeup.matrix.PosterizeMatrix;
import com.het.facesdk.makeup.matrix.WindowMatrix;
import com.het.facesdk.utils.OpenGlUtils;

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
    public static final int POSTERIZE = WINDOW + 1;
    public static final int BRIGHTNESS = POSTERIZE + 1;
    public static final int LOOKUP = BRIGHTNESS + 1;
    public static final int BEAUTY = LOOKUP + 1;
    public static final int BUFFER_NUM = 2;

    private static final String TAG = MakeUpEngine.class.getSimpleName();
    private static int gCurrentFrameBufferIndex = 0;
    private static int[] gFrameBuf = new int[BUFFER_NUM];
    private static int[] gCameraTexture = new int[1];
    private static int[] gFrameBufferColorTextures = new int[BUFFER_NUM];//挂靠在FrameBuffer的ColorTexture
    private static LinkedList<IMatrix> gMatrixs = new LinkedList<>();
    private static IMatrix gWindowMatrix;


    public static MakeUpEngine.IMatrix create(int type) {
        switch (type) {
            case CAMERA:
                return new CameraMatrix(gCameraTexture[0]);
            case BILATERAL:
                return new BiMatrix(gFrameBufferColorTextures[0]);
            case POSTERIZE:
                return new PosterizeMatrix(gFrameBufferColorTextures[0]);
            case WINDOW:
                return new WindowMatrix(gFrameBufferColorTextures[0]);
            case BRIGHTNESS:
                return new BrightnessMatrix(gFrameBufferColorTextures[0]);
            case LOOKUP:
                return new LookUpMatrix(gFrameBufferColorTextures[0]);
            case BEAUTY:
                return new BeautyMatrix(gFrameBufferColorTextures[0]);
        }
        return null;
    }


    public static void onSurfaceCreated(int width, int height) {

        GLES30.glGenTextures(1, gCameraTexture, 0);
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0);
        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, gCameraTexture[0]);
        gWindowMatrix = MakeUpEngine.create(MakeUpEngine.WINDOW);

        initFrameBuffer(width, height);


    }

    public static void initFrameBuffer(int width, int height) {
        GLES30.glGenFramebuffers(gFrameBuf.length, gFrameBuf, 0);
        GLES30.glGenTextures(gFrameBufferColorTextures.length, gFrameBufferColorTextures, 0);
        for (int i = 0; i < BUFFER_NUM; i++) {
            GLES30.glActiveTexture(GLES30.GL_TEXTURE1);
            GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, gFrameBufferColorTextures[i]);
            OpenGlUtils.useTexParameter();
            if (width > height) {
                GLES30.glTexImage2D(GLES30.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, height, width, 0, GLES20.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, null);
            } else {
                GLES30.glTexImage2D(GLES30.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, width, height, 0, GLES20.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, null);
            }
            GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, 0);

            GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, gFrameBuf[i]);
            GLES30.glFramebufferTexture2D(GLES20.GL_FRAMEBUFFER, GLES20.GL_COLOR_ATTACHMENT0, GLES20.GL_TEXTURE_2D, gFrameBufferColorTextures[i], 0);
            GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, 0);
            int error = GLES30.glCheckFramebufferStatus(GLES20.GL_FRAMEBUFFER);
            if (error == 0) {
                Log.d(TAG, "FBO CREATE ERROR!!");
            }
        }

    }


    public static void onSurfaceChanged(int w, int h) {
        for (IMatrix matrix : gMatrixs) {
            matrix.onSurfaceChanged(w, h);
        }
    }

    public static void onSurfaceDestory() {

    }

    public static void work() {

        if (gMatrixs.size() == 1) {
            GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, 0);
            gMatrixs.get(0).draw();
            return;
        }

        for (IMatrix matrix : gMatrixs) {
            int inputTextureIndex = 1 - gCurrentFrameBufferIndex;
            if (matrix instanceof CameraMatrix) {
                GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, gFrameBuf[gCurrentFrameBufferIndex]);
                matrix.draw();
            } else if (matrix instanceof WindowMatrix) {
                GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, 0);
                matrix.draw(gFrameBufferColorTextures[inputTextureIndex]);
            } else {
                GLES30.glBindFramebuffer(GLES30.GL_FRAMEBUFFER, gFrameBuf[gCurrentFrameBufferIndex]);
                matrix.draw(gFrameBufferColorTextures[inputTextureIndex]);
            }
            gCurrentFrameBufferIndex = inputTextureIndex;
        }
    }

    public static IMatrix innerWindowMatrix() {
        return gWindowMatrix;
    }

    public static void push(IMatrix iMatrix) {
        gMatrixs.add(iMatrix);
    }

    public static IMatrix pollLast() {
        return gMatrixs.pollLast();
    }

    public static IMatrix pollFirst() {
        return gMatrixs.pollFirst();
    }

    public interface IMatrix {

        void control(int progress);

        void draw();

        void draw(int inputTexture);

        int textureId();

        void onSurfaceChanged(int w, int h);

        void onSurfaceCreated();

    }


}
