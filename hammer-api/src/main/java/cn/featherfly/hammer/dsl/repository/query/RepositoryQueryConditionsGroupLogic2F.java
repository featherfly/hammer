
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * repository query conditions group logic2.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroupLogic2F extends
    RepositoryQueryConditionsGroupLogicExpression2<RepositoryQueryConditionsGroup2F,
        RepositoryQueryConditionsGroupLogic2F,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression2F, LimitAwareQuery1<Map<String, Serializable>>>,
    RepositoryQuerySortedExpression2F, QueryMapperSetter1 {
}
