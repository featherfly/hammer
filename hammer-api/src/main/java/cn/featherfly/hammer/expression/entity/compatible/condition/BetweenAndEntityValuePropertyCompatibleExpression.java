/*
 * All rights Reserved, Designed By zhongj
 * @Title: BetweenAndEntityValuePropertyCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression2;
import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityValuePropertyExpression;

/**
 * The Interface BetweenAndEntityValuePropertyExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface BetweenAndEntityValuePropertyCompatibleExpression<T>
    extends BetweenAndEntityValuePropertyExpression<T> {

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetIntExpression2 propertyAsInt(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLongExpression2 propertyAsLong(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetDoubleExpression2 propertyAsDouble(String name);

    /**
     * entity between and function property expression.
     *
     * @param <D> the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <D extends Date> SetDateExpression2<D> propertyAsDate(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalDateExpression2 propertyAsLocalDate(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalTimeExpression2 propertyAsLocalTime(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalDateTimeExpression2 propertyAsLocalDateTime(String name);

    /**
     * entity between and function property expression.
     *
     * @param <N> the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <N extends Number> SetNumberExpression2<N> propertyAsNumber(String name);

    /**
     * entity between and function property expression.
     *
     * @param <E> the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <E extends Enum<E>> SetEnumExpression2<E> propertyAsEnum(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetStringExpression2 propertyAsString(String name);
}
