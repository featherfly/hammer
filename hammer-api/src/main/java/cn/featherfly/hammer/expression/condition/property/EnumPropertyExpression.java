
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Enum property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EnumPropertyExpression<E extends Enum<E>, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, E>, PropertyNotEqualsExpression<C, L, E>, PropertyInExpression<C, L, E>,
        PropertyNotInExpression<C, L, E>, PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(E value);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(E value, Predicate<E> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(E value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(E value, MatchStrategy matchStrategy, Predicate<E> ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(E value);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(E value, Predicate<E> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(E value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return ne(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(E value, MatchStrategy matchStrategy, Predicate<E> ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }
}