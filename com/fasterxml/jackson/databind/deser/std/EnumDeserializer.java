/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Member
 *  java.util.Objects
 *  java.util.Optional
 */
package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.FactoryBasedEnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.CompactStringObjectMap;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Objects;
import java.util.Optional;

@JacksonStdImpl
public class EnumDeserializer
extends StdScalarDeserializer<Object>
implements ContextualDeserializer {
    private static final long serialVersionUID = 1L;
    protected Object[] _enumsByIndex;
    private final Enum<?> _enumDefaultValue;
    protected final CompactStringObjectMap _lookupByName;
    protected volatile CompactStringObjectMap _lookupByToString;
    protected final Boolean _caseInsensitive;
    private Boolean _useDefaultValueForUnknownEnum;
    private Boolean _useNullForUnknownEnum;
    protected final boolean _isFromIntValue;
    protected final CompactStringObjectMap _lookupByEnumNaming;

    @Deprecated
    public EnumDeserializer(EnumResolver byNameResolver, Boolean caseInsensitive) {
        this(byNameResolver, (boolean)caseInsensitive, null, null);
    }

    @Deprecated
    public EnumDeserializer(EnumResolver byNameResolver, boolean caseInsensitive, EnumResolver byEnumNamingResolver) {
        super(byNameResolver.getEnumClass());
        this._lookupByName = byNameResolver.constructLookup();
        this._enumsByIndex = byNameResolver.getRawEnums();
        this._enumDefaultValue = byNameResolver.getDefaultValue();
        this._caseInsensitive = caseInsensitive;
        this._isFromIntValue = byNameResolver.isFromIntValue();
        this._lookupByEnumNaming = byEnumNamingResolver == null ? null : byEnumNamingResolver.constructLookup();
        this._lookupByToString = null;
    }

    public EnumDeserializer(EnumResolver byNameResolver, boolean caseInsensitive, EnumResolver byEnumNamingResolver, EnumResolver toStringResolver) {
        super(byNameResolver.getEnumClass());
        this._lookupByName = byNameResolver.constructLookup();
        this._enumsByIndex = byNameResolver.getRawEnums();
        this._enumDefaultValue = byNameResolver.getDefaultValue();
        this._caseInsensitive = caseInsensitive;
        this._isFromIntValue = byNameResolver.isFromIntValue();
        this._lookupByEnumNaming = byEnumNamingResolver == null ? null : byEnumNamingResolver.constructLookup();
        this._lookupByToString = toStringResolver == null ? null : toStringResolver.constructLookup();
    }

    protected EnumDeserializer(EnumDeserializer base, Boolean caseInsensitive, Boolean useDefaultValueForUnknownEnum, Boolean useNullForUnknownEnum) {
        super(base);
        this._lookupByName = base._lookupByName;
        this._enumsByIndex = base._enumsByIndex;
        this._enumDefaultValue = base._enumDefaultValue;
        this._caseInsensitive = caseInsensitive;
        this._isFromIntValue = base._isFromIntValue;
        this._useDefaultValueForUnknownEnum = useDefaultValueForUnknownEnum;
        this._useNullForUnknownEnum = useNullForUnknownEnum;
        this._lookupByEnumNaming = base._lookupByEnumNaming;
        this._lookupByToString = base._lookupByToString;
    }

    @Deprecated
    protected EnumDeserializer(EnumDeserializer base, Boolean caseInsensitive) {
        this(base, caseInsensitive, null, null);
    }

    @Deprecated
    public EnumDeserializer(EnumResolver byNameResolver) {
        this(byNameResolver, null);
    }

    @Deprecated
    public static JsonDeserializer<?> deserializerForCreator(DeserializationConfig config, Class<?> enumClass, AnnotatedMethod factory2) {
        return EnumDeserializer.deserializerForCreator(config, enumClass, factory2, null, null);
    }

    public static JsonDeserializer<?> deserializerForCreator(DeserializationConfig config, Class<?> enumClass, AnnotatedMethod factory2, ValueInstantiator valueInstantiator, SettableBeanProperty[] creatorProps) {
        if (config.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess((Member)factory2.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new FactoryBasedEnumDeserializer(enumClass, factory2, factory2.getParameterType(0), valueInstantiator, creatorProps);
    }

    public static JsonDeserializer<?> deserializerForNoArgsCreator(DeserializationConfig config, Class<?> enumClass, AnnotatedMethod factory2) {
        if (config.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess((Member)factory2.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new FactoryBasedEnumDeserializer(enumClass, factory2);
    }

    public EnumDeserializer withResolved(Boolean caseInsensitive, Boolean useDefaultValueForUnknownEnum, Boolean useNullForUnknownEnum) {
        if (Objects.equals((Object)this._caseInsensitive, (Object)caseInsensitive) && Objects.equals((Object)this._useDefaultValueForUnknownEnum, (Object)useDefaultValueForUnknownEnum) && Objects.equals((Object)this._useNullForUnknownEnum, (Object)useNullForUnknownEnum)) {
            return this;
        }
        return new EnumDeserializer(this, caseInsensitive, useDefaultValueForUnknownEnum, useNullForUnknownEnum);
    }

    @Deprecated
    public EnumDeserializer withResolved(Boolean caseInsensitive) {
        return this.withResolved(caseInsensitive, this._useDefaultValueForUnknownEnum, this._useNullForUnknownEnum);
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        Boolean caseInsensitive = (Boolean)Optional.ofNullable((Object)this.findFormatFeature(ctxt, property, this.handledType(), JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)).orElse((Object)this._caseInsensitive);
        Boolean useDefaultValueForUnknownEnum = (Boolean)Optional.ofNullable((Object)this.findFormatFeature(ctxt, property, this.handledType(), JsonFormat.Feature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)).orElse((Object)this._useDefaultValueForUnknownEnum);
        Boolean useNullForUnknownEnum = (Boolean)Optional.ofNullable((Object)this.findFormatFeature(ctxt, property, this.handledType(), JsonFormat.Feature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)).orElse((Object)this._useNullForUnknownEnum);
        return this.withResolved(caseInsensitive, useDefaultValueForUnknownEnum, useNullForUnknownEnum);
    }

    @Override
    public boolean isCachable() {
        return true;
    }

    @Override
    public LogicalType logicalType() {
        return LogicalType.Enum;
    }

    @Override
    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return this._enumDefaultValue;
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_STRING)) {
            return this._fromString(p, ctxt, p.getText());
        }
        if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            if (this._isFromIntValue) {
                return this._fromString(p, ctxt, p.getText());
            }
            return this._fromInteger(p, ctxt, p.getIntValue());
        }
        if (p.isExpectedStartObjectToken()) {
            return this._fromString(p, ctxt, ctxt.extractScalarFromObject(p, this, this._valueClass));
        }
        return this._deserializeOther(p, ctxt);
    }

    protected Object _fromString(JsonParser p, DeserializationContext ctxt, String text) throws IOException {
        String trimmed;
        CompactStringObjectMap lookup = this._resolveCurrentLookup(ctxt);
        Object result = lookup.find(text);
        if (result == null && ((trimmed = text.trim()) == text || (result = lookup.find(trimmed)) == null)) {
            return this._deserializeAltString(p, ctxt, lookup, trimmed);
        }
        return result;
    }

    private CompactStringObjectMap _resolveCurrentLookup(DeserializationContext ctxt) {
        if (this._lookupByEnumNaming != null) {
            return this._lookupByEnumNaming;
        }
        return ctxt.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING) ? this._getToStringLookup(ctxt) : this._lookupByName;
    }

    protected Object _fromInteger(JsonParser p, DeserializationContext ctxt, int index) throws IOException {
        CoercionAction act = ctxt.findCoercionAction(this.logicalType(), this.handledType(), CoercionInputShape.Integer);
        if (act == CoercionAction.Fail) {
            if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                return ctxt.handleWeirdNumberValue(this._enumClass(), (Number)Integer.valueOf((int)index), "not allowed to deserialize Enum value out of number: disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[0]);
            }
            this._checkCoercionFail(ctxt, act, this.handledType(), index, "Integer value (" + index + ")");
        }
        switch (act) {
            case AsNull: {
                return null;
            }
            case AsEmpty: {
                return this.getEmptyValue(ctxt);
            }
        }
        if (index >= 0 && index < this._enumsByIndex.length) {
            return this._enumsByIndex[index];
        }
        if (this.useDefaultValueForUnknownEnum(ctxt)) {
            return this._enumDefaultValue;
        }
        if (!this.useNullForUnknownEnum(ctxt)) {
            return ctxt.handleWeirdNumberValue(this._enumClass(), (Number)Integer.valueOf((int)index), "index value outside legal index range [0..%s]", this._enumsByIndex.length - 1);
        }
        return null;
    }

    private final Object _deserializeAltString(JsonParser p, DeserializationContext ctxt, CompactStringObjectMap lookup, String nameOrig) throws IOException {
        char c;
        Object match;
        String name = nameOrig.trim();
        if (name.isEmpty()) {
            CoercionAction act;
            if (this.useDefaultValueForUnknownEnum(ctxt)) {
                return this._enumDefaultValue;
            }
            if (this.useNullForUnknownEnum(ctxt)) {
                return null;
            }
            if (nameOrig.isEmpty()) {
                act = this._findCoercionFromEmptyString(ctxt);
                act = this._checkCoercionFail(ctxt, act, this.handledType(), nameOrig, "empty String (\"\")");
            } else {
                act = this._findCoercionFromBlankString(ctxt);
                act = this._checkCoercionFail(ctxt, act, this.handledType(), nameOrig, "blank String (all whitespace)");
            }
            switch (act) {
                case AsEmpty: 
                case TryConvert: {
                    return this.getEmptyValue(ctxt);
                }
            }
            return null;
        }
        if (Boolean.TRUE.equals((Object)this._caseInsensitive) && (match = lookup.findCaseInsensitive(name)) != null) {
            return match;
        }
        if (!ctxt.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS) && !this._isFromIntValue && (c = name.charAt(0)) >= '0' && c <= '9') {
            try {
                int index = Integer.parseInt((String)name);
                if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
                    return ctxt.handleWeirdStringValue(this._enumClass(), name, "value looks like quoted Enum index, but `MapperFeature.ALLOW_COERCION_OF_SCALARS` prevents use", new Object[0]);
                }
                if (index >= 0 && index < this._enumsByIndex.length) {
                    return this._enumsByIndex[index];
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        if (this.useDefaultValueForUnknownEnum(ctxt)) {
            return this._enumDefaultValue;
        }
        if (this.useNullForUnknownEnum(ctxt)) {
            return null;
        }
        return ctxt.handleWeirdStringValue(this._enumClass(), name, "not one of the values accepted for Enum class: %s", lookup.keys());
    }

    protected Object _deserializeOther(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.START_ARRAY)) {
            return this._deserializeFromArray(p, ctxt);
        }
        return ctxt.handleUnexpectedToken(this._enumClass(), p);
    }

    protected Class<?> _enumClass() {
        return this.handledType();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Deprecated
    protected CompactStringObjectMap _getToStringLookup(DeserializationContext ctxt) {
        CompactStringObjectMap lookup = this._lookupByToString;
        if (lookup == null) {
            EnumDeserializer enumDeserializer = this;
            synchronized (enumDeserializer) {
                lookup = this._lookupByToString;
                if (lookup == null) {
                    this._lookupByToString = lookup = EnumResolver.constructUsingToString(ctxt.getConfig(), this._enumClass()).constructLookup();
                }
            }
        }
        return lookup;
    }

    protected boolean useNullForUnknownEnum(DeserializationContext ctxt) {
        return Boolean.TRUE.equals((Object)this._useNullForUnknownEnum) || ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    protected boolean useDefaultValueForUnknownEnum(DeserializationContext ctxt) {
        return this._enumDefaultValue != null && (Boolean.TRUE.equals((Object)this._useDefaultValueForUnknownEnum) || ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE));
    }
}

