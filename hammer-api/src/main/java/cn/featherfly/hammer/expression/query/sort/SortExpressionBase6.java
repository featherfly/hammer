package cn.featherfly.hammer.expression.query.sort;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;

/**
 * sort expression6.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpressionBase6<S extends SortedExpression<S>> extends SortExpressionBase5<S> {

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    S asc6(String... names);

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    default S asc6(List<String> names) {
        return asc6(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc6(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return asc6(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return asc6(names);
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc6(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return asc6(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return asc6(names);
    }

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    S desc6(String... names);

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    default S desc6(List<String> names) {
        return desc6(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc6(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return desc6(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return desc6(names);
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc6(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return desc6(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return desc6(names);
    }
}