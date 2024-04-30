
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.repository.execute.RepositoryExecutableUpdateExpression2;

/**
 * repository executable update2.
 *
 * @author zhongj
 */
public interface RepositoryExecutableUpdate2 extends
    RepositoryExecutableUpdateExpression2<RepositoryExecutableUpdate2,
        RepositoryExecutableConditionsGroup2<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig>> {
}
