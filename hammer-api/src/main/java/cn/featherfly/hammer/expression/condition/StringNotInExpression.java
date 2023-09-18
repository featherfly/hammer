
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

/**
 * StringNotInExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ni(String name, Object value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(String name, Object value, Predicate<Object> ignoreStrategy);

}