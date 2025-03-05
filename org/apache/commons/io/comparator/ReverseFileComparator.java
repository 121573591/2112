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
 *  java.util.Comparator
 */
package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.comparator.AbstractFileComparator;

class ReverseFileComparator
extends AbstractFileComparator
implements Serializable {
    private static final long serialVersionUID = -4808255005272229056L;
    private final Comparator<File> delegate;

    public ReverseFileComparator(Comparator<File> delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("Delegate comparator is missing");
        }
        this.delegate = delegate;
    }

    public int compare(File file1, File file2) {
        return this.delegate.compare((Object)file2, (Object)file1);
    }

    @Override
    public String toString() {
        return super.toString() + "[" + this.delegate.toString() + "]";
    }
}

