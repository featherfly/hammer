
package cn.featherfly.hammer.expression.condition.property;

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
public interface StringPropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, String>, PropertyNotBetweenExpression<C, L, String> //
        , PropertyEqualsExpression<C, L, String>, PropertyNotEqualsExpression<C, L, String>,
        PropertyInExpression<C, L, String>, PropertyNotInExpression<C, L, String>,
        PropertyLessEqualsExpression<C, L, String>, PropertyLessThanExpression<C, L, String>,
        PropertyGreatEqualsExpression<C, L, String>, PropertyGreatThanExpression<C, L, String>,
        PropertyStartWithExpression<C, L>, PropertyNotStartWithExpression<C, L>//
        , PropertyContainsExpression<C, L>, PropertyNotContainsExpression<C, L>//
        , PropertyEndWithExpression<C, L>, PropertyNotEndWithExpression<C, L>//
        , PropertyLikeExpression<C, L>, PropertyNotLikeExpression<C, L>//
        , PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

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
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param value          参数值
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
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne(String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}