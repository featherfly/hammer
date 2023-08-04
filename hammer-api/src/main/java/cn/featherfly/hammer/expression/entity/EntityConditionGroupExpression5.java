
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression5;

/**
 * The Interface EntityConditionGroupExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionGroupExpression5<E, E2, E3, E4, E5,
        C extends EntityConditionGroupExpression5<E, E2, E3, E4, E5, C, L>,
        L extends EntityConditionGroupLogicExpression5<E, E2, E3, E4, E5, C, L>>
        extends EntityConditionsGroupExpression5<E, E2, E3, E4, E5, C, L>, ConditionGroupConfig<C> {
}
