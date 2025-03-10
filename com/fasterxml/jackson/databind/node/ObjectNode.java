/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.JsonNodeFeature;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class ObjectNode
extends ContainerNode<ObjectNode>
implements Serializable {
    private static final long serialVersionUID = 1L;
    protected final Map<String, JsonNode> _children;

    public ObjectNode(JsonNodeFactory nc) {
        super(nc);
        this._children = new LinkedHashMap();
    }

    public ObjectNode(JsonNodeFactory nc, Map<String, JsonNode> children) {
        super(nc);
        this._children = (Map)Objects.requireNonNull(children, (String)"Must not pass `null` for 'children' argument");
    }

    @Override
    protected JsonNode _at(JsonPointer ptr) {
        return this.get(ptr.getMatchingProperty());
    }

    public ObjectNode deepCopy() {
        ObjectNode ret = new ObjectNode(this._nodeFactory);
        for (Map.Entry entry : this._children.entrySet()) {
            ret._children.put(entry.getKey(), ((JsonNode)entry.getValue()).deepCopy());
        }
        return ret;
    }

    @Deprecated
    public ObjectNode with(String exprOrProperty) {
        JsonPointer ptr = this._jsonPointerIfValid(exprOrProperty);
        if (ptr != null) {
            return this.withObject(ptr);
        }
        JsonNode n = (JsonNode)this._children.get((Object)exprOrProperty);
        if (n != null) {
            if (n instanceof ObjectNode) {
                return (ObjectNode)n;
            }
            throw new UnsupportedOperationException("Property '" + exprOrProperty + "' has value that is not of type `ObjectNode` (but `" + n.getClass().getName() + "`)");
        }
        ObjectNode result = this.objectNode();
        this._children.put((Object)exprOrProperty, (Object)result);
        return result;
    }

    @Override
    public ObjectNode withObject(String exprOrProperty) {
        JsonPointer ptr = this._jsonPointerIfValid(exprOrProperty);
        if (ptr != null) {
            return this.withObject(ptr);
        }
        return this.withObjectProperty(exprOrProperty);
    }

    @Override
    public ObjectNode withObjectProperty(String propName) {
        JsonNode child = (JsonNode)this._children.get((Object)propName);
        if (child == null || child.isNull()) {
            return this.putObject(propName);
        }
        if (child.isObject()) {
            return (ObjectNode)child;
        }
        return (ObjectNode)this._reportWrongNodeType("Cannot replace `JsonNode` of type `%s` with `ObjectNode` for property \"%s\" (default mode `OverwriteMode.%s`)", new Object[]{child.getClass().getName(), propName, JsonNode.OverwriteMode.NULLS});
    }

    public ArrayNode withArray(String exprOrProperty) {
        JsonPointer ptr = this._jsonPointerIfValid(exprOrProperty);
        if (ptr != null) {
            return this.withArray(ptr);
        }
        JsonNode n = (JsonNode)this._children.get((Object)exprOrProperty);
        if (n != null) {
            if (n instanceof ArrayNode) {
                return (ArrayNode)n;
            }
            throw new UnsupportedOperationException("Property '" + exprOrProperty + "' has value that is not of type `ArrayNode` (but `" + n.getClass().getName() + "`)");
        }
        ArrayNode result = this.arrayNode();
        this._children.put((Object)exprOrProperty, (Object)result);
        return result;
    }

    @Override
    public ArrayNode withArrayProperty(String propName) {
        JsonNode child = (JsonNode)this._children.get((Object)propName);
        if (child == null || child.isNull()) {
            return this.putArray(propName);
        }
        if (child.isArray()) {
            return (ArrayNode)child;
        }
        return (ArrayNode)this._reportWrongNodeType("Cannot replace `JsonNode` of type `%s` with `ArrayNode` for property \"%s\" with (default mode `OverwriteMode.%s`)", new Object[]{child.getClass().getName(), propName, JsonNode.OverwriteMode.NULLS});
    }

    @Override
    protected ObjectNode _withObject(JsonPointer origPtr, JsonPointer currentPtr, JsonNode.OverwriteMode overwriteMode, boolean preferIndex) {
        if (currentPtr.matches()) {
            return this;
        }
        JsonNode n = this._at(currentPtr);
        if (n != null && n instanceof BaseJsonNode) {
            ObjectNode found = ((BaseJsonNode)n)._withObject(origPtr, currentPtr.tail(), overwriteMode, preferIndex);
            if (found != null) {
                return found;
            }
            this._withXxxVerifyReplace(origPtr, currentPtr, overwriteMode, preferIndex, n);
        }
        return this._withObjectAddTailProperty(currentPtr, preferIndex);
    }

    @Override
    protected ArrayNode _withArray(JsonPointer origPtr, JsonPointer currentPtr, JsonNode.OverwriteMode overwriteMode, boolean preferIndex) {
        if (currentPtr.matches()) {
            return null;
        }
        JsonNode n = this._at(currentPtr);
        if (n != null && n instanceof BaseJsonNode) {
            ArrayNode found = ((BaseJsonNode)n)._withArray(origPtr, currentPtr.tail(), overwriteMode, preferIndex);
            if (found != null) {
                return found;
            }
            this._withXxxVerifyReplace(origPtr, currentPtr, overwriteMode, preferIndex, n);
        }
        return this._withArrayAddTailProperty(currentPtr, preferIndex);
    }

    protected ObjectNode _withObjectAddTailProperty(JsonPointer tail, boolean preferIndex) {
        String propName = tail.getMatchingProperty();
        if ((tail = tail.tail()).matches()) {
            return this.putObject(propName);
        }
        if (preferIndex && tail.mayMatchElement()) {
            return this.putArray(propName)._withObjectAddTailElement(tail, preferIndex);
        }
        return this.putObject(propName)._withObjectAddTailProperty(tail, preferIndex);
    }

    protected ArrayNode _withArrayAddTailProperty(JsonPointer tail, boolean preferIndex) {
        String propName = tail.getMatchingProperty();
        if ((tail = tail.tail()).matches()) {
            return this.putArray(propName);
        }
        if (preferIndex && tail.mayMatchElement()) {
            return this.putArray(propName)._withArrayAddTailElement(tail, preferIndex);
        }
        return this.putObject(propName)._withArrayAddTailProperty(tail, preferIndex);
    }

    @Override
    public boolean isEmpty(SerializerProvider serializers) {
        return this._children.isEmpty();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.OBJECT;
    }

    @Override
    public final boolean isObject() {
        return true;
    }

    @Override
    public JsonToken asToken() {
        return JsonToken.START_OBJECT;
    }

    @Override
    public int size() {
        return this._children.size();
    }

    @Override
    public boolean isEmpty() {
        return this._children.isEmpty();
    }

    @Override
    public Iterator<JsonNode> elements() {
        return this._children.values().iterator();
    }

    @Override
    public JsonNode get(int index) {
        return null;
    }

    @Override
    public JsonNode get(String propertyName) {
        return (JsonNode)this._children.get((Object)propertyName);
    }

    @Override
    public Iterator<String> fieldNames() {
        return this._children.keySet().iterator();
    }

    @Override
    public JsonNode path(int index) {
        return MissingNode.getInstance();
    }

    @Override
    public JsonNode path(String propertyName) {
        JsonNode n = (JsonNode)this._children.get((Object)propertyName);
        if (n != null) {
            return n;
        }
        return MissingNode.getInstance();
    }

    @Override
    public JsonNode required(String propertyName) {
        JsonNode n = (JsonNode)this._children.get((Object)propertyName);
        if (n != null) {
            return n;
        }
        return (JsonNode)this._reportRequiredViolation("No value for property '%s' of `ObjectNode`", propertyName);
    }

    @Override
    public Iterator<Map.Entry<String, JsonNode>> fields() {
        return this._children.entrySet().iterator();
    }

    @Override
    public Set<Map.Entry<String, JsonNode>> properties() {
        return this._children.entrySet();
    }

    @Override
    public boolean equals(Comparator<JsonNode> comparator, JsonNode o) {
        if (!(o instanceof ObjectNode)) {
            return false;
        }
        ObjectNode other = (ObjectNode)o;
        Map<String, JsonNode> m1 = this._children;
        Map<String, JsonNode> m2 = other._children;
        int len = m1.size();
        if (m2.size() != len) {
            return false;
        }
        for (Map.Entry entry : m1.entrySet()) {
            JsonNode v2 = (JsonNode)m2.get(entry.getKey());
            if (v2 != null && ((JsonNode)entry.getValue()).equals(comparator, v2)) continue;
            return false;
        }
        return true;
    }

    @Override
    public JsonNode findValue(String propertyName) {
        JsonNode jsonNode = (JsonNode)this._children.get((Object)propertyName);
        if (jsonNode != null) {
            return jsonNode;
        }
        for (JsonNode child : this._children.values()) {
            JsonNode value = child.findValue(propertyName);
            if (value == null) continue;
            return value;
        }
        return null;
    }

    @Override
    public List<JsonNode> findValues(String propertyName, List<JsonNode> foundSoFar) {
        for (Map.Entry entry : this._children.entrySet()) {
            if (propertyName.equals(entry.getKey())) {
                if (foundSoFar == null) {
                    foundSoFar = new List<JsonNode>();
                }
                foundSoFar.add(entry.getValue());
                continue;
            }
            foundSoFar = ((JsonNode)entry.getValue()).findValues(propertyName, foundSoFar);
        }
        return foundSoFar;
    }

    @Override
    public List<String> findValuesAsText(String propertyName, List<String> foundSoFar) {
        for (Map.Entry entry : this._children.entrySet()) {
            if (propertyName.equals(entry.getKey())) {
                if (foundSoFar == null) {
                    foundSoFar = new List<String>();
                }
                foundSoFar.add((Object)((JsonNode)entry.getValue()).asText());
                continue;
            }
            foundSoFar = ((JsonNode)entry.getValue()).findValuesAsText(propertyName, foundSoFar);
        }
        return foundSoFar;
    }

    @Override
    public ObjectNode findParent(String propertyName) {
        JsonNode jsonNode = (JsonNode)this._children.get((Object)propertyName);
        if (jsonNode != null) {
            return this;
        }
        for (JsonNode child : this._children.values()) {
            JsonNode value = child.findParent(propertyName);
            if (value == null) continue;
            return (ObjectNode)value;
        }
        return null;
    }

    @Override
    public List<JsonNode> findParents(String propertyName, List<JsonNode> foundSoFar) {
        for (Map.Entry entry : this._children.entrySet()) {
            if (propertyName.equals(entry.getKey())) {
                if (foundSoFar == null) {
                    foundSoFar = new List<JsonNode>();
                }
                foundSoFar.add((Object)this);
                continue;
            }
            foundSoFar = ((JsonNode)entry.getValue()).findParents(propertyName, foundSoFar);
        }
        return foundSoFar;
    }

    @Override
    public void serialize(JsonGenerator g, SerializerProvider provider) throws IOException {
        if (provider != null) {
            boolean skipNulls;
            boolean trimEmptyArray = !provider.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
            boolean bl = skipNulls = !provider.isEnabled(JsonNodeFeature.WRITE_NULL_PROPERTIES);
            if (trimEmptyArray || skipNulls) {
                g.writeStartObject(this);
                this.serializeFilteredContents(g, provider, trimEmptyArray, skipNulls);
                g.writeEndObject();
                return;
            }
        }
        g.writeStartObject(this);
        for (Map.Entry en : this._contentsToSerialize(provider).entrySet()) {
            JsonNode value = (JsonNode)en.getValue();
            g.writeFieldName((String)en.getKey());
            value.serialize(g, provider);
        }
        g.writeEndObject();
    }

    @Override
    public void serializeWithType(JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        boolean trimEmptyArray = false;
        boolean skipNulls = false;
        if (provider != null) {
            trimEmptyArray = !provider.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
            skipNulls = !provider.isEnabled(JsonNodeFeature.WRITE_NULL_PROPERTIES);
        }
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(g, typeSer.typeId(this, JsonToken.START_OBJECT));
        if (trimEmptyArray || skipNulls) {
            this.serializeFilteredContents(g, provider, trimEmptyArray, skipNulls);
        } else {
            for (Map.Entry en : this._contentsToSerialize(provider).entrySet()) {
                JsonNode value = (JsonNode)en.getValue();
                g.writeFieldName((String)en.getKey());
                value.serialize(g, provider);
            }
        }
        typeSer.writeTypeSuffix(g, typeIdDef);
    }

    protected void serializeFilteredContents(JsonGenerator g, SerializerProvider ctxt, boolean trimEmptyArray, boolean skipNulls) throws IOException {
        for (Map.Entry en : this._contentsToSerialize(ctxt).entrySet()) {
            JsonNode value = (JsonNode)en.getValue();
            if (trimEmptyArray && value.isArray() && value.isEmpty(ctxt) || skipNulls && value.isNull()) continue;
            g.writeFieldName((String)en.getKey());
            value.serialize(g, ctxt);
        }
    }

    protected Map<String, JsonNode> _contentsToSerialize(SerializerProvider ctxt) {
        if (ctxt.isEnabled(JsonNodeFeature.WRITE_PROPERTIES_SORTED) && !this._children.isEmpty()) {
            return new TreeMap(this._children);
        }
        return this._children;
    }

    public <T extends JsonNode> T set(String propertyName, JsonNode value) {
        if (value == null) {
            value = this.nullNode();
        }
        this._children.put((Object)propertyName, (Object)value);
        return (T)this;
    }

    public <T extends JsonNode> T setAll(Map<String, ? extends JsonNode> properties) {
        for (Map.Entry en : properties.entrySet()) {
            JsonNode n = (JsonNode)en.getValue();
            if (n == null) {
                n = this.nullNode();
            }
            this._children.put(en.getKey(), (Object)n);
        }
        return (T)this;
    }

    public <T extends JsonNode> T setAll(ObjectNode other) {
        this._children.putAll(other._children);
        return (T)this;
    }

    public JsonNode replace(String propertyName, JsonNode value) {
        if (value == null) {
            value = this.nullNode();
        }
        return (JsonNode)this._children.put((Object)propertyName, (Object)value);
    }

    public <T extends JsonNode> T without(String propertyName) {
        this._children.remove((Object)propertyName);
        return (T)this;
    }

    public <T extends JsonNode> T without(Collection<String> propertyNames) {
        this._children.keySet().removeAll(propertyNames);
        return (T)this;
    }

    @Deprecated
    public JsonNode put(String propertyName, JsonNode value) {
        if (value == null) {
            value = this.nullNode();
        }
        return (JsonNode)this._children.put((Object)propertyName, (Object)value);
    }

    public JsonNode putIfAbsent(String propertyName, JsonNode value) {
        if (value == null) {
            value = this.nullNode();
        }
        return (JsonNode)this._children.putIfAbsent((Object)propertyName, (Object)value);
    }

    public JsonNode remove(String propertyName) {
        return (JsonNode)this._children.remove((Object)propertyName);
    }

    public ObjectNode remove(Collection<String> propertyNames) {
        this._children.keySet().removeAll(propertyNames);
        return this;
    }

    @Override
    public ObjectNode removeAll() {
        this._children.clear();
        return this;
    }

    @Deprecated
    public JsonNode putAll(Map<String, ? extends JsonNode> properties) {
        return this.setAll(properties);
    }

    @Deprecated
    public JsonNode putAll(ObjectNode other) {
        return this.setAll(other);
    }

    public ObjectNode retain(Collection<String> propertyNames) {
        this._children.keySet().retainAll(propertyNames);
        return this;
    }

    public ObjectNode retain(String ... propertyNames) {
        return this.retain((Collection<String>)Arrays.asList((Object[])propertyNames));
    }

    public ArrayNode putArray(String propertyName) {
        ArrayNode n = this.arrayNode();
        this._put(propertyName, n);
        return n;
    }

    public ObjectNode putObject(String propertyName) {
        ObjectNode n = this.objectNode();
        this._put(propertyName, n);
        return n;
    }

    public ObjectNode putPOJO(String propertyName, Object pojo) {
        return this._put(propertyName, this.pojoNode(pojo));
    }

    public ObjectNode putRawValue(String propertyName, RawValue raw) {
        return this._put(propertyName, this.rawValueNode(raw));
    }

    public ObjectNode putNull(String propertyName) {
        this._children.put((Object)propertyName, (Object)this.nullNode());
        return this;
    }

    public ObjectNode put(String propertyName, short v) {
        return this._put(propertyName, this.numberNode(v));
    }

    public ObjectNode put(String fieldName, Short v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.numberNode((short)v));
    }

    public ObjectNode put(String fieldName, int v) {
        return this._put(fieldName, this.numberNode(v));
    }

    public ObjectNode put(String fieldName, Integer v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.numberNode((int)v));
    }

    public ObjectNode put(String fieldName, long v) {
        return this._put(fieldName, this.numberNode(v));
    }

    public ObjectNode put(String fieldName, Long v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.numberNode((long)v));
    }

    public ObjectNode put(String fieldName, float v) {
        return this._put(fieldName, this.numberNode(v));
    }

    public ObjectNode put(String fieldName, Float v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.numberNode(v.floatValue()));
    }

    public ObjectNode put(String fieldName, double v) {
        return this._put(fieldName, this.numberNode(v));
    }

    public ObjectNode put(String fieldName, Double v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.numberNode((double)v));
    }

    public ObjectNode put(String fieldName, BigDecimal v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.numberNode(v));
    }

    public ObjectNode put(String fieldName, BigInteger v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.numberNode(v));
    }

    public ObjectNode put(String fieldName, String v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.textNode(v));
    }

    public ObjectNode put(String fieldName, boolean v) {
        return this._put(fieldName, this.booleanNode(v));
    }

    public ObjectNode put(String fieldName, Boolean v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.booleanNode(v));
    }

    public ObjectNode put(String fieldName, byte[] v) {
        return this._put(fieldName, v == null ? this.nullNode() : this.binaryNode(v));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof ObjectNode) {
            return this._childrenEqual((ObjectNode)o);
        }
        return false;
    }

    protected boolean _childrenEqual(ObjectNode other) {
        return this._children.equals(other._children);
    }

    @Override
    public int hashCode() {
        return this._children.hashCode();
    }

    protected ObjectNode _put(String fieldName, JsonNode value) {
        this._children.put((Object)fieldName, (Object)value);
        return this;
    }
}

