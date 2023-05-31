
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsGroupExpression4;

/**
 * The Interface EntityConditionGroupExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionGroupExpression4<E, E2, E3, E4,
        C extends EntityConditionGroupExpression4<E, E2, E3, E4, C, L>,
        L extends EntityConditionGroupLogicExpression4<E, E2, E3, E4, C, L>>
        extends EntityConditionsGroupExpression4<E, E2, E3, E4, C, L>, ConditionGroupConfig<C> {
}
