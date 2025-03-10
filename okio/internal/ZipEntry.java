/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" 2\n\n \n\n \n\n \n\n \n\t\n\b\n\b\n\b\b\n!\n\b\b  20Ba0\b\b0\b\b0\b\b\t0\b\b\b\n0\b\b\b0\b\b\b\r0\f\n\b0\b\b\b0\b¢\bR08¢\f\n\b\bR\b008¢\f\n\b\bR08¢\f\n\b\bR\n0\b8¢\f\n\b\n\bR\r0\f8¢\f\n\b\r \b!\"R\t0\b8¢\f\n\b\t\b#R08¢\f\n\b$\b%R0\b8¢\f\n\b&\b'(R0\b8¢\f\n\b\b)R0\b8¢\f\n\b\b*¨+"}, d2={"Lokio/internal/ZipEntry;", "", "Lokio/Path;", "canonicalPath", "", "isDirectory", "", "comment", "", "crc", "compressedSize", "size", "", "compressionMethod", "lastModifiedAtMillis", "offset", "<init>", "(Lokio/Path;ZLjava/lang/String;JJJILjava/lang/Long;J)V", "Lokio/Path;", "getCanonicalPath", "()Lokio/Path;", "", "children", "Ljava/util/List;", "getChildren", "()Ljava/util/List;", "Ljava/lang/String;", "getComment", "()Ljava/lang/String;", "J", "getCompressedSize", "()J", "I", "getCompressionMethod", "()I", "getCrc", "Z", "()Z", "Ljava/lang/Long;", "getLastModifiedAtMillis", "()Ljava/lang/Long;", "getOffset", "getSize", "okio"})
public final class ZipEntry {
    @NotNull
    private final Path canonicalPath;
    private final boolean isDirectory;
    @NotNull
    private final String comment;
    private final long crc;
    private final long compressedSize;
    private final long size;
    private final int compressionMethod;
    @Nullable
    private final Long lastModifiedAtMillis;
    private final long offset;
    @NotNull
    private final List<Path> children;

    public ZipEntry(@NotNull Path canonicalPath, boolean isDirectory, @NotNull String comment, long crc, long compressedSize, long size, int compressionMethod, @Nullable Long lastModifiedAtMillis, long offset) {
        Intrinsics.checkNotNullParameter((Object)canonicalPath, (String)"canonicalPath");
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        this.canonicalPath = canonicalPath;
        this.isDirectory = isDirectory;
        this.comment = comment;
        this.crc = crc;
        this.compressedSize = compressedSize;
        this.size = size;
        this.compressionMethod = compressionMethod;
        this.lastModifiedAtMillis = lastModifiedAtMillis;
        this.offset = offset;
        this.children = (List)new ArrayList();
    }

    public /* synthetic */ ZipEntry(Path path, boolean bl, String string, long l, long l2, long l3, int n, Long l4, long l5, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            string = "";
        }
        if ((n2 & 8) != 0) {
            l = -1L;
        }
        if ((n2 & 0x10) != 0) {
            l2 = -1L;
        }
        if ((n2 & 0x20) != 0) {
            l3 = -1L;
        }
        if ((n2 & 0x40) != 0) {
            n = -1;
        }
        if ((n2 & 0x80) != 0) {
            l4 = null;
        }
        if ((n2 & 0x100) != 0) {
            l5 = -1L;
        }
        this(path, bl, string, l, l2, l3, n, l4, l5);
    }

    @NotNull
    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    @NotNull
    public final String getComment() {
        return this.comment;
    }

    public final long getCrc() {
        return this.crc;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    @Nullable
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final long getOffset() {
        return this.offset;
    }

    @NotNull
    public final List<Path> getChildren() {
        return this.children;
    }
}

