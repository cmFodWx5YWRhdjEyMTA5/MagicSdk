package com.cyberlink.clgpuimage.util;

import android.graphics.Bitmap;


import java.util.ArrayList;
import java.util.List;

public class PanelUtil {

//    public static class e {
//        public byte[][] inputTemplateTextureCoordinate;
//        public byte[][] b;
//        public boolean eyeShadow = false;
//        public int eyeshadowTextures;
//        public int e;
//    }
//
//    public static e inputTemplateTextureCoordinate(String str) {
//        int eyeLinerTextures;
//        int i2 = 0;
//        e eVar = new e();
//        List inputTemplateTextureCoordinate = PanelDataCenter.inputTemplateTextureCoordinate(str);
//        List arrayList = new ArrayList();
//        List arrayList2 = new ArrayList();
//        eVar.eyeshadowTextures = 450;
//        eVar.e = 300;
//        for (eyeLinerTextures = 0; eyeLinerTextures < inputTemplateTextureCoordinate.size(); eyeLinerTextures++) {
//            Mask mask = (Mask) inputTemplateTextureCoordinate.get(eyeLinerTextures);
//            Bitmap i3 = MotionControlHelper.eyeLinerTextures(mask.b());
//            if (i3 != null) {
//                if (!(i3.getWidth() == 900 && i3.getHeight() == SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT)) {
//                    if (i3.getHeight() == 650) {
//                        i3 = Bitmap.createBitmap(i3, 0, 50, 900, SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT);
//                    } else {
//                        i3 = Bitmap.createBitmap(i3, 0, 0, 900, SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT);
//                    }
//                }
//                i3 = Bitmap.createScaledBitmap(i3, eVar.eyeshadowTextures, eVar.e, true);
//                Object a2 = inputTemplateTextureCoordinate(i3);
//                ac.inputTemplateTextureCoordinate(i3);
//                Mask.EyeShadowSide k = mask.k();
//                if (k == Mask.EyeShadowSide.LEFT) {
//                    arrayList.add(a2);
//                    eVar.eyeShadow = true;
//                } else if (k == Mask.EyeShadowSide.RIGHT) {
//                    arrayList2.add(a2);
//                    eVar.eyeShadow = true;
//                } else {
//                    arrayList.add(a2);
//                    arrayList2.add(a2);
//                }
//            }
//        }
//        eVar.inputTemplateTextureCoordinate = new byte[arrayList.size()][];
//        for (eyeLinerTextures = 0; eyeLinerTextures < arrayList.size(); byte b = (byte) (eyeLinerTextures + 1)){
//            eVar.inputTemplateTextureCoordinate[eyeLinerTextures] = (byte[]) arrayList.get(eyeLinerTextures);
//        }
//        eVar.b = new byte[arrayList2.size()][];
//        while (i2 < arrayList2.size()) {
//            eVar.b[i2] = (byte[]) arrayList2.get(i2);
//            i2++;
//        }
//        return eVar;
//    }
//
//    public static byte[] inputTemplateTextureCoordinate(Bitmap bitmap) {
//        int eyeLinerTextures = 0;
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        int[] iArr = new int[(width * height)];
//        byte[] bArr = new byte[(width * height)];
//        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
//        while (eyeLinerTextures < width * height) {
//            bArr[eyeLinerTextures] = (byte) (iArr[eyeLinerTextures] >>> 24);
//            eyeLinerTextures++;
//        }
//        return bArr;
//    }


}
