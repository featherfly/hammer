
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.time.LocalTime;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;

/**
 * The Class TypeLocalTimeExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityLocalTimePropertyExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<E, LocalTime, SerializableFunction<E, LocalTime>, C, L>
        implements EntityLocalTimePropertyExpression<E, C, L> {

    /**
     * Instantiates a new entity local time property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EntityLocalTimePropertyExpressionImpl(int index, SerializableFunction<E, LocalTime> name,
            AbstractMulitiEntityConditionExpression<C, L> expression) {
        super(index, name, expression);
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
    public L eq(LocalTime value) {
        return expression.eq0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value) {
        return expression.ne0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value) {
        return expression.in0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(LocalTime value) {
        return expression.nin0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value) {
        return expression.le0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value) {
        return expression.lt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value) {
        return expression.ge0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value) {
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
