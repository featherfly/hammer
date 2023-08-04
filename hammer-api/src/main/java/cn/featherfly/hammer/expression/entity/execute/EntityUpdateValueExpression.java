
package cn.featherfly.hammer.expression.entity.execute;

import java.util.function.Consumer;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;

/**
 * EntityUpdateValueExpression .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityUpdateValueExpression<E, T, U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>> {

    /**
     * Sets the.
     *
     * @param value the value
     * @return the u
     */
    U set(T value);

    /**
     * Sets the.
     *
     * @param consumer the consumer
     * @return the u
     */
    U set(Consumer<EntityUpdateValueExpression<E, T, U, C, L>> consumer);
}
