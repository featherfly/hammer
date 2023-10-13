
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;

/**
 * executable condition group logic expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupLogicExpression<C extends ExecutableConditionGroupExpression<C, L, C2>,
        L extends ExecutableConditionGroupLogicExpression<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
        extends Executor, ConditionGroupLogicExpression<C, L> {

}
