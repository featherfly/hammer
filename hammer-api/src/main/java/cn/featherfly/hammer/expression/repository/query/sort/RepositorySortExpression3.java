package cn.featherfly.hammer.expression.repository.query.sort;

import java.util.Arrays;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.expression.query.sort.SortExpression3;

/**
 * repository sort expression3.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortExpression3<S extends RepositorySortedExpression3<S>> extends SortExpression3<S> {

    /**
     * add asc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S asc3(SerializableFunction<T, R> name) {
        return asc3(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add asc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S asc3(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return asc3(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return asc3(ss);
    }

    /**
     * add desc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S desc3(SerializableFunction<T, R> name) {
        return desc3(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add desc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S desc3(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return desc3(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return desc3(ss);
    }
}