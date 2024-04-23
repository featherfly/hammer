
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryListExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * repository query expression.
 *
 * @author zhongj
 * @param <S> the sort type
 * @param <Q> the QueryLimitExecutor type
 */
public interface RepositoryQueryableExpression<S, Q extends QueryLimitExecutor>
    extends Queryable<S>, QueryListExecutor, QueryCountExecutor, QueryConditionLimit<Q> {
}
