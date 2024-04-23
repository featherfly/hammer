
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression4;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityUpdateSetExecutableExpression4.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityUpdateSetExecutableExpression4<E, J1, J2, J3,
    U extends EntityUpdateSetExecutableExpression4<E, J1, J2, J3, U, C, L>,
    C extends EntityExecutableConditionGroupExpression4<E, J1, J2, J3, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression4<E, J1, J2, J3, C, L, UpdateConditionConfig>>
    extends EntityWhereExpression4<E, J1, J2, J3, C, L>, EntityUpdateSetExpression<E, U, C, L>, Executor {
}