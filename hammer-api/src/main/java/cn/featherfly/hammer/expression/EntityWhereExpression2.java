
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.api.Where;

/**
 * The Interface EntityWhereExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityWhereExpression2<E, E2, C extends EntityConditionGroupExpression2<E, E2, C, L>,
        L extends EntityConditionGroupLogicExpression2<E, E2, C, L>> extends Where<C, L> {

}
