
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.data.query.QueryExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter0;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression6;

/**
 * repository query sorted expression6.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression6<S extends RepositoryQuerySortedExpression6<S, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositorySortedExpression6<S>, QueryLimitSetter<Q>,
    QueryExecutor<Map<String, Serializable>>, QueryMapperSetter0 {

}
