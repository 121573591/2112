/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NoSuchFieldException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.SafeVarargs
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.net.InetSocketAddress
 *  java.net.ServerSocket
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.net.SocketTimeoutException
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.TimeZone
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.ArrayIteratorKt
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Charsets
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={" È\n\n \n\t\n \n\n \n\b\n\b\n\n\b\n\n \n\b\n\n\b\n \n\b\n\n\b\n\n\b\n\n\b\n!\n\b\n\n\b\n\n\n \n\n\n\b\n\n\b\n\n\b\n\n \n\n\b\n\f\n\b\n\n\b\n\n\n\n\b\n\n\b\n\n\b\r\n\n\n\b\n\n\b\t\n\n\b\n\n\b\n\n\n\b\n$\n\b\t\n\n\n \n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\b'020 202\b0¢\b\b%\r0\f2\t02\n020¢\b\r)0 20 2\n\b00\"0¢\b!0\f2\f\b0\f0H\bø ¢\b/\b8 0\"\b 2\n\b8 0\"8 H¢\b020 ¢\b3$8 \"\b 2 02\f\"\b8 0!2#0 ¢\b$%(0'20 2&0¢\b())*0\f20 2\f\b0\f0H\bø ¢\b*+'/0\f\"\b ,*\b8 0-2.8 H ¢\b/030*01220H¢\b3430*0220H¢\b3530*06220H¢\b37:09*08¢\b:;<0\f*0H\b¢\b<=>0\f*0H\b¢\b>=?0*0 ¢\b?B0*0@2A0@¢\bBCE0\f*0D¢\bEFE0\f*0G¢\bEHE0\f*0I¢\bEJ%L\b0 0*\b0 02K0 ¢\bLM-R0*0 2O0N2\b\bP02\b\bQ0¢\bRS-R0*0 2T0 2\b\bP02\b\bQ0¢\bRU!Y0*0V2W02X0¢\bYZB_\b8 0\"\b *\b8 0[2^8 00\\¢\b]H\bø ¢\b_`7c0*\b0 02A\n0 02b\n\b 0 0a¢\bcdf0*0e¢\bfg-h0*\b0 02K0 2\fb\b0 0a¢\bhij0*0 ¢\bjk%l0*0 2\b\bP02\b\bQ0¢\blm%n0*0 2\b\bP02\b\bQ0¢\bnmo0*0 2\b\bP0¢\bop;q\b0 0*\b0 02\fA\b0 02b\n\b 0 0a¢\bqrv0*0s2u0t¢\bvwz0*0I2y0x¢\bz{|0\f*0H\b¢\b|=}0\f*0H\b¢\b}=~0*0N¢\b~0 *0I¢\b0*0x2\b0¢\b0*0x¢\b0*0201¢\b#0*0V202X0¢\bZ\t00*0¢\b0*\t00¢\b0 *0¢\b0 *0¢\b0 *0@2\t\b0¢\b&\b8 0\"\b *\b8 0¢\b<8 80\"\b \"\b*8 80¢\b 0*0 20¢\b ¡¢0*0 20¢\b¢p(£0 *0 2\b\bP02\b\bQ0¢\b£¤¥0\f*0H\b¢\b¥=0ª0©*\b0¦j`§2¨\n\b0¦j`§0¢\bª«®0\f*0¬2­0¢\b®¯\"±0°8X¢\b\n\b±²\"³08X¢\b\n\b³´\"¶0µ8X¢\b\n\b¶·\"¹0¸8X¢\b\n\b¹º\"¼0»8X¢\b\n\b¼½\"¿0¾8X¢\b\n\b¿À\"Â0Á8X¢\b\n\bÂÃ\"Ä08 X¢\b\n\bÄÅ\"Æ0 8 X¢\b\n\bÆÇ\"È0 8XT¢\b\n\bÈÇ\n\b20¨É"}, d2={"", "name", "", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "arrayLength", "offset", "count", "", "checkOffsetAndCount", "(JJJ)V", "format", "", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/Function0;", "block", "ignoreIoExceptions", "(Lkotlin/jvm/functions/Function0;)V", "T", "elements", "", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "", "isSensitiveHeader", "(Ljava/lang/String;)Z", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "threadName", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "E", "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "", "mask", "and", "(BI)I", "(IJ)J", "", "(SI)I", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "(Lokhttp3/EventListener;)Lokhttp3/EventListener$Factory;", "assertThreadDoesntHoldLock", "(Ljava/lang/Object;)V", "assertThreadHoldsLock", "canParseAsIpAddress", "Lokhttp3/HttpUrl;", "other", "canReuseConnectionFor", "(Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;)Z", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "Ljava/net/ServerSocket;", "(Ljava/net/ServerSocket;)V", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "value", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "", "delimiter", "startIndex", "endIndex", "delimiterOffset", "(Ljava/lang/String;CII)I", "delimiters", "(Ljava/lang/String;Ljava/lang/String;II)I", "Lokio/Source;", "timeout", "timeUnit", "discard", "(Lokio/Source;ILjava/util/concurrent/TimeUnit;)Z", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "predicate", "filterList", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "Ljava/util/Comparator;", "comparator", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/Response;", "headersContentLength", "(Lokhttp3/Response;)J", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "isCivilized", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;)Z", "Lokio/BufferedSource;", "source", "isHealthy", "(Ljava/net/Socket;Lokio/BufferedSource;)Z", "notify", "notifyAll", "parseHexDigit", "(C)I", "peerName", "(Ljava/net/Socket;)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "readMedium", "(Lokio/BufferedSource;)I", "Lokio/Buffer;", "b", "skipAll", "(Lokio/Buffer;B)I", "Lokhttp3/Headers;", "Lokhttp3/internal/http2/Header;", "toHeaderList", "(Lokhttp3/Headers;)Ljava/util/List;", "toHeaders", "(Ljava/util/List;)Lokhttp3/Headers;", "toHexString", "(I)Ljava/lang/String;", "(J)Ljava/lang/String;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/HttpUrl;Z)Ljava/lang/String;", "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", "K", "V", "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "wait", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "Lokio/BufferedSink;", "medium", "writeMedium", "(Lokio/BufferedSink;I)V", "", "EMPTY_BYTE_ARRAY", "[B", "EMPTY_HEADERS", "Lokhttp3/Headers;", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "Lokio/Options;", "UNICODE_BOMS", "Lokio/Options;", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "Lkotlin/text/Regex;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "Z", "okHttpName", "Ljava/lang/String;", "userAgent", "okhttp"})
@JvmName(name="Util")
@SourceDebugExtension(value={"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,636:1\n37#2,2:637\n1627#3,6:639\n1#4:645\n1549#5:646\n1620#5,3:647\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n*L\n127#1:637,2\n167#1:639,6\n300#1:646\n300#1:647,3\n*E\n"})
public final class Util {
    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, EMPTY_BYTE_ARRAY, null, 1, null);
    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, EMPTY_BYTE_ARRAY, null, 0, 0, 7, null);
    @NotNull
    private static final Options UNICODE_BOMS;
    @JvmField
    @NotNull
    public static final TimeZone UTC;
    @NotNull
    private static final Regex VERIFY_AS_IP_ADDRESS;
    @JvmField
    public static final boolean assertionsEnabled;
    @JvmField
    @NotNull
    public static final String okHttpName;
    @NotNull
    public static final String userAgent = "okhttp/4.12.0";

    public static final void checkOffsetAndCount(long arrayLength, long offset, long count) {
        if ((offset | count) < 0L || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull String name, boolean daemon) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return arg_0 -> Util.threadFactory$lambda$1(name, daemon, arg_0);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] $this$intersect, @NotNull String[] other, @NotNull Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter((Object)$this$intersect, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Intrinsics.checkNotNullParameter(comparator, (String)"comparator");
        List result = (List)new ArrayList();
        block0: for (String a : $this$intersect) {
            for (String b : other) {
                if (comparator.compare((Object)a, (Object)b) != 0) continue;
                result.add((Object)a);
                continue block0;
            }
        }
        Collection $this$toTypedArray$iv = (Collection)result;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        return (String[])thisCollection$iv.toArray((Object[])new String[0]);
    }

    public static final boolean hasIntersection(@NotNull String[] $this$hasIntersection, @Nullable String[] other, @NotNull Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter((Object)$this$hasIntersection, (String)"<this>");
        Intrinsics.checkNotNullParameter(comparator, (String)"comparator");
        if ($this$hasIntersection.length == 0 || other == null || other.length == 0) {
            return false;
        }
        for (String a : $this$hasIntersection) {
            Iterator iterator = ArrayIteratorKt.iterator((Object[])other);
            while (iterator.hasNext()) {
                String b = (String)iterator.next();
                if (comparator.compare((Object)a, (Object)b) != 0) continue;
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl $this$toHostHeader, boolean includeDefaultPort) {
        Intrinsics.checkNotNullParameter((Object)$this$toHostHeader, (String)"<this>");
        String host = StringsKt.contains$default((CharSequence)$this$toHostHeader.host(), (CharSequence)":", (boolean)false, (int)2, null) ? '[' + $this$toHostHeader.host() + ']' : $this$toHostHeader.host();
        return includeDefaultPort || $this$toHostHeader.port() != HttpUrl.Companion.defaultPort($this$toHostHeader.scheme()) ? host + ':' + $this$toHostHeader.port() : host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return Util.toHostHeader(httpUrl, bl);
    }

    public static final int indexOf(@NotNull String[] $this$indexOf, @NotNull String value, @NotNull Comparator<String> comparator) {
        int n;
        block1: {
            Intrinsics.checkNotNullParameter((Object)$this$indexOf, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Intrinsics.checkNotNullParameter(comparator, (String)"comparator");
            String[] $this$indexOfFirst$iv = $this$indexOf;
            boolean $i$f$indexOfFirst = false;
            int n2 = $this$indexOfFirst$iv.length;
            for (int index$iv = 0; index$iv < n2; ++index$iv) {
                String it = $this$indexOfFirst$iv[index$iv];
                boolean bl = false;
                if (!(comparator.compare((Object)it, (Object)value) == 0)) continue;
                n = index$iv;
                break block1;
            }
            n = -1;
        }
        return n;
    }

    @NotNull
    public static final String[] concat(@NotNull String[] $this$concat, @NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)$this$concat, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Object[] objectArray = Arrays.copyOf((Object[])$this$concat, (int)($this$concat.length + 1));
        Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"copyOf(this, newSize)");
        Object[] result = (String[])objectArray;
        result[ArraysKt.getLastIndex((Object[])result)] = value;
        return result;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String $this$indexOfFirstNonAsciiWhitespace, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter((Object)$this$indexOfFirstNonAsciiWhitespace, (String)"<this>");
        for (int i = startIndex; i < endIndex; ++i) {
            char c = $this$indexOfFirstNonAsciiWhitespace.charAt(i);
            if ((((c == '\t' ? true : c == '\n') ? true : c == '\f') ? true : c == '\r') ? true : c == ' ') continue;
            return i;
        }
        return endIndex;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        return Util.indexOfFirstNonAsciiWhitespace(string, n, n2);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String $this$indexOfLastNonAsciiWhitespace, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter((Object)$this$indexOfLastNonAsciiWhitespace, (String)"<this>");
        int i = endIndex - 1;
        if (startIndex <= i) {
            while (true) {
                char c;
                if (!(((((c = $this$indexOfLastNonAsciiWhitespace.charAt(i)) == '\t' ? true : c == '\n') ? true : c == '\f') ? true : c == '\r') ? true : c == ' ')) {
                    return i + 1;
                }
                if (i == startIndex) break;
                --i;
            }
        }
        return startIndex;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        return Util.indexOfLastNonAsciiWhitespace(string, n, n2);
    }

    @NotNull
    public static final String trimSubstring(@NotNull String $this$trimSubstring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter((Object)$this$trimSubstring, (String)"<this>");
        int start = Util.indexOfFirstNonAsciiWhitespace($this$trimSubstring, startIndex, endIndex);
        int end = Util.indexOfLastNonAsciiWhitespace($this$trimSubstring, start, endIndex);
        String string = $this$trimSubstring.substring(start, end);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"this as java.lang.String…ing(startIndex, endIndex)");
        return string;
    }

    public static /* synthetic */ String trimSubstring$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        return Util.trimSubstring(string, n, n2);
    }

    public static final int delimiterOffset(@NotNull String $this$delimiterOffset, @NotNull String delimiters, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter((Object)$this$delimiterOffset, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)delimiters, (String)"delimiters");
        for (int i = startIndex; i < endIndex; ++i) {
            if (!StringsKt.contains$default((CharSequence)delimiters, (char)$this$delimiterOffset.charAt(i), (boolean)false, (int)2, null)) continue;
            return i;
        }
        return endIndex;
    }

    public static /* synthetic */ int delimiterOffset$default(String string, String string2, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            n2 = string.length();
        }
        return Util.delimiterOffset(string, string2, n, n2);
    }

    public static final int delimiterOffset(@NotNull String $this$delimiterOffset, char delimiter, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter((Object)$this$delimiterOffset, (String)"<this>");
        for (int i = startIndex; i < endIndex; ++i) {
            if ($this$delimiterOffset.charAt(i) != delimiter) continue;
            return i;
        }
        return endIndex;
    }

    public static /* synthetic */ int delimiterOffset$default(String string, char c, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            n2 = string.length();
        }
        return Util.delimiterOffset(string, c, n, n2);
    }

    public static final int indexOfControlOrNonAscii(@NotNull String $this$indexOfControlOrNonAscii) {
        Intrinsics.checkNotNullParameter((Object)$this$indexOfControlOrNonAscii, (String)"<this>");
        int n = $this$indexOfControlOrNonAscii.length();
        for (int i = 0; i < n; ++i) {
            char c = $this$indexOfControlOrNonAscii.charAt(i);
            if (Intrinsics.compare((int)c, (int)31) > 0 && Intrinsics.compare((int)c, (int)127) < 0) continue;
            return i;
        }
        return -1;
    }

    public static final boolean canParseAsIpAddress(@NotNull String $this$canParseAsIpAddress) {
        Intrinsics.checkNotNullParameter((Object)$this$canParseAsIpAddress, (String)"<this>");
        return VERIFY_AS_IP_ADDRESS.matches((CharSequence)$this$canParseAsIpAddress);
    }

    public static final boolean isSensitiveHeader(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return StringsKt.equals((String)name, (String)"Authorization", (boolean)true) || StringsKt.equals((String)name, (String)"Cookie", (boolean)true) || StringsKt.equals((String)name, (String)"Proxy-Authorization", (boolean)true) || StringsKt.equals((String)name, (String)"Set-Cookie", (boolean)true);
    }

    @NotNull
    public static final String format(@NotNull String format, Object ... args) {
        Intrinsics.checkNotNullParameter((Object)format, (String)"format");
        Intrinsics.checkNotNullParameter((Object)args, (String)"args");
        Locale locale = Locale.US;
        Object[] objectArray = Arrays.copyOf((Object[])args, (int)args.length);
        String string = String.format((Locale)locale, (String)format, (Object[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"format(locale, format, *args)");
        return string;
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource $this$readBomAsCharset, @NotNull Charset charset) throws IOException {
        Charset charset2;
        Intrinsics.checkNotNullParameter((Object)$this$readBomAsCharset, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"default");
        switch ($this$readBomAsCharset.select(UNICODE_BOMS)) {
            case 0: {
                Charset charset3 = StandardCharsets.UTF_8;
                charset2 = charset3;
                Intrinsics.checkNotNullExpressionValue((Object)charset3, (String)"UTF_8");
                break;
            }
            case 1: {
                Charset charset4 = StandardCharsets.UTF_16BE;
                charset2 = charset4;
                Intrinsics.checkNotNullExpressionValue((Object)charset4, (String)"UTF_16BE");
                break;
            }
            case 2: {
                Charset charset5 = StandardCharsets.UTF_16LE;
                charset2 = charset5;
                Intrinsics.checkNotNullExpressionValue((Object)charset5, (String)"UTF_16LE");
                break;
            }
            case 3: {
                charset2 = Charsets.INSTANCE.UTF32_BE();
                break;
            }
            case 4: {
                charset2 = Charsets.INSTANCE.UTF32_LE();
                break;
            }
            case -1: {
                charset2 = charset;
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return charset2;
    }

    public static final int checkDuration(@NotNull String name, long duration, @Nullable TimeUnit unit) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        if (!(duration >= 0L)) {
            boolean $i$a$-check-Util$checkDuration$32 = false;
            String $i$a$-check-Util$checkDuration$32 = name + " < 0";
            throw new IllegalStateException($i$a$-check-Util$checkDuration$32.toString());
        }
        if (!(unit != null)) {
            boolean bl = false;
            String string = "unit == null";
            throw new IllegalStateException(string.toString());
        }
        long millis = unit.toMillis(duration);
        if (!(millis <= Integer.MAX_VALUE)) {
            boolean $i$a$-require-Util$checkDuration$52 = false;
            String $i$a$-require-Util$checkDuration$52 = name + " too large.";
            throw new IllegalArgumentException($i$a$-require-Util$checkDuration$52.toString());
        }
        if (!(millis != 0L || duration <= 0L)) {
            boolean bl = false;
            String string = name + " too small.";
            throw new IllegalArgumentException(string.toString());
        }
        return (int)millis;
    }

    public static final int parseHexDigit(char $this$parseHexDigit) {
        int n;
        block1: {
            char c;
            block0: {
                c = $this$parseHexDigit;
                boolean bl = '0' <= c ? c < ':' : false;
                if (!bl) break block0;
                n = $this$parseHexDigit - 48;
                break block1;
            }
            n = ('a' <= c ? c < 'g' : false) ? $this$parseHexDigit - 97 + 10 : (('A' <= c ? c < 'G' : false) ? $this$parseHexDigit - 65 + 10 : -1);
        }
        return n;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> $this$toHeaders) {
        Intrinsics.checkNotNullParameter($this$toHeaders, (String)"<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : $this$toHeaders) {
            ByteString name = header.component1();
            ByteString value = header.component2();
            builder.addLenient$okhttp(name.utf8(), value.utf8());
        }
        return builder.build();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers $this$toHeaderList) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toHeaderList, (String)"<this>");
        Iterable $this$map$iv = (Iterable)RangesKt.until((int)0, (int)$this$toHeaderList.size());
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator = $this$mapTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            void it;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)iterator).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add((Object)new Header($this$toHeaderList.name((int)it), $this$toHeaderList.value((int)it)));
        }
        return (List)destination$iv$iv;
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl $this$canReuseConnectionFor, @NotNull HttpUrl other) {
        Intrinsics.checkNotNullParameter((Object)$this$canReuseConnectionFor, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Intrinsics.areEqual((Object)$this$canReuseConnectionFor.host(), (Object)other.host()) && $this$canReuseConnectionFor.port() == other.port() && Intrinsics.areEqual((Object)$this$canReuseConnectionFor.scheme(), (Object)other.scheme());
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull EventListener $this$asFactory) {
        Intrinsics.checkNotNullParameter((Object)$this$asFactory, (String)"<this>");
        return arg_0 -> Util.asFactory$lambda$8($this$asFactory, arg_0);
    }

    public static final int and(byte $this$and, int mask) {
        return $this$and & mask;
    }

    public static final int and(short $this$and, int mask) {
        return $this$and & mask;
    }

    public static final long and(int $this$and, long mask) {
        return (long)$this$and & mask;
    }

    public static final void writeMedium(@NotNull BufferedSink $this$writeMedium, int medium) throws IOException {
        Intrinsics.checkNotNullParameter((Object)$this$writeMedium, (String)"<this>");
        $this$writeMedium.writeByte(medium >>> 16 & 0xFF);
        $this$writeMedium.writeByte(medium >>> 8 & 0xFF);
        $this$writeMedium.writeByte(medium & 0xFF);
    }

    public static final int readMedium(@NotNull BufferedSource $this$readMedium) throws IOException {
        Intrinsics.checkNotNullParameter((Object)$this$readMedium, (String)"<this>");
        return Util.and($this$readMedium.readByte(), 255) << 16 | Util.and($this$readMedium.readByte(), 255) << 8 | Util.and($this$readMedium.readByte(), 255);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final boolean skipAll(@NotNull Source $this$skipAll, int duration, @NotNull TimeUnit timeUnit) throws IOException {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$skipAll, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)timeUnit, (String)"timeUnit");
        long nowNs = System.nanoTime();
        long originalDurationNs = $this$skipAll.timeout().hasDeadline() ? $this$skipAll.timeout().deadlineNanoTime() - nowNs : Long.MAX_VALUE;
        $this$skipAll.timeout().deadlineNanoTime(nowNs + Math.min((long)originalDurationNs, (long)timeUnit.toNanos((long)duration)));
        try {
            Buffer skipBuffer = new Buffer();
            while ($this$skipAll.read(skipBuffer, 8192L) != -1L) {
                skipBuffer.clear();
            }
            bl = true;
        }
        catch (InterruptedIOException _) {
            bl = false;
        }
        finally {
            if (originalDurationNs == Long.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
        }
        return bl;
    }

    public static final boolean discard(@NotNull Source $this$discard, int timeout2, @NotNull TimeUnit timeUnit) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$discard, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)timeUnit, (String)"timeUnit");
        try {
            bl = Util.skipAll($this$discard, timeout2, timeUnit);
        }
        catch (IOException _) {
            bl = false;
        }
        return bl;
    }

    @NotNull
    public static final String peerName(@NotNull Socket $this$peerName) {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$peerName, (String)"<this>");
        SocketAddress address = $this$peerName.getRemoteSocketAddress();
        if (address instanceof InetSocketAddress) {
            String string2 = ((InetSocketAddress)address).getHostName();
            string = string2;
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"address.hostName");
        } else {
            string = address.toString();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final boolean isHealthy(@NotNull Socket $this$isHealthy, @NotNull BufferedSource source2) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$isHealthy, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        try {
            boolean bl2;
            int readTimeout = $this$isHealthy.getSoTimeout();
            try {
                $this$isHealthy.setSoTimeout(1);
                bl2 = !source2.exhausted();
            }
            finally {
                $this$isHealthy.setSoTimeout(readTimeout);
            }
            bl = bl2;
        }
        catch (SocketTimeoutException _) {
            bl = true;
        }
        catch (IOException _) {
            bl = false;
        }
        return bl;
    }

    public static final void ignoreIoExceptions(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        boolean $i$f$ignoreIoExceptions = false;
        try {
            block.invoke();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void threadName(@NotNull String name, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        boolean $i$f$threadName = false;
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        }
        finally {
            InlineMarker.finallyStart((int)1);
            currentThread.setName(oldName);
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static final int skipAll(@NotNull Buffer $this$skipAll, byte b) {
        Intrinsics.checkNotNullParameter((Object)$this$skipAll, (String)"<this>");
        int count = 0;
        while (!$this$skipAll.exhausted() && $this$skipAll.getByte(0L) == b) {
            ++count;
            $this$skipAll.readByte();
        }
        return count;
    }

    public static final int indexOfNonWhitespace(@NotNull String $this$indexOfNonWhitespace, int startIndex) {
        Intrinsics.checkNotNullParameter((Object)$this$indexOfNonWhitespace, (String)"<this>");
        int n = $this$indexOfNonWhitespace.length();
        for (int i = startIndex; i < n; ++i) {
            char c = $this$indexOfNonWhitespace.charAt(i);
            if (c == ' ' || c == '\t') continue;
            return i;
        }
        return $this$indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String string, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        return Util.indexOfNonWhitespace(string, n);
    }

    public static final long headersContentLength(@NotNull Response $this$headersContentLength) {
        Intrinsics.checkNotNullParameter((Object)$this$headersContentLength, (String)"<this>");
        String string = $this$headersContentLength.headers().get("Content-Length");
        return string != null ? Util.toLongOrDefault(string, -1L) : -1L;
    }

    public static final long toLongOrDefault(@NotNull String $this$toLongOrDefault, long defaultValue) {
        long l;
        Intrinsics.checkNotNullParameter((Object)$this$toLongOrDefault, (String)"<this>");
        try {
            l = Long.parseLong((String)$this$toLongOrDefault);
        }
        catch (NumberFormatException _) {
            l = defaultValue;
        }
        return l;
    }

    public static final int toNonNegativeInt(@Nullable String $this$toNonNegativeInt, int defaultValue) {
        try {
            String string = $this$toNonNegativeInt;
            if (string == null) {
                return defaultValue;
            }
            long value = Long.parseLong((String)string);
            return value > Integer.MAX_VALUE ? Integer.MAX_VALUE : (value < 0L ? 0 : (int)value);
        }
        catch (NumberFormatException _) {
            return defaultValue;
        }
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> $this$toImmutableList) {
        Intrinsics.checkNotNullParameter($this$toImmutableList, (String)"<this>");
        List list = Collections.unmodifiableList((List)CollectionsKt.toMutableList((Collection)((Collection)$this$toImmutableList)));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"unmodifiableList(toMutableList())");
        return list;
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(T ... elements) {
        Intrinsics.checkNotNullParameter(elements, (String)"elements");
        Object[] objectArray = (Object[])elements.clone();
        List list = Collections.unmodifiableList((List)CollectionsKt.listOf((Object[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length)));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"unmodifiableList(listOf(*elements.clone()))");
        return list;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> $this$toImmutableMap) {
        Map map;
        Intrinsics.checkNotNullParameter($this$toImmutableMap, (String)"<this>");
        if ($this$toImmutableMap.isEmpty()) {
            map = MapsKt.emptyMap();
        } else {
            Map map2 = Collections.unmodifiableMap((Map)((Map)new LinkedHashMap($this$toImmutableMap)));
            map = map2;
            Intrinsics.checkNotNullExpressionValue((Object)map2, (String)"{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        }
        return map;
    }

    public static final void closeQuietly(@NotNull Closeable $this$closeQuietly) {
        Intrinsics.checkNotNullParameter((Object)$this$closeQuietly, (String)"<this>");
        try {
            $this$closeQuietly.close();
        }
        catch (RuntimeException rethrown) {
            throw rethrown;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void closeQuietly(@NotNull Socket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter((Object)$this$closeQuietly, (String)"<this>");
        try {
            $this$closeQuietly.close();
        }
        catch (AssertionError e) {
            throw e;
        }
        catch (RuntimeException rethrown) {
            if (Intrinsics.areEqual((Object)rethrown.getMessage(), (Object)"bio == null")) {
                return;
            }
            throw rethrown;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter((Object)$this$closeQuietly, (String)"<this>");
        try {
            $this$closeQuietly.close();
        }
        catch (RuntimeException rethrown) {
            throw rethrown;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Exception decompiling
     */
    public static final boolean isCivilized(@NotNull FileSystem $this$isCivilized, @NotNull File file) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Unknown Source:65)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Unknown Source:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Unknown Source:39)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(Unknown Source:1424)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(Unknown Source:6)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(Unknown Source:94)
         *     at android.s.ۥۣۢۧ.ۥ۟۟(Unknown Source:10)
         *     at org.benf.cfr.reader.entities.Method.ۥ۟۟۟(Unknown Source:4)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:91)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۨ(Unknown Source:0)
         *     at android.s.ۦۦ۟.ۥ۟۟۟(Unknown Source:190)
         *     at android.s.ۦۦ۟.ۥ۟۟(Unknown Source:144)
         *     at android.s.ۥۧۥ۟.ۥ(Unknown Source:107)
         *     at android.s.ۥۦۨۡ.ۥ(Unknown Source:83)
         *     at com.efs.sdk.pa.a.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁣⁠⁠⁤⁠⁠⁣⁣⁣⁣⁣⁠.⁣⁤⁠⁠⁠⁠⁣⁣⁣⁠⁠⁤⁠⁣⁤⁤⁠⁤⁤⁠⁠⁠⁣⁣⁠(Unknown Source:8)
         *     at android.s.ۥۦۨ۠.ۥ۟(Unknown Source:53)
         *     at org.apache.commons.lang3.builder.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁤⁠⁤⁤⁤⁠⁤⁠⁠⁠⁣.⁣⁤⁠⁠⁠⁣⁤⁤⁣⁤⁤⁤⁣⁤⁠⁠⁤⁤⁤⁠⁤⁤⁠⁠⁣⁠⁠⁠⁣⁣⁣(Unknown Source:10)
         *     at android.s.ۥۦۨ۠.ۥ(Unknown Source:99)
         *     at org.apache.xerces.xni.parser.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁣⁤⁤⁠⁤⁤.⁠⁣⁤⁣⁤⁠⁣⁤⁠⁠⁠⁣⁣⁤⁤⁣⁠(Unknown Source:8)
         *     at android.s.go$ۥ۟۟۠$ۥ.run(Unknown Source:92)
         *     at java.lang.Thread.run(Thread.java:1012)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @NotNull
    public static final String toHexString(long $this$toHexString) {
        String string = Long.toHexString((long)$this$toHexString);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toHexString(this)");
        return string;
    }

    @NotNull
    public static final String toHexString(int $this$toHexString) {
        String string = Integer.toHexString((int)$this$toHexString);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toHexString(this)");
        return string;
    }

    public static final void wait(@NotNull Object $this$wait) {
        Intrinsics.checkNotNullParameter((Object)$this$wait, (String)"<this>");
        boolean $i$f$wait = false;
        $this$wait.wait();
    }

    public static final void notify(@NotNull Object $this$notify) {
        Intrinsics.checkNotNullParameter((Object)$this$notify, (String)"<this>");
        boolean $i$f$notify = false;
        $this$notify.notify();
    }

    public static final void notifyAll(@NotNull Object $this$notifyAll) {
        Intrinsics.checkNotNullParameter((Object)$this$notifyAll, (String)"<this>");
        boolean $i$f$notifyAll = false;
        $this$notifyAll.notifyAll();
    }

    @Nullable
    public static final <T> T readFieldOrNull(@NotNull Object instance, @NotNull Class<T> fieldType, @NotNull String fieldName) {
        Object delegate;
        Intrinsics.checkNotNullParameter((Object)instance, (String)"instance");
        Intrinsics.checkNotNullParameter(fieldType, (String)"fieldType");
        Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
        Class c = instance.getClass();
        while (!Intrinsics.areEqual((Object)c, Object.class)) {
            try {
                Field field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(instance);
                return (T)(!fieldType.isInstance(value) ? null : fieldType.cast(value));
            }
            catch (NoSuchFieldException field) {
                Intrinsics.checkNotNullExpressionValue((Object)c.getSuperclass(), (String)"c.superclass");
            }
        }
        if (!Intrinsics.areEqual((Object)fieldName, (Object)"delegate") && (delegate = Util.readFieldOrNull(instance, Object.class, "delegate")) != null) {
            return Util.readFieldOrNull(delegate, fieldType, fieldName);
        }
        return null;
    }

    public static final <E> void addIfAbsent(@NotNull List<E> $this$addIfAbsent, E element) {
        Intrinsics.checkNotNullParameter($this$addIfAbsent, (String)"<this>");
        if (!$this$addIfAbsent.contains(element)) {
            $this$addIfAbsent.add(element);
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object $this$assertThreadHoldsLock) {
        Intrinsics.checkNotNullParameter((Object)$this$assertThreadHoldsLock, (String)"<this>");
        boolean $i$f$assertThreadHoldsLock = false;
        if (assertionsEnabled && !Thread.holdsLock((Object)$this$assertThreadHoldsLock)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertThreadHoldsLock));
        }
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object $this$assertThreadDoesntHoldLock) {
        Intrinsics.checkNotNullParameter((Object)$this$assertThreadDoesntHoldLock, (String)"<this>");
        boolean $i$f$assertThreadDoesntHoldLock = false;
        if (assertionsEnabled && Thread.holdsLock((Object)$this$assertThreadDoesntHoldLock)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock));
        }
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception $this$withSuppressed, @NotNull List<? extends Exception> suppressed) {
        Exception exception;
        Intrinsics.checkNotNullParameter((Object)((Object)$this$withSuppressed), (String)"<this>");
        Intrinsics.checkNotNullParameter(suppressed, (String)"suppressed");
        Exception $this$withSuppressed_u24lambda_u2410 = exception = $this$withSuppressed;
        boolean bl = false;
        for (Exception e : suppressed) {
            ExceptionsKt.addSuppressed((Throwable)$this$withSuppressed_u24lambda_u2410, (Throwable)e);
        }
        return exception;
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> $this$filterList, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterList, (String)"<this>");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        boolean $i$f$filterList = false;
        List result = CollectionsKt.emptyList();
        for (Object i : $this$filterList) {
            if (!((Boolean)predicate.invoke(i)).booleanValue()) continue;
            if (result.isEmpty()) {
                result = (List)new ArrayList();
            }
            List list = result;
            Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
            TypeIntrinsics.asMutableList((Object)list).add(i);
        }
        return result;
    }

    private static final Thread threadFactory$lambda$1(String $name, boolean $daemon, Runnable runnable2) {
        Thread thread;
        Intrinsics.checkNotNullParameter((Object)$name, (String)"$name");
        Thread $this$threadFactory_u24lambda_u241_u24lambda_u240 = thread = new Thread(runnable2, $name);
        boolean bl = false;
        $this$threadFactory_u24lambda_u241_u24lambda_u240.setDaemon($daemon);
        return thread;
    }

    private static final EventListener asFactory$lambda$8(EventListener $this_asFactory, Call it) {
        Intrinsics.checkNotNullParameter((Object)$this_asFactory, (String)"$this_asFactory");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return $this_asFactory;
    }

    static {
        ByteString[] byteStringArray = new ByteString[]{ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000")};
        UNICODE_BOMS = Options.Companion.of(byteStringArray);
        TimeZone timeZone = TimeZone.getTimeZone((String)"GMT");
        Intrinsics.checkNotNull((Object)timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = OkHttpClient.class.desiredAssertionStatus();
        String string = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix((String)StringsKt.removePrefix((String)string, (CharSequence)"okhttp3."), (CharSequence)"Client");
    }
}

