package cn.featherfly.hammer.expression.repository.query.sort;

import java.util.Arrays;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.expression.query.sort.SortExpression5;

/**
 * repository sort expression5.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortExpression5<S extends RepositorySortedExpression5<S>> extends SortExpression5<S> {
    /**
     * add asc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S asc5(SerializableFunction<T, R> name) {
        return asc5(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add asc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S asc5(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return asc5(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return asc5(ss);
    }

    /**
     * add desc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S desc5(SerializableFunction<T, R> name) {
        return desc5(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add desc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S desc5(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return desc5(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return desc5(ss);
    }
}