
package cn.featherfly.hammer.expression.condition.property;

import java.util.Date;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
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
        PropertyNotInExpression<C, L, D>, PropertyLessEqualsExpressoin<C, L, D>, PropertyLessThanExpressoin<C, L, D>,
        PropertyGreatEqualsExpressoin<C, L, D>, PropertyGreatThanExpressoin<C, L, D>, PropertyIsNullExpression<C, L>,
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
    default L eq(D value, QueryPolicy queryPolicy) {
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
    default L ne(D value, QueryPolicy queryPolicy) {
        return ne(value);
    }
}