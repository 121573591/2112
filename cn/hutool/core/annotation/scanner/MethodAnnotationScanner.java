/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AnnotatedElement
 *  java.lang.reflect.Method
 *  java.util.Set
 *  java.util.function.Predicate
 *  java.util.stream.Stream
 */
package cn.hutool.core.annotation.scanner;

import cn.hutool.core.annotation.scanner.AbstractTypeAnnotationScanner;
import cn.hutool.core.annotation.scanner.AnnotationScanner;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MethodAnnotationScanner
extends AbstractTypeAnnotationScanner<MethodAnnotationScanner>
implements AnnotationScanner {
    public MethodAnnotationScanner() {
        this(false);
    }

    public MethodAnnotationScanner(boolean scanSameSignatureMethod) {
        this(scanSameSignatureMethod, (Predicate<Class<?>>)((Predicate)targetClass -> true), (Set<Class<?>>)CollUtil.newLinkedHashSet(new Class[0]));
    }

    public MethodAnnotationScanner(boolean scanSameSignatureMethod, Predicate<Class<?>> filter, Set<Class<?>> excludeTypes) {
        super(scanSameSignatureMethod, scanSameSignatureMethod, filter, excludeTypes);
    }

    public MethodAnnotationScanner(boolean includeSuperClass, boolean includeInterfaces, Predicate<Class<?>> filter, Set<Class<?>> excludeTypes) {
        super(includeSuperClass, includeInterfaces, filter, excludeTypes);
    }

    @Override
    public boolean support(AnnotatedElement annotatedEle) {
        return annotatedEle instanceof Method;
    }

    @Override
    protected Class<?> getClassFormAnnotatedElement(AnnotatedElement annotatedElement) {
        return ((Method)annotatedElement).getDeclaringClass();
    }

    @Override
    protected Annotation[] getAnnotationsFromTargetClass(AnnotatedElement source2, int index, Class<?> targetClass) {
        Method sourceMethod = (Method)source2;
        return (Annotation[])Stream.of((Object[])ClassUtil.getDeclaredMethods(targetClass)).filter(superMethod -> !superMethod.isBridge()).filter(superMethod -> this.hasSameSignature(sourceMethod, (Method)superMethod)).map(AnnotatedElement::getAnnotations).flatMap(Stream::of).toArray(Annotation[]::new);
    }

    public MethodAnnotationScanner setScanSameSignatureMethod(boolean scanSuperMethodIfOverride) {
        this.setIncludeInterfaces(scanSuperMethodIfOverride);
        this.setIncludeSuperClass(scanSuperMethodIfOverride);
        return this;
    }

    private boolean hasSameSignature(Method sourceMethod, Method superMethod) {
        Class[] targetParameterTypes;
        if (!StrUtil.equals(sourceMethod.getName(), superMethod.getName())) {
            return false;
        }
        Class[] sourceParameterTypes = sourceMethod.getParameterTypes();
        if (sourceParameterTypes.length != (targetParameterTypes = superMethod.getParameterTypes()).length) {
            return false;
        }
        if (!ArrayUtil.containsAll(sourceParameterTypes, targetParameterTypes)) {
            return false;
        }
        return ClassUtil.isAssignable(superMethod.getReturnType(), sourceMethod.getReturnType());
    }
}

