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

import com.github.wolf480pl.geoabstract.geo2d.Space;

import org.spout.math.imaginary.Quaternion;

public class Space2D implements Space {
    private final Quaternion realCenter;
    private final Point2D center;
    private final double radius;

    public Space2D(double radius) {
        this.radius = radius;
        this.realCenter = new Quaternion();
        this.center = new Point2D(this, this.realCenter);
    }

    @Override
    public Point2D getCenter() {
        return this.center;
    }

    public double getRadius() {
        return this.radius;
    }

}
