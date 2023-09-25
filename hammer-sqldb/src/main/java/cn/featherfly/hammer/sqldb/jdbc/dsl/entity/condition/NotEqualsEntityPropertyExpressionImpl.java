
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityPropertyExpressionImpl.java
 * @Description: EqualsEntityPropertyExpressionImpl
 * @author: zhongj
 * @date: 2023-09-20 16:08:20
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityPropertyExpression;

/**
 * NotEqualsEntityPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotEqualsEntityPropertyExpressionImpl<V, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<V, C, L> implements NotEqualsEntityPropertyExpression<V> {

    /**
     * Instantiates a new equals entity expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     * @param factory    the factory
     */
    public NotEqualsEntityPropertyExpressionImpl(int index, SerializableFunction<?, V> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, name, expression, factory);
    }

    /**
     * Instantiates a new equals entity property expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    public NotEqualsEntityPropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotEqualsEntityPropertyExpression<R> property(SerializableFunction<V, R> name) {
        propertyList.add(name);
        return new NotEqualsEntityPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    private <R> NotEqualsEntityPropertyExpression<R> property(SerializableSupplier<R> name) {
        propertyList.add(name);
        return new NotEqualsEntityPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotEqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value) {
        expression.ne0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, MatchStrategy matchStrategy) {
        expression.ne0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, Predicate<V> ignoreStrategy) {
        expression.ne0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, MatchStrategy matchStrategy, Predicate<V> ignoreStrategy) {
        expression.ne0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> property, R value) {
        property(property).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> property, R value, MatchStrategy matchStrategy) {
        property(property).value(value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> property, R value, Predicate<R> ignoreStrategy) {
        property(property).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> property, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        property(property).value(value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property) {
        property(property).value(property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        property(property).value(property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
        property(property).value(property.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        property(property).value(property.get(), matchStrategy, ignoreStrategy);
    }

}
