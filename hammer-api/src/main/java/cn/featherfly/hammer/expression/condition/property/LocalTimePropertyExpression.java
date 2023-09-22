
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalTime;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalTime property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalTimePropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, LocalTime>, PropertyNotBetweenExpression<C, L, LocalTime> // 
        , PropertyEqualsExpression<C, L, LocalTime>, PropertyNotEqualsExpression<C, L, LocalTime>,
        PropertyInExpression<C, L, LocalTime>, PropertyNotInExpression<C, L, LocalTime>,
        PropertyLessEqualsExpression<C, L, LocalTime>, PropertyLessThanExpression<C, L, LocalTime>,
        PropertyGreatEqualsExpression<C, L, LocalTime>, PropertyGreatThanExpression<C, L, LocalTime>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalTime value);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalTime value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalTime value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalTime value, MatchStrategy matchStrategy, Predicate<LocalTime> ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalTime value);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalTime value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalTime value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return ne(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalTime value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalTime value, MatchStrategy matchStrategy, Predicate<LocalTime> ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }
}