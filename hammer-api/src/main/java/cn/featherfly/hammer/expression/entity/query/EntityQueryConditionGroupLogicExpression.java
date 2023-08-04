
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryConditionGroupLogicExpression<E, C extends EntityQueryConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        extends EntityConditionGroupLogicExpression<E, C, L>, Queryable<S>, EntityQueryConditionLimit<E>,
        EntityQueryLimitExecutor<E>, QueryCountExecutor {

}
