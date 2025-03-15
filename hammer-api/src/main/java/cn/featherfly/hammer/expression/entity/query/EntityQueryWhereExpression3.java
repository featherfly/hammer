
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityWhereExpression3;

/**
 * The Interface EntityQueryWhereExpression3.
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
public interface EntityQueryWhereExpression3<E1, E2, E3,
    C extends EntityQueryConditionGroupExpression3<E1, E2, E3, C, L, S, S2, R>,
    L extends EntityQueryConditionGroupLogicExpression3<E1, E2, E3, C, L, S, S2, R>,
    S extends EntityQuerySortExpression3<E1, E2, E3, R>, S2 extends EntityQuerySortedExpression3<E1, E2, E3, R>, R>
    extends EntityWhereExpression3<E1, E2, E3, C, L> {
}
