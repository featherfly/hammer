
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression4;

/**
 * The Interface EntityConditionGroupLogicExpression4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 * @param <S2> sorted expression
 * @param <R> query result type
 */
public interface EntityQueryConditionGroupLogicExpression4<E1, E2, E3, E4,
    C extends EntityQueryConditionGroupExpression4<E1, E2, E3, E4, C, L, S, S2, R>,
    L extends EntityQueryConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, S, S2, R>,
    S extends EntityQuerySortExpression4<E1, E2, E3, E4, R>, S2 extends EntityQuerySortedExpression4<E1, E2, E3, E4, R>,
    R> extends EntityConditionGroupLogicExpression4<E1, E2, E3, E4, C, L>, EntityQueryable4<E1, E2, E3, E4, S, S2>,
    QueryLimitSetter<QueryLimitExecutor<R>>, QueryLimitExecutor<R>, QueryCountExecutor {

}
