/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.apache.commons.logging.LogFactory
 */
package cn.hutool.log.dialect.commons;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.commons.ApacheCommonsLog;
import cn.hutool.log.dialect.commons.ApacheCommonsLog4JLog;

public class ApacheCommonsLogFactory
extends LogFactory {
    public ApacheCommonsLogFactory() {
        super("Apache Common Logging");
        this.checkLogExist(org.apache.commons.logging.LogFactory.class);
    }

    @Override
    public Log createLog(String name) {
        try {
            return new ApacheCommonsLog4JLog(name);
        }
        catch (Exception e) {
            return new ApacheCommonsLog(name);
        }
    }

    @Override
    public Log createLog(Class<?> clazz) {
        try {
            return new ApacheCommonsLog4JLog(clazz);
        }
        catch (Exception e) {
            return new ApacheCommonsLog(clazz);
        }
    }

    @Override
    protected void checkLogExist(Class<?> logClassName) {
        super.checkLogExist(logClassName);
        this.getLog(ApacheCommonsLogFactory.class);
    }
}

