/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Map$Entry
 */
package cn.hutool.db.sql;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class Wrapper
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Character preWrapQuote;
    private Character sufWrapQuote;

    public Wrapper() {
    }

    public Wrapper(Character wrapQuote) {
        this.preWrapQuote = wrapQuote;
        this.sufWrapQuote = wrapQuote;
    }

    public Wrapper(Character preWrapQuote, Character sufWrapQuote) {
        this.preWrapQuote = preWrapQuote;
        this.sufWrapQuote = sufWrapQuote;
    }

    public char getPreWrapQuote() {
        return this.preWrapQuote.charValue();
    }

    public void setPreWrapQuote(Character preWrapQuote) {
        this.preWrapQuote = preWrapQuote;
    }

    public char getSufWrapQuote() {
        return this.sufWrapQuote.charValue();
    }

    public void setSufWrapQuote(Character sufWrapQuote) {
        this.sufWrapQuote = sufWrapQuote;
    }

    public String wrap(String field) {
        if (this.preWrapQuote == null || this.sufWrapQuote == null || StrUtil.isBlank(field)) {
            return field;
        }
        if (StrUtil.isSurround((CharSequence)field, this.preWrapQuote.charValue(), this.sufWrapQuote.charValue())) {
            return field;
        }
        if (StrUtil.containsAnyIgnoreCase(field, "*", "(", " ", " as ")) {
            return field;
        }
        if (field.contains((CharSequence)".")) {
            Collection<String> target = CollUtil.edit(StrUtil.split(field, '.', 2), t -> StrUtil.format("{}{}{}", this.preWrapQuote, t, this.sufWrapQuote));
            return CollectionUtil.join(target, (CharSequence)".");
        }
        return StrUtil.format("{}{}{}", this.preWrapQuote, field, this.sufWrapQuote);
    }

    public String[] wrap(String ... fields) {
        if (ArrayUtil.isEmpty(fields)) {
            return fields;
        }
        String[] wrappedFields = new String[fields.length];
        for (int i = 0; i < fields.length; ++i) {
            wrappedFields[i] = this.wrap(fields[i]);
        }
        return wrappedFields;
    }

    public Collection<String> wrap(Collection<String> fields) {
        if (CollectionUtil.isEmpty(fields)) {
            return fields;
        }
        return Arrays.asList((Object[])this.wrap((String[])fields.toArray((Object[])new String[0])));
    }

    public Entity wrap(Entity entity) {
        if (null == entity) {
            return null;
        }
        Entity wrapedEntity = new Entity();
        wrapedEntity.setTableName(this.wrap(entity.getTableName()));
        for (Map.Entry entry : entity.entrySet()) {
            wrapedEntity.set(this.wrap((String)entry.getKey()), entry.getValue());
        }
        return wrapedEntity;
    }

    public Condition[] wrap(Condition ... conditions) {
        Condition[] clonedConditions = new Condition[conditions.length];
        if (ArrayUtil.isNotEmpty(conditions)) {
            for (int i = 0; i < conditions.length; ++i) {
                Condition clonedCondition = (Condition)conditions[i].clone();
                clonedCondition.setField(this.wrap(clonedCondition.getField()));
                clonedConditions[i] = clonedCondition;
            }
        }
        return clonedConditions;
    }
}

