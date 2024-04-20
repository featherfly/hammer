
package cn.featherfly.hammer.expression.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * update number value .
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <N> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface UpdateNumberValueExpression<N extends Number, U, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends UpdateValueExpressionBase<N, U, C, L> {

    /**
     * increase value.
     *
     * @param value the value
     * @return the PropertyExecutableUpdateExpression
     */
    U increase(N value);

    /**
     * increase value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the PropertyExecutableUpdateExpression
     */
    U increase(N value, Predicate<N> ignoreStrategy);

    /**
     * increase value.
     *
     * @param consumer the consumer
     * @return the u
     */
    U increase(Consumer<UpdateNumberValueExpression<N, U, C, L>> consumer);

    /**
     * set value.
     *
     * @param consumer the consumer
     * @return the u
     */
    U set(Consumer<UpdateNumberValueExpression<N, U, C, L>> consumer);
}
