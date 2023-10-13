
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * entity enum property expression implements.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <T> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityEnumPropertyExpressionImpl<E, T extends Enum<T>, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityGenericPropertyExpression<E, T, SerializableFunction<E, T>, C, L>
        implements EntityEnumPropertyExpression<E, T, C, L> {

    /**
     * Instantiates a new entity enum property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityEnumPropertyExpressionImpl(int index, SerializableFunction<E, T> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity enum property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityEnumPropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity enum property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityEnumPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(T value) {
        return expression.eq0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(T value, IgnoreStrategy ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(T value, Predicate<T> ignoreStrategy) {
        return expression.eq0(index, getPropertyMapping(value), value, ignoreStrategy);
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
    public L ne(T value) {
        return expression.ne0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(T value, IgnoreStrategy ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(T value, Predicate<T> ignoreStrategy) {
        return expression.ne0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T value) {
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T value, Predicate<T> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T[] value) {
        return expression.in0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(T[] value, Predicate<T[]> ignoreStrategy) {
        return expression.in0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(T value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(T value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(T value, Predicate<T> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(T[] value) {
        return expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(T[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(T[] value, Predicate<T[]> ignoreStrategy) {
        return expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
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

}
