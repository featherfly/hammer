
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.data.query.QueryExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter0;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression5;

/**
 * repository query sorted expression5.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression5<S extends RepositoryQuerySortedExpression5<S, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositorySortedExpression5<S>, QueryLimitSetter<Q>,
    QueryExecutor<Map<String, Serializable>>, QueryMapperSetter0 {

}
