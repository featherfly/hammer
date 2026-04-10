
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * repository query conditions group logic3.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic3FFF extends
    RepositoryQueryConditionsGroupLogicExpression3<RepositoryQueryConditionsGroup3FFF,
        RepositoryQueryConditionsGroupLogic3FFF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3FFF, LimitAwareQuery3<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression3FFF, QueryMapperSetter3 {
}
