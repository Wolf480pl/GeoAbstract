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

import org.spout.math.GenericMath;
import org.spout.math.TrigMath;
import org.spout.math.imaginary.Quaternion;
import org.spout.math.vector.Vector3;

public class Point2D implements Point {
    private final Quaternion point;
    private final Space2D space;

    public Point2D(Space2D space, Quaternion point) {
        this.space = space;
        this.point = point;
    }

    @Override
    public Point add(Vector vector) {
        double radius = this.space.getRadius();
        double angleDist = vector.length() / radius;  // In radians.
        Quaternion target = this.point.mul(Quaternion.fromAngleDegAxis(vector.angle(), Vector3.FORWARD)).mul(Quaternion.fromAngleRadAxis(angleDist, Vector3.UP));
        return new Point2D(this.space, target.mul(Quaternion.fromAngleDegAxis(-vector.angle(), Vector3.FORWARD)));
    }

    @Override
    public Vector vectorTo(Point other) {
        if (!(other instanceof Point2D) || other.getSpace() != this.space) {
            throw new IllegalArgumentException("The point must be from the same space.");
        }
        Vector3 delta = deltaDir((Point2D) other);
        double angle = TrigMath.atan2(delta.getY(), delta.getX()); // In radians.
        double angleDist = TrigMath.acos(delta.getZ() / delta.length()); // In radians.
        return new Vector(angleDist * this.space.getRadius(), (float) (angle * TrigMath.RAD_TO_DEG));
    }

    @Override
    public double distanceTo(Point other) {
        if (!(other instanceof Point2D) || other.getSpace() != this.space) {
            throw new IllegalArgumentException("The point must be from the same space.");
        }
        Vector3 delta = deltaDir((Point2D) other);
        double angleDist = TrigMath.acos(delta.getZ() / delta.length()); // In radians.
        return angleDist * this.space.getRadius();
    }

    @Override
    public boolean sameAs(Point other) {
        if (!(other instanceof Point2D)) {
            return false;
        }
        Vector3 delta = this.point.getDirection().sub(((Point2D) other).point.getDirection()).abs();
        // TODO: are we sure about this?
        return delta.getX() < GenericMath.DBL_EPSILON && delta.getY() < GenericMath.DBL_EPSILON && delta.getZ() < GenericMath.DBL_EPSILON;
    }

    @Override
    public Space getSpace() {
        return this.space;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point2D)) {
            return false;
        }
        return this.point.equals(((Point2D) other).point);
    }

    private Vector3 deltaDir(Point2D other) {
        return this.point.invert().mul(other.point).getDirection();
    }
}
