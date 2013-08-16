package com.github.wolf480pl.geoabstract;

import org.junit.Assert;

import org.spout.math.GenericMath;

public class MathTestUtil {

    public static void assertEquals(float actual, float expected) {
        if (Math.abs(expected) < 1) {
            Assert.assertEquals(expected, actual, GenericMath.FLT_EPSILON);
        } else {
            Assert.assertEquals(expected, actual, GenericMath.FLT_EPSILON * expected);
        }
    }
}
