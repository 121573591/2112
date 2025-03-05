/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.Charset
 */
package cn.hutool.core.io;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class BufferUtil {
    public static ByteBuffer copy(ByteBuffer src, int start, int end) {
        return BufferUtil.copy(src, ByteBuffer.allocate((int)(end - start)));
    }

    public static ByteBuffer copy(ByteBuffer src, ByteBuffer dest) {
        return BufferUtil.copy(src, dest, Math.min((int)src.limit(), (int)dest.remaining()));
    }

    public static ByteBuffer copy(ByteBuffer src, ByteBuffer dest, int length) {
        return BufferUtil.copy(src, src.position(), dest, dest.position(), length);
    }

    public static ByteBuffer copy(ByteBuffer src, int srcStart, ByteBuffer dest, int destStart, int length) {
        System.arraycopy((Object)src.array(), (int)srcStart, (Object)dest.array(), (int)destStart, (int)length);
        return dest;
    }

    public static String readUtf8Str(ByteBuffer buffer) {
        return BufferUtil.readStr(buffer, CharsetUtil.CHARSET_UTF_8);
    }

    public static String readStr(ByteBuffer buffer, Charset charset) {
        return StrUtil.str(BufferUtil.readBytes(buffer), charset);
    }

    public static byte[] readBytes(ByteBuffer buffer) {
        int remaining = buffer.remaining();
        byte[] ab = new byte[remaining];
        buffer.get(ab);
        return ab;
    }

    public static byte[] readBytes(ByteBuffer buffer, int maxLength) {
        int remaining = buffer.remaining();
        if (maxLength > remaining) {
            maxLength = remaining;
        }
        byte[] ab = new byte[maxLength];
        buffer.get(ab);
        return ab;
    }

    public static byte[] readBytes(ByteBuffer buffer, int start, int end) {
        byte[] bs = new byte[end - start];
        System.arraycopy((Object)buffer.array(), (int)start, (Object)bs, (int)0, (int)bs.length);
        return bs;
    }

    public static int lineEnd(ByteBuffer buffer) {
        return BufferUtil.lineEnd(buffer, buffer.remaining());
    }

    public static int lineEnd(ByteBuffer buffer, int maxLength) {
        int primitivePosition = buffer.position();
        boolean canEnd = false;
        int charIndex = primitivePosition;
        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            ++charIndex;
            if (b == 13) {
                canEnd = true;
            } else {
                if (b == 10) {
                    return canEnd ? charIndex - 2 : charIndex - 1;
                }
                canEnd = false;
            }
            if (charIndex - primitivePosition <= maxLength) continue;
            buffer.position(primitivePosition);
            throw new IndexOutOfBoundsException(StrUtil.format("Position is out of maxLength: {}", maxLength));
        }
        buffer.position(primitivePosition);
        return -1;
    }

    public static String readLine(ByteBuffer buffer, Charset charset) {
        int startPosition = buffer.position();
        int endPosition = BufferUtil.lineEnd(buffer);
        if (endPosition > startPosition) {
            byte[] bs = BufferUtil.readBytes(buffer, startPosition, endPosition);
            return StrUtil.str(bs, charset);
        }
        if (endPosition == startPosition) {
            return "";
        }
        return null;
    }

    public static ByteBuffer create(byte[] data) {
        return ByteBuffer.wrap((byte[])data);
    }

    public static ByteBuffer create(CharSequence data, Charset charset) {
        return BufferUtil.create(StrUtil.bytes(data, charset));
    }

    public static ByteBuffer createUtf8(CharSequence data) {
        return BufferUtil.create(StrUtil.utf8Bytes(data));
    }

    public static CharBuffer createCharBuffer(int capacity) {
        return CharBuffer.allocate((int)capacity);
    }
}

