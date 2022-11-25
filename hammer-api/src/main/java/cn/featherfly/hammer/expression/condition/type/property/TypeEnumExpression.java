
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
public class TypeEnumExpression<E, T extends Enum<?>, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends AbstractTypeExpression<E, T, SerializableFunction<E, T>, C, L>
        implements EnumExpression<T, C, L> {

    /**
     * Instantiates a new type date expression.
     *
     * @param property   the property
     * @param expression the expression
     */
    public TypeEnumExpression(SerializableFunction<E, T> property, EntityConditionsExpression<E, C, L> expression) {
        super(property, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(T value) {
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
    public L ne(T value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(T value) {
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
    public L eq(T value, QueryPolicy queryPolicy) {
        return expression.eq(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(T value, QueryPolicy queryPolicy) {
        return expression.ne(name, value, queryPolicy);
    }
}
