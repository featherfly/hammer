
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group logic4.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic4F extends
    RepositoryQueryConditionsGroupLogicExpression4<RepositoryQueryConditionsGroup4F,
        RepositoryQueryConditionsGroupLogic4F,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4F, QueryLimitExecutor>,
        RepositoryQuerySortedExpression4F, QueryLimitExecutor>,
    RepositoryQuerySortedExpression4F {
}
