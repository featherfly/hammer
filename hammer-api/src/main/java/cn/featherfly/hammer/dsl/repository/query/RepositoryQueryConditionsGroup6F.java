
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup6F extends
    RepositoryQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6F, RepositoryQueryConditionsGroupLogic6F,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6F, LimitAwareQuery1<Map<String, Serializable>>> {

}
