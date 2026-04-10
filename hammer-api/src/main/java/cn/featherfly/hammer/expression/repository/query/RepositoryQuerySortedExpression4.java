
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.data.query.QueryExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter0;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression4;

/**
 * repository query sorted expression4.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression4<S extends RepositoryQuerySortedExpression4<S, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositorySortedExpression4<S>, QueryLimitSetter<Q>,
    QueryExecutor<Map<String, Serializable>>, QueryMapperSetter0 {

}
