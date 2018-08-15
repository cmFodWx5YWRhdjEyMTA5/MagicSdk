package com.het.facesdk.utils;

import android.content.Context;

public class ResourceUtil {


    public static int[] screenSize;

    public static int[] getScreenSize(Context context) {
        if (screenSize == null) {
            screenSize = new int[2];
            screenSize[0] = context.getResources().getDisplayMetrics().widthPixels;
            screenSize[1] = context.getResources().getDisplayMetrics().heightPixels;
        }
        return screenSize;
    }

}
