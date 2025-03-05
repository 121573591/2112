/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.Map
 */
package cn.hutool.core.bean.copier;

import cn.hutool.core.bean.copier.AbsCopier;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.TypeUtil;
import java.lang.reflect.Type;
import java.util.Map;

public class MapToMapCopier
extends AbsCopier<Map, Map> {
    private final Type targetType;

    public MapToMapCopier(Map source2, Map target, Type targetType, CopyOptions copyOptions) {
        super(source2, target, copyOptions);
        this.targetType = targetType;
    }

    @Override
    public Map copy() {
        ((Map)this.source).forEach((sKey, sValue) -> {
            if (null == sKey) {
                return;
            }
            if (this.copyOptions.ignoreNullValue && sValue == null) {
                return;
            }
            String sKeyStr = this.copyOptions.editFieldName(sKey.toString());
            if (null == sKeyStr) {
                return;
            }
            if (!this.copyOptions.testKeyFilter(sKeyStr)) {
                return;
            }
            Object targetValue = ((Map)this.target).get((Object)sKeyStr);
            if (!this.copyOptions.override && null != targetValue) {
                return;
            }
            Type[] typeArguments = TypeUtil.getTypeArguments(this.targetType);
            if (null != typeArguments) {
                sValue = this.copyOptions.convertField(typeArguments[1], sValue);
                sValue = this.copyOptions.editFieldValue(sKeyStr, sValue);
            }
            ((Map)this.target).put((Object)sKeyStr, sValue);
        });
        return (Map)this.target;
    }
}

