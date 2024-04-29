
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupExpression6;

/**
 * executable condition group,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroup6<C extends ExecutableConditionConfig<C>>
    extends RepositoryExecutableConditionsGroupExpression6<RepositoryExecutableConditionsGroup6<C>,
        RepositoryExecutableConditionsGroupLogic6<C>, C> {
}
