
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.api.Where;

/**
 * The Interface EntityWhereExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityWhereExpression4<E, E2, E3, E4, C extends EntityConditionGroupExpression4<E, E2, E3, E4, C, L>,
        L extends EntityConditionGroupLogicExpression4<E, E2, E3, E4, C, L>> extends Where<C, L> {
}
