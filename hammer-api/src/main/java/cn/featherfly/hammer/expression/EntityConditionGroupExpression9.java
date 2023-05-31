
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsGroupExpression9;

/**
 * The Interface EntityConditionGroupExpression9.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <E7> the generic type
 * @param <E8> the generic type
 * @param <E9> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionGroupExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9,
        C extends EntityConditionGroupExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, C, L>,
        L extends EntityConditionGroupLogicExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, C, L>>
        extends EntityConditionsGroupExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, C, L>, ConditionGroupConfig<C> {
}
