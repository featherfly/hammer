
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityPropertyExpression5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityPropertyExpression<E, C, L> {

    /**
     * property.
     *
     * @param entityPropertyFunction the entity property function
     * @return the LogicExpression
     */
    L property(FiveArgusFunction<EntityPropertyExpression<E, ?, ?>, EntityPropertyExpression<E2, ?, ?>,
        EntityPropertyExpression<E3, ?, ?>, EntityPropertyExpression<E4, ?, ?>, EntityPropertyExpression<E5, ?, ?>,
        LogicExpression<?, ?>> entityPropertyFunction);
}
