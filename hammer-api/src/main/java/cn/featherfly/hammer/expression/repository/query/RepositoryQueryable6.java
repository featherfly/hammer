
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryListExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * repository queryable 6.
 *
 * @author zhongj
 * @param <S> the sort type
 * @param <S2> the sorted type
 * @param <Q> the QueryLimitExecutor type
 */
public interface RepositoryQueryable6<S, S2, Q> extends Queryable<S>, RepositorySortable6<S, S2>,
    QueryListExecutor<Map<String, Serializable>>, QueryCountExecutor, QueryLimitSetter<Q> {
}
