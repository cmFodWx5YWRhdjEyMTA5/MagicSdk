package com.cyberlink.clgpuimage.util;

public enum MakeupMode {
    LOOKS {
        public String a() {
            return "Looks";
        }
    },
    WIG {
        public String a() {
            return "Hair";
        }
    },
    FACE {
        public String a() {
            return "Face";
        }
    },
    EYE {
        public String a() {
            return "Eye";
        }
    },
    MOUTH {
        public String a() {
            return "Mouth";
        }
    },
    ACCESSORY {
        public String a() {
            return "Accessories";
        }
    },
    UNDEFINED {
        public String a() {
            return "";
        }
    };

    public abstract String a();
}
