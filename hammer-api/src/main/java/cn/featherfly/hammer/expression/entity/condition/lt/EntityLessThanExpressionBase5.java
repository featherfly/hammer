
package cn.featherfly.hammer.expression.entity.condition.lt;

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
import cn.featherfly.hammer.expression.condition.lt.LessThanSupplierExpression5;

/**
 * The Interface EntityLessThanExpressionBase5.
 *
 * @author zhongj
 * @param <T> the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <T5> the fifth comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLessThanExpressionBase5<T, T2, T3, T4, T5, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityLessThanExpressionBase4<T, T2, T3, T4, C, L>, LessThanSupplierExpression5<C, L> {

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(SerializableToIntFunction<T5> name, int value);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableToIntFunction<T5> name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(SerializableToLongFunction<T5> name, long value);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableToLongFunction<T5> name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(SerializableToDoubleFunction<T5> name, double value);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableToDoubleFunction<T5> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt5(SerializableFunction<T5, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt5(SerializableFunction<T5, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt5(SerializableFunction<T5, E> name, E value);

    /**
     * less than. 小于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt5(SerializableFunction<T5, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt5(SerializableFunction<T5, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt5(SerializableFunction<T5, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt5(SerializableFunction<T5, String> name, String value) {
        return lt5(name, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt5(SerializableFunction<T5, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, String> name, String value, MatchStrategy matchStrategy);

    /**
     * less than. 小于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<T5, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}