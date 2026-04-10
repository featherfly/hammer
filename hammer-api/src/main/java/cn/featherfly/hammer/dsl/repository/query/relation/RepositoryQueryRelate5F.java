
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FRRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5F extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FF>,
    RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FF, RepositoryQueryConditionsGroupLogic6FF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FF, LimitAwareQuery2<Map<String, Serializable>>>,
    QueryMapperSetter2
//,QueryLimitExecutor2
{

}
