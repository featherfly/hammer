
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group5.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup5F extends
    RepositoryQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5F, RepositoryQueryConditionsGroupLogic5F,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5F, LimitAwareQuery1<Map<String, Serializable>>> {

}
