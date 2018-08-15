package com.het.facesdk;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.het.facesdk.core.FaceThreadManager;
import com.het.facesdk.facepp.FaceppEngine;
import com.het.facesdk.makeup.MakeUpActivity;
import com.megvii.licensemanager.sdk.LicenseManager;

public class MainActivity extends SimpleBaseActivity {

    // Used to load the 'native-lib' library on application startup.
    private static final int SIMPLE_OK = 1;


    static {
        System.loadLibrary("native-lib");
    }

    private View mArMakeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArMakeup = findViewById(R.id.ar_makeup);
        mArMakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FaceppEngine.hasPermission()) {
                    FaceppEngine.init(MainActivity.this);
                    MakeUpActivity.startActivity(MainActivity.this);
                } else {
                    requestFaceppPermission();
                }
            }
        });

        FaceppEngine.init(this);

        checkPermission();
        requestFaceppPermission();

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


    private void network() {

        if (FaceppEngine.hasPermission()) {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "今天已授权!!", Toast.LENGTH_SHORT).show();
                }
            });
            return;
        }

        FaceppEngine.takePermission(new LicenseManager.TakeLicenseCallback() {
            @Override
            public void onSuccess() {
                FaceppEngine.saveCookie();
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
