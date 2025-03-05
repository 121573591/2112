/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.util.Map
 *  java.util.Objects
 *  java.util.function.BiFunction
 */
package org.apache.commons.text.lookup;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import org.apache.commons.text.lookup.BiStringLookup;

final class BiFunctionStringLookup<P, R>
implements BiStringLookup<P> {
    private final BiFunction<String, P, R> biFunction;

    static <U, T> BiFunctionStringLookup<U, T> on(BiFunction<String, U, T> biFunction) {
        return new BiFunctionStringLookup<U, T>(biFunction);
    }

    static <U, T> BiFunctionStringLookup<U, T> on(Map<String, T> map) {
        return BiFunctionStringLookup.on((key, u) -> map.get(key));
    }

    private BiFunctionStringLookup(BiFunction<String, P, R> biFunction) {
        this.biFunction = biFunction;
    }

    @Override
    public String lookup(String key) {
        return this.lookup(key, (P)null);
    }

    @Override
    public String lookup(String key, P object) {
        Object obj;
        if (this.biFunction == null) {
            return null;
        }
        try {
            obj = this.biFunction.apply((Object)key, object);
        }
        catch (IllegalArgumentException | NullPointerException | SecurityException e) {
            return null;
        }
        return Objects.toString((Object)obj, null);
    }

    public String toString() {
        return super.toString() + " [function=" + this.biFunction + "]";
    }
}

