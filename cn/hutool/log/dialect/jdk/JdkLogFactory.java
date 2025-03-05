/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.util.logging.LogManager
 */
package cn.hutool.log.dialect.jdk;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.jdk.JdkLog;
import java.io.Closeable;
import java.io.InputStream;
import java.util.logging.LogManager;

public class JdkLogFactory
extends LogFactory {
    public JdkLogFactory() {
        super("JDK Logging");
        this.readConfig();
    }

    @Override
    public Log createLog(String name) {
        return new JdkLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new JdkLog(clazz);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readConfig() {
        InputStream in = ResourceUtil.getStreamSafe("logging.properties");
        if (null == in) {
            System.err.println("[WARN] Can not find [logging.properties], use [%JRE_HOME%/lib/logging.properties] as default!");
            return;
        }
        try {
            LogManager.getLogManager().readConfiguration(in);
        }
        catch (Exception e) {
            Console.error(e, "Read [logging.properties] from classpath error!", new Object[0]);
            try {
                LogManager.getLogManager().readConfiguration();
            }
            catch (Exception e1) {
                Console.error(e, "Read [logging.properties] from [%JRE_HOME%/lib/logging.properties] error!", new Object[0]);
            }
        }
        finally {
            IoUtil.close((Closeable)in);
        }
    }
}

