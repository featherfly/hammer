
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
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
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
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDateAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoubleAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimeAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDateAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDoubleAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionEnumAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionIntAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDateAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLongAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionNumberAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionStringAndArrayPropertyExpressionImpl;

/**
 * The Class NotInEntityPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotInEntityPropertyExpressionImpl<V, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<V, C, L> implements NotInEntityPropertyExpression<V> {

    /**
     * Instantiates a new not in entity property expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     * @param factory    the factory
     */
    public NotInEntityPropertyExpressionImpl(int index, SerializableFunction<?, V> name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new not in entity property expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    public NotInEntityPropertyExpressionImpl(int index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new not in entity property expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    public NotInEntityPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionIntAndArrayPropertyExpression property(SerializableToIntFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionIntAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    @SuppressWarnings("unchecked")
    private ConditionEntityExpressionIntAndArrayPropertyExpression property(SerializableIntSupplier name) {
        propertyList.add(name);
        return new ConditionEntityExpressionIntAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLongAndArrayPropertyExpression property(SerializableToLongFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLongAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    @SuppressWarnings("unchecked")
    private ConditionEntityExpressionLongAndArrayPropertyExpression property(SerializableLongSupplier name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLongAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionDoubleAndArrayPropertyExpression property(SerializableToDoubleFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionDoubleAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    @SuppressWarnings("unchecked")
    private ConditionEntityExpressionDoubleAndArrayPropertyExpression property(SerializableDoubleSupplier name) {
        propertyList.add(name);
        return new ConditionEntityExpressionDoubleAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <R extends Number> ConditionEntityExpressionNumberAndArrayPropertyExpression<R> property(
            SerializableToNumberFunction<V, R> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionNumberAndArrayPropertyExpressionImpl<>(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <R extends Date> ConditionEntityExpressionDateAndArrayPropertyExpression<R> property(
            SerializableToDateFunction<V, R> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionDateAndArrayPropertyExpressionImpl<>(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <R extends Enum<R>> ConditionEntityExpressionEnumAndArrayPropertyExpression<R> property(
            SerializableToEnumFunction<V, R> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionEnumAndArrayPropertyExpressionImpl<>(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression property(
            SerializableToLocalDateTimeFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLocalDateAndArrayPropertyExpression property(
            SerializableToLocalDateFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLocalDateAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLocalTimeAndArrayPropertyExpression property(
            SerializableToLocalTimeFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.ni0(index, pm, value, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, ignore, pm) -> expression.ni0(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionStringAndArrayPropertyExpression property(SerializableToStringFunction<V> name) {
        propertyList.add(name);
        return new ConditionEntityExpressionStringAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(),
                (value, match, ignore, pm) -> expression.ni0(index, pm, value, match, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, match, ignore, pm) -> expression.ni0(index, pm, value, match, ignore));
    }

    @SuppressWarnings("unchecked")
    private ConditionEntityExpressionStringAndArrayPropertyExpression property(SerializableStringSupplier name) {
        propertyList.add(name);
        return new ConditionEntityExpressionStringAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
                expression.getIgnoreStrategy(),
                (value, match, ignore, pm) -> expression.ni0(index, pm, value, match, ignore),
                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
                (value, match, ignore, pm) -> expression.ni0(index, pm, value, match, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotInEntityPropertyExpression<R> property(SerializableFunction<V, R> name) {
        propertyList.add(name);
        return new NotInEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    private <R> NotInEntityPropertyExpression<R> property(SerializableSupplier<R> name) {
        propertyList.add(name);
        return new NotInEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
            E> NotInEntityPropertyExpression<E> property(SerializableToCollectionFunction<V, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> name, R value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> name, R value, Predicate<R> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<V> name, int value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<V> name, int value, IntPredicate ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<V> name, long value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<V> name, long value, LongPredicate ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<V> name, double value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<V> name, double value, DoublePredicate ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> name, @SuppressWarnings("unchecked") R... value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<V> name, int... value) {
        property(name).value(value);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<V> name, long... value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<V> name, int[] value, Predicate<int[]> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<V> name, long[] value, Predicate<long[]> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> name, Collection<R> value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<V, R> name, Collection<R> value,
            Predicate<Collection<R>> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String value, MatchStrategy matchStrategy) {
        property(name).value(value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        property(name).value(value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String[] value, MatchStrategy matchStrategy) {
        property(name).value(value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String[] value, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy) {
        property(name).value(value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        property(property).value(property.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        property(property).value(property.get(), matchStrategy, ignoreStrategy);
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
    public void accept(SerializableIntSupplier property) {
        property(property).value(property.getAsInt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        property(property).value(property.getAsInt(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLongSupplier property) {
        property(property).value(property.getAsLong());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        property(property).value(property.getAsLong(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableDoubleSupplier property) {
        property(property).value(property.getAsDouble());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        property(property).value(property.getAsDouble(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value) {
        expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, Predicate<V> ignoreStrategy) {
        expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(@SuppressWarnings("unchecked") V... value) {
        expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V[] value, Predicate<V[]> ignoreStrategy) {
        expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(Collection<V> value) {
        expression.ni0(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(Collection<V> value, Predicate<Collection<V>> ignoreStrategy) {
        expression.ni0(index, getPropertyMapping(value), value, ignoreStrategy);
    }
}
