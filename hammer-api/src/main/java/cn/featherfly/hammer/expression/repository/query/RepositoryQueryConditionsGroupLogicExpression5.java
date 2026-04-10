/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 5053-11-17 16:55:17
 * @Copyright: 5053 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.data.query.QueryMapperSetter0;
import cn.featherfly.data.query.QueryOneExecutor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression5;

/**
 * repository query conditions group logic expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroupLogicExpression5<
    C extends RepositoryQueryConditionsGroupExpression5<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression5<S2, Q>, S2 extends RepositoryQuerySortedExpression5<S2, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositoryConditionsGroupLogicExpression5<C, L>,
    RepositoryQueryable5<S, S2, Q>, QueryOneExecutor<Map<String, Serializable>>, QueryMapperSetter0 {
}
