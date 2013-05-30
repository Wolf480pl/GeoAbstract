package com.github.wolf480pl.geoabstract.geo2d;

public class Vector {
    private final double length;
    private final float angle;

    public Vector(double length, float angle) {
        this.length = length;
        this.angle = angle;
    }

    public double length() {
        return this.length;
    }

    public float angle() {
        return this.angle;
    }

}
