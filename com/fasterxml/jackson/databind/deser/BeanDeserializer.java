/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 */
package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BeanDeserializer
extends BeanDeserializerBase
implements Serializable {
    private static final long serialVersionUID = 1L;
    protected transient Exception _nullFromCreator;
    private volatile transient NameTransformer _currentlyTransforming;

    @Deprecated
    public BeanDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews) {
        super(builder, beanDesc, properties, backRefs, (Set<String>)ignorableProps, ignoreAllUnknown, null, hasViews);
    }

    public BeanDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, Set<String> includableProps, boolean hasViews) {
        super(builder, beanDesc, properties, backRefs, (Set<String>)ignorableProps, ignoreAllUnknown, includableProps, hasViews);
    }

    protected BeanDeserializer(BeanDeserializerBase src) {
        super(src, src._ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase src, boolean ignoreAllUnknown) {
        super(src, ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase src, NameTransformer unwrapper) {
        super(src, unwrapper);
    }

    public BeanDeserializer(BeanDeserializerBase src, ObjectIdReader oir) {
        super(src, oir);
    }

    @Deprecated
    public BeanDeserializer(BeanDeserializerBase src, Set<String> ignorableProps) {
        super(src, ignorableProps);
    }

    public BeanDeserializer(BeanDeserializerBase src, Set<String> ignorableProps, Set<String> includableProps) {
        super(src, ignorableProps, includableProps);
    }

    public BeanDeserializer(BeanDeserializerBase src, BeanPropertyMap props) {
        super(src, props);
    }

    @Override
    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer transformer) {
        if (this.getClass() != BeanDeserializer.class) {
            return this;
        }
        if (this._currentlyTransforming == transformer) {
            return this;
        }
        this._currentlyTransforming = transformer;
        try {
            BeanDeserializer beanDeserializer = new BeanDeserializer((BeanDeserializerBase)this, transformer);
            return beanDeserializer;
        }
        finally {
            this._currentlyTransforming = null;
        }
    }

    @Override
    public BeanDeserializer withObjectIdReader(ObjectIdReader oir) {
        return new BeanDeserializer((BeanDeserializerBase)this, oir);
    }

    @Override
    public BeanDeserializer withByNameInclusion(Set<String> ignorableProps, Set<String> includableProps) {
        return new BeanDeserializer(this, ignorableProps, includableProps);
    }

    @Override
    public BeanDeserializerBase withIgnoreAllUnknown(boolean ignoreUnknown) {
        return new BeanDeserializer((BeanDeserializerBase)this, ignoreUnknown);
    }

    @Override
    public BeanDeserializerBase withBeanProperties(BeanPropertyMap props) {
        return new BeanDeserializer((BeanDeserializerBase)this, props);
    }

    @Override
    protected BeanDeserializerBase asArrayDeserializer() {
        SettableBeanProperty[] props = this._beanProperties.getPropertiesInInsertionOrder();
        return new BeanAsArrayDeserializer((BeanDeserializerBase)this, props);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.isExpectedStartObjectToken()) {
            if (this._vanillaProcessing) {
                return this.vanillaDeserialize(p, ctxt, p.nextToken());
            }
            p.nextToken();
            if (this._objectIdReader != null) {
                return this.deserializeWithObjectId(p, ctxt);
            }
            return this.deserializeFromObject(p, ctxt);
        }
        return this._deserializeOther(p, ctxt, p.currentToken());
    }

    protected final Object _deserializeOther(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        if (t != null) {
            switch (t) {
                case VALUE_STRING: {
                    return this.deserializeFromString(p, ctxt);
                }
                case VALUE_NUMBER_INT: {
                    return this.deserializeFromNumber(p, ctxt);
                }
                case VALUE_NUMBER_FLOAT: {
                    return this.deserializeFromDouble(p, ctxt);
                }
                case VALUE_EMBEDDED_OBJECT: {
                    return this.deserializeFromEmbedded(p, ctxt);
                }
                case VALUE_TRUE: 
                case VALUE_FALSE: {
                    return this.deserializeFromBoolean(p, ctxt);
                }
                case VALUE_NULL: {
                    return this.deserializeFromNull(p, ctxt);
                }
                case START_ARRAY: {
                    return this._deserializeFromArray(p, ctxt);
                }
                case FIELD_NAME: 
                case END_OBJECT: {
                    if (this._vanillaProcessing) {
                        return this.vanillaDeserialize(p, ctxt, t);
                    }
                    if (this._objectIdReader != null) {
                        return this.deserializeWithObjectId(p, ctxt);
                    }
                    return this.deserializeFromObject(p, ctxt);
                }
            }
        }
        return ctxt.handleUnexpectedToken(this.getValueType(ctxt), p);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        Class<?> view;
        String propName;
        p.setCurrentValue(bean);
        if (this._injectables != null) {
            this.injectValues(ctxt, bean);
        }
        if (this._unwrappedPropertyHandler != null) {
            return this.deserializeWithUnwrapped(p, ctxt, bean);
        }
        if (this._externalTypeIdHandler != null) {
            return this.deserializeWithExternalTypeId(p, ctxt, bean);
        }
        if (p.isExpectedStartObjectToken()) {
            propName = p.nextFieldName();
            if (propName == null) {
                return bean;
            }
        } else if (p.hasTokenId(5)) {
            propName = p.currentName();
        } else {
            return bean;
        }
        if (this._needViewProcesing && (view = ctxt.getActiveView()) != null) {
            return this.deserializeWithView(p, ctxt, bean, view);
        }
        do {
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                try {
                    prop.deserializeAndSet(p, ctxt, bean);
                }
                catch (Exception e) {
                    this.wrapAndThrow(e, bean, propName, ctxt);
                }
                continue;
            }
            this.handleUnknownVanilla(p, ctxt, bean, propName);
        } while ((propName = p.nextFieldName()) != null);
        return bean;
    }

    private final Object vanillaDeserialize(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        if (p.hasTokenId(5)) {
            p.setCurrentValue(bean);
            String propName = p.currentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    }
                    catch (Exception e) {
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                    continue;
                }
                this.handleUnknownVanilla(p, ctxt, bean, propName);
            } while ((propName = p.nextFieldName()) != null);
        }
        return bean;
    }

    @Override
    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        Class<?> view;
        Object id;
        if (this._objectIdReader != null && this._objectIdReader.maySerializeAsObject() && p.hasTokenId(5) && this._objectIdReader.isValidReferencePropertyName(p.currentName(), p)) {
            return this.deserializeFromObjectId(p, ctxt);
        }
        if (this._nonStandardCreation) {
            if (this._unwrappedPropertyHandler != null) {
                return this.deserializeWithUnwrapped(p, ctxt);
            }
            if (this._externalTypeIdHandler != null) {
                return this.deserializeWithExternalTypeId(p, ctxt);
            }
            Object bean = this.deserializeFromObjectUsingNonDefault(p, ctxt);
            return bean;
        }
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        p.setCurrentValue(bean);
        if (p.canReadObjectId() && (id = p.getObjectId()) != null) {
            this._handleTypedObjectId(p, ctxt, bean, id);
        }
        if (this._objectIdReader != null && p.hasTokenId(2)) {
            ctxt.reportUnresolvedObjectId(this._objectIdReader, bean);
        }
        if (this._injectables != null) {
            this.injectValues(ctxt, bean);
        }
        if (this._needViewProcesing && (view = ctxt.getActiveView()) != null) {
            return this.deserializeWithView(p, ctxt, bean, view);
        }
        if (p.hasTokenId(5)) {
            String propName = p.currentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    }
                    catch (Exception e) {
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                    continue;
                }
                this.handleUnknownVanilla(p, ctxt, bean, propName);
            } while ((propName = p.nextFieldName()) != null);
        }
        return bean;
    }

    @Override
    protected Object _deserializeUsingPropertyBased(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object bean;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer unknown = null;
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        JsonToken t = p.currentToken();
        ArrayList referrings = null;
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.currentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (!buffer.readIdProperty(propName) || creatorProp != null) {
                if (creatorProp != null) {
                    if (activeView != null && !creatorProp.visibleInView(activeView)) {
                        p.skipChildren();
                    } else {
                        Object value = this._deserializeWithErrorWrapping(p, ctxt, creatorProp);
                        if (buffer.assignParameter(creatorProp, value)) {
                            Object bean2;
                            p.nextToken();
                            try {
                                bean2 = creator.build(ctxt, buffer);
                            }
                            catch (Exception e) {
                                bean2 = this.wrapInstantiationProblem(e, ctxt);
                            }
                            if (bean2 == null) {
                                return ctxt.handleInstantiationProblem(this.handledType(), null, this._creatorReturnedNullException());
                            }
                            p.setCurrentValue(bean2);
                            if (bean2.getClass() != this._beanType.getRawClass()) {
                                return this.handlePolymorphic(p, ctxt, p.streamReadConstraints(), bean2, unknown);
                            }
                            if (unknown != null) {
                                bean2 = this.handleUnknownProperties(ctxt, bean2, unknown);
                            }
                            return this.deserialize(p, ctxt, bean2);
                        }
                    }
                } else {
                    SettableBeanProperty prop = this._beanProperties.find(propName);
                    if (prop != null && (!this._beanType.isRecordType() || prop instanceof MethodProperty)) {
                        try {
                            buffer.bufferProperty(prop, this._deserializeWithErrorWrapping(p, ctxt, prop));
                        }
                        catch (UnresolvedForwardReference reference) {
                            BeanReferring referring = this.handleUnresolvedReference(ctxt, prop, buffer, reference);
                            if (referrings == null) {
                                referrings = new ArrayList();
                            }
                            referrings.add((Object)referring);
                        }
                    } else if (IgnorePropertiesUtil.shouldIgnore(propName, (Collection<String>)this._ignorableProps, (Collection<String>)this._includableProps)) {
                        this.handleIgnoredProperty(p, ctxt, this.handledType(), propName);
                    } else if (this._anySetter != null) {
                        try {
                            buffer.bufferAnyProperty(this._anySetter, propName, this._anySetter.deserialize(p, ctxt));
                        }
                        catch (Exception e) {
                            this.wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                        }
                    } else if (this._ignoreAllUnknown) {
                        p.skipChildren();
                    } else {
                        if (unknown == null) {
                            unknown = ctxt.bufferForInputBuffering(p);
                        }
                        unknown.writeFieldName(propName);
                        unknown.copyCurrentStructure(p);
                    }
                }
            }
            t = p.nextToken();
        }
        try {
            bean = creator.build(ctxt, buffer);
        }
        catch (Exception e) {
            return this.wrapInstantiationProblem(e, ctxt);
        }
        if (this._injectables != null) {
            this.injectValues(ctxt, bean);
        }
        if (referrings != null) {
            for (BeanReferring referring : referrings) {
                referring.setBean(bean);
            }
        }
        if (unknown != null) {
            if (bean.getClass() != this._beanType.getRawClass()) {
                return this.handlePolymorphic(null, ctxt, p.streamReadConstraints(), bean, unknown);
            }
            return this.handleUnknownProperties(ctxt, bean, unknown);
        }
        return bean;
    }

    private BeanReferring handleUnresolvedReference(DeserializationContext ctxt, SettableBeanProperty prop, PropertyValueBuffer buffer, UnresolvedForwardReference reference) throws JsonMappingException {
        BeanReferring referring = new BeanReferring(ctxt, reference, prop.getType(), buffer, prop);
        reference.getRoid().appendReferring(referring);
        return referring;
    }

    protected final Object _deserializeWithErrorWrapping(JsonParser p, DeserializationContext ctxt, SettableBeanProperty prop) throws IOException {
        try {
            return prop.deserialize(p, ctxt);
        }
        catch (Exception e) {
            this.wrapAndThrow(e, this._beanType.getRawClass(), prop.getName(), ctxt);
            return null;
        }
    }

    protected Object deserializeFromNull(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.requiresCustomCodec()) {
            TokenBuffer tb = ctxt.bufferForInputBuffering(p);
            tb.writeEndObject();
            JsonParser p2 = tb.asParser(p);
            p2.nextToken();
            Object ob = this._vanillaProcessing ? this.vanillaDeserialize(p2, ctxt, JsonToken.END_OBJECT) : this.deserializeFromObject(p2, ctxt);
            p2.close();
            return ob;
        }
        return ctxt.handleUnexpectedToken(this.getValueType(ctxt), p);
    }

    @Override
    protected Object _deserializeFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer delegateDeser = this._arrayDelegateDeserializer;
        if (delegateDeser != null || (delegateDeser = this._delegateDeserializer) != null) {
            Object bean = this._valueInstantiator.createUsingArrayDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                this.injectValues(ctxt, bean);
            }
            return bean;
        }
        CoercionAction act = this._findCoercionFromEmptyArray(ctxt);
        boolean unwrap = ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (unwrap || act != CoercionAction.Fail) {
            JsonToken unwrappedToken = p.nextToken();
            if (unwrappedToken == JsonToken.END_ARRAY) {
                switch (act) {
                    case AsEmpty: {
                        return this.getEmptyValue(ctxt);
                    }
                    case AsNull: 
                    case TryConvert: {
                        return this.getNullValue(ctxt);
                    }
                }
                return ctxt.handleUnexpectedToken(this.getValueType(ctxt), JsonToken.START_ARRAY, p, null, new Object[0]);
            }
            if (unwrap) {
                if (unwrappedToken == JsonToken.START_ARRAY) {
                    JavaType targetType = this.getValueType(ctxt);
                    return ctxt.handleUnexpectedToken(targetType, JsonToken.START_ARRAY, p, "Cannot deserialize value of type %s from deeply-nested Array: only single wrapper allowed with `%s`", ClassUtil.getTypeDescription(targetType), "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS");
                }
                Object value = this.deserialize(p, ctxt);
                if (p.nextToken() != JsonToken.END_ARRAY) {
                    this.handleMissingEndArrayForSingle(p, ctxt);
                }
                return value;
            }
        }
        return ctxt.handleUnexpectedToken(this.getValueType(ctxt), p);
    }

    protected final Object deserializeWithView(JsonParser p, DeserializationContext ctxt, Object bean, Class<?> activeView) throws IOException {
        if (p.hasTokenId(5)) {
            String propName = p.currentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    if (!prop.visibleInView(activeView)) {
                        p.skipChildren();
                        continue;
                    }
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    }
                    catch (Exception e) {
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                    continue;
                }
                this.handleUnknownVanilla(p, ctxt, bean, propName);
            } while ((propName = p.nextFieldName()) != null);
        }
        return bean;
    }

    protected Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
        String propName;
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, this._delegateDeserializer.deserialize(p, ctxt));
        }
        if (this._propertyBasedCreator != null) {
            return this.deserializeUsingPropertyBasedWithUnwrapped(p, ctxt);
        }
        TokenBuffer tokens = ctxt.bufferForInputBuffering(p);
        tokens.writeStartObject();
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        p.setCurrentValue(bean);
        if (this._injectables != null) {
            this.injectValues(ctxt, bean);
        }
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        String string = propName = p.hasTokenId(5) ? p.currentName() : null;
        while (propName != null) {
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                if (activeView != null && !prop.visibleInView(activeView)) {
                    p.skipChildren();
                } else {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    }
                    catch (Exception e) {
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                }
            } else if (IgnorePropertiesUtil.shouldIgnore(propName, (Collection<String>)this._ignorableProps, (Collection<String>)this._includableProps)) {
                this.handleIgnoredProperty(p, ctxt, bean, propName);
            } else if (this._anySetter == null) {
                tokens.writeFieldName(propName);
                tokens.copyCurrentStructure(p);
            } else {
                TokenBuffer b2 = ctxt.bufferAsCopyOfValue(p);
                tokens.writeFieldName(propName);
                tokens.append(b2);
                try {
                    this._anySetter.deserializeAndSet(b2.asParserOnFirstToken(), ctxt, bean, propName);
                }
                catch (Exception e) {
                    this.wrapAndThrow(e, bean, propName, ctxt);
                }
            }
            propName = p.nextFieldName();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        return bean;
    }

    protected Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        Class<?> activeView;
        JsonToken t = p.currentToken();
        if (t == JsonToken.START_OBJECT) {
            t = p.nextToken();
        }
        TokenBuffer tokens = ctxt.bufferForInputBuffering(p);
        tokens.writeStartObject();
        Class<?> clazz = activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.currentName();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            p.nextToken();
            if (prop != null) {
                if (activeView != null && !prop.visibleInView(activeView)) {
                    p.skipChildren();
                } else {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    }
                    catch (Exception e) {
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                }
            } else if (IgnorePropertiesUtil.shouldIgnore(propName, (Collection<String>)this._ignorableProps, (Collection<String>)this._includableProps)) {
                this.handleIgnoredProperty(p, ctxt, bean, propName);
            } else if (this._anySetter == null) {
                tokens.writeFieldName(propName);
                tokens.copyCurrentStructure(p);
            } else {
                TokenBuffer b2 = ctxt.bufferAsCopyOfValue(p);
                tokens.writeFieldName(propName);
                tokens.append(b2);
                try {
                    this._anySetter.deserializeAndSet(b2.asParserOnFirstToken(), ctxt, bean, propName);
                }
                catch (Exception e) {
                    this.wrapAndThrow(e, bean, propName, ctxt);
                }
            }
            t = p.nextToken();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        return bean;
    }

    protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object bean;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer tokens = ctxt.bufferForInputBuffering(p);
        tokens.writeStartObject();
        JsonToken t = p.currentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.currentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (!buffer.readIdProperty(propName) || creatorProp != null) {
                if (creatorProp != null) {
                    if (buffer.assignParameter(creatorProp, this._deserializeWithErrorWrapping(p, ctxt, creatorProp))) {
                        Object bean2;
                        t = p.nextToken();
                        try {
                            bean2 = creator.build(ctxt, buffer);
                        }
                        catch (Exception e) {
                            bean2 = this.wrapInstantiationProblem(e, ctxt);
                        }
                        p.setCurrentValue(bean2);
                        while (t == JsonToken.FIELD_NAME) {
                            tokens.copyCurrentStructure(p);
                            t = p.nextToken();
                        }
                        if (t != JsonToken.END_OBJECT) {
                            ctxt.reportWrongTokenException(this, JsonToken.END_OBJECT, "Attempted to unwrap '%s' value", this.handledType().getName());
                        }
                        tokens.writeEndObject();
                        if (bean2.getClass() != this._beanType.getRawClass()) {
                            return ctxt.reportInputMismatch(creatorProp, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                        }
                        return this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean2, tokens);
                    }
                } else {
                    SettableBeanProperty prop = this._beanProperties.find(propName);
                    if (prop != null) {
                        buffer.bufferProperty(prop, this._deserializeWithErrorWrapping(p, ctxt, prop));
                    } else if (IgnorePropertiesUtil.shouldIgnore(propName, (Collection<String>)this._ignorableProps, (Collection<String>)this._includableProps)) {
                        this.handleIgnoredProperty(p, ctxt, this.handledType(), propName);
                    } else if (this._anySetter == null) {
                        tokens.writeFieldName(propName);
                        tokens.copyCurrentStructure(p);
                    } else {
                        TokenBuffer b2 = ctxt.bufferAsCopyOfValue(p);
                        tokens.writeFieldName(propName);
                        tokens.append(b2);
                        try {
                            buffer.bufferAnyProperty(this._anySetter, propName, this._anySetter.deserialize(b2.asParserOnFirstToken(), ctxt));
                        }
                        catch (Exception e) {
                            this.wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                        }
                    }
                }
            }
            t = p.nextToken();
        }
        try {
            bean = creator.build(ctxt, buffer);
        }
        catch (Exception e) {
            return this.wrapInstantiationProblem(e, ctxt);
        }
        return this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
    }

    protected Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return this.deserializeUsingPropertyBasedWithExternalTypeId(p, ctxt);
        }
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, this._delegateDeserializer.deserialize(p, ctxt));
        }
        return this.deserializeWithExternalTypeId(p, ctxt, this._valueInstantiator.createUsingDefault(ctxt));
    }

    protected Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        return this._deserializeWithExternalTypeId(p, ctxt, bean, this._externalTypeIdHandler.start());
    }

    protected Object _deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt, Object bean, ExternalTypeHandler ext) throws IOException {
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        JsonToken t = p.currentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.currentName();
            t = p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                if (t.isScalarValue()) {
                    ext.handleTypePropertyValue(p, ctxt, propName, bean);
                }
                if (activeView != null && !prop.visibleInView(activeView)) {
                    p.skipChildren();
                } else {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    }
                    catch (Exception e) {
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                }
            } else if (IgnorePropertiesUtil.shouldIgnore(propName, (Collection<String>)this._ignorableProps, (Collection<String>)this._includableProps)) {
                this.handleIgnoredProperty(p, ctxt, bean, propName);
            } else if (!ext.handlePropertyValue(p, ctxt, propName, bean)) {
                if (this._anySetter != null) {
                    try {
                        this._anySetter.deserializeAndSet(p, ctxt, bean, propName);
                    }
                    catch (Exception e) {
                        this.wrapAndThrow(e, bean, propName, ctxt);
                    }
                } else {
                    this.handleUnknownProperty(p, ctxt, bean, propName);
                }
            }
            t = p.nextToken();
        }
        return ext.complete(p, ctxt, bean);
    }

    protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser p, DeserializationContext ctxt) throws IOException {
        ExternalTypeHandler ext = this._externalTypeIdHandler.start();
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        JsonToken t = p.currentToken();
        while (t == JsonToken.FIELD_NAME) {
            block20: {
                String propName = p.currentName();
                t = p.nextToken();
                SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
                if (!buffer.readIdProperty(propName) || creatorProp != null) {
                    if (creatorProp != null) {
                        if (!ext.handlePropertyValue(p, ctxt, propName, null) && buffer.assignParameter(creatorProp, this._deserializeWithErrorWrapping(p, ctxt, creatorProp))) {
                            Object bean;
                            t = p.nextToken();
                            try {
                                bean = creator.build(ctxt, buffer);
                            }
                            catch (Exception e) {
                                this.wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                                break block20;
                            }
                            if (bean.getClass() != this._beanType.getRawClass()) {
                                return ctxt.reportBadDefinition(this._beanType, String.format((String)"Cannot create polymorphic instances with external type ids (%s -> %s)", (Object[])new Object[]{this._beanType, bean.getClass()}));
                            }
                            return this._deserializeWithExternalTypeId(p, ctxt, bean, ext);
                        }
                    } else {
                        SettableBeanProperty prop = this._beanProperties.find(propName);
                        if (prop != null) {
                            if (t.isScalarValue()) {
                                ext.handleTypePropertyValue(p, ctxt, propName, null);
                            }
                            if (activeView != null && !prop.visibleInView(activeView)) {
                                p.skipChildren();
                            } else {
                                buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
                            }
                        } else if (!ext.handlePropertyValue(p, ctxt, propName, null)) {
                            if (IgnorePropertiesUtil.shouldIgnore(propName, (Collection<String>)this._ignorableProps, (Collection<String>)this._includableProps)) {
                                this.handleIgnoredProperty(p, ctxt, this.handledType(), propName);
                            } else if (this._anySetter != null) {
                                buffer.bufferAnyProperty(this._anySetter, propName, this._anySetter.deserialize(p, ctxt));
                            } else {
                                this.handleUnknownProperty(p, ctxt, this._valueClass, propName);
                            }
                        }
                    }
                }
            }
            t = p.nextToken();
        }
        try {
            return ext.complete(p, ctxt, buffer, creator);
        }
        catch (Exception e) {
            return this.wrapInstantiationProblem(e, ctxt);
        }
    }

    protected Exception _creatorReturnedNullException() {
        if (this._nullFromCreator == null) {
            this._nullFromCreator = new NullPointerException("JSON Creator returned null");
        }
        return this._nullFromCreator;
    }

    static class BeanReferring
    extends ReadableObjectId.Referring {
        private final DeserializationContext _context;
        private final SettableBeanProperty _prop;
        private Object _bean;

        BeanReferring(DeserializationContext ctxt, UnresolvedForwardReference ref, JavaType valueType, PropertyValueBuffer buffer, SettableBeanProperty prop) {
            super(ref, valueType);
            this._context = ctxt;
            this._prop = prop;
        }

        public void setBean(Object bean) {
            this._bean = bean;
        }

        @Override
        public void handleResolvedForwardReference(Object id, Object value) throws IOException {
            if (this._bean == null) {
                this._context.reportInputMismatch(this._prop, "Cannot resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", this._prop.getName(), this._prop.getDeclaringClass().getName());
            }
            this._prop.set(this._bean, value);
        }
    }
}

