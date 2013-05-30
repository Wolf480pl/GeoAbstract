package com.github.wolf480pl.geoabstract.spaces.sphere2d;

import com.github.wolf480pl.geoabstract.util.Vector3;

public class RealPoint extends Vector3 {
    private final Space2D space;

    public RealPoint(Space2D space, Vector3 vector) {
        super(vector);
        this.space = space;
    }

    public Space2D getSpace() {
        return this.space;
    }

    @Override
    public RealPoint add(Vector3 vec) {
        return new RealPoint(this.space, super.add(vec));
    }

    @Override
    public RealPoint add(double x, double y, double z) {
        return new RealPoint(this.space, super.add(x, y, z));
    }

    @Override
    public RealPoint add(float x, float y, float z) {
        return new RealPoint(this.space, super.add(x, y, z));
    }

    @Override
    public RealPoint subtract(Vector3 vec) {
        return new RealPoint(this.space, super.subtract(vec));
    }

    @Override
    public RealPoint subtract(double x, double y, double z) {
        return new RealPoint(this.space, super.subtract(x, y, z));
    }

    @Override
    public RealPoint subtract(float x, float y, float z) {
        return new RealPoint(this.space, super.subtract(x, y, z));
    }

    @Override
    public RealPoint multiply(double val) {
        return new RealPoint(this.space, super.multiply(val));
    }

    @Override
    public RealPoint multiply(float val) {
        return new RealPoint(this.space, super.multiply(val));
    }

    @Override
    public RealPoint divide(double val) {
        return new RealPoint(this.space, super.divide(val));
    }

    @Override
    public RealPoint divide(float val) {
        return new RealPoint(this.space, super.divide(val));
    }

}
