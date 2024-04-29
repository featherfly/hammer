
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityWhereExpression;

/**
 * The Interface EntityQueryWhereExpression.
 *
 * @author zhongj
 * @param <E> filterable entity type
 * @param <V> filterable entity fetch property type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 */
public interface EntityQueryValueWhereExpression<E, V,
    C extends EntityQueryValueConditionGroupExpression<E, V, C, L, S>,
    L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, S>,
    S extends EntityQueryValueSortExpression<E, V>> extends EntityWhereExpression<E, C, L> {

}
