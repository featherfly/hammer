
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * The Interface EntityConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryValueConditionGroupLogicExpression<E,
        C extends EntityQueryValueConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryValueConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        extends EntityQueryConditionGroupLogicExpression<E, C, L, S>, QueryValueExecutor {

}
