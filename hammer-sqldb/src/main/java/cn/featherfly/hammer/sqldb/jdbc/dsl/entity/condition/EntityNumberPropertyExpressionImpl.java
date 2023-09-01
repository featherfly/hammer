
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;

/**
 * The Class TypeNumberExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <N> the number type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityNumberPropertyExpressionImpl<E, N extends Number, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<E, N, SerializableFunction<E, N>, C, L>
        implements EntityNumberPropertyExpression<E, N, C, L> {

    /**
     * Instantiates a new entity number property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EntityNumberPropertyExpressionImpl(int index, SerializableFunction<E, N> name,
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
    public L in(N value) {
        return expression.in0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(N value) {
        return expression.nin0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value) {
        return expression.le0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value) {
        return expression.lt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value) {
        return expression.ge0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, MatchStrategy queryPolicy) {
        return expression.eq0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, MatchStrategy queryPolicy) {
        return expression.ne0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }
}
