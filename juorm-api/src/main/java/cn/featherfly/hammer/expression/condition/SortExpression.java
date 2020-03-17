package cn.featherfly.hammer.expression.condition;

import java.util.List;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * <p>
 * 排序构建接口
 * </p>
 * .
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression<S extends SortExpression<S>> extends Expression {

    /**
     * <p>
     * 添加升序条件
     * </p>
     * .
     *
     * @param names 名称
     * @return this
     */
    S asc(String... names);

    /**
     * <p>
     * 添加升序条件
     * </p>
     * .
     *
     * @param names 名称
     * @return this
     */
    S asc(List<String> names);

    /**
     * <p>
     * 添加升序条件
     * </p>
     * .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <T, R> S asc(SerializableFunction<T, R> name);

    /**
     * <p>
     * 添加升序条件
     * </p>
     * .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <T, R> S asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names);

    /**
     * <p>
     * 添加降序条件
     * </p>
     * .
     *
     * @param names 名称
     * @return this
     */
    S desc(String... names);

    /**
     * <p>
     * 添加降序条件
     * </p>
     * .
     *
     * @param names 名称
     * @return this
     */
    S desc(List<String> names);

    /**
     * <p>
     * 添加降序条件
     * </p>
     * .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <T, R> S desc(SerializableFunction<T, R> name);

    /**
     * <p>
     * 添加降序条件
     * </p>
     * .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    <T, R> S desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names);

}