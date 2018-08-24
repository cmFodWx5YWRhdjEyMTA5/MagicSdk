package com.het.facesdk.makeup;

import android.content.Context;
import android.util.Log;

import com.cyberlink.clgpuimage.CLMakeupLiveBlushFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveSmoothFilter;
import com.cyberlink.youcammakeup.jniproxy.CUIVenus;
import com.het.facesdk.core.FaceThreadManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BeautyManager {

    private static final String TAG = BeautyManager.class.getSimpleName();
    private static BeautyManager mBeautyManager;
    CUIVenus mCUIVenus;
    private Context mContext;

    public CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata[] liveEyeMakeupMetadata = null;
    public CLMakeupLiveLipStickFilter.LipstickData lipstickData = null;
    public CLMakeupLiveBlushFilter.LiveBlushMakeupdata liveBlushMakeupdata = null;
    public CLMakeupLiveSmoothFilter.LiveSmoothMetadata liveSmoothMetadata = null;
    public CLMakeupLiveFilter.LiveFrameInformation liveFrameInformation = null;

    public BeautyManager() {
        this.liveEyeMakeupMetadata = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata[2];
        this.liveEyeMakeupMetadata[0] = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        this.liveEyeMakeupMetadata[1] = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        this.lipstickData = new CLMakeupLiveLipStickFilter.LipstickData();
        this.liveBlushMakeupdata = new CLMakeupLiveBlushFilter.LiveBlushMakeupdata();
        this.liveSmoothMetadata = new CLMakeupLiveSmoothFilter.LiveSmoothMetadata();
        this.liveFrameInformation = new CLMakeupLiveFilter.LiveFrameInformation();
    }

    public static BeautyManager getInstance(Context context) {
        if (mBeautyManager == null) {
            synchronized (BeautyManager.class) {
                if (mBeautyManager == null) {
                    mBeautyManager = new BeautyManager();
                    mBeautyManager.mContext = context;
//                    mBeautyManager.initFace();
                    FaceThreadManager.getInstance().excute(mBeautyManager.mInitCUIVenus);
                }
            }
        }
        return mBeautyManager;
    }

    private void initFace() {
        Log.d(TAG, "FileDir#" + cacheRoot());
        mCUIVenus = new CUIVenus(mContext.getApplicationInfo().nativeLibraryDir,
                modelInit("model/Davinci.cade"),
                modelInit("model/Venus.regressor"),
                modelInit("model/Venus.classifier"));
        mCUIVenus.CUIVenus_setIsHoudini(false);
        mCUIVenus.CUIVenus_SetUserProfileFolder(cacheRoot());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isLoadSuccess = mCUIVenus.CUIVenus_IsModelLoaded();
        Log.d(TAG, "CUIVenus_IsModelLoaded#" + isLoadSuccess);
        if (mCUIVenus.CUIVenus_IsModelLoaded()) {
            boolean isMakeUpInit = mCUIVenus.CUIVenus_MakeupLiveInitialize();
            setLipStick(new CLMakeupLiveLipStickFilter.LipStickProfile(CLMakeupLiveLipStickFilter.BlendMode.BRIGHT, 0xFF885511, 75, 100));
            Log.d(TAG, "MakeUpInit#" + isMakeUpInit);
        }
        Log.d(TAG, mCUIVenus.toString());
    }

    private Runnable mInitCUIVenus = new Runnable() {
        @Override
        public void run() {
            initFace();
        }
    };

    private String cacheRoot() {
        return mContext.getFilesDir().getAbsolutePath() + "/";
    }

    private String modelInit(String tPath) {
        String modePath = tPath;
        String targetPath = cacheRoot() + tPath.split("/")[1];
        File cadeFile = new File(targetPath);
        if (!cadeFile.exists()) {
            try {
                cadeFile.createNewFile();
                InputStream open = mContext.getAssets().open(modePath);
                OutputStream fileOutputStream = new FileOutputStream(targetPath);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                open.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return targetPath;
    }

    public void sendFrameBuffer(byte[] data, int w, int h, int roi, boolean isFront) {
        if (mCUIVenus == null) {
            return;
        }
        mCUIVenus.CUIVenus_SendFrameBuffer(data, w, h, roi, isFront);
    }

//    public boolean getMakeupMeta(){
//        return mCUIVenus.CUIVenus_GetMakeupMetadata();
//    }

    public void setLipStick(Object object) {
        mCUIVenus.CUIVenus_SetLipstickProfile(object);
    }

    public boolean getFaceRect(Object object) {
        if (mCUIVenus == null) {
            return false;
        }
        return mCUIVenus.CUIVenus_GetFaceRectangle(object);
    }

    public void getMakeUpData() {
        mCUIVenus.CUIVenus_GetMakeupMetadata(liveEyeMakeupMetadata, lipstickData, liveBlushMakeupdata, liveSmoothMetadata, liveFrameInformation);
        Log.d(TAG, "getMakeUpData#" + lipstickData.m_blend_weight);
    }


}
