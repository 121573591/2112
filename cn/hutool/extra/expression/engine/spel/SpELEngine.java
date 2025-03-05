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
 *  org.springframework.expression.EvaluationContext
 *  org.springframework.expression.ExpressionParser
 *  org.springframework.expression.spel.standard.SpelExpressionParser
 *  org.springframework.expression.spel.support.StandardEvaluationContext
 */
package cn.hutool.extra.expression.engine.spel;

import cn.hutool.extra.expression.ExpressionEngine;
import java.util.Collection;
import java.util.Map;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELEngine
implements ExpressionEngine {
    private final ExpressionParser parser = new SpelExpressionParser();

    @Override
    public Object eval(String expression, Map<String, Object> context, Collection<Class<?>> allowClassSet) {
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        context.forEach((arg_0, arg_1) -> ((EvaluationContext)evaluationContext).setVariable(arg_0, arg_1));
        return this.parser.parseExpression(expression).getValue((EvaluationContext)evaluationContext);
    }
}

