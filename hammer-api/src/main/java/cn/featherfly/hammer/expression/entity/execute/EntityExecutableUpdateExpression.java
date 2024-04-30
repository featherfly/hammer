
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 * @param <E> the update type
 * @param <U> update expressoin
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface EntityExecutableUpdateExpression<E, U extends EntityExecutableUpdateExpression<E, U, C, L>,
    C extends EntityExecutableConditionGroupExpression<E, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression<E, C, L, UpdateConditionConfig>>
    extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression<E, U, C, L>,
    EntityExecutableUpdateSetExpression<E, U, C, L> {

}
