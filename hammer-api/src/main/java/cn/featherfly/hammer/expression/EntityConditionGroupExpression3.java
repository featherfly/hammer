
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsGroupExpression3;

/**
 * The Interface EntityConditionGroupExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityConditionGroupExpression3<E, E2, E3, C extends EntityConditionGroupExpression3<E, E2, E3, C, L>,
        L extends EntityConditionGroupLogicExpression3<E, E2, E3, C, L>>
        extends EntityConditionsGroupExpression3<E, E2, E3, C, L>, ConditionGroupConfig<C> {
}
