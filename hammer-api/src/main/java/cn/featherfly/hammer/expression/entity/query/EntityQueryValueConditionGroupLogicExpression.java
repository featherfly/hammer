
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.condition.ValueLogicExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.Queryable;

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
    S extends EntityQueryValueSortExpression<E, V>>
    extends ValueLogicExpression<C, L>, EntityConditionGroupLogicExpression<E, C, L>, Queryable<S>,
    QueryLimitSetter<EntityQueryValueLimitExecutor<E, V>>, EntityQueryValueLimitExecutor<E, V>, QueryCountExecutor {
}
