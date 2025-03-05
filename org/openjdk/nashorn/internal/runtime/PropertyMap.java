/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.lang.invoke.SwitchPoint
 *  java.lang.ref.Reference
 *  java.lang.ref.SoftReference
 *  java.lang.ref.WeakReference
 *  java.util.Arrays
 *  java.util.BitSet
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 *  java.util.Set
 *  java.util.WeakHashMap
 *  java.util.concurrent.atomic.LongAdder
 */
package org.openjdk.nashorn.internal.runtime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.SwitchPoint;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.LongAdder;
import org.openjdk.nashorn.internal.runtime.AccessorProperty;
import org.openjdk.nashorn.internal.runtime.Context;
import org.openjdk.nashorn.internal.runtime.Debug;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyHashMap;
import org.openjdk.nashorn.internal.runtime.PropertySwitchPoints;
import org.openjdk.nashorn.internal.runtime.ScriptObject;
import org.openjdk.nashorn.internal.runtime.SharedPropertyMap;
import org.openjdk.nashorn.internal.runtime.UserAccessorProperty;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayIndex;
import org.openjdk.nashorn.internal.runtime.options.Options;
import org.openjdk.nashorn.internal.scripts.JO;

public class PropertyMap
implements Iterable<Object>,
Serializable {
    private static final int INITIAL_SOFT_REFERENCE_DERIVATION_LIMIT = Math.max((int)0, (int)Options.getIntProperty("nashorn.propertyMap.softReferenceDerivationLimit", 32));
    private static final int NOT_EXTENSIBLE = 1;
    private static final int CONTAINS_ARRAY_KEYS = 2;
    private final int flags;
    private transient PropertyHashMap properties;
    private final int fieldCount;
    private final int fieldMaximum;
    private final int spillLength;
    private final String className;
    private final int softReferenceDerivationLimit;
    private transient SharedPropertyMap sharedProtoMap;
    private transient WeakHashMap<Property, Reference<PropertyMap>> history;
    private transient WeakHashMap<ScriptObject, SoftReference<PropertyMap>> protoHistory;
    private transient PropertySwitchPoints propertySwitchPoints;
    private transient BitSet freeSlots;
    private static final long serialVersionUID = -7041836752008732533L;
    private static LongAdder count;
    private static LongAdder clonedCount;
    private static LongAdder historyHit;
    private static LongAdder protoInvalidations;
    private static LongAdder protoHistoryHit;
    private static LongAdder setProtoNewMapCount;

    private PropertyMap(PropertyHashMap properties, int flags, String className, int fieldCount, int fieldMaximum, int spillLength) {
        this.properties = properties;
        this.className = className;
        this.fieldCount = fieldCount;
        this.fieldMaximum = fieldMaximum;
        this.spillLength = spillLength;
        this.flags = flags;
        this.softReferenceDerivationLimit = INITIAL_SOFT_REFERENCE_DERIVATION_LIMIT;
        if (Context.DEBUG) {
            count.increment();
        }
    }

    private PropertyMap(PropertyMap propertyMap, PropertyHashMap properties, int flags, int fieldCount, int spillLength, int softReferenceDerivationLimit) {
        this.properties = properties;
        this.flags = flags;
        this.spillLength = spillLength;
        this.fieldCount = fieldCount;
        this.fieldMaximum = propertyMap.fieldMaximum;
        this.className = propertyMap.className;
        this.propertySwitchPoints = propertyMap.propertySwitchPoints;
        this.freeSlots = propertyMap.freeSlots;
        this.sharedProtoMap = propertyMap.sharedProtoMap;
        this.softReferenceDerivationLimit = softReferenceDerivationLimit;
        if (Context.DEBUG) {
            count.increment();
            clonedCount.increment();
        }
    }

    protected PropertyMap(PropertyMap propertyMap) {
        this(propertyMap, propertyMap.properties, propertyMap.flags, propertyMap.fieldCount, propertyMap.spillLength, propertyMap.softReferenceDerivationLimit);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject((Object)this.properties.getProperties());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Property[] props = (Property[])in.readObject();
        this.properties = PropertyHashMap.EMPTY_HASHMAP.immutableAdd(props);
        assert (this.className != null);
        Class<? extends ScriptObject> structure = Context.forStructureClass(this.className);
        for (Property prop : props) {
            prop.initMethodHandles(structure);
        }
    }

    public static PropertyMap newMap(Collection<Property> properties, String className, int fieldCount, int fieldMaximum, int spillLength) {
        PropertyHashMap newProperties = PropertyHashMap.EMPTY_HASHMAP.immutableAdd(properties);
        return new PropertyMap(newProperties, 0, className, fieldCount, fieldMaximum, spillLength);
    }

    public static PropertyMap newMap(Collection<Property> properties) {
        return properties == null || properties.isEmpty() ? PropertyMap.newMap() : PropertyMap.newMap(properties, JO.class.getName(), 0, 0, 0);
    }

    public static PropertyMap newMap(Class<? extends ScriptObject> clazz) {
        return new PropertyMap(PropertyHashMap.EMPTY_HASHMAP, 0, clazz.getName(), 0, 0, 0);
    }

    public static PropertyMap newMap() {
        return PropertyMap.newMap(JO.class);
    }

    public int size() {
        return this.properties.size();
    }

    public int getSwitchPointCount() {
        return this.propertySwitchPoints == null ? 0 : this.propertySwitchPoints.getSwitchPointCount();
    }

    public void addSwitchPoint(String key, SwitchPoint switchPoint) {
        this.propertySwitchPoints = PropertySwitchPoints.addSwitchPoint(this.propertySwitchPoints, key, switchPoint);
    }

    public void propertyChanged(Property property) {
        if (this.propertySwitchPoints != null) {
            this.propertySwitchPoints.invalidateProperty(property);
        }
    }

    void protoChanged() {
        if (this.sharedProtoMap != null) {
            this.sharedProtoMap.invalidateSwitchPoint();
        }
        if (this.propertySwitchPoints != null) {
            this.propertySwitchPoints.invalidateInheritedProperties(this);
        }
    }

    public synchronized SwitchPoint getSwitchPoint(String key) {
        if (this.propertySwitchPoints != null) {
            Set<SwitchPoint> existingSwitchPoints = this.propertySwitchPoints.getSwitchPoints(key);
            for (SwitchPoint switchPoint : existingSwitchPoints) {
                if (switchPoint == null || switchPoint.hasBeenInvalidated()) continue;
                return switchPoint;
            }
        }
        return null;
    }

    PropertyMap addPropertyBind(AccessorProperty property, Object bindTo) {
        return this.addPropertyNoHistory(new AccessorProperty(property, bindTo));
    }

    private int logicalSlotIndex(Property property) {
        int slot = property.getSlot();
        if (slot < 0) {
            return -1;
        }
        return property.isSpill() ? slot + this.fieldMaximum : slot;
    }

    private int newSpillLength(Property newProperty) {
        return newProperty.isSpill() ? Math.max((int)this.spillLength, (int)(newProperty.getSlot() + 1)) : this.spillLength;
    }

    private int newFieldCount(Property newProperty) {
        return !newProperty.isSpill() ? Math.max((int)this.fieldCount, (int)(newProperty.getSlot() + 1)) : this.fieldCount;
    }

    private int newFlags(Property newProperty) {
        return ArrayIndex.isValidArrayIndex(ArrayIndex.getArrayIndex(newProperty.getKey())) ? this.flags | 2 : this.flags;
    }

    private void updateFreeSlots(Property oldProperty, Property newProperty) {
        BitSet newFreeSlots;
        int slotIndex;
        boolean freeSlotsCloned = false;
        if (oldProperty != null && (slotIndex = this.logicalSlotIndex(oldProperty)) >= 0) {
            BitSet bitSet = newFreeSlots = this.freeSlots == null ? new BitSet() : (BitSet)this.freeSlots.clone();
            assert (!newFreeSlots.get(slotIndex));
            newFreeSlots.set(slotIndex);
            this.freeSlots = newFreeSlots;
            freeSlotsCloned = true;
        }
        if (this.freeSlots != null && newProperty != null && (slotIndex = this.logicalSlotIndex(newProperty)) > -1 && this.freeSlots.get(slotIndex)) {
            newFreeSlots = freeSlotsCloned ? this.freeSlots : (BitSet)this.freeSlots.clone();
            newFreeSlots.clear(slotIndex);
            this.freeSlots = newFreeSlots.isEmpty() ? null : newFreeSlots;
        }
    }

    public final PropertyMap addPropertyNoHistory(Property property) {
        this.propertyChanged(property);
        return this.addPropertyInternal(property);
    }

    public final synchronized PropertyMap addProperty(Property property) {
        this.propertyChanged(property);
        PropertyMap newMap = this.checkHistory(property);
        if (newMap == null) {
            newMap = this.addPropertyInternal(property);
            this.addToHistory(property, newMap);
        }
        return newMap;
    }

    private PropertyMap deriveMap(PropertyHashMap newProperties, int newFlags, int newFieldCount, int newSpillLength) {
        return new PropertyMap(this, newProperties, newFlags, newFieldCount, newSpillLength, this.softReferenceDerivationLimit == 0 ? 0 : this.softReferenceDerivationLimit - 1);
    }

    private PropertyMap addPropertyInternal(Property property) {
        PropertyHashMap newProperties = this.properties.immutableAdd(property);
        PropertyMap newMap = this.deriveMap(newProperties, this.newFlags(property), this.newFieldCount(property), this.newSpillLength(property));
        newMap.updateFreeSlots(null, property);
        return newMap;
    }

    public final synchronized PropertyMap deleteProperty(Property property) {
        this.propertyChanged(property);
        PropertyMap newMap = this.checkHistory(property);
        Object key = property.getKey();
        if (newMap == null && this.properties.containsKey(key)) {
            PropertyHashMap newProperties = this.properties.immutableRemove(key);
            boolean isSpill = property.isSpill();
            int slot = property.getSlot();
            if (isSpill && slot >= 0 && slot == this.spillLength - 1) {
                newMap = this.deriveMap(newProperties, this.flags, this.fieldCount, this.spillLength - 1);
                newMap.freeSlots = this.freeSlots;
            } else if (!isSpill && slot >= 0 && slot == this.fieldCount - 1) {
                newMap = this.deriveMap(newProperties, this.flags, this.fieldCount - 1, this.spillLength);
                newMap.freeSlots = this.freeSlots;
            } else {
                newMap = this.deriveMap(newProperties, this.flags, this.fieldCount, this.spillLength);
                newMap.updateFreeSlots(property, null);
            }
            this.addToHistory(property, newMap);
        }
        return newMap;
    }

    public final PropertyMap replaceProperty(Property oldProperty, Property newProperty) {
        boolean sameType;
        this.propertyChanged(oldProperty);
        boolean bl = sameType = oldProperty.getClass() == newProperty.getClass();
        assert (sameType || oldProperty instanceof AccessorProperty && newProperty instanceof UserAccessorProperty) : "arbitrary replaceProperty attempted oldProperty=" + oldProperty.getClass() + " newProperty=" + newProperty.getClass() + " [" + oldProperty.getLocalType() + " => " + newProperty.getLocalType() + "]";
        int newSpillLength = sameType ? this.spillLength : Math.max((int)this.spillLength, (int)(newProperty.getSlot() + 1));
        PropertyHashMap newProperties = this.properties.immutableReplace(oldProperty, newProperty);
        PropertyMap newMap = this.deriveMap(newProperties, this.flags, this.fieldCount, newSpillLength);
        if (!sameType) {
            newMap.updateFreeSlots(oldProperty, newProperty);
        }
        return newMap;
    }

    public final UserAccessorProperty newUserAccessors(Object key, int propertyFlags) {
        return new UserAccessorProperty(key, propertyFlags, this.getFreeSpillSlot());
    }

    public final Property findProperty(Object key) {
        return this.properties.find(key);
    }

    public final PropertyMap addAll(PropertyMap other) {
        assert (this != other) : "adding property map to itself";
        Property[] otherProperties = other.properties.getProperties();
        PropertyHashMap newProperties = this.properties.immutableAdd(otherProperties);
        PropertyMap newMap = this.deriveMap(newProperties, this.flags, this.fieldCount, this.spillLength);
        for (Property property : otherProperties) {
            assert (property.getSlot() == -1);
            assert (!ArrayIndex.isValidArrayIndex(ArrayIndex.getArrayIndex(property.getKey())));
        }
        return newMap;
    }

    public final Property[] getProperties() {
        return this.properties.getProperties();
    }

    public final String getClassName() {
        return this.className;
    }

    PropertyMap preventExtensions() {
        return this.deriveMap(this.properties, this.flags | 1, this.fieldCount, this.spillLength);
    }

    PropertyMap seal() {
        PropertyHashMap newProperties = PropertyHashMap.EMPTY_HASHMAP;
        for (Property oldProperty : this.properties.getProperties()) {
            newProperties = newProperties.immutableAdd(oldProperty.addFlags(4));
        }
        return this.deriveMap(newProperties, this.flags | 1, this.fieldCount, this.spillLength);
    }

    PropertyMap freeze() {
        PropertyHashMap newProperties = PropertyHashMap.EMPTY_HASHMAP;
        for (Property oldProperty : this.properties.getProperties()) {
            int propertyFlags = 4;
            if (!(oldProperty instanceof UserAccessorProperty)) {
                propertyFlags |= 1;
            }
            newProperties = newProperties.immutableAdd(oldProperty.addFlags(propertyFlags));
        }
        return this.deriveMap(newProperties, this.flags | 1, this.fieldCount, this.spillLength);
    }

    private boolean anyConfigurable() {
        for (Property property : this.properties.getProperties()) {
            if (!property.isConfigurable()) continue;
            return true;
        }
        return false;
    }

    private boolean allFrozen() {
        for (Property property : this.properties.getProperties()) {
            if (!property.isAccessorProperty() && property.isWritable()) {
                return false;
            }
            if (!property.isConfigurable()) continue;
            return false;
        }
        return true;
    }

    private PropertyMap checkProtoHistory(ScriptObject proto) {
        SoftReference weakMap;
        PropertyMap cachedMap = this.protoHistory != null ? ((weakMap = (SoftReference)this.protoHistory.get((Object)proto)) != null ? (PropertyMap)weakMap.get() : null) : null;
        if (Context.DEBUG && cachedMap != null) {
            protoHistoryHit.increment();
        }
        return cachedMap;
    }

    private void addToProtoHistory(ScriptObject newProto, PropertyMap newMap) {
        if (this.protoHistory == null) {
            this.protoHistory = new WeakHashMap();
        }
        this.protoHistory.put((Object)newProto, (Object)new SoftReference((Object)newMap));
    }

    private void addToHistory(Property property, PropertyMap newMap) {
        if (this.history == null) {
            this.history = new WeakHashMap();
        }
        this.history.put((Object)property, this.softReferenceDerivationLimit == 0 ? new WeakReference((Object)newMap) : new SoftReference((Object)newMap));
    }

    private PropertyMap checkHistory(Property property) {
        if (this.history != null) {
            PropertyMap historicMap;
            Reference ref = (Reference)this.history.get((Object)property);
            PropertyMap propertyMap = historicMap = ref == null ? null : (PropertyMap)ref.get();
            if (historicMap != null) {
                if (Context.DEBUG) {
                    historyHit.increment();
                }
                return historicMap;
            }
        }
        return null;
    }

    public boolean equalsWithoutType(PropertyMap otherMap) {
        if (this.properties.size() != otherMap.properties.size()) {
            return false;
        }
        Iterator iter = this.properties.values().iterator();
        Iterator otherIter = otherMap.properties.values().iterator();
        while (iter.hasNext() && otherIter.hasNext()) {
            if (((Property)iter.next()).equalsWithoutType((Property)otherIter.next())) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Debug.id(this));
        sb.append(" = {\n");
        for (Property property : this.getProperties()) {
            sb.append('\t');
            sb.append((Object)property);
            sb.append('\n');
        }
        sb.append('}');
        return sb.toString();
    }

    public Iterator<Object> iterator() {
        return new PropertyMapIterator(this);
    }

    public final boolean containsArrayKeys() {
        return (this.flags & 2) != 0;
    }

    boolean isExtensible() {
        return (this.flags & 1) == 0;
    }

    boolean isSealed() {
        return !this.isExtensible() && !this.anyConfigurable();
    }

    boolean isFrozen() {
        return !this.isExtensible() && this.allFrozen();
    }

    int getFreeFieldSlot() {
        int freeSlot;
        if (this.freeSlots != null && (freeSlot = this.freeSlots.nextSetBit(0)) > -1 && freeSlot < this.fieldMaximum) {
            return freeSlot;
        }
        if (this.fieldCount < this.fieldMaximum) {
            return this.fieldCount;
        }
        return -1;
    }

    int getFreeSpillSlot() {
        int freeSlot;
        if (this.freeSlots != null && (freeSlot = this.freeSlots.nextSetBit(this.fieldMaximum)) > -1) {
            return freeSlot - this.fieldMaximum;
        }
        return this.spillLength;
    }

    public synchronized PropertyMap changeProto(ScriptObject newProto) {
        PropertyMap nextMap = this.checkProtoHistory(newProto);
        if (nextMap != null) {
            return nextMap;
        }
        if (Context.DEBUG) {
            setProtoNewMapCount.increment();
        }
        PropertyMap newMap = this.makeUnsharedCopy();
        this.addToProtoHistory(newProto, newMap);
        return newMap;
    }

    PropertyMap makeUnsharedCopy() {
        PropertyMap newMap = new PropertyMap(this);
        newMap.sharedProtoMap = null;
        return newMap;
    }

    void setSharedProtoMap(SharedPropertyMap protoMap) {
        this.sharedProtoMap = protoMap;
    }

    public PropertyMap getSharedProtoMap() {
        return this.sharedProtoMap;
    }

    boolean isValidSharedProtoMap() {
        return false;
    }

    SwitchPoint getSharedProtoSwitchPoint() {
        return null;
    }

    boolean isInvalidSharedMapFor(ScriptObject prototype) {
        return this.sharedProtoMap != null && (!this.sharedProtoMap.isValidSharedProtoMap() || prototype == null || this.sharedProtoMap != prototype.getMap());
    }

    public static String diff(PropertyMap map0, PropertyMap map1) {
        StringBuilder sb = new StringBuilder();
        if (map0 != map1) {
            sb.append(">>> START: Map diff");
            boolean found = false;
            for (Property p : map0.getProperties()) {
                Property p2 = map1.findProperty(p.getKey());
                if (p2 == null) {
                    sb.append("FIRST ONLY : [").append((Object)p).append("]");
                    found = true;
                    continue;
                }
                if (p2 == p) continue;
                sb.append("DIFFERENT  : [").append((Object)p).append("] != [").append((Object)p2).append("]");
                found = true;
            }
            for (Property p2 : map1.getProperties()) {
                Property p1 = map0.findProperty(p2.getKey());
                if (p1 != null) continue;
                sb.append("SECOND ONLY: [").append((Object)p2).append("]");
                found = true;
            }
            if (!found) {
                sb.append((Object)map0).append("!=").append((Object)map1);
            }
            sb.append("<<< END: Map diff\n");
        }
        return sb.toString();
    }

    public static long getCount() {
        return count.longValue();
    }

    public static long getClonedCount() {
        return clonedCount.longValue();
    }

    public static long getHistoryHit() {
        return historyHit.longValue();
    }

    public static long getProtoInvalidations() {
        return protoInvalidations.longValue();
    }

    public static long getProtoHistoryHit() {
        return protoHistoryHit.longValue();
    }

    public static long getSetProtoNewMapCount() {
        return setProtoNewMapCount.longValue();
    }

    static {
        if (Context.DEBUG) {
            count = new LongAdder();
            clonedCount = new LongAdder();
            historyHit = new LongAdder();
            protoInvalidations = new LongAdder();
            protoHistoryHit = new LongAdder();
            setProtoNewMapCount = new LongAdder();
        }
    }

    private static class PropertyMapIterator
    implements Iterator<Object> {
        final Iterator<Property> iter;
        Property property;

        PropertyMapIterator(PropertyMap propertyMap) {
            this.iter = Arrays.asList((Object[])propertyMap.properties.getProperties()).iterator();
            this.property = this.iter.hasNext() ? (Property)this.iter.next() : null;
            this.skipNotEnumerable();
        }

        private void skipNotEnumerable() {
            while (this.property != null && !this.property.isEnumerable()) {
                this.property = this.iter.hasNext() ? (Property)this.iter.next() : null;
            }
        }

        public boolean hasNext() {
            return this.property != null;
        }

        public Object next() {
            if (this.property == null) {
                throw new NoSuchElementException();
            }
            Object key = this.property.getKey();
            this.property = this.iter.hasNext() ? (Property)this.iter.next() : null;
            this.skipNotEnumerable();
            return key;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}

