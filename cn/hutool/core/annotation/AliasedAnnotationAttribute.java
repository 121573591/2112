/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.AbstractWrappedAnnotationAttribute;
import cn.hutool.core.annotation.AnnotationAttribute;

public class AliasedAnnotationAttribute
extends AbstractWrappedAnnotationAttribute {
    protected AliasedAnnotationAttribute(AnnotationAttribute origin, AnnotationAttribute linked) {
        super(origin, linked);
    }

    @Override
    public Object getValue() {
        return this.linked.isValueEquivalentToDefaultValue() ? super.getValue() : this.linked.getValue();
    }

    @Override
    public boolean isValueEquivalentToDefaultValue() {
        return this.linked.isValueEquivalentToDefaultValue() && this.original.isValueEquivalentToDefaultValue();
    }
}

