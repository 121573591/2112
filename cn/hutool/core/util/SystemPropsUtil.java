/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.System
 *  java.util.Properties
 */
package cn.hutool.core.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Properties;

public class SystemPropsUtil {
    public static String HUTOOL_DATE_LENIENT = "hutool.date.lenient";

    public static String get(String name, String defaultValue) {
        return StrUtil.nullToDefault(SystemPropsUtil.get(name, false), defaultValue);
    }

    public static String get(String name, boolean quiet) {
        String value;
        block6: {
            block5: {
                value = null;
                try {
                    value = System.getProperty((String)name);
                }
                catch (SecurityException e) {
                    if (quiet) break block5;
                    Console.error("Caught a SecurityException reading the system property '{}'; the SystemUtil property value will default to null.", name);
                }
            }
            if (null == value) {
                try {
                    value = System.getenv((String)name);
                }
                catch (SecurityException e) {
                    if (quiet) break block6;
                    Console.error("Caught a SecurityException reading the system env '{}'; the SystemUtil env value will default to null.", name);
                }
            }
        }
        return value;
    }

    public static String get(String key) {
        return SystemPropsUtil.get(key, null);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = SystemPropsUtil.get(key);
        if (value == null) {
            return defaultValue;
        }
        return BooleanUtil.toBoolean(value);
    }

    public static int getInt(String key, int defaultValue) {
        return Convert.toInt(SystemPropsUtil.get(key), defaultValue);
    }

    public static long getLong(String key, long defaultValue) {
        return Convert.toLong(SystemPropsUtil.get(key), defaultValue);
    }

    public static Properties getProps() {
        return System.getProperties();
    }

    public static void set(String key, String value) {
        if (null == value) {
            System.clearProperty((String)key);
        } else {
            System.setProperty((String)key, (String)value);
        }
    }
}

