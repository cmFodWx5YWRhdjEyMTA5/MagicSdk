package com.het.facesdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

public class BitmapUtil {


    public static byte[][] decodePNGs(Context context, String[] paths) {
        if (paths == null || paths.length == 0) {
            return null;
        }

        int layers = paths.length;
        byte[][] outPngs = new byte[layers][];
        int width = 450;
        int height = 300;
        BitmapFactory.Options options = new BitmapFactory.Options();
        for (int i = 0; i < layers; i++) {
            try {
                Bitmap orgBitmap = BitmapFactory.decodeStream(context.getAssets().open(paths[i]), null, options);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(orgBitmap, width, height, true);
                outPngs[i] = getGrayBitmapBytes(createScaledBitmap);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return outPngs;
    }

    private static byte[] getGrayBitmapBytes(Bitmap bitmap) {
        int i = 0;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        byte[] bArr = new byte[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        while (i < width * height) {
            bArr[i] = (byte) (iArr[i] >>> 24);
            i++;
        }
        return bArr;
    }
}
