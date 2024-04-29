
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityConditionGroupLogicExpression6.
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
public interface EntityQueryConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6,
    C extends EntityQueryConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, S, R>,
    L extends EntityQueryConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, S, R>,
    S extends EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, R>, R>
    extends EntityConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L>, Queryable<S>,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>, EntityQueryLimitExecutor<R>, QueryCountExecutor {

}
