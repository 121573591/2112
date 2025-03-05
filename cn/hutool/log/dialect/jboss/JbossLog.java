/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  org.jboss.logging.Logger
 *  org.jboss.logging.Logger$Level
 */
package cn.hutool.log.dialect.jboss;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.AbstractLog;
import cn.hutool.log.level.Level;
import org.jboss.logging.Logger;

public class JbossLog
extends AbstractLog {
    private static final long serialVersionUID = -6843151523380063975L;
    private final transient Logger logger;

    public JbossLog(Logger logger) {
        this.logger = logger;
    }

    public JbossLog(Class<?> clazz) {
        this(null == clazz ? "null" : clazz.getName());
    }

    public JbossLog(String name) {
        this(Logger.getLogger((String)name));
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
        if (this.isTraceEnabled()) {
            this.logger.trace(fqcn, (Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public void debug(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isDebugEnabled()) {
            this.logger.debug(fqcn, (Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isInfoEnabled()) {
            this.logger.info(fqcn, (Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return this.logger.isEnabled(Logger.Level.WARN);
    }

    @Override
    public void warn(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isWarnEnabled()) {
            this.logger.warn(fqcn, (Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return this.logger.isEnabled(Logger.Level.ERROR);
    }

    @Override
    public void error(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isErrorEnabled()) {
            this.logger.error(fqcn, (Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public void log(String fqcn, Level level, Throwable t, String format, Object ... arguments) {
        switch (level) {
            case TRACE: {
                this.trace(fqcn, t, format, arguments);
                break;
            }
            case DEBUG: {
                this.debug(fqcn, t, format, arguments);
                break;
            }
            case INFO: {
                this.info(fqcn, t, format, arguments);
                break;
            }
            case WARN: {
                this.warn(fqcn, t, format, arguments);
                break;
            }
            case ERROR: {
                this.error(fqcn, t, format, arguments);
                break;
            }
            default: {
                throw new Error(StrUtil.format("Can not identify level: {}", new Object[]{level}));
            }
        }
    }
}

