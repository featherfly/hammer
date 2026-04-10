
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group logic5.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic5FFF extends
    RepositoryQueryConditionsGroupLogicExpression5<RepositoryQueryConditionsGroup5FFF,
        RepositoryQueryConditionsGroupLogic5FFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFF, LimitAwareQuery3<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression5FFF, QueryMapperSetter3 {
}
