/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Member
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.MergingSettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.NativeImageUtil;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BeanDeserializerBase
extends StdDeserializer<Object>
implements ContextualDeserializer,
ResolvableDeserializer,
ValueInstantiator.Gettable,
Serializable {
    private static final long serialVersionUID = 1L;
    protected static final PropertyName TEMP_PROPERTY_NAME = new PropertyName("#temporary-name");
    protected final JavaType _beanType;
    protected final JsonFormat.Shape _serializationShape;
    protected final ValueInstantiator _valueInstantiator;
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected JsonDeserializer<Object> _arrayDelegateDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected boolean _nonStandardCreation;
    protected boolean _vanillaProcessing;
    protected final BeanPropertyMap _beanProperties;
    protected final ValueInjector[] _injectables;
    protected SettableAnyProperty _anySetter;
    protected final Set<String> _ignorableProps;
    protected final Set<String> _includableProps;
    protected final boolean _ignoreAllUnknown;
    protected final boolean _needViewProcesing;
    protected final Map<String, SettableBeanProperty> _backRefs;
    protected transient HashMap<ClassKey, JsonDeserializer<Object>> _subDeserializers;
    protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
    protected ExternalTypeHandler _externalTypeIdHandler;
    protected final ObjectIdReader _objectIdReader;

    protected BeanDeserializerBase(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, Set<String> ignorableProps, boolean ignoreAllUnknown, Set<String> includableProps, boolean hasViews) {
        super(beanDesc.getType());
        this._beanType = beanDesc.getType();
        this._valueInstantiator = builder.getValueInstantiator();
        this._delegateDeserializer = null;
        this._arrayDelegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._beanProperties = properties;
        this._backRefs = backRefs;
        this._ignorableProps = ignorableProps;
        this._ignoreAllUnknown = ignoreAllUnknown;
        this._includableProps = includableProps;
        this._anySetter = builder.getAnySetter();
        List<ValueInjector> injectables = builder.getInjectables();
        this._injectables = injectables == null || injectables.isEmpty() ? null : (ValueInjector[])injectables.toArray((Object[])new ValueInjector[injectables.size()]);
        this._objectIdReader = builder.getObjectIdReader();
        this._nonStandardCreation = this._unwrappedPropertyHandler != null || this._valueInstantiator.canCreateUsingDelegate() || this._valueInstantiator.canCreateFromObjectWith() || !this._valueInstantiator.canCreateUsingDefault();
        JsonFormat.Value format = beanDesc.findExpectedFormat(null);
        this._serializationShape = format.getShape();
        this._needViewProcesing = hasViews;
        this._vanillaProcessing = !this._nonStandardCreation && this._injectables == null && !this._needViewProcesing && this._objectIdReader == null;
    }

    protected BeanDeserializerBase(BeanDeserializerBase src) {
        this(src, src._ignoreAllUnknown);
    }

    protected BeanDeserializerBase(BeanDeserializerBase src, boolean ignoreAllUnknown) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._arrayDelegateDeserializer = src._arrayDelegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._beanProperties = src._beanProperties;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = ignoreAllUnknown;
        this._includableProps = src._includableProps;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._objectIdReader = src._objectIdReader;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = src._vanillaProcessing;
        this._externalTypeIdHandler = src._externalTypeIdHandler;
    }

    protected BeanDeserializerBase(BeanDeserializerBase src, NameTransformer unwrapper) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._arrayDelegateDeserializer = src._arrayDelegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = unwrapper != null || src._ignoreAllUnknown;
        this._includableProps = src._includableProps;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._objectIdReader = src._objectIdReader;
        this._nonStandardCreation = src._nonStandardCreation;
        UnwrappedPropertyHandler uph = src._unwrappedPropertyHandler;
        if (unwrapper != null) {
            if (uph != null) {
                uph = uph.renameAll(unwrapper);
            }
            this._beanProperties = src._beanProperties.renameAll(unwrapper);
        } else {
            this._beanProperties = src._beanProperties;
        }
        this._unwrappedPropertyHandler = uph;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = false;
        this._externalTypeIdHandler = src._externalTypeIdHandler;
    }

    public BeanDeserializerBase(BeanDeserializerBase src, ObjectIdReader oir) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._arrayDelegateDeserializer = src._arrayDelegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = src._ignoreAllUnknown;
        this._includableProps = src._includableProps;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._objectIdReader = oir;
        if (oir == null) {
            this._beanProperties = src._beanProperties;
            this._vanillaProcessing = src._vanillaProcessing;
        } else {
            ObjectIdValueProperty idProp = new ObjectIdValueProperty(oir, PropertyMetadata.STD_REQUIRED);
            this._beanProperties = src._beanProperties.withProperty(idProp);
            this._vanillaProcessing = false;
        }
        this._externalTypeIdHandler = src._externalTypeIdHandler;
    }

    public BeanDeserializerBase(BeanDeserializerBase src, Set<String> ignorableProps, Set<String> includableProps) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._arrayDelegateDeserializer = src._arrayDelegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._backRefs = src._backRefs;
        this._ignorableProps = ignorableProps;
        this._ignoreAllUnknown = src._ignoreAllUnknown;
        this._includableProps = includableProps;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = src._vanillaProcessing;
        this._objectIdReader = src._objectIdReader;
        this._beanProperties = src._beanProperties.withoutProperties((Collection<String>)ignorableProps, (Collection<String>)includableProps);
        this._externalTypeIdHandler = src._externalTypeIdHandler;
    }

    protected BeanDeserializerBase(BeanDeserializerBase src, BeanPropertyMap beanProps) {
        super(src._beanType);
        this._beanType = src._beanType;
        this._valueInstantiator = src._valueInstantiator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._arrayDelegateDeserializer = src._arrayDelegateDeserializer;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._beanProperties = beanProps;
        this._backRefs = src._backRefs;
        this._ignorableProps = src._ignorableProps;
        this._ignoreAllUnknown = src._ignoreAllUnknown;
        this._includableProps = src._includableProps;
        this._anySetter = src._anySetter;
        this._injectables = src._injectables;
        this._objectIdReader = src._objectIdReader;
        this._nonStandardCreation = src._nonStandardCreation;
        this._unwrappedPropertyHandler = src._unwrappedPropertyHandler;
        this._needViewProcesing = src._needViewProcesing;
        this._serializationShape = src._serializationShape;
        this._vanillaProcessing = src._vanillaProcessing;
        this._externalTypeIdHandler = src._externalTypeIdHandler;
    }

    @Deprecated
    protected BeanDeserializerBase(BeanDeserializerBase src, Set<String> ignorableProps) {
        this(src, ignorableProps, src._includableProps);
    }

    @Override
    public abstract JsonDeserializer<Object> unwrappingDeserializer(NameTransformer var1);

    public abstract BeanDeserializerBase withObjectIdReader(ObjectIdReader var1);

    public abstract BeanDeserializerBase withByNameInclusion(Set<String> var1, Set<String> var2);

    public abstract BeanDeserializerBase withIgnoreAllUnknown(boolean var1);

    public BeanDeserializerBase withBeanProperties(BeanPropertyMap props) {
        throw new UnsupportedOperationException("Class " + this.getClass().getName() + " does not override `withBeanProperties()`, needs to");
    }

    protected abstract BeanDeserializerBase asArrayDeserializer();

    @Deprecated
    public BeanDeserializerBase withIgnorableProperties(Set<String> ignorableProps) {
        return this.withByNameInclusion(ignorableProps, this._includableProps);
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        JavaType delegateType;
        SettableBeanProperty[] creatorProps;
        ExternalTypeHandler.Builder extTypes = null;
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            creatorProps = this._valueInstantiator.getFromObjectArguments(ctxt.getConfig());
            if (this._ignorableProps != null || this._includableProps != null) {
                int end = creatorProps.length;
                for (int i = 0; i < end; ++i) {
                    SettableBeanProperty prop = creatorProps[i];
                    if (!IgnorePropertiesUtil.shouldIgnore(prop.getName(), this._ignorableProps, this._includableProps)) continue;
                    creatorProps[i].markAsIgnorable();
                }
            }
        } else {
            creatorProps = null;
        }
        UnwrappedPropertyHandler unwrapped = null;
        for (SettableBeanProperty prop : this._beanProperties) {
            if (prop.hasValueDeserializer()) continue;
            JsonDeserializer<Object> deser = this.findConvertingDeserializer(ctxt, prop);
            if (deser == null) {
                deser = ctxt.findNonContextualValueDeserializer(prop.getType());
            }
            SettableBeanProperty newProp = prop.withValueDeserializer(deser);
            this._replaceProperty(this._beanProperties, creatorProps, prop, newProp);
        }
        Iterator<SettableBeanProperty> end = this._beanProperties.iterator();
        while (end.hasNext()) {
            TypeDeserializer typeDeser;
            JsonDeserializer<Object> orig;
            JsonDeserializer<Object> unwrapping;
            NameTransformer xform;
            SettableBeanProperty origProp;
            SettableBeanProperty prop = origProp = (SettableBeanProperty)end.next();
            JsonDeserializer<Object> deser = prop.getValueDeserializer();
            deser = ctxt.handlePrimaryContextualization(deser, prop, prop.getType());
            prop = prop.withValueDeserializer(deser);
            if (!((prop = this._resolveManagedReferenceProperty(ctxt, prop)) instanceof ManagedReferenceProperty)) {
                prop = this._resolvedObjectIdProperty(ctxt, prop);
            }
            if ((xform = this._findPropertyUnwrapper(ctxt, prop)) != null && (unwrapping = (orig = prop.getValueDeserializer()).unwrappingDeserializer(xform)) != orig && unwrapping != null) {
                prop = prop.withValueDeserializer(unwrapping);
                if (unwrapped == null) {
                    unwrapped = new UnwrappedPropertyHandler();
                }
                unwrapped.addProperty(prop);
                this._beanProperties.remove(prop);
                continue;
            }
            PropertyMetadata md = prop.getMetadata();
            prop = this._resolveMergeAndNullSettings(ctxt, prop, md);
            if ((prop = this._resolveInnerClassValuedProperty(ctxt, prop)) != origProp) {
                this._replaceProperty(this._beanProperties, creatorProps, origProp, prop);
            }
            if (!prop.hasValueTypeDeserializer() || (typeDeser = prop.getValueTypeDeserializer()).getTypeInclusion() != JsonTypeInfo.As.EXTERNAL_PROPERTY) continue;
            if (extTypes == null) {
                extTypes = ExternalTypeHandler.builder(this._beanType);
            }
            extTypes.addExternal(prop, typeDeser);
            this._beanProperties.remove(prop);
        }
        if (this._anySetter != null && !this._anySetter.hasValueDeserializer()) {
            this._anySetter = this._anySetter.withValueDeserializer(this.findDeserializer(ctxt, this._anySetter.getType(), this._anySetter.getProperty()));
        }
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            delegateType = this._valueInstantiator.getDelegateType(ctxt.getConfig());
            if (delegateType == null) {
                ctxt.reportBadDefinition(this._beanType, String.format((String)"Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", (Object[])new Object[]{ClassUtil.getTypeDescription(this._beanType), ClassUtil.classNameOf(this._valueInstantiator)}));
            }
            this._delegateDeserializer = this._findDelegateDeserializer(ctxt, delegateType, this._valueInstantiator.getDelegateCreator());
        }
        if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            delegateType = this._valueInstantiator.getArrayDelegateType(ctxt.getConfig());
            if (delegateType == null) {
                ctxt.reportBadDefinition(this._beanType, String.format((String)"Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", (Object[])new Object[]{ClassUtil.getTypeDescription(this._beanType), ClassUtil.classNameOf(this._valueInstantiator)}));
            }
            this._arrayDelegateDeserializer = this._findDelegateDeserializer(ctxt, delegateType, this._valueInstantiator.getArrayDelegateCreator());
        }
        if (creatorProps != null) {
            this._propertyBasedCreator = PropertyBasedCreator.construct(ctxt, this._valueInstantiator, creatorProps, this._beanProperties);
        }
        if (extTypes != null) {
            this._externalTypeIdHandler = extTypes.build(this._beanProperties);
            this._nonStandardCreation = true;
        }
        this._unwrappedPropertyHandler = unwrapped;
        if (unwrapped != null) {
            this._nonStandardCreation = true;
        }
        this._vanillaProcessing = this._vanillaProcessing && !this._nonStandardCreation;
    }

    protected void _replaceProperty(BeanPropertyMap props, SettableBeanProperty[] creatorProps, SettableBeanProperty origProp, SettableBeanProperty newProp) {
        props.replace(origProp, newProp);
        if (creatorProps != null) {
            int len = creatorProps.length;
            for (int i = 0; i < len; ++i) {
                if (creatorProps[i] != origProp) continue;
                creatorProps[i] = newProp;
                return;
            }
        }
    }

    private JsonDeserializer<Object> _findDelegateDeserializer(DeserializationContext ctxt, JavaType delegateType, AnnotatedWithParams delegateCreator) throws JsonMappingException {
        JsonDeserializer<Object> dd;
        BeanProperty.Std property;
        if (delegateCreator != null && delegateCreator.getParameterCount() == 1) {
            AnnotatedParameter delegator = delegateCreator.getParameter(0);
            PropertyMetadata propMd = this._getSetterInfo(ctxt, delegator, delegateType);
            property = new BeanProperty.Std(TEMP_PROPERTY_NAME, delegateType, null, delegator, propMd);
        } else {
            property = new BeanProperty.Std(TEMP_PROPERTY_NAME, delegateType, null, delegateCreator, PropertyMetadata.STD_OPTIONAL);
        }
        TypeDeserializer td = (TypeDeserializer)delegateType.getTypeHandler();
        if (td == null) {
            td = ctxt.getConfig().findTypeDeserializer(delegateType);
        }
        dd = (dd = (JsonDeserializer<Object>)delegateType.getValueHandler()) == null ? this.findDeserializer(ctxt, delegateType, property) : ctxt.handleSecondaryContextualization(dd, property, delegateType);
        if (td != null) {
            td = td.forProperty(property);
            return new TypeWrappedDeserializer(td, dd);
        }
        return dd;
    }

    protected PropertyMetadata _getSetterInfo(DeserializationContext ctxt, AnnotatedMember accessor, JavaType type) {
        ConfigOverride co;
        JsonSetter.Value setterInfo;
        JsonSetter.Value setterInfo2;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        DeserializationConfig config = ctxt.getConfig();
        PropertyMetadata metadata = PropertyMetadata.STD_OPTIONAL;
        boolean needMerge = true;
        Nulls valueNulls = null;
        Nulls contentNulls = null;
        if (intr != null && (setterInfo2 = intr.findSetterInfo(accessor)) != null) {
            valueNulls = setterInfo2.nonDefaultValueNulls();
            contentNulls = setterInfo2.nonDefaultContentNulls();
        }
        if ((needMerge || valueNulls == null || contentNulls == null) && (setterInfo = (co = config.getConfigOverride(type.getRawClass())).getSetterInfo()) != null) {
            if (valueNulls == null) {
                valueNulls = setterInfo.nonDefaultValueNulls();
            }
            if (contentNulls == null) {
                contentNulls = setterInfo.nonDefaultContentNulls();
            }
        }
        if (needMerge || valueNulls == null || contentNulls == null) {
            setterInfo2 = config.getDefaultSetterInfo();
            if (valueNulls == null) {
                valueNulls = setterInfo2.nonDefaultValueNulls();
            }
            if (contentNulls == null) {
                contentNulls = setterInfo2.nonDefaultContentNulls();
            }
        }
        if (valueNulls != null || contentNulls != null) {
            metadata = metadata.withNulls(valueNulls, contentNulls);
        }
        return metadata;
    }

    protected JsonDeserializer<Object> findConvertingDeserializer(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        Object convDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null && (convDef = intr.findDeserializationConverter(prop.getMember())) != null) {
            Converter<Object, Object> conv = ctxt.converterInstance(prop.getMember(), convDef);
            JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
            JsonDeserializer<Object> deser = ctxt.findNonContextualValueDeserializer(delegateType);
            return new StdDelegatingDeserializer<Object>(conv, delegateType, deser);
        }
        return null;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        ObjectIdInfo objectIdInfo;
        AnnotatedMember accessor;
        ObjectIdReader oir = this._objectIdReader;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        AnnotatedMember annotatedMember = accessor = BeanDeserializerBase._neitherNull(property, intr) ? property.getMember() : null;
        if (accessor != null && (objectIdInfo = intr.findObjectIdInfo(accessor)) != null) {
            ObjectIdGenerator idGen;
            JavaType idType;
            SettableBeanProperty idProp;
            objectIdInfo = intr.findObjectReferenceInfo(accessor, objectIdInfo);
            Class<? extends ObjectIdGenerator<?>> implClass = objectIdInfo.getGeneratorType();
            ObjectIdResolver resolver = ctxt.objectIdResolverInstance(accessor, objectIdInfo);
            if (implClass == ObjectIdGenerators.PropertyGenerator.class) {
                PropertyName propName = objectIdInfo.getPropertyName();
                idProp = this.findProperty(propName);
                if (idProp == null) {
                    return (JsonDeserializer)ctxt.reportBadDefinition(this._beanType, String.format((String)"Invalid Object Id definition for %s: cannot find property with name %s", (Object[])new Object[]{ClassUtil.nameOf(this.handledType()), ClassUtil.name(propName)}));
                }
                idType = idProp.getType();
                idGen = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
            } else {
                JavaType type = ctxt.constructType(implClass);
                idType = ctxt.getTypeFactory().findTypeParameters(type, ObjectIdGenerator.class)[0];
                idProp = null;
                idGen = ctxt.objectIdGeneratorInstance(accessor, objectIdInfo);
            }
            JsonDeserializer<Object> deser = ctxt.findRootValueDeserializer(idType);
            oir = ObjectIdReader.construct(idType, objectIdInfo.getPropertyName(), idGen, deser, idProp, resolver);
        }
        BeanDeserializerBase contextual = this;
        if (oir != null && oir != this._objectIdReader) {
            contextual = contextual.withObjectIdReader(oir);
        }
        if (accessor != null) {
            contextual = this._handleByNameInclusion(ctxt, intr, contextual, accessor);
        }
        JsonFormat.Value format = this.findFormatOverrides(ctxt, property, this.handledType());
        JsonFormat.Shape shape = null;
        if (format != null) {
            BeanPropertyMap propsOrig;
            BeanPropertyMap props;
            Boolean B;
            if (format.hasShape()) {
                shape = format.getShape();
            }
            if ((B = format.getFeature(JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)) != null && (props = (propsOrig = this._beanProperties).withCaseInsensitivity(B)) != propsOrig) {
                contextual = contextual.withBeanProperties(props);
            }
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        if (shape == JsonFormat.Shape.ARRAY) {
            contextual = contextual.asArrayDeserializer();
        }
        return contextual;
    }

    protected BeanDeserializerBase _handleByNameInclusion(DeserializationContext ctxt, AnnotationIntrospector intr, BeanDeserializerBase contextual, AnnotatedMember accessor) throws JsonMappingException {
        HashSet newNamesToIgnore;
        DeserializationConfig config = ctxt.getConfig();
        JsonIgnoreProperties.Value ignorals = intr.findPropertyIgnoralByName(config, accessor);
        if (ignorals.getIgnoreUnknown() && !this._ignoreAllUnknown) {
            contextual = contextual.withIgnoreAllUnknown(true);
        }
        Set<String> namesToIgnore = ignorals.findIgnoredForDeserialization();
        HashSet prevNamesToIgnore = contextual._ignorableProps;
        if (namesToIgnore.isEmpty()) {
            newNamesToIgnore = prevNamesToIgnore;
        } else if (prevNamesToIgnore == null || prevNamesToIgnore.isEmpty()) {
            newNamesToIgnore = namesToIgnore;
        } else {
            newNamesToIgnore = new HashSet(prevNamesToIgnore);
            newNamesToIgnore.addAll(namesToIgnore);
        }
        Set<String> prevNamesToInclude = contextual._includableProps;
        Set<String> newNamesToInclude = IgnorePropertiesUtil.combineNamesToInclude(prevNamesToInclude, intr.findPropertyInclusionByName(config, accessor).getIncluded());
        if (newNamesToIgnore != prevNamesToIgnore || newNamesToInclude != prevNamesToInclude) {
            contextual = contextual.withByNameInclusion((Set<String>)newNamesToIgnore, newNamesToInclude);
        }
        return contextual;
    }

    protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        String refName = prop.getManagedReferenceName();
        if (refName == null) {
            return prop;
        }
        JsonDeserializer<Object> valueDeser = prop.getValueDeserializer();
        SettableBeanProperty backProp = valueDeser.findBackReference(refName);
        if (backProp == null) {
            return (SettableBeanProperty)ctxt.reportBadDefinition(this._beanType, String.format((String)"Cannot handle managed/back reference %s: no back reference property found from type %s", (Object[])new Object[]{ClassUtil.name(refName), ClassUtil.getTypeDescription(prop.getType())}));
        }
        JavaType referredType = this._beanType;
        JavaType backRefType = backProp.getType();
        boolean isContainer = prop.getType().isContainerType();
        if (!backRefType.getRawClass().isAssignableFrom(referredType.getRawClass())) {
            ctxt.reportBadDefinition(this._beanType, String.format((String)"Cannot handle managed/back reference %s: back reference type (%s) not compatible with managed type (%s)", (Object[])new Object[]{ClassUtil.name(refName), ClassUtil.getTypeDescription(backRefType), referredType.getRawClass().getName()}));
        }
        return new ManagedReferenceProperty(prop, refName, backProp, isContainer);
    }

    protected SettableBeanProperty _resolvedObjectIdProperty(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        ObjectIdReader objectIdReader;
        ObjectIdInfo objectIdInfo = prop.getObjectIdInfo();
        JsonDeserializer<Object> valueDeser = prop.getValueDeserializer();
        ObjectIdReader objectIdReader2 = objectIdReader = valueDeser == null ? null : valueDeser.getObjectIdReader();
        if (objectIdInfo == null && objectIdReader == null) {
            return prop;
        }
        return new ObjectIdReferenceProperty(prop, objectIdInfo);
    }

    protected NameTransformer _findPropertyUnwrapper(DeserializationContext ctxt, SettableBeanProperty prop) throws JsonMappingException {
        NameTransformer unwrapper;
        AnnotatedMember am = prop.getMember();
        if (am != null && (unwrapper = ctxt.getAnnotationIntrospector().findUnwrappingNameTransformer(am)) != null) {
            if (prop instanceof CreatorProperty) {
                ctxt.reportBadDefinition(this.getValueType(), String.format((String)"Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", (Object[])new Object[]{prop.getName()}));
            }
            return unwrapper;
        }
        return null;
    }

    protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationContext ctxt, SettableBeanProperty prop) {
        Class<?> valueClass;
        Class<?> enclosing;
        BeanDeserializerBase bd;
        ValueInstantiator vi;
        JsonDeserializer<Object> deser = prop.getValueDeserializer();
        if (deser instanceof BeanDeserializerBase && !(vi = (bd = (BeanDeserializerBase)deser).getValueInstantiator()).canCreateUsingDefault() && (enclosing = ClassUtil.getOuterClass(valueClass = prop.getType().getRawClass())) != null && enclosing == this._beanType.getRawClass()) {
            for (Constructor ctor : valueClass.getConstructors()) {
                Class[] paramTypes;
                if (ctor.getParameterCount() != 1 || !enclosing.equals((Object)(paramTypes = ctor.getParameterTypes())[0])) continue;
                if (ctxt.canOverrideAccessModifiers()) {
                    ClassUtil.checkAndFixAccess((Member)ctor, ctxt.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
                return new InnerClassProperty(prop, ctor);
            }
        }
        return prop;
    }

    protected SettableBeanProperty _resolveMergeAndNullSettings(DeserializationContext ctxt, SettableBeanProperty prop, PropertyMetadata propMetadata) throws JsonMappingException {
        NullValueProvider nuller;
        PropertyMetadata.MergeInfo merge = propMetadata.getMergeInfo();
        if (merge != null) {
            JsonDeserializer<Object> valueDeser = prop.getValueDeserializer();
            Boolean mayMerge = valueDeser.supportsUpdate(ctxt.getConfig());
            if (mayMerge == null) {
                if (merge.fromDefaults) {
                    return prop;
                }
            } else if (!mayMerge.booleanValue()) {
                if (!merge.fromDefaults) {
                    ctxt.handleBadMerge(valueDeser);
                }
                return prop;
            }
            AnnotatedMember accessor = merge.getter;
            accessor.fixAccess(ctxt.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            if (!(prop instanceof SetterlessProperty)) {
                prop = MergingSettableBeanProperty.construct(prop, accessor);
            }
        }
        if ((nuller = this.findValueNullProvider(ctxt, prop, propMetadata)) != null) {
            prop = prop.withNullProvider(nuller);
        }
        return prop;
    }

    @Override
    public AccessPattern getNullAccessPattern() {
        return AccessPattern.ALWAYS_NULL;
    }

    @Override
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override
    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        try {
            return this._valueInstantiator.createUsingDefaultOrWithoutArguments(ctxt);
        }
        catch (IOException e) {
            return ClassUtil.throwAsMappingException(ctxt, e);
        }
    }

    @Override
    public boolean isCachable() {
        return true;
    }

    public boolean isCaseInsensitive() {
        return this._beanProperties.isCaseInsensitive();
    }

    @Override
    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.TRUE;
    }

    @Override
    public Class<?> handledType() {
        return this._beanType.getRawClass();
    }

    @Override
    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public boolean hasProperty(String propertyName) {
        return this._beanProperties.find(propertyName) != null;
    }

    public boolean hasViews() {
        return this._needViewProcesing;
    }

    public int getPropertyCount() {
        return this._beanProperties.size();
    }

    @Override
    public Collection<Object> getKnownPropertyNames() {
        ArrayList names = new ArrayList();
        for (SettableBeanProperty prop : this._beanProperties) {
            names.add((Object)prop.getName());
        }
        return names;
    }

    @Deprecated
    public final Class<?> getBeanClass() {
        return this._beanType.getRawClass();
    }

    @Override
    public JavaType getValueType() {
        return this._beanType;
    }

    @Override
    public LogicalType logicalType() {
        return LogicalType.POJO;
    }

    public Iterator<SettableBeanProperty> properties() {
        if (this._beanProperties == null) {
            throw new IllegalStateException("Can only call after BeanDeserializer has been resolved");
        }
        return this._beanProperties.iterator();
    }

    public Iterator<SettableBeanProperty> creatorProperties() {
        if (this._propertyBasedCreator == null) {
            return Collections.emptyList().iterator();
        }
        return this._propertyBasedCreator.properties().iterator();
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return this.findProperty(propertyName.getSimpleName());
    }

    public SettableBeanProperty findProperty(String propertyName) {
        SettableBeanProperty prop;
        SettableBeanProperty settableBeanProperty = prop = this._beanProperties == null ? null : this._beanProperties.find(propertyName);
        if (prop == null && this._propertyBasedCreator != null) {
            prop = this._propertyBasedCreator.findCreatorProperty(propertyName);
        }
        return prop;
    }

    public SettableBeanProperty findProperty(int propertyIndex) {
        SettableBeanProperty prop;
        SettableBeanProperty settableBeanProperty = prop = this._beanProperties == null ? null : this._beanProperties.find(propertyIndex);
        if (prop == null && this._propertyBasedCreator != null) {
            prop = this._propertyBasedCreator.findCreatorProperty(propertyIndex);
        }
        return prop;
    }

    @Override
    public SettableBeanProperty findBackReference(String logicalName) {
        if (this._backRefs == null) {
            return null;
        }
        return (SettableBeanProperty)this._backRefs.get((Object)logicalName);
    }

    @Override
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    public void replaceProperty(SettableBeanProperty original, SettableBeanProperty replacement) {
        this._beanProperties.replace(original, replacement);
    }

    public abstract Object deserializeFromObject(JsonParser var1, DeserializationContext var2) throws IOException;

    @Override
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        if (this._objectIdReader != null) {
            Object id;
            if (p.canReadObjectId() && (id = p.getObjectId()) != null) {
                Object ob = typeDeserializer.deserializeTypedFromObject(p, ctxt);
                return this._handleTypedObjectId(p, ctxt, ob, id);
            }
            JsonToken t = p.currentToken();
            if (t != null) {
                if (t.isScalarValue()) {
                    return this.deserializeFromObjectId(p, ctxt);
                }
                if (t == JsonToken.START_OBJECT) {
                    t = p.nextToken();
                }
                if (t == JsonToken.FIELD_NAME && this._objectIdReader.maySerializeAsObject() && this._objectIdReader.isValidReferencePropertyName(p.currentName(), p)) {
                    return this.deserializeFromObjectId(p, ctxt);
                }
            }
        }
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }

    protected Object _handleTypedObjectId(JsonParser p, DeserializationContext ctxt, Object pojo, Object rawId) throws IOException {
        JsonDeserializer<Object> idDeser = this._objectIdReader.getDeserializer();
        Object id = idDeser.handledType() == rawId.getClass() ? rawId : this._convertObjectId(p, ctxt, rawId, idDeser);
        ReadableObjectId roid = ctxt.findObjectId(id, this._objectIdReader.generator, this._objectIdReader.resolver);
        roid.bindItem(pojo);
        SettableBeanProperty idProp = this._objectIdReader.idProperty;
        if (idProp != null) {
            return idProp.setAndReturn(pojo, id);
        }
        return pojo;
    }

    protected Object _convertObjectId(JsonParser p, DeserializationContext ctxt, Object rawId, JsonDeserializer<Object> idDeser) throws IOException {
        TokenBuffer buf = ctxt.bufferForInputBuffering(p);
        if (rawId instanceof String) {
            buf.writeString((String)rawId);
        } else if (rawId instanceof Long) {
            buf.writeNumber((Long)rawId);
        } else if (rawId instanceof Integer) {
            buf.writeNumber((Integer)rawId);
        } else {
            buf.writeObject(rawId);
        }
        JsonParser bufParser = buf.asParser(p.streamReadConstraints());
        bufParser.nextToken();
        return idDeser.deserialize(bufParser, ctxt);
    }

    protected Object deserializeWithObjectId(JsonParser p, DeserializationContext ctxt) throws IOException {
        return this.deserializeFromObject(p, ctxt);
    }

    protected Object deserializeFromObjectId(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object id = this._objectIdReader.readObjectReference(p, ctxt);
        ReadableObjectId roid = ctxt.findObjectId(id, this._objectIdReader.generator, this._objectIdReader.resolver);
        Object pojo = roid.resolve();
        if (pojo == null) {
            throw new UnresolvedForwardReference(p, "Could not resolve Object Id [" + id + "] (for " + this._beanType + ").", p.getCurrentLocation(), roid);
        }
        return pojo;
    }

    protected Object deserializeFromObjectUsingNonDefault(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> delegateDeser = this._delegateDeserializer();
        if (delegateDeser != null) {
            Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                this.injectValues(ctxt, bean);
            }
            return bean;
        }
        if (this._propertyBasedCreator != null) {
            return this._deserializeUsingPropertyBased(p, ctxt);
        }
        Class<?> raw = this._beanType.getRawClass();
        if (ClassUtil.isNonStaticInnerClass(raw)) {
            return ctxt.handleMissingInstantiator(raw, null, p, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]);
        }
        if (NativeImageUtil.needsReflectionConfiguration(raw)) {
            return ctxt.handleMissingInstantiator(raw, null, p, "cannot deserialize from Object value (no delegate- or property-based Creator): this appears to be a native image, in which case you may need to configure reflection for the class that is to be deserialized", new Object[0]);
        }
        return ctxt.handleMissingInstantiator(raw, this.getValueInstantiator(), p, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
    }

    protected abstract Object _deserializeUsingPropertyBased(JsonParser var1, DeserializationContext var2) throws IOException;

    public Object deserializeFromNumber(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._objectIdReader != null) {
            return this.deserializeFromObjectId(p, ctxt);
        }
        JsonDeserializer<Object> delegateDeser = this._delegateDeserializer();
        JsonParser.NumberType nt = p.getNumberType();
        if (nt == JsonParser.NumberType.INT) {
            if (delegateDeser != null && !this._valueInstantiator.canCreateFromInt()) {
                Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
                if (this._injectables != null) {
                    this.injectValues(ctxt, bean);
                }
                return bean;
            }
            return this._valueInstantiator.createFromInt(ctxt, p.getIntValue());
        }
        if (nt == JsonParser.NumberType.LONG) {
            if (delegateDeser != null && !this._valueInstantiator.canCreateFromInt()) {
                Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
                if (this._injectables != null) {
                    this.injectValues(ctxt, bean);
                }
                return bean;
            }
            return this._valueInstantiator.createFromLong(ctxt, p.getLongValue());
        }
        if (nt == JsonParser.NumberType.BIG_INTEGER) {
            if (delegateDeser != null && !this._valueInstantiator.canCreateFromBigInteger()) {
                Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
                if (this._injectables != null) {
                    this.injectValues(ctxt, bean);
                }
                return bean;
            }
            return this._valueInstantiator.createFromBigInteger(ctxt, p.getBigIntegerValue());
        }
        return ctxt.handleMissingInstantiator(this.handledType(), this.getValueInstantiator(), p, "no suitable creator method found to deserialize from Number value (%s)", p.getNumberValue());
    }

    public Object deserializeFromString(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._objectIdReader != null) {
            return this.deserializeFromObjectId(p, ctxt);
        }
        JsonDeserializer<Object> delegateDeser = this._delegateDeserializer();
        if (delegateDeser != null && !this._valueInstantiator.canCreateFromString()) {
            Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                this.injectValues(ctxt, bean);
            }
            return bean;
        }
        return this._deserializeFromString(p, ctxt);
    }

    public Object deserializeFromDouble(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonParser.NumberType t = p.getNumberType();
        if (t == JsonParser.NumberType.DOUBLE || t == JsonParser.NumberType.FLOAT) {
            JsonDeserializer<Object> delegateDeser = this._delegateDeserializer();
            if (delegateDeser != null && !this._valueInstantiator.canCreateFromDouble()) {
                Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
                if (this._injectables != null) {
                    this.injectValues(ctxt, bean);
                }
                return bean;
            }
            return this._valueInstantiator.createFromDouble(ctxt, p.getDoubleValue());
        }
        if (t == JsonParser.NumberType.BIG_DECIMAL) {
            JsonDeserializer<Object> delegateDeser = this._delegateDeserializer();
            if (delegateDeser != null && !this._valueInstantiator.canCreateFromBigDecimal()) {
                Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
                if (this._injectables != null) {
                    this.injectValues(ctxt, bean);
                }
                return bean;
            }
            return this._valueInstantiator.createFromBigDecimal(ctxt, p.getDecimalValue());
        }
        return ctxt.handleMissingInstantiator(this.handledType(), this.getValueInstantiator(), p, "no suitable creator method found to deserialize from Number value (%s)", p.getNumberValue());
    }

    public Object deserializeFromBoolean(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> delegateDeser = this._delegateDeserializer();
        if (delegateDeser != null && !this._valueInstantiator.canCreateFromBoolean()) {
            Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                this.injectValues(ctxt, bean);
            }
            return bean;
        }
        boolean value = p.currentToken() == JsonToken.VALUE_TRUE;
        return this._valueInstantiator.createFromBoolean(ctxt, value);
    }

    @Deprecated
    public Object deserializeFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        return this._deserializeFromArray(p, ctxt);
    }

    public Object deserializeFromEmbedded(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._objectIdReader != null) {
            return this.deserializeFromObjectId(p, ctxt);
        }
        JsonDeserializer<Object> delegateDeser = this._delegateDeserializer();
        if (delegateDeser != null && !this._valueInstantiator.canCreateFromString()) {
            Object bean = this._valueInstantiator.createUsingDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
            if (this._injectables != null) {
                this.injectValues(ctxt, bean);
            }
            return bean;
        }
        Object value = p.getEmbeddedObject();
        if (value != null && !this._beanType.isTypeOrSuperTypeOf(value.getClass())) {
            value = ctxt.handleWeirdNativeValue(this._beanType, value, p);
        }
        return value;
    }

    protected final JsonDeserializer<Object> _delegateDeserializer() {
        JsonDeserializer<Object> deser = this._delegateDeserializer;
        if (deser == null) {
            deser = this._arrayDelegateDeserializer;
        }
        return deser;
    }

    protected void injectValues(DeserializationContext ctxt, Object bean) throws IOException {
        for (ValueInjector injector : this._injectables) {
            injector.inject(ctxt, bean);
        }
    }

    protected Object handleUnknownProperties(DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens) throws IOException {
        unknownTokens.writeEndObject();
        JsonParser bufferParser = unknownTokens.asParser();
        while (bufferParser.nextToken() != JsonToken.END_OBJECT) {
            String propName = bufferParser.currentName();
            bufferParser.nextToken();
            this.handleUnknownProperty(bufferParser, ctxt, bean, propName);
        }
        return bean;
    }

    protected void handleUnknownVanilla(JsonParser p, DeserializationContext ctxt, Object beanOrBuilder, String propName) throws IOException {
        if (IgnorePropertiesUtil.shouldIgnore(propName, this._ignorableProps, this._includableProps)) {
            this.handleIgnoredProperty(p, ctxt, beanOrBuilder, propName);
        } else if (this._anySetter != null) {
            try {
                this._anySetter.deserializeAndSet(p, ctxt, beanOrBuilder, propName);
            }
            catch (Exception e) {
                this.wrapAndThrow(e, beanOrBuilder, propName, ctxt);
            }
        } else {
            this.handleUnknownProperty(p, ctxt, beanOrBuilder, propName);
        }
    }

    @Override
    protected void handleUnknownProperty(JsonParser p, DeserializationContext ctxt, Object beanOrClass, String propName) throws IOException {
        if (this._ignoreAllUnknown) {
            p.skipChildren();
            return;
        }
        if (IgnorePropertiesUtil.shouldIgnore(propName, this._ignorableProps, this._includableProps)) {
            this.handleIgnoredProperty(p, ctxt, beanOrClass, propName);
        }
        super.handleUnknownProperty(p, ctxt, beanOrClass, propName);
    }

    protected void handleIgnoredProperty(JsonParser p, DeserializationContext ctxt, Object beanOrClass, String propName) throws IOException {
        if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)) {
            throw IgnoredPropertyException.from(p, beanOrClass, propName, this.getKnownPropertyNames());
        }
        p.skipChildren();
    }

    @Deprecated
    protected Object handlePolymorphic(JsonParser p, DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens) throws IOException {
        StreamReadConstraints streamReadConstraints = p == null ? StreamReadConstraints.defaults() : p.streamReadConstraints();
        return this.handlePolymorphic(p, ctxt, streamReadConstraints, bean, unknownTokens);
    }

    protected Object handlePolymorphic(JsonParser p, DeserializationContext ctxt, StreamReadConstraints streamReadConstraints, Object bean, TokenBuffer unknownTokens) throws IOException {
        JsonDeserializer<Object> subDeser = this._findSubclassDeserializer(ctxt, bean, unknownTokens);
        if (subDeser != null) {
            if (unknownTokens != null) {
                unknownTokens.writeEndObject();
                JsonParser p2 = unknownTokens.asParser(streamReadConstraints);
                p2.nextToken();
                bean = subDeser.deserialize(p2, ctxt, bean);
            }
            if (p != null) {
                bean = subDeser.deserialize(p, ctxt, bean);
            }
            return bean;
        }
        if (unknownTokens != null) {
            bean = this.handleUnknownProperties(ctxt, bean, unknownTokens);
        }
        if (p != null) {
            bean = this.deserialize(p, ctxt, bean);
        }
        return bean;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected JsonDeserializer<Object> _findSubclassDeserializer(DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens) throws IOException {
        JsonDeserializer<Object> subDeser;
        BeanDeserializerBase beanDeserializerBase = this;
        synchronized (beanDeserializerBase) {
            subDeser = this._subDeserializers == null ? null : (JsonDeserializer<Object>)this._subDeserializers.get((Object)new ClassKey(bean.getClass()));
        }
        if (subDeser != null) {
            return subDeser;
        }
        JavaType type = ctxt.constructType(bean.getClass());
        subDeser = ctxt.findRootValueDeserializer(type);
        if (subDeser != null) {
            BeanDeserializerBase beanDeserializerBase2 = this;
            synchronized (beanDeserializerBase2) {
                if (this._subDeserializers == null) {
                    this._subDeserializers = new HashMap();
                }
                this._subDeserializers.put((Object)new ClassKey(bean.getClass()), subDeser);
            }
        }
        return subDeser;
    }

    public void wrapAndThrow(Throwable t, Object bean, String fieldName, DeserializationContext ctxt) throws IOException {
        throw JsonMappingException.wrapWithPath(this.throwOrReturnThrowable(t, ctxt), bean, fieldName);
    }

    private Throwable throwOrReturnThrowable(Throwable t, DeserializationContext ctxt) throws IOException {
        boolean wrap;
        while (t instanceof InvocationTargetException && t.getCause() != null) {
            t = t.getCause();
        }
        ClassUtil.throwIfError(t);
        boolean bl = wrap = ctxt == null || ctxt.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS);
        if (t instanceof IOException) {
            if (!wrap || !(t instanceof JacksonException)) {
                throw (IOException)t;
            }
        } else if (!wrap) {
            ClassUtil.throwIfRTE(t);
        }
        return t;
    }

    protected Object wrapInstantiationProblem(Throwable t, DeserializationContext ctxt) throws IOException {
        while (t instanceof InvocationTargetException && t.getCause() != null) {
            t = t.getCause();
        }
        ClassUtil.throwIfError(t);
        if (t instanceof IOException) {
            throw (IOException)t;
        }
        if (ctxt == null) {
            throw new IllegalArgumentException(t.getMessage(), t);
        }
        if (!ctxt.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
            ClassUtil.throwIfRTE(t);
        }
        return ctxt.handleInstantiationProblem(this._beanType.getRawClass(), null, t);
    }
}

