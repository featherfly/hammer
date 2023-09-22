
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
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityPropertySetValueExpression;

/**
 * The Class NotStartWithEntityPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotStartWithEntityPropertyExpressionImpl<V, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<V, C, L>
        implements NotStartWithEntityPropertyExpression<V>, NotStartWithEntityPropertySetValueExpression {

    /**
     * Instantiates a new not start with entity property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     * @param factory    the factory
     */
    public NotStartWithEntityPropertyExpressionImpl(int index, SerializableFunction<?, V> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, name, expression, factory);
    }

    /**
     * Instantiates a new not start with entity property expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    public NotStartWithEntityPropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory) {
        super(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotStartWithEntityPropertyExpression<R> property(SerializableFunction<V, R> name) {
        propertyList.add(name);
        return new NotStartWithEntityPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NotStartWithEntityPropertySetValueExpression property(SerializableToStringFunction<V> name) {
        propertyList.add(name);
        return new NotStartWithEntityPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    public NotStartWithEntityPropertySetValueExpression property(SerializableSupplier<String> name) {
        propertyList.add(name);
        return new NotStartWithEntityPropertyExpressionImpl<>(index, propertyList, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotStartWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value) {
        value(value, MatchStrategy.AUTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy) {
        expression.nsw0(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, Predicate<String> ignoreStrategy) {
        value(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.nsw0(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> property, String value) {
        property(property).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> property, String value, MatchStrategy matchStrategy) {
        property(property).value(value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> property, String value, Predicate<String> ignoreStrategy) {
        property(property).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> property, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        property(property).value(value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue) {
        property(propertyValue).value(propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy) {
        property(propertyValue).value(propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy) {
        property(propertyValue).value(propertyValue.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        property(propertyValue).value(propertyValue.get(), matchStrategy, ignoreStrategy);
    }
}
