
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableUpdateExpression;

/**
 * executable update.
 *
 * @author zhongj
 */
public interface ExecutableUpdate extends FieldExecutableUpdate, RepositoryExecutableUpdateExpression<ExecutableUpdate,
    RepositoryExecutableConditionsGroup<UpdateConditionConfig>, RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>> {
}
