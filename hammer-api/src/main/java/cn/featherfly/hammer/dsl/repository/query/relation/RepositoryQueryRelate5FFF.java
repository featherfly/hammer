
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.QueryMapperSetter4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * The Interface RepositoryQueryRelate5FFFRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate5FFF extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched5FFFF>,
    RepositoryQueryExpression6<RepositoryQueryConditionsGroup6FFFF, RepositoryQueryConditionsGroupLogic6FFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFF, LimitAwareQuery4<Map<String, Serializable>>>,
    QueryMapperSetter4
//, QueryLimitExecutor4
{

}
