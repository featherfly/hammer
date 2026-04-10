
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query conditions group logic2.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic2FF extends
    RepositoryQueryConditionsGroupLogicExpression2<RepositoryQueryConditionsGroup2FF,
        RepositoryQueryConditionsGroupLogic2FF,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression2FF, LimitAwareQuery2<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression2FF, QueryMapperSetter2 {
}
