
package cn.featherfly.hammer.expression.entity.condition.in;

import java.io.Serializable;
import java.util.Collection;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.in.InSupplierExpression4;

/**
 * The Interface EntityInExpressionBase4.
 *
 * @author zhongj
 * @param <T> the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityInExpressionBase4<T, T2, T3, T4, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityInExpressionBase3<T, T2, T3, C, L>, InSupplierExpression4<C, L> {
    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in4(SerializableFunction<T4, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return in4(name, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableFunction<T4, R> name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableFunction<T4, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableToIntFunction<T4> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToIntFunction<T4> name, int value, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableToLongFunction<T4> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToLongFunction<T4> name, long value, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableToDoubleFunction<T4> name, double value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToDoubleFunction<T4> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableFunction<T4, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableToIntFunction<T4> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableToLongFunction<T4> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableToDoubleFunction<T4> name, double... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableFunction<T4, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToIntFunction<T4> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToLongFunction<T4> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToDoubleFunction<T4> name, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableFunction<T4, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableFunction<T4, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in4(SerializableToStringFunction<T4> name, String value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToStringFunction<T4> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in4(SerializableToStringFunction<T4> name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableToStringFunction<T4> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy);

}