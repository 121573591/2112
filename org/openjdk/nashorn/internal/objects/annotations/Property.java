/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.ElementType
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 *  java.lang.annotation.Target
 */
package org.openjdk.nashorn.internal.objects.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.openjdk.nashorn.internal.objects.annotations.Where;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface Property {
    public String name() default "";

    public int attributes() default 0;

    public String clazz() default "";

    public Where where() default Where.INSTANCE;
}

