/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  io.netty.util.internal.EmptyArrays
 *  io.netty.util.internal.ObjectUtil
 *  io.netty.util.internal.PlatformDependent
 *  io.netty.util.internal.logging.InternalLogger
 *  io.netty.util.internal.logging.InternalLoggerFactory
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.nio.charset.Charset
 */
package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.multipart.AbstractHttpData;
import io.netty.handler.codec.http.multipart.DeleteFileOnExitHook;
import io.netty.handler.codec.http.multipart.HttpData;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public abstract class AbstractDiskHttpData
extends AbstractHttpData {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractDiskHttpData.class);
    private File file;
    private boolean isRenamed;
    private FileChannel fileChannel;

    protected AbstractDiskHttpData(String name, Charset charset, long size) {
        super(name, charset, size);
    }

    protected abstract String getDiskFilename();

    protected abstract String getPrefix();

    protected abstract String getBaseDirectory();

    protected abstract String getPostfix();

    protected abstract boolean deleteOnExit();

    private File tempFile() throws IOException {
        String diskFilename = this.getDiskFilename();
        String newpostfix = diskFilename != null ? '_' + Integer.toString((int)diskFilename.hashCode()) : this.getPostfix();
        File tmpFile = this.getBaseDirectory() == null ? PlatformDependent.createTempFile((String)this.getPrefix(), (String)newpostfix, null) : PlatformDependent.createTempFile((String)this.getPrefix(), (String)newpostfix, (File)new File(this.getBaseDirectory()));
        if (this.deleteOnExit()) {
            DeleteFileOnExitHook.add(tmpFile.getPath());
        }
        return tmpFile;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setContent(ByteBuf buffer) throws IOException {
        ObjectUtil.checkNotNull((Object)buffer, (String)"buffer");
        try {
            this.size = buffer.readableBytes();
            this.checkSize(this.size);
            if (this.definedSize > 0L && this.definedSize < this.size) {
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            if (this.file == null) {
                this.file = this.tempFile();
            }
            if (buffer.readableBytes() == 0) {
                if (!this.file.createNewFile()) {
                    if (this.file.length() == 0L) {
                        return;
                    }
                    if (!this.file.delete() || !this.file.createNewFile()) {
                        throw new IOException("file exists already: " + this.file);
                    }
                }
                return;
            }
            RandomAccessFile accessFile = new RandomAccessFile(this.file, "rw");
            try {
                accessFile.setLength(0L);
                FileChannel localfileChannel = accessFile.getChannel();
                ByteBuffer byteBuffer = buffer.nioBuffer();
                int written = 0;
                while ((long)written < this.size) {
                    written += localfileChannel.write(byteBuffer);
                }
                buffer.readerIndex(buffer.readerIndex() + written);
                localfileChannel.force(false);
            }
            finally {
                accessFile.close();
            }
            this.setCompleted();
        }
        finally {
            buffer.release();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addContent(ByteBuf buffer, boolean last) throws IOException {
        if (buffer != null) {
            try {
                int written;
                int localsize = buffer.readableBytes();
                this.checkSize(this.size + (long)localsize);
                if (this.definedSize > 0L && this.definedSize < this.size + (long)localsize) {
                    throw new IOException("Out of size: " + (this.size + (long)localsize) + " > " + this.definedSize);
                }
                if (this.file == null) {
                    this.file = this.tempFile();
                }
                if (this.fileChannel == null) {
                    RandomAccessFile accessFile = new RandomAccessFile(this.file, "rw");
                    this.fileChannel = accessFile.getChannel();
                }
                int remaining = localsize;
                long position = this.fileChannel.position();
                int index = buffer.readerIndex();
                while (remaining > 0 && (written = buffer.getBytes(index, this.fileChannel, position, remaining)) >= 0) {
                    remaining -= written;
                    position += (long)written;
                    index += written;
                }
                this.fileChannel.position(position);
                buffer.readerIndex(index);
                this.size += (long)(localsize - remaining);
            }
            finally {
                buffer.release();
            }
        }
        if (last) {
            if (this.file == null) {
                this.file = this.tempFile();
            }
            if (this.fileChannel == null) {
                RandomAccessFile accessFile = new RandomAccessFile(this.file, "rw");
                this.fileChannel = accessFile.getChannel();
            }
            try {
                this.fileChannel.force(false);
            }
            finally {
                this.fileChannel.close();
            }
            this.fileChannel = null;
            this.setCompleted();
        } else {
            ObjectUtil.checkNotNull((Object)buffer, (String)"buffer");
        }
    }

    @Override
    public void setContent(File file) throws IOException {
        long size = file.length();
        this.checkSize(size);
        this.size = size;
        if (this.file != null) {
            this.delete();
        }
        this.file = file;
        this.isRenamed = true;
        this.setCompleted();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setContent(InputStream inputStream2) throws IOException {
        ObjectUtil.checkNotNull((Object)inputStream2, (String)"inputStream");
        if (this.file != null) {
            this.delete();
        }
        this.file = this.tempFile();
        RandomAccessFile accessFile = new RandomAccessFile(this.file, "rw");
        int written = 0;
        try {
            accessFile.setLength(0L);
            FileChannel localfileChannel = accessFile.getChannel();
            byte[] bytes = new byte[16384];
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])bytes);
            int read = inputStream2.read(bytes);
            while (read > 0) {
                byteBuffer.position(read).flip();
                this.checkSize(written += localfileChannel.write(byteBuffer));
                byteBuffer.clear();
                read = inputStream2.read(bytes);
            }
            localfileChannel.force(false);
        }
        finally {
            accessFile.close();
        }
        this.size = written;
        if (this.definedSize > 0L && this.definedSize < this.size) {
            if (!this.file.delete()) {
                logger.warn("Failed to delete: {}", (Object)this.file);
            }
            this.file = null;
            throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
        }
        this.isRenamed = true;
        this.setCompleted();
    }

    @Override
    public void delete() {
        if (this.fileChannel != null) {
            try {
                this.fileChannel.force(false);
            }
            catch (IOException e) {
                logger.warn("Failed to force.", (Throwable)e);
            }
            finally {
                try {
                    this.fileChannel.close();
                }
                catch (IOException e) {
                    logger.warn("Failed to close a file.", (Throwable)e);
                }
            }
            this.fileChannel = null;
        }
        if (!this.isRenamed) {
            String filePath = null;
            if (this.file != null && this.file.exists()) {
                filePath = this.file.getPath();
                if (!this.file.delete()) {
                    filePath = null;
                    logger.warn("Failed to delete: {}", (Object)this.file);
                }
            }
            if (this.deleteOnExit() && filePath != null) {
                DeleteFileOnExitHook.remove(filePath);
            }
            this.file = null;
        }
    }

    @Override
    public byte[] get() throws IOException {
        if (this.file == null) {
            return EmptyArrays.EMPTY_BYTES;
        }
        return AbstractDiskHttpData.readFrom(this.file);
    }

    @Override
    public ByteBuf getByteBuf() throws IOException {
        if (this.file == null) {
            return Unpooled.EMPTY_BUFFER;
        }
        byte[] array = AbstractDiskHttpData.readFrom(this.file);
        return Unpooled.wrappedBuffer((byte[])array);
    }

    @Override
    public ByteBuf getChunk(int length) throws IOException {
        int read;
        if (this.file == null || length == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (this.fileChannel == null) {
            RandomAccessFile accessFile = new RandomAccessFile(this.file, "r");
            this.fileChannel = accessFile.getChannel();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)length);
        try {
            int readnow;
            for (read = 0; read < length; read += readnow) {
                readnow = this.fileChannel.read(byteBuffer);
                if (readnow != -1) continue;
                this.fileChannel.close();
                this.fileChannel = null;
                break;
            }
        }
        catch (IOException e) {
            this.fileChannel.close();
            this.fileChannel = null;
            throw e;
        }
        if (read == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        byteBuffer.flip();
        ByteBuf buffer = Unpooled.wrappedBuffer((ByteBuffer)byteBuffer);
        buffer.readerIndex(0);
        buffer.writerIndex(read);
        return buffer;
    }

    @Override
    public String getString() throws IOException {
        return this.getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override
    public String getString(Charset encoding) throws IOException {
        if (this.file == null) {
            return "";
        }
        if (encoding == null) {
            byte[] array = AbstractDiskHttpData.readFrom(this.file);
            return new String(array, HttpConstants.DEFAULT_CHARSET.name());
        }
        byte[] array = AbstractDiskHttpData.readFrom(this.file);
        return new String(array, encoding.name());
    }

    @Override
    public boolean isInMemory() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean renameTo(File dest) throws IOException {
        ObjectUtil.checkNotNull((Object)dest, (String)"dest");
        if (this.file == null) {
            throw new IOException("No file defined so cannot be renamed");
        }
        if (!this.file.renameTo(dest)) {
            long position;
            IOException exception = null;
            RandomAccessFile inputAccessFile = null;
            RandomAccessFile outputAccessFile = null;
            long chunkSize = 8196L;
            try {
                inputAccessFile = new RandomAccessFile(this.file, "r");
                outputAccessFile = new RandomAccessFile(dest, "rw");
                FileChannel in = inputAccessFile.getChannel();
                FileChannel out = outputAccessFile.getChannel();
                for (position = 0L; position < this.size; position += in.transferTo(position, chunkSize, (WritableByteChannel)out)) {
                    if (chunkSize >= this.size - position) continue;
                    chunkSize = this.size - position;
                }
            }
            catch (IOException e) {
                exception = e;
            }
            finally {
                if (inputAccessFile != null) {
                    try {
                        inputAccessFile.close();
                    }
                    catch (IOException e) {
                        if (exception == null) {
                            exception = e;
                        }
                        logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable)e);
                    }
                }
                if (outputAccessFile != null) {
                    try {
                        outputAccessFile.close();
                    }
                    catch (IOException e) {
                        if (exception == null) {
                            exception = e;
                        }
                        logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable)e);
                    }
                }
            }
            if (exception != null) {
                throw exception;
            }
            if (position == this.size) {
                if (!this.file.delete()) {
                    logger.warn("Failed to delete: {}", (Object)this.file);
                }
                this.file = dest;
                this.isRenamed = true;
                return true;
            }
            if (!dest.delete()) {
                logger.warn("Failed to delete: {}", (Object)dest);
            }
            return false;
        }
        this.file = dest;
        this.isRenamed = true;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] readFrom(File src) throws IOException {
        long srcsize = src.length();
        if (srcsize > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("File too big to be loaded in memory");
        }
        RandomAccessFile accessFile = new RandomAccessFile(src, "r");
        byte[] array = new byte[(int)srcsize];
        try {
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])array);
            int read = 0;
            while ((long)read < srcsize) {
                read += fileChannel.read(byteBuffer);
            }
        }
        finally {
            accessFile.close();
        }
        return array;
    }

    @Override
    public File getFile() throws IOException {
        return this.file;
    }

    @Override
    public HttpData touch() {
        return this;
    }

    @Override
    public HttpData touch(Object hint) {
        return this;
    }
}

