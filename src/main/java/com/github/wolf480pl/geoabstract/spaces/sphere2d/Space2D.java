package com.github.wolf480pl.geoabstract.spaces.sphere2d;

import com.github.wolf480pl.geoabstract.geo2d.Space;

public class Space2D implements Space {
    private final RealPoint sphereCenter, surfaceCenter;
    private final Point2D center;
    private final float radius;

    public Space2D(float radius) {
        this.radius = radius;
        this.sphereCenter = null;
        this.surfaceCenter = null;
        this.center = new Point2D(this.surfaceCenter, 0);
    }

    public Point2D getCenter() {
        return this.center;
    }

    public RealPoint getRealCenter() {
        return this.sphereCenter;
    }

    public float getRadius() {
        return this.radius;
    }

}
