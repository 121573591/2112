/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.util.HashMap
 *  java.util.Map
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProxy<T extends Annotation>
implements Annotation,
InvocationHandler,
Serializable {
    private static final long serialVersionUID = 1L;
    private final T annotation;
    private final Class<T> type;
    private final Map<String, Object> attributes;

    public AnnotationProxy(T annotation) {
        this.annotation = annotation;
        this.type = annotation.annotationType();
        this.attributes = this.initAttributes();
    }

    public Class<? extends Annotation> annotationType() {
        return this.type;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name;
        Alias alias = (Alias)method.getAnnotation(Alias.class);
        if (null != alias && StrUtil.isNotBlank(name = alias.value())) {
            if (!this.attributes.containsKey((Object)name)) {
                throw new IllegalArgumentException(StrUtil.format("No method for alias: [{}]", name));
            }
            return this.attributes.get((Object)name);
        }
        Object value = this.attributes.get((Object)method.getName());
        if (value != null) {
            return value;
        }
        return method.invoke((Object)this, args);
    }

    private Map<String, Object> initAttributes() {
        Method[] methods = ReflectUtil.getMethods(this.type);
        HashMap attributes = new HashMap(methods.length, 1.0f);
        for (Method method : methods) {
            if (method.isSynthetic()) continue;
            attributes.put((Object)method.getName(), ReflectUtil.invoke(this.annotation, method, new Object[0]));
        }
        return attributes;
    }
}

