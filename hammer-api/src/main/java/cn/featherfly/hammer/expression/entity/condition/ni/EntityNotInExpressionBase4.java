
package cn.featherfly.hammer.expression.entity.condition.ni;

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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction4;
import cn.featherfly.common.function.serializable.SerializableToIntFunction4;
import cn.featherfly.common.function.serializable.SerializableToLongFunction4;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotInExpressionBase4.
 *
 * @author zhongj
 * @param <T>  the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotInExpressionBase4<T, T2, T3, T4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotInExpressionBase3<T, T2, T3, C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L ni4(SerializableFunction<T4, R> name, R value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ni4(SerializableFunction<T4, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return ni4(name, value, ignoreStrategy::test);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni4(SerializableFunction<T4, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni4(SerializableToIntFunction4<T4> name, int value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToIntFunction4<T4> name, int value, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni4(SerializableToLongFunction4<T4> name, long value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToLongFunction4<T4> name, long value, LongPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni4(SerializableToDoubleFunction<T4> name, double value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToDoubleFunction<T4> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L ni4(SerializableFunction<T4, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni4(SerializableToIntFunction4<T4> name, int... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni4(SerializableToLongFunction4<T4> name, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni4(SerializableToDoubleFunction4<T4> name, double... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni4(SerializableFunction<T4, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToIntFunction4<T4> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToLongFunction4<T4> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToDoubleFunction4<T4> name, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L ni4(SerializableFunction<T4, R> name, Collection<R> value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni4(SerializableFunction<T4, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni4(SerializableToStringFunction<T4> name, String value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToStringFunction<T4> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni4(SerializableToStringFunction<T4> name, String[] value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableToStringFunction<T4> name, String[] value, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <R> L ni4(SerializableSupplier<R> property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ni4(SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return ni4(property, ignoreStrategy::test);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni4(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ni4(SerializableIntSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ni4(SerializableLongSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ni4(SerializableDoubleSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni4(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}