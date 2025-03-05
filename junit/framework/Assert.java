/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 */
package junit.framework;

import junit.framework.AssertionFailedError;
import junit.framework.ComparisonFailure;

public class Assert {
    protected Assert() {
    }

    public static void assertTrue(String message, boolean condition) {
        if (!condition) {
            Assert.fail(message);
        }
    }

    public static void assertTrue(boolean condition) {
        Assert.assertTrue(null, condition);
    }

    public static void assertFalse(String message, boolean condition) {
        Assert.assertTrue(message, !condition);
    }

    public static void assertFalse(boolean condition) {
        Assert.assertFalse(null, condition);
    }

    public static void fail(String message) {
        throw new AssertionFailedError(message);
    }

    public static void fail() {
        Assert.fail(null);
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected != null && expected.equals(actual)) {
            return;
        }
        Assert.failNotEquals(message, expected, actual);
    }

    public static void assertEquals(Object expected, Object actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, String expected, String actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected != null && expected.equals((Object)actual)) {
            return;
        }
        throw new ComparisonFailure(message, expected, actual);
    }

    public static void assertEquals(String expected, String actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, double expected, double actual, double delta) {
        if (Double.compare((double)expected, (double)actual) == 0) {
            return;
        }
        if (!(Math.abs((double)(expected - actual)) <= delta)) {
            Assert.failNotEquals(message, new Double(expected), new Double(actual));
        }
    }

    public static void assertEquals(double expected, double actual, double delta) {
        Assert.assertEquals(null, expected, actual, delta);
    }

    public static void assertEquals(String message, float expected, float actual, float delta) {
        if (Float.isInfinite((float)expected)) {
            if (expected != actual) {
                Assert.failNotEquals(message, new Float(expected), new Float(actual));
            }
        } else if (!(Math.abs((float)(expected - actual)) <= delta)) {
            Assert.failNotEquals(message, new Float(expected), new Float(actual));
        }
    }

    public static void assertEquals(float expected, float actual, float delta) {
        Assert.assertEquals(null, expected, actual, delta);
    }

    public static void assertEquals(String message, long expected, long actual) {
        Assert.assertEquals(message, new Long(expected), new Long(actual));
    }

    public static void assertEquals(long expected, long actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, boolean expected, boolean actual) {
        Assert.assertEquals(message, (Object)expected, (Object)actual);
    }

    public static void assertEquals(boolean expected, boolean actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, byte expected, byte actual) {
        Assert.assertEquals(message, new Byte(expected), new Byte(actual));
    }

    public static void assertEquals(byte expected, byte actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, char expected, char actual) {
        Assert.assertEquals(message, new Character(expected), new Character(actual));
    }

    public static void assertEquals(char expected, char actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, short expected, short actual) {
        Assert.assertEquals(message, new Short(expected), new Short(actual));
    }

    public static void assertEquals(short expected, short actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertEquals(String message, int expected, int actual) {
        Assert.assertEquals(message, new Integer(expected), new Integer(actual));
    }

    public static void assertEquals(int expected, int actual) {
        Assert.assertEquals(null, expected, actual);
    }

    public static void assertNotNull(Object object) {
        Assert.assertNotNull(null, object);
    }

    public static void assertNotNull(String message, Object object) {
        Assert.assertTrue(message, object != null);
    }

    public static void assertNull(Object object) {
        Assert.assertNull(null, object);
    }

    public static void assertNull(String message, Object object) {
        Assert.assertTrue(message, object == null);
    }

    public static void assertSame(String message, Object expected, Object actual) {
        if (expected == actual) {
            return;
        }
        Assert.failNotSame(message, expected, actual);
    }

    public static void assertSame(Object expected, Object actual) {
        Assert.assertSame(null, expected, actual);
    }

    public static void assertNotSame(String message, Object expected, Object actual) {
        if (expected == actual) {
            Assert.failSame(message);
        }
    }

    public static void assertNotSame(Object expected, Object actual) {
        Assert.assertNotSame(null, expected, actual);
    }

    public static void failSame(String message) {
        String formatted = "";
        if (message != null) {
            formatted = message + " ";
        }
        Assert.fail(formatted + "expected not same");
    }

    public static void failNotSame(String message, Object expected, Object actual) {
        String formatted = "";
        if (message != null) {
            formatted = message + " ";
        }
        Assert.fail(formatted + "expected same:<" + expected + "> was not:<" + actual + ">");
    }

    public static void failNotEquals(String message, Object expected, Object actual) {
        Assert.fail(Assert.format(message, expected, actual));
    }

    static String format(String message, Object expected, Object actual) {
        String formatted = "";
        if (message != null) {
            formatted = message + " ";
        }
        return formatted + "expected:<" + expected + "> but was:<" + actual + ">";
    }
}

