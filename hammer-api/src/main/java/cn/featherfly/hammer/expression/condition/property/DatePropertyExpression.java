
package cn.featherfly.hammer.expression.condition.property;

import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Date property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface DatePropertyExpression<D extends Date, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, D>, PropertyNotEqualsExpression<C, L, D>, PropertyInExpression<C, L, D>,
        PropertyNotInExpression<C, L, D>, PropertyLessEqualsExpression<C, L, D>, PropertyLessThanExpression<C, L, D>,
        PropertyGreatEqualsExpression<C, L, D>, PropertyGreatThanExpression<C, L, D>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {
    /**
     * {@inheritDoc}
     */
    @Override
    L eq(D value);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(D value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(D value, Predicate<D> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(D value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(D value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(D value, MatchStrategy matchStrategy, Predicate<D> ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(D value);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(D value, Predicate<D> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(D value, IgnoreStrategy ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(D value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return ne(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(D value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(D value, MatchStrategy matchStrategy, Predicate<D> ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }
}