
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
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.DateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;
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
    public EntityLocalTimePropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
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
    public EntityLocalTimePropertyExpressionImpl(int index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
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
    public EntityLocalTimePropertyExpressionImpl(int index, SerializableToLocalTimeFunction<E> name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity local time property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityLocalTimePropertyExpressionImpl(int index, List<Serializable> propertyList,
        Function function, Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, function, argus, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity local time property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityLocalTimePropertyExpressionImpl(int index, Serializable name, Function function,
        Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, function, argus, expression, factory, queryRelation);
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
    public EntityLocalTimePropertyExpressionImpl(int index, Serializable name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalTime[] value, Predicate<LocalTime[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<LocalTime> value, Predicate<Collection<LocalTime>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalTime[] value, Predicate<LocalTime[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<LocalTime> value, Predicate<Collection<LocalTime>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
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
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalTime min, LocalTime max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringFieldExpression<C, L> format(String format) {
        return new EntityStringPropertyExpressionImpl<>(index, propertyList, DateFunction.TIME_FORMAT,
            new Object[] { format }, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getHour() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_HOUR,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getMinute() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_MINUTE,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getSecond() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_SECOND,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }
}
