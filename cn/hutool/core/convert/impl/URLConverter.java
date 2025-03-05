/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.net.URI
 *  java.net.URL
 */
package cn.hutool.core.convert.impl;

import cn.hutool.core.convert.AbstractConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class URLConverter
extends AbstractConverter<URL> {
    private static final long serialVersionUID = 1L;

    @Override
    protected URL convertInternal(Object value) {
        try {
            if (value instanceof File) {
                return ((File)value).toURI().toURL();
            }
            if (value instanceof URI) {
                return ((URI)value).toURL();
            }
            return new URL(this.convertToStr(value));
        }
        catch (Exception exception) {
            return null;
        }
    }
}

