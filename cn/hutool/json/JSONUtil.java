/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Type
 *  java.nio.charset.Charset
 *  java.sql.SQLException
 *  java.time.temporal.TemporalAccessor
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package cn.hutool.json;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.map.MapWrapper;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONStrFormatter;
import cn.hutool.json.JSONString;
import cn.hutool.json.XML;
import cn.hutool.json.serialize.GlobalSerializeMapping;
import cn.hutool.json.serialize.JSONArraySerializer;
import cn.hutool.json.serialize.JSONDeserializer;
import cn.hutool.json.serialize.JSONObjectSerializer;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONUtil {
    public static JSONObject createObj() {
        return new JSONObject();
    }

    public static JSONObject createObj(JSONConfig config) {
        return new JSONObject(config);
    }

    public static JSONArray createArray() {
        return new JSONArray();
    }

    public static JSONArray createArray(JSONConfig config) {
        return new JSONArray(config);
    }

    public static JSONObject parseObj(String jsonStr) {
        return new JSONObject(jsonStr);
    }

    public static JSONObject parseObj(Object obj) {
        return JSONUtil.parseObj(obj, null);
    }

    public static JSONObject parseObj(Object obj, JSONConfig config) {
        return new JSONObject(obj, ObjectUtil.defaultIfNull(config, JSONConfig::create));
    }

    public static JSONObject parseObj(Object obj, boolean ignoreNullValue) {
        return new JSONObject(obj, ignoreNullValue);
    }

    @Deprecated
    public static JSONObject parseObj(Object obj, boolean ignoreNullValue, boolean isOrder) {
        return new JSONObject(obj, ignoreNullValue);
    }

    public static JSONArray parseArray(String jsonStr) {
        return new JSONArray(jsonStr);
    }

    public static JSONArray parseArray(Object arrayOrCollection) {
        return JSONUtil.parseArray(arrayOrCollection, null);
    }

    public static JSONArray parseArray(Object arrayOrCollection, JSONConfig config) {
        return new JSONArray(arrayOrCollection, config);
    }

    public static JSONArray parseArray(Object arrayOrCollection, boolean ignoreNullValue) {
        return new JSONArray(arrayOrCollection, ignoreNullValue);
    }

    public static JSON parse(Object obj) {
        return JSONUtil.parse(obj, null);
    }

    public static JSON parse(Object obj, JSONConfig config) {
        String jsonStr;
        if (null == obj) {
            return null;
        }
        JSON json = obj instanceof JSON ? (JSON)obj : (obj instanceof CharSequence ? (JSONUtil.isTypeJSONArray(jsonStr = StrUtil.trim((CharSequence)obj)) ? JSONUtil.parseArray((Object)jsonStr, config) : JSONUtil.parseObj((Object)jsonStr, config)) : (obj instanceof MapWrapper ? JSONUtil.parseObj(obj, config) : (obj instanceof Iterable || obj instanceof Iterator || ArrayUtil.isArray(obj) ? JSONUtil.parseArray(obj, config) : JSONUtil.parseObj(obj, config))));
        return json;
    }

    public static JSONObject parseFromXml(String xmlStr) {
        return XML.toJSONObject(xmlStr);
    }

    public static JSON readJSON(File file, Charset charset) throws IORuntimeException {
        return JSONUtil.parse(FileReader.create(file, charset).readString());
    }

    public static JSONObject readJSONObject(File file, Charset charset) throws IORuntimeException {
        return JSONUtil.parseObj(FileReader.create(file, charset).readString());
    }

    public static JSONArray readJSONArray(File file, Charset charset) throws IORuntimeException {
        return JSONUtil.parseArray(FileReader.create(file, charset).readString());
    }

    public static String toJsonStr(JSON json, int indentFactor) {
        if (null == json) {
            return null;
        }
        return json.toJSONString(indentFactor);
    }

    public static String toJsonStr(JSON json) {
        if (null == json) {
            return null;
        }
        return json.toJSONString(0);
    }

    public static void toJsonStr(JSON json, Writer writer) {
        if (null != json) {
            json.write(writer);
        }
    }

    public static String toJsonPrettyStr(JSON json) {
        if (null == json) {
            return null;
        }
        return json.toJSONString(4);
    }

    public static String toJsonStr(Object obj) {
        return JSONUtil.toJsonStr(obj, (JSONConfig)null);
    }

    public static String toJsonStr(Object obj, JSONConfig jsonConfig) {
        if (null == obj) {
            return null;
        }
        if (obj instanceof CharSequence) {
            return StrUtil.str((CharSequence)obj);
        }
        return JSONUtil.toJsonStr(JSONUtil.parse(obj, jsonConfig));
    }

    public static void toJsonStr(Object obj, Writer writer) {
        if (null != obj) {
            JSONUtil.toJsonStr(JSONUtil.parse(obj), writer);
        }
    }

    public static String toJsonPrettyStr(Object obj) {
        return JSONUtil.toJsonPrettyStr(JSONUtil.parse(obj));
    }

    public static String toXmlStr(JSON json) {
        return XML.toXml(json);
    }

    public static <T> T toBean(String jsonString, Class<T> beanClass) {
        return JSONUtil.toBean(JSONUtil.parseObj(jsonString), beanClass);
    }

    public static <T> T toBean(String jsonString, JSONConfig config, Class<T> beanClass) {
        return JSONUtil.toBean(JSONUtil.parseObj((Object)jsonString, config), beanClass);
    }

    public static <T> T toBean(JSONObject json, Class<T> beanClass) {
        return (T)(null == json ? null : json.toBean(beanClass));
    }

    public static <T> T toBean(String jsonString, TypeReference<T> typeReference, boolean ignoreError) {
        return JSONUtil.toBean(jsonString, typeReference.getType(), ignoreError);
    }

    public static <T> T toBean(String jsonString, Type beanType, boolean ignoreError) {
        JSON json = JSONUtil.parse(jsonString, JSONConfig.create().setIgnoreError(ignoreError));
        if (null == json) {
            return null;
        }
        return json.toBean(beanType);
    }

    public static <T> T toBean(JSON json, TypeReference<T> typeReference, boolean ignoreError) {
        return JSONUtil.toBean(json, typeReference.getType(), ignoreError);
    }

    public static <T> T toBean(JSON json, Type beanType, boolean ignoreError) {
        if (null == json) {
            return null;
        }
        return json.toBean(beanType, ignoreError);
    }

    public static <T> List<T> toList(String jsonArray, Class<T> elementType) {
        return JSONUtil.toList(JSONUtil.parseArray(jsonArray), elementType);
    }

    public static <T> List<T> toList(JSONArray jsonArray, Class<T> elementType) {
        return null == jsonArray ? null : jsonArray.toList(elementType);
    }

    public static Object getByPath(JSON json, String expression) {
        return JSONUtil.getByPath(json, expression, null);
    }

    public static <T> T getByPath(JSON json, String expression, T defaultValue) {
        if (null == json || StrUtil.isBlank(expression)) {
            return defaultValue;
        }
        if (null != defaultValue) {
            Class type = defaultValue.getClass();
            return ObjectUtil.defaultIfNull(json.getByPath(expression, type), defaultValue);
        }
        return (T)json.getByPath(expression);
    }

    public static void putByPath(JSON json, String expression, Object value) {
        json.putByPath(expression, value);
    }

    public static String quote(String string) {
        return JSONUtil.quote(string, true);
    }

    public static String quote(String string, boolean isWrap) {
        StringWriter sw = new StringWriter();
        try {
            return JSONUtil.quote(string, (Writer)sw, isWrap).toString();
        }
        catch (IOException ignored) {
            return "";
        }
    }

    public static Writer quote(String str, Writer writer) throws IOException {
        return JSONUtil.quote(str, writer, true);
    }

    public static Writer quote(String str, Writer writer, boolean isWrap) throws IOException {
        if (StrUtil.isEmpty(str)) {
            if (isWrap) {
                writer.write("\"\"");
            }
            return writer;
        }
        int len = str.length();
        if (isWrap) {
            writer.write(34);
        }
        block3: for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            switch (c) {
                case '\"': 
                case '\\': {
                    writer.write("\\");
                    writer.write((int)c);
                    continue block3;
                }
                default: {
                    writer.write(JSONUtil.escape(c));
                }
            }
        }
        if (isWrap) {
            writer.write(34);
        }
        return writer;
    }

    public static String escape(String str) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }
        int len = str.length();
        StringBuilder builder = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            builder.append(JSONUtil.escape(c));
        }
        return builder.toString();
    }

    public static Object wrap(Object object, JSONConfig jsonConfig) {
        if (object == null) {
            return jsonConfig.isIgnoreNullValue() ? null : JSONNull.NULL;
        }
        if (object instanceof JSON || ObjectUtil.isNull(object) || object instanceof JSONString || object instanceof CharSequence || object instanceof Number || ObjectUtil.isBasicType(object)) {
            if (object instanceof Number && null != jsonConfig.getDateFormat()) {
                return new NumberWithFormat((Number)object, jsonConfig.getDateFormat());
            }
            return object;
        }
        try {
            if (object instanceof SQLException) {
                return object.toString();
            }
            if (object instanceof Iterable || ArrayUtil.isArray(object)) {
                return new JSONArray(object, jsonConfig);
            }
            if (object instanceof Map || object instanceof Map.Entry) {
                return new JSONObject(object, jsonConfig);
            }
            if (object instanceof Date || object instanceof Calendar || object instanceof TemporalAccessor) {
                return object;
            }
            if (object instanceof Enum) {
                return object.toString();
            }
            if (ClassUtil.isJdkClass(object.getClass())) {
                return object.toString();
            }
            return new JSONObject(object, jsonConfig);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String formatJsonStr(String jsonStr) {
        return JSONStrFormatter.format(jsonStr);
    }

    @Deprecated
    public static boolean isJson(String str) {
        return JSONUtil.isTypeJSON(str);
    }

    public static boolean isTypeJSON(String str) {
        return JSONUtil.isTypeJSONObject(str) || JSONUtil.isTypeJSONArray(str);
    }

    @Deprecated
    public static boolean isJsonObj(String str) {
        return JSONUtil.isTypeJSONObject(str);
    }

    public static boolean isTypeJSONObject(String str) {
        if (StrUtil.isBlank(str)) {
            return false;
        }
        return StrUtil.isWrap((CharSequence)StrUtil.trim(str), '{', '}');
    }

    @Deprecated
    public static boolean isJsonArray(String str) {
        return JSONUtil.isTypeJSONArray(str);
    }

    public static boolean isTypeJSONArray(String str) {
        if (StrUtil.isBlank(str)) {
            return false;
        }
        return StrUtil.isWrap((CharSequence)StrUtil.trim(str), '[', ']');
    }

    public static boolean isNull(Object obj) {
        return null == obj || obj instanceof JSONNull;
    }

    public static JSONObject xmlToJson(String xml) {
        return XML.toJSONObject(xml);
    }

    public static void putSerializer(Type type, JSONArraySerializer<?> serializer) {
        GlobalSerializeMapping.put(type, serializer);
    }

    public static void putSerializer(Type type, JSONObjectSerializer<?> serializer) {
        GlobalSerializeMapping.put(type, serializer);
    }

    public static void putDeserializer(Type type, JSONDeserializer<?> deserializer) {
        GlobalSerializeMapping.put(type, deserializer);
    }

    private static String escape(char c) {
        switch (c) {
            case '\b': {
                return "\\b";
            }
            case '\t': {
                return "\\t";
            }
            case '\n': {
                return "\\n";
            }
            case '\f': {
                return "\\f";
            }
            case '\r': {
                return "\\r";
            }
        }
        if (c < ' ' || c >= '' && c <= ' ' || c >= '\u2000' && c <= '\u2010' || c >= '\u2028' && c <= '\u202f' || c >= '\u2066' && c <= '\u206f') {
            return HexUtil.toUnicodeHex(c);
        }
        return Character.toString((char)c);
    }
}

