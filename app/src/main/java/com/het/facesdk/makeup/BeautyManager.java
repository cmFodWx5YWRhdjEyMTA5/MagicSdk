package com.het.facesdk.makeup;

import android.content.Context;
import android.util.Log;

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


    public static BeautyManager getInstance(Context context) {
        if (mBeautyManager == null) {
            synchronized (BeautyManager.class) {
                if (mBeautyManager == null) {
                    mBeautyManager = new BeautyManager();
                    mBeautyManager.mContext = context;
                    FaceThreadManager.getInstance().excute(mBeautyManager.mInitCUIVenus);
                }
            }
        }
        return mBeautyManager;
    }

    private Runnable mInitCUIVenus = new Runnable() {
        @Override
        public void run() {
            mCUIVenus = new CUIVenus(mContext.getApplicationInfo().nativeLibraryDir,
                    modelInit("model/Davinci.cade"),
                    modelInit("model/Venus.regressor"),
                    modelInit("model/Venus.classifier"));
            Log.d(TAG, mCUIVenus.toString());
        }
    };


    private String modelInit(String tPath) {
        String modePath = tPath;
        String targetPath = mContext.getFilesDir().getAbsolutePath() + "/" + tPath.split("/")[1];
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

    public void setLipStick(Object object) {
        mCUIVenus.CUIVenus_SetLipstickProfile(object);
    }


}
