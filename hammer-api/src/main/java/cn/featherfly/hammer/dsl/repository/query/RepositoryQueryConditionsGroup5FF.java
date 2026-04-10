
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group5.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup5FF extends
    RepositoryQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5FF, RepositoryQueryConditionsGroupLogic5FF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>> {

}
