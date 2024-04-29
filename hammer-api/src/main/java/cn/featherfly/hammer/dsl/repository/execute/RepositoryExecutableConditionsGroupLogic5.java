
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupLogicExpression5;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogic5<C extends ExecutableConditionConfig<C>>
    extends Executor, RepositoryExecutableConditionsGroupLogicExpression5<RepositoryExecutableConditionsGroup5<C>,
        RepositoryExecutableConditionsGroupLogic5<C>, C> {

}
