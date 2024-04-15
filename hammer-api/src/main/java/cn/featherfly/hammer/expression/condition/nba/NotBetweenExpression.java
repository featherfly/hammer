
package cn.featherfly.hammer.expression.condition.nba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not between and expression .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface NotBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not between and.
     *
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <N extends Number> L nba(Field name, N min, N max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(Field name, N min, N max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(Field name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <N extends Number> L nba(String name, N min, N max);

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <N extends Number> L nba(String name, N min, N max, IgnoreStrategy ignoreStrategy) {
        return nba(name, min, max, (i, a) -> ignoreStrategy.test(Lang.array(i, a)));
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L nba(String name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <D extends Date> L nba(Field name, D min, D max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(Field name, D min, D max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(Field name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <D extends Date> L nba(String name, D min, D max);

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <D extends Date> L nba(String name, D min, D max, IgnoreStrategy ignoreStrategy) {
        return nba(name, min, max, (i, a) -> ignoreStrategy.test(Lang.array(i, a)));
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L nba(String name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, LocalTime min, LocalTime max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(String name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return nba(name, min, max, (i, a) -> ignoreStrategy.test(Lang.array(i, a)));
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, LocalDate min, LocalDate max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(String name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return nba(name, min, max, (i, a) -> ignoreStrategy.test(Lang.array(i, a)));
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, LocalDateTime min, LocalDateTime max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(name.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(String name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return nba(name, min, max, (i, a) -> ignoreStrategy.test(Lang.array(i, a)));
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L nba(Field name, String min, String max) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(Field name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(name.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L nba(String name, String min, String max);

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(String name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return nba(name, min, max, (i, a) -> ignoreStrategy.test(Lang.array(i, a)));
    }

    /**
     * not between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(String name, String min, String max, BiPredicate<String, String> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * not between and.
     *
     * @param <N>   number type
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <N extends Number> L nba(AliasField field, N min, N max) {
        return nba(field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(AliasField field, N min, N max, IgnoreStrategy ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(AliasField field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>   date type
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <D extends Date> L nba(AliasField field, D min, D max) {
        return nba(field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(AliasField field, D min, D max, IgnoreStrategy ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(AliasField field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalTime min, LocalTime max) {
        return nba(field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalDate min, LocalDate max) {
        return nba(field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalDateTime min, LocalDateTime max) {
        return nba(field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(AliasField field, String min, String max) {
        return nba(field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, String min, String max, IgnoreStrategy ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(AliasField field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(field.getAliasOrName(), min, max);
    }
}