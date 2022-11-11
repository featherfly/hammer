
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EnumExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EnumExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, Enum<?>>, PropertyNotEqualsExpression<C, L, Enum<?>>,
        PropertyInExpression<C, L, Enum<?>>, PropertyNotInExpression<C, L, Enum<?>>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {

    /**
     * {@inheritDoc}
     */
    @Override
    L eq(Enum<?> value);

    /**
     * {@inheritDoc}
     */
    @Override
    default L eq(Enum<?> value, QueryPolicy queryPolicy) {
        return eq(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    L ne(Enum<?> value);

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(Enum<?> value, QueryPolicy queryPolicy) {
        return ne(value);
    }
}