
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

/**
 * StringInExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L in(String name, Object value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(String name, Object value, Predicate<Object> ignoreStrategy);

}