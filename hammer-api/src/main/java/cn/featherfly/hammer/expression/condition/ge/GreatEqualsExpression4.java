
package cn.featherfly.hammer.expression.condition.ge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * great equals expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatEqualsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(String name, int value);

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(String name, int value, IntPredicate ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(String name, long value);

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(String name, long value, LongPredicate ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(String name, double value);

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param <E>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge4(String name, E value);

    /**
     * great equals. 大于等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge4(String name, E value, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge4(String name, E value, Predicate<E> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ge4(String name, N value);

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge4(String name, N value, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge4(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ge4(String name, D value);

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge4(String name, D value, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge4(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(String name, LocalTime value);

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(String name, LocalDate value);

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(String name, LocalDateTime value);

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(String name, String value) {
        return ge4(name, value, MatchStrategy.AUTO);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ge4(String name, String value, MatchStrategy matchStrategy);

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(String name, String value, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(String name, String value, Predicate<String> ignoreStrategy) {
        return ge4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ge4(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * great equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ****************************************************************************************************************************

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(Field field, int value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, int value, IntPredicate ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(Field field, long value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, long value, LongPredicate ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(Field field, double value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, double value, DoublePredicate ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <E>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge4(Field field, E value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge4(Field field, E value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge4(Field field, E value, Predicate<E> ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ge4(Field field, N value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge4(Field field, N value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge4(Field field, N value, Predicate<N> ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ge4(Field field, D value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge4(Field field, D value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge4(Field field, D value, Predicate<D> ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(Field field, LocalTime value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(Field field, LocalDate value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(Field field, LocalDateTime value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(Field field, String value) {
        return ge4(field.name(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ge4(Field field, String value, MatchStrategy matchStrategy) {
        return ge4(field.name(), value, matchStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, String value, Predicate<String> ignoreStrategy) {
        return ge4(field.name(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ge4(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge4(field.name(), value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(AliasField field, int value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, int value, IntPredicate ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(AliasField field, long value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, long value, LongPredicate ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(AliasField field, double value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, double value, DoublePredicate ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <E>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge4(AliasField field, E value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge4(AliasField field, E value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge4(AliasField field, E value, Predicate<E> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ge4(AliasField field, N value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge4(AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge4(AliasField field, N value, Predicate<N> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ge4(AliasField field, D value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge4(AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge4(AliasField field, D value, Predicate<D> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalTime value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalDate value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalDateTime value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(AliasField field, String value) {
        return ge4(field.getAliasOrName(), value);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, String value, MatchStrategy matchStrategy) {
        return ge4(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * great equals. 大于等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge4(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}