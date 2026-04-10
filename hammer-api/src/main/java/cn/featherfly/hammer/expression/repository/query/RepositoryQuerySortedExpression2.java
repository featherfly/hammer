
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.data.query.QueryExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter0;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression2;

/**
 * repository query sorted expression2.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortedExpression2<S extends RepositoryQuerySortedExpression2<S, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositorySortedExpression2<S>, QueryLimitSetter<Q>,
    QueryExecutor<Map<String, Serializable>>, QueryMapperSetter0 {

}
