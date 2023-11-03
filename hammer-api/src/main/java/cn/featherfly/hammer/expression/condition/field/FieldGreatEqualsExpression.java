
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface PropertyGreatEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldGreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * 大于等于.
     *
     * @param value the value
     * @return LogicExpression
     */
    L ge(V value);

    /**
     * 大于等于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(V value, IgnoreStrategy ignoreStrategy) {
        return ge(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * 大于等于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(V value, Predicate<V> ignoreStrategy);
}