
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface PropertyGreatThanExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldGreatThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * 大于.
     *
     * @param value the value
     * @return LogicExpression
     */
    L gt(V value);

    /**
     * 大于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(V value, IgnoreStrategy ignoreStrategy) {
        return gt(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * 大于.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(V value, Predicate<V> ignoreStrategy);
}