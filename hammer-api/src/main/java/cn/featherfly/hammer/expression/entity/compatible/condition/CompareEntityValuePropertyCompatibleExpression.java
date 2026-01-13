/*
 * All rights Reserved, Designed By zhongj
 * @Title: CompareEntityValuePropertyCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition;

import cn.featherfly.hammer.expression.condition.field.value.SetCompareValueExpression;
import cn.featherfly.hammer.expression.entity.condition.CompareEntityValuePropertyExpression;

/**
 * compare entity value property expression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface CompareEntityValuePropertyCompatibleExpression<T> extends CompareEntityValuePropertyExpression<T> {

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetCompareValueExpression property(String name);

    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    SetIntExpression propertyAsInt(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    SetLongExpression propertyAsLong(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    SetDoubleExpression propertyAsDouble(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param <D> the generic type
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    <D extends Date> SetDateExpression<D> propertyAsDate(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    SetLocalDateExpression propertyAsLocalDate(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    SetLocalTimeExpression propertyAsLocalTime(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    SetLocalDateTimeExpression propertyAsLocalDateTime(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param <N> the generic type
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    <N extends Number> SetNumberExpression<N> propertyAsNumber(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param <E> the element type
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    <E extends Enum<E>> SetEnumExpression<E> propertyAsEnum(String name);
    //
    //    /**
    //     * entity compare function property expression.
    //     *
    //     * @param name the name
    //     * @return entity compare function property expression.
    //     */
    //    SetStringExpression propertyAsString(String name);
}
