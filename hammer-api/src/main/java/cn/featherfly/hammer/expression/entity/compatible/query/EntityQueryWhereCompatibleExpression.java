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
 * The Interface EntityQueryWhereExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 */
public interface EntityQueryWhereCompatibleExpression<E1,
    C extends EntityQueryConditionGroupCompatibleExpression<E1, C, L, S>,
    L extends EntityQueryConditionGroupLogicCompatibleExpression<E1, C, L, S>,
    S extends EntityQuerySortCompatibleExpression<E1>> extends EntityWhereCompatibleExpression<E1, C, L> {

}
