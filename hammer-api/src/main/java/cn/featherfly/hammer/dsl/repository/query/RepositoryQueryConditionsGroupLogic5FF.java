
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group logic5.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic5FF extends
    RepositoryQueryConditionsGroupLogicExpression5<RepositoryQueryConditionsGroup5FF,
        RepositoryQueryConditionsGroupLogic5FF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression5FF, QueryMapperSetter2 {
}
