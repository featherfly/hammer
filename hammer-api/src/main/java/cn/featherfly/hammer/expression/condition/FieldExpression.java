
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-12-01 17:21:01
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.field.DateFieldExpression;
import cn.featherfly.hammer.expression.condition.field.EnumFieldExpression;
import cn.featherfly.hammer.expression.condition.field.LocalDateFieldExpression;
import cn.featherfly.hammer.expression.condition.field.LocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.condition.field.LocalTimeFieldExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.ObjectFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;

/**
 * field expression.
 *
 * @author zhongj
 */
public interface FieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * Property.
     *
     * @param name the name
     * @return the object expression
     */
    ObjectFieldExpression<C, L> field(String name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    StringFieldExpression<C, L> fieldAsString(String name);

    /**
     * Property number.
     *
     * @param <N>  the number type
     * @param name the name
     * @return the number expression
     */
    <N extends Number> NumberFieldExpression<N, C, L> fieldAsNumber(String name);

    /**
     * Property enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EnumFieldExpression<R, C, L> fieldAsEnum(String name);

    /**
     * Property date.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the date expression
     */
    <D extends Date> DateFieldExpression<D, C, L> fieldAsDate(String name);

    /**
     * Property LocalDate.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the date expression
     */
    LocalDateFieldExpression<C, L> fieldAsLocalDate(String name);

    /**
     * Property LocalDateTime.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the date expression
     */
    LocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(String name);

    /**
     * Property LocalTime.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the date expression
     */
    LocalTimeFieldExpression<C, L> fieldAsLocalTime(String name);
}