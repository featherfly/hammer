
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup6FF extends
    RepositoryQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FF, RepositoryQueryConditionsGroupLogic6FF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FF, LimitAwareQuery2<Map<String, Serializable>>> {

}
