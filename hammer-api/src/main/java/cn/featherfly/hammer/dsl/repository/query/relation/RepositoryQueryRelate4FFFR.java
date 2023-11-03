
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4FFFR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4FFFR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4FFFF>,
        RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FFFF, RepositoryQueryConditionsGroupLogic5FFFF,
                RepositoryQuerySortExpression5<QueryLimitExecutor4>, QueryLimitExecutor4>,
        QueryLimitExecutor4,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression5<RepositoryQueryRelate5FFFRR, RepositoryQueryRelatedFetched5FFFRF>,
                RepositoryQueryRelate5FFFRR, RepositoryQueryRelatedFetched5FFFRF> {
}
