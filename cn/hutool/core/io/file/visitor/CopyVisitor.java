/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.nio.file.CopyOption
 *  java.nio.file.FileAlreadyExistsException
 *  java.nio.file.FileVisitResult
 *  java.nio.file.Files
 *  java.nio.file.LinkOption
 *  java.nio.file.Path
 *  java.nio.file.SimpleFileVisitor
 *  java.nio.file.attribute.BasicFileAttributes
 */
package cn.hutool.core.io.file.visitor;

import cn.hutool.core.io.file.PathUtil;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyVisitor
extends SimpleFileVisitor<Path> {
    private final Path source;
    private final Path target;
    private final CopyOption[] copyOptions;
    private boolean isTargetCreated;

    public CopyVisitor(Path source2, Path target, CopyOption ... copyOptions) {
        if (PathUtil.exists(target, false) && !PathUtil.isDirectory(target)) {
            throw new IllegalArgumentException("Target must be a directory");
        }
        this.source = source2;
        this.target = target;
        this.copyOptions = copyOptions;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        block2: {
            this.initTargetDir();
            Path targetDir = this.resolveTarget(dir);
            try {
                Files.copy((Path)dir, (Path)targetDir, (CopyOption[])this.copyOptions);
            }
            catch (FileAlreadyExistsException e) {
                if (Files.isDirectory((Path)targetDir, (LinkOption[])new LinkOption[0])) break block2;
                throw e;
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        this.initTargetDir();
        Files.copy((Path)file, (Path)this.resolveTarget(file), (CopyOption[])this.copyOptions);
        return FileVisitResult.CONTINUE;
    }

    private Path resolveTarget(Path file) {
        return this.target.resolve(this.source.relativize(file));
    }

    private void initTargetDir() {
        if (!this.isTargetCreated) {
            PathUtil.mkdir(this.target);
            this.isTargetCreated = true;
        }
    }
}

