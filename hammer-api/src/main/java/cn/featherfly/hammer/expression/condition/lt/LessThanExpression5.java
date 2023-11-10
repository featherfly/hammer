
package cn.featherfly.hammer.expression.condition.lt;

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
 * less than expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LessThanExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessThanExpression4<C, L>, LessThanSupplierExpression5<C, L> {
    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(String name, int value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(String name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(String name, long value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(String name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(String name, double value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt5(String name, E value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt5(String name, E value, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, (Predicate<E>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt5(String name, E value, Predicate<E> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt5(String name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt5(String name, N value, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, (Predicate<N>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt5(String name, N value, Predicate<N> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt5(String name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt5(String name, D value, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, (Predicate<D>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt5(String name, D value, Predicate<D> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(String name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, (Predicate<LocalTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(String name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, (Predicate<LocalDate>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(String name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, (Predicate<LocalDateTime>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    // **************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(String name, String value) {
        return lt5(name, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lt5(String name, String value, MatchStrategy matchStrategy);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(String name, String value, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(String name, String value, Predicate<String> ignoreStrategy) {
        return lt5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lt5(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ****************************************************************************************************************************

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(Field field, int value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, int value, IntPredicate ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(Field field, long value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, long value, LongPredicate ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(Field field, double value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, double value, DoublePredicate ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt5(Field field, E value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt5(Field field, E value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt5(Field field, E value, Predicate<E> ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L lt5(Field field, N value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt5(Field field, N value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt5(Field field, N value, Predicate<N> ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L lt5(Field field, D value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt5(Field field, D value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt5(Field field, D value, Predicate<D> ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(Field field, LocalTime value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(Field field, LocalDate value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(Field field, LocalDateTime value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(Field field, String value) {
        return lt5(field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lt5(Field field, String value, MatchStrategy matchStrategy) {
        return lt5(field.name(), value, matchStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, String value, Predicate<String> ignoreStrategy) {
        return lt5(field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lt5(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt5(field.name(), value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, int value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, int value, IntPredicate ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, long value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, long value, LongPredicate ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, double value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, double value, DoublePredicate ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt5(AliasField field, E value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt5(AliasField field, E value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt5(AliasField field, E value, Predicate<E> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L lt5(AliasField field, N value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt5(AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt5(AliasField field, N value, Predicate<N> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L lt5(AliasField field, D value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt5(AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt5(AliasField field, D value, Predicate<D> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalTime value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalDate value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalDateTime value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, String value) {
        return lt5(field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(AliasField field, String value, MatchStrategy matchStrategy) {
        return lt5(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt5(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}