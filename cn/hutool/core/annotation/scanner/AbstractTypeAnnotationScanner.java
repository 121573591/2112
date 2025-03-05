/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AnnotatedElement
 *  java.lang.reflect.Proxy
 *  java.util.ArrayList
 *  java.util.LinkedHashSet
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 *  java.util.function.BiConsumer
 *  java.util.function.Predicate
 *  java.util.function.UnaryOperator
 */
package cn.hutool.core.annotation.scanner;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.annotation.scanner.AnnotationScanner;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public abstract class AbstractTypeAnnotationScanner<T extends AbstractTypeAnnotationScanner<T>>
implements AnnotationScanner {
    private boolean includeSuperClass;
    private boolean includeInterfaces;
    private Predicate<Class<?>> filter;
    private final Set<Class<?>> excludeTypes;
    private final List<UnaryOperator<Class<?>>> converters;
    private boolean hasConverters;
    private final T typedThis;

    protected AbstractTypeAnnotationScanner(boolean includeSuperClass, boolean includeInterfaces, Predicate<Class<?>> filter, Set<Class<?>> excludeTypes) {
        Assert.notNull(filter, "filter must not null", new Object[0]);
        Assert.notNull(excludeTypes, "excludeTypes must not null", new Object[0]);
        this.includeSuperClass = includeSuperClass;
        this.includeInterfaces = includeInterfaces;
        this.filter = filter;
        this.excludeTypes = excludeTypes;
        this.converters = new ArrayList();
        this.typedThis = this;
    }

    public boolean isIncludeSuperClass() {
        return this.includeSuperClass;
    }

    public boolean isIncludeInterfaces() {
        return this.includeInterfaces;
    }

    public T setFilter(Predicate<Class<?>> filter) {
        Assert.notNull(filter, "filter must not null", new Object[0]);
        this.filter = filter;
        return this.typedThis;
    }

    public T addExcludeTypes(Class<?> ... excludeTypes) {
        CollUtil.addAll(this.excludeTypes, excludeTypes);
        return this.typedThis;
    }

    public T addConverters(UnaryOperator<Class<?>> converter) {
        Assert.notNull(converter, "converter must not null", new Object[0]);
        this.converters.add(converter);
        if (!this.hasConverters) {
            this.hasConverters = CollUtil.isNotEmpty(this.converters);
        }
        return this.typedThis;
    }

    protected T setIncludeSuperClass(boolean includeSuperClass) {
        this.includeSuperClass = includeSuperClass;
        return this.typedThis;
    }

    protected T setIncludeInterfaces(boolean includeInterfaces) {
        this.includeInterfaces = includeInterfaces;
        return this.typedThis;
    }

    @Override
    public void scan(BiConsumer<Integer, Annotation> consumer, AnnotatedElement annotatedEle, Predicate<Annotation> filter) {
        filter = ObjectUtil.defaultIfNull(filter, a -> annotation -> true);
        Class<?> sourceClass = this.getClassFormAnnotatedElement(annotatedEle);
        LinkedList<List> classDeque = CollUtil.newLinkedList(CollUtil.newArrayList(sourceClass));
        LinkedHashSet accessedTypes = new LinkedHashSet();
        int index = 0;
        while (!classDeque.isEmpty()) {
            List currClassQueue = (List)classDeque.removeFirst();
            ArrayList nextClassQueue = new ArrayList();
            for (Class<?> targetClass : currClassQueue) {
                Annotation[] targetAnnotations;
                if (this.isNotNeedProcess((Set<Class<?>>)accessedTypes, targetClass = this.convert(targetClass))) continue;
                accessedTypes.add(targetClass);
                this.scanSuperClassIfNecessary((List<Class<?>>)nextClassQueue, targetClass);
                this.scanInterfaceIfNecessary((List<Class<?>>)nextClassQueue, targetClass);
                for (Annotation annotation : targetAnnotations = this.getAnnotationsFromTargetClass(annotatedEle, index, targetClass)) {
                    if (!AnnotationUtil.isNotJdkMateAnnotation((Class<? extends Annotation>)annotation.annotationType()) || !filter.test((Object)annotation)) continue;
                    consumer.accept((Object)index, (Object)annotation);
                }
                ++index;
            }
            if (!CollUtil.isNotEmpty(nextClassQueue)) continue;
            classDeque.addLast((Object)nextClassQueue);
        }
    }

    protected abstract Class<?> getClassFormAnnotatedElement(AnnotatedElement var1);

    protected abstract Annotation[] getAnnotationsFromTargetClass(AnnotatedElement var1, int var2, Class<?> var3);

    protected boolean isNotNeedProcess(Set<Class<?>> accessedTypes, Class<?> targetClass) {
        return ObjectUtil.isNull(targetClass) || accessedTypes.contains(targetClass) || this.excludeTypes.contains(targetClass) || this.filter.negate().test(targetClass);
    }

    protected void scanInterfaceIfNecessary(List<Class<?>> nextClasses, Class<?> targetClass) {
        Class[] interfaces;
        if (this.includeInterfaces && ArrayUtil.isNotEmpty(interfaces = targetClass.getInterfaces())) {
            CollUtil.addAll(nextClasses, interfaces);
        }
    }

    protected void scanSuperClassIfNecessary(List<Class<?>> nextClassQueue, Class<?> targetClass) {
        Class superClass;
        if (this.includeSuperClass && !ObjectUtil.equals(superClass = targetClass.getSuperclass(), Object.class) && ObjectUtil.isNotNull(superClass)) {
            nextClassQueue.add((Object)superClass);
        }
    }

    protected Class<?> convert(Class<?> target) {
        if (this.hasConverters) {
            for (UnaryOperator converter : this.converters) {
                target = (Class)converter.apply((Object)target);
            }
        }
        return target;
    }

    public static class JdkProxyClassConverter
    implements UnaryOperator<Class<?>> {
        public Class<?> apply(Class<?> sourceClass) {
            return Proxy.isProxyClass(sourceClass) ? this.apply(sourceClass.getSuperclass()) : sourceClass;
        }
    }
}

