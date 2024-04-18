
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic expression,.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 */
public interface EntityExecutableConditionGroupLogicExpression2<E1, E2,
    C extends EntityExecutableConditionGroupExpression2<E1, E2, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression2<E1, E2, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>> extends Executor, EntityConditionGroupLogicExpression2<E1, E2, C, L> {

}
