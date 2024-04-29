
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupLogicExpression4;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogic4<C extends ExecutableConditionConfig<C>>
    extends Executor, RepositoryExecutableConditionsGroupLogicExpression4<RepositoryExecutableConditionsGroup4<C>,
        RepositoryExecutableConditionsGroupLogic4<C>, C> {

}
