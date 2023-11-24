
package cn.featherfly.hammer.expression.condition.ba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface BetweenExpression4.
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface BetweenExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends BetweenExpression3<C, L> {

    /**
     * between and.
     *
     * @param <N>  number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <N extends Number> L ba4(Field name, N min, N max) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba4(Field name, N min, N max, IgnoreStrategy ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba4(Field name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
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
    <N extends Number> L ba4(String name, N min, N max);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <N extends Number> L ba4(String name, N min, N max, IgnoreStrategy ignoreStrategy) {
        return ba2(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ba4(String name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param <D>  date type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default <D extends Date> L ba4(Field name, D min, D max) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba4(Field name, D min, D max, IgnoreStrategy ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba4(Field name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
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
    <D extends Date> L ba4(String name, D min, D max);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <D extends Date> L ba4(String name, D min, D max, IgnoreStrategy ignoreStrategy) {
        return ba2(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ba4(String name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba4(Field name, LocalTime min, LocalTime max) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba4(String name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(String name, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return ba2(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba4(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba4(Field name, LocalDate min, LocalDate max) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba4(String name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(String name, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return ba2(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba4(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba4(Field name, LocalDateTime min, LocalDateTime max) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba4(name.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba4(String name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(String name, LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return ba2(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba4(String name, LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    default L ba4(Field name, String min, String max) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(Field name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba4(name.name(), min, max);
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return LogicExpression
     */
    L ba4(String name, String min, String max);

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba4(String name, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba2(name, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba4(String name, String min, String max, BiPredicate<String, String> ignoreStrategy);
}