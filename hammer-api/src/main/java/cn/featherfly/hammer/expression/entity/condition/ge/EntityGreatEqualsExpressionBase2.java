
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction2;
import cn.featherfly.common.function.serializable.SerializableToIntFunction2;
import cn.featherfly.common.function.serializable.SerializableToLongFunction2;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsSupplierExpression2;

/**
 * The Interface EntityGreatEqualsExpressionBase2.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatEqualsExpressionBase2<T, T2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityGreatEqualsExpression<T, C, L>, GreatEqualsSupplierExpression2<C, L> {

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge2(SerializableToIntFunction2<T2> name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge2(SerializableToIntFunction2<T2> name, int value, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge2(SerializableToLongFunction2<T2> name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge2(SerializableToLongFunction2<T2> name, long value, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge2(SerializableToDoubleFunction2<T2> name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge2(SerializableToDoubleFunction2<T2> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ge2(SerializableFunction<T2, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge2(SerializableFunction<T2, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge2(SerializableFunction<T2, E> name, E value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge2(SerializableFunction<T2, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ge2(SerializableFunction<T2, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge2(SerializableFunction<T2, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge2(SerializableFunction<T2, String> name, String value) {
        return ge2(name, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge2(SerializableFunction<T2, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge2(SerializableFunction<T2, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}