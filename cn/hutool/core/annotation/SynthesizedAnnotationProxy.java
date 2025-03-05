/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 *  java.util.function.BiFunction
 *  java.util.stream.Collectors
 *  java.util.stream.Stream
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.AnnotationAttributeValueProvider;
import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.annotation.SynthesizedAnnotation;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SynthesizedAnnotationProxy
implements InvocationHandler {
    private final AnnotationAttributeValueProvider annotationAttributeValueProvider;
    private final SynthesizedAnnotation annotation;
    private final Map<String, BiFunction<Method, Object[], Object>> methods;

    public static <T extends Annotation> T create(Class<T> annotationType, AnnotationAttributeValueProvider annotationAttributeValueProvider, SynthesizedAnnotation annotation) {
        if (ObjectUtil.isNull(annotation)) {
            return null;
        }
        SynthesizedAnnotationProxy proxyHandler = new SynthesizedAnnotationProxy(annotationAttributeValueProvider, annotation);
        if (ObjectUtil.isNull(annotation)) {
            return null;
        }
        return (T)((Annotation)Proxy.newProxyInstance((ClassLoader)annotationType.getClassLoader(), (Class[])new Class[]{annotationType, SyntheticProxyAnnotation.class}, (InvocationHandler)proxyHandler));
    }

    public static <T extends Annotation> T create(Class<T> annotationType, SynthesizedAnnotation annotation) {
        return SynthesizedAnnotationProxy.create(annotationType, annotation, annotation);
    }

    public static boolean isProxyAnnotation(Class<?> annotationType) {
        return ClassUtil.isAssignable(SyntheticProxyAnnotation.class, annotationType);
    }

    SynthesizedAnnotationProxy(AnnotationAttributeValueProvider annotationAttributeValueProvider, SynthesizedAnnotation annotation) {
        Assert.notNull(annotationAttributeValueProvider, "annotationAttributeValueProvider must not null", new Object[0]);
        Assert.notNull(annotation, "annotation must not null", new Object[0]);
        this.annotationAttributeValueProvider = annotationAttributeValueProvider;
        this.annotation = annotation;
        this.methods = new HashMap(9);
        this.loadMethods();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return Opt.ofNullable(this.methods.get((Object)method.getName())).map(m -> m.apply((Object)method, (Object)args)).orElseGet(() -> ReflectUtil.invoke((Object)this.annotation.getAnnotation(), method, args));
    }

    void loadMethods() {
        this.methods.put((Object)"toString", (method, args) -> this.proxyToString());
        this.methods.put((Object)"hashCode", (method, args) -> this.proxyHashCode());
        this.methods.put((Object)"getSynthesizedAnnotation", (method, args) -> this.proxyGetSynthesizedAnnotation());
        this.methods.put((Object)"getRoot", (method, args) -> this.annotation.getRoot());
        this.methods.put((Object)"getVerticalDistance", (method, args) -> this.annotation.getVerticalDistance());
        this.methods.put((Object)"getHorizontalDistance", (method, args) -> this.annotation.getHorizontalDistance());
        this.methods.put((Object)"hasAttribute", (method, args) -> this.annotation.hasAttribute((String)args[0], (Class)args[1]));
        this.methods.put((Object)"getAttributes", (method, args) -> this.annotation.getAttributes());
        this.methods.put((Object)"setAttribute", (method, args) -> {
            throw new UnsupportedOperationException("proxied annotation can not reset attributes");
        });
        this.methods.put((Object)"getAttributeValue", (method, args) -> this.annotation.getAttributeValue((String)args[0]));
        this.methods.put((Object)"annotationType", (method, args) -> this.annotation.annotationType());
        Stream.of((Object[])ClassUtil.getDeclaredMethods(this.annotation.getAnnotation().annotationType())).filter(m -> !this.methods.containsKey((Object)m.getName())).forEach(m -> {
            BiFunction cfr_ignored_0 = (BiFunction)this.methods.put((Object)m.getName(), (method, args) -> this.proxyAttributeValue((Method)method));
        });
    }

    private String proxyToString() {
        String attributes = (String)Stream.of((Object[])ClassUtil.getDeclaredMethods(this.annotation.getAnnotation().annotationType())).filter(AnnotationUtil::isAttributeMethod).map(method -> CharSequenceUtil.format("{}={}", method.getName(), this.proxyAttributeValue((Method)method))).collect(Collectors.joining((CharSequence)", "));
        return CharSequenceUtil.format("@{}({})", this.annotation.annotationType().getName(), attributes);
    }

    private int proxyHashCode() {
        return Objects.hash((Object[])new Object[]{this.annotationAttributeValueProvider, this.annotation});
    }

    private Object proxyGetSynthesizedAnnotation() {
        return this.annotation;
    }

    private Object proxyAttributeValue(Method attributeMethod) {
        return this.annotationAttributeValueProvider.getAttributeValue(attributeMethod.getName(), attributeMethod.getReturnType());
    }

    static interface SyntheticProxyAnnotation
    extends SynthesizedAnnotation {
        public SynthesizedAnnotation getSynthesizedAnnotation();
    }
}

