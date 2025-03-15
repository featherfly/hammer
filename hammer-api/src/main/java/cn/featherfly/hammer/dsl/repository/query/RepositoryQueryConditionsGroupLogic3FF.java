
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * repository query conditions group logic3.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic3FF extends
    RepositoryQueryConditionsGroupLogicExpression3<RepositoryQueryConditionsGroup3FF,
        RepositoryQueryConditionsGroupLogic3FF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FF, QueryLimitExecutor2>,
        RepositoryQuerySortedExpression3FF, QueryLimitExecutor2>,
    RepositoryQuerySortedExpression3FF, QueryLimitExecutor2 {
}
