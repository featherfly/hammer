
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * entity query value expression.
 *
 * @author zhongj
 * @param <E> the query entity type
 * @param <V> the fetch value type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 * @param <T> this expression
 */
public interface EntityQueryValueExpression<E, V, C extends EntityQueryValueConditionGroupExpression<E, V, C, L, S>,
    L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, S>,
    S extends EntityQueryValueSortExpression<E, V>, T extends EntityQueryValueExpression<E, V, C, L, S, T>>
    extends EntityQueryValueWhereExpression<E, V, C, L, S>, EntityQueryListExecutor<E>, EntityQueryValueExecutor<V>,
    QueryCountExecutor, EntityQueryConditionLimit<EntityQueryValueLimitExecutor<E, V>>, Queryable<S>,
    ConfigureExpression<T, DslQueryConfig, QueryConditionConfig> {

}
