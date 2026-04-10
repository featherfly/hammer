
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression4;

/**
 * repository query sort expression4.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression4<S extends RepositoryQuerySortedExpression4<S, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositorySortExpression4<S> {

}
