/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.UncheckedIOException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URL
 *  java.nio.file.CopyOption
 *  java.nio.file.DirectoryStream
 *  java.nio.file.DirectoryStream$Filter
 *  java.nio.file.FileVisitOption
 *  java.nio.file.FileVisitResult
 *  java.nio.file.FileVisitor
 *  java.nio.file.Files
 *  java.nio.file.LinkOption
 *  java.nio.file.NoSuchFileException
 *  java.nio.file.OpenOption
 *  java.nio.file.Path
 *  java.nio.file.Paths
 *  java.nio.file.attribute.AclEntry
 *  java.nio.file.attribute.AclFileAttributeView
 *  java.nio.file.attribute.BasicFileAttributes
 *  java.nio.file.attribute.DosFileAttributeView
 *  java.nio.file.attribute.FileAttribute
 *  java.nio.file.attribute.PosixFileAttributeView
 *  java.nio.file.attribute.PosixFileAttributes
 *  java.nio.file.attribute.PosixFilePermission
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.EnumSet
 *  java.util.List
 *  java.util.Objects
 *  java.util.Set
 *  java.util.stream.Collector
 *  java.util.stream.Collectors
 *  java.util.stream.Stream
 */
package org.apache.commons.io.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.IOExceptionList;
import org.apache.commons.io.file.AccumulatorPathVisitor;
import org.apache.commons.io.file.CleaningPathVisitor;
import org.apache.commons.io.file.CopyDirectoryVisitor;
import org.apache.commons.io.file.Counters;
import org.apache.commons.io.file.CountingPathVisitor;
import org.apache.commons.io.file.DeleteOption;
import org.apache.commons.io.file.DeletingPathVisitor;
import org.apache.commons.io.file.DirectoryStreamFilter;
import org.apache.commons.io.file.PathFilter;
import org.apache.commons.io.file.StandardDeleteOption;

public final class PathUtils {
    public static final CopyOption[] EMPTY_COPY_OPTIONS = new CopyOption[0];
    public static final DeleteOption[] EMPTY_DELETE_OPTION_ARRAY = new DeleteOption[0];
    public static final FileVisitOption[] EMPTY_FILE_VISIT_OPTION_ARRAY = new FileVisitOption[0];
    public static final LinkOption[] EMPTY_LINK_OPTION_ARRAY = new LinkOption[0];
    public static final LinkOption[] NOFOLLOW_LINK_OPTION_ARRAY = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
    public static final OpenOption[] EMPTY_OPEN_OPTION_ARRAY = new OpenOption[0];
    public static final Path[] EMPTY_PATH_ARRAY = new Path[0];

    private static AccumulatorPathVisitor accumulate(Path directory, int maxDepth, FileVisitOption[] fileVisitOptions) throws IOException {
        return PathUtils.visitFileTree(AccumulatorPathVisitor.withLongCounters(), directory, PathUtils.toFileVisitOptionSet(fileVisitOptions), maxDepth);
    }

    public static Counters.PathCounters cleanDirectory(Path directory) throws IOException {
        return PathUtils.cleanDirectory(directory, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters cleanDirectory(Path directory, DeleteOption ... deleteOptions) throws IOException {
        return PathUtils.visitFileTree(new CleaningPathVisitor(Counters.longPathCounters(), deleteOptions, new String[0]), directory).getPathCounters();
    }

    public static Counters.PathCounters copyDirectory(Path sourceDirectory, Path targetDirectory, CopyOption ... copyOptions) throws IOException {
        Path absoluteSource = sourceDirectory.toAbsolutePath();
        return PathUtils.visitFileTree(new CopyDirectoryVisitor(Counters.longPathCounters(), absoluteSource, targetDirectory, copyOptions), absoluteSource).getPathCounters();
    }

    public static Path copyFile(URL sourceFile, Path targetFile, CopyOption ... copyOptions) throws IOException {
        try (InputStream inputStream2 = sourceFile.openStream();){
            Files.copy((InputStream)inputStream2, (Path)targetFile, (CopyOption[])copyOptions);
            Path path = targetFile;
            return path;
        }
    }

    public static Path copyFileToDirectory(Path sourceFile, Path targetDirectory, CopyOption ... copyOptions) throws IOException {
        return Files.copy((Path)sourceFile, (Path)targetDirectory.resolve(sourceFile.getFileName()), (CopyOption[])copyOptions);
    }

    public static Path copyFileToDirectory(URL sourceFile, Path targetDirectory, CopyOption ... copyOptions) throws IOException {
        try (InputStream inputStream2 = sourceFile.openStream();){
            Files.copy((InputStream)inputStream2, (Path)targetDirectory.resolve(sourceFile.getFile()), (CopyOption[])copyOptions);
            Path path = targetDirectory;
            return path;
        }
    }

    public static Counters.PathCounters countDirectory(Path directory) throws IOException {
        return PathUtils.visitFileTree(new CountingPathVisitor(Counters.longPathCounters()), directory).getPathCounters();
    }

    public static Path createParentDirectories(Path path, FileAttribute<?> ... attrs) throws IOException {
        Path parent = path.getParent();
        if (parent == null) {
            return null;
        }
        return Files.createDirectories((Path)parent, attrs);
    }

    public static Path current() {
        return Paths.get((String)"", (String[])new String[0]);
    }

    public static Counters.PathCounters delete(Path path) throws IOException {
        return PathUtils.delete(path, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters delete(Path path, DeleteOption ... deleteOptions) throws IOException {
        return Files.isDirectory((Path)path, (LinkOption[])new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) ? PathUtils.deleteDirectory(path, deleteOptions) : PathUtils.deleteFile(path, deleteOptions);
    }

    public static Counters.PathCounters delete(Path path, LinkOption[] linkOptions, DeleteOption ... deleteOptions) throws IOException {
        return Files.isDirectory((Path)path, (LinkOption[])linkOptions) ? PathUtils.deleteDirectory(path, linkOptions, deleteOptions) : PathUtils.deleteFile(path, linkOptions, deleteOptions);
    }

    public static Counters.PathCounters deleteDirectory(Path directory) throws IOException {
        return PathUtils.deleteDirectory(directory, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters deleteDirectory(Path directory, DeleteOption ... deleteOptions) throws IOException {
        return PathUtils.visitFileTree(new DeletingPathVisitor(Counters.longPathCounters(), NOFOLLOW_LINK_OPTION_ARRAY, deleteOptions, new String[0]), directory).getPathCounters();
    }

    public static Counters.PathCounters deleteDirectory(Path directory, LinkOption[] linkOptions, DeleteOption ... deleteOptions) throws IOException {
        return PathUtils.visitFileTree(new DeletingPathVisitor(Counters.longPathCounters(), linkOptions, deleteOptions, new String[0]), directory).getPathCounters();
    }

    public static Counters.PathCounters deleteFile(Path file) throws IOException {
        return PathUtils.deleteFile(file, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters deleteFile(Path file, DeleteOption ... deleteOptions) throws IOException {
        return PathUtils.deleteFile(file, NOFOLLOW_LINK_OPTION_ARRAY, deleteOptions);
    }

    public static Counters.PathCounters deleteFile(Path file, LinkOption[] linkOptions, DeleteOption ... deleteOptions) throws NoSuchFileException, IOException {
        long size;
        if (Files.isDirectory((Path)file, (LinkOption[])linkOptions)) {
            throw new NoSuchFileException(file.toString());
        }
        Counters.PathCounters pathCounts = Counters.longPathCounters();
        boolean exists = Files.exists((Path)file, (LinkOption[])linkOptions);
        long l = size = exists && !Files.isSymbolicLink((Path)file) ? Files.size((Path)file) : 0L;
        if (PathUtils.overrideReadOnly(deleteOptions) && exists) {
            PathUtils.setReadOnly(file, false, linkOptions);
        }
        if (Files.deleteIfExists((Path)file)) {
            pathCounts.getFileCounter().increment();
            pathCounts.getByteCounter().add(size);
        }
        return pathCounts;
    }

    public static boolean directoryAndFileContentEquals(Path path1, Path path2) throws IOException {
        return PathUtils.directoryAndFileContentEquals(path1, path2, EMPTY_LINK_OPTION_ARRAY, EMPTY_OPEN_OPTION_ARRAY, EMPTY_FILE_VISIT_OPTION_ARRAY);
    }

    public static boolean directoryAndFileContentEquals(Path path1, Path path2, LinkOption[] linkOptions, OpenOption[] openOptions, FileVisitOption[] fileVisitOption) throws IOException {
        if (path1 == null && path2 == null) {
            return true;
        }
        if (path1 == null || path2 == null) {
            return false;
        }
        if (Files.notExists((Path)path1, (LinkOption[])new LinkOption[0]) && Files.notExists((Path)path2, (LinkOption[])new LinkOption[0])) {
            return true;
        }
        RelativeSortedPaths relativeSortedPaths = new RelativeSortedPaths(path1, path2, Integer.MAX_VALUE, linkOptions, fileVisitOption);
        if (!relativeSortedPaths.equals) {
            return false;
        }
        List<Path> fileList1 = relativeSortedPaths.relativeFileList1;
        List<Path> fileList2 = relativeSortedPaths.relativeFileList2;
        for (Path path : fileList1) {
            int binarySearch = Collections.binarySearch(fileList2, (Object)path);
            if (binarySearch <= -1) {
                throw new IllegalStateException("Unexpected mismatch.");
            }
            if (PathUtils.fileContentEquals(path1.resolve(path), path2.resolve(path), linkOptions, openOptions)) continue;
            return false;
        }
        return true;
    }

    public static boolean directoryContentEquals(Path path1, Path path2) throws IOException {
        return PathUtils.directoryContentEquals(path1, path2, Integer.MAX_VALUE, EMPTY_LINK_OPTION_ARRAY, EMPTY_FILE_VISIT_OPTION_ARRAY);
    }

    public static boolean directoryContentEquals(Path path1, Path path2, int maxDepth, LinkOption[] linkOptions, FileVisitOption[] fileVisitOptions) throws IOException {
        return new RelativeSortedPaths((Path)path1, (Path)path2, (int)maxDepth, (LinkOption[])linkOptions, (FileVisitOption[])fileVisitOptions).equals;
    }

    public static boolean fileContentEquals(Path path1, Path path2) throws IOException {
        return PathUtils.fileContentEquals(path1, path2, EMPTY_LINK_OPTION_ARRAY, EMPTY_OPEN_OPTION_ARRAY);
    }

    /*
     * Exception decompiling
     */
    public static boolean fileContentEquals(Path path1, Path path2, LinkOption[] linkOptions, OpenOption[] openOptions) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Unknown Source:65)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Unknown Source:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Unknown Source:39)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(Unknown Source:1424)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(Unknown Source:6)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(Unknown Source:94)
         *     at android.s.ۥۣۢۧ.ۥ۟۟(Unknown Source:10)
         *     at org.benf.cfr.reader.entities.Method.ۥ۟۟۟(Unknown Source:4)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:91)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۨ(Unknown Source:0)
         *     at android.s.ۦۦ۟.ۥ۟۟۟(Unknown Source:190)
         *     at android.s.ۦۦ۟.ۥ۟۟(Unknown Source:144)
         *     at android.s.ۥۧۥ۟.ۥ(Unknown Source:107)
         *     at android.s.ۥۦۨۡ.ۥ(Unknown Source:83)
         *     at com.efs.sdk.pa.a.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁣⁠⁠⁤⁠⁠⁣⁣⁣⁣⁣⁠.⁣⁤⁠⁠⁠⁠⁣⁣⁣⁠⁠⁤⁠⁣⁤⁤⁠⁤⁤⁠⁠⁠⁣⁣⁠(Unknown Source:8)
         *     at android.s.ۥۦۨ۠.ۥ۟(Unknown Source:53)
         *     at org.apache.commons.lang3.builder.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁤⁠⁤⁤⁤⁠⁤⁠⁠⁠⁣.⁣⁤⁠⁠⁠⁣⁤⁤⁣⁤⁤⁤⁣⁤⁠⁠⁤⁤⁤⁠⁤⁤⁠⁠⁣⁠⁠⁠⁣⁣⁣(Unknown Source:10)
         *     at android.s.ۥۦۨ۠.ۥ(Unknown Source:99)
         *     at org.apache.xerces.xni.parser.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁣⁤⁤⁠⁤⁤.⁠⁣⁤⁣⁤⁠⁣⁤⁠⁠⁠⁣⁣⁤⁤⁣⁠(Unknown Source:8)
         *     at android.s.go$ۥ۟۟۠$ۥ.run(Unknown Source:92)
         *     at java.lang.Thread.run(Thread.java:1012)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static Path[] filter(PathFilter filter, Path ... paths) {
        Objects.requireNonNull((Object)filter, (String)"filter");
        if (paths == null) {
            return EMPTY_PATH_ARRAY;
        }
        return (Path[])((List)PathUtils.filterPaths(filter, (Stream<Path>)Stream.of((Object[])paths), Collectors.toList())).toArray((Object[])EMPTY_PATH_ARRAY);
    }

    private static <R, A> R filterPaths(PathFilter filter, Stream<Path> stream, Collector<? super Path, A, R> collector) {
        Objects.requireNonNull((Object)filter, (String)"filter");
        Objects.requireNonNull(collector, (String)"collector");
        if (stream == null) {
            return (R)Stream.empty().collect(collector);
        }
        return (R)stream.filter(p -> {
            try {
                return p != null && filter.accept((Path)p, PathUtils.readBasicFileAttributes(p)) == FileVisitResult.CONTINUE;
            }
            catch (IOException e) {
                return false;
            }
        }).collect(collector);
    }

    public static List<AclEntry> getAclEntryList(Path sourcePath) throws IOException {
        AclFileAttributeView fileAttributeView = (AclFileAttributeView)Files.getFileAttributeView((Path)sourcePath, AclFileAttributeView.class, (LinkOption[])new LinkOption[0]);
        return fileAttributeView == null ? null : fileAttributeView.getAcl();
    }

    public static boolean isDirectory(Path path, LinkOption ... options) {
        return path != null && Files.isDirectory((Path)path, (LinkOption[])options);
    }

    public static boolean isEmpty(Path path) throws IOException {
        return Files.isDirectory((Path)path, (LinkOption[])new LinkOption[0]) ? PathUtils.isEmptyDirectory(path) : PathUtils.isEmptyFile(path);
    }

    public static boolean isEmptyDirectory(Path directory) throws IOException {
        try (DirectoryStream directoryStream = Files.newDirectoryStream((Path)directory);){
            boolean bl = !directoryStream.iterator().hasNext();
            return bl;
        }
    }

    public static boolean isEmptyFile(Path file) throws IOException {
        return Files.size((Path)file) <= 0L;
    }

    public static boolean isNewer(Path file, long timeMillis, LinkOption ... options) throws IOException {
        Objects.requireNonNull((Object)file, (String)"file");
        if (Files.notExists((Path)file, (LinkOption[])new LinkOption[0])) {
            return false;
        }
        return Files.getLastModifiedTime((Path)file, (LinkOption[])options).toMillis() > timeMillis;
    }

    public static boolean isRegularFile(Path path, LinkOption ... options) {
        return path != null && Files.isRegularFile((Path)path, (LinkOption[])options);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir, PathFilter pathFilter) throws IOException {
        return Files.newDirectoryStream((Path)dir, (DirectoryStream.Filter)new DirectoryStreamFilter(pathFilter));
    }

    private static boolean overrideReadOnly(DeleteOption ... deleteOptions) {
        if (deleteOptions == null) {
            return false;
        }
        return Stream.of((Object[])deleteOptions).anyMatch(e -> e == StandardDeleteOption.OVERRIDE_READ_ONLY);
    }

    public static BasicFileAttributes readBasicFileAttributes(Path path) throws IOException {
        return Files.readAttributes((Path)path, BasicFileAttributes.class, (LinkOption[])new LinkOption[0]);
    }

    public static BasicFileAttributes readBasicFileAttributesUnchecked(Path path) {
        try {
            return PathUtils.readBasicFileAttributes(path);
        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    static List<Path> relativize(Collection<Path> collection, Path parent, boolean sort, Comparator<? super Path> comparator) {
        Stream stream = collection.stream().map(arg_0 -> ((Path)parent).relativize(arg_0));
        if (sort) {
            stream = comparator == null ? stream.sorted() : stream.sorted(comparator);
        }
        return (List)stream.collect(Collectors.toList());
    }

    public static Path setReadOnly(Path path, boolean readOnly, LinkOption ... linkOptions) throws IOException {
        PosixFileAttributeView posixFileAttributeView;
        ArrayList causeList = new ArrayList(2);
        DosFileAttributeView fileAttributeView = (DosFileAttributeView)Files.getFileAttributeView((Path)path, DosFileAttributeView.class, (LinkOption[])linkOptions);
        if (fileAttributeView != null) {
            try {
                fileAttributeView.setReadOnly(readOnly);
                return path;
            }
            catch (IOException e) {
                causeList.add((Object)e);
            }
        }
        if ((posixFileAttributeView = (PosixFileAttributeView)Files.getFileAttributeView((Path)path, PosixFileAttributeView.class, (LinkOption[])linkOptions)) != null) {
            PosixFileAttributes readAttributes = posixFileAttributeView.readAttributes();
            Set permissions = readAttributes.permissions();
            permissions.remove((Object)PosixFilePermission.OWNER_WRITE);
            permissions.remove((Object)PosixFilePermission.GROUP_WRITE);
            permissions.remove((Object)PosixFilePermission.OTHERS_WRITE);
            try {
                return Files.setPosixFilePermissions((Path)path, (Set)permissions);
            }
            catch (IOException e) {
                causeList.add((Object)e);
            }
        }
        if (!causeList.isEmpty()) {
            throw new IOExceptionList(path.toString(), (List<? extends Throwable>)causeList);
        }
        throw new IOException(String.format((String)"No DosFileAttributeView or PosixFileAttributeView for '%s' (linkOptions=%s)", (Object[])new Object[]{path, Arrays.toString((Object[])linkOptions)}));
    }

    static Set<FileVisitOption> toFileVisitOptionSet(FileVisitOption ... fileVisitOptions) {
        return fileVisitOptions == null ? EnumSet.noneOf(FileVisitOption.class) : (Set)Stream.of((Object[])fileVisitOptions).collect(Collectors.toSet());
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T visitor, Path directory) throws IOException {
        Files.walkFileTree((Path)directory, visitor);
        return visitor;
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T visitor, Path start, Set<FileVisitOption> options, int maxDepth) throws IOException {
        Files.walkFileTree((Path)start, options, (int)maxDepth, visitor);
        return visitor;
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T visitor, String first, String ... more) throws IOException {
        return PathUtils.visitFileTree(visitor, Paths.get((String)first, (String[])more));
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T visitor, URI uri) throws IOException {
        return PathUtils.visitFileTree(visitor, Paths.get((URI)uri));
    }

    public static Stream<Path> walk(Path start, PathFilter pathFilter, int maxDepth, boolean readAttributes, FileVisitOption ... options) throws IOException {
        return Files.walk((Path)start, (int)maxDepth, (FileVisitOption[])options).filter(path -> pathFilter.accept((Path)path, readAttributes ? PathUtils.readBasicFileAttributesUnchecked(path) : null) == FileVisitResult.CONTINUE);
    }

    private PathUtils() {
    }

    private static class RelativeSortedPaths {
        final boolean equals;
        final List<Path> relativeFileList1;
        final List<Path> relativeFileList2;

        private RelativeSortedPaths(Path dir1, Path dir2, int maxDepth, LinkOption[] linkOptions, FileVisitOption[] fileVisitOptions) throws IOException {
            List<Path> tmpRelativeFileList1 = null;
            List<Path> tmpRelativeFileList2 = null;
            if (dir1 == null && dir2 == null) {
                this.equals = true;
            } else if (dir1 == null ^ dir2 == null) {
                this.equals = false;
            } else {
                boolean parentDirNotExists1 = Files.notExists((Path)dir1, (LinkOption[])linkOptions);
                boolean parentDirNotExists2 = Files.notExists((Path)dir2, (LinkOption[])linkOptions);
                if (parentDirNotExists1 || parentDirNotExists2) {
                    this.equals = parentDirNotExists1 && parentDirNotExists2;
                } else {
                    AccumulatorPathVisitor visitor1 = PathUtils.accumulate(dir1, maxDepth, fileVisitOptions);
                    AccumulatorPathVisitor visitor2 = PathUtils.accumulate(dir2, maxDepth, fileVisitOptions);
                    if (visitor1.getDirList().size() != visitor2.getDirList().size() || visitor1.getFileList().size() != visitor2.getFileList().size()) {
                        this.equals = false;
                    } else {
                        List<Path> tmpRelativeDirList2;
                        List<Path> tmpRelativeDirList1 = visitor1.relativizeDirectories(dir1, true, null);
                        if (!tmpRelativeDirList1.equals(tmpRelativeDirList2 = visitor2.relativizeDirectories(dir2, true, null))) {
                            this.equals = false;
                        } else {
                            tmpRelativeFileList1 = visitor1.relativizeFiles(dir1, true, null);
                            tmpRelativeFileList2 = visitor2.relativizeFiles(dir2, true, null);
                            this.equals = tmpRelativeFileList1.equals(tmpRelativeFileList2);
                        }
                    }
                }
            }
            this.relativeFileList1 = tmpRelativeFileList1;
            this.relativeFileList2 = tmpRelativeFileList2;
        }
    }
}

