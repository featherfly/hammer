/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryValueCompat.java
 * @Package cn.featherfly.hammer.dsl.entity.query.compatible
 * @author: zhongj
 * @date: 2025-12-11 01:22:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.compat.query;

import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryValueCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryValueSortCompatibleExpression;

/**
 * dsl for entity query value.
 *
 * @author zhongj
 * @param <E> the query entity type
 * @param <V> the fetch value type
 * @param <T> this expression
 */
public interface EntityQueryValueCompat<E, V, T extends EntityQueryValueCompat<E, V, T>>
    extends EntityQueryValueCompatibleExpression<E, V, EntityQueryValueConditionGroupCompat<E, V>,
        EntityQueryValueConditionGroupLogicCompat<E, V>, EntityQueryValueSortCompatibleExpression<E, V>, T> {
}
