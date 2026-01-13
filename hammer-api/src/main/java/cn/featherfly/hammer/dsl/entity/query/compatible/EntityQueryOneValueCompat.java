/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryValueCompat.java
 * @Package cn.featherfly.hammer.dsl.entity.query.compatible
 * @author: zhongj
 * @date: 2025-12-11 01:22:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.compatible;

import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroupLogic;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryOneValueCompatibleExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;

/**
 * dsl for entity query value.
 *
 * @author zhongj
 * @param <E> the query entity type
 * @param <V> the fetch value type
 * @param <T> this expression
 */
public interface EntityQueryOneValueCompat<E, V, T extends EntityQueryOneValueCompat<E, V, T>>
    extends EntityQueryOneValueCompatibleExpression<E, V, EntityQueryValueConditionGroup<E, V>,
        EntityQueryValueConditionGroupLogic<E, V>, EntityQueryValueSortExpression<E, V>, T> {
}
