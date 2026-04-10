
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group5.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup5FFFFF extends
    RepositoryQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5FFFFF,
        RepositoryQueryConditionsGroupLogic5FFFFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFFF,
            LimitAwareQuery5<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFFFF, LimitAwareQuery5<Map<String, Serializable>>> {

}
