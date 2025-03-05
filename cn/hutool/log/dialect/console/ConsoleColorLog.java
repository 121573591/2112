/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.function.Function
 */
package cn.hutool.log.dialect.console;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.ansi.AnsiColor;
import cn.hutool.core.lang.ansi.AnsiEncoder;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.dialect.console.ConsoleLog;
import cn.hutool.log.level.Level;
import java.util.function.Function;

public class ConsoleColorLog
extends ConsoleLog {
    private static final AnsiColor COLOR_CLASSNAME = AnsiColor.CYAN;
    private static final AnsiColor COLOR_TIME = AnsiColor.WHITE;
    private static final AnsiColor COLOR_NONE = AnsiColor.DEFAULT;
    private static Function<Level, AnsiColor> colorFactory = level -> {
        switch (level) {
            case DEBUG: 
            case INFO: {
                return AnsiColor.GREEN;
            }
            case WARN: {
                return AnsiColor.YELLOW;
            }
            case ERROR: {
                return AnsiColor.RED;
            }
            case TRACE: {
                return AnsiColor.MAGENTA;
            }
        }
        return COLOR_NONE;
    };

    public static void setColorFactory(Function<Level, AnsiColor> colorFactory) {
        ConsoleColorLog.colorFactory = colorFactory;
    }

    public ConsoleColorLog(String name) {
        super(name);
    }

    public ConsoleColorLog(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public synchronized void log(String fqcn, Level level, Throwable t, String format, Object ... arguments) {
        if (!this.isEnabled(level)) {
            return;
        }
        String template = AnsiEncoder.encode(COLOR_TIME, "[%s]", colorFactory.apply((Object)level), "[%-5s]%s", COLOR_CLASSNAME, "%-30s: ", COLOR_NONE, "%s%n");
        System.out.format(template, new Object[]{DateUtil.now(), level.name(), " - ", ClassUtil.getShortClassName(this.getName()), StrUtil.format(format, arguments)});
    }
}

