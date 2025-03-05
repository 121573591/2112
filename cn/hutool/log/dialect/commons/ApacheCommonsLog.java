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
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package cn.hutool.log.dialect.commons;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.AbstractLog;
import cn.hutool.log.level.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApacheCommonsLog
extends AbstractLog {
    private static final long serialVersionUID = -6843151523380063975L;
    private final transient Log logger;
    private final String name;

    public ApacheCommonsLog(Log logger, String name) {
        this.logger = logger;
        this.name = name;
    }

    public ApacheCommonsLog(Class<?> clazz) {
        this(LogFactory.getLog(clazz), null == clazz ? "null" : clazz.getName());
    }

    public ApacheCommonsLog(String name) {
        this(LogFactory.getLog((String)name), name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override
    public void trace(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isTraceEnabled()) {
            this.logger.trace((Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public void debug(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isDebugEnabled()) {
            this.logger.debug((Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isInfoEnabled()) {
            this.logger.info((Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override
    public void warn(String format, Object ... arguments) {
        if (this.isWarnEnabled()) {
            this.logger.warn((Object)StrUtil.format(format, arguments));
        }
    }

    @Override
    public void warn(Throwable t, String format, Object ... arguments) {
    }

    @Override
    public void warn(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isWarnEnabled()) {
            this.logger.warn((Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override
    public void error(String fqcn, Throwable t, String format, Object ... arguments) {
        if (this.isErrorEnabled()) {
            this.logger.warn((Object)StrUtil.format(format, arguments), t);
        }
    }

    @Override
    public void log(String fqcn, Level level, Throwable t, String format, Object ... arguments) {
        switch (level) {
            case TRACE: {
                this.trace(t, format, arguments);
                break;
            }
            case DEBUG: {
                this.debug(t, format, arguments);
                break;
            }
            case INFO: {
                this.info(t, format, arguments);
                break;
            }
            case WARN: {
                this.warn(t, format, arguments);
                break;
            }
            case ERROR: {
                this.error(t, format, arguments);
                break;
            }
            default: {
                throw new Error(StrUtil.format("Can not identify level: {}", new Object[]{level}));
            }
        }
    }
}

