
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression6;

/**
 * The Interface EntityConditionGroupExpression6.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <E6> sixth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <S>  sort expression
 * @param <R>  query result type
 */
public interface EntityQueryConditionGroupExpression6<E1, E2, E3, E4, E5, E6,
    C extends EntityQueryConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, S, R>,
    L extends EntityQueryConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, S, R>,
    S extends EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, R>, R>
    extends EntityConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    ConditionConfigureExpression<C, QueryConditionConfig> {
}
