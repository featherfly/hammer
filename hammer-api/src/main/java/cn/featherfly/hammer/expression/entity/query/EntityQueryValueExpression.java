
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
 * @param <E> the query type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryValueExpression<E, V, C extends EntityQueryValueConditionGroupExpression<E, V, C, L, S>,
    L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, S>,
    S extends EntityQueryValueSortExpression<E, V>>
    extends EntityQueryValueWhereExpression<E, V, C, L, S>, EntityQueryListExecutor<E>, EntityQueryValueExecutor<V>,
    QueryCountExecutor, EntityQueryConditionLimit<EntityQueryValueLimitExecutor<E, V>>, Queryable<S>,
    ConfigureExpression<EntityQueryValueExpression<E, V, C, L, S>, DslQueryConfig, QueryConditionConfig> {

}
