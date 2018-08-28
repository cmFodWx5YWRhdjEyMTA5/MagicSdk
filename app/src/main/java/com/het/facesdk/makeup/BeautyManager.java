package com.het.facesdk.makeup;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;

import com.cyberlink.clgpuimage.CLMakeupLiveBlushFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter;
import com.cyberlink.clgpuimage.CLMakeupLiveSmoothFilter;
import com.cyberlink.youcammakeup.jniproxy.CUIVenus;
import com.cyberlink.youcammakeup.jniproxy.UIVenusJNI;
import com.het.facesdk.core.FaceThreadManager;
import com.het.facesdk.utils.BitmapUtil;

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


    public byte[] mEyeLiner;
    public byte[] mEyeLash;
    public PointF[] mGlobalPoints;

    public BeautyManager() {
        this.liveEyeMakeupMetadata = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata[2];
        this.liveEyeMakeupMetadata[0] = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        this.liveEyeMakeupMetadata[1] = new CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        this.lipstickData = new CLMakeupLiveLipStickFilter.LipstickData();
        this.liveBlushMakeupdata = new CLMakeupLiveBlushFilter.LiveBlushMakeupdata();
        this.liveSmoothMetadata = new CLMakeupLiveSmoothFilter.LiveSmoothMetadata();
        this.liveFrameInformation = new CLMakeupLiveFilter.LiveFrameInformation();

        mGlobalPoints = new PointF[4];
        mGlobalPoints[0] = new PointF(142.0f, 143.5f);
        mGlobalPoints[1] = new PointF(229.0f, 106.5f);
        mGlobalPoints[2] = new PointF(316.5f, 143.5f);
        mGlobalPoints[3] = new PointF(229.0f, 181.0f);
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
            setLipStick(new CLMakeupLiveLipStickFilter.LipStickProfile(CLMakeupLiveLipStickFilter.BlendMode.BRIGHT, 0xFFFF0000, 75, 100));
            byte[][] eyeLinerSrc = BitmapUtil.decodePNGs(mContext, new String[]{
                    "makeup/eyeline/01_01_01.png"
            });
            byte[][] eyeLashSrc = BitmapUtil.decodePNGs(mContext, new String[]{
                    "makeup/eyelash/01_01_01.png"
            });
            mEyeLiner = new byte[450 * 300];
            mEyeLash = new byte[450 * 300];

            initialEyeModelCommonInfo(mGlobalPoints, 450, 300);
            preprocessEyelinerModel(mEyeLiner, eyeLinerSrc, 0xFF333333, 50, 1, 450, 300);
            preprocessEyelinerModel(mEyeLash, eyeLashSrc, 0xFF333333, 50, 1, 450, 300);
            Log.d(TAG, "MakeUpInit#" + isMakeUpInit);
        }
        Log.d(TAG, mCUIVenus.toString());
    }

    public PointF[] getGlobalPoints() {
        return mGlobalPoints;
    }

    private Runnable mInitCUIVenus = new Runnable() {
        @Override
        public void run() {
            initFace();
        }
    };

    public byte[] getEyeLiner() {
        return mEyeLiner;
    }

    public byte[] getEyeLash() {
        return mEyeLash;
    }

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

    public void initialEyeModelCommonInfo(Object[] objArr, int i, int i2) {
        mCUIVenus.CUIVenus_InitialEyeModelCommonInfo(objArr, i, i2);
    }

    public boolean preprocessEyeshadowModel(int[] iArr, Object[] objArr, int[] iArr2, int[] iArr3,
                                            int i, int i2, int i3, int i4, int i5,
                                            int[] iArr4,
                                            int i6, int i7, int i8,
                                            byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return mCUIVenus.CUIVenus_PreprocessEyeshadowModel(iArr, objArr, iArr2, iArr3,
                i, i2, i3, i4, i5,
                iArr4,
                i6, i7, i8,
                bArr, bArr2, bArr3);
    }

    public boolean preprocessEyelinerModel(byte[] outBitmap, Object[] objArr,
                                           int i, int i2, int i3, int i4, int i5) {
        return mCUIVenus.CUIVenus_PreprocessEyelinerModel(outBitmap, objArr,
                i, i2, i3, i4, i5);
    }

    public boolean preprocessEyelashModel(byte[] outBitmap, Object[] objArr,
                                          int i, int i2, int i3, int i4, int i5) {
        return mCUIVenus.CUIVenus_PreprocessEyelashModel(outBitmap, objArr, i, i2, i3, i4, i5);
    }

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
