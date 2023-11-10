package cn.featherfly.hammer.expression.query.sort;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.Expression;

/**
 * 基础排序构建接口.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpressionBase<S extends SortExpressionBase<S>> extends Expression {

    /**
     * 添加升序条件 .
     *
     * @param names 名称
     * @return this
     */
    S asc(String... names);

    /**
     * 添加升序条件 .
     *
     * @param names 名称
     * @return this
     */
    S asc(List<String> names);

    /**
     * 添加升序条件 .
     *
     * @param fields the fields
     * @return this
     */
    default S asc(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return asc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        return asc(Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(Field.class, num)));
    }

    /**
     * 添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc(String... names);

    /**
     * 添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc(List<String> names);

    /**
     * 添加降序条件 .
     *
     * @param fields the fields
     * @return this
     */
    default S desc(Field... fields) {
        if (Lang.isEmpty(fields)) {
            return desc(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        return desc(Arrays.stream(fields).map(Field::name).toArray(num -> ArrayUtils.create(Field.class, num)));
    }
}