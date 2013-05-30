package com.github.wolf480pl.geoabstract.spaces.sphere2d;

import com.github.wolf480pl.geoabstract.geo2d.Point;
import com.github.wolf480pl.geoabstract.geo2d.Space;
import com.github.wolf480pl.geoabstract.geo2d.Vector;

public class Point2D implements Point {
    private final RealPoint point;
    private final float baseAngle;

    public Point2D(RealPoint point, float baseAngle) {
        this.point = point;
        this.baseAngle = baseAngle;
    }

    public Point add(Vector vector) {
        return null;
    }

    public Vector vectorTo(Point other) {
        // TODO Auto-generated method stub
        return null;
    }

    public double distanceTo(Point other) {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean sameAs(Point other) {
        if (!(other instanceof Point2D)) {
            return false;
        }
        return this.point.equals(((Point2D) other).point);
    }

    public Space getSpace() {
        return this.point.getSpace();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point2D)) {
            return false;
        }
        return sameAs((Point) other) && this.baseAngle == ((Point2D) other).baseAngle;
    }
}
