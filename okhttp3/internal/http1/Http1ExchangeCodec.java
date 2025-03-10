/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.Proxy$Type
 *  java.util.concurrent.TimeUnit
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n\n\n \n\n \n\n \n\n\b\n\n\b\n\n \n\t\n \n\n\b\n\n\b\n\n \n\n\b\b\n\n\b\n\n \n\n\b\n\n\b\n\n\b\t\n\n\b\n\b\n\b  R20:STURVWXB)\b000\t0\b¢\b\nJ\r0\fH¢\b\rJ02020H¢\bJ0\f20H¢\bJ0\fH¢\bJ0\fH¢\bJ0H¢\bJ!0 20H¢\b!\"J$0 2#0H¢\b$%J&0H¢\b&J'0 H¢\b'(J+0 2*0)H¢\b+,J00/2.0-H¢\b01J202*0)H¢\b23J40\f2*0)¢\b45J706H¢\b78J<0\f29062;0:¢\b<=J>0\f20H¢\b>?R08X¢\n\b@R08X¢\f\n\bA\bBCRE0D8X¢\n\bEFRG0-8F¢\bGHR\t0\b8X¢\n\b\tIR08X¢\n\bJRL0K8@X¢\n\bLMR7068@X¢\n\b7NRO0-*08BX¢\bOPRO0-*0)8BX¢\bOQ¨Y"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "sink", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "", "cancel", "()V", "Lokhttp3/Request;", "request", "", "contentLength", "Lokio/Sink;", "createRequestBody", "(Lokhttp3/Request;J)Lokio/Sink;", "Lokio/ForwardingTimeout;", "timeout", "detachTimeout", "(Lokio/ForwardingTimeout;)V", "finishRequest", "flushRequest", "newChunkedSink", "()Lokio/Sink;", "Lokhttp3/HttpUrl;", "url", "Lokio/Source;", "newChunkedSource", "(Lokhttp3/HttpUrl;)Lokio/Source;", "length", "newFixedLengthSource", "(J)Lokio/Source;", "newKnownLengthSink", "newUnknownLengthSource", "()Lokio/Source;", "Lokhttp3/Response;", "response", "openResponseBodySource", "(Lokhttp3/Response;)Lokio/Source;", "", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "reportedContentLength", "(Lokhttp3/Response;)J", "skipConnectBody", "(Lokhttp3/Response;)V", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "headers", "", "requestLine", "writeRequest", "(Lokhttp3/Headers;Ljava/lang/String;)V", "writeRequestHeaders", "(Lokhttp3/Request;)V", "Lokhttp3/OkHttpClient;", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http1/HeadersReader;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "isClosed", "()Z", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "", "state", "I", "Lokhttp3/Headers;", "isChunked", "(Lokhttp3/Request;)Z", "(Lokhttp3/Response;)Z", "Companion", "AbstractSource", "ChunkedSink", "ChunkedSource", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"})
@SourceDebugExtension(value={"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
public final class Http1ExchangeCodec
implements ExchangeCodec {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final OkHttpClient client;
    @NotNull
    private final RealConnection connection;
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final BufferedSink sink;
    private int state;
    @NotNull
    private final HeadersReader headersReader;
    @Nullable
    private Headers trailers;
    private static final long NO_CHUNK_YET = -1L;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_CLOSED = 6;

    public Http1ExchangeCodec(@Nullable OkHttpClient client, @NotNull RealConnection connection, @NotNull BufferedSource source2, @NotNull BufferedSink sink2) {
        Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        this.client = client;
        this.connection = connection;
        this.source = source2;
        this.sink = sink2;
        this.headersReader = new HeadersReader(this.source);
    }

    @Override
    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    private final boolean isChunked(Response $this$isChunked) {
        return StringsKt.equals((String)"chunked", (String)Response.header$default($this$isChunked, "Transfer-Encoding", null, 2, null), (boolean)true);
    }

    private final boolean isChunked(Request $this$isChunked) {
        return StringsKt.equals((String)"chunked", (String)$this$isChunked.header("Transfer-Encoding"), (boolean)true);
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @Override
    @NotNull
    public Sink createRequestBody(@NotNull Request request, long contentLength) {
        Sink sink2;
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        if (request.body() != null && request.body().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (this.isChunked(request)) {
            sink2 = this.newChunkedSink();
        } else if (contentLength != -1L) {
            sink2 = this.newKnownLengthSink();
        } else {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        return sink2;
    }

    @Override
    public void cancel() {
        this.getConnection().cancel();
    }

    @Override
    public void writeRequestHeaders(@NotNull Request request) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        Proxy.Type type = this.getConnection().route().proxy().type();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"connection.route().proxy.type()");
        String requestLine = RequestLine.INSTANCE.get(request, type);
        this.writeRequest(request.headers(), requestLine);
    }

    @Override
    public long reportedContentLength(@NotNull Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        return !HttpHeaders.promisesBody(response) ? 0L : (this.isChunked(response) ? -1L : Util.headersContentLength(response));
    }

    @Override
    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        long contentLength;
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        return !HttpHeaders.promisesBody(response) ? this.newFixedLengthSource(0L) : (this.isChunked(response) ? this.newChunkedSource(response.request().url()) : ((contentLength = Util.headersContentLength(response)) != -1L ? this.newFixedLengthSource(contentLength) : this.newUnknownLengthSource()));
    }

    @Override
    @NotNull
    public Headers trailers() {
        if (!(this.state == 6)) {
            boolean bl = false;
            String string = "too early; can't read the trailers yet";
            throw new IllegalStateException(string.toString());
        }
        Headers headers = this.trailers;
        if (headers == null) {
            headers = Util.EMPTY_HEADERS;
        }
        return headers;
    }

    @Override
    public void flushRequest() {
        this.sink.flush();
    }

    @Override
    public void finishRequest() {
        this.sink.flush();
    }

    public final void writeRequest(@NotNull Headers headers, @NotNull String requestLine) {
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        Intrinsics.checkNotNullParameter((Object)requestLine, (String)"requestLine");
        if (!(this.state == 0)) {
            boolean bl = false;
            String string = "state: " + this.state;
            throw new IllegalStateException(string.toString());
        }
        this.sink.writeUtf8(requestLine).writeUtf8("\r\n");
        int n = headers.size();
        for (int i = 0; i < n; ++i) {
            this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override
    @Nullable
    public Response.Builder readResponseHeaders(boolean expectContinue) {
        if (!(this.state == 1 || this.state == 2 || this.state == 3)) {
            boolean $i$a$-check-Http1ExchangeCodec$readResponseHeaders$22 = false;
            String $i$a$-check-Http1ExchangeCodec$readResponseHeaders$22 = "state: " + this.state;
            throw new IllegalStateException($i$a$-check-Http1ExchangeCodec$readResponseHeaders$22.toString());
        }
        try {
            Response.Builder builder;
            StatusLine statusLine = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder responseBuilder = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(this.headersReader.readHeaders());
            if (expectContinue && statusLine.code == 100) {
                builder = null;
            } else if (statusLine.code == 100) {
                this.state = 3;
                builder = responseBuilder;
            } else {
                int n = statusLine.code;
                boolean bl = 102 <= n ? n < 200 : false;
                if (bl) {
                    this.state = 3;
                    builder = responseBuilder;
                } else {
                    this.state = 4;
                    builder = responseBuilder;
                }
            }
            return builder;
        }
        catch (EOFException e) {
            String address = this.getConnection().route().address().url().redact();
            throw new IOException("unexpected end of stream on " + address, (Throwable)e);
        }
    }

    private final Sink newChunkedSink() {
        if (!(this.state == 1)) {
            boolean bl = false;
            String string = "state: " + this.state;
            throw new IllegalStateException(string.toString());
        }
        this.state = 2;
        return new ChunkedSink();
    }

    private final Sink newKnownLengthSink() {
        if (!(this.state == 1)) {
            boolean bl = false;
            String string = "state: " + this.state;
            throw new IllegalStateException(string.toString());
        }
        this.state = 2;
        return new KnownLengthSink();
    }

    private final Source newFixedLengthSource(long length) {
        if (!(this.state == 4)) {
            boolean bl = false;
            String string = "state: " + this.state;
            throw new IllegalStateException(string.toString());
        }
        this.state = 5;
        return new FixedLengthSource(length);
    }

    private final Source newChunkedSource(HttpUrl url) {
        if (!(this.state == 4)) {
            boolean bl = false;
            String string = "state: " + this.state;
            throw new IllegalStateException(string.toString());
        }
        this.state = 5;
        return new ChunkedSource(url);
    }

    private final Source newUnknownLengthSource() {
        if (!(this.state == 4)) {
            boolean bl = false;
            String string = "state: " + this.state;
            throw new IllegalStateException(string.toString());
        }
        this.state = 5;
        this.getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource();
    }

    private final void detachTimeout(ForwardingTimeout timeout2) {
        Timeout oldDelegate = timeout2.delegate();
        timeout2.setDelegate(Timeout.NONE);
        oldDelegate.clearDeadline();
        oldDelegate.clearTimeout();
    }

    public final void skipConnectBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        long contentLength = Util.headersContentLength(response);
        if (contentLength == -1L) {
            return;
        }
        Source body = this.newFixedLengthSource(contentLength);
        Util.skipAll(body, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        body.close();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" :\n\n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\n\n\b\n\n\b\b¢ 20B¢\bJ\b02020H¢\b\b\tJ\r0\n¢\b\fJ0\rH¢\bR\"08@X¢\n\b\b\"\bR08X¢\f\n\b\b¨"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokio/Source;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "", "responseBodyComplete", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "Lokio/ForwardingTimeout;", "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "okhttp"})
    private abstract class AbstractSource
    implements Source {
        @NotNull
        private final ForwardingTimeout timeout;
        private boolean closed;

        public AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.source.timeout());
        }

        @NotNull
        protected final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        protected final boolean getClosed() {
            return this.closed;
        }

        protected final void setClosed(boolean bl) {
            this.closed = bl;
        }

        @Override
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public long read(@NotNull Buffer sink2, long byteCount) {
            long l;
            Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
            try {
                l = Http1ExchangeCodec.this.source.read(sink2, byteCount);
            }
            catch (IOException e) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                this.responseBodyComplete();
                throw e;
            }
            return l;
        }

        public final void responseBodyComplete() {
            if (Http1ExchangeCodec.this.state == 6) {
                return;
            }
            if (Http1ExchangeCodec.this.state != 5) {
                throw new IllegalStateException("state: " + Http1ExchangeCodec.this.state);
            }
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 6;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" :\n\n\n\b\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\b 20B¢\bJ0H¢\bJ0H¢\bJ\t0\bH¢\b\t\nJ02\f020\rH¢\bR08@X¢\n\bR\t08X¢\n\b\t¨"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lokio/Sink;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "", "close", "()V", "flush", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokio/Buffer;", "source", "", "byteCount", "write", "(Lokio/Buffer;J)V", "", "closed", "Z", "Lokio/ForwardingTimeout;", "Lokio/ForwardingTimeout;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class ChunkedSink
    implements Sink {
        @NotNull
        private final ForwardingTimeout timeout;
        private boolean closed;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public void write(@NotNull Buffer source2, long byteCount) {
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            if (!(!this.closed)) {
                boolean bl = false;
                String string = "closed";
                throw new IllegalStateException(string.toString());
            }
            if (byteCount == 0L) {
                return;
            }
            Http1ExchangeCodec.this.sink.writeHexadecimalUnsignedLong(byteCount);
            Http1ExchangeCodec.this.sink.writeUtf8("\r\n");
            Http1ExchangeCodec.this.sink.write(source2, byteCount);
            Http1ExchangeCodec.this.sink.writeUtf8("\r\n");
        }

        @Override
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.sink.writeUtf8("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 2\n\n\n\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\b 20R0B0¢\bJ\b0H¢\b\b\tJ0\f20\n2\r0\fH¢\bJ0H¢\b\tR0\f8@X¢\n\bR08@X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/HttpUrl;", "url", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "", "close", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "readChunkSize", "bytesRemainingInChunk", "J", "", "hasMoreChunks", "Z", "Lokhttp3/HttpUrl;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class ChunkedSource
    extends AbstractSource {
        @NotNull
        private final HttpUrl url;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;

        public ChunkedSource(HttpUrl url) {
            Intrinsics.checkNotNullParameter((Object)url, (String)"url");
            this.url = url;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        @Override
        public long read(@NotNull Buffer sink2, long byteCount) {
            long read;
            Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
            if (!(byteCount >= 0L)) {
                boolean $i$a$-require-Http1ExchangeCodec$ChunkedSource$read$22 = false;
                String $i$a$-require-Http1ExchangeCodec$ChunkedSource$read$22 = "byteCount < 0: " + byteCount;
                throw new IllegalArgumentException($i$a$-require-Http1ExchangeCodec$ChunkedSource$read$22.toString());
            }
            if (!(!this.getClosed())) {
                boolean bl = false;
                String string = "closed";
                throw new IllegalStateException(string.toString());
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            if (this.bytesRemainingInChunk == 0L || this.bytesRemainingInChunk == -1L) {
                this.readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            if ((read = super.read(sink2, Math.min((long)byteCount, (long)this.bytesRemainingInChunk))) == -1L) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                ProtocolException e = new ProtocolException("unexpected end of stream");
                this.responseBodyComplete();
                throw e;
            }
            this.bytesRemainingInChunk -= read;
            return read;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk != -1L) {
                Http1ExchangeCodec.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1ExchangeCodec.this.source.readHexadecimalUnsignedLong();
                String extensions = StringsKt.trim((CharSequence)Http1ExchangeCodec.this.source.readUtf8LineStrict()).toString();
                if (this.bytesRemainingInChunk < 0L || ((CharSequence)extensions).length() > 0 && !StringsKt.startsWith$default((String)extensions, (String)";", (boolean)false, (int)2, null)) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + extensions + '\"');
                }
            }
            catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
            if (this.bytesRemainingInChunk == 0L) {
                this.hasMoreChunks = false;
                Http1ExchangeCodec.this.trailers = Http1ExchangeCodec.this.headersReader.readHeaders();
                OkHttpClient okHttpClient = Http1ExchangeCodec.this.client;
                Intrinsics.checkNotNull((Object)okHttpClient);
                CookieJar cookieJar = okHttpClient.cookieJar();
                Headers headers = Http1ExchangeCodec.this.trailers;
                Intrinsics.checkNotNull((Object)headers);
                HttpHeaders.receiveHeaders(cookieJar, this.url, headers);
                this.responseBodyComplete();
            }
        }

        @Override
        public void close() {
            if (this.getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                this.responseBodyComplete();
            }
            this.setClosed(true);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\t\n\b\n\b\n\b\t\b 20B\t\b¢\bR08XT¢\n\bR\b08XT¢\n\b\b\tR\n08XT¢\n\b\n\tR08XT¢\n\b\tR\f08XT¢\n\b\f\tR\r08XT¢\n\b\r\tR08XT¢\n\b\tR08XT¢\n\b\t¨"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "<init>", "()V", "", "NO_CHUNK_YET", "J", "", "STATE_CLOSED", "I", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" $\n\n\n\n\t\n\b\n\n\b\n\n\b\b 20R0B0¢\bJ\b0H¢\b\b\tJ\r020\n2\f0H¢\b\rR08@X¢\n\b¨"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "", "bytesRemaining", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "", "close", "()V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "J", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class FixedLengthSource
    extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long bytesRemaining) {
            this.bytesRemaining = bytesRemaining;
            if (this.bytesRemaining == 0L) {
                this.responseBodyComplete();
            }
        }

        @Override
        public long read(@NotNull Buffer sink2, long byteCount) {
            Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
            if (!(byteCount >= 0L)) {
                boolean $i$a$-require-Http1ExchangeCodec$FixedLengthSource$read$22 = false;
                String $i$a$-require-Http1ExchangeCodec$FixedLengthSource$read$22 = "byteCount < 0: " + byteCount;
                throw new IllegalArgumentException($i$a$-require-Http1ExchangeCodec$FixedLengthSource$read$22.toString());
            }
            if (!(!this.getClosed())) {
                boolean bl = false;
                String string = "closed";
                throw new IllegalStateException(string.toString());
            }
            if (this.bytesRemaining == 0L) {
                return -1L;
            }
            long read = super.read(sink2, Math.min((long)this.bytesRemaining, (long)byteCount));
            if (read == -1L) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                ProtocolException e = new ProtocolException("unexpected end of stream");
                this.responseBodyComplete();
                throw e;
            }
            this.bytesRemaining -= read;
            if (this.bytesRemaining == 0L) {
                this.responseBodyComplete();
            }
            return read;
        }

        @Override
        public void close() {
            if (this.getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0L && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                this.responseBodyComplete();
            }
            this.setClosed(true);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" :\n\n\n\b\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\b 20B¢\bJ0H¢\bJ0H¢\bJ\t0\bH¢\b\t\nJ02\f020\rH¢\bR08@X¢\n\bR\t08X¢\n\b\t¨"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lokio/Sink;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "", "close", "()V", "flush", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokio/Buffer;", "source", "", "byteCount", "write", "(Lokio/Buffer;J)V", "", "closed", "Z", "Lokio/ForwardingTimeout;", "Lokio/ForwardingTimeout;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class KnownLengthSink
    implements Sink {
        @NotNull
        private final ForwardingTimeout timeout;
        private boolean closed;

        public KnownLengthSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public void write(@NotNull Buffer source2, long byteCount) {
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            if (!(!this.closed)) {
                boolean bl = false;
                String string = "closed";
                throw new IllegalStateException(string.toString());
            }
            Util.checkOffsetAndCount(source2.size(), 0L, byteCount);
            Http1ExchangeCodec.this.sink.write(source2, byteCount);
        }

        @Override
        public void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" .\n\n\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\b 20R0B¢\bJ0H¢\bJ\f0\n2\t0\b20\nH¢\b\f\rR08@X¢\n\b¨"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "", "close", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "", "inputExhausted", "Z", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class UnknownLengthSource
    extends AbstractSource {
        private boolean inputExhausted;

        @Override
        public long read(@NotNull Buffer sink2, long byteCount) {
            Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
            if (!(byteCount >= 0L)) {
                boolean $i$a$-require-Http1ExchangeCodec$UnknownLengthSource$read$22 = false;
                String $i$a$-require-Http1ExchangeCodec$UnknownLengthSource$read$22 = "byteCount < 0: " + byteCount;
                throw new IllegalArgumentException($i$a$-require-Http1ExchangeCodec$UnknownLengthSource$read$22.toString());
            }
            if (!(!this.getClosed())) {
                boolean bl = false;
                String string = "closed";
                throw new IllegalStateException(string.toString());
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long read = super.read(sink2, byteCount);
            if (read == -1L) {
                this.inputExhausted = true;
                this.responseBodyComplete();
                return -1L;
            }
            return read;
        }

        @Override
        public void close() {
            if (this.getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                this.responseBodyComplete();
            }
            this.setClosed(true);
        }
    }
}

