
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression4;

/**
 * repository delete 4.
 *
 * @author zhongj
 */
public interface RepositoryDelete4 extends
    RepositoryDeleteExpression4<RepositoryExecutableConditionsGroup4<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic4<DeleteConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression4<RepositoryDelete5>, RepositoryDelete5> {

}
