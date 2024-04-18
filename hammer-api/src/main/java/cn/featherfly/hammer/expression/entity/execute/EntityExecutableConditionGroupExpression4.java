
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression4;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 */
public interface EntityExecutableConditionGroupExpression4<E1, E2, E3, E4,
    C extends EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends EntityConditionGroupExpression4<E1, E2, E3, E4, C, L>, ConditionConfigureExpression<C, C2> {
}
