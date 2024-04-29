
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * EntityExecutableUpdateExpression4.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <U>  update expressoin
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityExecutableUpdateExpression4<E, J1, J2, J3,
    U extends EntityExecutableUpdateExpression4<E, J1, J2, J3, U, C, L>,
    C extends EntityExecutableConditionGroupExpression4<E, J1, J2, J3, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression4<E, J1, J2, J3, C, L, UpdateConditionConfig>>
    extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression4<E, J1, J2, J3, U, C, L>,
    EntityUpdateSetExecutableExpression4<E, J1, J2, J3, U, C, L> {

}
