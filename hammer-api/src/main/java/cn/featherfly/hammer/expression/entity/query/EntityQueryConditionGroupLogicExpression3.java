
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression3;

/**
 * The Interface EntityConditionGroupLogicExpression3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 * @param <S2> sorted expression
 * @param <R> query result type
 */
public interface EntityQueryConditionGroupLogicExpression3<E1, E2, E3,
    C extends EntityQueryConditionGroupExpression3<E1, E2, E3, C, L, S, S2, R>,
    L extends EntityQueryConditionGroupLogicExpression3<E1, E2, E3, C, L, S, S2, R>,
    S extends EntityQuerySortExpression3<E1, E2, E3, R>, S2 extends EntityQuerySortedExpression3<E1, E2, E3, R>, R>
    extends EntityConditionGroupLogicExpression3<E1, E2, E3, C, L>, EntityQueryable3<E1, E2, E3, S, S2>,
    QueryLimitSetter<QueryLimitExecutor<R>>, QueryLimitExecutor<R>, QueryCountExecutor {

}
