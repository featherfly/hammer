
package cn.featherfly.hammer.expression.condition.property;

import java.util.Date;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * DateExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface DateExpression<D extends Date, C extends ConditionExpression, L extends LogicExpression<C, L>>
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
    default L eq(D value, MatchStrategy queryPolicy) {
        return eq(value);
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
    default L ne(D value, MatchStrategy queryPolicy) {
        return ne(value);
    }
}