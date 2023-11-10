
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FRRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FRRRR
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FRRRF>,
        RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FF, RepositoryQueryConditionsGroupLogic6FF,
                RepositoryQuerySortExpression6<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2 {

}
