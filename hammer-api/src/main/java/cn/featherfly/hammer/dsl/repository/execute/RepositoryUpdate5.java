
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;

/**
 * repository update5.
 *
 * @author zhongj
 */
public interface RepositoryUpdate5 extends
    RepositoryUpdateExpression<RepositoryExecutableUpdate5, RepositoryExecutableConditionsGroup5<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression5<RepositoryUpdate6>, RepositoryUpdate6> {

}
