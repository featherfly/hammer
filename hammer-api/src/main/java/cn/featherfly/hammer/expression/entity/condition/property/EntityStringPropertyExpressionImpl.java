
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsExpression;

/**
 * The Class RepositorySimpleStringExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityStringPropertyExpressionImpl<E, C extends EntityConditionsExpression<E, C, L>, L extends LogicExpression<C, L>>
        extends AbstractEntityPropertyExpression<E, String, SerializableFunction<E, String>, C, L>
        implements EntityStringPropertyExpression<E, C, L> {

    /**
     * Instantiates a new type string expression.
     *
     * @param name       the name
     * @param expression the expression
     */
    public EntityStringPropertyExpressionImpl(SerializableFunction<E, String> name, EntityConditionsExpression<E, C, L> expression) {
        super(name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value) {
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
    public L ne(String value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String value) {
        return expression.nin(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {
        return expression.gt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value) {
        return expression.sw(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value) {
        return expression.co(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value) {
        return expression.ew(name, value);
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
    public L eq(String value, QueryPolicy queryPolicy) {
        return expression.eq(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, QueryPolicy queryPolicy) {
        return expression.ne(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, QueryPolicy queryPolicy) {
        return expression.sw(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, QueryPolicy queryPolicy) {
        return expression.co(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, QueryPolicy queryPolicy) {
        return expression.ew(name, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, QueryPolicy queryPolicy) {
        return expression.lk(name, value, queryPolicy);
    }
}
