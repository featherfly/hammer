
package cn.featherfly.hammer.expression.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not start with expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotStartWithExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotStartWithExpression5<C, L>, NotStartWithSupplierExpression6<C, L> {
    /**
     * not start with value. 不以value开始.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nsw6(Field field, String value) {
        return nsw6(field.name(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return nsw6(field.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(Field field, String value, Predicate<String> ignoreStrategy) {
        return nsw6(field.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L nsw6(Field field, String value, MatchStrategy matchStrategy) {
        return nsw6(field.name(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw6(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw6(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nsw6(String name, String value) {
        return nsw6(name, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(String name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(String name, String value, Predicate<String> ignoreStrategy) {
        return nsw6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw6(String name, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw6(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nsw6(AliasField field, String value) {
        return nsw6(field.getAliasOrName(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return nsw6(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return nsw6(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L nsw6(AliasField field, String value, MatchStrategy matchStrategy) {
        return nsw6(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw6(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw6(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw6(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}