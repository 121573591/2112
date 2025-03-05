/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package cn.hutool.core.math;

public class BitStatusUtil {
    public static int add(int states, int stat) {
        BitStatusUtil.check(states, stat);
        return states | stat;
    }

    public static boolean has(int states, int stat) {
        BitStatusUtil.check(states, stat);
        return (states & stat) == stat;
    }

    public static int remove(int states, int stat) {
        BitStatusUtil.check(states, stat);
        if (BitStatusUtil.has(states, stat)) {
            return states ^ stat;
        }
        return states;
    }

    public static int clear() {
        return 0;
    }

    private static void check(int ... args) {
        for (int arg : args) {
            if (arg < 0) {
                throw new IllegalArgumentException(arg + " 必须大于等于0");
            }
            if ((arg & 1) != 1) continue;
            throw new IllegalArgumentException(arg + " 不是偶数");
        }
    }
}

