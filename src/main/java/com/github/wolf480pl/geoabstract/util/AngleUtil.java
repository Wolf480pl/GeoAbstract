package com.github.wolf480pl.geoabstract.util;

public class AngleUtil {

    public static float normalize(float angle) {
        return (angle + 180) % 360 - 180;
    }

    private AngleUtil() {
    }

}
