
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * The Interface EntityQueryWhereExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryWhereExpression<E, C extends EntityQueryConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        extends EntityWhereExpression<E, C, L> {

}
