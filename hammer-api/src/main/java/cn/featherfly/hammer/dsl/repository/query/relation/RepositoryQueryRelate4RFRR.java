
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4RFRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4RFRR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4RFRF>,
        RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FF, RepositoryQueryConditionsGroupLogic5FF,
                RepositoryQuerySortExpression5<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression5<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF>,
                RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> {

}
