package com.cyberlink.clgpuimage.util;

import android.graphics.Bitmap;


import java.util.ArrayList;
import java.util.List;

public class PanelUtil {

//    public static class e {
//        public byte[][] a;
//        public byte[][] b;
//        public boolean c = false;
//        public int d;
//        public int e;
//    }
//
//    public static e a(String str) {
//        int i;
//        int i2 = 0;
//        e eVar = new e();
//        List a = PanelDataCenter.a(str);
//        List arrayList = new ArrayList();
//        List arrayList2 = new ArrayList();
//        eVar.d = 450;
//        eVar.e = 300;
//        for (i = 0; i < a.size(); i++) {
//            Mask mask = (Mask) a.get(i);
//            Bitmap i3 = MotionControlHelper.i(mask.b());
//            if (i3 != null) {
//                if (!(i3.getWidth() == 900 && i3.getHeight() == SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT)) {
//                    if (i3.getHeight() == 650) {
//                        i3 = Bitmap.createBitmap(i3, 0, 50, 900, SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT);
//                    } else {
//                        i3 = Bitmap.createBitmap(i3, 0, 0, 900, SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT);
//                    }
//                }
//                i3 = Bitmap.createScaledBitmap(i3, eVar.d, eVar.e, true);
//                Object a2 = a(i3);
//                ac.a(i3);
//                Mask.EyeShadowSide k = mask.k();
//                if (k == Mask.EyeShadowSide.LEFT) {
//                    arrayList.add(a2);
//                    eVar.c = true;
//                } else if (k == Mask.EyeShadowSide.RIGHT) {
//                    arrayList2.add(a2);
//                    eVar.c = true;
//                } else {
//                    arrayList.add(a2);
//                    arrayList2.add(a2);
//                }
//            }
//        }
//        eVar.a = new byte[arrayList.size()][];
//        for (i = 0; i < arrayList.size(); byte b = (byte) (i + 1)){
//            eVar.a[i] = (byte[]) arrayList.get(i);
//        }
//        eVar.b = new byte[arrayList2.size()][];
//        while (i2 < arrayList2.size()) {
//            eVar.b[i2] = (byte[]) arrayList2.get(i2);
//            i2++;
//        }
//        return eVar;
//    }
//
//    public static byte[] a(Bitmap bitmap) {
//        int i = 0;
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        int[] iArr = new int[(width * height)];
//        byte[] bArr = new byte[(width * height)];
//        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
//        while (i < width * height) {
//            bArr[i] = (byte) (iArr[i] >>> 24);
//            i++;
//        }
//        return bArr;
//    }


}
