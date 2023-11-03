
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface PropertyLessThanExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FiledLessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * less than. 小于.
     *
     * @param value the value
     * @return LogicExpression
     */
    L lt(V value);

    /**
     * less than. 小于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(V value, IgnoreStrategy ignoreStrategy) {
        return lt(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(V value, Predicate<V> ignoreStrategy);
}