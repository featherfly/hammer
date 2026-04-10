
package cn.featherfly.hammer.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression5;

/**
 * repository query5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuery5<C extends RepositoryQueryConditionsGroupExpression5<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression5<S2, Q>, S2 extends RepositoryQuerySortedExpression5<S2, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositoryQueryExpression5<C, L, S, S2, Q> {
}
