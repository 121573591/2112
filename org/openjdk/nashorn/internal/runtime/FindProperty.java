/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.invoke.MethodHandle
 *  jdk.dynalink.linker.LinkRequest
 */
package org.openjdk.nashorn.internal.runtime;

import java.lang.invoke.MethodHandle;
import jdk.dynalink.linker.LinkRequest;
import org.openjdk.nashorn.internal.lookup.Lookup;
import org.openjdk.nashorn.internal.objects.Global;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.ScriptObject;
import org.openjdk.nashorn.internal.runtime.UnwarrantedOptimismException;
import org.openjdk.nashorn.internal.runtime.UserAccessorProperty;
import org.openjdk.nashorn.internal.runtime.WithObject;

public final class FindProperty {
    private final ScriptObject self;
    private final ScriptObject prototype;
    private final Property property;

    public FindProperty(ScriptObject self, ScriptObject prototype, Property property) {
        this.self = self;
        this.prototype = prototype;
        this.property = property;
    }

    public FindProperty replaceProperty(Property newProperty) {
        assert (this.property.getKey().equals(newProperty.getKey()));
        assert (this.property.getSlot() == newProperty.getSlot());
        return new FindProperty(this.self, this.prototype, newProperty);
    }

    public MethodHandle getGetter(Class<?> type, int programPoint, LinkRequest request) {
        MethodHandle getter = UnwarrantedOptimismException.isValid(programPoint) ? this.property.getOptimisticGetter(type, programPoint) : this.property.getGetter(type);
        if (this.property instanceof UserAccessorProperty) {
            getter = Lookup.MH.insertArguments(getter, 1, UserAccessorProperty.getINVOKE_UA_GETTER(type, programPoint));
            if (UnwarrantedOptimismException.isValid(programPoint) && type.isPrimitive()) {
                getter = Lookup.MH.insertArguments(getter, 1, programPoint);
            }
            this.property.setType(type);
            return this.insertAccessorsGetter((UserAccessorProperty)this.property, request, getter);
        }
        return getter;
    }

    public MethodHandle getSetter(Class<?> type, boolean strict, LinkRequest request) {
        MethodHandle setter = this.property.getSetter(type, this.getOwner().getMap());
        if (this.property instanceof UserAccessorProperty) {
            setter = Lookup.MH.insertArguments(setter, 1, UserAccessorProperty.getINVOKE_UA_SETTER(type), strict ? this.property.getKey() : null);
            this.property.setType(type);
            return this.insertAccessorsGetter((UserAccessorProperty)this.property, request, setter);
        }
        return setter;
    }

    private MethodHandle insertAccessorsGetter(UserAccessorProperty uap, LinkRequest request, MethodHandle mh) {
        MethodHandle superGetter = uap.getAccessorsGetter();
        if (!this.isSelf()) {
            superGetter = ScriptObject.addProtoFilter(superGetter, this.getProtoChainLength());
        }
        if (request != null && !(request.getReceiver() instanceof ScriptObject)) {
            MethodHandle wrapFilter = Global.getPrimitiveWrapFilter(request.getReceiver());
            superGetter = Lookup.MH.filterArguments(superGetter, 0, wrapFilter.asType(wrapFilter.type().changeReturnType(superGetter.type().parameterType(0))));
        }
        superGetter = Lookup.MH.asType(superGetter, superGetter.type().changeParameterType(0, Object.class));
        return Lookup.MH.foldArguments(mh, superGetter);
    }

    public ScriptObject getOwner() {
        return this.prototype;
    }

    public ScriptObject getSelf() {
        return this.self;
    }

    public ScriptObject getGetterReceiver() {
        return this.property != null && this.property.isAccessorProperty() ? this.self : this.prototype;
    }

    public ScriptObject getSetterReceiver() {
        return this.property != null && this.property.hasSetterFunction(this.prototype) ? this.self : this.prototype;
    }

    public Property getProperty() {
        return this.property;
    }

    public boolean isInheritedOrdinaryProperty() {
        return !this.isSelf() && !this.getProperty().isAccessorProperty();
    }

    public boolean isSelf() {
        return this.self == this.prototype;
    }

    public boolean isScope() {
        return this.prototype.isScope();
    }

    public int getIntValue() {
        return this.property.getIntValue(this.getGetterReceiver(), this.getOwner());
    }

    public double getDoubleValue() {
        return this.property.getDoubleValue(this.getGetterReceiver(), this.getOwner());
    }

    public Object getObjectValue() {
        return this.property.getObjectValue(this.getGetterReceiver(), this.getOwner());
    }

    public void setValue(int value, boolean strict) {
        this.property.setValue(this.getSetterReceiver(), this.getOwner(), value, strict);
    }

    public void setValue(double value, boolean strict) {
        this.property.setValue(this.getSetterReceiver(), this.getOwner(), value, strict);
    }

    public void setValue(Object value, boolean strict) {
        this.property.setValue(this.getSetterReceiver(), this.getOwner(), value, strict);
    }

    int getProtoChainLength() {
        assert (this.self != null);
        int length = 0;
        for (ScriptObject obj = this.self; obj != this.prototype; obj = obj.getProto()) {
            assert (!(obj instanceof WithObject));
            ++length;
        }
        return length;
    }

    public String toString() {
        return "[FindProperty: " + this.property.getKey() + "]";
    }
}

