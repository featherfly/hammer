
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupExpression5;

/**
 * executable condition group,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroup5<C extends ExecutableConditionConfig<C>>
    extends RepositoryExecutableConditionsGroupExpression5<RepositoryExecutableConditionsGroup5<C>,
        RepositoryExecutableConditionsGroupLogic5<C>, C> {
}
