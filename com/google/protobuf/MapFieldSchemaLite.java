/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Map
 *  java.util.Map$Entry
 */
package com.google.protobuf;

import com.google.protobuf.CheckReturnValue;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MapFieldSchema;
import java.util.Map;

@CheckReturnValue
class MapFieldSchemaLite
implements MapFieldSchema {
    MapFieldSchemaLite() {
    }

    @Override
    public Map<?, ?> forMutableMapData(Object mapField) {
        return (MapFieldLite)((Object)mapField);
    }

    @Override
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object mapDefaultEntry) {
        return ((MapEntryLite)mapDefaultEntry).getMetadata();
    }

    @Override
    public Map<?, ?> forMapData(Object mapField) {
        return (MapFieldLite)((Object)mapField);
    }

    @Override
    public boolean isImmutable(Object mapField) {
        return !((MapFieldLite)((Object)mapField)).isMutable();
    }

    @Override
    public Object toImmutable(Object mapField) {
        ((MapFieldLite)((Object)mapField)).makeImmutable();
        return mapField;
    }

    @Override
    public Object newMapField(Object unused) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override
    public Object mergeFrom(Object destMapField, Object srcMapField) {
        return MapFieldSchemaLite.mergeFromLite(destMapField, srcMapField);
    }

    private static <K, V> MapFieldLite<K, V> mergeFromLite(Object destMapField, Object srcMapField) {
        MapFieldLite mine = (MapFieldLite)((Object)destMapField);
        MapFieldLite other = (MapFieldLite)((Object)srcMapField);
        if (!other.isEmpty()) {
            if (!mine.isMutable()) {
                mine = mine.mutableCopy();
            }
            mine.mergeFrom(other);
        }
        return mine;
    }

    @Override
    public int getSerializedSize(int fieldNumber, Object mapField, Object mapDefaultEntry) {
        return MapFieldSchemaLite.getSerializedSizeLite(fieldNumber, mapField, mapDefaultEntry);
    }

    private static <K, V> int getSerializedSizeLite(int fieldNumber, Object mapField, Object defaultEntry) {
        MapFieldLite mapFieldLite = (MapFieldLite)((Object)mapField);
        MapEntryLite defaultEntryLite = (MapEntryLite)defaultEntry;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        int size = 0;
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            size += defaultEntryLite.computeMessageSize(fieldNumber, entry.getKey(), entry.getValue());
        }
        return size;
    }
}

