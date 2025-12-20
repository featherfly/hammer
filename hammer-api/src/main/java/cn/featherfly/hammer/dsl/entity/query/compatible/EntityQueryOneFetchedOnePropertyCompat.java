/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryOneFetchedPropertyCompat.java
 * @Package cn.featherfly.hammer.dsl.entity.query.compatible
 * @author: zhongj
 * @date: 2025-12-11 01:22:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.compatible;

import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryFetchedPropertiesCompatibleExpression;

/**
 * dsl for compatible entity query fetched property.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryOneFetchedOnePropertyCompat<E, V>
    extends EntityQueryRelateBase<E>, EntityQueryOneValueCompat<E, V, EntityQueryOneFetchedOnePropertyCompat<E, V>>,
    EntityQueryFetchedPropertiesCompatibleExpression<E, EntityQueryFetchedPropertiesCompat<E>> {

}
