/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.io.RandomAccessFile
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.JvmFileHandle;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" N\n\n\n\b\n\n \n\n \n\n\b\n\n\b\n \n\b\n\n\b\n\n\b\n\n \n\n\b\b 20B¢\bJ\t0\b2020H¢\b\t\nJ0\r202\f0H¢\bJ020H¢\bJ0\r2020H¢\bJ0\r202\f0H¢\bJ0\r2020H¢\bJ\b0020H¢\bJ'\n002020H¢\bJ\n0020H¢\bJ 020H¢\b !J#0\"20H¢\b#$J'%0\"202020H¢\b%&J'0\b2020H¢\b'\nJ0(20H¢\b)J+0*H¢\b+,J-0\r*0H¢\b-.J/0\r*0H¢\b/.¨0"}, d2={"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "<init>", "()V", "Lokio/Path;", "file", "", "mustExist", "Lokio/Sink;", "appendingSink", "(Lokio/Path;Z)Lokio/Sink;", "source", "target", "", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "path", "canonicalize", "(Lokio/Path;)Lokio/Path;", "dir", "mustCreate", "createDirectory", "(Lokio/Path;Z)V", "createSymlink", "delete", "", "list", "(Lokio/Path;)Ljava/util/List;", "throwOnFailure", "(Lokio/Path;Z)Ljava/util/List;", "listOrNull", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "sink", "Lokio/Source;", "(Lokio/Path;)Lokio/Source;", "", "toString", "()Ljava/lang/String;", "requireCreate", "(Lokio/Path;)V", "requireExist", "okio"})
@SourceDebugExtension(value={"SMAP\nJvmSystemFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,158:1\n11400#2,3:159\n*S KotlinDebug\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n*L\n77#1:159,3\n*E\n"})
public class JvmSystemFileSystem
extends FileSystem {
    @Override
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        Intrinsics.checkNotNull((Object)canonicalFile);
        return Path.Companion.get$default(Path.Companion, canonicalFile, false, 1, null);
    }

    @Override
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        File file = path.toFile();
        boolean isRegularFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModifiedAtMillis = file.lastModified();
        long size = file.length();
        if (!(isRegularFile || isDirectory || lastModifiedAtMillis != 0L || size != 0L || file.exists())) {
            return null;
        }
        return new FileMetadata(isRegularFile, isDirectory, null, size, null, lastModifiedAtMillis, null, null, 128, null);
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

    /*
     * WARNING - void declaration
     */
    private final List<Path> list(Path dir, boolean throwOnFailure) {
        void destination$iv;
        void $this$mapTo$iv;
        File file = dir.toFile();
        String[] entries = file.list();
        if (entries == null) {
            if (throwOnFailure) {
                if (!file.exists()) {
                    throw new FileNotFoundException("no such file: " + dir);
                }
                throw new IOException("failed to list " + dir);
            }
            return null;
        }
        String[] stringArray = entries;
        Collection collection = (Collection)((List)new ArrayList());
        boolean $i$f$mapTo = false;
        int n = ((void)$this$mapTo$iv).length;
        for (int i = 0; i < n; ++i) {
            void it;
            void item$iv;
            void var12_11 = item$iv = $this$mapTo$iv[i];
            void var14_13 = destination$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            var14_13.add((Object)dir.resolve((String)it));
        }
        List result = (List)destination$iv;
        CollectionsKt.sort((List)result);
        return result;
    }

    @Override
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return new JvmFileHandle(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        if (!(!mustCreate || !mustExist)) {
            boolean bl = false;
            String string = "Cannot require mustCreate and mustExist at the same time.";
            throw new IllegalArgumentException(string.toString());
        }
        if (mustCreate) {
            this.requireCreate(file);
        }
        if (mustExist) {
            this.requireExist(file);
        }
        return new JvmFileHandle(true, new RandomAccessFile(file.toFile(), "rw"));
    }

    @Override
    @NotNull
    public Source source(@NotNull Path file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return Okio.source(file.toFile());
    }

    @Override
    @NotNull
    public Sink sink(@NotNull Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        if (mustCreate) {
            this.requireCreate(file);
        }
        return Okio.sink$default(file.toFile(), false, 1, null);
    }

    @Override
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean mustExist) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        if (mustExist) {
            this.requireExist(file);
        }
        return Okio.sink(file.toFile(), true);
    }

    @Override
    public void createDirectory(@NotNull Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        if (!dir.toFile().mkdir()) {
            boolean alreadyExist;
            FileMetadata fileMetadata = this.metadataOrNull(dir);
            boolean bl = fileMetadata != null ? fileMetadata.isDirectory() : (alreadyExist = false);
            if (alreadyExist) {
                if (mustCreate) {
                    throw new IOException(dir + " already exists.");
                }
                return;
            }
            throw new IOException("failed to create directory: " + dir);
        }
    }

    @Override
    public void atomicMove(@NotNull Path source2, @NotNull Path target) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        boolean renamed = source2.toFile().renameTo(target.toFile());
        if (!renamed) {
            throw new IOException("failed to move " + source2 + " to " + target);
        }
    }

    @Override
    public void delete(@NotNull Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        boolean deleted = file.delete();
        if (!deleted) {
            if (file.exists()) {
                throw new IOException("failed to delete " + path);
            }
            if (mustExist) {
                throw new FileNotFoundException("no such file: " + path);
            }
        }
    }

    @Override
    public void createSymlink(@NotNull Path source2, @NotNull Path target) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        throw new IOException("unsupported");
    }

    @NotNull
    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final void requireExist(Path $this$requireExist) {
        if (!this.exists($this$requireExist)) {
            throw new IOException($this$requireExist + " doesn't exist.");
        }
    }

    private final void requireCreate(Path $this$requireCreate) {
        if (this.exists($this$requireCreate)) {
            throw new IOException($this$requireCreate + " already exists.");
        }
    }
}

