package com.github.wolf480pl.geoabstract.geo2d;

import org.junit.Test;

import com.github.wolf480pl.geoabstract.MathTestUtil;

public class TestVector {

    @Test
    public void testVector() {
        float dist = 12368.86f;
        float angle = 137.712f;
        Vector v = new Vector(dist, angle);
        MathTestUtil.assertEquals(v.length(), dist);
        MathTestUtil.assertEquals(v.angle(), angle);
    }

    @Test
    public void testDoubleOverload() {
        double dist = 12368.86;
        double angle = 137.712;
        Vector v = new Vector(dist, angle);
        MathTestUtil.assertEquals(v.length(), (float) dist);
        MathTestUtil.assertEquals(v.angle(), (float) angle);
    }

}
