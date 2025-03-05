/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.file.Path
 *  java.nio.file.SimpleFileVisitor
 */
package org.apache.commons.io.file;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import org.apache.commons.io.file.PathVisitor;

public abstract class SimplePathVisitor
extends SimpleFileVisitor<Path>
implements PathVisitor {
    protected SimplePathVisitor() {
    }
}

