
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryValueConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryValueConditionGroupLogicExpression<E, V,
        C extends EntityQueryValueConditionGroupExpression<E, V, C, L, S>,
        L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, S>,
        S extends EntityQueryValueSortExpression<E, V>> extends EntityConditionGroupLogicExpression<E, C, L>,
        Queryable<S>, EntityQueryConditionLimit<V>, EntityQueryLimitExecutor<V>, QueryCountExecutor
//        EntityQueryConditionGroupLogicExpression<E, C, L, S>, QueryValueExecutor
{
}
