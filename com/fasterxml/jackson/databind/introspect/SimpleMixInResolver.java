/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 */
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SimpleMixInResolver
implements ClassIntrospector.MixInResolver,
Serializable {
    private static final long serialVersionUID = 1L;
    protected final ClassIntrospector.MixInResolver _overrides;
    protected Map<ClassKey, Class<?>> _localMixIns;

    public SimpleMixInResolver(ClassIntrospector.MixInResolver overrides) {
        this._overrides = overrides;
    }

    protected SimpleMixInResolver(ClassIntrospector.MixInResolver overrides, Map<ClassKey, Class<?>> mixins) {
        this._overrides = overrides;
        this._localMixIns = mixins;
    }

    public SimpleMixInResolver withOverrides(ClassIntrospector.MixInResolver overrides) {
        return new SimpleMixInResolver(overrides, this._localMixIns);
    }

    public SimpleMixInResolver withoutLocalDefinitions() {
        return new SimpleMixInResolver(this._overrides, null);
    }

    public void setLocalDefinitions(Map<Class<?>, Class<?>> sourceMixins) {
        if (sourceMixins == null || sourceMixins.isEmpty()) {
            this._localMixIns = null;
        } else {
            HashMap mixIns = new HashMap(sourceMixins.size());
            for (Map.Entry en : sourceMixins.entrySet()) {
                mixIns.put((Object)new ClassKey((Class)en.getKey()), en.getValue());
            }
            this._localMixIns = mixIns;
        }
    }

    public void addLocalDefinition(Class<?> target, Class<?> mixinSource) {
        if (this._localMixIns == null) {
            this._localMixIns = new HashMap();
        }
        this._localMixIns.put((Object)new ClassKey(target), mixinSource);
    }

    @Override
    public SimpleMixInResolver copy() {
        ClassIntrospector.MixInResolver overrides = this._overrides == null ? null : this._overrides.copy();
        HashMap mixIns = this._localMixIns == null ? null : new HashMap(this._localMixIns);
        return new SimpleMixInResolver(overrides, (Map<ClassKey, Class<?>>)mixIns);
    }

    @Override
    public Class<?> findMixInClassFor(Class<?> cls) {
        Class mixin;
        Class clazz = mixin = this._overrides == null ? null : this._overrides.findMixInClassFor(cls);
        if (mixin == null && this._localMixIns != null) {
            mixin = (Class)this._localMixIns.get((Object)new ClassKey(cls));
        }
        return mixin;
    }

    public int localSize() {
        return this._localMixIns == null ? 0 : this._localMixIns.size();
    }

    public boolean hasMixIns() {
        if (this._localMixIns == null) {
            if (this._overrides == null) {
                return false;
            }
            if (this._overrides instanceof SimpleMixInResolver) {
                return ((SimpleMixInResolver)this._overrides).hasMixIns();
            }
        }
        return true;
    }
}

