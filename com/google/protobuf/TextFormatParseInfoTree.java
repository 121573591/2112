/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.TextFormatParseLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField, Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField) {
        HashMap locs = new HashMap();
        for (Map.Entry kv : locationsFromField.entrySet()) {
            locs.put((Object)((Descriptors.FieldDescriptor)kv.getKey()), (Object)Collections.unmodifiableList((List)((List)kv.getValue())));
        }
        this.locationsFromField = Collections.unmodifiableMap((Map)locs);
        HashMap subs = new HashMap();
        for (Map.Entry kv : subtreeBuildersFromField.entrySet()) {
            ArrayList submessagesOfField = new ArrayList();
            for (Builder subBuilder : (List)kv.getValue()) {
                submessagesOfField.add((Object)subBuilder.build());
            }
            subs.put((Object)((Descriptors.FieldDescriptor)kv.getKey()), (Object)Collections.unmodifiableList((List)submessagesOfField));
        }
        this.subtreesFromField = Collections.unmodifiableMap((Map)subs);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor fieldDescriptor) {
        List result = (List)this.locationsFromField.get((Object)fieldDescriptor);
        return result == null ? Collections.emptyList() : result;
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor fieldDescriptor, int index) {
        return TextFormatParseInfoTree.getFromList(this.getLocations(fieldDescriptor), index, fieldDescriptor);
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor fieldDescriptor) {
        List result = (List)this.subtreesFromField.get((Object)fieldDescriptor);
        return result == null ? Collections.emptyList() : result;
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor fieldDescriptor, int index) {
        return TextFormatParseInfoTree.getFromList(this.getNestedTrees(fieldDescriptor), index, fieldDescriptor);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static <T> T getFromList(List<T> list, int index, Descriptors.FieldDescriptor fieldDescriptor) {
        if (index >= list.size() || index < 0) {
            throw new IllegalArgumentException(String.format((String)"Illegal index field: %s, index %d", (Object[])new Object[]{fieldDescriptor == null ? "<null>" : fieldDescriptor.getName(), index}));
        }
        return (T)list.get(index);
    }

    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField = new HashMap();
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField = new HashMap();

        private Builder() {
        }

        public Builder setLocation(Descriptors.FieldDescriptor fieldDescriptor, TextFormatParseLocation location) {
            List fieldLocations = (List)this.locationsFromField.get((Object)fieldDescriptor);
            if (fieldLocations == null) {
                fieldLocations = new ArrayList();
                this.locationsFromField.put((Object)fieldDescriptor, (Object)fieldLocations);
            }
            fieldLocations.add((Object)location);
            return this;
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor fieldDescriptor) {
            List submessageBuilders = (List)this.subtreeBuildersFromField.get((Object)fieldDescriptor);
            if (submessageBuilders == null) {
                submessageBuilders = new ArrayList();
                this.subtreeBuildersFromField.put((Object)fieldDescriptor, (Object)submessageBuilders);
            }
            Builder subtreeBuilder = new Builder();
            submessageBuilders.add((Object)subtreeBuilder);
            return subtreeBuilder;
        }

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField);
        }
    }
}

