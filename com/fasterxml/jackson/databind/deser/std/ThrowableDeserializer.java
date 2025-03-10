/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;

public class ThrowableDeserializer
extends BeanDeserializer {
    private static final long serialVersionUID = 1L;
    protected static final String PROP_NAME_MESSAGE = "message";
    protected static final String PROP_NAME_SUPPRESSED = "suppressed";
    protected static final String PROP_NAME_LOCALIZED_MESSAGE = "localizedMessage";

    @Deprecated
    public ThrowableDeserializer(BeanDeserializer baseDeserializer) {
        super(baseDeserializer);
        this._vanillaProcessing = false;
    }

    public static ThrowableDeserializer construct(DeserializationContext ctxt, BeanDeserializer baseDeserializer) {
        return new ThrowableDeserializer(baseDeserializer);
    }

    protected ThrowableDeserializer(BeanDeserializer src, NameTransformer unwrapper) {
        super((BeanDeserializerBase)src, unwrapper);
    }

    @Override
    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper) {
        if (this.getClass() != ThrowableDeserializer.class) {
            return this;
        }
        return new ThrowableDeserializer(this, unwrapper);
    }

    @Override
    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return this._deserializeUsingPropertyBased(p, ctxt);
        }
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, this._delegateDeserializer.deserialize(p, ctxt));
        }
        if (this._beanType.isAbstract()) {
            return ctxt.handleMissingInstantiator(this.handledType(), this.getValueInstantiator(), p, "abstract type (need to add/enable type information?)", new Object[0]);
        }
        boolean hasStringCreator = this._valueInstantiator.canCreateFromString();
        boolean hasDefaultCtor = this._valueInstantiator.canCreateUsingDefault();
        if (!hasStringCreator && !hasDefaultCtor) {
            return ctxt.handleMissingInstantiator(this.handledType(), this.getValueInstantiator(), p, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
        }
        Throwable throwable = null;
        Object[] pending = null;
        Throwable[] suppressed = null;
        int pendingIx = 0;
        while (!p.hasToken(JsonToken.END_OBJECT)) {
            String propName = p.currentName();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            p.nextToken();
            if (prop != null) {
                if (throwable != null) {
                    prop.deserializeAndSet(p, ctxt, (Object)throwable);
                } else {
                    if (pending == null) {
                        int len = this._beanProperties.size();
                        pending = new Object[len + len];
                    }
                    pending[pendingIx++] = prop;
                    pending[pendingIx++] = prop.deserialize(p, ctxt);
                }
            } else if (PROP_NAME_MESSAGE.equalsIgnoreCase(propName) && hasStringCreator) {
                throwable = (Throwable)((Object)this._valueInstantiator.createFromString(ctxt, p.getValueAsString()));
            } else if (this._ignorableProps != null && this._ignorableProps.contains((Object)propName)) {
                p.skipChildren();
            } else if (PROP_NAME_SUPPRESSED.equalsIgnoreCase(propName)) {
                suppressed = ctxt.readValue(p, Throwable[].class);
            } else if (PROP_NAME_LOCALIZED_MESSAGE.equalsIgnoreCase(propName)) {
                p.skipChildren();
            } else if (this._anySetter != null) {
                this._anySetter.deserializeAndSet(p, ctxt, (Object)throwable, propName);
            } else if (PROP_NAME_MESSAGE.equalsIgnoreCase(propName)) {
                p.skipChildren();
            } else {
                this.handleUnknownProperty(p, ctxt, (Object)throwable, propName);
            }
            p.nextToken();
        }
        if (throwable == null) {
            throwable = hasStringCreator ? (Throwable)((Object)this._valueInstantiator.createFromString(ctxt, null)) : (Throwable)((Object)this._valueInstantiator.createUsingDefault(ctxt));
        }
        if (pending != null) {
            int len = pendingIx;
            for (int i = 0; i < len; i += 2) {
                SettableBeanProperty prop = (SettableBeanProperty)pending[i];
                prop.set((Object)throwable, pending[i + 1]);
            }
        }
        if (suppressed != null) {
            for (void var12_18 : suppressed) {
                throwable.addSuppressed((Throwable)var12_18);
            }
        }
        return throwable;
    }
}

