package cn.featherfly.hammer.expression.repository.query.sort;

import java.util.Arrays;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.expression.query.sort.SortExpression2;

/**
 * repository sort expression.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface RepositorySortExpression2<S extends RepositorySortedExpression2<S>> extends SortExpression2<S> {

    /**
     * add asc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S asc2(SerializableFunction<T, R> name) {
        return asc2(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add asc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S asc2(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return asc2(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return asc2(ss);
    }

    /**
     * add desc field.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    default <T, R> S desc2(SerializableFunction<T, R> name) {
        return desc2(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * add desc field.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param names 名称
     * @return this
     */
    default <T, R> S desc2(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        if (Lang.isEmpty(names)) {
            return desc2(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] ss = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(num -> ArrayUtils.create(String.class, num));
        return desc2(ss);
    }

}