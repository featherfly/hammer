
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression1;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;

/**
 * Update.
 *
 * @author zhongj
 */
public interface RepositoryUpdate extends
    RepositoryUpdateExpression<RepositoryExecutableUpdate, RepositoryExecutableConditionsGroup<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression1<RepositoryUpdate2>, RepositoryUpdate2> {

}
