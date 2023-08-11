
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupLogic<E> extends Executor, EntityExecutableConditionGroupLogicExpression<
        E, EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>> {

}
