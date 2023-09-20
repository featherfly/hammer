
package cn.featherfly.hammer.expression.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * StringNotBetweenExpression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface StringNotBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not between and.
     *
     * @param <N>  number type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <N extends Number> L nba(String name, N min, N max);

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L nba(String name, N min, N max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L nba(String name, N min, N max, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <D>  date type
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <D extends Date> L nba(String name, D min, D max);

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L nba(String name, D min, D max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L nba(String name, D min, D max, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalTime min, LocalTime max, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalDate min, LocalDate max, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalDateTime min, LocalDateTime max, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name 参数名称
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, String min, String max);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, String min, String max, IgnoreStrategy ignoreStrategy);

    /**
     * not between and.
     *
     * @param name           参数名称
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, String min, String max, Predicate<String> ignoreStrategy);
}