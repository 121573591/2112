/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jfirer.jfireel.expression.Expression
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 */
package cn.hutool.extra.expression.engine.jfireel;

import cn.hutool.extra.expression.ExpressionEngine;
import com.jfirer.jfireel.expression.Expression;
import java.util.Collection;
import java.util.Map;

public class JfireELEngine
implements ExpressionEngine {
    @Override
    public Object eval(String expression, Map<String, Object> context, Collection<Class<?>> allowClassSet) {
        return Expression.parse((String)expression).calculate(context);
    }

    private static void checkEngineExist(Class<?> clazz) {
    }

    static {
        JfireELEngine.checkEngineExist(Expression.class);
    }
}

