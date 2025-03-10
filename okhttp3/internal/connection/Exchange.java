/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.net.SocketException
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" |\n\n \n\n \n\n \n\n \n\n\b\n\n \n\t\n \n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n \n\n\b\n\n\b\n\n\b\t\n\n\b 20:STB'000\t0\b¢\b\nJ98 \"\n\b \r*0\f20202028 ¢\bJ\r0¢\bJ02020¢\bJ\r0¢\bJ\r 0¢\b J\r!0¢\b!J\r#0\"¢\b#$J\r%0¢\b%J\r&0¢\b&J*0)2(0'¢\b*+J.0-2,0¢\b./J002(0'¢\b01J\r20¢\b2J3020\fH¢\b34J\r605¢\b67J\r80¢\b8J9020¢\b9:R08 X¢\f\n\b;\b<=R\t0\b8X¢\n\b\t>R@0?8 X¢\f\n\b@A\bBCR08 X¢\f\n\bD\bEFR08 X¢\f\n\bG\bHIR$K02J08 @BX¢\f\n\bKL\bMNRP08@X¢\bONR$Q02J08 @BX¢\f\n\bQL\bRN¨U"}, d2={"Lokhttp3/internal/connection/Exchange;", "", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lokhttp3/internal/http/ExchangeCodec;", "codec", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "Ljava/io/IOException;", "E", "", "bytesRead", "", "responseDone", "requestDone", "e", "bodyComplete", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "", "cancel", "()V", "Lokhttp3/Request;", "request", "duplex", "Lokio/Sink;", "createRequestBody", "(Lokhttp3/Request;Z)Lokio/Sink;", "detachWithViolence", "finishRequest", "flushRequest", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/internal/ws/RealWebSocket$Streams;", "noNewExchangesOnConnection", "noRequestBody", "Lokhttp3/Response;", "response", "Lokhttp3/ResponseBody;", "openResponseBody", "(Lokhttp3/Response;)Lokhttp3/ResponseBody;", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "responseHeadersEnd", "(Lokhttp3/Response;)V", "responseHeadersStart", "trackFailure", "(Ljava/io/IOException;)V", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "webSocketUpgradeFailed", "writeRequestHeaders", "(Lokhttp3/Request;)V", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/internal/http/ExchangeCodec;", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "Lokhttp3/internal/connection/ExchangeFinder;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "hasFailure", "Z", "getHasFailure$okhttp", "()Z", "isCoalescedConnection$okhttp", "isCoalescedConnection", "isDuplex", "isDuplex$okhttp", "RequestBodySink", "ResponseBodySource", "okhttp"})
public final class Exchange {
    @NotNull
    private final RealCall call;
    @NotNull
    private final EventListener eventListener;
    @NotNull
    private final ExchangeFinder finder;
    @NotNull
    private final ExchangeCodec codec;
    private boolean isDuplex;
    private boolean hasFailure;
    @NotNull
    private final RealConnection connection;

    public Exchange(@NotNull RealCall call, @NotNull EventListener eventListener, @NotNull ExchangeFinder finder, @NotNull ExchangeCodec codec) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        Intrinsics.checkNotNullParameter((Object)finder, (String)"finder");
        Intrinsics.checkNotNullParameter((Object)codec, (String)"codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
        this.connection = this.codec.getConnection();
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    @NotNull
    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    @NotNull
    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.areEqual((Object)this.finder.getAddress$okhttp().url().host(), (Object)this.connection.route().address().url().host());
    }

    public final void writeRequestHeaders(@NotNull Request request) throws IOException {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        }
        catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            this.trackFailure(e);
            throw e;
        }
    }

    @NotNull
    public final Sink createRequestBody(@NotNull Request request, boolean duplex) throws IOException {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        this.isDuplex = duplex;
        RequestBody requestBody = request.body();
        Intrinsics.checkNotNull((Object)requestBody);
        long contentLength = requestBody.contentLength();
        this.eventListener.requestBodyStart(this.call);
        Sink rawRequestBody = this.codec.createRequestBody(request, contentLength);
        return new RequestBodySink(rawRequestBody, contentLength);
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        }
        catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            this.trackFailure(e);
            throw e;
        }
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        }
        catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            this.trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    @Nullable
    public final Response.Builder readResponseHeaders(boolean expectContinue) throws IOException {
        try {
            Response.Builder result;
            Response.Builder builder = result = this.codec.readResponseHeaders(expectContinue);
            if (builder != null) {
                builder.initExchange$okhttp(this);
            }
            return result;
        }
        catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            this.trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersEnd(@NotNull Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    @NotNull
    public final ResponseBody openResponseBody(@NotNull Response response) throws IOException {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        try {
            String contentType = Response.header$default(response, "Content-Type", null, 2, null);
            long contentLength = this.codec.reportedContentLength(response);
            Source rawSource = this.codec.openResponseBodySource(response);
            ResponseBodySource source2 = new ResponseBodySource(rawSource, contentLength);
            return new RealResponseBody(contentType, contentLength, Okio.buffer(source2));
        }
        catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            this.trackFailure(e);
            throw e;
        }
    }

    @NotNull
    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void webSocketUpgradeFailed() {
        this.bodyComplete(-1L, true, true, null);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    private final void trackFailure(IOException e) {
        this.hasFailure = true;
        this.finder.trackFailure(e);
        this.codec.getConnection().trackFailure$okhttp(this.call, e);
    }

    public final <E extends IOException> E bodyComplete(long bytesRead, boolean responseDone, boolean requestDone, E e) {
        if (e != null) {
            this.trackFailure(e);
        }
        if (requestDone) {
            if (e != null) {
                this.eventListener.requestFailed(this.call, e);
            } else {
                this.eventListener.requestBodyEnd(this.call, bytesRead);
            }
        }
        if (responseDone) {
            if (e != null) {
                this.eventListener.responseFailed(this.call, e);
            } else {
                this.eventListener.responseBodyEnd(this.call, bytesRead);
            }
        }
        return this.call.messageDone$okhttp(this, requestDone, responseDone, e);
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 6\n\n\n\n \n\t\n\b\n\n\b\n\n\b\n\n\b\n\n\b\b 20B00¢\bJ\t0\bH¢\b\t\nJ#8 \"\n\b \f*02\r8 H¢\bJ0\bH¢\b\nJ0\b2020H¢\bR08@X¢\n\bR08@X¢\n\bR08@X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;J)V", "", "close", "()V", "Ljava/io/IOException;", "E", "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "flush", "Lokio/Buffer;", "source", "byteCount", "write", "(Lokio/Buffer;J)V", "bytesReceived", "J", "", "closed", "Z", "completed", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nExchange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exchange.kt\nokhttp3/internal/connection/Exchange$RequestBodySink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
    private final class RequestBodySink
    extends ForwardingSink {
        private final long contentLength;
        private boolean completed;
        private long bytesReceived;
        private boolean closed;

        public RequestBodySink(Sink delegate, long contentLength) {
            Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
            super(delegate);
            this.contentLength = contentLength;
        }

        @Override
        public void write(@NotNull Buffer source2, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            if (!(!this.closed)) {
                boolean bl = false;
                String string = "closed";
                throw new IllegalStateException(string.toString());
            }
            if (this.contentLength != -1L && this.bytesReceived + byteCount > this.contentLength) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
            }
            try {
                super.write(source2, byteCount);
                this.bytesReceived += byteCount;
            }
            catch (IOException e) {
                throw this.complete(e);
            }
        }

        @Override
        public void flush() throws IOException {
            try {
                super.flush();
            }
            catch (IOException e) {
                throw this.complete(e);
            }
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.contentLength != -1L && this.bytesReceived != this.contentLength) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                this.complete(null);
            }
            catch (IOException e) {
                throw this.complete(e);
            }
        }

        private final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, false, true, e);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 6\n\n\n\n \n\t\n\b\n\n\b\n\n\b\n\n\b\n\n\b\b 20B00¢\bJ\t0\bH¢\b\t\nJ!8 \"\n\b \f*02\r8 ¢\bJ02020H¢\bR08@X¢\n\bR08@X¢\n\bR08@X¢\n\bR08X¢\n\bR08@X¢\n\b¨"}, d2={"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "", "close", "()V", "Ljava/io/IOException;", "E", "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "bytesReceived", "J", "", "closed", "Z", "completed", "invokeStartEvent", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nExchange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exchange.kt\nokhttp3/internal/connection/Exchange$ResponseBodySource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
    public final class ResponseBodySource
    extends ForwardingSource {
        private final long contentLength;
        private long bytesReceived;
        private boolean invokeStartEvent;
        private boolean completed;
        private boolean closed;

        public ResponseBodySource(Source delegate, long contentLength) {
            Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
            super(delegate);
            this.contentLength = contentLength;
            this.invokeStartEvent = true;
            if (this.contentLength == 0L) {
                this.complete(null);
            }
        }

        @Override
        public long read(@NotNull Buffer sink2, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
            if (!(!this.closed)) {
                boolean bl = false;
                String string = "closed";
                throw new IllegalStateException(string.toString());
            }
            try {
                long read = this.delegate().read(sink2, byteCount);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    Exchange.this.getEventListener$okhttp().responseBodyStart(Exchange.this.getCall$okhttp());
                }
                if (read == -1L) {
                    this.complete(null);
                    return -1L;
                }
                long newBytesReceived = this.bytesReceived + read;
                if (this.contentLength != -1L && newBytesReceived > this.contentLength) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + newBytesReceived);
                }
                this.bytesReceived = newBytesReceived;
                if (newBytesReceived == this.contentLength) {
                    this.complete(null);
                }
                return read;
            }
            catch (IOException e) {
                throw this.complete(e);
            }
        }

        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                this.complete(null);
            }
            catch (IOException e) {
                throw this.complete(e);
            }
        }

        public final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            if (e == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                Exchange.this.getEventListener$okhttp().responseBodyStart(Exchange.this.getCall$okhttp());
            }
            return Exchange.this.bodyComplete(this.bytesReceived, true, false, e);
        }
    }
}

