
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelate3RFR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate3RFR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3RFF>,
        RepositoryQueryExpression4<RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
                RepositoryQuerySortExpression4<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2,
        RepositoryQueryRelate<
                RepositoryQueryOnExpression4<RepositoryQueryRelate4RFRR, RepositoryQueryRelatedFetched4RFRF>,
                RepositoryQueryRelate4RFRR, RepositoryQueryRelatedFetched4RFRF> {

}
