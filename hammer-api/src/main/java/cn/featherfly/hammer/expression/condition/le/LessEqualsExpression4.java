
package cn.featherfly.hammer.expression.condition.le;

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
 * less equals expression4 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface LessEqualsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessEqualsExpression3<C, L> {

    /**
     * less equals. 小于等于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L le4(Field name, N value) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le4(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L le4(Field name, N value, Predicate<N> ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L le4(String name, N value);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le4(String name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le4(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L le4(Field name, D value) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le4(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L le4(Field name, D value, Predicate<D> ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L le4(String name, D value);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le4(String name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le4(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L le4(Field name, LocalTime value) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le4(String name, LocalTime value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L le4(Field name, LocalDate value) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le4(String name, LocalDate value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L le4(Field name, LocalDateTime value) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le4(name.name(), value, ignoreStrategy);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le4(String name, LocalDateTime value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L le4(Field name, String value) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(Field name, String value, Predicate<String> ignoreStrategy) {
        return le4(name.name(), value);
    }

    /**
     * less equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le4(String name, String value);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * less equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(String name, String value, Predicate<String> ignoreStrategy);
}