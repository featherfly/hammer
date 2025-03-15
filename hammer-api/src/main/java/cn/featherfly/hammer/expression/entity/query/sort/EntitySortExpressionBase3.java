package cn.featherfly.hammer.expression.entity.query.sort;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.SortOperator;

/**
 * The Interface EntitySortExpressionBase3.
 *
 * @author zhongj
 * @param <E> the entity type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <S> the EntitySortExpression type
 */
public interface EntitySortExpressionBase3<E, E2, E3, S extends EntitySortedExpression<E, S>>
    extends EntitySortExpressionBase2<E, E2, S> {

    /**
     * add assign order value. 添加指定排序条件.
     *
     * @param <R> the generic type
     * @param order the order
     * @param names the names
     * @return the s
     */
    default <R> S order3(SortOperator order, SerializableFunction<E3, R> names) {
        switch (order) {
            case DESC:
                return desc3(names);
            default:
                return asc3(names);
        }
    }

    /**
     * add assign order value. 添加指定排序条件.
     *
     * @param order the order
     * @param names the names
     * @return the s
     */
    default S order3(SortOperator order, @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        switch (order) {
            case DESC:
                return desc3(names);
            default:
                return asc3(names);
        }
    }

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R> the generic type
     * @param name 名称
     * @return this
     */
    <R> S asc3(SerializableFunction<E3, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param names 名称
     * @return this
     */
    S asc3(@SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names);

    /**
     * add descending order value.添加降序条件 .
     *
     * @param <R> the generic type
     * @param name 名称
     * @return this
     */
    <R> S desc3(SerializableFunction<E3, R> name);

    /**
     * add descending order value.添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc3(@SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names);

}