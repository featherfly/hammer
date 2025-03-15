
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query conditions group logic2.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic2F extends
    RepositoryQueryConditionsGroupLogicExpression2<RepositoryQueryConditionsGroup2F,
        RepositoryQueryConditionsGroupLogic2F,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2F, QueryLimitExecutor>,
        RepositoryQuerySortedExpression2F, QueryLimitExecutor>,
    RepositoryQuerySortedExpression2F {
}
