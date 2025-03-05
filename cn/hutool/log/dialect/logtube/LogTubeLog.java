/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.github.logtube.Logtube
 *  io.github.logtube.core.IEventLogger
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.log.dialect.logtube;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.AbstractLog;
import cn.hutool.log.level.Level;
import io.github.logtube.Logtube;
import io.github.logtube.core.IEventLogger;

public class LogTubeLog
extends AbstractLog {
    private final IEventLogger logger;

    public LogTubeLog(IEventLogger logger) {
        this.logger = logger;
    }

    public LogTubeLog(Class<?> clazz) {
        this(null == clazz ? "null" : clazz.getName());
    }

    public LogTubeLog(String name) {
        this(Logtube.getLogger((String)name));
    }

    @Override
    public String getName() {
        return this.logger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override
    public void trace(String fqcn, Throwable t, String format, Object ... arguments) {
        this.log(fqcn, Level.TRACE, t, format, arguments);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public void debug(String fqcn, Throwable t, String format, Object ... arguments) {
        this.log(fqcn, Level.DEBUG, t, format, arguments);
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(String fqcn, Throwable t, String format, Object ... arguments) {
        this.log(fqcn, Level.INFO, t, format, arguments);
    }

    @Override
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override
    public void warn(String fqcn, Throwable t, String format, Object ... arguments) {
        this.log(fqcn, Level.WARN, t, format, arguments);
    }

    @Override
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override
    public void error(String fqcn, Throwable t, String format, Object ... arguments) {
        this.log(fqcn, Level.ERROR, t, format, arguments);
    }

    @Override
    public void log(String fqcn, Level level, Throwable t, String format, Object ... arguments) {
        String topic = level.name().toLowerCase();
        this.logger.topic(topic).xStackTraceElement(ExceptionUtil.getStackElement(6), null).message(StrUtil.format(format, arguments)).xException(t).commit();
    }
}

