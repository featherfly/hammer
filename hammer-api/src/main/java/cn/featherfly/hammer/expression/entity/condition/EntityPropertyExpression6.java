
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityPropertyExpression6.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityPropertyExpression<E, C, L> {

    /**
     * property.
     *
     * @param entityPropertyFunction the entity property function
     * @return the LogicExpression
     */
    L property(SixArgusFunction<EntityPropertyExpression<E, ?, ?>, EntityPropertyExpression<E2, ?, ?>,
        EntityPropertyExpression<E3, ?, ?>, EntityPropertyExpression<E4, ?, ?>, EntityPropertyExpression<E5, ?, ?>,
        EntityPropertyExpression<E6, ?, ?>, LogicExpression<?, ?>> entityPropertyFunction);
}
