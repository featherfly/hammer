
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * The Interface EntityQueryRelate1R.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate1R extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched1F>,
        RepositoryQuery2<RepositoryQueryConditionsGroup2F, RepositoryQueryConditionsGroupLogic2F,
                RepositoryQuerySortExpression2<QueryLimitExecutor>, QueryLimitExecutor>,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression2<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF>,
                RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> {

}
