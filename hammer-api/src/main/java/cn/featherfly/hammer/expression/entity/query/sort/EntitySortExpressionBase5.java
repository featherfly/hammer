package cn.featherfly.hammer.expression.entity.query.sort;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.SortOperator;

/**
 * The Interface EntitySortExpressionBase4.
 *
 * @author zhongj
 * @param <E> the entity type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <S> the EntitySortExpression type
 */
public interface EntitySortExpressionBase5<E, E2, E3, E4, E5, S extends EntitySortedExpression<E, S>>
    extends EntitySortExpressionBase4<E, E2, E3, E4, S> {

    /**
     * add assign order value. 添加指定排序条件.
     *
     * @param <R> the generic type
     * @param order the order
     * @param names the names
     * @return the s
     */
    default <R> S order5(SortOperator order, SerializableFunction<E5, R> names) {
        switch (order) {
            case DESC:
                return desc5(names);
            default:
                return asc5(names);
        }
    }

    /**
     * add assign order value. 添加指定排序条件.
     *
     * @param order the order
     * @param names the names
     * @return the s
     */
    default S order5(SortOperator order, @SuppressWarnings("unchecked") SerializableFunction<E5, ?>... names) {
        switch (order) {
            case DESC:
                return desc5(names);
            default:
                return asc5(names);
        }
    }

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R> the generic type
     * @param name 名称
     * @return this
     */
    <R> S asc5(SerializableFunction<E5, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param names 名称
     * @return this
     */
    S asc5(@SuppressWarnings("unchecked") SerializableFunction<E5, ?>... names);

    /**
     * add descending order value.添加降序条件 .
     *
     * @param <R> the generic type
     * @param name 名称
     * @return this
     */
    <R> S desc5(SerializableFunction<E5, R> name);

    /**
     * add descending order value.添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc5(@SuppressWarnings("unchecked") SerializableFunction<E5, ?>... names);

}