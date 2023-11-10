
package cn.featherfly.hammer.expression.repository.condition.in;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.in.InExpression;

/**
 * RepositoryInExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends InExpression<C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <T> L in(SerializableToIntFunction<T> name, int... values);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return in(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(SerializableToIntFunction<T> name, int[] values, Predicate<int[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <T> L in(SerializableToLongFunction<T> name, long... values);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return in(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(SerializableToLongFunction<T> name, long[] values, Predicate<long[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <T> L in(SerializableToDoubleFunction<T> name, double... values);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return in(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(SerializableToDoubleFunction<T> name, double[] values, Predicate<double[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L in(SerializableToStringFunction<T> name, String... values) {
        return in(name, values, MatchStrategy.AUTO);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name          the name
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <T> L in(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return in(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return in(name, new String[] { value }, matchStrategy, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in(SerializableToStringFunction<T> name, String[] values, Predicate<String[]> ignoreStrategy) {
        return in(name, values, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           the name
     * @param values         the values
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    <T, R> L in(SerializableFunction<T, R> name, R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R> L in(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return in(name, Lang.array(value), v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, R> L in(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy);
}