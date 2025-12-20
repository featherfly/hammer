/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryCompat.java
 * @Package cn.featherfly.hammer.dsl.entity.query.compatible
 * @author: zhongj
 * @date: 2025-12-11 01:21:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.compatible;

import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQuerySortCompatibleExpression;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQueryCompat<E, T extends EntityQueryCompat<E, T>>
    extends EntityQueryCompatibleExpression<E, EntityQueryConditionGroupCompat<E>,
        EntityQueryConditionGroupLogicCompat<E>, EntityQuerySortCompatibleExpression<E>, T> {
}
