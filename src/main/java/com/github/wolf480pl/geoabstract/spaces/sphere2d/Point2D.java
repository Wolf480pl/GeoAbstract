/*
 * This file is part of GeoAbstract.
 *
 * Copyright (c) 2013 Wolf480pl <wolf480@interia.pl>
 * GeoAbstract is licensed under the GNU Lesser General Public License.
 *
 * GeoAbstract is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GeoAbstract is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.wolf480pl.geoabstract.spaces.sphere2d;

import com.github.wolf480pl.geoabstract.geo2d.Point;
import com.github.wolf480pl.geoabstract.geo2d.Space;
import com.github.wolf480pl.geoabstract.geo2d.Vector;
import com.github.wolf480pl.geoabstract.util.math.Quaternion;
import com.github.wolf480pl.geoabstract.util.math.QuaternionMath;
import com.github.wolf480pl.geoabstract.util.math.Vector3;

public class Point2D implements Point {
    private final RealPoint point;
    private final float baseAngle;

    public Point2D(RealPoint point, float baseAngle) {
        this.point = point;
        this.baseAngle = baseAngle;
    }

    @Override
    public Point add(Vector vector) {
        float radius = this.point.getSpace().getRadius();
        double angleDist = vector.length() / radius;  // In radians.
        Quaternion target = QuaternionMath.rotation(this.point.getLatitude(), this.point.getLongitude(), this.baseAngle + vector.angle()).multiply(new Quaternion(false, angleDist, Vector3.UP));
        return new Point2D(new RealPoint(this.point.getSpace(), target.getYaw(), target.getPitch()), target.getRoll() - vector.angle());
    }

    @Override
    public Vector vectorTo(Point other) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double distanceTo(Point other) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean sameAs(Point other) {
        if (!(other instanceof Point2D)) {
            return false;
        }
        return this.point.equals(((Point2D) other).point);
    }

    @Override
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
