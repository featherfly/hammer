
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelatedFetched4FFFF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched4FFFF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4FFFF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FFFFF, RepositoryQueryConditionsGroupLogic5FFFFF,
        RepositoryQuerySortExpression5<QueryLimitExecutor5>, QueryLimitExecutor5>,
    QueryLimitExecutor5,
    RepositoryQueryRelate<
        RepositoryQueryOnExpression5<RepositoryQueryRelate5FFFFR, RepositoryQueryRelatedFetched5FFFFF>,
        RepositoryQueryRelate5FFFFR, RepositoryQueryRelatedFetched5FFFFF> {

}
