/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package cn.hutool.core.comparator;

import cn.hutool.core.comparator.FieldComparator;
import cn.hutool.core.comparator.NullComparator;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import java.lang.reflect.Field;

public class FieldsComparator<T>
extends NullComparator<T> {
    private static final long serialVersionUID = 8649196282886500803L;

    public FieldsComparator(Class<T> beanClass, String ... fieldNames) {
        this(true, beanClass, fieldNames);
    }

    public FieldsComparator(boolean nullGreater, Class<T> beanClass, String ... fieldNames) {
        super(nullGreater, (a, b) -> {
            for (String fieldName : fieldNames) {
                Field field = ClassUtil.getDeclaredField(beanClass, fieldName);
                Assert.notNull(field, "Field [{}] not found in Class [{}]", fieldName, beanClass.getName());
                int compare = new FieldComparator<Object>(true, false, field).compare(a, b);
                if (0 == compare) continue;
                return compare;
            }
            return 0;
        });
    }
}

