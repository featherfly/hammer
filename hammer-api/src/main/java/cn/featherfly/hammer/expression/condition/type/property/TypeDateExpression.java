
package cn.featherfly.hammer.expression.condition.type.property;

import java.util.Date;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * The Class TypeDateExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class TypeDateExpression<E, D extends Date, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends AbstractTypeExpression<E, D, SerializableFunction<E, D>, C, L>
        implements DateExpression<D, C, L> {

    /**
     * Instantiates a new type date expression.
     *
     * @param property   the property
     * @param expression the expression
     */
    public TypeDateExpression(SerializableFunction<E, D> property, EntityConditionsExpression<E, C, L> expression) {
        super(property, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value) {
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
    public L ne(D value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(D value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value) {
        return expression.gt(name, value);
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
    public L eq(D value, QueryPolicy queryPolicy) {
        return expression.eq(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value, QueryPolicy queryPolicy) {
        return expression.ne(name, value, queryPolicy);
    }
}
