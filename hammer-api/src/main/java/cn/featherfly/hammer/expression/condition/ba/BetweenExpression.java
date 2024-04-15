
package cn.featherfly.hammer.expression.condition.ba;

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
 * between and expression.
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface BetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * between and.
     *
     * @param <N>   number type
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <N extends Number> L ba(Field field, N min, N max) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(Field field, N min, N max, IgnoreStrategy ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(Field field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <N extends Number> L ba(String name, N min, N max);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <N extends Number> L ba(String name, N min, N max, IgnoreStrategy ignoreStrategy) {
        return ba(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ba(String name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <D>   date type
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <D extends Date> L ba(Field field, D min, D max) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(Field field, D min, D max, IgnoreStrategy ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(Field field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    <D extends Date> L ba(String name, D min, D max);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <D extends Date> L ba(String name, D min, D max, IgnoreStrategy ignoreStrategy) {
        return ba(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ba(String name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(Field field, LocalTime min, LocalTime max) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(String name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(String name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return ba(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(Field field, LocalDate min, LocalDate max) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(String name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(String name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return ba(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(Field field, LocalDateTime min, LocalDateTime max) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(String name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(String name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return ba(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(String name, LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(Field field, String min, String max) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(Field field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba(String name, String min, String max);

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(String name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(String name, String min, String max, BiPredicate<String, String> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <N>   number type
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <N extends Number> L ba(AliasField field, N min, N max) {
        return ba(field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(AliasField field, N min, N max, IgnoreStrategy ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(AliasField field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>   date type
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <D extends Date> L ba(AliasField field, D min, D max) {
        return ba(field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(AliasField field, D min, D max, IgnoreStrategy ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(AliasField field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalTime min, LocalTime max) {
        return ba(field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalDate min, LocalDate max) {
        return ba(field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalDateTime min, LocalDateTime max) {
        return ba(field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(AliasField field, String min, String max) {
        return ba(field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(AliasField field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(field.getAliasOrName(), min, max);
    }
}