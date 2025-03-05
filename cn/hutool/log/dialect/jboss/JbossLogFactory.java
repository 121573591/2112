/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.jboss.logging.Logger
 */
package cn.hutool.log.dialect.jboss;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.jboss.JbossLog;
import org.jboss.logging.Logger;

public class JbossLogFactory
extends LogFactory {
    public JbossLogFactory() {
        super("JBoss Logging");
        this.checkLogExist(Logger.class);
    }

    @Override
    public Log createLog(String name) {
        return new JbossLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new JbossLog(clazz);
    }
}

