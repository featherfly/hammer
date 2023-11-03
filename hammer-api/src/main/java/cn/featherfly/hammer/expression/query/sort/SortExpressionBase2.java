package cn.featherfly.hammer.expression.query.sort;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;

/**
 * sort expression.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpressionBase2<S extends SortedExpression<S>> extends SortExpression<S> {

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    S asc2(String... names);

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    default S asc2(List<String> names) {
        return asc2(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc2(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return asc2(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return asc2(names);
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc2(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return asc2(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return asc2(names);
    }

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    S desc2(String... names);

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    default S desc2(List<String> names) {
        return desc2(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc2(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return desc2(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return desc2(names);
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc2(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return desc2(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return desc2(names);
    }
}