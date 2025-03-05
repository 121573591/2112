/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package org.apache.commons.text.similarity;

public interface SimilarityScore<R> {
    public R apply(CharSequence var1, CharSequence var2);
}

