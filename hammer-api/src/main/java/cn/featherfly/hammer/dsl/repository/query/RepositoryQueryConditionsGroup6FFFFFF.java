
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery6;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup6FFFFFF extends
    RepositoryQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFFF,
            LimitAwareQuery6<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFFF, LimitAwareQuery6<Map<String, Serializable>>> {

}
