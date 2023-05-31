
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.type.EntityLogicGroupExpression3;

/**
 * The Interface EntityConditionGroupLogicExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionGroupLogicExpression3<E, E2, E3,
        C extends EntityConditionGroupExpression3<E, E2, E3, C, L>,
        L extends EntityConditionGroupLogicExpression3<E, E2, E3, C, L>>
        extends EntityLogicGroupExpression3<E, E2, E3, C, L> {

}
