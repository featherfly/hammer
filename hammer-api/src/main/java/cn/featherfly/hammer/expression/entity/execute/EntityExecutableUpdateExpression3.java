
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * EntityExecutableUpdateExpression3.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <U>  update expressoin
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityExecutableUpdateExpression3<E, J1, J2,
    U extends EntityExecutableUpdateExpression3<E, J1, J2, U, C, L>,
    C extends EntityExecutableConditionGroupExpression3<E, J1, J2, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression3<E, J1, J2, C, L, UpdateConditionConfig>>
    extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression3<E, J1, J2, U, C, L>,
    EntityExecutableUpdateSetExpression3<E, J1, J2, U, C, L> {

}
