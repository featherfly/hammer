
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityPropertyExpressionImpl.java
 * @Description: EqualsEntityPropertyExpressionImpl
 * @author: zhongj
 * @date: 2023-09-20 16:08:20
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.lk;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityPropertySetValueExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class LikeEntityPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LikeEntityPropertyExpressionImpl<V, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<V, C, L>
        implements LikeEntityPropertyExpression<V>, LikeEntityPropertySetValueExpression {

    /**
     * Instantiates a new like entity property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public LikeEntityPropertyExpressionImpl(int index, SerializableFunction<?, V> name,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new like entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public LikeEntityPropertyExpressionImpl(int index, List<Serializable> propertyList,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new like entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public LikeEntityPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> LikeEntityPropertyExpression<R> property(SerializableFunction<V, R> name) {
        propertyList.add(name);
        return new LikeEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LikeEntityPropertySetValueExpression property(SerializableToStringFunction<V> name) {
        propertyList.add(name);
        return new LikeEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * Property.
     *
     * @param name the name
     * @return LogicExpressionike entity property set value expression
     */
    private LikeEntityPropertySetValueExpression property(SerializableSupplier<String> name) {
        propertyList.add(name);
        return new LikeEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> LikeEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy) {
        expression.lk(index, getPropertyMapping(value), value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.lk(index, getPropertyMapping(value), value, matchStrategy, ignoreStrategy);
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
