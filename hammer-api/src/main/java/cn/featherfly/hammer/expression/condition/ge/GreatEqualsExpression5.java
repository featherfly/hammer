
package cn.featherfly.hammer.expression.condition.ge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * great equals expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatEqualsExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatEqualsExpression4<C, L> {

    /**
     * great equals. 大于等于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ge5(Field name, N value) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge5(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge5(Field name, N value, Predicate<N> ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ge5(String name, N value);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge5(String name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge5(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ge5(Field name, D value) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge5(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge5(Field name, D value, Predicate<D> ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ge5(String name, D value);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge5(String name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge5(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge5(Field name, LocalTime value) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge5(String name, LocalTime value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge5(Field name, LocalDate value) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge5(String name, LocalDate value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge5(Field name, LocalDateTime value) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge5(name.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge5(String name, LocalDateTime value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge5(Field name, String value) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge5(Field name, String value, Predicate<String> ignoreStrategy) {
        return ge5(name.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge5(String name, String value);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge5(String name, String value, Predicate<String> ignoreStrategy);
}