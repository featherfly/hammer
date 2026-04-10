
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group logic6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic6FFF extends
    RepositoryQueryConditionsGroupLogicExpression6<RepositoryQueryConditionsGroup6FFF,
        RepositoryQueryConditionsGroupLogic6FFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFF, LimitAwareQuery3<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression6FFF, QueryMapperSetter3 {
}
