
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.QueryMapperSetter4;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group logic6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic6FFFF extends
    RepositoryQueryConditionsGroupLogicExpression6<RepositoryQueryConditionsGroup6FFFF,
        RepositoryQueryConditionsGroupLogic6FFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFF, LimitAwareQuery4<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression6FFFF, QueryMapperSetter4 {
}
