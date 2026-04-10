/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryListExecutor;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityQueryCompatibleExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> this expression
 * @param <T> the generic type
 */
public interface EntityQueryCompatibleExpression<E1,
    C extends EntityQueryConditionGroupCompatibleExpression<E1, C, L, S>,
    L extends EntityQueryConditionGroupLogicCompatibleExpression<E1, C, L, S>,
    S extends EntityQuerySortCompatibleExpression<E1>, T extends EntityQueryCompatibleExpression<E1, C, L, S, T>>
    extends EntityQueryWhereCompatibleExpression<E1, C, L, S>, QueryListExecutor<E1>, QueryCountExecutor,
    QueryLimitSetter<QueryLimitExecutor<E1>>, Queryable<S>,
    ConfigureExpression<T, DslQueryConfig, QueryConditionConfig> {
}
