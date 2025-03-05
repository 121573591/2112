/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.pmw.tinylog.Logger
 */
package cn.hutool.log.dialect.tinylog;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.tinylog.TinyLog;
import org.pmw.tinylog.Logger;

public class TinyLogFactory
extends LogFactory {
    public TinyLogFactory() {
        super("TinyLog");
        this.checkLogExist(Logger.class);
    }

    @Override
    public Log createLog(String name) {
        return new TinyLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new TinyLog(clazz);
    }
}

