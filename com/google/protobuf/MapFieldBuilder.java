/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.MutabilityOracle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapFieldBuilder<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT, BuilderT extends MessageOrBuilderT>
extends MapFieldReflectionAccessor {
    Map<KeyT, MessageOrBuilderT> builderMap = new LinkedHashMap();
    Map<KeyT, MessageT> messageMap = null;
    List<Message> messageList = null;
    Converter<KeyT, MessageOrBuilderT, MessageT> converter;

    public MapFieldBuilder(Converter<KeyT, MessageOrBuilderT, MessageT> converter) {
        this.converter = converter;
    }

    private List<MapEntry<KeyT, MessageT>> getMapEntryList() {
        ArrayList list = new ArrayList(this.messageList.size());
        Class valueClass = ((MessageOrBuilder)this.converter.defaultEntry().getValue()).getClass();
        for (Message entry : this.messageList) {
            MapEntry typedEntry = (MapEntry)entry;
            if (valueClass.isInstance(typedEntry.getValue())) {
                list.add((Object)typedEntry);
                continue;
            }
            list.add((Object)((MapEntry.Builder)((AbstractMessage.Builder)this.converter.defaultEntry().toBuilder()).mergeFrom(entry)).build());
        }
        return list;
    }

    public Map<KeyT, MessageOrBuilderT> ensureBuilderMap() {
        if (this.builderMap != null) {
            return this.builderMap;
        }
        if (this.messageMap != null) {
            this.builderMap = new LinkedHashMap(this.messageMap.size());
            for (Map.Entry entry : this.messageMap.entrySet()) {
                this.builderMap.put(entry.getKey(), (Object)((MessageOrBuilder)entry.getValue()));
            }
            this.messageMap = null;
            return this.builderMap;
        }
        this.builderMap = new LinkedHashMap(this.messageList.size());
        for (MapEntry entry : this.getMapEntryList()) {
            this.builderMap.put(entry.getKey(), (Object)((MessageOrBuilder)entry.getValue()));
        }
        this.messageList = null;
        return this.builderMap;
    }

    public List<Message> ensureMessageList() {
        if (this.messageList != null) {
            return this.messageList;
        }
        if (this.builderMap != null) {
            this.messageList = new ArrayList(this.builderMap.size());
            for (Map.Entry entry : this.builderMap.entrySet()) {
                this.messageList.add((Object)((MapEntry.Builder)this.converter.defaultEntry().toBuilder()).setKey(entry.getKey()).setValue(this.converter.build((MessageOrBuilder)entry.getValue())).build());
            }
            this.builderMap = null;
            return this.messageList;
        }
        this.messageList = new ArrayList(this.messageMap.size());
        for (Map.Entry entry : this.messageMap.entrySet()) {
            this.messageList.add((Object)((MapEntry.Builder)this.converter.defaultEntry().toBuilder()).setKey(entry.getKey()).setValue((MessageOrBuilder)entry.getValue()).build());
        }
        this.messageMap = null;
        return this.messageList;
    }

    public Map<KeyT, MessageT> ensureMessageMap() {
        this.messageMap = this.populateMutableMap();
        this.builderMap = null;
        this.messageList = null;
        return this.messageMap;
    }

    public Map<KeyT, MessageT> getImmutableMap() {
        return new MapField.MutabilityAwareMap<KeyT, MessageT>(MutabilityOracle.IMMUTABLE, this.populateMutableMap());
    }

    private Map<KeyT, MessageT> populateMutableMap() {
        if (this.messageMap != null) {
            return this.messageMap;
        }
        if (this.builderMap != null) {
            LinkedHashMap toReturn = new LinkedHashMap(this.builderMap.size());
            for (Map.Entry entry : this.builderMap.entrySet()) {
                toReturn.put(entry.getKey(), this.converter.build((MessageOrBuilder)entry.getValue()));
            }
            return toReturn;
        }
        LinkedHashMap toReturn = new LinkedHashMap(this.messageList.size());
        for (MapEntry entry : this.getMapEntryList()) {
            toReturn.put(entry.getKey(), (Object)((MessageOrBuilder)entry.getValue()));
        }
        return toReturn;
    }

    public void mergeFrom(MapField<KeyT, MessageT> other) {
        this.ensureBuilderMap().putAll(MapFieldLite.copy(other.getMap()));
    }

    public void clear() {
        this.builderMap = new LinkedHashMap();
        this.messageMap = null;
        this.messageList = null;
    }

    private boolean typedEquals(MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> other) {
        return MapFieldLite.equals(this.ensureBuilderMap(), other.ensureBuilderMap());
    }

    public boolean equals(Object object) {
        if (!(object instanceof MapFieldBuilder)) {
            return false;
        }
        return this.typedEquals((MapFieldBuilder)object);
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(this.ensureBuilderMap());
    }

    public MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> copy() {
        MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> clone = new MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT>(this.converter);
        clone.ensureBuilderMap().putAll(this.ensureBuilderMap());
        return clone;
    }

    public MapField<KeyT, MessageT> build(MapEntry<KeyT, MessageT> defaultEntry) {
        MapField<KeyT, MessageT> mapField = MapField.newMapField(defaultEntry);
        Map<KeyT, MessageT> map = mapField.getMutableMap();
        for (Map.Entry entry : this.ensureBuilderMap().entrySet()) {
            map.put(entry.getKey(), this.converter.build((MessageOrBuilder)entry.getValue()));
        }
        mapField.makeImmutable();
        return mapField;
    }

    @Override
    List<Message> getList() {
        return this.ensureMessageList();
    }

    @Override
    List<Message> getMutableList() {
        return this.ensureMessageList();
    }

    @Override
    Message getMapEntryMessageDefaultInstance() {
        return this.converter.defaultEntry();
    }

    public static interface Converter<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT> {
        public MessageT build(MessageOrBuilderT var1);

        public MapEntry<KeyT, MessageT> defaultEntry();
    }
}

