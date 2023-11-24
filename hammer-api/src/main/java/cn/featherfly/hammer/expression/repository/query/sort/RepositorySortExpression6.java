package cn.featherfly.hammer.expression.repository.query.sort;

import java.util.Arrays;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.expression.query.sort.SortExpression6;

/**
 * repository sort expression6.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortExpression6<S extends RepositorySortedExpression6<S>> extends SortExpression6<S> {
    /**
     * add asc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S asc6(SerializableFunction<T, R> name) {
        return asc6(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add asc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S asc6(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return asc6(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return asc6(ss);
    }

    /**
     * add desc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S desc6(SerializableFunction<T, R> name) {
        return desc6(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add desc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S desc6(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return desc6(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return desc6(ss);
    }
}