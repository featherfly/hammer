
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression2;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityPropertyExecutableUpdateExpression.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <U>  property update expressoin
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityPropertyExecutableUpdateExpression2<E, J1,
    U extends EntityPropertyExecutableUpdateExpression2<E, J1, U, C, L>,
    C extends EntityExecutableConditionGroupExpression2<E, J1, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression2<E, J1, C, L, UpdateConditionConfig>>
    extends EntityWhereExpression2<E, J1, C, L>, EntityPropertyUpdateExpression<E, U, C, L>, Executor {
}
