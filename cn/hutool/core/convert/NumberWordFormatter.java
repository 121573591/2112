/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package cn.hutool.core.convert;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

public class NumberWordFormatter {
    private static final String[] NUMBER = new String[]{"", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    private static final String[] NUMBER_TEEN = new String[]{"TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    private static final String[] NUMBER_TEN = new String[]{"TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
    private static final String[] NUMBER_MORE = new String[]{"", "THOUSAND", "MILLION", "BILLION", "TRILLION"};
    private static final String[] NUMBER_SUFFIX = new String[]{"k", "w", "", "m", "", "", "b", "", "", "t", "", "", "p", "", "", "e"};

    public static String format(Object x) {
        if (x != null) {
            return NumberWordFormatter.format(x.toString());
        }
        return "";
    }

    public static String formatSimple(long value) {
        return NumberWordFormatter.formatSimple(value, true);
    }

    public static String formatSimple(long value, boolean isTwo) {
        if (value < 1000L) {
            return String.valueOf((long)value);
        }
        int index = -1;
        double res = value;
        while (res > 10.0 && (!isTwo || index < 1)) {
            if (res >= 1000.0) {
                res /= 1000.0;
                ++index;
            }
            if (!(res > 10.0)) continue;
            res /= 10.0;
            ++index;
        }
        return String.format((String)"%s%s", (Object[])new Object[]{NumberUtil.decimalFormat("#.##", res), NUMBER_SUFFIX[index]});
    }

    private static String format(String x) {
        String lstr;
        int z = x.indexOf(".");
        String rstr = "";
        if (z > -1) {
            lstr = x.substring(0, z);
            rstr = x.substring(z + 1);
        } else {
            lstr = x;
        }
        String lstrrev = StrUtil.reverse(lstr);
        String[] a = new String[5];
        switch (lstrrev.length() % 3) {
            case 1: {
                lstrrev = lstrrev + "00";
                break;
            }
            case 2: {
                lstrrev = lstrrev + "0";
            }
        }
        StringBuilder lm = new StringBuilder();
        for (int i = 0; i < lstrrev.length() / 3; ++i) {
            a[i] = StrUtil.reverse(lstrrev.substring(3 * i, 3 * i + 3));
            if (!"000".equals((Object)a[i])) {
                if (i != 0) {
                    lm.insert(0, NumberWordFormatter.transThree(a[i]) + " " + NumberWordFormatter.parseMore(i) + " ");
                    continue;
                }
                lm = new StringBuilder(NumberWordFormatter.transThree(a[i]));
                continue;
            }
            lm.append(NumberWordFormatter.transThree(a[i]));
        }
        String xs = "";
        if (z > -1) {
            xs = "AND CENTS " + NumberWordFormatter.transTwo(rstr) + " ";
        }
        return lm.toString().trim() + " " + xs + "ONLY";
    }

    private static String parseFirst(String s) {
        return NUMBER[Integer.parseInt((String)s.substring(s.length() - 1))];
    }

    private static String parseTeen(String s) {
        return NUMBER_TEEN[Integer.parseInt((String)s) - 10];
    }

    private static String parseTen(String s) {
        return NUMBER_TEN[Integer.parseInt((String)s.substring(0, 1)) - 1];
    }

    private static String parseMore(int i) {
        return NUMBER_MORE[i];
    }

    private static String transTwo(String s) {
        if (s.length() > 2) {
            s = s.substring(0, 2);
        } else if (s.length() < 2) {
            s = "0" + s;
        }
        String value = s.startsWith("0") ? NumberWordFormatter.parseFirst(s) : (s.startsWith("1") ? NumberWordFormatter.parseTeen(s) : (s.endsWith("0") ? NumberWordFormatter.parseTen(s) : NumberWordFormatter.parseTen(s) + " " + NumberWordFormatter.parseFirst(s)));
        return value;
    }

    private static String transThree(String s) {
        String value = s.startsWith("0") ? NumberWordFormatter.transTwo(s.substring(1)) : ("00".equals((Object)s.substring(1)) ? NumberWordFormatter.parseFirst(s.substring(0, 1)) + " HUNDRED" : NumberWordFormatter.parseFirst(s.substring(0, 1)) + " HUNDRED AND " + NumberWordFormatter.transTwo(s.substring(1)));
        return value;
    }
}

