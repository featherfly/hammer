
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression4;

/**
 * repository query where expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryWhereExpression4<C extends RepositoryQueryConditionsGroupExpression4<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression4<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression4<S2, Q>, S2 extends RepositoryQuerySortedExpression4<S2, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositoryWhereExpression4<C, L> {

}
