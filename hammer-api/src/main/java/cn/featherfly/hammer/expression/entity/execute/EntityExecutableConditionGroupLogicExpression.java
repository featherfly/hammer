
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic expression,.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 */
public interface EntityExecutableConditionGroupLogicExpression<E,
    C extends EntityExecutableConditionGroupExpression<E, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression<E, C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
    extends Executor, EntityConditionGroupLogicExpression<E, C, L> {

}
