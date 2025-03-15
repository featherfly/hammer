
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-15 19:12:15
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;
import cn.featherfly.hammer.expression.query.Sortable;

/**
 * The Interface EntitySortable6.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface EntitySortable6<E1, E2, E3, E4, E5, E6, S, Q> extends Sortable<S> {

    /**
     * Sort.
     *
     * @param <S1> the generic type
     * @param <S2> the generic type
     * @param <S3> the generic type
     * @param <S4> the generic type
     * @param <S5> the generic type
     * @param <S6> the generic type
     * @param entitySortExpresions the entity sort expresions
     * @return the s
     */
    <S1 extends EntitySortedExpression<E1, S1>, S2 extends EntitySortedExpression<E2, S2>,
        S3 extends EntitySortedExpression<E3, S3>, S4 extends EntitySortedExpression<E4, S4>,
        S5 extends EntitySortedExpression<E5, S5>,
        S6 extends EntitySortedExpression<E6, S6>> Q sort(SixArgusConsumer<EntitySortExpression<E1, S1>,
            EntitySortExpression<E2, S2>, EntitySortExpression<E3, S3>, EntitySortExpression<E4, S4>,
            EntitySortExpression<E5, S5>, EntitySortExpression<E6, S6>> entitySortExpresions);
}
