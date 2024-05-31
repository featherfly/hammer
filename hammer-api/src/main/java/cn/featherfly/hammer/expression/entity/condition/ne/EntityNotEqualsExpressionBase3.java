
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
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
import cn.featherfly.hammer.expression.condition.ne.NotEqualsSupplierExpression3;

/**
 * The Interface EntityNotEqualsExpressionBase3.
 *
 * @author zhongj
 * @param <T> the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpressionBase3<T, T2, T3, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityNotEqualsExpressionBase2<T, T2, C, L>, NotEqualsSupplierExpression3<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ne3(SerializableFunction<T3, R> name, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne3(SerializableFunction<T3, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return ne3(name, value, ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ne3(SerializableFunction<T3, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne3(SerializableToIntFunction<T3> name, int value);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableToIntFunction<T3> name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne3(SerializableToLongFunction<T3> name, long value);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableToLongFunction<T3> name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne3(SerializableToDoubleFunction<T3> name, double value);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableToDoubleFunction<T3> name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ne3(SerializableToNumberFunction<T3, N> name, N value);

    /**
     * not equals. 不等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne3(SerializableToNumberFunction<T3, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne3(SerializableToEnumFunction<T3, E> name, E value);

    /**
     * not equals. 不等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne3(SerializableToEnumFunction<T3, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ne3(SerializableToDateFunction<T3, D> name, D value);

    /**
     * not equals. 不等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ne3(SerializableToDateFunction<T3, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne3(SerializableToLocalTimeFunction<T3> name, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableToLocalTimeFunction<T3> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne3(SerializableToLocalDateFunction<T3> name, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableToLocalDateFunction<T3> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ne3(SerializableToLocalDateTimeFunction<T3> name, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableToLocalDateTimeFunction<T3> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ne3(SerializableToStringFunction<T3> name, String value) {
        return ne3(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableToStringFunction<T3> name, String value, Predicate<String> ignoreStrategy) {
        return ne3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne3(SerializableToStringFunction<T3> name, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne3(SerializableToStringFunction<T3> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne3(name, value, matchStrategy, ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne3(SerializableToStringFunction<T3> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}