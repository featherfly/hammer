
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryListExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * repository queryable 5.
 *
 * @author zhongj
 * @param <S> the sort type
 * @param <S2> the sorted type
 * @param <Q> the QueryLimitExecutor type
 */
public interface RepositoryQueryable5<S, S2, Q>
    extends Queryable<S>, RepositorySortable5<S, S2>, QueryListExecutor, QueryCountExecutor, QueryConditionLimit<Q> {
}
