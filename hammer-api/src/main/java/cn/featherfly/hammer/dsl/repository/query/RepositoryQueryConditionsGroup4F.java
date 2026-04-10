
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group4.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup4F extends
    RepositoryQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4F, RepositoryQueryConditionsGroupLogic4F,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>> {

}
