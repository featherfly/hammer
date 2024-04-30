
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;

/**
 * repository update2.
 *
 * @author zhongj
 */
public interface RepositoryUpdate2 extends
    RepositoryUpdateExpression<RepositoryExecutableUpdate2, RepositoryExecutableConditionsGroup2<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression2<RepositoryUpdate3>, RepositoryUpdate3> {

}
