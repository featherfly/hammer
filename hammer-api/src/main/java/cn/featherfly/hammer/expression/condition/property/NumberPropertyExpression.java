
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * number property expression..
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NumberPropertyExpression<N extends Number, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, N>, PropertyNotBetweenExpression<C, L, N> //
        , PropertyEqualsExpression<C, L, N>, PropertyNotEqualsExpression<C, L, N> //
        , PropertyInExpression<C, L, N>, PropertyNotInExpression<C, L, N> //
        , PropertyLessEqualsExpression<C, L, N>, PropertyLessThanExpression<C, L, N> //
        , PropertyGreatEqualsExpression<C, L, N>, PropertyGreatThanExpression<C, L, N> //
        , PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {
    /**
     * {@inheritDoc}
     */
    @Override
    L eq(N value);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(N value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(N value, Predicate<N> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(N value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(N value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(N value, MatchStrategy matchStrategy, Predicate<N> ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(N value);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(N value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(N value, Predicate<N> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(N value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return ne(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(N value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(N value, MatchStrategy matchStrategy, Predicate<N> ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }
}