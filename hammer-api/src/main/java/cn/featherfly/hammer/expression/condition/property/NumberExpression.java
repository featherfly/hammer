
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * NumberExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NumberExpression<N extends Number, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, N>, PropertyNotEqualsExpression<C, L, N>, PropertyInExpression<C, L, N>,
        PropertyNotInExpression<C, L, N>, PropertyLessEqualsExpressoin<C, L, N>, PropertyLessThanExpressoin<C, L, N>,
        PropertyGreatEqualsExpressoin<C, L, N>, PropertyGreatThanExpressoin<C, L, N>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(N value);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(N value, QueryPolicy queryPolicy) {
        return eq(value);
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
    default L ne(N value, QueryPolicy queryPolicy) {
        return ne(value);
    }
}