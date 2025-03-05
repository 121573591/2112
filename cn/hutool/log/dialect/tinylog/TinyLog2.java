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
 *  org.tinylog.Level
 *  org.tinylog.configuration.Configuration
 *  org.tinylog.format.AdvancedMessageFormatter
 *  org.tinylog.format.MessageFormatter
 *  org.tinylog.provider.LoggingProvider
 *  org.tinylog.provider.ProviderRegistry
 */
package cn.hutool.log.dialect.tinylog;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.AbstractLog;
import cn.hutool.log.level.Level;
import org.tinylog.configuration.Configuration;
import org.tinylog.format.AdvancedMessageFormatter;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.provider.ProviderRegistry;

public class TinyLog2
extends AbstractLog {
    private static final long serialVersionUID = 1L;
    private static final int DEPTH = 5;
    private final int level;
    private final String name;
    private static final LoggingProvider provider = ProviderRegistry.getLoggingProvider();
    private static final MessageFormatter formatter = new AdvancedMessageFormatter(Configuration.getLocale(), Configuration.isEscapingEnabled());

    public TinyLog2(Class<?> clazz) {
        this(null == clazz ? "null" : clazz.getName());
    }

    public TinyLog2(String name) {
        this.name = name;
        this.level = provider.getMinimumLevel().ordinal();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isTraceEnabled() {
        return this.level <= org.tinylog.Level.TRACE.ordinal();
    }

    @Override
    public void trace(String fqcn, Throwable t, String format, Object ... arguments) {
        this.logIfEnabled(fqcn, org.tinylog.Level.TRACE, t, format, arguments);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.level <= org.tinylog.Level.DEBUG.ordinal();
    }

    @Override
    public void debug(String fqcn, Throwable t, String format, Object ... arguments) {
        this.logIfEnabled(fqcn, org.tinylog.Level.DEBUG, t, format, arguments);
    }

    @Override
    public boolean isInfoEnabled() {
        return this.level <= org.tinylog.Level.INFO.ordinal();
    }

    @Override
    public void info(String fqcn, Throwable t, String format, Object ... arguments) {
        this.logIfEnabled(fqcn, org.tinylog.Level.INFO, t, format, arguments);
    }

    @Override
    public boolean isWarnEnabled() {
        return this.level <= org.tinylog.Level.WARN.ordinal();
    }

    @Override
    public void warn(String fqcn, Throwable t, String format, Object ... arguments) {
        this.logIfEnabled(fqcn, org.tinylog.Level.WARN, t, format, arguments);
    }

    @Override
    public boolean isErrorEnabled() {
        return this.level <= org.tinylog.Level.ERROR.ordinal();
    }

    @Override
    public void error(String fqcn, Throwable t, String format, Object ... arguments) {
        this.logIfEnabled(fqcn, org.tinylog.Level.ERROR, t, format, arguments);
    }

    @Override
    public void log(String fqcn, Level level, Throwable t, String format, Object ... arguments) {
        this.logIfEnabled(fqcn, this.toTinyLevel(level), t, format, arguments);
    }

    @Override
    public boolean isEnabled(Level level) {
        return this.level <= this.toTinyLevel(level).ordinal();
    }

    private void logIfEnabled(String fqcn, org.tinylog.Level level, Throwable t, String format, Object ... arguments) {
        if (null == t) {
            t = TinyLog2.getLastArgumentIfThrowable(arguments);
        }
        provider.log(5, null, level, t, formatter, (Object)StrUtil.toString(format), arguments);
    }

    private org.tinylog.Level toTinyLevel(Level level) {
        org.tinylog.Level tinyLevel;
        switch (level) {
            case TRACE: {
                tinyLevel = org.tinylog.Level.TRACE;
                break;
            }
            case DEBUG: {
                tinyLevel = org.tinylog.Level.DEBUG;
                break;
            }
            case INFO: {
                tinyLevel = org.tinylog.Level.INFO;
                break;
            }
            case WARN: {
                tinyLevel = org.tinylog.Level.WARN;
                break;
            }
            case ERROR: {
                tinyLevel = org.tinylog.Level.ERROR;
                break;
            }
            case OFF: {
                tinyLevel = org.tinylog.Level.OFF;
                break;
            }
            default: {
                throw new Error(StrUtil.format("Can not identify level: {}", new Object[]{level}));
            }
        }
        return tinyLevel;
    }

    private static Throwable getLastArgumentIfThrowable(Object ... arguments) {
        if (ArrayUtil.isNotEmpty(arguments) && arguments[arguments.length - 1] instanceof Throwable) {
            return (Throwable)((Object)arguments[arguments.length - 1]);
        }
        return null;
    }
}

