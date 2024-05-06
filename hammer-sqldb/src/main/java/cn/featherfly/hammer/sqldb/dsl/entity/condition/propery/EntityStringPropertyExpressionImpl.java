
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
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
        extends AbstractMulitiEntityGenericPropertyExpression<E, String, SerializableFunction<E, String>, C, L>
        implements EntityStringPropertyExpression<E, C, L> {

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
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
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
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
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(int index, SerializableFunction<E, String> name,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity string property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityStringPropertyExpressionImpl(int index, SerializableToStringFunction<E> name,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        return expression.co(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.co(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.co(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, value, matchStrategy, expression.getIgnoreStrategy());
        //        return expression.eq(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, value, matchStrategy, ignoreStrategy);
        //        return expression.eq(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        PropertyMapping<?> pm = getPropertyMapping(value);
        return expression.eq(index, pm, value, matchStrategy, ignoreStrategy);
        //        return expression.eq(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        return expression.ew(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ew(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ew(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {
        return expression.ge(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, Predicate<String> ignoreStrategy) {
        return expression.ge(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {
        return expression.gt(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, Predicate<String> ignoreStrategy) {
        return expression.gt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value) {
        return expression.in(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, Predicate<String> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value) {
        return expression.in(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, Predicate<String[]> ignoreStrategy) {
        return expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
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
        return expression.le(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, Predicate<String> ignoreStrategy) {
        return expression.le(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {
        return expression.lk(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.lk(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.lk(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {
        return expression.lt(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, Predicate<String> ignoreStrategy) {
        return expression.lt(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy) {
        return expression.ne(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ne(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value) {
        return expression.ni(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, Predicate<String> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value) {
        return expression.ni(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, Predicate<String[]> ignoreStrategy) {
        return expression.ni(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.sw(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.sw(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), min, max,
                expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return expression.ba(index, getPropertyMapping(Lang.ifNull(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), min, max,
                expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return expression.nba(index, getPropertyMapping(Lang.ifNull(min, max)), min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy) {
        return expression.nsw(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nsw(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nsw(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy) {
        return expression.nco(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nco(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nco(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy) {
        return expression.newv(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.newv(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.newv(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy) {
        return expression.nl(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nl(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nl(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

}
