package com.het.facesdk.utils;

import android.app.Activity;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.Surface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CameraUtil {

    public static final String TAG = CameraUtil.class.getSimpleName();

    /**
     * 这个方法必须在onSurfaceCreate调用
     *
     * @return
     */
    public static Camera openCamera(int width,int height) {
        Camera camera = null;
        boolean isOpen = false;
        try {
            camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
            isOpen = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!isOpen) {
            try {
                camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
                isOpen = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!isOpen) {
            Log.e(TAG, "No camera!!");
            return null;
        }

        Camera.Parameters camParm = camera.getParameters();
        Camera.Size size = calBestPreviewSize(camParm,width,height);
        camParm.setPreviewSize(size.width, size.height);
        camParm.setPreviewFrameRate(30);
        camParm.setPreviewFormat(ImageFormat.NV21);
        camera.setParameters(camParm);


        return camera;
    }

    public static Camera.Size calBestPreviewSize(Camera.Parameters camPara,
                                                 final int width, final int height) {
        List<Camera.Size> allSupportedSize = camPara.getSupportedPreviewSizes();
        ArrayList<Camera.Size> widthLargerSize = new ArrayList<Camera.Size>();
        for (Camera.Size tmpSize : allSupportedSize) {
            Log.w("ceshi", "tmpSize.width===" + tmpSize.width
                    + ", tmpSize.height===" + tmpSize.height);
            if (tmpSize.width > tmpSize.height) {
                widthLargerSize.add(tmpSize);
            }
        }

        Collections.sort(widthLargerSize, new Comparator<Camera.Size>() {
            @Override
            public int compare(Camera.Size lhs, Camera.Size rhs) {
                int off_one = Math.abs(lhs.width * lhs.height - width * height);
                int off_two = Math.abs(rhs.width * rhs.height - width * height);
                return off_one - off_two;
            }
        });

        return widthLargerSize.get(0);
    }

    public static void setCameraDisplayOrientation(Activity activity,
                                                   int cameraId, android.hardware.Camera camera) {
        android.hardware.Camera.CameraInfo info =
                new android.hardware.Camera.CameraInfo();
        android.hardware.Camera.getCameraInfo(cameraId, info);
        int rotation = activity.getWindowManager().getDefaultDisplay()
                .getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;  // compensate the mirror
        } else {  // back-facing
            result = (info.orientation - degrees + 360) % 360;
        }
        camera.setDisplayOrientation(result);
    }
}
