
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query conditions group2.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup2FF extends
    RepositoryQueryConditionsGroupExpression2<RepositoryQueryConditionsGroup2FF, RepositoryQueryConditionsGroupLogic2FF,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2FF, QueryLimitExecutor2>,
        RepositoryQuerySortedExpression2FF, QueryLimitExecutor2> {

}
