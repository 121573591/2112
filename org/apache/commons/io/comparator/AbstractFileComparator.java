/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.List
 */
package org.apache.commons.io.comparator;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

abstract class AbstractFileComparator
implements Comparator<File> {
    AbstractFileComparator() {
    }

    public File[] sort(File ... files) {
        if (files != null) {
            Arrays.sort((Object[])files, (Comparator)this);
        }
        return files;
    }

    public List<File> sort(List<File> files) {
        if (files != null) {
            files.sort((Comparator)this);
        }
        return files;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}

