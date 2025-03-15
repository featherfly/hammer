
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression6;

/**
 * repository query conditions group6.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroup6<S extends RepositoryQuerySortExpression6<S2, Q>,
    S2 extends RepositoryQuerySortedExpression6<S2, Q>, Q extends QueryLimitExecutor>
    extends RepositoryQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6<S, S2, Q>,
        RepositoryQueryConditionsGroupLogic6<S, S2, Q>, S, S2, Q> {

}
