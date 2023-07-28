package com.steven.cns.common.tool.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

/**
 * @author: steven
 * @date: 2023/7/26 21:55
 */
@Slf4j
public final class SpELUtils {
    private static final LocalVariableTableParameterNameDiscoverer DISCOVERER = new LocalVariableTableParameterNameDiscoverer();

    private SpELUtils() {
    }

    public static String parseSpEL(String key, Method method, Object[] args) {
        try {
            ExpressionParser parser = new SpelExpressionParser();
            StandardEvaluationContext context = new StandardEvaluationContext();
            String[] paramNames = DISCOVERER.getParameterNames(method); //获取方法参数名

            // 把方法的参数放入SpEL上下文中
            if (paramNames != null) {
                for (int i = 0; i < paramNames.length; i++) {
                    context.setVariable(paramNames[i], args[i]);
                }
            }

            Expression expression = parser.parseExpression(key);
            return expression.getValue(context, String.class);
        } catch (Exception e) {
            // Handle any exceptions during expression evaluation
            log.warn("解析SpEL表达式失败:{}", key, e);
            return null;
        }
    }

}
