
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupLogicExpression;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogic<C extends ExecutableConditionConfig<C>>
    extends Executor, RepositoryExecutableConditionsGroupLogicExpression<RepositoryExecutableConditionsGroup<C>,
        RepositoryExecutableConditionsGroupLogic<C>, C> {

}
