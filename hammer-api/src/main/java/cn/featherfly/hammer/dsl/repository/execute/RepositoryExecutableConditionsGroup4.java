
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupExpression4;

/**
 * executable condition group,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroup4<C extends ExecutableConditionConfig<C>>
    extends RepositoryExecutableConditionsGroupExpression4<RepositoryExecutableConditionsGroup4<C>,
        RepositoryExecutableConditionsGroupLogic4<C>, C> {
}
