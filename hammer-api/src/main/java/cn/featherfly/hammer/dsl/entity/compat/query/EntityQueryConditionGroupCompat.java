/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryConditionGroupCompat.java
 * @Package cn.featherfly.hammer.dsl.entity.query.compatible
 * @author: zhongj
 * @date: 2025-12-11 01:21:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.compat.query;

import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryConditionGroupCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQuerySortCompatibleExpression;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public interface EntityQueryConditionGroupCompat<E>
    extends EntityQueryConditionGroupCompatibleExpression<E, EntityQueryConditionGroupCompat<E>,
        EntityQueryConditionGroupLogicCompat<E>, EntityQuerySortCompatibleExpression<E>> {

}
