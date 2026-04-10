
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery6;
import cn.featherfly.data.query.QueryMapperSetter6;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group logic6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic6FFFFFF extends
    RepositoryQueryConditionsGroupLogicExpression6<RepositoryQueryConditionsGroup6FFFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFFF,
            LimitAwareQuery6<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFFF, LimitAwareQuery6<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression6FFFFFF, QueryMapperSetter6 {
}
