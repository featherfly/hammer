
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelatedFetched4RRRF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched4RRRF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4RRRF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FF, RepositoryQueryConditionsGroupLogic5FF,
        RepositoryQuerySortExpression5<QueryLimitExecutor2>, QueryLimitExecutor2>,
    QueryLimitExecutor2,
    RepositoryQueryRelate<
        RepositoryQueryOnExpression5<RepositoryQueryRelate5RRRFR, RepositoryQueryRelatedFetched5RRRFF>,
        RepositoryQueryRelate5RRRFR, RepositoryQueryRelatedFetched5RRRFF> {

}
