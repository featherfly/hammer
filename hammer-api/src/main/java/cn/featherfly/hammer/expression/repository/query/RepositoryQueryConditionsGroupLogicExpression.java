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

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.expression.query.Queryable;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression;

/**
 * repository query conditions group logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryConditionsGroupLogicExpression<
    C extends RepositoryQueryConditionsGroupExpression<C, L, S>,
    L extends RepositoryQueryConditionsGroupLogicExpression<C, L, S>, S extends RepositoryQuerySortExpression>
    extends RepositoryConditionsGroupLogicExpression<C, L>, Queryable<S>,
    QueryLimitSetter<LimitAwareQuery1<Map<String, Serializable>>>, QueryLimitExecutor<Map<String, Serializable>>,
    QueryCountExecutor, QueryMapperSetter1 {
}
