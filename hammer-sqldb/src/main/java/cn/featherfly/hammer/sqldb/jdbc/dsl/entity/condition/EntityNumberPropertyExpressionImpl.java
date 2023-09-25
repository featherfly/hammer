
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;

/**
 * entity number property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <N> the number type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityNumberPropertyExpressionImpl<E, N extends Number, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityGenericPropertyExpression<E, N, SerializableFunction<E, N>, C, L>
        implements EntityNumberPropertyExpression<E, N, C, L> {

    /**
     * Instantiates a new entity number property expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    public EntityNumberPropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, propertyList, expression, factory);
    }

    /**
     * Instantiates a new entity number property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     * @param factory    the factory
     */
    public EntityNumberPropertyExpressionImpl(int index, SerializableFunction<E, N> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, name, expression, factory);
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
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value, Predicate<N> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value) {
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value, Predicate<N> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value) {
        return expression.le0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, IgnoreStrategy ignoreStrategy) {
        return expression.le0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, Predicate<N> ignoreStrategy) {
        return expression.le0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value) {
        return expression.lt0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, IgnoreStrategy ignoreStrategy) {
        return expression.lt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, Predicate<N> ignoreStrategy) {
        return expression.lt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value) {
        return expression.ge0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ge0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, Predicate<N> ignoreStrategy) {
        return expression.ge0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value) {
        return expression.gt0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, IgnoreStrategy ignoreStrategy) {
        return expression.gt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, Predicate<N> ignoreStrategy) {
        return expression.gt0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn0(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn0(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value) {
        return expression.eq0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, IgnoreStrategy ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, Predicate<N> ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value) {
        return expression.ne0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, Predicate<N> ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, IgnoreStrategy ignoreStrategy) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return expression.ba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max,
                expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, IgnoreStrategy ignoreStrategy) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return expression.nba0(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

}
