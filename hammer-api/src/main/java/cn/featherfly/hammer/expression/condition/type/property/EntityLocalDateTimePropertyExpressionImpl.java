
package cn.featherfly.hammer.expression.condition.type.property;

import java.time.LocalDateTime;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * The Class TypeLocalDateTimeExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityLocalDateTimePropertyExpressionImpl<E, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>>
        extends AbstractEntityPropertyExpression<E, LocalDateTime, SerializableFunction<E, LocalDateTime>, C, L>
        implements EntityLocalDateTimePropertyExpression<E, C, L> {

    /**
     * Instantiates a new type date expression.
     *
     * @param property   the property
     * @param expression the expression
     */
    public EntityLocalDateTimePropertyExpressionImpl(SerializableFunction<E, LocalDateTime> property,
            EntityConditionsExpression<E, C, L> expression) {
        super(property, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value) {
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
    public L ne(LocalDateTime value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(LocalDateTime value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value) {
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
    public L eq(LocalDateTime value, QueryPolicy queryPolicy) {
        return expression.eq(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value, QueryPolicy queryPolicy) {
        return expression.ne(name, value, queryPolicy);
    }
}
