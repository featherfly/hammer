
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;

/**
 * The Class RepositorySimpleStringExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityStringPropertyExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<E, String, SerializableFunction<E, String>, C, L>
        implements EntityStringPropertyExpression<E, C, L> {

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index                          the index
     * @param name                           the name
     * @param expression.getIgnoreStrategy() the ignore strategy
     * @param expression                     the expression
     */
    public EntityStringPropertyExpressionImpl(int index, SerializableFunction<E, String> name,
            AbstractMulitiEntityConditionExpression<C, L> expression) {
        super(index, name, expression);
    }

    /**
     * Instantiates a new type string expression.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     */
    public EntityStringPropertyExpressionImpl(int index, SerializableToStringFunction<E> name,
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
    public L eq(String value, MatchStrategy queryPolicy) {
        return expression.eq0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value) {
        return expression.in0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(String value) {
        return expression.nin0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value) {
        return expression.le0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {
        return expression.lt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {
        return expression.ge0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {
        return expression.gt0(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        return expression.isn0(index, name, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn0(index, name, null);
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
    public L ne(String value, MatchStrategy queryPolicy) {
        return expression.ne0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy queryPolicy) {
        return expression.sw0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy queryPolicy) {
        return expression.co0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy queryPolicy) {
        return expression.ew0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy queryPolicy) {
        return expression.lk0(index, name, value, queryPolicy, expression.getIgnoreStrategy());
    }
}
