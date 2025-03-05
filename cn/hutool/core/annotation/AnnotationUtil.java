/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.SuppressWarnings
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.lang.annotation.Documented
 *  java.lang.annotation.ElementType
 *  java.lang.annotation.Inherited
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 *  java.lang.annotation.Target
 *  java.lang.invoke.SerializedLambda
 *  java.lang.reflect.AnnotatedElement
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 *  java.util.function.Predicate
 *  java.util.stream.Collectors
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.CombinationAnnotationElement;
import cn.hutool.core.annotation.GenericSynthesizedAggregateAnnotation;
import cn.hutool.core.annotation.SynthesizedAggregateAnnotation;
import cn.hutool.core.annotation.SynthesizedAnnotationProxy;
import cn.hutool.core.annotation.scanner.AnnotationScanner;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.lang.func.LambdaUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnnotationUtil {
    static final Set<Class<? extends Annotation>> META_ANNOTATIONS = CollUtil.newHashSet(Target.class, Retention.class, Inherited.class, Documented.class, SuppressWarnings.class, Override.class, Deprecated.class);

    public static boolean isJdkMetaAnnotation(Class<? extends Annotation> annotationType) {
        return META_ANNOTATIONS.contains(annotationType);
    }

    public static boolean isNotJdkMateAnnotation(Class<? extends Annotation> annotationType) {
        return false == AnnotationUtil.isJdkMetaAnnotation(annotationType);
    }

    public static CombinationAnnotationElement toCombination(AnnotatedElement annotationEle) {
        if (annotationEle instanceof CombinationAnnotationElement) {
            return (CombinationAnnotationElement)annotationEle;
        }
        return new CombinationAnnotationElement(annotationEle);
    }

    public static Annotation[] getAnnotations(AnnotatedElement annotationEle, boolean isToCombination) {
        return AnnotationUtil.getAnnotations(annotationEle, isToCombination, (Predicate<Annotation>)((Predicate)null));
    }

    public static <T> T[] getCombinationAnnotations(AnnotatedElement annotationEle, Class<T> annotationType) {
        return AnnotationUtil.getAnnotations(annotationEle, true, annotationType);
    }

    public static <T> T[] getAnnotations(AnnotatedElement annotationEle, boolean isToCombination, Class<T> annotationType) {
        Annotation[] annotations = AnnotationUtil.getAnnotations(annotationEle, isToCombination, (Predicate<Annotation>)((Predicate)annotation -> null == annotationType || annotationType.isAssignableFrom(annotation.getClass())));
        T[] result = ArrayUtil.newArray(annotationType, annotations.length);
        for (int i = 0; i < annotations.length; ++i) {
            result[i] = annotations[i];
        }
        return result;
    }

    public static Annotation[] getAnnotations(AnnotatedElement annotationEle, boolean isToCombination, Predicate<Annotation> predicate) {
        if (null == annotationEle) {
            return null;
        }
        if (isToCombination) {
            if (null == predicate) {
                return AnnotationUtil.toCombination(annotationEle).getAnnotations();
            }
            return CombinationAnnotationElement.of(annotationEle, predicate).getAnnotations();
        }
        Annotation[] result = annotationEle.getAnnotations();
        if (null == predicate) {
            return result;
        }
        return ArrayUtil.filter(result, arg_0 -> predicate.test(arg_0));
    }

    public static <A extends Annotation> A getAnnotation(AnnotatedElement annotationEle, Class<A> annotationType) {
        return null == annotationEle ? null : (A)AnnotationUtil.toCombination(annotationEle).getAnnotation(annotationType);
    }

    public static boolean hasAnnotation(AnnotatedElement annotationEle, Class<? extends Annotation> annotationType) {
        return null != AnnotationUtil.getAnnotation(annotationEle, annotationType);
    }

    public static <T> T getAnnotationValue(AnnotatedElement annotationEle, Class<? extends Annotation> annotationType) throws UtilException {
        return AnnotationUtil.getAnnotationValue(annotationEle, annotationType, "value");
    }

    public static <T> T getAnnotationValue(AnnotatedElement annotationEle, Class<? extends Annotation> annotationType, String propertyName) throws UtilException {
        Annotation annotation = AnnotationUtil.getAnnotation(annotationEle, annotationType);
        if (null == annotation) {
            return null;
        }
        Method method = ReflectUtil.getMethodOfObj(annotation, propertyName, new Object[0]);
        if (null == method) {
            return null;
        }
        return ReflectUtil.invoke((Object)annotation, method, new Object[0]);
    }

    public static <A extends Annotation, R> R getAnnotationValue(AnnotatedElement annotationEle, Func1<A, R> propertyName) {
        if (propertyName == null) {
            return null;
        }
        SerializedLambda lambda = LambdaUtil.resolve(propertyName);
        String instantiatedMethodType = lambda.getInstantiatedMethodType();
        Class annotationClass = ClassUtil.loadClass(StrUtil.sub(instantiatedMethodType, 2, StrUtil.indexOf(instantiatedMethodType, ';')));
        return (R)AnnotationUtil.getAnnotationValue(annotationEle, annotationClass, lambda.getImplMethodName());
    }

    public static Map<String, Object> getAnnotationValueMap(AnnotatedElement annotationEle, Class<? extends Annotation> annotationType) throws UtilException {
        Annotation annotation = AnnotationUtil.getAnnotation(annotationEle, annotationType);
        if (null == annotation) {
            return null;
        }
        Method[] methods = ReflectUtil.getMethods(annotationType, t -> {
            if (ArrayUtil.isEmpty(t.getParameterTypes())) {
                String name = t.getName();
                return false == "hashCode".equals((Object)name) && false == "toString".equals((Object)name) && false == "annotationType".equals((Object)name);
            }
            return false;
        });
        HashMap result = new HashMap(methods.length, 1.0f);
        for (Method method : methods) {
            result.put((Object)method.getName(), ReflectUtil.invoke((Object)annotation, method, new Object[0]));
        }
        return result;
    }

    public static RetentionPolicy getRetentionPolicy(Class<? extends Annotation> annotationType) {
        Retention retention = (Retention)annotationType.getAnnotation(Retention.class);
        if (null == retention) {
            return RetentionPolicy.CLASS;
        }
        return retention.value();
    }

    public static ElementType[] getTargetType(Class<? extends Annotation> annotationType) {
        Target target = (Target)annotationType.getAnnotation(Target.class);
        if (null == target) {
            return new ElementType[]{ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.PACKAGE};
        }
        return target.value();
    }

    public static boolean isDocumented(Class<? extends Annotation> annotationType) {
        return annotationType.isAnnotationPresent(Documented.class);
    }

    public static boolean isInherited(Class<? extends Annotation> annotationType) {
        return annotationType.isAnnotationPresent(Inherited.class);
    }

    public static List<Annotation> scanMetaAnnotation(Class<? extends Annotation> annotationType) {
        return AnnotationScanner.DIRECTLY_AND_META_ANNOTATION.getAnnotationsIfSupport((AnnotatedElement)annotationType);
    }

    public static List<Annotation> scanClass(Class<?> targetClass) {
        return AnnotationScanner.TYPE_HIERARCHY.getAnnotationsIfSupport((AnnotatedElement)targetClass);
    }

    public static List<Annotation> scanMethod(Method method) {
        return AnnotationScanner.TYPE_HIERARCHY.getAnnotationsIfSupport((AnnotatedElement)method);
    }

    public static void setValue(Annotation annotation, String annotationField, Object value) {
        Map memberValues = (Map)ReflectUtil.getFieldValue((Object)Proxy.getInvocationHandler((Object)annotation), "memberValues");
        memberValues.put((Object)annotationField, value);
    }

    public static boolean isSynthesizedAnnotation(Annotation annotation) {
        return SynthesizedAnnotationProxy.isProxyAnnotation(annotation.getClass());
    }

    public static <T extends Annotation> T getAnnotationAlias(AnnotatedElement annotationEle, Class<T> annotationType) {
        T annotation = AnnotationUtil.getAnnotation(annotationEle, annotationType);
        if (null == annotation) {
            return null;
        }
        return (T)AnnotationUtil.aggregatingFromAnnotation(new Annotation[]{annotation}).synthesize(annotationType);
    }

    public static <T extends Annotation> T getSynthesizedAnnotation(Class<T> annotationType, Annotation ... annotations) {
        return (T)((Annotation)Opt.ofNullable(annotations).filter((Predicate<Annotation[]>)((Predicate)ArrayUtil::isNotEmpty)).map(AnnotationUtil::aggregatingFromAnnotationWithMeta).map(a -> a.synthesize(annotationType)).get());
    }

    public static <T extends Annotation> T getSynthesizedAnnotation(AnnotatedElement annotatedEle, Class<T> annotationType) {
        Annotation target = annotatedEle.getAnnotation(annotationType);
        if (ObjectUtil.isNotNull(target)) {
            return (T)target;
        }
        return (T)((Annotation)AnnotationScanner.DIRECTLY.getAnnotationsIfSupport(annotatedEle).stream().map(annotation -> AnnotationUtil.getSynthesizedAnnotation(annotationType, annotation)).filter(Objects::nonNull).findFirst().orElse(null));
    }

    public static <T extends Annotation> List<T> getAllSynthesizedAnnotations(AnnotatedElement annotatedEle, Class<T> annotationType) {
        return (List)AnnotationScanner.DIRECTLY.getAnnotationsIfSupport(annotatedEle).stream().map(annotation -> AnnotationUtil.getSynthesizedAnnotation(annotationType, annotation)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static SynthesizedAggregateAnnotation aggregatingFromAnnotation(Annotation ... annotations) {
        return new GenericSynthesizedAggregateAnnotation((List<Annotation>)Arrays.asList((Object[])annotations), AnnotationScanner.NOTHING);
    }

    public static SynthesizedAggregateAnnotation aggregatingFromAnnotationWithMeta(Annotation ... annotations) {
        return new GenericSynthesizedAggregateAnnotation((List<Annotation>)Arrays.asList((Object[])annotations), AnnotationScanner.DIRECTLY_AND_META_ANNOTATION);
    }

    static boolean isAttributeMethod(Method method) {
        return method.getParameterCount() == 0 && method.getReturnType() != Void.TYPE;
    }
}

