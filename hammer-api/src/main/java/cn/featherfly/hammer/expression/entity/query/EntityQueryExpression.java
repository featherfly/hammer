
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * EntityQueryEntityExpression .
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <S>  sort expression
 */
public interface EntityQueryExpression<E1, C extends EntityQueryConditionGroupExpression<E1, C, L, S>,
    L extends EntityQueryConditionGroupLogicExpression<E1, C, L, S>, S extends EntityQuerySortExpression<E1>>
    extends EntityQueryWhereExpression<E1, C, L, S>, EntityQueryListExecutor<E1>, QueryCountExecutor,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<E1>>, Queryable<S>,
    ConfigureExpression<EntityQueryExpression<E1, C, L, S>, DslQueryConfig, QueryConditionConfig> {
}
