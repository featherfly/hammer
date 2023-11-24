
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction4;
import cn.featherfly.common.function.serializable.SerializableToIntFunction4;
import cn.featherfly.common.function.serializable.SerializableToLongFunction4;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lt.LessThanSupplierExpression4;

/**
 * The Interface EntityLessThanExpressionBase4.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessThanExpressionBase4<T, T2, T3, T4, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityLessThanExpressionBase3<T, T2, T3, C, L>, LessThanSupplierExpression4<C, L> {

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(SerializableToIntFunction4<T4> name, int value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(SerializableToIntFunction4<T4> name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(SerializableToLongFunction4<T4> name, long value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(SerializableToLongFunction4<T4> name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(SerializableToDoubleFunction4<T4> name, double value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(SerializableToDoubleFunction4<T4> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt4(SerializableFunction<T4, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt4(SerializableFunction<T4, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt4(SerializableFunction<T4, E> name, E value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt4(SerializableFunction<T4, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt4(SerializableFunction<T4, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt4(SerializableFunction<T4, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt4(SerializableFunction<T4, String> name, String value) {
        return lt4(name, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt4(SerializableFunction<T4, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}