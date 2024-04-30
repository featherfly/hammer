
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableUpdateExpression;

/**
 * repository executable update.
 *
 * @author zhongj
 */
public interface RepositoryExecutableUpdate extends
    RepositoryExecutableUpdateExpression<RepositoryExecutableUpdate,
        RepositoryExecutableConditionsGroup<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> {

}
