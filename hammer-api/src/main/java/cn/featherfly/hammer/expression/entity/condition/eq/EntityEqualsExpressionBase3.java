
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
import cn.featherfly.hammer.expression.condition.eq.EqualsSupplierExpression3;

/**
 * The Interface EntityEqualsExpressionBase3.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityEqualsExpressionBase3<T, T2, T3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityEqualsExpressionBase2<T, T2, C, L>, EqualsSupplierExpression3<C, L> {

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L eq3(SerializableFunction<T3, R> name, R value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq3(SerializableFunction<T3, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq3(SerializableToCharFunction<T3> name, char value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToCharFunction<T3> name, char value, CharPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq3(SerializableToIntFunction<T3> name, int value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToIntFunction<T3> name, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq3(SerializableToLongFunction<T3> name, long value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToLongFunction<T3> name, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq3(SerializableToDoubleFunction<T3> name, double value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToDoubleFunction<T3> name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L eq3(SerializableToNumberFunction<T3, N> name, N value);

    /**
     * equals. 等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L eq3(SerializableToNumberFunction<T3, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq3(SerializableToEnumFunction<T3, E> name, E value);

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq3(SerializableToEnumFunction<T3, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L eq3(SerializableToDateFunction<T3, D> name, D value);

    /**
     * equals. 等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L eq3(SerializableToDateFunction<T3, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq3(SerializableToLocalTimeFunction<T3> name, LocalTime value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToLocalTimeFunction<T3> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq3(SerializableToLocalDateFunction<T3> name, LocalDate value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToLocalDateFunction<T3> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq3(SerializableToLocalDateTimeFunction<T3> name, LocalDateTime value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToLocalDateTimeFunction<T3> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L eq3(SerializableToStringFunction<T3> name, String value) {
        return eq3(name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq3(SerializableToStringFunction<T3> name, String value, Predicate<String> ignoreStrategy) {
        return eq3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq3(SerializableToStringFunction<T3> name, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq3(SerializableToStringFunction<T3> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}