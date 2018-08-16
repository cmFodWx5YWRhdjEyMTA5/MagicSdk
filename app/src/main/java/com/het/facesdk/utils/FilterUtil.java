package com.het.facesdk.utils;

public class FilterUtil {


    public static float range(final int percentage, final float start, final float end) {
        return (end - start) * percentage / 100.0f + start;
    }

    public static int range(final int percentage, final int start, final int end) {
        return (end - start) * percentage / 100 + start;
    }
}
