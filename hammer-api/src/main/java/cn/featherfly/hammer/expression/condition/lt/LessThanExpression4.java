
package cn.featherfly.hammer.expression.condition.lt;

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
 * less than expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LessThanExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessThanExpression3<C, L> {

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L lt4(Field name, N value) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt4(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt4(Field name, N value, Predicate<N> ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt4(String name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt4(String name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt4(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L lt4(Field name, D value) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt4(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt4(Field name, D value, Predicate<D> ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt4(String name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt4(String name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt4(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt4(Field name, LocalTime value) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(String name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt4(Field name, LocalDate value) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(String name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt4(Field name, LocalDateTime value) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt4(name.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(String name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt4(Field name, String value) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(Field name, String value, Predicate<String> ignoreStrategy) {
        return lt4(name.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(String name, String value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(String name, String value, Predicate<String> ignoreStrategy);

}