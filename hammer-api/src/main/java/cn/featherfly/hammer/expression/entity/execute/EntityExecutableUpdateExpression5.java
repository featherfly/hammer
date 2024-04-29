
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * EntityExecutableUpdateExpression5.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 * @param <U>  update expressoin
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityExecutableUpdateExpression5<E, J1, J2, J3, J4,
    U extends EntityExecutableUpdateExpression5<E, J1, J2, J3, J4, U, C, L>,
    C extends EntityExecutableConditionGroupExpression5<E, J1, J2, J3, J4, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression5<E, J1, J2, J3, J4, C, L, UpdateConditionConfig>>
    extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression5<E, J1, J2, J3, J4, U, C, L>,
    EntityUpdateSetExecutableExpression5<E, J1, J2, J3, J4, U, C, L> {

}
