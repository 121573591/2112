/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n\n\b\n\b\b  \t2\b0 0:\tB\b0¢\bR08¢\f\n\b\b\bj\b\nj\bj\b\fj\b\rj\bj\bj\bj\bj\bj\bj\bj\bj\bj\b¨"}, d2={"Lokhttp3/internal/http2/ErrorCode;", "", "", "httpCode", "<init>", "(Ljava/lang/String;II)V", "I", "getHttpCode", "()I", "Companion", "NO_ERROR", "PROTOCOL_ERROR", "INTERNAL_ERROR", "FLOW_CONTROL_ERROR", "SETTINGS_TIMEOUT", "STREAM_CLOSED", "FRAME_SIZE_ERROR", "REFUSED_STREAM", "CANCEL", "COMPRESSION_ERROR", "CONNECT_ERROR", "ENHANCE_YOUR_CALM", "INADEQUATE_SECURITY", "HTTP_1_1_REQUIRED", "okhttp"})
public final class ErrorCode
extends Enum<ErrorCode> {
    @NotNull
    public static final Companion Companion;
    private final int httpCode;
    public static final /* enum */ ErrorCode NO_ERROR;
    public static final /* enum */ ErrorCode PROTOCOL_ERROR;
    public static final /* enum */ ErrorCode INTERNAL_ERROR;
    public static final /* enum */ ErrorCode FLOW_CONTROL_ERROR;
    public static final /* enum */ ErrorCode SETTINGS_TIMEOUT;
    public static final /* enum */ ErrorCode STREAM_CLOSED;
    public static final /* enum */ ErrorCode FRAME_SIZE_ERROR;
    public static final /* enum */ ErrorCode REFUSED_STREAM;
    public static final /* enum */ ErrorCode CANCEL;
    public static final /* enum */ ErrorCode COMPRESSION_ERROR;
    public static final /* enum */ ErrorCode CONNECT_ERROR;
    public static final /* enum */ ErrorCode ENHANCE_YOUR_CALM;
    public static final /* enum */ ErrorCode INADEQUATE_SECURITY;
    public static final /* enum */ ErrorCode HTTP_1_1_REQUIRED;
    private static final /* synthetic */ ErrorCode[] $VALUES;

    private ErrorCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }

    public static ErrorCode[] values() {
        return (ErrorCode[])$VALUES.clone();
    }

    public static ErrorCode valueOf(String value) {
        return (ErrorCode)Enum.valueOf(ErrorCode.class, (String)value);
    }

    static {
        NO_ERROR = new ErrorCode(0);
        PROTOCOL_ERROR = new ErrorCode(1);
        INTERNAL_ERROR = new ErrorCode(2);
        FLOW_CONTROL_ERROR = new ErrorCode(3);
        SETTINGS_TIMEOUT = new ErrorCode(4);
        STREAM_CLOSED = new ErrorCode(5);
        FRAME_SIZE_ERROR = new ErrorCode(6);
        REFUSED_STREAM = new ErrorCode(7);
        CANCEL = new ErrorCode(8);
        COMPRESSION_ERROR = new ErrorCode(9);
        CONNECT_ERROR = new ErrorCode(10);
        ENHANCE_YOUR_CALM = new ErrorCode(11);
        INADEQUATE_SECURITY = new ErrorCode(12);
        HTTP_1_1_REQUIRED = new ErrorCode(13);
        $VALUES = errorCodeArray = new ErrorCode[]{ErrorCode.NO_ERROR, ErrorCode.PROTOCOL_ERROR, ErrorCode.INTERNAL_ERROR, ErrorCode.FLOW_CONTROL_ERROR, ErrorCode.SETTINGS_TIMEOUT, ErrorCode.STREAM_CLOSED, ErrorCode.FRAME_SIZE_ERROR, ErrorCode.REFUSED_STREAM, ErrorCode.CANCEL, ErrorCode.COMPRESSION_ERROR, ErrorCode.CONNECT_ERROR, ErrorCode.ENHANCE_YOUR_CALM, ErrorCode.INADEQUATE_SECURITY, ErrorCode.HTTP_1_1_REQUIRED};
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\b\n \n\n\b\b 20B\t\b¢\bJ020¢\b\b¨\t"}, d2={"Lokhttp3/internal/http2/ErrorCode$Companion;", "", "<init>", "()V", "", "code", "Lokhttp3/internal/http2/ErrorCode;", "fromHttp2", "(I)Lokhttp3/internal/http2/ErrorCode;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nErrorCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErrorCode.kt\nokhttp3/internal/http2/ErrorCode$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final ErrorCode fromHttp2(int code) {
            ErrorCode errorCode;
            block1: {
                ErrorCode[] errorCodeArray = ErrorCode.values();
                int n = errorCodeArray.length;
                for (int i = 0; i < n; ++i) {
                    ErrorCode errorCode2;
                    ErrorCode it = errorCode2 = errorCodeArray[i];
                    boolean bl = false;
                    if (!(it.getHttpCode() == code)) continue;
                    errorCode = errorCode2;
                    break block1;
                }
                errorCode = null;
            }
            return errorCode;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

