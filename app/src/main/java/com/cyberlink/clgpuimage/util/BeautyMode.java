package com.cyberlink.clgpuimage.util;

public enum BeautyMode {
    BLUSH {
        public String a() {
            return "Blush";
        }

        public boolean b() {
            return true;
        }
    },
    SKIN_TONER {
        public String a() {
            return "Skin Toner";
        }

        public boolean b() {
            return true;
        }
    },
    SHINE_REMOVAL {
        public String a() {
            return "Shine Removal";
        }

        public boolean b() {
            return false;
        }
    },
    SKIN_SMOOTHER {
        public String a() {
            return "Skin Smoother";
        }

        public boolean b() {
            return false;
        }
    },
    BLEMISH_REMOVAL {
        public String a() {
            return "Blemish";
        }

        public boolean b() {
            return false;
        }
    },
    CONTOUR_NOSE {
        public String a() {
            return "Contour-Nose";
        }

        public boolean b() {
            return false;
        }
    },
    CONTOUR_FACE {
        public String a() {
            return "Contour-Face";
        }

        public boolean b() {
            return false;
        }
    },
    FACE_RESHAPER {
        public String a() {
            return "Face Shaper";
        }

        public boolean b() {
            return false;
        }
    },
    FACE_RESHAPER_MANUAL {
        public String a() {
            return "Face Shaper Manual";
        }

        public boolean b() {
            return false;
        }
    },
    FACE_ART {
        public String a() {
            return "Face Art";
        }

        public boolean b() {
            return true;
        }
    },
    MUSTACHE {
        public String a() {
            return "Mustache";
        }

        public boolean b() {
            return true;
        }
    },
    EYE_LINES {
        public String a() {
            return "Eye Line";
        }

        public boolean b() {
            return true;
        }
    },
    EYE_LASHES {
        public String a() {
            return "Eye Lash";
        }

        public boolean b() {
            return true;
        }
    },
    EYE_SHADOW {
        public String a() {
            return "Eye Shadow";
        }

        public boolean b() {
            return true;
        }
    },
    EYE_ENLARGER {
        public String a() {
            return "Enlarge Eye";
        }

        public boolean b() {
            return false;
        }
    },
    EYE_BAG_REMOVAL {
        public String a() {
            return "Eye Bag";
        }

        public boolean b() {
            return false;
        }
    },
    RED_EYE_REMOVAL {
        public String a() {
            return "Red Eye";
        }

        public boolean b() {
            return false;
        }
    },
    EYE_BROW {
        public String a() {
            return "Eye Brow";
        }

        public boolean b() {
            return true;
        }
    },
    EYE_CONTACT {
        public String a() {
            return "Eye Contact";
        }

        public boolean b() {
            return true;
        }
    },
    DOUBLE_EYELID {
        public String a() {
            return "Double Eyelid";
        }

        public boolean b() {
            return true;
        }
    },
    EYE_SPARKLE {
        public String a() {
            return "Eye Sparkle";
        }

        public boolean b() {
            return false;
        }
    },
    LIP_STICK {
        public String a() {
            return "Lip Stick";
        }

        public boolean b() {
            return true;
        }
    },
    TEETH_WHITENER {
        public String a() {
            return "Tooth Brush";
        }

        public boolean b() {
            return false;
        }
    },
    WIG {
        public String a() {
            return "Hair";
        }

        public boolean b() {
            return true;
        }
    },
    HAIR_DYE {
        public String a() {
            return "Hair Dye";
        }

        public boolean b() {
            return false;
        }
    },
    EYE_WEAR {
        public String a() {
            return "Eyewear";
        }

        public boolean b() {
            return false;
        }
    },
    HAIR_BAND {
        public String a() {
            return "Head band";
        }

        public boolean b() {
            return false;
        }
    },
    NECKLACE {
        public String a() {
            return "Necklace";
        }

        public boolean b() {
            return false;
        }
    },
    EARRINGS {
        public String a() {
            return "Earrings";
        }

        public boolean b() {
            return false;
        }
    },
    UNDEFINED {
        public String a() {
            return "Undefined";
        }

        public boolean b() {
            return false;
        }
    };

    public abstract String a();

    public abstract boolean b();

    public static boolean a(BeautyMode beautyMode) {
        switch (beautyMode) {
            case CONTOUR_FACE:
            case CONTOUR_NOSE:
            case EYE_BAG_REMOVAL:
            case EYE_ENLARGER:
            case FACE_RESHAPER:
            case SKIN_SMOOTHER:
            case SHINE_REMOVAL:
            case TEETH_WHITENER:
            case EYE_SPARKLE:
                return true;
            default:
                return false;
        }
    }

    public static boolean b(BeautyMode beautyMode) {
        switch (beautyMode) {
            case BLEMISH_REMOVAL:
            case RED_EYE_REMOVAL:
                return true;
            default:
                return false;
        }
    }

    public static MakeupMode c(BeautyMode beautyMode) {
        switch (beautyMode) {
            case CONTOUR_FACE:
            case CONTOUR_NOSE:
            case FACE_RESHAPER:
            case SKIN_SMOOTHER:
            case SHINE_REMOVAL:
            case BLEMISH_REMOVAL:
            case BLUSH:
            case SKIN_TONER:
            case FACE_ART:
            case MUSTACHE:
                return MakeupMode.FACE;
            case EYE_BAG_REMOVAL:
            case EYE_ENLARGER:
            case EYE_SPARKLE:
            case RED_EYE_REMOVAL:
            case EYE_LINES:
            case EYE_LASHES:
            case EYE_SHADOW:
            case EYE_BROW:
            case EYE_CONTACT:
            case DOUBLE_EYELID:
                return MakeupMode.EYE;
            case TEETH_WHITENER:
            case LIP_STICK:
                return MakeupMode.MOUTH;
            case WIG:
            case HAIR_DYE:
                return MakeupMode.WIG;
            case EYE_WEAR:
            case HAIR_BAND:
            case NECKLACE:
            case EARRINGS:
                return MakeupMode.ACCESSORY;
            default:
                return MakeupMode.UNDEFINED;
        }
    }

    public static boolean d(BeautyMode beautyMode) {
        return c(beautyMode) == MakeupMode.ACCESSORY;
    }

    public static boolean e(BeautyMode beautyMode) {
        return c(beautyMode) == MakeupMode.FACE;
    }

    public static boolean f(BeautyMode beautyMode) {
        return c(beautyMode) == MakeupMode.EYE;
    }

    public static boolean g(BeautyMode beautyMode) {
        return c(beautyMode) == MakeupMode.MOUTH;
    }

    public static boolean h(BeautyMode beautyMode) {
        return c(beautyMode) == MakeupMode.WIG;
    }
}
