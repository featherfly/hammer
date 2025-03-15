
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-15 19:12:15
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.query;

import java.util.function.BiConsumer;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;
import cn.featherfly.hammer.expression.query.Sortable;

/**
 * The Interface EntitySortable2.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <S> the generic type
 */
public interface EntitySortable2<E1, E2, S, Q> extends Sortable<S> {

    /**
     * Sort.
     *
     * @param <S1> the generic type
     * @param <S2> the generic type
     * @param entitySortExpresions the entity sort expresions
     * @return the s
     */
    <S1 extends EntitySortedExpression<E1, S1>, S2 extends EntitySortedExpression<E2, S2>> Q sort(
        BiConsumer<EntitySortExpression<E1, S1>, EntitySortExpression<E2, S2>> entitySortExpresions);
}
