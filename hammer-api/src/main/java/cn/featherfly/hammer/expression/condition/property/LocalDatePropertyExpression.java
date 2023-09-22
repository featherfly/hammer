
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDate property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalDatePropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, LocalDate>, PropertyNotBetweenExpression<C, L, LocalDate> //
        , PropertyEqualsExpression<C, L, LocalDate>, PropertyNotEqualsExpression<C, L, LocalDate>,
        PropertyInExpression<C, L, LocalDate>, PropertyNotInExpression<C, L, LocalDate>,
        PropertyLessEqualsExpression<C, L, LocalDate>, PropertyLessThanExpression<C, L, LocalDate>,
        PropertyGreatEqualsExpression<C, L, LocalDate>, PropertyGreatThanExpression<C, L, LocalDate>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {
    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalDate value);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalDate value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalDate value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalDate value, MatchStrategy matchStrategy, Predicate<LocalDate> ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalDate value);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalDate value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalDate value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return ne(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalDate value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalDate value, MatchStrategy matchStrategy, Predicate<LocalDate> ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }
}