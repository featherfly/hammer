
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * repository query conditions group3.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup3F extends
    RepositoryQueryConditionsGroupExpression3<RepositoryQueryConditionsGroup3F, RepositoryQueryConditionsGroupLogic3F,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3F, LimitAwareQuery1<Map<String, Serializable>>> {

}
