
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsSupplierExpression6;

/**
 * The Interface EntityGreatEqualsExpressionBase6.
 *
 * @author zhongj
 * @param <T> the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <T5> the fifth comparable type
 * @param <T6> the sixth comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityGreatEqualsExpressionBase6<T, T2, T3, T4, T5, T6, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityGreatEqualsExpressionBase5<T, T2, T3, T4, T5, C, L>, GreatEqualsSupplierExpression6<C, L> {

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge6(SerializableToIntFunction<T6> name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge6(SerializableToIntFunction<T6> name, int value, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge6(SerializableToLongFunction<T6> name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge6(SerializableToLongFunction<T6> name, long value, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge6(SerializableToDoubleFunction<T6> name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ge6(SerializableFunction<T6, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge6(SerializableFunction<T6, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge6(SerializableFunction<T6, E> name, E value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge6(SerializableFunction<T6, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ge6(SerializableFunction<T6, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge6(SerializableFunction<T6, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge6(SerializableFunction<T6, String> name, String value) {
        return ge6(name, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge6(SerializableFunction<T6, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}