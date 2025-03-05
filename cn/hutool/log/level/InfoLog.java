/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.log.level;

public interface InfoLog {
    public boolean isInfoEnabled();

    public void info(Throwable var1);

    public void info(String var1, Object ... var2);

    public void info(Throwable var1, String var2, Object ... var3);

    public void info(String var1, Throwable var2, String var3, Object ... var4);
}

