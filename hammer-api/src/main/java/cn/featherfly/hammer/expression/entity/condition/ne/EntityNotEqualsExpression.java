
package cn.featherfly.hammer.expression.entity.condition.ne;

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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsSupplierExpression;

/**
 * The Interface EntityNotEqualsExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsSupplierExpression<C, L> {

    //    /**
    //     * not equals. 不等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L ne(Consumer<EntityEqualsExpression<E, C, L>> consumer);

    /**
     * not equals. 不等于.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L ne(SerializableFunction<T, R> name, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(SerializableToIntFunction<T> name, int value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(SerializableToLongFunction<T> name, long value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(SerializableToDoubleFunction<T> name, double value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ne(SerializableToNumberFunction<T, N> name, N value);

    /**
     * not equals. 不等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne(SerializableToEnumFunction<T, E> name, E value);

    /**
     * not equals. 不等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne(SerializableToEnumFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ne(SerializableToDateFunction<T, D> name, D value);

    /**
     * not equals. 不等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ne(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(SerializableToLocalTimeFunction<T> name, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(SerializableToLocalDateFunction<T> name, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ne(SerializableToStringFunction<T> name, String value) {
        return ne(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}