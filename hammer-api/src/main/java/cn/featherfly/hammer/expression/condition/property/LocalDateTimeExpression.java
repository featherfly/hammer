
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDateTime;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
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
        PropertyLessEqualsExpressoin<C, L, LocalDateTime>, PropertyLessThanExpressoin<C, L, LocalDateTime>,
        PropertyGreatEqualsExpressoin<C, L, LocalDateTime>, PropertyGreatThanExpressoin<C, L, LocalDateTime>,
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
    default L eq(LocalDateTime value, QueryPolicy queryPolicy) {
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
    default L ne(LocalDateTime value, QueryPolicy queryPolicy) {
        return ne(value);
    }
}