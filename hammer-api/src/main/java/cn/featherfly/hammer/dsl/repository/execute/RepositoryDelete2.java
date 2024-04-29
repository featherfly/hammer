
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression2;

/**
 * repository delete 2.
 *
 * @author zhongj
 */
public interface RepositoryDelete2 extends
    RepositoryDeleteExpression2<RepositoryExecutableConditionsGroup2<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic2<DeleteConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression2<RepositoryDelete3>, RepositoryDelete3> {

}
