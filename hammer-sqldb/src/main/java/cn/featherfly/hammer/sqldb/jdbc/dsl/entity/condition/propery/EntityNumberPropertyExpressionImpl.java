
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.AbstractMulitiEntityGenericPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

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
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityNumberPropertyExpressionImpl(int index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity number property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityNumberPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity number property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityNumberPropertyExpressionImpl(int index, SerializableFunction<E, N> name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value) {
        return expression.in(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N value, Predicate<N> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value) {
        return expression.in(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value) {
        return expression.ni(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N value, Predicate<N> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value) {
        return expression.ni(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(N[] value, Predicate<N[]> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value) {
        return expression.le(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(N value, Predicate<N> ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value) {
        return expression.lt(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(N value, Predicate<N> ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value) {
        return expression.ge(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(N value, Predicate<N> ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value) {
        return expression.gt(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(N value, Predicate<N> ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(index, getPropertyMapping(value), value);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public L eq(FieldExpression expr) {
    //        return expression.eq(index, getPropertyMapping(expr), expr, expression.getIgnoreStrategy());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value) {
        return expression.eq(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(N value, Predicate<N> ignoreStrategy) {
        return expression.eq(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value) {
        return expression.ne(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(N value, Predicate<N> ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max) {
        return expression.ba(index, getPropertyMapping(Lang.pick(min, max)), min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max) {
        return expression.nba(index, getPropertyMapping(Lang.pick(min, max)), min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.pick(min, max)), min, max, ignoreStrategy);
    }

}
