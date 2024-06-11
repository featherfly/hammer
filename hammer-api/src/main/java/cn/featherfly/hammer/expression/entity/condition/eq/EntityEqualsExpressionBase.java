
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.io.Serializable;
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
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsSupplierExpression;

/**
 * The Interface EntityEqualsExpression.
 *
 * @author zhongj
 * @param <T> the first comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEqualsExpressionBase<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EqualsSupplierExpression<C, L> {

    // 和 <R extends Serializable> L eq(Consumer<Tuple2<EqualsEntityExpression<E>, EqualsEntityExpression<E2>>> equalsEntityExpressions)冲突了
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L eq(Consumer<EntityEqualsExpression<E, C, L>> consumer);

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L eq(SerializableFunction<T, R> name, R value);

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(SerializableFunction<T, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return eq(name, value, ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L eq(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableToCharFunction<T> name, char value);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToCharFunction<T> name, char value, CharPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableToIntFunction<T> name, int value);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableToLongFunction<T> name, long value);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableToDoubleFunction<T> name, double value);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L eq(SerializableToNumberFunction<T, N> name, N value);

    /**
     * equals. 等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L eq(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(SerializableToEnumFunction<T, E> name, E value);

    /**
     * equals. 等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L eq(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L eq(SerializableToDateFunction<T, D> name, D value);

    /**
     * equals. 等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L eq(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L eq(SerializableToStringFunction<T> name, String value) {
        return eq(name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return eq(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return eq(name, value, matchStrategy, ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}