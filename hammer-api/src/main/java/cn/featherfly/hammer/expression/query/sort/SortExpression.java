package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * 排序构建接口.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression<S extends SortExpression<S>> extends BaseSortExpression<S> {

    /**
     * 添加升序条件 .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <T, R> S asc(SerializableFunction<T, R> name);

    /**
     * 添加升序条件 .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <T, R> S asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names);

    /**
     * 添加降序条件 .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <T, R> S desc(SerializableFunction<T, R> name);

    /**
     * 添加降序条件 .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <T, R> S desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names);

}