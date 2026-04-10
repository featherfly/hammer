
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.QueryMapperSetter4;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group logic4.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic4FFFF extends
    RepositoryQueryConditionsGroupLogicExpression4<RepositoryQueryConditionsGroup4FFFF,
        RepositoryQueryConditionsGroupLogic4FFFF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FFFF, LimitAwareQuery4<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression4FFFF, QueryMapperSetter4 {

}
