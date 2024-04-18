
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression3;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityUpdateSetExecutableExpression3.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityUpdateSetExecutableExpression3<E, J1, J2,
    U extends EntityUpdateSetExecutableExpression3<E, J1, J2, U, C, L>,
    C extends EntityExecutableConditionGroupExpression3<E, J1, J2, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression3<E, J1, J2, C, L, UpdateConditionConfig>>
    extends EntityWhereExpression3<E, J1, J2, C, L>, EntityUpdateSetExpression<E, U, C, L>, Executor {
}
