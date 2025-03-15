
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityWhereExpression2;

/**
 * The Interface EntityQueryWhereExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 * @param <S2> the generic type
 * @param <R> query result type
 */
public interface EntityQueryWhereExpression2<E1, E2,
    C extends EntityQueryConditionGroupExpression2<E1, E2, C, L, S, S2, R>,
    L extends EntityQueryConditionGroupLogicExpression2<E1, E2, C, L, S, S2, R>,
    S extends EntityQuerySortExpression2<E1, E2, R>, S2 extends EntityQuerySortedExpression2<E1, E2, R>, R>
    extends EntityWhereExpression2<E1, E2, C, L> {

}
