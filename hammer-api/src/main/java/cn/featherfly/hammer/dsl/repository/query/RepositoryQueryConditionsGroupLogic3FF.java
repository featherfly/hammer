
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * repository query conditions group logic3.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic3FF extends
    RepositoryQueryConditionsGroupLogicExpression3<RepositoryQueryConditionsGroup3FF,
        RepositoryQueryConditionsGroupLogic3FF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression3FF, QueryMapperSetter2 {
}
