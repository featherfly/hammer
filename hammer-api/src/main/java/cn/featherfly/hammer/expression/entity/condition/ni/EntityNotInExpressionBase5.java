
package cn.featherfly.hammer.expression.entity.condition.ni;

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
import cn.featherfly.hammer.expression.condition.ni.NotInSupplierExpression5;

/**
 * The Interface EntityNotInExpressionBase5.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotInExpressionBase5<T, T2, T3, T4, T5, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends EntityNotInExpressionBase4<T, T2, T3, T4, C, L>, NotInSupplierExpression5<C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableFunction<T5, R> name, R value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni5(SerializableFunction<T5, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return ni5(name, value, ignoreStrategy::test);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableFunction<T5, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableToIntFunction<T5> name, int value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToIntFunction<T5> name, int value, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableToLongFunction<T5> name, long value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToLongFunction<T5> name, long value, LongPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableToDoubleFunction<T5> name, double value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToDoubleFunction<T5> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableFunction<T5, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableToIntFunction<T5> name, int... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableToLongFunction<T5> name, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableToDoubleFunction<T5> name, double... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableFunction<T5, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToIntFunction<T5> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToLongFunction<T5> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToDoubleFunction<T5> name, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableFunction<T5, R> name, Collection<R> value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableFunction<T5, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni5(SerializableToStringFunction<T5> name, String value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToStringFunction<T5> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni5(SerializableToStringFunction<T5> name, String[] value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableToStringFunction<T5> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy);

}