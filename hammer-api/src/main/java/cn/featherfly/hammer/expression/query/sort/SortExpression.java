package cn.featherfly.hammer.expression.query.sort;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.Expression;

/**
 * sort expression.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression<S extends SortedExpression<S>> extends Expression {

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    S asc(String... names);

    /**
     * add asc field.
     *
     * @param names 名称
     * @return this
     */
    default S asc(List<String> names) {
        return asc(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return asc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return asc(names);
    }

    /**
     * add asc field.
     *
     * @param fields the fields
     * @return this
     */
    default S asc(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return asc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return asc(names);
    }

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    S desc(String... names);

    /**
     * add desc field.
     *
     * @param names 名称
     * @return this
     */
    default S desc(List<String> names) {
        return desc(CollectionUtils.toArray(names, String.class));
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return desc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(String.class, num));
        return desc(names);
    }

    /**
     * add desc field.
     *
     * @param fields the fields
     * @return this
     */
    default S desc(AliasField... fields) {
        if (Lang.isEmpty(fields)) {
            return desc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        String[] names = Arrays.stream(fields).map(AliasField::getAliasOrName)
            .toArray(num -> ArrayUtils.create(String.class, num));
        return desc(names);
    }
}