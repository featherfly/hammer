
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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not in expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotInExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotInExpression5<C, L>, NotInSupplierExpression6<C, L> {
    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    L ni6(String name, int... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(String name, int value, IntPredicate ignoreStrategy) {
        return ni6(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni6(String name, int[] values, Predicate<int[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ni6(String name, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(String name, long value, LongPredicate ignoreStrategy) {
        return ni6(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni6(String name, long[] values, Predicate<long[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    L ni6(String name, double... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(String name, double value, DoublePredicate ignoreStrategy) {
        return ni6(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni6(String name, double[] values, Predicate<double[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(String name, String... values) {
        return ni6(name, values, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni6(String name, String[] values, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(String name, String value, Predicate<String> ignoreStrategy) {
        return ni6(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default L ni6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni6(name, new String[] { value }, matchStrategy, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(String name, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni6(name, values, MatchStrategy.AUTO, ignoreStrategy);
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
    L ni6(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni6(Field field, R value) {
        return ni6(field.name(), value);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni6(Field field, @SuppressWarnings("unchecked") R... values) {
        return ni6(field.name(), values);
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
    default <R extends Serializable> L ni6(Field field, R value, Predicate<R> ignoreStrategy) {
        return ni6(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L ni6(String name, R value) {
        return ni6(name, ArrayUtils.create(ClassUtils.getClass(value), 1, (index) -> value));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name   the name
     * @param values the values
     * @return LogicExpression
     */
    <R extends Serializable> L ni6(String name, @SuppressWarnings("unchecked") R... values);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni6(String name, R value, Predicate<R> ignoreStrategy);

    // ******************************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(Field field, int... values) {
        return ni6(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, int value, IntPredicate ignoreStrategy) {
        return ni6(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni6(field.name(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(Field field, long... values) {
        return ni6(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, long value, LongPredicate ignoreStrategy) {
        return ni6(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni6(field.name(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(Field field, double... values) {
        return ni6(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, double value, DoublePredicate ignoreStrategy) {
        return ni6(field.name(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni6(field.name(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(Field field, String... values) {
        return ni6(field.name(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field         the field
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni6(Field field, String[] values, MatchStrategy matchStrategy) {
        return ni6(field.name(), values, matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, String value, Predicate<String> ignoreStrategy) {
        return ni6(field.name(), value, ignoreStrategy);
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
    default L ni6(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni6(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(Field field, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni6(field.name(), values, ignoreStrategy);
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
    default L ni6(Field field, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni6(field.name(), values, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(AliasField field, int... values) {
        return ni6(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, int value, IntPredicate ignoreStrategy) {
        return ni6(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni6(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(AliasField field, long... values) {
        return ni6(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, long value, LongPredicate ignoreStrategy) {
        return ni6(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni6(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(AliasField field, double... values) {
        return ni6(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, double value, DoublePredicate ignoreStrategy) {
        return ni6(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni6(field.getAliasOrName(), values, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default L ni6(AliasField field, String... values) {
        return ni6(field.getAliasOrName(), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field         the field
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, String[] values, MatchStrategy matchStrategy) {
        return ni6(field.getAliasOrName(), values, matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ni6(field.getAliasOrName(), value, ignoreStrategy);
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
    default L ni6(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni6(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni6(AliasField field, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni6(field.getAliasOrName(), values, ignoreStrategy);
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
    default L ni6(AliasField field, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni6(field.getAliasOrName(), values, matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni6(AliasField field, R value) {
        return ni6(field.getAliasOrName(), value);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param field  the field
     * @param values the values
     * @return LogicExpression
     */
    default <R extends Serializable> L ni6(AliasField field, @SuppressWarnings("unchecked") R... values) {
        return ni6(field.getAliasOrName(), values);
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
    default <R extends Serializable> L ni6(AliasField field, R value, Predicate<R> ignoreStrategy) {
        return ni6(field.getAliasOrName(), value, ignoreStrategy);
    }
}