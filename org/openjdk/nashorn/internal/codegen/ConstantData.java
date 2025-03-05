/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 */
package org.openjdk.nashorn.internal.codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.openjdk.nashorn.internal.runtime.PropertyMap;

final class ConstantData {
    final List<Object> constants = new ArrayList();
    final Map<String, Integer> stringMap = new HashMap();
    final Map<Object, Integer> objectMap = new HashMap();

    ConstantData() {
    }

    public int add(String string) {
        Integer value = (Integer)this.stringMap.get((Object)string);
        if (value != null) {
            return value;
        }
        this.constants.add((Object)string);
        int index = this.constants.size() - 1;
        this.stringMap.put((Object)string, (Object)index);
        return index;
    }

    public int add(Object object) {
        assert (object != null);
        Object entry = object.getClass().isArray() ? new ArrayWrapper(object) : (object instanceof PropertyMap ? new PropertyMapWrapper((PropertyMap)object) : object);
        Integer value = (Integer)this.objectMap.get(entry);
        if (value != null) {
            return value;
        }
        this.constants.add(object);
        int index = this.constants.size() - 1;
        this.objectMap.put(entry, (Object)index);
        return index;
    }

    Object[] toArray() {
        return this.constants.toArray();
    }

    private static class PropertyMapWrapper {
        private final PropertyMap propertyMap;
        private final int hashCode;

        public PropertyMapWrapper(PropertyMap map) {
            this.hashCode = Arrays.hashCode((Object[])map.getProperties()) + 31 * Objects.hashCode((Object)map.getClassName());
            this.propertyMap = map;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object other) {
            if (!(other instanceof PropertyMapWrapper)) {
                return false;
            }
            PropertyMap otherMap = ((PropertyMapWrapper)other).propertyMap;
            return this.propertyMap == otherMap || Arrays.equals((Object[])this.propertyMap.getProperties(), (Object[])otherMap.getProperties()) && Objects.equals((Object)this.propertyMap.getClassName(), (Object)otherMap.getClassName());
        }
    }

    private static class ArrayWrapper {
        private final Object array;
        private final int hashCode;

        public ArrayWrapper(Object array) {
            this.array = array;
            this.hashCode = this.calcHashCode();
        }

        private int calcHashCode() {
            Class cls = this.array.getClass();
            if (!cls.getComponentType().isPrimitive()) {
                return Arrays.hashCode((Object[])((Object[])this.array));
            }
            if (cls == double[].class) {
                return Arrays.hashCode((double[])((double[])this.array));
            }
            if (cls == long[].class) {
                return Arrays.hashCode((long[])((long[])this.array));
            }
            if (cls == int[].class) {
                return Arrays.hashCode((int[])((int[])this.array));
            }
            throw new AssertionError((Object)("ConstantData doesn't support " + cls));
        }

        public boolean equals(Object other) {
            if (!(other instanceof ArrayWrapper)) {
                return false;
            }
            Object otherArray = ((ArrayWrapper)other).array;
            if (this.array == otherArray) {
                return true;
            }
            Class cls = this.array.getClass();
            if (cls == otherArray.getClass()) {
                if (!cls.getComponentType().isPrimitive()) {
                    return Arrays.equals((Object[])((Object[])this.array), (Object[])((Object[])otherArray));
                }
                if (cls == double[].class) {
                    return Arrays.equals((double[])((double[])this.array), (double[])((double[])otherArray));
                }
                if (cls == long[].class) {
                    return Arrays.equals((long[])((long[])this.array), (long[])((long[])otherArray));
                }
                if (cls == int[].class) {
                    return Arrays.equals((int[])((int[])this.array), (int[])((int[])otherArray));
                }
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }
}

