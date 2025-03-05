/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Map$Entry
 */
package cn.hutool.json;

import cn.hutool.core.bean.BeanPath;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.lang.mutable.MutablePair;
import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.map.MapWrapper;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.json.InternalJSONUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONGetter;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.ObjectMapper;
import cn.hutool.json.serialize.JSONWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

public class JSONObject
extends MapWrapper<String, Object>
implements JSON,
JSONGetter<String> {
    private static final long serialVersionUID = -330220388580734346L;
    public static final int DEFAULT_CAPACITY = 16;
    private JSONConfig config;

    public JSONObject() {
        this(16, false);
    }

    public JSONObject(boolean isOrder) {
        this(16, isOrder);
    }

    public JSONObject(int capacity, boolean isOrder) {
        this(capacity, false, isOrder);
    }

    @Deprecated
    public JSONObject(int capacity, boolean isIgnoreCase, boolean isOrder) {
        this(capacity, JSONConfig.create().setIgnoreCase(isIgnoreCase));
    }

    public JSONObject(JSONConfig config) {
        this(16, config);
    }

    public JSONObject(int capacity, JSONConfig config) {
        super(InternalJSONUtil.createRawMap(capacity, ObjectUtil.defaultIfNull(config, JSONConfig.create())));
        this.config = ObjectUtil.defaultIfNull(config, JSONConfig.create());
    }

    public JSONObject(Object source2) {
        this(source2, InternalJSONUtil.defaultIgnoreNullValue(source2));
    }

    public JSONObject(Object source2, boolean ignoreNullValue) {
        this(source2, JSONConfig.create().setIgnoreNullValue(ignoreNullValue));
    }

    @Deprecated
    public JSONObject(Object source2, boolean ignoreNullValue, boolean isOrder) {
        this(source2, JSONConfig.create().setIgnoreCase(source2 instanceof CaseInsensitiveMap).setIgnoreNullValue(ignoreNullValue));
    }

    public JSONObject(Object source2, JSONConfig config) {
        this(source2, config, null);
    }

    public JSONObject(Object source2, JSONConfig config, Filter<MutablePair<String, Object>> filter) {
        this(16, config);
        ObjectMapper.of(source2).map(this, filter);
    }

    public JSONObject(Object source2, String ... names) {
        this();
        if (ArrayUtil.isEmpty(names)) {
            ObjectMapper.of(source2).map(this, null);
            return;
        }
        if (source2 instanceof Map) {
            for (String name : names) {
                Object value = ((Map)source2).get((Object)name);
                this.set(name, value, null, this.getConfig().isCheckDuplicate());
            }
        } else {
            for (String name : names) {
                try {
                    this.putOpt(name, ReflectUtil.getFieldValue(source2, name));
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }

    @Deprecated
    public JSONObject(CharSequence source2, boolean isOrder) throws JSONException {
        this((Object)source2, JSONConfig.create());
    }

    @Override
    public JSONConfig getConfig() {
        return this.config;
    }

    public JSONObject setDateFormat(String format) {
        this.config.setDateFormat(format);
        return this;
    }

    public JSONArray toJSONArray(Collection<String> names) throws JSONException {
        if (CollectionUtil.isEmpty(names)) {
            return null;
        }
        JSONArray ja = new JSONArray(this.config);
        for (String name : names) {
            Object value = this.get(name);
            if (null == value) continue;
            ja.set(value);
        }
        return ja;
    }

    @Override
    public Object getObj(String key, Object defaultValue) {
        return this.getOrDefault(key, defaultValue);
    }

    @Override
    public Object getByPath(String expression) {
        return BeanPath.create(expression).get(this);
    }

    @Override
    public <T> T getByPath(String expression, Class<T> resultType) {
        return JSONConverter.jsonConvert(resultType, this.getByPath(expression), this.getConfig());
    }

    @Override
    public void putByPath(String expression, Object value) {
        BeanPath.create(expression).set(this, value);
    }

    @Override
    @Deprecated
    public JSONObject put(String key, Object value) throws JSONException {
        return this.set(key, value);
    }

    public JSONObject set(String key, Object value) throws JSONException {
        return this.set(key, value, null, false);
    }

    public JSONObject set(String key, Object value, Filter<MutablePair<String, Object>> filter, boolean checkDuplicate) throws JSONException {
        if (null == key) {
            return this;
        }
        if (null != filter) {
            MutablePair<String, Object> pair = new MutablePair<String, Object>(key, value);
            if (filter.accept(pair)) {
                key = (String)pair.getKey();
                value = pair.getValue();
            } else {
                return this;
            }
        }
        boolean ignoreNullValue = this.config.isIgnoreNullValue();
        if (ObjectUtil.isNull(value) && ignoreNullValue) {
            this.remove(key);
        } else {
            if (checkDuplicate && this.containsKey(key)) {
                throw new JSONException("Duplicate key \"{}\"", key);
            }
            super.put(key, JSONUtil.wrap(InternalJSONUtil.testValidity(value), this.config));
        }
        return this;
    }

    public JSONObject putOnce(String key, Object value) throws JSONException {
        return this.setOnce(key, value, null);
    }

    public JSONObject setOnce(String key, Object value, Filter<MutablePair<String, Object>> filter) throws JSONException {
        return this.set(key, value, filter, true);
    }

    public JSONObject putOpt(String key, Object value) throws JSONException {
        if (key != null && value != null) {
            this.set(key, value);
        }
        return this;
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        for (Map.Entry entry : m.entrySet()) {
            this.set((String)entry.getKey(), entry.getValue());
        }
    }

    public JSONObject accumulate(String key, Object value) throws JSONException {
        InternalJSONUtil.testValidity(value);
        Object object = this.getObj(key);
        if (object == null) {
            this.set(key, value);
        } else if (object instanceof JSONArray) {
            ((JSONArray)object).set(value);
        } else {
            this.set(key, JSONUtil.createArray(this.config).set(object).set(value));
        }
        return this;
    }

    public JSONObject append(String key, Object value) throws JSONException {
        InternalJSONUtil.testValidity(value);
        Object object = this.getObj(key);
        if (object == null) {
            this.set(key, new JSONArray(this.config).set(value));
        } else if (object instanceof JSONArray) {
            this.set(key, ((JSONArray)object).set(value));
        } else {
            throw new JSONException("JSONObject [" + key + "] is not a JSONArray.");
        }
        return this;
    }

    public JSONObject increment(String key) throws JSONException {
        Object value = this.getObj(key);
        if (value == null) {
            this.set(key, 1);
        } else if (value instanceof BigInteger) {
            this.set(key, ((BigInteger)value).add(BigInteger.ONE));
        } else if (value instanceof BigDecimal) {
            this.set(key, ((BigDecimal)value).add(BigDecimal.ONE));
        } else if (value instanceof Integer) {
            this.set(key, (Integer)value + 1);
        } else if (value instanceof Long) {
            this.set(key, (Long)value + 1L);
        } else if (value instanceof Double) {
            this.set(key, (Double)value + 1.0);
        } else if (value instanceof Float) {
            this.set(key, Float.valueOf((float)(((Float)value).floatValue() + 1.0f)));
        } else {
            throw new JSONException("Unable to increment [" + JSONUtil.quote(key) + "].");
        }
        return this;
    }

    @Override
    public String toString() {
        return this.toJSONString(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toJSONString(int indentFactor, Filter<MutablePair<Object, Object>> filter) {
        StringWriter sw = new StringWriter();
        StringBuffer stringBuffer = sw.getBuffer();
        synchronized (stringBuffer) {
            return this.write((Writer)sw, indentFactor, 0, filter).toString();
        }
    }

    @Override
    public Writer write(Writer writer, int indentFactor, int indent) throws JSONException {
        return this.write(writer, indentFactor, indent, null);
    }

    public Writer write(Writer writer, int indentFactor, int indent, Filter<MutablePair<Object, Object>> filter) throws JSONException {
        JSONWriter jsonWriter = JSONWriter.of(writer, indentFactor, indent, this.config).beginObj();
        this.forEach((key, value) -> jsonWriter.writeField(new MutablePair<Object, Object>(key, value), filter));
        jsonWriter.end();
        return writer;
    }

    @Override
    public JSONObject clone() throws CloneNotSupportedException {
        JSONObject clone = (JSONObject)super.clone();
        clone.config = this.config;
        return clone;
    }
}

