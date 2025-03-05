/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.time.DayOfWeek
 *  java.time.Instant
 *  java.time.LocalDate
 *  java.time.LocalDateTime
 *  java.time.LocalTime
 *  java.time.Month
 *  java.time.MonthDay
 *  java.time.OffsetDateTime
 *  java.time.OffsetTime
 *  java.time.ZoneId
 *  java.time.ZonedDateTime
 *  java.time.chrono.Era
 *  java.time.chrono.IsoEra
 *  java.time.format.DateTimeFormatter
 *  java.time.temporal.TemporalAccessor
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Map
 *  java.util.Objects
 */
package cn.hutool.core.convert.impl;

import cn.hutool.core.convert.AbstractConverter;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConvertException;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.Era;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class TemporalAccessorConverter
extends AbstractConverter<TemporalAccessor> {
    private static final long serialVersionUID = 1L;
    private final Class<?> targetType;
    private String format;

    public TemporalAccessorConverter(Class<?> targetType) {
        this(targetType, null);
    }

    public TemporalAccessorConverter(Class<?> targetType, String format) {
        this.targetType = targetType;
        this.format = format;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public Class<TemporalAccessor> getTargetType() {
        return this.targetType;
    }

    @Override
    protected TemporalAccessor convertInternal(Object value) {
        if (value instanceof Number) {
            return this.parseFromLong(((Number)value).longValue());
        }
        if (value instanceof TemporalAccessor) {
            return this.parseFromTemporalAccessor((TemporalAccessor)value);
        }
        if (value instanceof Date) {
            DateTime dateTime = DateUtil.date((Date)value);
            return this.parseFromInstant(dateTime.toInstant(), dateTime.getZoneId());
        }
        if (value instanceof Calendar) {
            Calendar calendar = (Calendar)value;
            return this.parseFromInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
        }
        if (value instanceof Map) {
            Map map = (Map)value;
            if (LocalDate.class.equals(this.targetType)) {
                return LocalDate.of((int)Convert.toInt(map.get((Object)"year")), (int)Convert.toInt(map.get((Object)"month")), (int)Convert.toInt(map.get((Object)"day")));
            }
            if (LocalDateTime.class.equals(this.targetType)) {
                return LocalDateTime.of((int)Convert.toInt(map.get((Object)"year")), (int)Convert.toInt(map.get((Object)"month")), (int)Convert.toInt(map.get((Object)"day")), (int)Convert.toInt(map.get((Object)"hour")), (int)Convert.toInt(map.get((Object)"minute")), (int)Convert.toInt(map.get((Object)"second")), (int)Convert.toInt(map.get((Object)"second")));
            }
            if (LocalTime.class.equals(this.targetType)) {
                return LocalTime.of((int)Convert.toInt(map.get((Object)"hour")), (int)Convert.toInt(map.get((Object)"minute")), (int)Convert.toInt(map.get((Object)"second")), (int)Convert.toInt(map.get((Object)"nano")));
            }
            throw new ConvertException("Unsupported type: [{}] from map: [{}]", this.targetType, map);
        }
        return this.parseFromCharSequence(this.convertToStr(value));
    }

    private TemporalAccessor parseFromCharSequence(CharSequence value) {
        ZoneId zoneId;
        Instant instant;
        if (StrUtil.isBlank(value)) {
            return null;
        }
        if (DayOfWeek.class.equals(this.targetType)) {
            return DayOfWeek.valueOf((String)StrUtil.toString(value));
        }
        if (Month.class.equals(this.targetType)) {
            return Month.valueOf((String)StrUtil.toString(value));
        }
        if (Era.class.equals(this.targetType)) {
            return IsoEra.valueOf((String)StrUtil.toString(value));
        }
        if (MonthDay.class.equals(this.targetType)) {
            return MonthDay.parse((CharSequence)value);
        }
        if (null != this.format) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern((String)this.format);
            instant = (Instant)formatter.parse(value, Instant::from);
            zoneId = formatter.getZone();
        } else {
            DateTime dateTime = DateUtil.parse(value);
            instant = ((DateTime)((Object)Objects.requireNonNull((Object)((Object)dateTime)))).toInstant();
            zoneId = dateTime.getZoneId();
        }
        return this.parseFromInstant(instant, zoneId);
    }

    private TemporalAccessor parseFromLong(Long time) {
        if (DayOfWeek.class.equals(this.targetType)) {
            return DayOfWeek.of((int)Math.toIntExact((long)time));
        }
        if (Month.class.equals(this.targetType)) {
            return Month.of((int)Math.toIntExact((long)time));
        }
        if (Era.class.equals(this.targetType)) {
            return IsoEra.of((int)Math.toIntExact((long)time));
        }
        Instant instant = "#sss".equals((Object)this.format) ? Instant.ofEpochSecond((long)time) : Instant.ofEpochMilli((long)time);
        return this.parseFromInstant(instant, null);
    }

    private TemporalAccessor parseFromTemporalAccessor(TemporalAccessor temporalAccessor) {
        if (DayOfWeek.class.equals(this.targetType)) {
            return DayOfWeek.from((TemporalAccessor)temporalAccessor);
        }
        if (Month.class.equals(this.targetType)) {
            return Month.from((TemporalAccessor)temporalAccessor);
        }
        if (MonthDay.class.equals(this.targetType)) {
            return MonthDay.from((TemporalAccessor)temporalAccessor);
        }
        TemporalAccessor result = null;
        if (temporalAccessor instanceof LocalDateTime) {
            result = this.parseFromLocalDateTime((LocalDateTime)temporalAccessor);
        } else if (temporalAccessor instanceof ZonedDateTime) {
            result = this.parseFromZonedDateTime((ZonedDateTime)temporalAccessor);
        }
        if (null == result) {
            result = this.parseFromInstant(DateUtil.toInstant(temporalAccessor), null);
        }
        return result;
    }

    private TemporalAccessor parseFromLocalDateTime(LocalDateTime localDateTime) {
        if (Instant.class.equals(this.targetType)) {
            return DateUtil.toInstant((TemporalAccessor)localDateTime);
        }
        if (LocalDate.class.equals(this.targetType)) {
            return localDateTime.toLocalDate();
        }
        if (LocalTime.class.equals(this.targetType)) {
            return localDateTime.toLocalTime();
        }
        if (ZonedDateTime.class.equals(this.targetType)) {
            return localDateTime.atZone(ZoneId.systemDefault());
        }
        if (OffsetDateTime.class.equals(this.targetType)) {
            return localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
        }
        if (OffsetTime.class.equals(this.targetType)) {
            return localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime().toOffsetTime();
        }
        return null;
    }

    private TemporalAccessor parseFromZonedDateTime(ZonedDateTime zonedDateTime) {
        if (Instant.class.equals(this.targetType)) {
            return DateUtil.toInstant((TemporalAccessor)zonedDateTime);
        }
        if (LocalDateTime.class.equals(this.targetType)) {
            return zonedDateTime.toLocalDateTime();
        }
        if (LocalDate.class.equals(this.targetType)) {
            return zonedDateTime.toLocalDate();
        }
        if (LocalTime.class.equals(this.targetType)) {
            return zonedDateTime.toLocalTime();
        }
        if (OffsetDateTime.class.equals(this.targetType)) {
            return zonedDateTime.toOffsetDateTime();
        }
        if (OffsetTime.class.equals(this.targetType)) {
            return zonedDateTime.toOffsetDateTime().toOffsetTime();
        }
        return null;
    }

    private TemporalAccessor parseFromInstant(Instant instant, ZoneId zoneId) {
        if (Instant.class.equals(this.targetType)) {
            return instant;
        }
        zoneId = ObjectUtil.defaultIfNull(zoneId, ZoneId::systemDefault);
        LocalDateTime result = null;
        if (LocalDateTime.class.equals(this.targetType)) {
            result = LocalDateTime.ofInstant((Instant)instant, (ZoneId)zoneId);
        } else if (LocalDate.class.equals(this.targetType)) {
            result = instant.atZone(zoneId).toLocalDate();
        } else if (LocalTime.class.equals(this.targetType)) {
            result = instant.atZone(zoneId).toLocalTime();
        } else if (ZonedDateTime.class.equals(this.targetType)) {
            result = instant.atZone(zoneId);
        } else if (OffsetDateTime.class.equals(this.targetType)) {
            result = OffsetDateTime.ofInstant((Instant)instant, (ZoneId)zoneId);
        } else if (OffsetTime.class.equals(this.targetType)) {
            result = OffsetTime.ofInstant((Instant)instant, (ZoneId)zoneId);
        }
        return result;
    }
}

