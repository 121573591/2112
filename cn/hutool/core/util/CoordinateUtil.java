/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package cn.hutool.core.util;

import java.io.Serializable;
import java.util.Objects;

public class CoordinateUtil {
    public static final double X_PI = 52.35987755982988;
    public static final double PI = Math.PI;
    public static final double RADIUS = 6378245.0;
    public static final double CORRECTION_PARAM = 0.006693421622965943;

    public static boolean outOfChina(double lng, double lat) {
        return lng < 72.004 || lng > 137.8347 || lat < 0.8293 || lat > 55.8271;
    }

    public static Coordinate wgs84ToGcj02(double lng, double lat) {
        return new Coordinate(lng, lat).offset(CoordinateUtil.offset(lng, lat, true));
    }

    public static Coordinate wgs84ToBd09(double lng, double lat) {
        Coordinate gcj02 = CoordinateUtil.wgs84ToGcj02(lng, lat);
        return CoordinateUtil.gcj02ToBd09(gcj02.lng, gcj02.lat);
    }

    public static Coordinate gcj02ToWgs84(double lng, double lat) {
        return new Coordinate(lng, lat).offset(CoordinateUtil.offset(lng, lat, false));
    }

    public static Coordinate gcj02ToBd09(double lng, double lat) {
        double z = Math.sqrt((double)(lng * lng + lat * lat)) + 2.0E-5 * Math.sin((double)(lat * 52.35987755982988));
        double theta = Math.atan2((double)lat, (double)lng) + 3.0E-6 * Math.cos((double)(lng * 52.35987755982988));
        double bd_lng = z * Math.cos((double)theta) + 0.0065;
        double bd_lat = z * Math.sin((double)theta) + 0.006;
        return new Coordinate(bd_lng, bd_lat);
    }

    public static Coordinate bd09ToGcj02(double lng, double lat) {
        double x = lng - 0.0065;
        double y = lat - 0.006;
        double z = Math.sqrt((double)(x * x + y * y)) - 2.0E-5 * Math.sin((double)(y * 52.35987755982988));
        double theta = Math.atan2((double)y, (double)x) - 3.0E-6 * Math.cos((double)(x * 52.35987755982988));
        double gg_lng = z * Math.cos((double)theta);
        double gg_lat = z * Math.sin((double)theta);
        return new Coordinate(gg_lng, gg_lat);
    }

    public static Coordinate bd09toWgs84(double lng, double lat) {
        Coordinate gcj02 = CoordinateUtil.bd09ToGcj02(lng, lat);
        return CoordinateUtil.gcj02ToWgs84(gcj02.lng, gcj02.lat);
    }

    public static Coordinate wgs84ToMercator(double lng, double lat) {
        double x = lng * 2.0037508342789244E7 / 180.0;
        double y = Math.log((double)Math.tan((double)((90.0 + lat) * Math.PI / 360.0))) / (Math.PI / 180);
        y = y * 2.0037508342789244E7 / 180.0;
        return new Coordinate(x, y);
    }

    public static Coordinate mercatorToWgs84(double mercatorX, double mercatorY) {
        double x = mercatorX / 2.0037508342789244E7 * 180.0;
        double y = mercatorY / 2.0037508342789244E7 * 180.0;
        y = 57.29577951308232 * (2.0 * Math.atan((double)Math.exp((double)(y * Math.PI / 180.0))) - 1.5707963267948966);
        return new Coordinate(x, y);
    }

    private static Coordinate offset(double lng, double lat, boolean isPlus) {
        double dlng = CoordinateUtil.transLng(lng - 105.0, lat - 35.0);
        double dlat = CoordinateUtil.transLat(lng - 105.0, lat - 35.0);
        double magic = Math.sin((double)(lat / 180.0 * Math.PI));
        magic = 1.0 - 0.006693421622965943 * magic * magic;
        double sqrtMagic = Math.sqrt((double)magic);
        dlng = dlng * 180.0 / (6378245.0 / sqrtMagic * Math.cos((double)(lat / 180.0 * Math.PI)) * Math.PI);
        dlat = dlat * 180.0 / (6335552.717000426 / (magic * sqrtMagic) * Math.PI);
        if (!isPlus) {
            dlng = -dlng;
            dlat = -dlat;
        }
        return new Coordinate(dlng, dlat);
    }

    private static double transLng(double lng, double lat) {
        double ret = 300.0 + lng + 2.0 * lat + 0.1 * lng * lng + 0.1 * lng * lat + 0.1 * Math.sqrt((double)Math.abs((double)lng));
        ret += (20.0 * Math.sin((double)(6.0 * lng * Math.PI)) + 20.0 * Math.sin((double)(2.0 * lng * Math.PI))) * 2.0 / 3.0;
        ret += (20.0 * Math.sin((double)(lng * Math.PI)) + 40.0 * Math.sin((double)(lng / 3.0 * Math.PI))) * 2.0 / 3.0;
        return ret += (150.0 * Math.sin((double)(lng / 12.0 * Math.PI)) + 300.0 * Math.sin((double)(lng / 30.0 * Math.PI))) * 2.0 / 3.0;
    }

    private static double transLat(double lng, double lat) {
        double ret = -100.0 + 2.0 * lng + 3.0 * lat + 0.2 * lat * lat + 0.1 * lng * lat + 0.2 * Math.sqrt((double)Math.abs((double)lng));
        ret += (20.0 * Math.sin((double)(6.0 * lng * Math.PI)) + 20.0 * Math.sin((double)(2.0 * lng * Math.PI))) * 2.0 / 3.0;
        ret += (20.0 * Math.sin((double)(lat * Math.PI)) + 40.0 * Math.sin((double)(lat / 3.0 * Math.PI))) * 2.0 / 3.0;
        return ret += (160.0 * Math.sin((double)(lat / 12.0 * Math.PI)) + 320.0 * Math.sin((double)(lat * Math.PI / 30.0))) * 2.0 / 3.0;
    }

    public static class Coordinate
    implements Serializable {
        private static final long serialVersionUID = 1L;
        private double lng;
        private double lat;

        public Coordinate(double lng, double lat) {
            this.lng = lng;
            this.lat = lat;
        }

        public double getLng() {
            return this.lng;
        }

        public Coordinate setLng(double lng) {
            this.lng = lng;
            return this;
        }

        public double getLat() {
            return this.lat;
        }

        public Coordinate setLat(double lat) {
            this.lat = lat;
            return this;
        }

        public Coordinate offset(Coordinate offset) {
            this.lng += offset.lng;
            this.lat += offset.lat;
            return this;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate)o;
            return Double.compare((double)that.lng, (double)this.lng) == 0 && Double.compare((double)that.lat, (double)this.lat) == 0;
        }

        public int hashCode() {
            return Objects.hash((Object[])new Object[]{this.lng, this.lat});
        }

        public String toString() {
            return "Coordinate{lng=" + this.lng + ", lat=" + this.lat + '}';
        }
    }
}

