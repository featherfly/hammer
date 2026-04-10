
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;

/**
 * repository query conditions group6.
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup6FFF extends
    RepositoryQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFF,
        RepositoryQueryConditionsGroupLogic6FFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFF, LimitAwareQuery3<Map<String, Serializable>>> {

}
