
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;

/**
 * repository update4.
 *
 * @author zhongj
 */
public interface RepositoryUpdate4 extends
    RepositoryUpdateExpression<RepositoryExecutableUpdate4, RepositoryExecutableConditionsGroup4<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression4<RepositoryUpdate5>, RepositoryUpdate5> {

}
