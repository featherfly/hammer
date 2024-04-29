
package cn.featherfly.hammer.dsl.repository.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.expression.repository.execute.RepositoryDeleteExpression3;

/**
 * repository delete 3.
 *
 * @author zhongj
 */
public interface RepositoryDelete3 extends
    RepositoryDeleteExpression3<RepositoryExecutableConditionsGroup3<DeleteConditionConfig>,
        RepositoryExecutableConditionsGroupLogic3<DeleteConditionConfig>>,
    RepositoryJoin<RepositoryOnExpression3<RepositoryDelete4>, RepositoryDelete4> {

}
