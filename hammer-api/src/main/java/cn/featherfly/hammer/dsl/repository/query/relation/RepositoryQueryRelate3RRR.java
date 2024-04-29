
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelate3RRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate3RRR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3RRF>,
    RepositoryQueryExpression4<RepositoryQueryConditionsGroup4F, RepositoryQueryConditionsGroupLogic4F,
        RepositoryQuerySortExpression4<QueryLimitExecutor>, QueryLimitExecutor>,
    RepositoryJoin<RepositoryOnExpression4<RepositoryQueryRelate4RRRR>,
        RepositoryQueryRelate4RRRR> {

}
