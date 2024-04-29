
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupExpression;

/**
 * executable condition group,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroup<C extends ExecutableConditionConfig<C>>
    extends RepositoryExecutableConditionsGroupExpression<RepositoryExecutableConditionsGroup<C>,
        RepositoryExecutableConditionsGroupLogic<C>, C> {
}
