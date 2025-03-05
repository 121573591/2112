/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.log.dialect.console;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.console.ConsoleLog;

public class ConsoleLogFactory
extends LogFactory {
    public ConsoleLogFactory() {
        super("Hutool Console Logging");
    }

    @Override
    public Log createLog(String name) {
        return new ConsoleLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new ConsoleLog(clazz);
    }
}

