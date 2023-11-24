
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryValueConditionLimit;
import cn.featherfly.hammer.expression.query.QueryValueOneExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * repository query value one expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryValueOneExpression<C extends RepositoryQueryValueConditionsGroupExpression<C, L, S>,
        L extends RepositoryQueryValueConditionsGroupLogicExpression<C, L, S>,
        S extends RepositoryQueryValueSortExpression> extends RepositoryQueryValueWhereExpression<C, L, S>,
        QueryValueOneExecutor, QueryCountExecutor, QueryValueConditionLimit, Queryable<S> {
}
