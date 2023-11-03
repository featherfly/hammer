
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelate2RR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate2FR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched2FF>,
        RepositoryQueryExpression3<RepositoryQueryConditionsGroup3FF, RepositoryQueryConditionsGroupLogic3FF,
                RepositoryQuerySortExpression3<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression3<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF>,
                RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> {

}
