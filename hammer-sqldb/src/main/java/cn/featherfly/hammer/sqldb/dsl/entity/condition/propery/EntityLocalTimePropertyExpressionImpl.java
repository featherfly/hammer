
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Collection;
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
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityGenericPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * entity LocalTime property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityLocalTimePropertyExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiEntityGenericPropertyExpression<E, LocalTime, SerializableFunction<E, LocalTime>, C, L>
    implements EntityLocalTimePropertyExpression<C, L> {

    /**
     * Instantiates a new entity local time property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityLocalTimePropertyExpressionImpl(int index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity local time property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityLocalTimePropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity local time property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityLocalTimePropertyExpressionImpl(int index, SerializableFunction<E, LocalTime> name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalTime value) {
        return expression.eq(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.eq(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value) {
        return expression.ne(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime[] value) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime[] value, Predicate<LocalTime[]> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<LocalTime> value, Predicate<Collection<LocalTime>> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime value) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime[] value) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime[] value, Predicate<LocalTime[]> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<LocalTime> value, Predicate<Collection<LocalTime>> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value) {
        return expression.le(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value) {
        return expression.lt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value) {
        return expression.ge(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value) {
        return expression.gt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalTime min, LocalTime max) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalTime min, LocalTime max) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

}
