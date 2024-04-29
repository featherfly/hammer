
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;

/**
 * Update.
 *
 * @author zhongj
 */
public interface Update extends FieldUpdate, RepositoryUpdateExpression<ExecutableUpdate,
    RepositoryExecutableConditionsGroup<UpdateConditionConfig>, RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> {

}
