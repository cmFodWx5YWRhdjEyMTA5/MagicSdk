package com.het.facesdk.makeup;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;

import com.cyberlink.clgpuimage.CameraFilter;
import com.cyberlink.clgpuimage.GPUImage;
import com.cyberlink.clgpuimage.util.CameraHelper;
import com.het.facesdk.R;
import com.het.facesdk.SimpleBaseActivity;

public class MakeUpActivity extends SimpleBaseActivity {


    private static final String TAG = MakeUpActivity.class.getSimpleName();

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MakeUpActivity.class);
        context.startActivity(intent);
    }

    private SeekBar mBiSeekBar;
    private GLSurfaceView mGLSurfaceView;
    private GPUImage mGPUImage;
    private CameraHelper mCameraHelper;
    private CameraLoader mCamera;
    private CameraFilter mDefaultWindowFilter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up);

        mDefaultWindowFilter = new CameraFilter();
        mGPUImage = new GPUImage(this);
        mGLSurfaceView = findViewById(R.id.glSurfaceView);
        mGPUImage.setGLSurfaceView(mGLSurfaceView);
        mGPUImage.setFilter(mDefaultWindowFilter);
        mCameraHelper = new CameraHelper(this);
        mCamera = new CameraLoader();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCamera.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCamera.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class CameraLoader {

        private int mCurrentCameraId = 1;
        private Camera mCameraInstance;

        public void onResume() {
            setUpCamera(mCurrentCameraId);
        }

        public void onPause() {
            releaseCamera();
        }

        public void switchCamera() {
            releaseCamera();
            mCurrentCameraId = (mCurrentCameraId + 1) % mCameraHelper.getNumberOfCameras();
            setUpCamera(mCurrentCameraId);
        }

        private void setUpCamera(final int id) {
            mCameraInstance = getCameraInstance(id);
            Camera.Parameters parameters = mCameraInstance.getParameters();
            // TODO adjust by getting supportedPreviewSizes and then choosing
            // the best one for screen size (best fill screen)
            if (parameters.getSupportedFocusModes().contains(
                    Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
                parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            }
            mCameraInstance.setParameters(parameters);

            int orientation = mCameraHelper.getCameraDisplayOrientation(
                    MakeUpActivity.this, mCurrentCameraId);
            CameraHelper.CameraInfo2 cameraInfo = new CameraHelper.CameraInfo2();
            mCameraHelper.getCameraInfo(mCurrentCameraId, cameraInfo);
            boolean flipHorizontal = cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT;
            mGPUImage.setUpCamera(mCameraInstance, orientation, flipHorizontal, false);
        }

        /**
         * A safe way to get an instance of the Camera object.
         */
        private Camera getCameraInstance(final int id) {
            Camera c = null;
            try {
                c = mCameraHelper.openCamera(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return c;
        }

        private void releaseCamera() {
            mCameraInstance.setPreviewCallback(null);
            mCameraInstance.release();
            mCameraInstance = null;
        }
    }
}
