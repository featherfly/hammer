
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableConditionsGroupExpression3;

/**
 * executable condition group,.
 *
 * @author zhongj
 * @param <C> executable condition config
 */
public interface RepositoryExecutableConditionsGroup3<C extends ExecutableConditionConfig<C>>
    extends RepositoryExecutableConditionsGroupExpression3<RepositoryExecutableConditionsGroup3<C>,
        RepositoryExecutableConditionsGroupLogic3<C>, C> {
}
