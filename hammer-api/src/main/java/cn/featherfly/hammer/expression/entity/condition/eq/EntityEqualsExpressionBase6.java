
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCharFunction;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsSupplierExpression6;

/**
 * The Interface EntityEqualsExpressionBase6.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <T5> the fifth comparable type
 * @param <T6> the sixth comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityEqualsExpressionBase6<T, T2, T3, T4, T5, T6, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityEqualsExpressionBase5<T, T2, T3, T4, T5, C, L>, EqualsSupplierExpression6<C, L> {

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L eq6(SerializableFunction<T6, R> name, R value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq6(SerializableFunction<T6, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq6(SerializableToCharFunction<T6> name, char value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToCharFunction<T6> name, char value, CharPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq6(SerializableToIntFunction<T6> name, int value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToIntFunction<T6> name, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq6(SerializableToLongFunction<T6> name, long value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToLongFunction<T6> name, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq6(SerializableToDoubleFunction<T6> name, double value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L eq6(SerializableToNumberFunction<T6, N> name, N value);

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L eq6(SerializableToNumberFunction<T6, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq6(SerializableToEnumFunction<T6, E> name, E value);

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq6(SerializableToEnumFunction<T6, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L eq6(SerializableToDateFunction<T6, D> name, D value);

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L eq6(SerializableToDateFunction<T6, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq6(SerializableToLocalTimeFunction<T6> name, LocalTime value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToLocalTimeFunction<T6> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq6(SerializableToLocalDateFunction<T6> name, LocalDate value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToLocalDateFunction<T6> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToLocalDateTimeFunction<T6> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L eq6(SerializableToStringFunction<T6> name, String value) {
        return eq6(name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq6(SerializableToStringFunction<T6> name, String value, Predicate<String> ignoreStrategy) {
        return eq6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}