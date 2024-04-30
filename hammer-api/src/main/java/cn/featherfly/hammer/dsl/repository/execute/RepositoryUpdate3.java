
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;

/**
 * repository update3.
 *
 * @author zhongj
 */
public interface RepositoryUpdate3 extends
    RepositoryUpdateExpression<RepositoryExecutableUpdate3, RepositoryExecutableConditionsGroup3<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression3<RepositoryUpdate4>, RepositoryUpdate4> {

}
