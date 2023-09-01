
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;

/**
 * The Class EntityDateExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <D> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityDatePropertyExpressionImpl<E, D extends Date, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<E, D, SerializableFunction<E, D>, C, L>
        implements EntityDatePropertyExpression<E, D, C, L> {

    /**
     * Instantiates a new entity date property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EntityDatePropertyExpressionImpl(int index, SerializableFunction<E, D> name,
            AbstractMulitiEntityConditionExpression<C, L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value) {
        return expression.eq0(index, name, value, expression.getIgnoreStrategy());
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
        return expression.ne0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value) {
        return expression.in0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(D value) {
        return expression.nin0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value) {
        return expression.le0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value) {
        return expression.lt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value) {
        return expression.ge0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value) {
        return expression.gt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn0(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn0(index, name, value);
    }
}
