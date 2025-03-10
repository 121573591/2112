/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassNotFoundException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.ref.SoftReference
 *  java.lang.reflect.Field
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 */
package com.google.protobuf;

import com.google.protobuf.Java8Compatibility;
import com.google.protobuf.UnsafeUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

final class ByteBufferWriter {
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = new ThreadLocal();
    private static final Class<?> FILE_OUTPUT_STREAM_CLASS = ByteBufferWriter.safeGetClass("java.io.FileOutputStream");
    private static final long CHANNEL_FIELD_OFFSET = ByteBufferWriter.getChannelFieldOffset(FILE_OUTPUT_STREAM_CLASS);

    private ByteBufferWriter() {
    }

    static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void write(ByteBuffer buffer, OutputStream output) throws IOException {
        int initialPos = buffer.position();
        try {
            if (buffer.hasArray()) {
                output.write(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
            } else if (!ByteBufferWriter.writeToChannel(buffer, output)) {
                byte[] array = ByteBufferWriter.getOrCreateBuffer(buffer.remaining());
                while (buffer.hasRemaining()) {
                    int length = Math.min((int)buffer.remaining(), (int)array.length);
                    buffer.get(array, 0, length);
                    output.write(array, 0, length);
                }
            }
        }
        finally {
            Java8Compatibility.position((Buffer)buffer, initialPos);
        }
    }

    private static byte[] getOrCreateBuffer(int requestedSize) {
        requestedSize = Math.max((int)requestedSize, (int)1024);
        byte[] buffer = ByteBufferWriter.getBuffer();
        if (buffer == null || ByteBufferWriter.needToReallocate(requestedSize, buffer.length)) {
            buffer = new byte[requestedSize];
            if (requestedSize <= 16384) {
                ByteBufferWriter.setBuffer(buffer);
            }
        }
        return buffer;
    }

    private static boolean needToReallocate(int requestedSize, int bufferLength) {
        return bufferLength < requestedSize && (float)bufferLength < (float)requestedSize * 0.5f;
    }

    private static byte[] getBuffer() {
        SoftReference sr = (SoftReference)BUFFER.get();
        return sr == null ? null : (byte[])sr.get();
    }

    private static void setBuffer(byte[] value) {
        BUFFER.set((Object)new SoftReference((Object)value));
    }

    private static boolean writeToChannel(ByteBuffer buffer, OutputStream output) throws IOException {
        if (CHANNEL_FIELD_OFFSET >= 0L && FILE_OUTPUT_STREAM_CLASS.isInstance((Object)output)) {
            WritableByteChannel channel = null;
            try {
                channel = (WritableByteChannel)UnsafeUtil.getObject(output, CHANNEL_FIELD_OFFSET);
            }
            catch (ClassCastException classCastException) {
                // empty catch block
            }
            if (channel != null) {
                channel.write(buffer);
                return true;
            }
        }
        return false;
    }

    private static Class<?> safeGetClass(String className) {
        try {
            return Class.forName((String)className);
        }
        catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static long getChannelFieldOffset(Class<?> clazz) {
        try {
            if (clazz != null && UnsafeUtil.hasUnsafeArrayOperations()) {
                Field field = clazz.getDeclaredField("channel");
                return UnsafeUtil.objectFieldOffset(field);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return -1L;
    }
}

