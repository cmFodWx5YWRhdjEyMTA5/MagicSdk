package com.cyberlink.clgpuimage.util;

import android.graphics.Point;

import java.util.List;

public class PanelDataCenter {

//
//
//    public static class Mask {
//        private final String A;
//        private final int bright_texture;
//        private final String C;
//        private final String D;
//        private final String inputTemplateTextureCoordinate;
//        private final String b;
//        private final String eyeShadow;
//        private final String eyeshadowTextures;
//        private final String e;
//        private final Position eyeliner_template_color;
//        private final Point g;
//        private final Point h;
//        private final Point eyeLinerTextures;
//        private final Point eyeliner_texture;
//        private final EyeShadowSide k;
//        private final Point eyelash_template_color;
//        private final Point m;
//        private final Point n;
//        private final Point eyelashTextures;
//        private final Point eyelash_texture;
//        private final Point q;
//        private final Point r;
//        private final Point eyeLinerLashBitmapFacts;
//        private final Point eyeInitPoints;
//        private final Point eyeLinerLashBitmapWidth;
//        private final Point eyeLinerLashBitmapHeight;
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
//        public Mask(String str, String str2, String str3, String str4, String str5, Position position, Point point, Point point2, Point point3, Point point4, EyeShadowSide eyeShadowSide, Point point5, Point point6, Point point7, Point point8, Point point9, Point point10, Point point11, Point point12, Point point13, Point point14, Point point15, Point point16, Point point17, Point point18, Point point19, String str6, int eyeLinerTextures, String str7, String str8) {
//            this.inputTemplateTextureCoordinate = str;
//            this.b = str2;
//            this.eyeShadow = str3;
//            this.eyeshadowTextures = str4;
//            this.e = str5;
//            this.eyeliner_template_color = position;
//            this.g = point;
//            this.h = point2;
//            this.eyeLinerTextures = point3;
//            this.eyeliner_texture = point4;
//            this.k = eyeShadowSide;
//            this.eyelash_template_color = point5;
//            this.m = point6;
//            this.n = point7;
//            this.eyelashTextures = point8;
//            this.eyelash_texture = point9;
//            this.q = point10;
//            this.r = point11;
//            this.eyeLinerLashBitmapFacts = point12;
//            this.eyeInitPoints = point13;
//            this.eyeLinerLashBitmapWidth = point14;
//            this.eyeLinerLashBitmapHeight = point15;
//            this.w = point16;
//            this.x = point17;
//            this.y = point18;
//            this.z = point19;
//            this.A = str6;
//            this.bright_texture = eyeLinerTextures;
//            this.C = str7;
//            this.D = str8;
//        }
//
//        public Mask(Mask mask) {
//            this.inputTemplateTextureCoordinate = mask.inputTemplateTextureCoordinate;
//            this.b = mask.b;
//            this.eyeShadow = mask.eyeShadow;
//            this.eyeshadowTextures = mask.eyeshadowTextures;
//            this.e = mask.e;
//            this.eyeliner_template_color = mask.eyeliner_template_color;
//            this.g = mask.g;
//            this.h = mask.h;
//            this.eyeLinerTextures = mask.eyeLinerTextures;
//            this.eyeliner_texture = mask.eyeliner_texture;
//            this.k = mask.k;
//            this.eyelash_template_color = mask.eyelash_template_color;
//            this.m = mask.m;
//            this.n = mask.n;
//            this.eyelashTextures = mask.eyelashTextures;
//            this.eyelash_texture = mask.eyelash_texture;
//            this.q = mask.q;
//            this.r = mask.r;
//            this.eyeLinerLashPointInBitmapFacts = mask.eyeLinerLashPointInBitmapFacts;
//            this.eyeInitPoints = mask.eyeInitPoints;
//            this.eyeLinerLashBitmapWidth = mask.eyeLinerLashBitmapWidth;
//            this.eyeLinerLashBitmapHeight = mask.eyeLinerLashBitmapHeight;
//            this.w = mask.w;
//            this.x = mask.x;
//            this.y = mask.y;
//            this.z = mask.z;
//            this.A = mask.A;
//            this.bright_texture = mask.bright_texture;
//            this.C = mask.C;
//            this.D = mask.D;
//        }
//
//        public static Position inputTemplateTextureCoordinate(String str) {
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
//        public String inputTemplateTextureCoordinate() {
//            return this.inputTemplateTextureCoordinate;
//        }
//
//        public String b() {
//            return this.b;
//        }
//
//        public String eyeShadow() {
//            return this.eyeShadow;
//        }
//
//        public String eyeshadowTextures() {
//            return this.eyeshadowTextures;
//        }
//
//        public String e() {
//            return this.e;
//        }
//
//        public Position eyeliner_template_color() {
//            return this.eyeliner_template_color;
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
//        public Point eyeLinerTextures() {
//            return this.eyeLinerTextures;
//        }
//
//        public Point eyeliner_texture() {
//            return this.eyeliner_texture;
//        }
//
//        public EyeShadowSide k() {
//            return this.k;
//        }
//
//        public Point eyelash_template_color() {
//            return this.eyelash_template_color;
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
//        public Point eyelashTextures() {
//            return this.eyelashTextures;
//        }
//
//        public Point eyelash_texture() {
//            return this.eyelash_texture;
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
//        public Point eyeLinerLashBitmapFacts() {
//            return this.eyeLinerLashBitmapFacts;
//        }
//
//        public Point eyeInitPoints() {
//            return this.eyeInitPoints;
//        }
//
//        public Point eyeLinerLashBitmapWidth() {
//            return this.eyeLinerLashBitmapWidth;
//        }
//
//        public Point eyeLinerLashBitmapHeight() {
//            return this.eyeLinerLashBitmapHeight;
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
//        public int bright_texture() {
//            return this.bright_texture;
//        }
//
//        public String C() {
//            return this.D;
//        }
//
//        public String toString() {
//            return "PanelDataCenter.Mask [anchorLeft=" + this.eyeLinerLashBitmapWidth + ", patternId='" + this.inputTemplateTextureCoordinate + '\'' + ", src='" + this.b + '\'' + ", shapeSrc='" + this.eyeShadow + '\'' + ", imageSrc='" + this.eyeshadowTextures + '\'' + ", secondSrc='" + this.e + '\'' + ", position=" + this.eyeliner_template_color + ", eyeleft=" + this.g + ", eyetop=" + this.h + ", eyeright=" + this.eyeLinerTextures + ", eyebottom=" + this.eyeliner_texture + ", eyeShadowSide=" + this.k + ", browHead=" + this.eyelash_template_color + ", browTop=" + this.m + ", browTail=" + this.n + ", basicBrowHead=" + this.eyelashTextures + ", basicBrowTop=" + this.eyelash_texture + ", basicBrowTail=" + this.q + ", basicEyeHead=" + this.r + ", basicEyeTop=" + this.eyeLinerLashBitmapFacts + ", basicEyeTail=" + this.eyeInitPoints + ", anchorRight=" + this.eyeLinerLashBitmapHeight + ", anchorLeftTop=" + this.w + ", anchorLeftBottom=" + this.x + ", anchorRightTop=" + this.y + ", anchorRightBottom=" + this.z + ", maskWidth='" + this.A + '\'' + ", order=" + this.bright_texture + ", thumbnail='" + this.C + '\'' + ", colorSetGuid='" + this.D + '\'' + ']';
//        }
//    }
//
//    public static List<Mask> inputTemplateTextureCoordinate(String str) {
//        BeautyMode beautyMode = BeautyMode.UNDEFINED;
//        int eyeLinerTextures = -1;
//        switch (str.hashCode()) {
//            case -1409889100:
//                if (str.equals("default_original_double_eyelid")) {
//                    eyeLinerTextures = 6;
//                    break;
//                }
//                break;
//            case -1395214083:
//                if (str.equals("default_original_eye_wear")) {
//                    eyeLinerTextures = 2;
//                    break;
//                }
//                break;
//            case -831148323:
//                if (str.equals("default_original_earrings")) {
//                    eyeLinerTextures = 5;
//                    break;
//                }
//                break;
//            case -591677019:
//                if (str.equals("default_original_wig")) {
//                    eyeLinerTextures = 1;
//                    break;
//                }
//                break;
//            case -530387390:
//                if (str.equals("default_original_hair_band")) {
//                    eyeLinerTextures = 3;
//                    break;
//                }
//                break;
//            case 788465062:
//                if (str.equals("default_original_necklace")) {
//                    eyeLinerTextures = 4;
//                    break;
//                }
//                break;
//            case 1598992866:
//                if (str.equals("default_original_eye_contact")) {
//                    eyeLinerTextures = 0;
//                    break;
//                }
//                break;
//        }
//        switch (eyeLinerTextures) {
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
//            List inputTemplateTextureCoordinate = x.inputTemplateTextureCoordinate(beautyMode, SourceType.DEFAULT);
//            if (inputTemplateTextureCoordinate != null && inputTemplateTextureCoordinate.size() > 0) {
//                return x.A((String) inputTemplateTextureCoordinate.get(0));
//            }
//        }
//        return x.A(str);
//    }
}
