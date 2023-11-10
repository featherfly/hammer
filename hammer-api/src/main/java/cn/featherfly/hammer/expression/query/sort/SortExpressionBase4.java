package cn.featherfly.hammer.expression.query.sort;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;

/**
 * sort expression4.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpressionBase4<S extends SortedExpression<S>> extends SortExpressionBase3<S> {

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    S asc4(String... names);

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    default S asc4(List<String> names) {
        return asc4(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc4(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return asc4(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return asc4(names);
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc4(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return asc4(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return asc4(names);
    }

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    S desc4(String... names);

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    default S desc4(List<String> names) {
        return desc4(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc4(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return desc4(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return desc4(names);
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc4(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return desc4(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return desc4(names);
    }
}