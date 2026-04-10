
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.data.query.QueryMapperSetter5;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group logic6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic6FFFFF extends
    RepositoryQueryConditionsGroupLogicExpression6<RepositoryQueryConditionsGroup6FFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFF,
            LimitAwareQuery5<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFF, LimitAwareQuery5<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression6FFFFF, QueryMapperSetter5 {
}
