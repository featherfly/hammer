
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.DateFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityGenericPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * entity date property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <D> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityDatePropertyExpressionImpl<E, D extends Date, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends AbstractMulitiEntityGenericPropertyExpression<E, D, C, L>
    implements EntityDatePropertyExpression<D, C, L> {

    /**
     * Instantiates a new entity date property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityDatePropertyExpressionImpl(int index, SerializableFunction<E, D> name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity date property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityDatePropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value, Predicate<D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value, Predicate<D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value, Predicate<D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D[] value, Predicate<D[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<D> value, Predicate<Collection<D>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D value, Predicate<D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D[] value, Predicate<D[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<D> value, Predicate<Collection<D>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value, Predicate<D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value, Predicate<D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value, Predicate<D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value, Predicate<D> ignoreStrategy) {
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
    public L ba(D min, D max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(D min, D max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(D min, D max, BiPredicate<D, D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(D min, D max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(D min, D max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(D min, D max, BiPredicate<D, D> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getYear() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_YEAR,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getMonth() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_MONTH,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getDayOfMonth() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_DAY_OF_MONTH,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringFieldExpression<C, L> format(String format) {
        return new EntityStringPropertyExpressionImpl<>(index, propertyList, DateFunction.DATE_FORMAT,
            new Object[] { format }, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getWeekDay() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_WEEKDAY,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getWeekOfYear() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_WEEK_OF_YEAR,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getDayOfYear() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_DAY_OF_YEAR,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getQuarter() {
        return new EntityIntPropertyExpressionImpl<>(index, propertyList, DateFunction.GET_QUARTER,
            ArrayUtils.EMPTY_OBJECT_ARRAY, expression, factory, queryRelation);
    }
}
