package com.github.wolf480pl.geoabstract.spaces.sphere2d;

import com.github.wolf480pl.geoabstract.util.AngleUtil;

public class RealPoint {
    private final Space2D space;
    private final float longitude, latitude;

    public RealPoint(Space2D space) {
        this(space, 0f, 0f);
    }

    public RealPoint(Space2D space, float longitude, float latitude) {
        this.space = space;
        float la = AngleUtil.normalize(latitude);
        if (Math.abs(la) > 90) {
            this.latitude = AngleUtil.normalize(180 - la);
            this.longitude = AngleUtil.normalize(longitude + 180);
        } else {
            this.longitude = AngleUtil.normalize(longitude);
            this.latitude = la;
        }
    }

    public Space2D getSpace() {
        return this.space;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public RealPoint add(float longitude, float latitude) {
        return new RealPoint(this.space, this.longitude + longitude, this.latitude + latitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RealPoint)) {
            return false;
        }
        return ((RealPoint) obj).latitude == this.latitude && ((RealPoint) obj).longitude == this.longitude;
    }

}
