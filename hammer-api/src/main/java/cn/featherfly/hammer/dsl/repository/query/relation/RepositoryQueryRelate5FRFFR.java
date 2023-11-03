
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FRFFR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FRFFR
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FRFFF>,
        RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFFF, RepositoryQueryConditionsGroupLogic6FFFF,
                RepositoryQuerySortExpression6<QueryLimitExecutor4>, QueryLimitExecutor4>,
        QueryLimitExecutor4 {

}
