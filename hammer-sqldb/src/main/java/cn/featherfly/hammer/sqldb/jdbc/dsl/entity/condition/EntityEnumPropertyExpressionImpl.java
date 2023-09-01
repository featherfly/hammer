
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;

/**
 * The Class TypeEnumExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <T> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityEnumPropertyExpressionImpl<E, T extends Enum<T>, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<E, T, SerializableFunction<E, T>, C, L>
        implements EntityEnumPropertyExpression<E, T, C, L> {

    /**
     * Instantiates a new entity enum property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EntityEnumPropertyExpressionImpl(int index, SerializableFunction<E, T> name,
            AbstractMulitiEntityConditionExpression<C, L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(T value) {
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
    public L ne(T value) {
        return expression.ne0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T value) {
        return expression.in0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(T value) {
        return expression.nin0(index, name, value, expression.getIgnoreStrategy());
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
