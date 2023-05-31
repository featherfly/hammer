
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsGroupExpression6;

/**
 * The Interface EntityConditionGroupExpression6.
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
 */
public interface EntityConditionGroupExpression6<E, E2, E3, E4, E5, E6,
        C extends EntityConditionGroupExpression6<E, E2, E3, E4, E5, E6, C, L>,
        L extends EntityConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L>>
        extends EntityConditionsGroupExpression6<E, E2, E3, E4, E5, E6, C, L>, ConditionGroupConfig<C> {
}
