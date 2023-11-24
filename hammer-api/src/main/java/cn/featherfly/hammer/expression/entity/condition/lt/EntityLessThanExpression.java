
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
import cn.featherfly.hammer.expression.condition.lt.LessThanSupplierExpression;

/**
 * The Interface EntityLessThanExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLessThanExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LessThanSupplierExpression<C, L> {

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(SerializableToIntFunction<T> name, int value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(SerializableToLongFunction<T> name, long value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(SerializableToDoubleFunction<T> name, double value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableFunction<T, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt(SerializableFunction<T, E> name, E value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableFunction<T, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt(SerializableFunction<T, String> name, String value) {
        return lt(name, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(SerializableFunction<T, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy);

    /**
     * less than. 小于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}