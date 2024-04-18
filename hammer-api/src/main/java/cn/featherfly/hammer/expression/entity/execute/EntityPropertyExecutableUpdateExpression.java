
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityPropertyExecutableUpdateExpression.
 *
 * @author zhongj
 * @param <E> the update type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyExecutableUpdateExpression<E,
    U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
    C extends EntityExecutableConditionGroupExpression<E, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression<E, C, L, UpdateConditionConfig>>
    extends EntityWhereExpression<E, C, L>, EntityPropertyUpdateExpression<E, U, C, L>, Executor {

}
