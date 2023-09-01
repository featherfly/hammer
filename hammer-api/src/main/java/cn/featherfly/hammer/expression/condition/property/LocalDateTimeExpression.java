
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDateTime;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDateTimeExpression.
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
    default L eq(LocalDateTime value, MatchStrategy queryPolicy) {
        return eq(value);
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
    default L ne(LocalDateTime value, MatchStrategy queryPolicy) {
        return ne(value);
    }
}