
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;

/**
 * The Interface EntityConditionGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionGroupExpression<E, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityConditionsGroupExpression<E, C, L>, ConditionGroupConfig<C> {
}