
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelate3FRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate3FRR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3FRF>,
    RepositoryQueryExpression4<RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<QueryLimitExecutor2>, QueryLimitExecutor2>,
    QueryLimitExecutor2,
    RepositoryJoin<RepositoryOnExpression4<RepositoryQueryRelate4FRRR>,
        RepositoryQueryRelate4FRRR> {
}
