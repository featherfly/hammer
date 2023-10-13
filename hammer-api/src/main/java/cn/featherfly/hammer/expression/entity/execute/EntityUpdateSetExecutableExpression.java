
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityUpdateSetExecutableExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateSetExecutableExpression<E, U extends EntityUpdateSetExecutableExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L, UpdateConditionConfig>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L, UpdateConditionConfig>>
        extends EntityWhereExpression<E, C, L>, EntityUpdateSetExpression<E, U, C, L>, Executor {
}
