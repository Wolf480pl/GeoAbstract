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

import com.github.wolf480pl.geoabstract.util.AngleUtil;

public class RealPoint {
    private final float longitude, latitude;

    public RealPoint() {
        this(0f, 0f);
    }

    public RealPoint(float longitude, float latitude) {
        float la = AngleUtil.normalize(latitude);
        if (Math.abs(la) > 90) {
            this.latitude = AngleUtil.normalize(180 - la);
            this.longitude = AngleUtil.normalize(longitude + 180);
        } else {
            this.longitude = AngleUtil.normalize(longitude);
            this.latitude = la;
        }
    }

    public float getLongitude() {
        return this.longitude;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public RealPoint add(float longitude, float latitude) {
        return new RealPoint(this.longitude + longitude, this.latitude + latitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RealPoint)) {
            return false;
        }
        return ((RealPoint) obj).latitude == this.latitude && ((RealPoint) obj).longitude == this.longitude;
    }

}
