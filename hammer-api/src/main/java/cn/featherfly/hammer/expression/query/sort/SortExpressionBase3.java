package cn.featherfly.hammer.expression.query.sort;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;

/**
 * sort expression3.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpressionBase3<S extends SortedExpression<S>> extends SortExpressionBase2<S> {

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    S asc3(String... names);

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    default S asc3(List<String> names) {
        return asc3(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc3(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return asc3(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return asc3(names);
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc3(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return asc3(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return asc3(names);
    }

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    S desc3(String... names);

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    default S desc3(List<String> names) {
        return desc3(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc3(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return desc3(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return desc3(names);
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc3(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return desc3(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return desc3(names);
    }
}