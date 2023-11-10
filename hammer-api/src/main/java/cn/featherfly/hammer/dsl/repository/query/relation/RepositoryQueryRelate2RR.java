
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelate2RR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate2RR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched2RF>,
        RepositoryQueryExpression3<RepositoryQueryConditionsGroup3F, RepositoryQueryConditionsGroupLogic3F,
                RepositoryQuerySortExpression3<QueryLimitExecutor>, QueryLimitExecutor>,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression3<RepositoryQueryRelate3RRR, RepositoryQueryRelatedFetched3RRF>,
                RepositoryQueryRelate3RRR, RepositoryQueryRelatedFetched3RRF> {

}
