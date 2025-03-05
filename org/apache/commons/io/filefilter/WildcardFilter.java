/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.nio.file.FileVisitResult
 *  java.nio.file.Files
 *  java.nio.file.LinkOption
 *  java.nio.file.Path
 *  java.nio.file.attribute.BasicFileAttributes
 *  java.util.List
 *  java.util.Objects
 */
package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.AbstractFileFilter;

@Deprecated
public class WildcardFilter
extends AbstractFileFilter
implements Serializable {
    private static final long serialVersionUID = -5037645902506953517L;
    private final String[] wildcards;

    public WildcardFilter(List<String> wildcards) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = (String[])wildcards.toArray((Object[])EMPTY_STRING_ARRAY);
    }

    public WildcardFilter(String wildcard) {
        if (wildcard == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{wildcard};
    }

    public WildcardFilter(String ... wildcards) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        this.wildcards = new String[wildcards.length];
        System.arraycopy((Object)wildcards, (int)0, (Object)this.wildcards, (int)0, (int)wildcards.length);
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (String wildcard : this.wildcards) {
            if (!FilenameUtils.wildcardMatch(file.getName(), wildcard)) continue;
            return true;
        }
        return false;
    }

    @Override
    public FileVisitResult accept(Path file, BasicFileAttributes attributes) {
        if (Files.isDirectory((Path)file, (LinkOption[])new LinkOption[0])) {
            return FileVisitResult.TERMINATE;
        }
        for (String wildcard : this.wildcards) {
            if (!FilenameUtils.wildcardMatch(Objects.toString((Object)file.getFileName(), null), wildcard)) continue;
            return FileVisitResult.CONTINUE;
        }
        return FileVisitResult.TERMINATE;
    }

    @Override
    public boolean accept(File dir, String name) {
        if (dir != null && new File(dir, name).isDirectory()) {
            return false;
        }
        for (String wildcard : this.wildcards) {
            if (!FilenameUtils.wildcardMatch(name, wildcard)) continue;
            return true;
        }
        return false;
    }
}

