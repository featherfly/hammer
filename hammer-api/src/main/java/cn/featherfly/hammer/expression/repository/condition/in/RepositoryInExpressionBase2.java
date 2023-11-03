
package cn.featherfly.hammer.expression.repository.condition.in;

import java.io.Serializable;
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
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.in.InExpression2;

/**
 * repository in expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpressionBase2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryInExpression<C, L>, InExpression2<C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L in2(SerializableToIntFunction<T> name, int... values) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in2(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return in2(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
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
    default <T> L in2(SerializableToIntFunction<T> name, int[] values, Predicate<int[]> ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L in2(SerializableToLongFunction<T> name, long... values) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in2(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return in2(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
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
    default <T> L in2(SerializableToLongFunction<T> name, long[] values, Predicate<long[]> ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L in2(SerializableToDoubleFunction<T> name, double... values) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in2(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return in2(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
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
    default <T> L in2(SerializableToDoubleFunction<T> name, double[] values, Predicate<double[]> ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L in2(SerializableToStringFunction<T> name, String... values) {
        return in2(name, values, MatchStrategy.AUTO);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L in2(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values, matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in2(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return in2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in2(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return in2(name, new String[] { value }, matchStrategy, v -> ignoreStrategy.test(v[0]));
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
    default <T> L in2(SerializableToStringFunction<T> name, String[] values, Predicate<String[]> ignoreStrategy) {
        return in2(name, values, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param values         the values
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L in2(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>    the generic type
     * @param <R>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R extends Serializable> L in2(SerializableFunction<T, R> name, R... values) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R extends Serializable> L in2(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return in2(name, Lang.array(value), v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R extends Serializable> L in2(SerializableFunction<T, R> name, R[] values,
            Predicate<R[]> ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L in2(SerializableSupplier<R> property) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L in2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableIntSupplier property) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableLongSupplier property) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableDoubleSupplier property) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L in2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in2(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy, ignoreStrategy);
    }

}