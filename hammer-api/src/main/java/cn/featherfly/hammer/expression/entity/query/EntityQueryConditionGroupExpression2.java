
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression2;

/**
 * The Interface EntityConditionGroupExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <S>  sort expression
 * @param <R>  query result type
 */
public interface EntityQueryConditionGroupExpression2<E1, E2,
    C extends EntityQueryConditionGroupExpression2<E1, E2, C, L, S, R>,
    L extends EntityQueryConditionGroupLogicExpression2<E1, E2, C, L, S, R>,
    S extends EntityQuerySortExpression2<E1, E2, R>, R>
    extends EntityConditionGroupExpression2<E1, E2, C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
