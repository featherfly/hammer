
package cn.featherfly.hammer.expression.condition.type.property;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * The Class TypeEnumExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class TypeEnumExpression<E, C extends EntityConditionsExpression<E, C, L>, L extends LogicExpression<C, L>>
        extends AbstractTypeExpression<E, Enum<?>, SerializableFunction<E, Enum<?>>, C, L>
        implements EnumExpression<C, L> {

    /**
     * Instantiates a new type date expression.
     *
     * @param property   the property
     * @param expression the expression
     */
    public TypeEnumExpression(SerializableFunction<E, Enum<?>> property,
            EntityConditionsExpression<E, C, L> expression) {
        super(property, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Enum<?> value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Enum<?> value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Enum<?> value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Enum<?> value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        return expression.isn(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Enum<?> value, QueryPolicy queryPolicy) {
        return expression.eq(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Enum<?> value, QueryPolicy queryPolicy) {
        return expression.ne(name, value, queryPolicy);
    }
}
