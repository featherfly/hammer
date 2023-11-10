package cn.featherfly.hammer.expression.query.sort;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;

/**
 * sort expression5.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpressionBase5<S extends SortedExpression<S>> extends SortExpressionBase4<S> {

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    S asc5(String... names);

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    default S asc5(List<String> names) {
        return asc5(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc5(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return asc5(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return asc5(names);
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc5(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return asc5(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return asc5(names);
    }

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    S desc5(String... names);

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    default S desc5(List<String> names) {
        return desc5(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc5(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return desc5(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return desc5(names);
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc5(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return desc5(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return desc5(names);
    }
}