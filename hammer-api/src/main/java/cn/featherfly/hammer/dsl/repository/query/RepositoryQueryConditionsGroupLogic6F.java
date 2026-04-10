
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group logic6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic6F extends
    RepositoryQueryConditionsGroupLogicExpression6<RepositoryQueryConditionsGroup6F,
        RepositoryQueryConditionsGroupLogic6F,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6F, LimitAwareQuery1<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression6F, QueryMapperSetter1 {
}
