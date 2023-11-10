package cn.featherfly.hammer.expression.repository.query.sort;

import java.util.Arrays;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
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
    default <T, R> S asc(SerializableFunction<T, R> name) {
        return asc(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add asc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return asc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return asc(ss);
    }

    /**
     * add desc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S desc(SerializableFunction<T, R> name) {
        return desc(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add desc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return desc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return desc(ss);
    }
}