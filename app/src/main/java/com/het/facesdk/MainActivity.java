package com.het.facesdk;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.het.facesdk.core.FaceThreadManager;
import com.het.facesdk.facepp.NativeFaceppConfig;
import com.het.facesdk.makeup.MakeUpActivity;
import com.het.facesdk.utils.ConUtil;
import com.het.facesdk.utils.ResourceUtil;
import com.megvii.facepp.sdk.Facepp;
import com.megvii.licensemanager.sdk.LicenseManager;

import java.util.Date;

public class MainActivity extends SimpleBaseActivity {

    // Used to load the 'native-lib' library on application startup.
    private static final int SIMPLE_OK = 1;


    static {
        System.loadLibrary("native-lib");
    }

    private Facepp mFacepp;
    private LicenseManager mLicenseManager;
    private View mArMakeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArMakeup = findViewById(R.id.ar_makeup);
        mArMakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHasPermission()) {
                    initFacepp();
                    MakeUpActivity.startActivity(MainActivity.this);
                } else {
                    requestFaceppPermission();
                }
            }
        });


        mFacepp = new Facepp();
        mLicenseManager = new LicenseManager(this);
        checkPermission();
        requestFaceppPermission();

    }


    private void initFacepp() {

        String errorCode = mFacepp.init(this, ConUtil.getFileContent(this, R.raw.megviifacepp_0_5_2_model), NativeFaceppConfig.isOneFaceTrackig ? 1 : 0);
        if (errorCode != null) {
            return;
        }

        Facepp.FaceppConfig faceppConfig = mFacepp.getFaceppConfig();
        faceppConfig.interval = 25;
        faceppConfig.minFaceSize = 40;
        faceppConfig.roi_left = 0;
        faceppConfig.roi_top = 0;
        faceppConfig.roi_right = ResourceUtil.getScreenSize(this)[0];
        faceppConfig.roi_bottom = ResourceUtil.getScreenSize(this)[1];
        faceppConfig.rotation = 270;

        faceppConfig.detectionMode = Facepp.FaceppConfig.DETECTION_MODE_TRACKING_FAST;
//            faceppConfig.detectionMode = Facepp.FaceppConfig.DETECTION_MODE_TRACKING_ROBUST;
//            faceppConfig.detectionMode = Facepp.FaceppConfig.MG_FPP_DETECTIONMODE_TRACK_RECT;

        mFacepp.setFaceppConfig(faceppConfig);
        String version = mFacepp.getVersion();
        Log.d("ceshi", "onResume:version:" + version);
    }


    private void requestFaceppPermission() {
        FaceThreadManager.getInstance().excute(new Runnable() {
            @Override
            public void run() {
                network();
            }
        });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{android.Manifest.permission.CAMERA}, SIMPLE_OK);
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, SIMPLE_OK);
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{android.Manifest.permission.INTERNET}, SIMPLE_OK);
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{android.Manifest.permission.ACCESS_NETWORK_STATE}, SIMPLE_OK);
        }

    }

    private boolean isHasPermission() {
        final Date date = new Date();
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("facepp", Context.MODE_PRIVATE);
        final int today = date.getDay();
        int lastConfirmDay = sharedPreferences.getInt("day", -1);
        return lastConfirmDay != -1 && lastConfirmDay == today;
    }

    private void network() {

        if (isHasPermission()) {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "今天已授权!!", Toast.LENGTH_SHORT).show();
                }
            });
            return;
        }

        final Date date = new Date();
        final int today = date.getDay();
        mLicenseManager.setAuthTimeBufferMillis(0);
        long apiName = Facepp.getApiName();
        String uuid = ConUtil.getUUIDString(MainActivity.this);
        mLicenseManager.takeLicenseFromNetwork(NativeFaceppConfig.CN_LICENSE_URL, uuid, NativeFaceppConfig.API_KEY, NativeFaceppConfig.API_SECRET, apiName,
                "1", new LicenseManager.TakeLicenseCallback() {
                    @Override
                    public void onSuccess() {
                        int month = date.getMonth();
                        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("facepp", Context.MODE_PRIVATE);
                        sharedPreferences.edit().putInt("day", today).putInt("month", month).apply();
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "授权成功!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onFailed(int i, byte[] bytes) {
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Fail to detect", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
