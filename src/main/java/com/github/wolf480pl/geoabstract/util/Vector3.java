package com.github.wolf480pl.geoabstract.util;

public class Vector3 {
    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    protected final float x, y, z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(double x, double y, double z) {
        this((float) x, (float) y, (float) z);
    }

    public Vector3(Vector3 vec) {
        this(vec.x, vec.y, vec.z);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }

    public Vector3 add(float x, float y, float z) {
        return new Vector3(this.x + x, this.y + y, this.z + z);
    }

    public Vector3 add(double x, double y, double z) {
        return add((float) x, (float) y, (float) z);
    }

    public Vector3 add(Vector3 vec) {
        return add(vec.x, vec.y, vec.z);
    }

    public Vector3 subtract(float x, float y, float z) {
        return add(-x, -y, -z);
    }

    public Vector3 subtract(double x, double y, double z) {
        return add(-x, -y, -z);
    }

    public Vector3 subtract(Vector3 vec) {
        return add(vec.multiply(-1.));
    }

    public Vector3 multiply(double val) {
        return new Vector3(this.x * val, this.y * val, this.z * val);
    }

    public Vector3 multiply(float val) {
        return multiply((double) val);
    }

    public Vector3 divide(double val) {
        return new Vector3(this.x / val, this.y / val, this.z / val);
    }

    public Vector3 divide(float val) {
        return divide((double) val);
    }

}
