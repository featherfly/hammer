
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression3;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityPropertyExecutableUpdateExpression3.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <U>  property update expressoin
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityPropertyExecutableUpdateExpression3<E, J1, J2,
    U extends EntityPropertyExecutableUpdateExpression3<E, J1, J2, U, C, L>,
    C extends EntityExecutableConditionGroupExpression3<E, J1, J2, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression3<E, J1, J2, C, L, UpdateConditionConfig>>
    extends EntityWhereExpression3<E, J1, J2, C, L>, EntityPropertyUpdateExpression<E, U, C, L>, Executor {
}
