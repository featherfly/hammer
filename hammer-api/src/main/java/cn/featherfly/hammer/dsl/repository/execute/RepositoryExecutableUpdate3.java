
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableUpdateExpression3;

/**
 * repository executable update3.
 *
 * @author zhongj
 */
public interface RepositoryExecutableUpdate3 extends
    RepositoryExecutableUpdateExpression3<RepositoryExecutableUpdate3,
        RepositoryExecutableConditionsGroup3<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig>> {
}
