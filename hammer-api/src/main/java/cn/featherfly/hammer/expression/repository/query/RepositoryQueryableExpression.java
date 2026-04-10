
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryEachExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryListExecutor;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * repository query expression.
 *
 * @author zhongj
 * @param <S> the sort type
 * @param <Q> the QueryLimitExecutor type
 */
public interface RepositoryQueryableExpression<S, Q extends LimitAwareQuery1<Map<String, Serializable>>>
    extends Queryable<S>, QueryListExecutor<Map<String, Serializable>>, QueryEachExecutor<Map<String, Serializable>>,
    QueryCountExecutor, QueryLimitSetter<Q>, QueryMapperSetter1 {
}
