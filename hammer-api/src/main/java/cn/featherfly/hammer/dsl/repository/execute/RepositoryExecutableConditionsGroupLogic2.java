
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupLogicExpression2;

/**
 * executable condition group logic,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroupLogic2<C extends ExecutableConditionConfig<C>>
    extends Executor, RepositoryExecutableConditionsGroupLogicExpression2<RepositoryExecutableConditionsGroup2<C>,
        RepositoryExecutableConditionsGroupLogic2<C>, C> {

}
