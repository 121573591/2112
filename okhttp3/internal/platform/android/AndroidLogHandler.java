/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.logging.Handler
 *  java.util.logging.LogRecord
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.platform.android.AndroidLogKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n\n\b\n\n\b\n\n\b\bÆ 20B\t\b¢\bJ0H¢\bJ0H¢\bJ\t02\b0H¢\b\t\n¨"}, d2={"Lokhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "<init>", "()V", "", "close", "flush", "Ljava/util/logging/LogRecord;", "record", "publish", "(Ljava/util/logging/LogRecord;)V", "okhttp"})
public final class AndroidLogHandler
extends Handler {
    @NotNull
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    public void publish(@NotNull LogRecord record) {
        Intrinsics.checkNotNullParameter((Object)record, (String)"record");
        String string = record.getLoggerName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"record.loggerName");
        int n = AndroidLogKt.access$getAndroidLevel(record);
        String string2 = record.getMessage();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"record.message");
        AndroidLog.INSTANCE.androidLog$okhttp(string, n, string2, record.getThrown());
    }

    public void flush() {
    }

    public void close() {
    }
}

