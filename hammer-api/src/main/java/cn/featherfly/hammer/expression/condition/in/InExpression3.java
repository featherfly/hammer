
package cn.featherfly.hammer.expression.condition.in;

import java.io.Serializable;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * in expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface InExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    L in3(String name, int... values);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(String name, int value, IntPredicate ignoreStrategy) {
        return in3(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in3(String name, int[] values, Predicate<int[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L in3(String name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(String name, long value, LongPredicate ignoreStrategy) {
        return in3(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in3(String name, long[] values, Predicate<long[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    L in3(String name, double... values);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(String name, double value, DoublePredicate ignoreStrategy) {
        return in3(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in3(String name, double[] values, Predicate<double[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default L in3(String name, String... values) {
        return in3(name, values, MatchStrategy.AUTO);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in3(String name, String[] values, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(String name, String value, Predicate<String> ignoreStrategy) {
        return in3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in3(name, new String[] { value }, matchStrategy, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(String name, String[] values, Predicate<String[]> ignoreStrategy) {
        return in3(name, values, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name the name
     * @param values the values
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in3(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L in3(String name, R value) {
        return in3(name, ArrayUtils.create(ClassUtils.getClass(value), 1, (index) -> value));
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    <R extends Serializable> L in3(String name, @SuppressWarnings("unchecked") R... values);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in3(String name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in3(String name, R[] value, Predicate<R[]> ignoreStrategy);

    // ******************************************************************************************************************************

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L in3(Field field, R value) {
        return in3(field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L in3(Field field, @SuppressWarnings("unchecked") R... values) {
        return in3(field.name(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in3(Field field, R value, Predicate<R> ignoreStrategy) {
        return in3(field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(Field field, int... values) {
        return in3(field.name(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, int value, IntPredicate ignoreStrategy) {
        return in3(field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, int[] values, Predicate<int[]> ignoreStrategy) {
        return in3(field.name(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(Field field, long... values) {
        return in3(field.name(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, long value, LongPredicate ignoreStrategy) {
        return in3(field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, long[] values, Predicate<long[]> ignoreStrategy) {
        return in3(field.name(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(Field field, double... values) {
        return in3(field.name(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, double value, DoublePredicate ignoreStrategy) {
        return in3(field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, double[] values, Predicate<double[]> ignoreStrategy) {
        return in3(field.name(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(Field field, String... values) {
        return in3(field.name(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L in3(Field field, String[] values, MatchStrategy matchStrategy) {
        return in3(field.name(), values, matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, String value, Predicate<String> ignoreStrategy) {
        return in3(field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, String[] values, Predicate<String[]> ignoreStrategy) {
        return in3(field.name(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(Field field, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in3(field.name(), values, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(AliasField field, int... values) {
        return in3(field.getAliasOrName(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, int value, IntPredicate ignoreStrategy) {
        return in3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, int[] values, Predicate<int[]> ignoreStrategy) {
        return in3(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(AliasField field, long... values) {
        return in3(field.getAliasOrName(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, long value, LongPredicate ignoreStrategy) {
        return in3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, long[] values, Predicate<long[]> ignoreStrategy) {
        return in3(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(AliasField field, double... values) {
        return in3(field.getAliasOrName(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, double value, DoublePredicate ignoreStrategy) {
        return in3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, double[] values, Predicate<double[]> ignoreStrategy) {
        return in3(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default L in3(AliasField field, String... values) {
        return in3(field.getAliasOrName(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, String[] values, MatchStrategy matchStrategy) {
        return in3(field.getAliasOrName(), values, matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return in3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, String[] values, Predicate<String[]> ignoreStrategy) {
        return in3(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param field the field
     * @param values the values
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in3(AliasField field, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in3(field.getAliasOrName(), values, matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L in3(AliasField field, R value) {
        return in3(field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param field the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L in3(AliasField field, @SuppressWarnings("unchecked") R... values) {
        return in3(field.getAliasOrName(), values);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in3(AliasField field, R value, Predicate<R> ignoreStrategy) {
        return in3(field.getAliasOrName(), value, ignoreStrategy);
    }
}