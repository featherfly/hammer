
package cn.featherfly.hammer.expression.entity.execute;

import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EntityUpdateNumberValueExpression.
 *
 * @author zhongj
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityUpdateNumberValueExpression<T extends Number, U, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityUpdateValueExpression<T, U, C, L> {

    /**
     * increase value.
     *
     * @param value the value
     * @return the u
     */
    U increase(T value);

    /**
     * increase value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    default U increase(T value, IgnoreStrategy ignoreStrategy) {
        return increase(value, ignoreStrategy::test);
    }

    /**
     * increase value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    U increase(T value, Predicate<T> ignoreStrategy);
}
