
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * repository query conditions group logic5.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic5F extends
    RepositoryQueryConditionsGroupLogicExpression5<RepositoryQueryConditionsGroup5F,
        RepositoryQueryConditionsGroupLogic5F,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5F, LimitAwareQuery1<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression5F, QueryMapperSetter1 {
}
