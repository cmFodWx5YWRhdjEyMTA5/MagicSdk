package com.het.facesdk.makeup;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;

import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.clgpuimage.CameraFilter;
import com.cyberlink.clgpuimage.GPUImage;
import com.cyberlink.clgpuimage.util.CameraHelper;
import com.het.facesdk.R;
import com.het.facesdk.SimpleBaseActivity;

import java.util.PriorityQueue;

public class MakeUpActivity extends SimpleBaseActivity {


    private static final String TAG = MakeUpActivity.class.getSimpleName();

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MakeUpActivity.class);
        context.startActivity(intent);
    }

    private GLSurfaceView mGLSurfaceView;
    private GPUImage mGPUImage;
    private CLMakeupLiveFilter mCLMakeupLiveFilter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up);

        mCLMakeupLiveFilter = new CLMakeupLiveFilter();
        mGLSurfaceView = findViewById(R.id.glSurfaceView);
        mGPUImage = new GPUImage(this, mCLMakeupLiveFilter);
        mGPUImage.setGLSurfaceView(mGLSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
