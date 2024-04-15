
package cn.featherfly.hammer.expression.condition.gt;

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
 * great than expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, int value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, long value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, double value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(String name, E value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(String name, E value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(String name, E value, Predicate<E> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt(String name, N value);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(String name, N value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt(String name, D value);

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(String name, D value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(String name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(String name, String value) {
        return gt(name, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L gt(String name, String value, MatchStrategy matchStrategy);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, String value, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, String value, Predicate<String> ignoreStrategy) {
        return gt(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return gt(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ****************************************************************************************************************************

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field field, int value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, int value, IntPredicate ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field field, long value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, long value, LongPredicate ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field field, double value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, double value, DoublePredicate ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(Field field, E value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(Field field, E value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(Field field, E value, Predicate<E> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field field, N value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field field, N value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(Field field, N value, Predicate<N> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field field, D value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field field, D value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(Field field, D value, Predicate<D> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field field, LocalTime value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field field, LocalDate value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field field, LocalDateTime value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(Field field, String value) {
        return gt(field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L gt(Field field, String value, MatchStrategy matchStrategy) {
        return gt(field.name(), value, matchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, String value, Predicate<String> ignoreStrategy) {
        return gt(field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return gt(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(field.name(), value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, int value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, int value, IntPredicate ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, long value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, long value, LongPredicate ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, double value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, double value, DoublePredicate ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(AliasField field, E value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(AliasField field, E value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(AliasField field, E value, Predicate<E> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L gt(AliasField field, N value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(AliasField field, N value, Predicate<N> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L gt(AliasField field, D value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(AliasField field, D value, Predicate<D> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalTime value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDate value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDateTime value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, String value) {
        return gt(field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(AliasField field, String value, MatchStrategy matchStrategy) {
        return gt(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return gt(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}