
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface NotEqualsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <T> the value type
 */
public interface EqualsOrNotEqualsEntityValuePropertyExpression<T> {

    /**
     * Value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    void value(T value);

    /**
     * Value.
     *
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    void value(T value, MatchStrategy matchStrategy);

    /**
     * Value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(T value, Predicate<T> ignoreStrategy);

    /**
     * Value.
     *
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(T value, MatchStrategy matchStrategy, Predicate<T> ignoreStrategy);
}
