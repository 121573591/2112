/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.concurrent.FastThreadLocal
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package io.netty.handler.codec.http;

import io.netty.util.concurrent.FastThreadLocal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Deprecated
public final class HttpHeaderDateFormat
extends SimpleDateFormat {
    private static final long serialVersionUID = -925286159755905325L;
    private final SimpleDateFormat format1 = new HttpHeaderDateFormatObsolete1();
    private final SimpleDateFormat format2 = new HttpHeaderDateFormatObsolete2();
    private static final FastThreadLocal<HttpHeaderDateFormat> dateFormatThreadLocal = new FastThreadLocal<HttpHeaderDateFormat>(){

        protected HttpHeaderDateFormat initialValue() {
            return new HttpHeaderDateFormat();
        }
    };

    public static HttpHeaderDateFormat get() {
        return (HttpHeaderDateFormat)((Object)dateFormatThreadLocal.get());
    }

    private HttpHeaderDateFormat() {
        super("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        this.setTimeZone(TimeZone.getTimeZone((String)"GMT"));
    }

    public Date parse(String text, ParsePosition pos) {
        Date date = super.parse(text, pos);
        if (date == null) {
            date = this.format1.parse(text, pos);
        }
        if (date == null) {
            date = this.format2.parse(text, pos);
        }
        return date;
    }

    private static final class HttpHeaderDateFormatObsolete2
    extends SimpleDateFormat {
        private static final long serialVersionUID = 3010674519968303714L;

        HttpHeaderDateFormatObsolete2() {
            super("E MMM d HH:mm:ss yyyy", Locale.ENGLISH);
            this.setTimeZone(TimeZone.getTimeZone((String)"GMT"));
        }
    }

    private static final class HttpHeaderDateFormatObsolete1
    extends SimpleDateFormat {
        private static final long serialVersionUID = -3178072504225114298L;

        HttpHeaderDateFormatObsolete1() {
            super("E, dd-MMM-yy HH:mm:ss z", Locale.ENGLISH);
            this.setTimeZone(TimeZone.getTimeZone((String)"GMT"));
        }
    }
}

