
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDateTime property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalDateTimeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, LocalDateTime>, PropertyNotEqualsExpression<C, L, LocalDateTime>,
        PropertyInExpression<C, L, LocalDateTime>, PropertyNotInExpression<C, L, LocalDateTime>,
        PropertyLessEqualsExpression<C, L, LocalDateTime>, PropertyLessThanExpression<C, L, LocalDateTime>,
        PropertyGreatEqualsExpression<C, L, LocalDateTime>, PropertyGreatThanExpression<C, L, LocalDateTime>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {
    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalDateTime value);

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalDateTime value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(LocalDateTime value, MatchStrategy matchStrategy, Predicate<LocalDateTime> ignoreStrategy) {
        // MatchStrategy only support for String
        return eq(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalDateTime value);

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalDateTime value, MatchStrategy matchStrategy) {
        // MatchStrategy only support for String
        return ne(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(LocalDateTime value, MatchStrategy matchStrategy, Predicate<LocalDateTime> ignoreStrategy) {
        // MatchStrategy only support for String
        return ne(value, ignoreStrategy);
    }
}