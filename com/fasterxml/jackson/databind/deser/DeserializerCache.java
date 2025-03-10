/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 */
package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.LookupCache;
import java.io.Serializable;
import java.util.HashMap;

public final class DeserializerCache
implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_MAX_CACHE_SIZE = 2000;
    protected final LookupCache<JavaType, JsonDeserializer<Object>> _cachedDeserializers;
    protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap(8);

    public DeserializerCache() {
        this(2000);
    }

    public DeserializerCache(int maxSize) {
        this(new LRUMap<JavaType, JsonDeserializer<Object>>(Math.min((int)64, (int)(maxSize >> 2)), maxSize));
    }

    public DeserializerCache(LookupCache<JavaType, JsonDeserializer<Object>> cache) {
        this._cachedDeserializers = cache;
    }

    public DeserializerCache emptyCopy() {
        return new DeserializerCache(this._cachedDeserializers.emptyCopy());
    }

    Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }

    public int cachedDeserializersCount() {
        return this._cachedDeserializers.size();
    }

    public void flushCachedDeserializers() {
        this._cachedDeserializers.clear();
    }

    public JsonDeserializer<Object> findValueDeserializer(DeserializationContext ctxt, DeserializerFactory factory2, JavaType propertyType) throws JsonMappingException {
        JsonDeserializer<Object> deser = this._findCachedDeserializer(propertyType);
        if (deser == null && (deser = this._createAndCacheValueDeserializer(ctxt, factory2, propertyType)) == null) {
            deser = this._handleUnknownValueDeserializer(ctxt, propertyType);
        }
        return deser;
    }

    public KeyDeserializer findKeyDeserializer(DeserializationContext ctxt, DeserializerFactory factory2, JavaType type) throws JsonMappingException {
        KeyDeserializer kd = factory2.createKeyDeserializer(ctxt, type);
        if (kd == null) {
            return this._handleUnknownKeyDeserializer(ctxt, type);
        }
        if (kd instanceof ResolvableDeserializer) {
            ((ResolvableDeserializer)((Object)kd)).resolve(ctxt);
        }
        return kd;
    }

    public boolean hasValueDeserializerFor(DeserializationContext ctxt, DeserializerFactory factory2, JavaType type) throws JsonMappingException {
        JsonDeserializer<Object> deser = this._findCachedDeserializer(type);
        if (deser == null) {
            deser = this._createAndCacheValueDeserializer(ctxt, factory2, type);
        }
        return deser != null;
    }

    protected JsonDeserializer<Object> _findCachedDeserializer(JavaType type) {
        if (type == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        }
        if (this._hasCustomHandlers(type)) {
            return null;
        }
        return this._cachedDeserializers.get(type);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected JsonDeserializer<Object> _createAndCacheValueDeserializer(DeserializationContext ctxt, DeserializerFactory factory2, JavaType type) throws JsonMappingException {
        HashMap<JavaType, JsonDeserializer<Object>> hashMap = this._incompleteDeserializers;
        synchronized (hashMap) {
            JsonDeserializer<Object> jsonDeserializer;
            JsonDeserializer deser = this._findCachedDeserializer(type);
            if (deser != null) {
                return deser;
            }
            int count = this._incompleteDeserializers.size();
            if (count > 0 && (deser = (JsonDeserializer)this._incompleteDeserializers.get((Object)type)) != null) {
                return deser;
            }
            try {
                jsonDeserializer = this._createAndCache2(ctxt, factory2, type);
            }
            catch (Throwable throwable) {
                if (count == 0 && this._incompleteDeserializers.size() > 0) {
                    this._incompleteDeserializers.clear();
                }
                throw throwable;
            }
            if (count == 0 && this._incompleteDeserializers.size() > 0) {
                this._incompleteDeserializers.clear();
            }
            return jsonDeserializer;
        }
    }

    protected JsonDeserializer<Object> _createAndCache2(DeserializationContext ctxt, DeserializerFactory factory2, JavaType type) throws JsonMappingException {
        boolean addToCache;
        JsonDeserializer<Object> deser;
        try {
            deser = this._createDeserializer(ctxt, factory2, type);
        }
        catch (IllegalArgumentException iae) {
            ctxt.reportBadDefinition(type, ClassUtil.exceptionMessage(iae));
            deser = null;
        }
        if (deser == null) {
            return null;
        }
        boolean bl = addToCache = !this._hasCustomHandlers(type) && deser.isCachable();
        if (deser instanceof ResolvableDeserializer) {
            this._incompleteDeserializers.put((Object)type, deser);
            ((ResolvableDeserializer)((Object)deser)).resolve(ctxt);
            this._incompleteDeserializers.remove((Object)type);
        }
        if (addToCache) {
            this._cachedDeserializers.put(type, deser);
        }
        return deser;
    }

    protected JsonDeserializer<Object> _createDeserializer(DeserializationContext ctxt, DeserializerFactory factory2, JavaType type) throws JsonMappingException {
        Class<?> builder;
        BeanDescription beanDesc;
        JsonDeserializer<Object> deser;
        DeserializationConfig config = ctxt.getConfig();
        if (type.isAbstract() || type.isMapLikeType() || type.isCollectionLikeType()) {
            type = factory2.mapAbstractType(config, type);
        }
        if ((deser = this.findDeserializerFromAnnotation(ctxt, (beanDesc = config.introspect(type)).getClassInfo())) != null) {
            return deser;
        }
        JavaType newType = this.modifyTypeByAnnotation(ctxt, beanDesc.getClassInfo(), type);
        if (newType != type) {
            type = newType;
            beanDesc = config.introspect(newType);
        }
        if ((builder = beanDesc.findPOJOBuilder()) != null) {
            return factory2.createBuilderBasedDeserializer(ctxt, type, beanDesc, builder);
        }
        Converter<Object, Object> conv = beanDesc.findDeserializationConverter();
        if (conv == null) {
            return this._createDeserializer2(ctxt, factory2, type, beanDesc);
        }
        JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
        if (!delegateType.hasRawClass(type.getRawClass())) {
            beanDesc = config.introspect(delegateType);
        }
        return new StdDelegatingDeserializer<Object>(conv, delegateType, this._createDeserializer2(ctxt, factory2, delegateType, beanDesc));
    }

    protected JsonDeserializer<?> _createDeserializer2(DeserializationContext ctxt, DeserializerFactory factory2, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        if (type.isEnumType()) {
            return factory2.createEnumDeserializer(ctxt, type, beanDesc);
        }
        if (type.isContainerType()) {
            JsonFormat.Value format;
            if (type.isArrayType()) {
                return factory2.createArrayDeserializer(ctxt, (ArrayType)type, beanDesc);
            }
            if (type.isMapLikeType() && (format = beanDesc.findExpectedFormat(null)).getShape() != JsonFormat.Shape.OBJECT) {
                MapLikeType mlt = (MapLikeType)type;
                if (mlt instanceof MapType) {
                    return factory2.createMapDeserializer(ctxt, (MapType)mlt, beanDesc);
                }
                return factory2.createMapLikeDeserializer(ctxt, mlt, beanDesc);
            }
            if (type.isCollectionLikeType() && (format = beanDesc.findExpectedFormat(null)).getShape() != JsonFormat.Shape.OBJECT) {
                CollectionLikeType clt = (CollectionLikeType)type;
                if (clt instanceof CollectionType) {
                    return factory2.createCollectionDeserializer(ctxt, (CollectionType)clt, beanDesc);
                }
                return factory2.createCollectionLikeDeserializer(ctxt, clt, beanDesc);
            }
        }
        if (type.isReferenceType()) {
            return factory2.createReferenceDeserializer(ctxt, (ReferenceType)type, beanDesc);
        }
        if (JsonNode.class.isAssignableFrom(type.getRawClass())) {
            return factory2.createTreeDeserializer(config, type, beanDesc);
        }
        return factory2.createBeanDeserializer(ctxt, type, beanDesc);
    }

    protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef = ctxt.getAnnotationIntrospector().findDeserializer(ann);
        if (deserDef == null) {
            return null;
        }
        JsonDeserializer<Object> deser = ctxt.deserializerInstance(ann, deserDef);
        return this.findConvertingDeserializer(ctxt, ann, deser);
    }

    protected JsonDeserializer<Object> findConvertingDeserializer(DeserializationContext ctxt, Annotated a, JsonDeserializer<Object> deser) throws JsonMappingException {
        Converter<Object, Object> conv = this.findConverter(ctxt, a);
        if (conv == null) {
            return deser;
        }
        JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
        return new StdDelegatingDeserializer<Object>(conv, delegateType, deser);
    }

    protected Converter<Object, Object> findConverter(DeserializationContext ctxt, Annotated a) throws JsonMappingException {
        Object convDef = ctxt.getAnnotationIntrospector().findDeserializationConverter(a);
        if (convDef == null) {
            return null;
        }
        return ctxt.converterInstance(a, convDef);
    }

    private JavaType modifyTypeByAnnotation(DeserializationContext ctxt, Annotated a, JavaType type) throws JsonMappingException {
        Object cdDef;
        JavaType contentType;
        KeyDeserializer kd;
        Object kdDef;
        JavaType keyType;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            return type;
        }
        if (type.isMapLikeType() && (keyType = type.getKeyType()) != null && keyType.getValueHandler() == null && (kdDef = intr.findKeyDeserializer(a)) != null && (kd = ctxt.keyDeserializerInstance(a, kdDef)) != null) {
            type = ((MapLikeType)type).withKeyValueHandler(kd);
        }
        if ((contentType = type.getContentType()) != null && contentType.getValueHandler() == null && (cdDef = intr.findContentDeserializer(a)) != null) {
            JsonDeserializer<Object> cd = null;
            if (cdDef instanceof JsonDeserializer) {
                cd = (JsonDeserializer<Object>)cdDef;
            } else {
                Class<?> cdClass = this._verifyAsClass(cdDef, "findContentDeserializer", JsonDeserializer.None.class);
                if (cdClass != null) {
                    cd = ctxt.deserializerInstance(a, cdClass);
                }
            }
            if (cd != null) {
                type = type.withContentValueHandler(cd);
            }
        }
        type = intr.refineDeserializationType(ctxt.getConfig(), a, type);
        return type;
    }

    private boolean _hasCustomHandlers(JavaType t) {
        if (t.isContainerType()) {
            JavaType kt;
            JavaType ct = t.getContentType();
            if (ct != null && (ct.getValueHandler() != null || ct.getTypeHandler() != null)) {
                return true;
            }
            if (t.isMapLikeType() && (kt = t.getKeyType()).getValueHandler() != null) {
                return true;
            }
        }
        return false;
    }

    private Class<?> _verifyAsClass(Object src, String methodName, Class<?> noneClass) {
        if (src == null) {
            return null;
        }
        if (!(src instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector." + methodName + "() returned value of type " + src.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
        }
        Class cls = (Class)src;
        if (cls == noneClass || ClassUtil.isBogusClass(cls)) {
            return null;
        }
        return cls;
    }

    protected JsonDeserializer<Object> _handleUnknownValueDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        Class<?> rawClass = type.getRawClass();
        if (!ClassUtil.isConcrete(rawClass)) {
            return (JsonDeserializer)ctxt.reportBadDefinition(type, "Cannot find a Value deserializer for abstract type " + type);
        }
        return (JsonDeserializer)ctxt.reportBadDefinition(type, "Cannot find a Value deserializer for type " + type);
    }

    protected KeyDeserializer _handleUnknownKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        return (KeyDeserializer)ctxt.reportBadDefinition(type, "Cannot find a (Map) Key deserializer for type " + type);
    }
}

