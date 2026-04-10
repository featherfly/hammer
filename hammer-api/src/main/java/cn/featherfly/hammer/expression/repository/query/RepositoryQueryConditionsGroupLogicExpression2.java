/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:55:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.data.query.QueryMapperSetter0;
import cn.featherfly.data.query.QueryOneExecutor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression2;

/**
 * repository query conditions group logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroupLogicExpression2<
    C extends RepositoryQueryConditionsGroupExpression2<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression2<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression2<S2, Q>, S2 extends RepositoryQuerySortedExpression2<S2, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositoryConditionsGroupLogicExpression2<C, L>,
    RepositoryQueryable2<S, S2, Q>, QueryOneExecutor<Map<String, Serializable>>, QueryMapperSetter0 {
}
