
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsGroupExpression2;

/**
 * The Interface EntityConditionGroupExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionGroupExpression2<E, E2, C extends EntityConditionGroupExpression2<E, E2, C, L>,
        L extends EntityConditionGroupLogicExpression2<E, E2, C, L>>
        extends EntityConditionsGroupExpression2<E, E2, C, L>, ConditionGroupConfig<C> {
}
