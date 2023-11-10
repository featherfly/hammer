
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.Collection;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction6;
import cn.featherfly.common.function.serializable.SerializableToIntFunction6;
import cn.featherfly.common.function.serializable.SerializableToLongFunction6;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityInExpressionBase5.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <T5> the fifth comparable type
 * @param <T6> the sixth comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityInExpressionBase6<T, T2, T3, T4, T5, T6, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityInExpressionBase5<T, T2, T3, T4, T5, C, L> {
    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in6(SerializableFunction<T6, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return in6(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L in6(SerializableFunction<T6, R> name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in6(SerializableFunction<T6, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in6(SerializableToIntFunction6<T6> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToIntFunction6<T6> name, int value, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in6(SerializableToLongFunction6<T6> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToLongFunction6<T6> name, long value, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in6(SerializableToDoubleFunction<T6> name, double value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToDoubleFunction<T6> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L in6(SerializableFunction<T6, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in6(SerializableToIntFunction6<T6> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in6(SerializableToLongFunction6<T6> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in6(SerializableToDoubleFunction6<T6> name, double... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in6(SerializableFunction<T6, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToIntFunction6<T6> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToLongFunction6<T6> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToDoubleFunction6<T6> name, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L in6(SerializableFunction<T6, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in6(SerializableFunction<T6, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToStringFunction<T6> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in6(SerializableToStringFunction<T6> name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableToStringFunction<T6> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <R> L in6(SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in6(SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return in6(property, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L in6(SerializableIntSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L in6(SerializableLongSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L in6(SerializableDoubleSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in6(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in6(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}