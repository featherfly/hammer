
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression5;

/**
 * The Interface EntityConditionGroupLogicExpression5.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 * @param <S2> sorted expression
 * @param <R> query result type
 */
public interface EntityQueryConditionGroupLogicExpression5<E1, E2, E3, E4, E5,
    C extends EntityQueryConditionGroupExpression5<E1, E2, E3, E4, E5, C, L, S, S2, R>,
    L extends EntityQueryConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L, S, S2, R>,
    S extends EntityQuerySortExpression5<E1, E2, E3, E4, E5, R>,
    S2 extends EntityQuerySortedExpression5<E1, E2, E3, E4, E5, R>, R>
    extends EntityConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L>, EntityQueryable5<E1, E2, E3, E4, E5, S, S2>,
    QueryLimitSetter<QueryLimitExecutor<R>>, QueryLimitExecutor<R>, QueryCountExecutor {

}
