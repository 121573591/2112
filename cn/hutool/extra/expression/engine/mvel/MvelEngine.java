/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 *  org.mvel2.MVEL
 */
package cn.hutool.extra.expression.engine.mvel;

import cn.hutool.extra.expression.ExpressionEngine;
import java.util.Collection;
import java.util.Map;
import org.mvel2.MVEL;

public class MvelEngine
implements ExpressionEngine {
    @Override
    public Object eval(String expression, Map<String, Object> context, Collection<Class<?>> allowClassSet) {
        return MVEL.eval((String)expression, context);
    }

    private static void checkEngineExist(Class<?> clazz) {
    }

    static {
        MvelEngine.checkEngineExist(MVEL.class);
    }
}

