/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.AnnotationAttribute;
import cn.hutool.core.annotation.WrappedAnnotationAttribute;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractWrappedAnnotationAttribute
implements WrappedAnnotationAttribute {
    protected final AnnotationAttribute original;
    protected final AnnotationAttribute linked;

    protected AbstractWrappedAnnotationAttribute(AnnotationAttribute original, AnnotationAttribute linked) {
        Assert.notNull(original, "target must not null", new Object[0]);
        Assert.notNull(linked, "linked must not null", new Object[0]);
        this.original = original;
        this.linked = linked;
    }

    @Override
    public AnnotationAttribute getOriginal() {
        return this.original;
    }

    @Override
    public AnnotationAttribute getLinked() {
        return this.linked;
    }

    @Override
    public AnnotationAttribute getNonWrappedOriginal() {
        AnnotationAttribute curr = null;
        AnnotationAttribute next = this.original;
        while (next != null) {
            curr = next;
            next = next.isWrapped() ? ((WrappedAnnotationAttribute)curr).getOriginal() : null;
        }
        return curr;
    }

    @Override
    public Collection<AnnotationAttribute> getAllLinkedNonWrappedAttributes() {
        ArrayList leafAttributes = new ArrayList();
        this.collectLeafAttribute(this, (List<AnnotationAttribute>)leafAttributes);
        return leafAttributes;
    }

    private void collectLeafAttribute(AnnotationAttribute curr, List<AnnotationAttribute> leafAttributes) {
        if (ObjectUtil.isNull(curr)) {
            return;
        }
        if (!curr.isWrapped()) {
            leafAttributes.add((Object)curr);
            return;
        }
        WrappedAnnotationAttribute wrappedAttribute = (WrappedAnnotationAttribute)curr;
        this.collectLeafAttribute(wrappedAttribute.getOriginal(), leafAttributes);
        this.collectLeafAttribute(wrappedAttribute.getLinked(), leafAttributes);
    }
}

