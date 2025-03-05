/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class FileExistsException
extends IOException {
    private static final long serialVersionUID = 1L;

    public FileExistsException() {
    }

    public FileExistsException(String message) {
        super(message);
    }

    public FileExistsException(File file) {
        super("File " + file + " exists");
    }
}

