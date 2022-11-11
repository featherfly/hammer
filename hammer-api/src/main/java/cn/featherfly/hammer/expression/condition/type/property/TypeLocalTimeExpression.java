
package cn.featherfly.hammer.expression.condition.type.property;

import java.time.LocalTime;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.LocalTimeExpression;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * The Class TypeLocalTimeExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class TypeLocalTimeExpression<E, C extends EntityConditionsExpression<E, C, L>, L extends LogicExpression<C, L>>
        extends AbstractTypeExpression<E, LocalTime, SerializableFunction<E, LocalTime>, C, L>
        implements LocalTimeExpression<C, L> {

    /**
     * Instantiates a new type date expression.
     *
     * @param property   the property
     * @param expression the expression
     */
    public TypeLocalTimeExpression(SerializableFunction<E, LocalTime> property,
            EntityConditionsExpression<E, C, L> expression) {
        super(property, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalTime value) {
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
    public L ne(LocalTime value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(LocalTime value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value) {
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
    public L eq(LocalTime value, QueryPolicy queryPolicy) {
        return expression.eq(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value, QueryPolicy queryPolicy) {
        return expression.ne(name, value, queryPolicy);
    }
}
