
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group logic4.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic4FF extends
    RepositoryQueryConditionsGroupLogicExpression4<RepositoryQueryConditionsGroup4FF,
        RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FF, QueryLimitExecutor2>,
        RepositoryQuerySortedExpression4FF, QueryLimitExecutor2>,
    RepositoryQuerySortedExpression4FF, QueryLimitExecutor2 {
}
