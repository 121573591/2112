/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.List
 *  java.util.Map
 *  java.util.zip.Inflater
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okio;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.InflaterSource;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" X\n\n\n\n\b\n$\n\n \n\n\b\n\n \n\n\b\n\n\b\f\n \n\b\n\n\b\n\n\b\n\n\b\b   620:6B7\b 00000\b\t0\b¢\b\nJ02\f020\rH¢\bJ02020H¢\bJ020H¢\bJ020H¢\bJ02020\rH¢\bJ02020H¢\bJ 02020\rH¢\b J\"\b00!20H¢\b\"#J'\"\n00!202$0\rH¢\b\"%J&\n00!20H¢\b&#J(0'20H¢\b()J+0*2\f0H¢\b+,J'-0*2\f020\r20\rH¢\b-.J/02\f020\rH¢\b/J002\f0H¢\b1R\t0\b8X¢\n\b\t2R 0008X¢\n\b3R08X¢\n\b4R08X¢\n\b5¨7"}, d2={"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "zipPath", "fileSystem", "", "Lokio/internal/ZipEntry;", "entries", "", "comment", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "file", "", "mustExist", "Lokio/Sink;", "appendingSink", "(Lokio/Path;Z)Lokio/Sink;", "source", "target", "", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "path", "canonicalize", "(Lokio/Path;)Lokio/Path;", "canonicalizeInternal", "dir", "mustCreate", "createDirectory", "(Lokio/Path;Z)V", "createSymlink", "delete", "", "list", "(Lokio/Path;)Ljava/util/List;", "throwOnFailure", "(Lokio/Path;Z)Ljava/util/List;", "listOrNull", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "sink", "Lokio/Source;", "(Lokio/Path;)Lokio/Source;", "Ljava/lang/String;", "Ljava/util/Map;", "Lokio/FileSystem;", "Lokio/Path;", "Companion", "okio"})
@SourceDebugExtension(value={"SMAP\nZipFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,175:1\n52#2,5:176\n52#2,21:181\n60#2,10:202\n57#2,2:212\n71#2,2:214\n52#2,21:216\n*S KotlinDebug\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n*L\n102#1:176,5\n103#1:181,21\n102#1:202,10\n102#1:212,2\n102#1:214,2\n132#1:216,21\n*E\n"})
public final class ZipFileSystem
extends FileSystem {
    @NotNull
    private static final Companion Companion = new Companion(null);
    @NotNull
    private final Path zipPath;
    @NotNull
    private final FileSystem fileSystem;
    @NotNull
    private final Map<Path, ZipEntry> entries;
    @Nullable
    private final String comment;
    @NotNull
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, null);

    public ZipFileSystem(@NotNull Path zipPath, @NotNull FileSystem fileSystem, @NotNull Map<Path, ZipEntry> entries, @Nullable String comment) {
        Intrinsics.checkNotNullParameter((Object)zipPath, (String)"zipPath");
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"fileSystem");
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = comment;
    }

    @Override
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Path canonical = this.canonicalizeInternal(path);
        if (!this.entries.containsKey((Object)canonical)) {
            throw new FileNotFoundException(String.valueOf((Object)path));
        }
        return canonical;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    @Override
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Throwable thrown$iv;
        FileMetadata result$iv;
        block33: {
            Throwable thrown$iv2;
            FileMetadata result$iv2;
            Closeable $this$use$iv;
            block32: {
                Intrinsics.checkNotNullParameter((Object)path, (String)"path");
                Path canonicalPath = this.canonicalizeInternal(path);
                ZipEntry zipEntry = (ZipEntry)this.entries.get((Object)canonicalPath);
                if (zipEntry == null) {
                    return null;
                }
                ZipEntry entry = zipEntry;
                FileMetadata basicMetadata = new FileMetadata(!entry.isDirectory(), entry.isDirectory(), null, entry.isDirectory() ? null : Long.valueOf((long)entry.getSize()), null, entry.getLastModifiedAtMillis(), null, null, 128, null);
                if (entry.getOffset() == -1L) {
                    return basicMetadata;
                }
                $this$use$iv = this.fileSystem.openReadOnly(this.zipPath);
                boolean $i$f$use = false;
                result$iv = null;
                thrown$iv = null;
                FileHandle fileHandle = (FileHandle)$this$use$iv;
                boolean bl = false;
                Closeable $this$use$iv2 = Okio.buffer(fileHandle.source(entry.getOffset()));
                boolean $i$f$use2 = false;
                result$iv2 = null;
                thrown$iv2 = null;
                BufferedSource source2 = (BufferedSource)$this$use$iv2;
                boolean bl2 = false;
                result$iv2 = ZipFilesKt.readLocalHeader(source2, basicMetadata);
                try {
                    Closeable closeable = $this$use$iv2;
                    if (closeable != null) {
                        closeable.close();
                    }
                    break block32;
                }
                catch (Throwable t$iv) {
                    thrown$iv2 = t$iv;
                }
                break block32;
                catch (Throwable t$iv) {
                    try {
                        thrown$iv2 = t$iv;
                    }
                    catch (Throwable throwable) {
                        try {
                            Closeable closeable = $this$use$iv2;
                            if (closeable != null) {
                                closeable.close();
                            }
                        }
                        catch (Throwable t$iv2) {
                            thrown$iv2 = t$iv2;
                        }
                        throw throwable;
                    }
                    try {
                        Closeable closeable = $this$use$iv2;
                        if (closeable != null) {
                            closeable.close();
                        }
                    }
                    catch (Throwable t$iv3) {
                        if (thrown$iv2 == null) {
                            thrown$iv2 = t$iv3;
                            break block32;
                        }
                        ExceptionsKt.addSuppressed((Throwable)thrown$iv2, (Throwable)t$iv3);
                    }
                }
            }
            Throwable throwable = thrown$iv2;
            if (throwable != null) {
                throw throwable;
            }
            FileMetadata fileMetadata = result$iv2;
            Intrinsics.checkNotNull((Object)fileMetadata);
            result$iv = fileMetadata;
            try {
                Closeable closeable = $this$use$iv;
                if (closeable != null) {
                    closeable.close();
                }
                break block33;
            }
            catch (Throwable t$iv) {
                thrown$iv = t$iv;
            }
            break block33;
            catch (Throwable t$iv) {
                try {
                    thrown$iv = t$iv;
                }
                catch (Throwable throwable2) {
                    try {
                        Closeable closeable = $this$use$iv;
                        if (closeable != null) {
                            closeable.close();
                        }
                    }
                    catch (Throwable t$iv4) {
                        thrown$iv = t$iv4;
                    }
                    throw throwable2;
                }
                try {
                    Closeable closeable = $this$use$iv;
                    if (closeable != null) {
                        closeable.close();
                    }
                }
                catch (Throwable t$iv5) {
                    if (thrown$iv == null) {
                        thrown$iv = t$iv5;
                        break block33;
                    }
                    ExceptionsKt.addSuppressed((Throwable)thrown$iv, (Throwable)t$iv5);
                }
            }
        }
        Throwable throwable = thrown$iv;
        if (throwable != null) {
            throw throwable;
        }
        FileMetadata fileMetadata = result$iv;
        Intrinsics.checkNotNull(fileMetadata);
        return fileMetadata;
    }

    @Override
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        throw new IOException("zip entries are not writable");
    }

    @Override
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        List<Path> list = this.list(dir, true);
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        return this.list(dir, false);
    }

    private final List<Path> list(Path dir, boolean throwOnFailure) {
        Path canonicalDir = this.canonicalizeInternal(dir);
        ZipEntry zipEntry = (ZipEntry)this.entries.get((Object)canonicalDir);
        if (zipEntry == null) {
            if (throwOnFailure) {
                throw new IOException("not a directory: " + dir);
            }
            return null;
        }
        ZipEntry entry = zipEntry;
        return CollectionsKt.toList((Iterable)((Iterable)entry.getChildren()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    @Override
    @NotNull
    public Source source(@NotNull Path file) throws IOException {
        Source source2;
        Throwable thrown$iv;
        BufferedSource result$iv;
        ZipEntry entry;
        block18: {
            Intrinsics.checkNotNullParameter((Object)file, (String)"file");
            Path canonicalPath = this.canonicalizeInternal(file);
            ZipEntry zipEntry = (ZipEntry)this.entries.get((Object)canonicalPath);
            if (zipEntry == null) {
                throw new FileNotFoundException("no such file: " + file);
            }
            entry = zipEntry;
            Closeable $this$use$iv = this.fileSystem.openReadOnly(this.zipPath);
            boolean $i$f$use = false;
            result$iv = null;
            thrown$iv = null;
            FileHandle fileHandle = (FileHandle)$this$use$iv;
            boolean bl = false;
            result$iv = Okio.buffer(fileHandle.source(entry.getOffset()));
            try {
                Closeable closeable = $this$use$iv;
                if (closeable != null) {
                    closeable.close();
                }
                break block18;
            }
            catch (Throwable t$iv) {
                thrown$iv = t$iv;
            }
            break block18;
            catch (Throwable t$iv) {
                try {
                    thrown$iv = t$iv;
                }
                catch (Throwable throwable) {
                    try {
                        Closeable closeable = $this$use$iv;
                        if (closeable != null) {
                            closeable.close();
                        }
                    }
                    catch (Throwable t$iv2) {
                        thrown$iv = t$iv2;
                    }
                    throw throwable;
                }
                try {
                    Closeable closeable = $this$use$iv;
                    if (closeable != null) {
                        closeable.close();
                    }
                }
                catch (Throwable t$iv3) {
                    if (thrown$iv == null) {
                        thrown$iv = t$iv3;
                        break block18;
                    }
                    ExceptionsKt.addSuppressed((Throwable)thrown$iv, (Throwable)t$iv3);
                }
            }
        }
        Throwable throwable = thrown$iv;
        if (throwable != null) {
            throw throwable;
        }
        BufferedSource bufferedSource = result$iv;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSource source3 = bufferedSource;
        ZipFilesKt.skipLocalHeader(source3);
        if (entry.getCompressionMethod() == 0) {
            source2 = new FixedLengthSource(source3, entry.getSize(), true);
        } else {
            InflaterSource inflaterSource = new InflaterSource(new FixedLengthSource(source3, entry.getCompressedSize(), true), new Inflater(true));
            source2 = new FixedLengthSource(inflaterSource, entry.getSize(), false);
        }
        return source2;
    }

    @Override
    @NotNull
    public Sink sink(@NotNull Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean mustExist) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void createDirectory(@NotNull Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void atomicMove(@NotNull Path source2, @NotNull Path target) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void delete(@NotNull Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void createSymlink(@NotNull Path source2, @NotNull Path target) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        throw new IOException("zip file systems are read-only");
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\b 20B\t\b¢\bR08¢\f\n\b\b\b¨\t"}, d2={"Lokio/ZipFileSystem$Companion;", "", "<init>", "()V", "Lokio/Path;", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"})
    private static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Path getROOT() {
            return ROOT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

