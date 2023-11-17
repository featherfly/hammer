
package cn.featherfly.hammer.expression.repository.condition.lt;

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
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression;

/**
 * repository less than expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessThanExpression<C, L> {

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, N extends Number> L lt(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, D extends Date> L lt(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T> L lt(SerializableToStringFunction<T> name, String value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L lt(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy);

}