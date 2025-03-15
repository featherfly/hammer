package cn.featherfly.hammer.expression.entity.query.sort;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.hammer.expression.condition.Expression;

/**
 * The Interface EntitySortExpression. 排序构建接口.
 *
 * @author zhongj
 * @param <E> the entity type
 * @param <S> the EntitySortedExpression type
 */
public interface EntitySortExpression<E, S extends EntitySortedExpression<E, S>> extends Expression {

    /**
     * add assign order value. 添加指定排序条件.
     *
     * @param <R> the generic type
     * @param order the order
     * @param names the names
     * @return the s
     */
    default <R> S order(SortOperator order, SerializableFunction<E, R> names) {
        switch (order) {
            case DESC:
                return desc(names);
            default:
                return asc(names);
        }
    }

    /**
     * add assign order value. 添加指定排序条件.
     *
     * @param order the order
     * @param names the names
     * @return the s
     */
    default S order(SortOperator order, @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        switch (order) {
            case DESC:
                return desc(names);
            default:
                return asc(names);
        }
    }

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param <R> the generic type
     * @param name 名称
     * @return this
     */
    <R> S asc(SerializableFunction<E, R> name);

    /**
     * add ascending order value. 添加升序条件.
     *
     * @param names 名称
     * @return this
     */
    S asc(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);

    /**
     * add descending order value. 添加降序条件 .
     *
     * @param <R> the generic type
     * @param name 名称
     * @return this
     */
    <R> S desc(SerializableFunction<E, R> name);

    /**
     * add descending order value.添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);

}