
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FRFRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FRFRR
        extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FRFRF>,
        RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFF, RepositoryQueryConditionsGroupLogic6FFF,
                RepositoryQuerySortExpression6<QueryLimitExecutor3>, QueryLimitExecutor3>,
        QueryLimitExecutor3 {

}
