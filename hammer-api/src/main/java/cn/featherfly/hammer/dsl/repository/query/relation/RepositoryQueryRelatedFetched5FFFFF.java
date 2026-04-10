
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery6;
import cn.featherfly.data.query.QueryMapperSetter6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelatedFetched5FFFFF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched5FFFFF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FFFFF>,
    RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFFFFF, RepositoryQueryConditionsGroupLogic6FFFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFFF,
            LimitAwareQuery6<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFFF, LimitAwareQuery6<Map<String, Serializable>>>,
    QueryMapperSetter6
//,QueryLimitExecutor6
{

}
