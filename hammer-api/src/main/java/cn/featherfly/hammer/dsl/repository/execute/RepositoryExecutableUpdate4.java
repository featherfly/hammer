
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableUpdateExpression4;

/**
 * repository executable update4.
 *
 * @author zhongj
 */
public interface RepositoryExecutableUpdate4 extends
    RepositoryExecutableUpdateExpression4<RepositoryExecutableUpdate4,
        RepositoryExecutableConditionsGroup4<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig>> {
}
