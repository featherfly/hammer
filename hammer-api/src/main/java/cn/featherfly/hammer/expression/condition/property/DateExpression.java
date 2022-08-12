
package cn.featherfly.hammer.expression.condition.property;

import java.util.Date;

import cn.featherfly.common.repository.operate.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EqualsExpressoin.
 *
 * @author zhongj
 */
public interface DateExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, Date>, PropertyNotEqualsExpression<C, L, Date>,
        PropertyInExpression<C, L, Date>, PropertyNotInExpression<C, L, Date>, PropertyLessEqualsExpressoin<C, L, Date>,
        PropertyLessThanExpressoin<C, L, Date>, PropertyGreatEqualsExpressoin<C, L, Date>,
        PropertyGreatThanExpressoin<C, L, Date>, PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {
    /**
     * {@inheritDoc}
     */
    @Override
    L eq(Date value);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(Date value, QueryPolicy queryPolicy) {
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(Date value);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(Date value, QueryPolicy queryPolicy) {
        return ne(value);
    }
}