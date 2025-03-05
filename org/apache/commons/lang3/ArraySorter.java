/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.Comparator
 */
package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySorter {
    public static byte[] sort(byte[] array) {
        Arrays.sort((byte[])array);
        return array;
    }

    public static char[] sort(char[] array) {
        Arrays.sort((char[])array);
        return array;
    }

    public static double[] sort(double[] array) {
        Arrays.sort((double[])array);
        return array;
    }

    public static float[] sort(float[] array) {
        Arrays.sort((float[])array);
        return array;
    }

    public static int[] sort(int[] array) {
        Arrays.sort((int[])array);
        return array;
    }

    public static long[] sort(long[] array) {
        Arrays.sort((long[])array);
        return array;
    }

    public static short[] sort(short[] array) {
        Arrays.sort((short[])array);
        return array;
    }

    public static <T> T[] sort(T[] array) {
        Arrays.sort((Object[])array);
        return array;
    }

    public static <T> T[] sort(T[] array, Comparator<? super T> comparator) {
        Arrays.sort((Object[])array, comparator);
        return array;
    }
}

