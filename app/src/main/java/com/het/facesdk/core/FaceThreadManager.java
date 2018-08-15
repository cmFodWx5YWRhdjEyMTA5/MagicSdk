package com.het.facesdk.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FaceThreadManager {

    private static FaceThreadManager mFaceThreadManager = null;
    ExecutorService mFaceThreadService;


    public static FaceThreadManager getInstance() {
        if (mFaceThreadManager == null) {
            synchronized (FaceThreadManager.class) {
                if (mFaceThreadManager == null) {
                    mFaceThreadManager = new FaceThreadManager();
                    mFaceThreadManager.mFaceThreadService = Executors.newFixedThreadPool(3);
                }
            }
        }
        return mFaceThreadManager;
    }


    public void excute(Runnable runnable) {
        mFaceThreadService.execute(runnable);
    }


}
