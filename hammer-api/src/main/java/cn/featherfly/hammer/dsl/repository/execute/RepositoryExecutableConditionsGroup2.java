
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupExpression2;

/**
 * executable condition group,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroup2<C extends ExecutableConditionConfig<C>>
    extends RepositoryExecutableConditionsGroupExpression2<RepositoryExecutableConditionsGroup2<C>,
        RepositoryExecutableConditionsGroupLogic2<C>, C> {
}
