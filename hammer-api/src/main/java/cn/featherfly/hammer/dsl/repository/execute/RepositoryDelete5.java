
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression5;

/**
 * repository delete 5.
 *
 * @author zhongj
 */
public interface RepositoryDelete5 extends
    RepositoryDeleteExpression5<RepositoryExecutableConditionsGroup5<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic5<DeleteConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression5<RepositoryDelete6>, RepositoryDelete6> {

}
