/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package cn.hutool.core.date;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;

public class BetweenFormatter
implements Serializable {
    private static final long serialVersionUID = 1L;
    private long betweenMs;
    private Level level;
    private final int levelMaxCount;

    public BetweenFormatter(long betweenMs, Level level) {
        this(betweenMs, level, 0);
    }

    public BetweenFormatter(long betweenMs, Level level, int levelMaxCount) {
        this.betweenMs = betweenMs;
        this.level = level;
        this.levelMaxCount = levelMaxCount;
    }

    public String format() {
        StringBuilder sb = new StringBuilder();
        if (this.betweenMs > 0L) {
            long day = this.betweenMs / DateUnit.DAY.getMillis();
            long hour = this.betweenMs / DateUnit.HOUR.getMillis() - day * 24L;
            long minute = this.betweenMs / DateUnit.MINUTE.getMillis() - day * 24L * 60L - hour * 60L;
            long BetweenOfSecond = ((day * 24L + hour) * 60L + minute) * 60L;
            long second = this.betweenMs / DateUnit.SECOND.getMillis() - BetweenOfSecond;
            long millisecond = this.betweenMs - (BetweenOfSecond + second) * 1000L;
            int level = this.level.ordinal();
            int levelCount = 0;
            if (this.isLevelCountValid(levelCount) && 0L != day && level >= Level.DAY.ordinal()) {
                sb.append(day).append(Level.DAY.name);
                ++levelCount;
            }
            if (this.isLevelCountValid(levelCount) && 0L != hour && level >= Level.HOUR.ordinal()) {
                sb.append(hour).append(Level.HOUR.name);
                ++levelCount;
            }
            if (this.isLevelCountValid(levelCount) && 0L != minute && level >= Level.MINUTE.ordinal()) {
                sb.append(minute).append(Level.MINUTE.name);
                ++levelCount;
            }
            if (this.isLevelCountValid(levelCount) && 0L != second && level >= Level.SECOND.ordinal()) {
                sb.append(second).append(Level.SECOND.name);
                ++levelCount;
            }
            if (this.isLevelCountValid(levelCount) && 0L != millisecond && level >= Level.MILLISECOND.ordinal()) {
                sb.append(millisecond).append(Level.MILLISECOND.name);
            }
        }
        if (StrUtil.isEmpty((CharSequence)sb)) {
            sb.append(0).append(this.level.name);
        }
        return sb.toString();
    }

    public long getBetweenMs() {
        return this.betweenMs;
    }

    public void setBetweenMs(long betweenMs) {
        this.betweenMs = betweenMs;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String toString() {
        return this.format();
    }

    private boolean isLevelCountValid(int levelCount) {
        return this.levelMaxCount <= 0 || levelCount < this.levelMaxCount;
    }

    public static enum Level {
        DAY("天"),
        HOUR("小时"),
        MINUTE("分"),
        SECOND("秒"),
        MILLISECOND("毫秒");

        private final String name;

        private Level(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}

