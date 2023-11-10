
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FFFFR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FFFFR
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FFFFF>,
        RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF,
                RepositoryQuerySortExpression6<QueryLimitExecutor5>, QueryLimitExecutor5>,
        QueryLimitExecutor5 {

}
