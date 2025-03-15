
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query conditions group2.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup2F extends
    RepositoryQueryConditionsGroupExpression2<RepositoryQueryConditionsGroup2F, RepositoryQueryConditionsGroupLogic2F,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2F, QueryLimitExecutor>,
        RepositoryQuerySortedExpression2F, QueryLimitExecutor> {

}
