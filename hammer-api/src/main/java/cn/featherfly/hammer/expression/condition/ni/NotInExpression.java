
package cn.featherfly.hammer.expression.condition.ni;

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
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not in expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends NotInSupplierExpression<C, L> {
    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    L ni(String name, int... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(String name, int value, IntPredicate ignoreStrategy) {
        return ni(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(String name, int[] values, Predicate<int[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni(String name, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(String name, long value, LongPredicate ignoreStrategy) {
        return ni(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(String name, long[] values, Predicate<long[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    L ni(String name, double... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(String name, double value, DoublePredicate ignoreStrategy) {
        return ni(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(String name, double[] values, Predicate<double[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default L ni(String name, String... values) {
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
    L ni(String name, String[] values, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(String name, String value, Predicate<String> ignoreStrategy) {
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
    default L ni(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
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
    default L ni(String name, String[] values, Predicate<String[]> ignoreStrategy) {
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
    L ni(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(String name, R value) {
        return ni(name, ArrayUtils.create(ClassUtils.getClass(value), 1, (index) -> value));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <R extends Serializable> L ni(String name, @SuppressWarnings("unchecked") R... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(String name, R value, IgnoreStrategy ignoreStrategy) {
        return ni(name, value, ignoreStrategy::test);
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
    <R extends Serializable> L ni(String name, R value, Predicate<R> ignoreStrategy);

    // ******************************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(Field field, int... values) {
        return ni(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, int value, IntPredicate ignoreStrategy) {
        return ni(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(field.name(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(Field field, long... values) {
        return ni(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, long value, LongPredicate ignoreStrategy) {
        return ni(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(field.name(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(Field field, double... values) {
        return ni(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, double value, DoublePredicate ignoreStrategy) {
        return ni(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(field.name(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(Field field, String... values) {
        return ni(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field         the field
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni(Field field, String[] values, MatchStrategy matchStrategy) {
        return ni(field.name(), values, matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, String value, Predicate<String> ignoreStrategy) {
        return ni(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni(field.name(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(Field field, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(field.name(), values, matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(Field field, R value) {
        return ni(field.name(), value);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(Field field, @SuppressWarnings("unchecked") R... values) {
        return ni(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(Field field, R value, IgnoreStrategy ignoreStrategy) {
        return ni(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(Field field, R value, Predicate<R> ignoreStrategy) {
        return ni(field.name(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(AliasField field, int... values) {
        return ni(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, int value, IntPredicate ignoreStrategy) {
        return ni(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(AliasField field, long... values) {
        return ni(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, long value, LongPredicate ignoreStrategy) {
        return ni(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(AliasField field, double... values) {
        return ni(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, double value, DoublePredicate ignoreStrategy) {
        return ni(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni(AliasField field, String... values) {
        return ni(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field         the field
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, String[] values, MatchStrategy matchStrategy) {
        return ni(field.getAliasOrName(), values, matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ni(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(AliasField field, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(field.getAliasOrName(), values, matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(AliasField field, R value) {
        return ni(field.getAliasOrName(), value);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(AliasField field, @SuppressWarnings("unchecked") R... values) {
        return ni(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(AliasField field, R value, IgnoreStrategy ignoreStrategy) {
        return ni(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(AliasField field, R value, Predicate<R> ignoreStrategy) {
        return ni(field.getAliasOrName(), value, ignoreStrategy);
    }
}