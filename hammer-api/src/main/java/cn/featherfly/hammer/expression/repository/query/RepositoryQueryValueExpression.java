
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryValueConditionLimit;
import cn.featherfly.hammer.expression.query.QueryValueListExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * entity query value expression.
 *
 * @author zhongj
 * @param <E> the query type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryValueExpression<C extends RepositoryQueryValueConditionsGroupExpression<C, L, S>,
        L extends RepositoryQueryValueConditionsGroupLogicExpression<C, L, S>,
        S extends RepositoryQueryValueSortExpression> extends RepositoryQueryValueWhereExpression<C, L, S>,
        QueryValueListExecutor, QueryCountExecutor, QueryValueConditionLimit, Queryable<S> {
}
