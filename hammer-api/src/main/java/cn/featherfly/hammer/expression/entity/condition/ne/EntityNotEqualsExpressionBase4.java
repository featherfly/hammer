
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
import cn.featherfly.hammer.expression.condition.ne.NotEqualsSupplierExpression4;

/**
 * The Interface EntityNotEqualsExpressionBase4.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotEqualsExpressionBase4<T, T2, T3, T4, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityNotEqualsExpressionBase3<T, T2, T3, C, L>, NotEqualsSupplierExpression4<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L ne4(SerializableFunction<T4, R> name, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne4(SerializableFunction<T4, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne4(SerializableToIntFunction<T4> name, int value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne4(SerializableToIntFunction<T4> name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne4(SerializableToLongFunction<T4> name, long value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne4(SerializableToLongFunction<T4> name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne4(SerializableToDoubleFunction<T4> name, double value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne4(SerializableToDoubleFunction<T4> name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ne4(SerializableToNumberFunction<T4, N> name, N value);

    /**
     * not equals. 不等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne4(SerializableToNumberFunction<T4, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne4(SerializableToEnumFunction<T4, E> name, E value);

    /**
     * not equals. 不等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne4(SerializableToEnumFunction<T4, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ne4(SerializableToDateFunction<T4, D> name, D value);

    /**
     * not equals. 不等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ne4(SerializableToDateFunction<T4, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne4(SerializableToLocalTimeFunction<T4> name, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne4(SerializableToLocalTimeFunction<T4> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne4(SerializableToLocalDateFunction<T4> name, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne4(SerializableToLocalDateFunction<T4> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne4(SerializableToLocalDateTimeFunction<T4> name, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne4(SerializableToLocalDateTimeFunction<T4> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ne4(SerializableToStringFunction<T4> name, String value) {
        return ne4(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne4(SerializableToStringFunction<T4> name, String value, Predicate<String> ignoreStrategy) {
        return ne4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne4(SerializableToStringFunction<T4> name, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne4(SerializableToStringFunction<T4> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}