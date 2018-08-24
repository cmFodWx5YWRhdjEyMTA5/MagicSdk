package com.cyberlink.clgpuimage;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;

import com.het.facesdk.utils.OpenGlUtils;

import java.nio.FloatBuffer;


/**
 * 照相机滤镜
 * 完美的滤镜模板.
 *
 * @Galis
 */
public class CameraFilter extends GPUImageFilter {

    private static final String TAG = CameraFilter.class.getSimpleName();
    private int mTransformMatrixLocation;
    private int[] mFrameBuffer;
    private int[] mColorTexture;

    public CameraFilter() {
        super(OpenGlUtils.file2Glsl("camera/camera.vert"),
                OpenGlUtils.file2Glsl("camera/camera.frag"));
    }

    @Override
    public void onInit() {
        super.onInit();
        mTransformMatrixLocation = GLES20.glGetUniformLocation(mGLProgId, "transformMatrix");
    }

    @Override
    public void onOutputSizeChanged(int width, int height) {
        super.onOutputSizeChanged(width, height);
        if (mFrameBuffer != null) {
            release();
        }

        this.mFrameBuffer = new int[1];
        this.mColorTexture = new int[1];
        GLES20.glGenFramebuffers(1, this.mFrameBuffer, 0);
        GLES20.glGenTextures(1, this.mColorTexture, 0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mColorTexture[0]);
        OpenGlUtils.useTexParameter();
        GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA,
                width, height, 0, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, null);
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, this.mFrameBuffer[0]);
        GLES20.glFramebufferTexture2D(GLES20.GL_FRAMEBUFFER, GLES20.GL_COLOR_ATTACHMENT0, GLES20.GL_TEXTURE_2D, mColorTexture[0], 0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
        int error = GLES20.glCheckFramebufferStatus(GLES20.GL_FRAMEBUFFER);
        if (error == 0) {
            Log.d(TAG, "GLES#FBO CREATE ERROR!!");
        }
    }

    public int drawWithFrameBuffer(int textureId, FloatBuffer floatBuffer, FloatBuffer textureBuffer) {

        if (!isInitialized() || mFrameBuffer == null || mColorTexture == null) {
            return -1;
        }

        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, mFrameBuffer[0]);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(mGLProgId);
        runPendingOnDrawTasks();

        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, GLES20.GL_FLOAT, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
        textureBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, GLES20.GL_FLOAT, false, 0, textureBuffer);
        GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
        if (textureId != -1) {
            GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
            GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textureId);
            GLES20.glUniform1i(this.mGLUniformTexture, 0);
        }
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
        GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
        GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0);
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);

        return mColorTexture[0];
    }

    @Override
    public void onDraw(int textureId, FloatBuffer floatBuffer, FloatBuffer textureBuffer) {
        if (!isInitialized() || mFrameBuffer == null || mColorTexture == null) {
            return;
        }

        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(mGLProgId);
        runPendingOnDrawTasks();

        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, GLES20.GL_FLOAT, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
        textureBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, GLES20.GL_FLOAT, false, 0, textureBuffer);
        GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
        if (textureId != -1) {
            GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
            GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textureId);
            GLES20.glUniform1i(this.mGLUniformTexture, 0);
        }
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
        GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
        GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0);
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
    }

    public int getTransformMatrixLocation() {
        return mTransformMatrixLocation;
    }

    @Override
    public void onDestroy() {
        release();
        super.onDestroy();
    }

    private void release() {

        if (mColorTexture != null) {
            GLES20.glDeleteTextures(1, mColorTexture, 0);
        }

        if (mFrameBuffer != null) {
            GLES20.glDeleteFramebuffers(1, mFrameBuffer, 0);
        }
    }
}
