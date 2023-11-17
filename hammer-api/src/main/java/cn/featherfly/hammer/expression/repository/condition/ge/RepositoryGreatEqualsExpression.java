
package cn.featherfly.hammer.expression.repository.condition.ge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression;

/**
 * RepositoryGreatEqualsExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatEqualsExpression<C, L> {

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L ge(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L ge(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L ge(SerializableToStringFunction<T> name, String value);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ge(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);
}