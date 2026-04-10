
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group5.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup5FFFF extends
    RepositoryQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5FFFF,
        RepositoryQueryConditionsGroupLogic5FFFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFFF, LimitAwareQuery4<Map<String, Serializable>>> {

}
