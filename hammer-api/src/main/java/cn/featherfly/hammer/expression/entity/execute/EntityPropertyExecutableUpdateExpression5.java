
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression5;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityPropertyExecutableUpdateExpression5.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 * @param <U>  property update expressoin
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityPropertyExecutableUpdateExpression5<E, J1, J2, J3, J4,
    U extends EntityPropertyExecutableUpdateExpression5<E, J1, J2, J3, J4, U, C, L>,
    C extends EntityExecutableConditionGroupExpression5<E, J1, J2, J3, J4, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression5<E, J1, J2, J3, J4, C, L, UpdateConditionConfig>>
    extends EntityWhereExpression5<E, J1, J2, J3, J4, C, L>, EntityPropertyUpdateExpression<E, U, C, L>, Executor {
}
