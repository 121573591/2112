/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileHandle;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" 2\n\n\n\n \n\n\b\n\n\b\n\t\n \n\n \n\b\n\b\r\b  20B00¢\bJ\t0\bH¢\b\t\nJ0\bH¢\b\nJ/02\r0\f202020H¢\bJ0\b20\fH¢\bJ0\fH¢\bJ/0\b2\r0\f202020H¢\bR08X¢\n\b¨"}, d2={"Lokio/JvmFileHandle;", "Lokio/FileHandle;", "", "readWrite", "Ljava/io/RandomAccessFile;", "randomAccessFile", "<init>", "(ZLjava/io/RandomAccessFile;)V", "", "protectedClose", "()V", "protectedFlush", "", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "protectedRead", "(J[BII)I", "size", "protectedResize", "(J)V", "protectedSize", "()J", "protectedWrite", "(J[BII)V", "Ljava/io/RandomAccessFile;", "okio"})
public final class JvmFileHandle
extends FileHandle {
    @NotNull
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean readWrite, @NotNull RandomAccessFile randomAccessFile) {
        Intrinsics.checkNotNullParameter((Object)randomAccessFile, (String)"randomAccessFile");
        super(readWrite);
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    protected synchronized void protectedResize(long size) {
        long currentSize = this.size();
        long delta = size - currentSize;
        if (delta > 0L) {
            this.protectedWrite(currentSize, new byte[(int)delta], 0, (int)delta);
        } else {
            this.randomAccessFile.setLength(size);
        }
    }

    @Override
    protected synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    @Override
    protected synchronized int protectedRead(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) {
        int bytesRead;
        int readResult;
        Intrinsics.checkNotNullParameter((Object)array, (String)"array");
        this.randomAccessFile.seek(fileOffset);
        for (bytesRead = 0; bytesRead < byteCount; bytesRead += readResult) {
            readResult = this.randomAccessFile.read(array, arrayOffset, byteCount - bytesRead);
            if (readResult != -1) continue;
            if (bytesRead != 0) break;
            return -1;
        }
        return bytesRead;
    }

    @Override
    protected synchronized void protectedWrite(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) {
        Intrinsics.checkNotNullParameter((Object)array, (String)"array");
        this.randomAccessFile.seek(fileOffset);
        this.randomAccessFile.write(array, arrayOffset, byteCount);
    }

    @Override
    protected synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override
    protected synchronized void protectedClose() {
        this.randomAccessFile.close();
    }
}

