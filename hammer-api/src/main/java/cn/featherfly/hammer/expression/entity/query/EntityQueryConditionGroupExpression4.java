
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression4;

/**
 * The Interface EntityConditionGroupExpression4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <S>  sort expression
 * @param <R>  query result type
 */
public interface EntityQueryConditionGroupExpression4<E1, E2, E3, E4,
    C extends EntityQueryConditionGroupExpression4<E1, E2, E3, E4, C, L, S, R>,
    L extends EntityQueryConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, S, R>,
    S extends EntityQuerySortExpression4<E1, E2, E3, E4, R>, R> extends
    EntityConditionGroupExpression4<E1, E2, E3, E4, C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
