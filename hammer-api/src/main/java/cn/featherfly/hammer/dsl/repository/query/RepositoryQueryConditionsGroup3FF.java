
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * repository query conditions group3.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup3FF extends
    RepositoryQueryConditionsGroupExpression3<RepositoryQueryConditionsGroup3FF, RepositoryQueryConditionsGroupLogic3FF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>> {

}
