
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * repository query conditions group logic3.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic3F extends
    RepositoryQueryConditionsGroupLogicExpression3<RepositoryQueryConditionsGroup3F,
        RepositoryQueryConditionsGroupLogic3F,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3F, QueryLimitExecutor>,
        RepositoryQuerySortedExpression3F, QueryLimitExecutor>,
    RepositoryQuerySortedExpression3F {
}
