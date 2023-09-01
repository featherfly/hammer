package cn.featherfly.hammer.expression.entity.query.sort;

import cn.featherfly.common.function.serializable.SerializableFunction;

/**
 * The Interface EntitySortExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the entity type
 * @param <E2> the generic type
 * @param <S>  the EntitySortExpression type
 */
public interface EntitySortExpressionBase2<E, E2, S extends EntitySortedExpression<E, S>>
        extends EntitySortExpression<E, S> {

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <R> S asc2(SerializableFunction<E2, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param names 名称
     * @return this
     */
    S asc2(@SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names);

    /**
     * add descending order value.添加降序条件 .
     *
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <R> S desc2(SerializableFunction<E2, R> name);

    /**
     * add descending order value.添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc2(@SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names);

}