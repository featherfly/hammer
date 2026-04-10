
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.data.query.QueryMapperSetter5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FFFFR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FFFF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FFFFF>,
    RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFF,
            LimitAwareQuery5<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFF, LimitAwareQuery5<Map<String, Serializable>>>,
    QueryMapperSetter5
//, QueryLimitExecutor5
{

}
