
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityExecutableUpdateExpression<E, U extends EntityExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L, UpdateConditionConfig>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L, UpdateConditionConfig>>
        extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        EntityUpdateSetExecutableExpression<E, U, C, L> {

}
