
package cn.featherfly.hammer.expression.condition.type.property;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * The Class TypeNumberExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <N> the number type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityNumberPropertyExpressionImpl<E, N extends Number, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends AbstractEntityPropertyExpression<E, N, SerializableFunction<E, N>, C, L>
        implements EntityNumberPropertyExpression<E, N, C, L> {

    /**
     * Instantiates a new type number expression.
     *
     * @param name       the name
     * @param expression the expression
     */
    public EntityNumberPropertyExpressionImpl(SerializableFunction<E, N> name, EntityConditionsExpression<E, C, L> expression) {
        super(name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value) {
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
    public L ne(N value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(N value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value) {
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
    public L eq(N value, QueryPolicy queryPolicy) {
        return expression.eq(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, QueryPolicy queryPolicy) {
        return expression.ne(name, value, queryPolicy);
    }
}
