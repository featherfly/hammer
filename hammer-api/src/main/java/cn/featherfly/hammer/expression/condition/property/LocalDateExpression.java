
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDate;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDateExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalDateExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, LocalDate>, PropertyNotEqualsExpression<C, L, LocalDate>,
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
    default L eq(LocalDate value, QueryPolicy queryPolicy) {
        return eq(value);
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
    default L ne(LocalDate value, QueryPolicy queryPolicy) {
        return ne(value);
    }
}