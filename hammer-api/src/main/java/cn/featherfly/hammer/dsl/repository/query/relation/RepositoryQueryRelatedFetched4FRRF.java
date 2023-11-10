
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelatedFetched4FRRF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched4FRRF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4FRRF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FFF, RepositoryQueryConditionsGroupLogic5FFF,
        RepositoryQuerySortExpression5<QueryLimitExecutor3>, QueryLimitExecutor3>,
    QueryLimitExecutor3,
    RepositoryQueryRelate<
        RepositoryQueryOnExpression5<RepositoryQueryRelate5FRRFR, RepositoryQueryRelatedFetched5FRRFF>,
        RepositoryQueryRelate5FRRFR, RepositoryQueryRelatedFetched5FRRFF> {

}
