/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
package cn.hutool.core.util;

import cn.hutool.core.util.StrUtil;

public class JdkUtil {
    public static final int JVM_VERSION = JdkUtil._getJvmVersion();
    public static final boolean IS_JDK8 = 8 == JVM_VERSION;
    public static final boolean IS_AT_LEAST_JDK17 = JVM_VERSION >= 17;
    public static final boolean IS_ANDROID;

    private static String _getJvmName() {
        return System.getProperty((String)"java.vm.name");
    }

    private static int _getJvmVersion() {
        int jvmVersion = -1;
        try {
            String javaSpecVer = System.getProperty((String)"java.specification.version");
            if (StrUtil.isNotBlank(javaSpecVer)) {
                if (javaSpecVer.startsWith("1.")) {
                    javaSpecVer = javaSpecVer.substring(2);
                }
                if (javaSpecVer.indexOf(46) == -1) {
                    jvmVersion = Integer.parseInt((String)javaSpecVer);
                }
            }
        }
        catch (Throwable ignore) {
            jvmVersion = 8;
        }
        return jvmVersion;
    }

    static {
        String jvmName = JdkUtil._getJvmName();
        IS_ANDROID = jvmName.equals((Object)"Dalvik");
    }
}

