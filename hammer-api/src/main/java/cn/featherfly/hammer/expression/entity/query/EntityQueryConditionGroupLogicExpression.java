
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 */
public interface EntityQueryConditionGroupLogicExpression<E1,
    C extends EntityQueryConditionGroupExpression<E1, C, L, S>,
    L extends EntityQueryConditionGroupLogicExpression<E1, C, L, S>, S extends EntityQuerySortExpression<E1>>
    extends EntityConditionGroupLogicExpression<E1, C, L>, Queryable<S>, QueryLimitSetter<QueryLimitExecutor<E1>>,
    QueryLimitExecutor<E1>, QueryCountExecutor {

}
