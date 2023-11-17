
package cn.featherfly.hammer.expression.condition.gt;

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
 * great than expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatThanExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatThanExpression4<C, L> {

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L gt5(Field name, N value) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt5(Field name, N value, IgnoreStrategy ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt5(Field name, N value, Predicate<N> ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt5(String name, N value);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt5(String name, N value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt5(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L gt5(Field name, D value) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt5(Field name, D value, IgnoreStrategy ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt5(Field name, D value, Predicate<D> ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt5(String name, D value);

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt5(String name, D value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt5(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt5(Field name, LocalTime value) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt5(String name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt5(Field name, LocalDate value) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt5(String name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt5(Field name, LocalDateTime value) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt5(name.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt5(String name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt5(Field name, String value) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt5(Field name, String value, Predicate<String> ignoreStrategy) {
        return gt5(name.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt5(String name, String value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, String value, IgnoreStrategy ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt5(String name, String value, Predicate<String> ignoreStrategy);
}