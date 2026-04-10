
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryListExecutor;
import cn.featherfly.data.query.QueryValueExecutor;
import cn.featherfly.data.query.QueryValueLimitExecutor;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * entity query one value expression.
 *
 * @author zhongj
 * @param <E> the query entity type
 * @param <V> the fetch value type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 * @param <T> this expression
 */
public interface EntityQueryOneValueCompatibleExpression<E, V,
    C extends EntityQueryValueConditionGroupCompatibleExpression<E, V, C, L, S>,
    L extends EntityQueryValueConditionGroupLogicCompatibleExpression<E, V, C, L, S>,
    S extends EntityQueryValueSortCompatibleExpression<E, V>,
    T extends EntityQueryOneValueCompatibleExpression<E, V, C, L, S, T>>
    extends EntityQueryValueWhereCompatibleExpression<E, V, C, L, S>, QueryListExecutor<E>, QueryValueExecutor,
    QueryCountExecutor, QueryLimitSetter<QueryValueLimitExecutor>, Queryable<S>,
    ConfigureExpression<T, DslQueryConfig, QueryConditionConfig> {

}
