/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package com.aayushatharva.brotli4j;

@Deprecated
public interface BrotliNativeProvider {
    @Deprecated
    default public String platformName() {
        throw new UnsupportedOperationException("This method is superseded by com.aayushatharva.brotli4j.service.BrotliNativeProvider#platformName()");
    }
}

