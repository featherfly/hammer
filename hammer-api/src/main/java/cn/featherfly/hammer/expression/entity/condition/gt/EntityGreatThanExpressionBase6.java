
package cn.featherfly.hammer.expression.entity.condition.gt;

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
import cn.featherfly.hammer.expression.condition.gt.GreatThanSupplierExpression6;

/**
 * The Interface EntityGreatThanExpressionBase6.
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
public interface EntityGreatThanExpressionBase6<T, T2, T3, T4, T5, T6, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityGreatThanExpressionBase5<T, T2, T3, T4, T5, C, L>, GreatThanSupplierExpression6<C, L> {

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableToIntFunction<T6> name, int value);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableToIntFunction<T6> name, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableToLongFunction<T6> name, long value);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableToLongFunction<T6> name, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableToDoubleFunction<T6> name, double value);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt6(SerializableFunction<T6, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt6(SerializableFunction<T6, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt6(SerializableFunction<T6, E> name, E value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt6(SerializableFunction<T6, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt6(SerializableFunction<T6, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt6(SerializableFunction<T6, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt6(SerializableFunction<T6, String> name, String value) {
        return gt6(name, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt6(SerializableFunction<T6, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy);

    /**
     * great than. 大于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt6(SerializableFunction<T6, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}