
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression4;

/**
 * repository query conditions group logic4.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroupLogic4<S extends RepositoryQuerySortExpression4<S2, Q>,
    S2 extends RepositoryQuerySortedExpression4<S2, Q>, Q extends QueryLimitExecutor>
    extends RepositoryQueryConditionsGroupLogicExpression4<RepositoryQueryConditionsGroup4<S, S2, Q>,
        RepositoryQueryConditionsGroupLogic4<S, S2, Q>, S, S2, Q> {
}
