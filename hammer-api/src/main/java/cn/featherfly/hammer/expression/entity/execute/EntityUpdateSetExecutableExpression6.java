
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression6;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityUpdateSetExecutableExpression6.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 * @param <J5> the join type 5
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityUpdateSetExecutableExpression6<E, J1, J2, J3, J4, J5,
    U extends EntityUpdateSetExecutableExpression6<E, J1, J2, J3, J4, J5, U, C, L>,
    C extends EntityExecutableConditionGroupExpression6<E, J1, J2, J3, J4, J5, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression6<E, J1, J2, J3, J4, J5, C, L, UpdateConditionConfig>>
    extends EntityWhereExpression6<E, J1, J2, J3, J4, J5, C, L>, EntityUpdateSetExpression<E, U, C, L>, Executor {
}
