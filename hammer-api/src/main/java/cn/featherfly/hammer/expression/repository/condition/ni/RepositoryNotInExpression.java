
package cn.featherfly.hammer.expression.repository.condition.ni;

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
import cn.featherfly.hammer.expression.condition.ni.NotInExpression;

/**
 * repository not in expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotInExpression<C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <T> L ni(SerializableToIntFunction<T> name, int... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ni(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(SerializableToIntFunction<T> name, int[] values, Predicate<int[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <T> L ni(SerializableToLongFunction<T> name, long... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ni(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(SerializableToLongFunction<T> name, long[] values, Predicate<long[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>    the generic type
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <T> L ni(SerializableToDoubleFunction<T> name, double... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ni(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(SerializableToDoubleFunction<T> name, double[] values, Predicate<double[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String... values) {
        return ni(name, values, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <T> L ni(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ni(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
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
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni(SerializableToStringFunction<T> name, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    <T, R> L ni(SerializableFunction<T, R> name, R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R> L ni(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, Lang.array(value), v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, R> L ni(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy);
}