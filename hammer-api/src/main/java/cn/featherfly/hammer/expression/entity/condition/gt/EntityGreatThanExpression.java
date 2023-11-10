
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
import cn.featherfly.hammer.expression.condition.gt.GreatThanSupplierExpression;

/**
 * The Interface EntityGreatThanExpression.
 *
 * @author zhongj
 * @param <T> the comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityGreatThanExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends GreatThanSupplierExpression<C, L> {

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(SerializableToIntFunction<T> name, int value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(SerializableToLongFunction<T> name, long value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(SerializableToDoubleFunction<T> name, double value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt(SerializableFunction<T, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(SerializableFunction<T, E> name, E value);

    /**
     * great than. 大于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt(SerializableFunction<T, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(SerializableFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(SerializableFunction<T, String> name, String value) {
        return gt(name, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(SerializableFunction<T, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy);

    /**
     * great than. 大于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(SerializableFunction<T, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}