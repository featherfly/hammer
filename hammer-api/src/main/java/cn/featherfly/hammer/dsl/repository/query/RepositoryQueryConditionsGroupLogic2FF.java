
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query conditions group logic2.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic2FF extends
        RepositoryQueryConditionsGroupLogicExpression2<RepositoryQueryConditionsGroup2FF,
                RepositoryQueryConditionsGroupLogic2FF, RepositoryQuerySortExpression2<QueryLimitExecutor2>,
                QueryLimitExecutor2>,
        QueryLimitExecutor2 {
}
