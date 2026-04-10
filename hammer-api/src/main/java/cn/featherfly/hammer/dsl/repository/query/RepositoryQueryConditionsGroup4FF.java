
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group4.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup4FF extends
    RepositoryQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>> {

}
