package com.cyberlink.clgpuimage.util;

import android.graphics.Point;

import java.util.List;

public class PanelDataCenter {

//
//
//    public static class Mask {
//        private final String A;
//        private final int B;
//        private final String C;
//        private final String D;
//        private final String a;
//        private final String b;
//        private final String c;
//        private final String d;
//        private final String e;
//        private final Position f;
//        private final Point g;
//        private final Point h;
//        private final Point i;
//        private final Point j;
//        private final EyeShadowSide k;
//        private final Point l;
//        private final Point m;
//        private final Point n;
//        private final Point o;
//        private final Point p;
//        private final Point q;
//        private final Point r;
//        private final Point s;
//        private final Point t;
//        private final Point u;
//        private final Point v;
//        private final Point w;
//        private final Point x;
//        private final Point y;
//        private final Point z;
//
//        public enum EyeShadowSide {
//            BOTH,
//            LEFT,
//            RIGHT
//        }
//
//        public enum Position {
//            LEFT,
//            RIGHT,
//            UPPER,
//            LOWER,
//            NONE
//        }
//
//        public Mask(String str, String str2, String str3, String str4, String str5, Position position, Point point, Point point2, Point point3, Point point4, EyeShadowSide eyeShadowSide, Point point5, Point point6, Point point7, Point point8, Point point9, Point point10, Point point11, Point point12, Point point13, Point point14, Point point15, Point point16, Point point17, Point point18, Point point19, String str6, int i, String str7, String str8) {
//            this.a = str;
//            this.b = str2;
//            this.c = str3;
//            this.d = str4;
//            this.e = str5;
//            this.f = position;
//            this.g = point;
//            this.h = point2;
//            this.i = point3;
//            this.j = point4;
//            this.k = eyeShadowSide;
//            this.l = point5;
//            this.m = point6;
//            this.n = point7;
//            this.o = point8;
//            this.p = point9;
//            this.q = point10;
//            this.r = point11;
//            this.s = point12;
//            this.t = point13;
//            this.u = point14;
//            this.v = point15;
//            this.w = point16;
//            this.x = point17;
//            this.y = point18;
//            this.z = point19;
//            this.A = str6;
//            this.B = i;
//            this.C = str7;
//            this.D = str8;
//        }
//
//        public Mask(Mask mask) {
//            this.a = mask.a;
//            this.b = mask.b;
//            this.c = mask.c;
//            this.d = mask.d;
//            this.e = mask.e;
//            this.f = mask.f;
//            this.g = mask.g;
//            this.h = mask.h;
//            this.i = mask.i;
//            this.j = mask.j;
//            this.k = mask.k;
//            this.l = mask.l;
//            this.m = mask.m;
//            this.n = mask.n;
//            this.o = mask.o;
//            this.p = mask.p;
//            this.q = mask.q;
//            this.r = mask.r;
//            this.s = mask.s;
//            this.t = mask.t;
//            this.u = mask.u;
//            this.v = mask.v;
//            this.w = mask.w;
//            this.x = mask.x;
//            this.y = mask.y;
//            this.z = mask.z;
//            this.A = mask.A;
//            this.B = mask.B;
//            this.C = mask.C;
//            this.D = mask.D;
//        }
//
//        public static Position a(String str) {
//            if (str.equalsIgnoreCase(Position.LEFT.name())) {
//                return Position.LEFT;
//            }
//            if (str.equalsIgnoreCase(Position.RIGHT.name())) {
//                return Position.RIGHT;
//            }
//            if (str.equalsIgnoreCase(Position.UPPER.name())) {
//                return Position.UPPER;
//            }
//            if (str.equalsIgnoreCase(Position.LOWER.name())) {
//                return Position.LOWER;
//            }
//            return Position.NONE;
//        }
//
//        public static EyeShadowSide b(String str) {
//            if (str.equalsIgnoreCase(EyeShadowSide.BOTH.name())) {
//                return EyeShadowSide.BOTH;
//            }
//            if (str.equalsIgnoreCase(EyeShadowSide.LEFT.name())) {
//                return EyeShadowSide.LEFT;
//            }
//            if (str.equalsIgnoreCase(EyeShadowSide.RIGHT.name())) {
//                return EyeShadowSide.RIGHT;
//            }
//            return EyeShadowSide.BOTH;
//        }
//
//        public String a() {
//            return this.a;
//        }
//
//        public String b() {
//            return this.b;
//        }
//
//        public String c() {
//            return this.c;
//        }
//
//        public String d() {
//            return this.d;
//        }
//
//        public String e() {
//            return this.e;
//        }
//
//        public Position f() {
//            return this.f;
//        }
//
//        public Point g() {
//            return this.g;
//        }
//
//        public Point h() {
//            return this.h;
//        }
//
//        public Point i() {
//            return this.i;
//        }
//
//        public Point j() {
//            return this.j;
//        }
//
//        public EyeShadowSide k() {
//            return this.k;
//        }
//
//        public Point l() {
//            return this.l;
//        }
//
//        public Point m() {
//            return this.m;
//        }
//
//        public Point n() {
//            return this.n;
//        }
//
//        public Point o() {
//            return this.o;
//        }
//
//        public Point p() {
//            return this.p;
//        }
//
//        public Point q() {
//            return this.q;
//        }
//
//        public Point r() {
//            return this.r;
//        }
//
//        public Point s() {
//            return this.s;
//        }
//
//        public Point t() {
//            return this.t;
//        }
//
//        public Point u() {
//            return this.u;
//        }
//
//        public Point v() {
//            return this.v;
//        }
//
//        public Point w() {
//            return this.w;
//        }
//
//        public Point x() {
//            return this.x;
//        }
//
//        public Point y() {
//            return this.y;
//        }
//
//        public Point z() {
//            return this.z;
//        }
//
//        public int A() {
//            try {
//                return Integer.parseInt(this.A);
//            } catch (NumberFormatException e) {
//                return 0;
//            }
//        }
//
//        public int B() {
//            return this.B;
//        }
//
//        public String C() {
//            return this.D;
//        }
//
//        public String toString() {
//            return "PanelDataCenter.Mask [anchorLeft=" + this.u + ", patternId='" + this.a + '\'' + ", src='" + this.b + '\'' + ", shapeSrc='" + this.c + '\'' + ", imageSrc='" + this.d + '\'' + ", secondSrc='" + this.e + '\'' + ", position=" + this.f + ", eyeleft=" + this.g + ", eyetop=" + this.h + ", eyeright=" + this.i + ", eyebottom=" + this.j + ", eyeShadowSide=" + this.k + ", browHead=" + this.l + ", browTop=" + this.m + ", browTail=" + this.n + ", basicBrowHead=" + this.o + ", basicBrowTop=" + this.p + ", basicBrowTail=" + this.q + ", basicEyeHead=" + this.r + ", basicEyeTop=" + this.s + ", basicEyeTail=" + this.t + ", anchorRight=" + this.v + ", anchorLeftTop=" + this.w + ", anchorLeftBottom=" + this.x + ", anchorRightTop=" + this.y + ", anchorRightBottom=" + this.z + ", maskWidth='" + this.A + '\'' + ", order=" + this.B + ", thumbnail='" + this.C + '\'' + ", colorSetGuid='" + this.D + '\'' + ']';
//        }
//    }
//
//    public static List<Mask> a(String str) {
//        BeautyMode beautyMode = BeautyMode.UNDEFINED;
//        int i = -1;
//        switch (str.hashCode()) {
//            case -1409889100:
//                if (str.equals("default_original_double_eyelid")) {
//                    i = 6;
//                    break;
//                }
//                break;
//            case -1395214083:
//                if (str.equals("default_original_eye_wear")) {
//                    i = 2;
//                    break;
//                }
//                break;
//            case -831148323:
//                if (str.equals("default_original_earrings")) {
//                    i = 5;
//                    break;
//                }
//                break;
//            case -591677019:
//                if (str.equals("default_original_wig")) {
//                    i = 1;
//                    break;
//                }
//                break;
//            case -530387390:
//                if (str.equals("default_original_hair_band")) {
//                    i = 3;
//                    break;
//                }
//                break;
//            case 788465062:
//                if (str.equals("default_original_necklace")) {
//                    i = 4;
//                    break;
//                }
//                break;
//            case 1598992866:
//                if (str.equals("default_original_eye_contact")) {
//                    i = 0;
//                    break;
//                }
//                break;
//        }
//        switch (i) {
//            case 0:
//                beautyMode = BeautyMode.EYE_CONTACT;
//                break;
//            case 1:
//                beautyMode = BeautyMode.WIG;
//                break;
//            case 2:
//                beautyMode = BeautyMode.EYE_WEAR;
//                break;
//            case 3:
//                beautyMode = BeautyMode.HAIR_BAND;
//                break;
//            case 4:
//                beautyMode = BeautyMode.NECKLACE;
//                break;
//            case 5:
//                beautyMode = BeautyMode.EARRINGS;
//                break;
//            case 6:
//                beautyMode = BeautyMode.DOUBLE_EYELID;
//                break;
//        }
//        if (beautyMode != BeautyMode.UNDEFINED) {
//            List a = x.a(beautyMode, SourceType.DEFAULT);
//            if (a != null && a.size() > 0) {
//                return x.A((String) a.get(0));
//            }
//        }
//        return x.A(str);
//    }
}
