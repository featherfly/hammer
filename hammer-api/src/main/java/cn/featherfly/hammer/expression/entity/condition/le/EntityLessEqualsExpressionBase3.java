
package cn.featherfly.hammer.expression.entity.condition.le;

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
import cn.featherfly.hammer.expression.condition.le.LessEqualsSupplierExpression3;

/**
 * The Interface EntityLessEqualsExpressionBase3.
 *
 * @author zhongj
 * @param <T> the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLessEqualsExpressionBase3<T, T2, T3, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityLessEqualsExpressionBase2<T, T2, C, L>, LessEqualsSupplierExpression3<C, L> {

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le3(SerializableToIntFunction<T3> name, int value);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableToIntFunction<T3> name, int value, IntPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le3(SerializableToLongFunction<T3> name, long value);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableToLongFunction<T3> name, long value, LongPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le3(SerializableToDoubleFunction<T3> name, double value);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableToDoubleFunction<T3> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L le3(SerializableFunction<T3, N> name, N value);

    /**
     * less and equals. 小于等于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le3(SerializableFunction<T3, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L le3(SerializableFunction<T3, E> name, E value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L le3(SerializableFunction<T3, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L le3(SerializableFunction<T3, D> name, D value);

    /**
     * less and equals. 小于等于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le3(SerializableFunction<T3, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, LocalTime> name, LocalTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, LocalDate> name, LocalDate value);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, LocalDateTime> name, LocalDateTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L le3(SerializableFunction<T3, String> name, String value) {
        return le3(name, value, MatchStrategy.AUTO);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le3(SerializableFunction<T3, String> name, String value, Predicate<String> ignoreStrategy) {
        return le3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, String> name, String value, MatchStrategy matchStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le3(SerializableFunction<T3, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}