/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" j\n\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n \n \n \n\n\n \n\b\n\b\n\t\n\b\n\n\b\n\n\b\b&  +20:,+B¢\bJ\r0¢\bJ\r\b0¢\b\b\tJ\r0\n¢\b\fJ\r0\r¢\bJ0H¢\bJ0H¢\bJB8 \"\b\b *0208 028 00H\b¢\bJ0H&¢\b J\"0!H&¢\b\"#J$0H&¢\b$%J\r'0&¢\b'(R)0\r8@X¢\n\b)*¨-"}, d2={"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "<init>", "()V", "Ljava/io/InputStream;", "byteStream", "()Ljava/io/InputStream;", "Lokio/ByteString;", "byteString", "()Lokio/ByteString;", "", "bytes", "()[B", "Ljava/io/Reader;", "charStream", "()Ljava/io/Reader;", "Ljava/nio/charset/Charset;", "charset", "()Ljava/nio/charset/Charset;", "", "close", "", "T", "Lkotlin/Function1;", "Lokio/BufferedSource;", "consumer", "", "sizeMapper", "consumeSource", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "contentLength", "()J", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "source", "()Lokio/BufferedSource;", "", "string", "()Ljava/lang/String;", "reader", "Ljava/io/Reader;", "Companion", "BomAwareReader", "okhttp"})
@SourceDebugExtension(value={"SMAP\nResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n*L\n1#1,321:1\n140#1,11:322\n140#1,11:333\n*S KotlinDebug\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody\n*L\n124#1:322,11\n134#1:333,11\n*E\n"})
public abstract class ResponseBody
implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private Reader reader;

    @Nullable
    public abstract MediaType contentType();

    public abstract long contentLength();

    @NotNull
    public final InputStream byteStream() {
        return this.source().inputStream();
    }

    @NotNull
    public abstract BufferedSource source();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final byte[] bytes() throws IOException {
        byte[] bytes$iv;
        byte[] byArray;
        ResponseBody this_$iv = this;
        boolean $i$f$consumeSource = false;
        long contentLength$iv = this_$iv.contentLength();
        if (contentLength$iv > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength$iv);
        }
        Closeable closeable = this_$iv.source();
        Throwable throwable = null;
        try {
            BufferedSource p0 = (BufferedSource)closeable;
            boolean bl = false;
            byArray = p0.readByteArray();
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        byte[] it = bytes$iv = byArray;
        boolean bl = false;
        int size$iv = it.length;
        if (contentLength$iv != -1L && contentLength$iv != (long)size$iv) {
            throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
        }
        return bytes$iv;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final ByteString byteString() throws IOException {
        ByteString bytes$iv;
        ByteString byteString;
        ResponseBody this_$iv = this;
        boolean $i$f$consumeSource = false;
        long contentLength$iv = this_$iv.contentLength();
        if (contentLength$iv > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength$iv);
        }
        Closeable closeable = this_$iv.source();
        Throwable throwable = null;
        try {
            BufferedSource p0 = (BufferedSource)closeable;
            boolean bl = false;
            byteString = p0.readByteString();
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        ByteString it = bytes$iv = byteString;
        boolean bl = false;
        int size$iv = it.size();
        if (contentLength$iv != -1L && contentLength$iv != (long)size$iv) {
            throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
        }
        return bytes$iv;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final <T> T consumeSource(Function1<? super BufferedSource, ? extends T> consumer, Function1<? super T, Integer> sizeMapper) {
        Object object;
        boolean $i$f$consumeSource = false;
        long contentLength = this.contentLength();
        if (contentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        Closeable closeable = this.source();
        Throwable throwable = null;
        try {
            object = consumer.invoke((Object)closeable);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            InlineMarker.finallyEnd((int)1);
        }
        Object bytes = object;
        int size = ((Number)sizeMapper.invoke(bytes)).intValue();
        if (contentLength != -1L && contentLength != (long)size) {
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
        }
        return (T)bytes;
    }

    @NotNull
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader == null) {
            BomAwareReader bomAwareReader;
            BomAwareReader it = bomAwareReader = new BomAwareReader(this.source(), this.charset());
            boolean bl = false;
            this.reader = it;
            reader = bomAwareReader;
        }
        return reader;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final String string() throws IOException {
        String string;
        Closeable closeable = this.source();
        Throwable throwable = null;
        try {
            BufferedSource source2 = (BufferedSource)closeable;
            boolean bl = false;
            string = source2.readString(Util.readBomAsCharset(source2, this.charset()));
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        return string;
    }

    private final Charset charset() {
        MediaType mediaType = this.contentType();
        if (mediaType == null || (mediaType = mediaType.charset(Charsets.UTF_8)) == null) {
            mediaType = Charsets.UTF_8;
        }
        return mediaType;
    }

    public void close() {
        Util.closeQuietly(this.source());
    }

    @JvmStatic
    @JvmName(name="create")
    @NotNull
    public static final ResponseBody create(@NotNull String $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name="create")
    @NotNull
    public static final ResponseBody create(@NotNull byte[] $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name="create")
    @NotNull
    public static final ResponseBody create(@NotNull ByteString $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name="create")
    @NotNull
    public static final ResponseBody create(@NotNull BufferedSource $this$create, @Nullable MediaType contentType, long contentLength) {
        return Companion.create($this$create, contentType, contentLength);
    }

    @JvmStatic
    @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}), level=DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, @NotNull String content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}), level=DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, @NotNull byte[] content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}), level=DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, @NotNull ByteString content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.asResponseBody(contentType, contentLength)", imports={"okhttp3.ResponseBody.Companion.asResponseBody"}), level=DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, long contentLength, @NotNull BufferedSource content) {
        return Companion.create(contentType, contentLength, content);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 4\n\n\n\n \n\n\b\n\n\b\n\n \n\b\n\b\n\n\b\b  20B00¢\bJ\t0\bH¢\b\t\nJ'0\r2\f020\r20\rH¢\bR08X¢\n\bR08@X¢\n\bR08@X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "Lokio/BufferedSource;", "source", "Ljava/nio/charset/Charset;", "charset", "<init>", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "", "close", "()V", "", "cbuf", "", "off", "len", "read", "([CII)I", "Ljava/nio/charset/Charset;", "", "closed", "Z", "delegate", "Ljava/io/Reader;", "Lokio/BufferedSource;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseBody.kt\nokhttp3/ResponseBody$BomAwareReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n1#2:322\n*E\n"})
    public static final class BomAwareReader
    extends Reader {
        @NotNull
        private final BufferedSource source;
        @NotNull
        private final Charset charset;
        private boolean closed;
        @Nullable
        private Reader delegate;

        public BomAwareReader(@NotNull BufferedSource source2, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
            this.source = source2;
            this.charset = charset;
        }

        public int read(@NotNull char[] cbuf, int off, int len) throws IOException {
            Intrinsics.checkNotNullParameter((Object)cbuf, (String)"cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                InputStreamReader inputStreamReader;
                InputStreamReader it = inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                boolean bl = false;
                this.delegate = (Reader)it;
                reader = (Reader)inputStreamReader;
            }
            Reader finalDelegate = reader;
            return finalDelegate.read(cbuf, off, len);
        }

        public void close() throws IOException {
            block2: {
                Unit unit;
                this.closed = true;
                Reader reader = this.delegate;
                if (reader != null) {
                    reader.close();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) break block2;
                BomAwareReader $this$close_u24lambda_u241 = this;
                boolean bl = false;
                $this$close_u24lambda_u241.source.close();
            }
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" :\n\n \n\b\n\n \n\n \n\n\b\n\t\n \n\n \n\n \n\n\b\b\b 20B\t\b¢\bJ!\t0\b2\b020H¢\b\t\nJ)\t0\b2\b02\f020\rH¢\b\tJ!\t0\b2\b020H¢\b\tJ!\t0\b2\b020H¢\b\tJ)0\b*0\r2\n\b02\b\b\f0H¢\b\tJ0\b*02\n\b0H¢\b\tJ0\b*02\n\b0H¢\b\tJ0\b*02\n\b0H¢\b\t¨"}, d2={"Lokhttp3/ResponseBody$Companion;", "", "<init>", "()V", "Lokhttp3/MediaType;", "contentType", "", "content", "Lokhttp3/ResponseBody;", "create", "(Lokhttp3/MediaType;[B)Lokhttp3/ResponseBody;", "", "contentLength", "Lokio/BufferedSource;", "(Lokhttp3/MediaType;JLokio/BufferedSource;)Lokhttp3/ResponseBody;", "", "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/ResponseBody;", "Lokio/ByteString;", "(Lokhttp3/MediaType;Lokio/ByteString;)Lokhttp3/ResponseBody;", "(Lokio/BufferedSource;Lokhttp3/MediaType;J)Lokhttp3/ResponseBody;", "asResponseBody", "([BLokhttp3/MediaType;)Lokhttp3/ResponseBody;", "toResponseBody", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "(Lokio/ByteString;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @JvmName(name="create")
        @NotNull
        public final ResponseBody create(@NotNull String $this$toResponseBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter((Object)$this$toResponseBody, (String)"<this>");
            Charset charset = Charsets.UTF_8;
            MediaType finalContentType = contentType;
            if (contentType != null) {
                Charset resolvedCharset = MediaType.charset$default(contentType, null, 1, null);
                if (resolvedCharset == null) {
                    charset = Charsets.UTF_8;
                    finalContentType = MediaType.Companion.parse(contentType + "; charset=utf-8");
                } else {
                    charset = resolvedCharset;
                }
            }
            Buffer buffer = new Buffer().writeString($this$toResponseBody, charset);
            return this.create(buffer, finalContentType, buffer.size());
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String string, MediaType mediaType, int n, Object object) {
            if ((n & 1) != 0) {
                mediaType = null;
            }
            return companion.create(string, mediaType);
        }

        @JvmStatic
        @JvmName(name="create")
        @NotNull
        public final ResponseBody create(@NotNull byte[] $this$toResponseBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter((Object)$this$toResponseBody, (String)"<this>");
            return this.create(new Buffer().write($this$toResponseBody), contentType, $this$toResponseBody.length);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] byArray, MediaType mediaType, int n, Object object) {
            if ((n & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byArray, mediaType);
        }

        @JvmStatic
        @JvmName(name="create")
        @NotNull
        public final ResponseBody create(@NotNull ByteString $this$toResponseBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter((Object)$this$toResponseBody, (String)"<this>");
            return this.create(new Buffer().write($this$toResponseBody), contentType, $this$toResponseBody.size());
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int n, Object object) {
            if ((n & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        @JvmName(name="create")
        @NotNull
        public final ResponseBody create(@NotNull BufferedSource $this$asResponseBody, @Nullable MediaType contentType, long contentLength) {
            Intrinsics.checkNotNullParameter((Object)$this$asResponseBody, (String)"<this>");
            return new ResponseBody(contentType, contentLength, $this$asResponseBody){
                final /* synthetic */ MediaType $contentType;
                final /* synthetic */ long $contentLength;
                final /* synthetic */ BufferedSource $this_asResponseBody;
                {
                    this.$contentType = $contentType;
                    this.$contentLength = $contentLength;
                    this.$this_asResponseBody = $receiver;
                }

                @Nullable
                public MediaType contentType() {
                    return this.$contentType;
                }

                public long contentLength() {
                    return this.$contentLength;
                }

                @NotNull
                public BufferedSource source() {
                    return this.$this_asResponseBody;
                }
            };
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long l, int n, Object object) {
            if ((n & 1) != 0) {
                mediaType = null;
            }
            if ((n & 2) != 0) {
                l = -1L;
            }
            return companion.create(bufferedSource, mediaType, l);
        }

        @JvmStatic
        @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}), level=DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull String content) {
            Intrinsics.checkNotNullParameter((Object)content, (String)"content");
            return this.create(content, contentType);
        }

        @JvmStatic
        @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}), level=DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull byte[] content) {
            Intrinsics.checkNotNullParameter((Object)content, (String)"content");
            return this.create(content, contentType);
        }

        @JvmStatic
        @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}), level=DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull ByteString content) {
            Intrinsics.checkNotNullParameter((Object)content, (String)"content");
            return this.create(content, contentType);
        }

        @JvmStatic
        @Deprecated(message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.asResponseBody(contentType, contentLength)", imports={"okhttp3.ResponseBody.Companion.asResponseBody"}), level=DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, long contentLength, @NotNull BufferedSource content) {
            Intrinsics.checkNotNullParameter((Object)content, (String)"content");
            return this.create(content, contentType, contentLength);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

