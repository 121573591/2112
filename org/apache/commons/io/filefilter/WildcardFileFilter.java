/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.file.FileVisitResult
 *  java.nio.file.Path
 *  java.nio.file.attribute.BasicFileAttributes
 *  java.util.List
 *  java.util.Objects
 */
package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.AbstractFileFilter;

public class WildcardFileFilter
extends AbstractFileFilter
implements Serializable {
    private static final long serialVersionUID = -7426486598995782105L;
    private final String[] wildcards;
    private final IOCase caseSensitivity;

    public WildcardFileFilter(List<String> wildcards) {
        this(wildcards, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(List<String> wildcards, IOCase caseSensitivity) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = (String[])wildcards.toArray((Object[])EMPTY_STRING_ARRAY);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    public WildcardFileFilter(String wildcard) {
        this(wildcard, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(String ... wildcards) {
        this(wildcards, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(String wildcard, IOCase caseSensitivity) {
        if (wildcard == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{wildcard};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    public WildcardFileFilter(String[] wildcards, IOCase caseSensitivity) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        this.wildcards = new String[wildcards.length];
        System.arraycopy((Object)wildcards, (int)0, (Object)this.wildcards, (int)0, (int)wildcards.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    @Override
    public boolean accept(File file) {
        return this.accept(file.getName());
    }

    @Override
    public boolean accept(File dir, String name) {
        return this.accept(name);
    }

    @Override
    public FileVisitResult accept(Path file, BasicFileAttributes attributes) {
        return WildcardFileFilter.toFileVisitResult(this.accept(Objects.toString((Object)file.getFileName(), null)), file);
    }

    private boolean accept(String name) {
        for (String wildcard : this.wildcards) {
            if (!FilenameUtils.wildcardMatch(name, wildcard, this.caseSensitivity)) continue;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        for (int i = 0; i < this.wildcards.length; ++i) {
            if (i > 0) {
                buffer.append(",");
            }
            buffer.append(this.wildcards[i]);
        }
        buffer.append(")");
        return buffer.toString();
    }
}

