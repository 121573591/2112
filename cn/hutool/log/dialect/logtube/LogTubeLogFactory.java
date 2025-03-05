/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.github.logtube.Logtube
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.log.dialect.logtube;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.logtube.LogTubeLog;
import io.github.logtube.Logtube;

public class LogTubeLogFactory
extends LogFactory {
    public LogTubeLogFactory() {
        super("LogTube");
        this.checkLogExist(Logtube.class);
    }

    @Override
    public Log createLog(String name) {
        return new LogTubeLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new LogTubeLog(clazz);
    }
}

