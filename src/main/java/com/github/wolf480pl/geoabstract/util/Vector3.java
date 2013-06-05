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
