/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.Map$Entry
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.MessageLite;
import java.util.Iterator;
import java.util.Map;

public class LazyField
extends LazyFieldLite {
    private final MessageLite defaultInstance;

    public LazyField(MessageLite defaultInstance, ExtensionRegistryLite extensionRegistry, ByteString bytes) {
        super(extensionRegistry, bytes);
        this.defaultInstance = defaultInstance;
    }

    @Override
    public boolean containsDefaultInstance() {
        return super.containsDefaultInstance() || this.value == this.defaultInstance;
    }

    public MessageLite getValue() {
        return this.getValue(this.defaultInstance);
    }

    @Override
    public int hashCode() {
        return this.getValue().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getValue().equals(obj);
    }

    public String toString() {
        return this.getValue().toString();
    }

    static class LazyIterator<K>
    implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> iterator) {
            this.iterator = iterator;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Map.Entry<K, Object> next() {
            Map.Entry entry = (Map.Entry)this.iterator.next();
            if (entry.getValue() instanceof LazyField) {
                return new LazyEntry(entry);
            }
            return entry;
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    static class LazyEntry<K>
    implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        private LazyEntry(Map.Entry<K, LazyField> entry) {
            this.entry = entry;
        }

        public K getKey() {
            return (K)this.entry.getKey();
        }

        public Object getValue() {
            LazyField field = (LazyField)this.entry.getValue();
            if (field == null) {
                return null;
            }
            return field.getValue();
        }

        public LazyField getField() {
            return (LazyField)this.entry.getValue();
        }

        public Object setValue(Object value) {
            if (!(value instanceof MessageLite)) {
                throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            }
            return ((LazyField)this.entry.getValue()).setValue((MessageLite)value);
        }
    }
}

