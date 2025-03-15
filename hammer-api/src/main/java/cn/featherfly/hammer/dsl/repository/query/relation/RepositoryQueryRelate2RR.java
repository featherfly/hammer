
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3F;
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
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3F, QueryLimitExecutor>,
        RepositoryQuerySortedExpression3F, QueryLimitExecutor>,
    RepositoryJoin<RepositoryOnExpression3<RepositoryQueryRelate3RRR>, RepositoryQueryRelate3RRR> {

}
