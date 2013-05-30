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
