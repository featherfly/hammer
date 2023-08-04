
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityWhereExpression2;

/**
 * The Interface EntityQueryWhereExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryWhereExpression2<E, E2, C extends EntityQueryConditionGroupExpression2<E, E2, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression2<E, E2, C, L, S, R>,
        S extends EntityQuerySortExpression2<E, E2, R>, R> extends EntityWhereExpression2<E, E2, C, L> {

}
