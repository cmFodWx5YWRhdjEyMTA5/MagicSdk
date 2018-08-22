package com.cyberlink.clgpuimage;

import com.het.facesdk.utils.OpenGlUtils;

public class CameraFilter extends GPUImageFilter {


    public static final float[] DEFAULT_VERTEXS = new float[]{
            1.0f, 1.0f,
            -1.0f, 1.0f,
            -1.0f, -1.0f,
            1.0f, 1.0f,
            -1.0f, -1.0f,
            1.0f, -1.0f
    };

    public static final float[] DEFAULT_FRAGS = new float[]{
            1.0f, 0.0f,
            1.0f, 1.0f,
            0.0f, 1.0f,
            1.0f, 0.0f,
            0.0f, 1.0f,
            0.0f, 0.0f
    };


    public CameraFilter() {
        super(OpenGlUtils.file2Glsl("camera/camera.vert"),
                OpenGlUtils.file2Glsl("camera/camera.frag"),
                DEFAULT_VERTEXS,
                DEFAULT_FRAGS);
    }
}
