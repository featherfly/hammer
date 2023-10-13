
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;

/**
 * The Interface EntityQueryValueConditionGroupExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryValueConditionGroupExpression<E, V,
        C extends EntityQueryValueConditionGroupExpression<E, V, C, L, S>,
        L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, S>,
        S extends EntityQueryValueSortExpression<E, V>> extends EntityConditionGroupExpression<E, C, L> {
}
