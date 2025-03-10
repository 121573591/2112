/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.channels.ReadableByteChannel
 *  java.nio.charset.Charset
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" ~\n\n\n\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\n\b\n\b\n\n\b\n\n\b\f\n\n\b\t\n\n\n\b\n\n \n\n\b\n\n\b\n\n \bv 2020J0H'¢\bJ0H&¢\b\bJ\f02\n0\tH&¢\b\f\rJ\f02\n0\t20H&¢\b\fJ'\f02\n0\t2020H&¢\b\fJ\f020H&¢\b\fJ\f02020H&¢\b\fJ020H&¢\bJ02020H&¢\bJ0H&¢\bJ0 H&¢\bJ02020H&¢\bJ/020202!0 2\"0 H&¢\b#J&0 2%0$H&¢\b&'J'&0 2%0$20 2\"0 H&¢\b&(J*02%0)H&¢\b*+J,0\tH&¢\b,-J.0$H&¢\b./J.0$2\"0H&¢\b.0J10H&¢\b12J102\"0H&¢\b13J40H&¢\b45J7062%0$H&¢\b78J7062%02\"0H&¢\b79J:0H&¢\b:5J;0 H&¢\b;<J=0 H&¢\b=<J>0H&¢\b>5J?0H&¢\b?5JA0@H&¢\bABJC0@H&¢\bCBJG0F2E0DH&¢\bGHJG0F2\"02E0DH&¢\bGIJJ0FH&¢\bJKJJ0F2\"0H&¢\bJLJM0 H&¢\bM<JN0FH&¢\bNKJO0FH&¢\bOKJO0F2P0H&¢\bOLJQ02\"0H&¢\bQRJS062\"0H&¢\bSTJW0 2V0UH&¢\bWXJY062\"0H&¢\bYTR08&X¦¢\bZ[ø \n\b!0¨\\À"}, d2={"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "", "exhausted", "()Z", "", "b", "", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "targetBytes", "indexOfElement", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "peek", "()Lokio/BufferedSource;", "offset", "rangeEquals", "(JLokio/ByteString;)Z", "", "bytesOffset", "byteCount", "(JLokio/ByteString;II)Z", "", "sink", "read", "([B)I", "([BII)I", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "readByte", "()B", "readByteArray", "()[B", "(J)[B", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "readDecimalLong", "()J", "", "readFully", "([B)V", "(Lokio/Buffer;J)V", "readHexadecimalUnsignedLong", "readInt", "()I", "readIntLe", "readLong", "readLongLe", "", "readShort", "()S", "readShortLe", "Ljava/nio/charset/Charset;", "charset", "", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "(J)Z", "require", "(J)V", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", "skip", "getBuffer", "Lokio/RealBufferedSource;", "okio"})
public interface BufferedSource
extends Source,
ReadableByteChannel {
    @Deprecated(message="moved to val: use getBuffer() instead", replaceWith=@ReplaceWith(expression="buffer", imports={}), level=DeprecationLevel.WARNING)
    @NotNull
    public Buffer buffer();

    @NotNull
    public Buffer getBuffer();

    public boolean exhausted() throws IOException;

    public void require(long var1) throws IOException;

    public boolean request(long var1) throws IOException;

    public byte readByte() throws IOException;

    public short readShort() throws IOException;

    public short readShortLe() throws IOException;

    public int readInt() throws IOException;

    public int readIntLe() throws IOException;

    public long readLong() throws IOException;

    public long readLongLe() throws IOException;

    public long readDecimalLong() throws IOException;

    public long readHexadecimalUnsignedLong() throws IOException;

    public void skip(long var1) throws IOException;

    @NotNull
    public ByteString readByteString() throws IOException;

    @NotNull
    public ByteString readByteString(long var1) throws IOException;

    public int select(@NotNull Options var1) throws IOException;

    @NotNull
    public byte[] readByteArray() throws IOException;

    @NotNull
    public byte[] readByteArray(long var1) throws IOException;

    public int read(@NotNull byte[] var1) throws IOException;

    public void readFully(@NotNull byte[] var1) throws IOException;

    public int read(@NotNull byte[] var1, int var2, int var3) throws IOException;

    public void readFully(@NotNull Buffer var1, long var2) throws IOException;

    public long readAll(@NotNull Sink var1) throws IOException;

    @NotNull
    public String readUtf8() throws IOException;

    @NotNull
    public String readUtf8(long var1) throws IOException;

    @Nullable
    public String readUtf8Line() throws IOException;

    @NotNull
    public String readUtf8LineStrict() throws IOException;

    @NotNull
    public String readUtf8LineStrict(long var1) throws IOException;

    public int readUtf8CodePoint() throws IOException;

    @NotNull
    public String readString(@NotNull Charset var1) throws IOException;

    @NotNull
    public String readString(long var1, @NotNull Charset var3) throws IOException;

    public long indexOf(byte var1) throws IOException;

    public long indexOf(byte var1, long var2) throws IOException;

    public long indexOf(byte var1, long var2, long var4) throws IOException;

    public long indexOf(@NotNull ByteString var1) throws IOException;

    public long indexOf(@NotNull ByteString var1, long var2) throws IOException;

    public long indexOfElement(@NotNull ByteString var1) throws IOException;

    public long indexOfElement(@NotNull ByteString var1, long var2) throws IOException;

    public boolean rangeEquals(long var1, @NotNull ByteString var3) throws IOException;

    public boolean rangeEquals(long var1, @NotNull ByteString var3, int var4, int var5) throws IOException;

    @NotNull
    public BufferedSource peek();

    @NotNull
    public InputStream inputStream();
}

