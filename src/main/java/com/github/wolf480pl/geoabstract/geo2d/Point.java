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
package com.github.wolf480pl.geoabstract.geo2d;

public interface Point {

    Point add(Vector vector);

    Vector vectorTo(Point other);

    double distanceTo(Point other);

    /**
     * Checks if the {@code other} Point object represents the same point in the subordinate space as this object.
     * 
     * @param other the Point object to compare
     * @return {@code true} if they represent the same point, {@code false} if otherwise
     */
    boolean sameAs(Point other);

    /**
     * Checks if the {@code other} object is a Point representing the same point in the subordinate space for the same observer.
     * 
     */
    boolean equals(Object other);

    Space getSpace();
}
