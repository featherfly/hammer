
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.data.query.LimitAwareQueryValue;
import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryValueListExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * entity query value expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryValueExpression<C extends RepositoryQueryValueConditionsGroupExpression<C, L, S>,
    L extends RepositoryQueryValueConditionsGroupLogicExpression<C, L, S>, S extends RepositoryQueryValueSortExpression>
    extends RepositoryQueryValueWhereExpression<C, L, S>, QueryValueListExecutor, QueryCountExecutor,
    QueryLimitSetter<LimitAwareQueryValue>, Queryable<S> {
}
