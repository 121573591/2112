/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package cn.hutool.db.sql;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.sql.Condition;
import cn.hutool.db.sql.ConditionBuilder;
import java.util.List;

public class ConditionGroup
extends Condition {
    private Condition[] conditions;

    public void addConditions(Condition ... conditions) {
        this.conditions = null == this.conditions ? conditions : ArrayUtil.addAll(this.conditions, conditions);
    }

    @Override
    public String toString(List<Object> paramValues) {
        if (ArrayUtil.isEmpty(this.conditions)) {
            return "";
        }
        StringBuilder conditionStrBuilder = StrUtil.builder();
        conditionStrBuilder.append("(");
        conditionStrBuilder.append(ConditionBuilder.of(this.conditions).build(paramValues));
        conditionStrBuilder.append(")");
        return conditionStrBuilder.toString();
    }
}

