
package cn.featherfly.hammer.expression.entity.condition.ge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction4;
import cn.featherfly.common.function.serializable.SerializableToIntFunction4;
import cn.featherfly.common.function.serializable.SerializableToLongFunction4;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsSupplierExpression4;

/**
 * The Interface EntityGreatEqualsExpressionBase4.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatEqualsExpressionBase4<T, T2, T3, T4, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityGreatEqualsExpressionBase3<T, T2, T3, C, L>, GreatEqualsSupplierExpression4<C, L> {

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(SerializableToIntFunction4<T4> name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(SerializableToIntFunction4<T4> name, int value, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(SerializableToLongFunction4<T4> name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(SerializableToLongFunction4<T4> name, long value, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(SerializableToDoubleFunction4<T4> name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(SerializableToDoubleFunction4<T4> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ge4(SerializableFunction<T4, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge4(SerializableFunction<T4, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge4(SerializableFunction<T4, E> name, E value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge4(SerializableFunction<T4, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ge4(SerializableFunction<T4, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge4(SerializableFunction<T4, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge4(SerializableFunction<T4, String> name, String value) {
        return ge4(name, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge4(SerializableFunction<T4, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}