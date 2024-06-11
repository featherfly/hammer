
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDoublePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityIntPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLongPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityTypePropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityGenericPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * entity Type property expression implements.
 *
 * @author zhongj
 * @param <T> the entity type
 * @param <P> the property type
 * @param <F> the property
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityTypePropertyExpressionImpl<T, P, F extends SerializableFunction<T, P>, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractMulitiEntityGenericPropertyExpression<T, P, F, C, L>
    implements EntityTypePropertyExpression<P, C, L> {

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityTypePropertyExpressionImpl(int index, F name, InternalMulitiEntityCondition<L> expression,
        JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityTypePropertyExpressionImpl(int index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityTypePropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    // ****************************************************************************************************************
    //	property
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityIntPropertyExpression<C, L> property(SerializableToIntFunction<P> name) {
        propertyList.add(name);
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<C, L> property(SerializableToLongFunction<P> name) {
        propertyList.add(name);
        return new EntityLongPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<C, L> property(SerializableToDoubleFunction<P> name) {
        propertyList.add(name);
        return new EntityDoublePropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        V extends Number> EntityNumberPropertyExpression<V, C, L> property(SerializableToNumberFunction<P, V> name) {
        propertyList.add(name);
        return new EntityNumberPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V extends Date> EntityDatePropertyExpression<V, C, L> property(SerializableToDateFunction<P, V> name) {
        propertyList.add(name);
        return new EntityDatePropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<C, L> property(SerializableToStringFunction<P> name) {
        propertyList.add(name);
        return new EntityStringPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<C, L> property(SerializableToLocalDateFunction<P> name) {
        propertyList.add(name);
        return new EntityLocalDatePropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<C, L> property(SerializableToLocalDateTimeFunction<P> name) {
        propertyList.add(name);
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<C, L> property(SerializableToLocalTimeFunction<P> name) {
        propertyList.add(name);
        return new EntityLocalTimePropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V extends Enum<V>> EntityEnumPropertyExpression<V, C, L> property(SerializableToEnumFunction<P, V> name) {
        propertyList.add(name);
        return new EntityEnumPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<P, R> name) {
        propertyList.add(name);
        return new EntityTypePropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
        E> EntityTypePropertyExpression<E, C, L> property(SerializableToCollectionFunction<P, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    // ****************************************************************************************************************
    //  condition
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P value) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P value, Predicate<P> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P[] value) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(P[] value, Predicate<P[]> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<P> value, Predicate<Collection<P>> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P value) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P value, Predicate<P> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P[] value) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(P[] value, Predicate<P[]> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<P> value, Predicate<Collection<P>> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L le(P value) {
        return expression.le(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(P value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(P value, Predicate<P> ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L lt(P value) {
        return expression.lt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(P value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(P value, Predicate<P> ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L ge(P value) {
        return expression.ge(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(P value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(P value, Predicate<P> ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public L gt(P value) {
        return expression.gt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(P value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(P value, Predicate<P> ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.sw(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.sw(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        return expression.co(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.co(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.co(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        return expression.ew(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ew(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ew(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {
        return expression.lk(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.lk(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.lk(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, matchStrategy,
            ignoreStrategy);
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
    public L eq(P value) {
        return expression.eq(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(P value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(P value, Predicate<P> ignoreStrategy) {
        return expression.eq(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(P value) {
        return expression.ne(index, getPropertyMapping(value), arithmeticColumnElement.get(), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(P value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(P value, Predicate<P> ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), arithmeticColumnElement.get(), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(P min, P max) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(P min, P max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(P min, P max, BiPredicate<P, P> ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(P min, P max) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(P min, P max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(P min, P max, BiPredicate<P, P> ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), arithmeticColumnElement.get(), min, max,
            ignoreStrategy);
    }

}
