
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * The Interface EntityQueryFetchedExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <Q> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryFetchedPropertyExpression<E, C extends EntityQueryValueConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryValueConditionGroupLogicExpression<E, C, L, S>,
        Q extends EntityQueryFetchedPropertyExpression<E, C, L, Q, S>, S extends EntityQuerySortExpression<E>>
        extends EntityQueryFetchExpression<E, C, L, Q, C, L, S>, QueryValueExecutor {

}
