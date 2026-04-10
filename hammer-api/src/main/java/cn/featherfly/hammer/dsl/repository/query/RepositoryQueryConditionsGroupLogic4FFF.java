
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * repository query conditions group logic4.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic4FFF extends
    RepositoryQueryConditionsGroupLogicExpression4<RepositoryQueryConditionsGroup4FFF,
        RepositoryQueryConditionsGroupLogic4FFF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FFF, LimitAwareQuery3<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression4FFF, QueryMapperSetter3 {
}
