package cn.featherfly.hammer.expression.repository.query.sort;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.query.sort.SortExpression;

/**
 * repository sort expression.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortExpression<S extends RepositorySortedExpression<S>> extends SortExpression<S> {

    /**
     * add asc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <T, R> S asc(SerializableFunction<T, R> name);

    /**
     * add asc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <T, R> S asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names);

    /**
     * add desc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <T, R> S desc(SerializableFunction<T, R> name);

    /**
     * add desc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <T, R> S desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names);

}