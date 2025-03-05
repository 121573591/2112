/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.annotation.Documented
 *  java.lang.annotation.ElementType
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 *  java.lang.annotation.Target
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.Link;
import cn.hutool.core.annotation.RelationType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Link(type=RelationType.MIRROR_FOR)
@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface MirrorFor {
    @Link(annotation=Link.class, attribute="annotation", type=RelationType.FORCE_ALIAS_FOR)
    public Class<? extends Annotation> annotation() default Annotation.class;

    @Link(annotation=Link.class, attribute="attribute", type=RelationType.FORCE_ALIAS_FOR)
    public String attribute() default "";
}

