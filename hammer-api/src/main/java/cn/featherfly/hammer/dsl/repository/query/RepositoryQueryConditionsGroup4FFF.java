
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group4.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup4FFF extends
    RepositoryQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4FFF,
        RepositoryQueryConditionsGroupLogic4FFF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FFF, LimitAwareQuery3<Map<String, Serializable>>> {

}
