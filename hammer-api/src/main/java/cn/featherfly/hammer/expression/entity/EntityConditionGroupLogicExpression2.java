
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.entity.condition.EntityLogicGroupExpression2;

/**
 * The Interface EntityConditionGroupLogicExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionGroupLogicExpression2<E, E2, C extends EntityConditionGroupExpression2<E, E2, C, L>,
        L extends EntityConditionGroupLogicExpression2<E, E2, C, L>> extends EntityLogicGroupExpression2<E, E2, C, L> {
}
