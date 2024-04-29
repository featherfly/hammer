
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryFieldUpdateExpression;

/**
 * property update.
 *
 * @author zhongj
 */
public interface FieldUpdate extends RepositoryFieldUpdateExpression<ExecutableUpdate,
    RepositoryExecutableConditionsGroup<UpdateConditionConfig>, RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> {

}
