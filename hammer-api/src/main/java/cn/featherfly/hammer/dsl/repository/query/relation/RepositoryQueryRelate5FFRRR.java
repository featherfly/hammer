
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FFRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FFRRR
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FFRRF>,
        RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFF, RepositoryQueryConditionsGroupLogic6FFF,
                RepositoryQuerySortExpression6<QueryLimitExecutor3>, QueryLimitExecutor3>,
        QueryLimitExecutor3 {

}
