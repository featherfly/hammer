
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * String property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends FieldBetweenExpression<C, L, String>, FieldNotBetweenExpression<C, L, String> //
        , FieldEqualsExpression<C, L, String>, FieldNotEqualsExpression<C, L, String>, FieldInExpression<C, L, String>,
        FieldNotInExpression<C, L, String>, FieldLessEqualsExpression<C, L, String>,
        FiledLessThanExpression<C, L, String>, FieldGreatEqualsExpression<C, L, String>,
        FieldGreatThanExpression<C, L, String>, FieldStartWithExpression<C, L>, FieldNotStartWithExpression<C, L>//
        , FieldContainsExpression<C, L>, FieldNotContainsExpression<C, L>//
        , FieldEndWithExpression<C, L>, FieldNotEndWithExpression<C, L>//
        , FieldLikeExpression<C, L>, FieldNotLikeExpression<C, L>//
        , FieldIsNullExpression<C, L>, FieldIsNotNullExpression<C, L> {

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(String value) {
        return eq(value, MatchStrategy.AUTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(String value, IgnoreStrategy ignoreStrategy) {
        return eq(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(String value, Predicate<String> ignoreStrategy) {
        return eq(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(String value) {
        return ne(value, MatchStrategy.AUTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(String value, IgnoreStrategy ignoreStrategy) {
        return ne(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(String value, Predicate<String> ignoreStrategy) {
        return ne(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne(String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}