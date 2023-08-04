
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.EntityWhereExpression6;

/**
 * The Interface EntityQueryWhereExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryWhereExpression6<E, E2, E3, E4, E5, E6,
        C extends EntityQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L, S, R>,
        S extends EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>, R>
        extends EntityWhereExpression6<E, E2, E3, E4, E5, E6, C, L> {
}
