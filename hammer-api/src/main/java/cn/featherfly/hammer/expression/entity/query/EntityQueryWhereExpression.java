
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityWhereExpression;

/**
 * The Interface EntityQueryWhereExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <S>  sort expression
 */
public interface EntityQueryWhereExpression<E1, C extends EntityQueryConditionGroupExpression<E1, C, L, S>,
    L extends EntityQueryConditionGroupLogicExpression<E1, C, L, S>, S extends EntityQuerySortExpression<E1>>
    extends EntityWhereExpression<E1, C, L> {

}
