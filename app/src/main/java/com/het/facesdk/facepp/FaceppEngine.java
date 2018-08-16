package com.het.facesdk.facepp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.het.facesdk.R;
import com.het.facesdk.utils.ConUtil;
import com.het.facesdk.utils.ResourceUtil;
import com.megvii.facepp.sdk.Facepp;
import com.megvii.licensemanager.sdk.LicenseManager;

import java.util.Date;

/**
 * Face++机器...
 * 负责授权,检测等一系列动作
 *
 * @Galis
 */
public class FaceppEngine {

    public static Facepp gFacepp;
    public static LicenseManager gLicenseManager;
    public static Context gContext;

    public static void init(Context context) {
        if (gFacepp == null) {
            gFacepp = new Facepp();
        }
        if (gLicenseManager == null) {
            gLicenseManager = new LicenseManager(context);
        }

        gContext = context;

    }

    public static void release() {
        if (gFacepp != null) {
            gFacepp.release();
        }
    }

    public static boolean hasPermission() {
        final Date date = new Date();
        SharedPreferences sharedPreferences = gContext.getSharedPreferences("gFacepp", Context.MODE_PRIVATE);
        final int today = date.getDay();
        int lastConfirmDay = sharedPreferences.getInt("day", -1);
        return lastConfirmDay != -1 && lastConfirmDay == today;
    }

    public static void saveCookie() {
        final Date date = new Date();
        int month = date.getMonth();
        final int today = date.getDay();
        SharedPreferences sharedPreferences = gContext.getSharedPreferences("gFacepp", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("day", today).putInt("month", month).apply();
    }

    public static void takePermission(final LicenseManager.TakeLicenseCallback callback) {
        if (gLicenseManager == null) {
            return;
        }
        gLicenseManager.setAuthTimeBufferMillis(0);
        long apiName = Facepp.getApiName();
        String uuid = ConUtil.getUUIDString(gContext);
        gLicenseManager.takeLicenseFromNetwork(NativeFaceppConfig.CN_LICENSE_URL, uuid, NativeFaceppConfig.API_KEY, NativeFaceppConfig.API_SECRET, apiName,
                "1", new LicenseManager.TakeLicenseCallback() {
                    @Override
                    public void onSuccess() {
                        callback.onSuccess();
                        String errorCode = gFacepp.init(gContext, ConUtil.getFileContent(gContext, R.raw.megviifacepp_0_5_2_model),
                                NativeFaceppConfig.isOneFaceTrackig ? 1 : 0);
                        if (errorCode != null) {
                            return;
                        }

                        Facepp.FaceppConfig faceppConfig = gFacepp.getFaceppConfig();
                        faceppConfig.interval = 25;
                        faceppConfig.minFaceSize = 40;
                        faceppConfig.roi_left = 0;
                        faceppConfig.roi_top = 0;
                        faceppConfig.roi_right = ResourceUtil.getScreenSize(gContext)[0];
                        faceppConfig.roi_bottom = ResourceUtil.getScreenSize(gContext)[1];
                        faceppConfig.rotation = 270;

                        faceppConfig.detectionMode = Facepp.FaceppConfig.DETECTION_MODE_TRACKING_FAST;
//            faceppConfig.detectionMode = Facepp.FaceppConfig.DETECTION_MODE_TRACKING_ROBUST;
//            faceppConfig.detectionMode = Facepp.FaceppConfig.MG_FPP_DETECTIONMODE_TRACK_RECT;

                        gFacepp.setFaceppConfig(faceppConfig);
                        String version = gFacepp.getVersion();
                        Log.d("ceshi", "onResume:version:" + version);
                    }

                    @Override
                    public void onFailed(int i, byte[] bytes) {
                        callback.onFailed(i, bytes);
                    }
                });

    }

    public static void setFaceppConfig(Facepp.FaceppConfig config) {
        assert (gFacepp != null);
        gFacepp.setFaceppConfig(config);
    }

    public static Facepp.Face[] detect(byte[] data, int width, int height, int mode) {
        assert (gFacepp != null);
        return gFacepp.detect(data, width, height, mode);
    }


}
