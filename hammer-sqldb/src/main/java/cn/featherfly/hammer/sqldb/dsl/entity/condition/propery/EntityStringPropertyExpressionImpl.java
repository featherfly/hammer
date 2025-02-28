
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityGenericPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * entity String property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityStringPropertyExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiEntityGenericPropertyExpression<E, String, C, L>
    implements EntityStringPropertyExpression<C, L> {

    /**
     * Instantiates a new entity int property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(int index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(int index, List<Serializable> propertyList,
        Function function, Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, function, argus, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList, Function function,
        Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, function, argus, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(int index, SerializableToStringFunction<E> name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(int index, SerializableToStringFunction<E> name,
        Function function, Object[] argus, InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, function, argus, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.co(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.co(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.co(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, getColumnElement(pm), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ew(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ew(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ew(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ge(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.gt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, Predicate<String[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<String> value, Predicate<Collection<String>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.in(index, pm, getColumnElement(pm), value, ignoreStrategy);
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
    public L isn(Boolean value) {
        return expression.isn(index, getPropertyMapping(value), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.le(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lk(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lk(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lk(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.lt(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ne(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, Predicate<String[]> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<String> value, Predicate<Collection<String>> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.ni(index, pm, getColumnElement(pm), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.sw(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.sw(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.sw(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.ba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(Lang.ifNull(min, max));
        return expression.nba(index, pm, getColumnElement(pm), min, max,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nsw(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nsw(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nsw(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nco(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nco(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nco(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.newv(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.newv(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.newv(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nl(index, pm, getColumnElement(pm), value, matchStrategy,
            expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nl(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.nl(index, pm, getColumnElement(pm), value, matchStrategy,
            ignoreStrategy);
    }

}
