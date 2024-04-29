
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic expression,.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> executable condition config
 */
public interface EntityExecutableConditionGroupLogicExpression5<E1, E2, E3, E4, E5,
    C extends EntityExecutableConditionGroupExpression5<E1, E2, E3, E4, E5, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends Executor, EntityConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L> {

}
