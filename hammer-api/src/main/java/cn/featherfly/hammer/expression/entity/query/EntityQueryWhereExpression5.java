
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Where;

/**
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityQueryWhereExpression5<E, E2, E3, E4, E5,
        C extends EntityQueryConditionGroupExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        S extends EntityQuerySortExpression5<E, E2, E3, E4, E5, R>, R> extends Where<C, L> {
}
