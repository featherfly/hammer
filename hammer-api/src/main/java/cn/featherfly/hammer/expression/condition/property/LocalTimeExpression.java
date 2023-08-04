
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalTime;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalTimeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalTimeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, LocalTime>, PropertyNotEqualsExpression<C, L, LocalTime>,
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
    default L eq(LocalTime value, QueryPolicy queryPolicy) {
        return eq(value);
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
    default L ne(LocalTime value, QueryPolicy queryPolicy) {
        return ne(value);
    }
}