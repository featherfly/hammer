
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FFRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FF extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FFF>,
    RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFF, RepositoryQueryConditionsGroupLogic6FFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFF, LimitAwareQuery3<Map<String, Serializable>>>,
    QueryMapperSetter3
//,  QueryLimitExecutor3
{

}
