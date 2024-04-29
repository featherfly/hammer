
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression3;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> executable condition config
 */
public interface EntityExecutableConditionGroupExpression3<E1, E2, E3,
    C extends EntityExecutableConditionGroupExpression3<E1, E2, E3, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression3<E1, E2, E3, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends EntityConditionGroupExpression3<E1, E2, E3, C, L>, ConditionConfigureExpression<C, C2> {
}
