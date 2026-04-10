/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryWhereCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:28:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.hammer.expression.entity.compatible.EntityWhereCompatibleExpression;

/**
 * entity query value where compatible expression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <V> the value type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 */
public interface EntityQueryValueWhereCompatibleExpression<E1, V,
    C extends EntityQueryValueConditionGroupCompatibleExpression<E1, V, C, L, S>,
    L extends EntityQueryValueConditionGroupLogicCompatibleExpression<E1, V, C, L, S>,
    S extends EntityQueryValueSortCompatibleExpression<E1, V>> extends EntityWhereCompatibleExpression<E1, C, L> {

}
