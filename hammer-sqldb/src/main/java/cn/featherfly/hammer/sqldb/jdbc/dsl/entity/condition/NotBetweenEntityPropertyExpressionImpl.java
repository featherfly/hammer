
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;

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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDatePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoublePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDatePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ba.BetweenEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDatePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDoublePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionEnumPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionIntPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDatePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDateTimePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalTimePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLongPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionNumberPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionStringPropertyExpression2Impl;

/**
 * The Class NotBetweenEntityPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotBetweenEntityPropertyExpressionImpl<V, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<V, C, L> implements NotBetweenEntityPropertyExpression<V> {

    /**
     * Instantiates a new not between entity property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotBetweenEntityPropertyExpressionImpl(int index, SerializableFunction<?, V> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new not between entity property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotBetweenEntityPropertyExpressionImpl(AtomicInteger index, SerializableFunction<?, V> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(index, name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new between entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotBetweenEntityPropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new between entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotBetweenEntityPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
            E> BetweenEntityPropertyExpression<E> property(SerializableToCollectionFunction<V, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionIntPropertyExpression2 property(SerializableToIntFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionIntPropertyExpression2Impl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLongPropertyExpression2 property(SerializableToLongFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLongPropertyExpression2Impl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionDoublePropertyExpression2 property(SerializableToDoubleFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionDoublePropertyExpression2Impl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> ConditionEntityExpressionDatePropertyExpression2<D> property(
            SerializableToDateFunction<V, D> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionDatePropertyExpression2Impl<>(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDatePropertyExpression2 property(SerializableToLocalDateFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLocalDatePropertyExpression2Impl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalTimePropertyExpression2 property(SerializableToLocalTimeFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLocalTimePropertyExpression2Impl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDateTimePropertyExpression2 property(
            SerializableToLocalDateTimeFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLocalDateTimePropertyExpression2Impl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> ConditionEntityExpressionNumberPropertyExpression2<R> property(
            SerializableToNumberFunction<V, R> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionNumberPropertyExpression2Impl<>(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression2<R> property(
            SerializableToEnumFunction<V, R> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionEnumPropertyExpression2Impl<>(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionStringPropertyExpression2 property(SerializableToStringFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionStringPropertyExpression2Impl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (min, max, ignore, pm) -> {
                    expression.nba0(index, pm, min, max, ignore);
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> BetweenAndEntityPropertyExpression<R> property(SerializableFunction<V, R> name) {
        return new NotBetweenEntityPropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<V> name, int min, int max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<V> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<V> name, long min, long max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<V> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<V> name, double min, double max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<V> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableToNumberFunction<V, N> name, N min, N max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableToNumberFunction<V, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableToDateFunction<V, D> name, D min, D max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableToDateFunction<V, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalTimeFunction<V> name, LocalTime min, LocalTime max) {
        property(name).value(min, max);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalTimeFunction<V> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateFunction<V> name, LocalDate min, LocalDate max) {
        property(name).value(min, max);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateFunction<V> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateTimeFunction<V> name, LocalDateTime min, LocalDateTime max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateTimeFunction<V> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String min, String max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> void accept(SerializableToEnumFunction<V, E> name, E min, E max) {
        property(name).value(min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> void accept(SerializableToEnumFunction<V, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy) {
        property(name).value(min, max, ignoreStrategy);
    }
}
