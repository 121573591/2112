/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.file.FileVisitResult
 *  java.nio.file.Files
 *  java.nio.file.LinkOption
 *  java.nio.file.Path
 *  java.nio.file.attribute.BasicFileAttributes
 *  java.util.Objects
 */
package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import org.apache.commons.io.file.Counters;
import org.apache.commons.io.file.PathFilter;
import org.apache.commons.io.file.SimplePathVisitor;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class CountingPathVisitor
extends SimplePathVisitor {
    static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final Counters.PathCounters pathCounters;
    private final PathFilter fileFilter;
    private final PathFilter dirFilter;

    public static CountingPathVisitor withBigIntegerCounters() {
        return new CountingPathVisitor(Counters.bigIntegerPathCounters());
    }

    public static CountingPathVisitor withLongCounters() {
        return new CountingPathVisitor(Counters.longPathCounters());
    }

    public CountingPathVisitor(Counters.PathCounters pathCounter) {
        this(pathCounter, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
    }

    public CountingPathVisitor(Counters.PathCounters pathCounter, PathFilter fileFilter, PathFilter dirFilter) {
        this.pathCounters = (Counters.PathCounters)Objects.requireNonNull((Object)pathCounter, (String)"pathCounter");
        this.fileFilter = (PathFilter)Objects.requireNonNull((Object)fileFilter, (String)"fileFilter");
        this.dirFilter = (PathFilter)Objects.requireNonNull((Object)dirFilter, (String)"dirFilter");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountingPathVisitor)) {
            return false;
        }
        CountingPathVisitor other = (CountingPathVisitor)obj;
        return Objects.equals((Object)this.pathCounters, (Object)other.pathCounters);
    }

    public Counters.PathCounters getPathCounters() {
        return this.pathCounters;
    }

    public int hashCode() {
        return Objects.hash((Object[])new Object[]{this.pathCounters});
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        this.updateDirCounter(dir, exc);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes) throws IOException {
        FileVisitResult accept = this.dirFilter.accept(dir, attributes);
        return accept != FileVisitResult.CONTINUE ? FileVisitResult.SKIP_SUBTREE : FileVisitResult.CONTINUE;
    }

    public String toString() {
        return this.pathCounters.toString();
    }

    protected void updateDirCounter(Path dir, IOException exc) {
        this.pathCounters.getDirectoryCounter().increment();
    }

    protected void updateFileCounters(Path file, BasicFileAttributes attributes) {
        this.pathCounters.getFileCounter().increment();
        this.pathCounters.getByteCounter().add(attributes.size());
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
        if (Files.exists((Path)file, (LinkOption[])new LinkOption[0]) && this.fileFilter.accept(file, attributes) == FileVisitResult.CONTINUE) {
            this.updateFileCounters(file, attributes);
        }
        return FileVisitResult.CONTINUE;
    }
}

