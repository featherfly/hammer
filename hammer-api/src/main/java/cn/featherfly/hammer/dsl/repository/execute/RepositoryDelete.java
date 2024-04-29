
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression1;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression;

/**
 * repository delete.
 *
 * @author zhongj
 */
public interface RepositoryDelete extends
    RepositoryDeleteExpression<RepositoryExecutableConditionsGroup<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic<DeleteConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression1<RepositoryDelete2>, RepositoryDelete2> {
}
