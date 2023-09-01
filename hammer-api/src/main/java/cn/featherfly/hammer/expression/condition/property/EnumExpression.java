
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EnumExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EnumExpression<E extends Enum<E>, C extends ConditionExpression, L extends LogicExpression<C, L>>
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
    default L eq(E value, MatchStrategy queryPolicy) {
        return eq(value);
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
    default L ne(E value, MatchStrategy queryPolicy) {
        return ne(value);
    }
}