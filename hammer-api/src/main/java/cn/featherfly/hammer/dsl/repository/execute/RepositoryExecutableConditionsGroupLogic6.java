
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupLogicExpression6;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogic6<C extends ExecutableConditionConfig<C>>
    extends Executor, RepositoryExecutableConditionsGroupLogicExpression6<RepositoryExecutableConditionsGroup6<C>,
        RepositoryExecutableConditionsGroupLogic6<C>, C> {

}
