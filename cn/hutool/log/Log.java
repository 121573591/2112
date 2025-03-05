/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.log;

import cn.hutool.core.lang.caller.CallerUtil;
import cn.hutool.log.LogFactory;
import cn.hutool.log.level.DebugLog;
import cn.hutool.log.level.ErrorLog;
import cn.hutool.log.level.InfoLog;
import cn.hutool.log.level.Level;
import cn.hutool.log.level.TraceLog;
import cn.hutool.log.level.WarnLog;

public interface Log
extends TraceLog,
DebugLog,
InfoLog,
WarnLog,
ErrorLog {
    public static Log get(Class<?> clazz) {
        return LogFactory.get(clazz);
    }

    public static Log get(String name) {
        return LogFactory.get(name);
    }

    public static Log get() {
        return LogFactory.get(CallerUtil.getCallerCaller());
    }

    public String getName();

    public boolean isEnabled(Level var1);

    public void log(Level var1, String var2, Object ... var3);

    public void log(Level var1, Throwable var2, String var3, Object ... var4);

    public void log(String var1, Level var2, Throwable var3, String var4, Object ... var5);
}

