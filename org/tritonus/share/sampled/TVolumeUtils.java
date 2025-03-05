/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package org.tritonus.share.sampled;

public class TVolumeUtils {
    private static final double FACTOR1 = 20.0 / Math.log((double)10.0);
    private static final double FACTOR2 = 0.05;

    public static double lin2log(double dLinear) {
        return FACTOR1 * Math.log((double)dLinear);
    }

    public static double log2lin(double dLogarithmic) {
        return Math.pow((double)10.0, (double)(dLogarithmic * 0.05));
    }
}

