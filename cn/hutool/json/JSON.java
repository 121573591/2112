/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.Cloneable
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package cn.hutool.json;

import cn.hutool.core.bean.copier.IJSONTypeConverter;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;

public interface JSON
extends Cloneable,
Serializable,
IJSONTypeConverter {
    public JSONConfig getConfig();

    public Object getByPath(String var1);

    public void putByPath(String var1, Object var2);

    public <T> T getByPath(String var1, Class<T> var2);

    default public String toStringPretty() throws JSONException {
        return this.toJSONString(4);
    }

    default public String toJSONString(int indentFactor) throws JSONException {
        StringWriter sw = new StringWriter();
        return this.write((Writer)sw, indentFactor, 0).toString();
    }

    default public Writer write(Writer writer) throws JSONException {
        return this.write(writer, 0, 0);
    }

    public Writer write(Writer var1, int var2, int var3) throws JSONException;

    default public <T> T toBean(Class<T> clazz) {
        return this.toBean((Type)clazz);
    }

    default public <T> T toBean(TypeReference<T> reference) {
        return this.toBean(reference.getType());
    }

    @Override
    default public <T> T toBean(Type type) {
        return JSONConverter.jsonConvert(type, this, this.getConfig());
    }

    @Deprecated
    default public <T> T toBean(Type type, boolean ignoreError) {
        return JSONConverter.jsonConvert(type, this, JSONConfig.create().setIgnoreError(ignoreError));
    }
}

