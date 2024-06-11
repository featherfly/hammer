
package cn.featherfly.hammer.expression.repository.condition.ni;

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
import cn.featherfly.hammer.expression.condition.ni.NotInExpression;
import cn.featherfly.hammer.expression.condition.ni.NotInSupplierExpression;

/**
 * repository not in expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends NotInExpression<C, L>, NotInSupplierExpression<C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni(SerializableToIntFunction<T> name, int... values) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ni(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToIntFunction<T> name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni(SerializableToLongFunction<T> name, long... values) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ni(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToLongFunction<T> name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni(SerializableToDoubleFunction<T> name, double... values) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ni(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToDoubleFunction<T> name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String... values) {
        return ni(name, values, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values, matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ni(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(name, new String[] { value }, matchStrategy, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R extends Serializable> L ni(SerializableFunction<T, R> name, R... values) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R extends Serializable> L ni(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, Lang.array(value), v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R extends Serializable> L ni(SerializableFunction<T, R> name, R[] values,
        Predicate<R[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ni(SerializableSupplier<R> property, R value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    @Override
    default <R extends Serializable> L ni(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ni(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    @Override
    default <R extends Serializable> L ni(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableIntSupplier property, int value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableIntSupplier property, int... value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableLongSupplier property, long value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableLongSupplier property, long... value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableDoubleSupplier property, double value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableDoubleSupplier property, double... value) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }
}