
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityPropertyExpressionImpl.java
 * @Description: EqualsEntityPropertyExpressionImpl
 * @author: zhongj
 * @date: 2023-09-20 16:08:20
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.in;

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
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.AbstractMulitiEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class InEntityPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class InEntityPropertyExpressionImpl<V, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<V, C, L> implements InEntityPropertyExpression<V> {

    /**
     * Instantiates a new in entity property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public InEntityPropertyExpressionImpl(int index, SerializableFunction<?, V> name,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new in entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public InEntityPropertyExpressionImpl(int index, List<Serializable> propertyList,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new in entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public InEntityPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntArrayExpression property(SerializableToIntFunction<V> name) {
        propertyList.add(name);
        return new SetIntArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression int and array property expression
     */
    private SetIntArrayExpression property(SerializableIntSupplier name) {
        propertyList.add(name);
        return new SetIntArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongArrayExpression property(SerializableToLongFunction<V> name) {
        propertyList.add(name);
        return new SetLongArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression long and array property
     *         expression
     */
    private SetLongArrayExpression property(SerializableLongSupplier name) {
        propertyList.add(name);
        return new SetLongArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public SetDoubleArrayExpression property(SerializableToDoubleFunction<V> name) {
        propertyList.add(name);
        return new SetDoubleArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression double and array property
     *         expression
     */

    private SetDoubleArrayExpression property(SerializableDoubleSupplier name) {
        propertyList.add(name);
        return new SetDoubleArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public <N extends Number> SetNumberArrayExpression<N> property(SerializableToNumberFunction<V, N> name) {
        propertyList.add(name);
        return new SetNumberArrayExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    //    /**
    //     * Property.
    //     *
    //     * @param <N>  the number type
    //     * @param name the name
    //     * @return the condition entity expression number and array property
    //     *         expression
    //     */
    //    private <N extends Number> SetNumberArrayExpression<N> property(
    //            SerializableNumberSupplier<N> name) {
    //        propertyList.add(name);
    //        return new ConditionEntityExpressionNumberAndArrayPropertyExpressionImpl<>(v -> getPropertyMapping(v),
    //                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.in(index, pm, value, ignore),
    //                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
    //                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    //    }

    /**
     * {@inheritDoc}
     */

    @Override
    public <D extends Date> SetDateArrayExpression<D> property(SerializableToDateFunction<V, D> name) {
        propertyList.add(name);
        return new SetDateArrayExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    //    /**
    //     * Property.
    //     *
    //     * @param <D>  the generic type
    //     * @param name the name
    //     * @return the condition entity expression date and array property
    //     *         expression
    //     */
    //    private <D extends Date> SetDateArrayExpression<D> property(
    //            SerializableDateSupplier<D> name) {
    //        propertyList.add(name);
    //        return new ConditionEntityExpressionDateAndArrayPropertyExpressionImpl<>(v -> getPropertyMapping(v),
    //                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.in(index, pm, value, ignore),
    //                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
    //                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumArrayExpression<E> property(SerializableToEnumFunction<V, E> name) {
        propertyList.add(name);
        return new SetEnumArrayExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    //    /**
    //     * Property.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return the condition entity expression enum and array property
    //     *         expression
    //     */
    //    private <R extends Enum<R>> ConditionEntityExpressionEnumAndArrayPropertyExpression<R> property(
    //            SerializableEnumSupplier<R> name) {
    //        propertyList.add(name);
    //        return new ConditionEntityExpressionEnumAndArrayPropertyExpressionImpl<>(v -> getPropertyMapping(v),
    //                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.in(index, pm, value, ignore),
    //                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
    //                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    //    }

    /**
     * {@inheritDoc}
     */

    @Override
    public SetLocalDateTimeArrayExpression property(SerializableToLocalDateTimeFunction<V> name) {
        propertyList.add(name);
        return new SetLocalDateTimeArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    //    /**
    //     * Property.
    //     *
    //     * @param name the name
    //     * @return the condition entity expression local date time and array
    //     *         property expression
    //     */
    //    private SetLocalDateTimeArrayExpression property(
    //            SerializableLocalDateTimeSupplier name) {
    //        propertyList.add(name);
    //        return new ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
    //                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.in(index, pm, value, ignore),
    //                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
    //                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    //    }

    /**
     * {@inheritDoc}
     */

    @Override
    public SetLocalDateArrayExpression property(SerializableToLocalDateFunction<V> name) {
        propertyList.add(name);
        return new SetLocalDateArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    //    /**
    //     * Property.
    //     *
    //     * @param name the name
    //     * @return the condition entity expression local date and array property
    //     *         expression
    //     */
    //    private SetLocalDateArrayExpression property(SerializableLocalDateSupplier name) {
    //        propertyList.add(name);
    //        return new ConditionEntityExpressionLocalDateAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
    //                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.in(index, pm, value, ignore),
    //                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
    //                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    //    }

    /**
     * {@inheritDoc}
     */

    @Override
    public SetLocalTimeArrayExpression property(SerializableToLocalTimeFunction<V> name) {
        propertyList.add(name);
        return new SetLocalTimeArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore), v -> getPropertyMapping(v),
                array -> expression.getIgnoreStrategy().test(array),
                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    }

    //    /**
    //     * Property.
    //     *
    //     * @param name the name
    //     * @return the condition entity expression local time and array property
    //     *         expression
    //     */
    //    private SetLocalTimeArrayExpression property(SerializableLocalTimeSupplier name) {
    //        propertyList.add(name);
    //        return new ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl(v -> getPropertyMapping(v),
    //                expression.getIgnoreStrategy(), (value, ignore, pm) -> expression.in(index, pm, value, ignore),
    //                v -> getPropertyMapping(v), array -> ((Predicate<Object>) expression.getIgnoreStrategy()).test(array),
    //                (value, ignore, pm) -> expression.in(index, pm, value, ignore));
    //    }

    /**
     * {@inheritDoc}
     */

    @Override
    public SetStringArrayExpression property(SerializableToStringFunction<V> name) {
        propertyList.add(name);
        return new SetStringArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, match, ignore, pm) -> expression.in(index, pm, value, match, ignore),
                v -> getPropertyMapping(v), array -> expression.getIgnoreStrategy().test(array),
                (value, match, ignore, pm) -> expression.in(index, pm, value, match, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression string and array property
     *         expression
     */

    private SetStringArrayExpression property(SerializableStringSupplier name) {
        propertyList.add(name);
        return new SetStringArrayExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, match, ignore, pm) -> expression.in(index, pm, value, match, ignore),
                v -> getPropertyMapping(v), array -> expression.getIgnoreStrategy().test(array),
                (value, match, ignore, pm) -> expression.in(index, pm, value, match, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> InEntityPropertyExpression<R> property(SerializableFunction<V, R> name) {
        propertyList.add(name);
        return new InEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * Property.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the in entity property expression
     */
    private <R> InEntityPropertyExpression<R> property(SerializableSupplier<R> name) {
        propertyList.add(name);
        return new InEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
            E> InEntityPropertyExpression<E> property(SerializableToCollectionFunction<V, R, E> name) {
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

    // ****************************************************************************************************************
    //	value
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value) {
        expression.in(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, Predicate<V> ignoreStrategy) {
        expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(@SuppressWarnings("unchecked") V... value) {
        expression.in(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V[] value, Predicate<V[]> ignoreStrategy) {
        expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(Collection<V> value) {
        expression.in(index, getPropertyMapping(value), value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(Collection<V> value, Predicate<Collection<V>> ignoreStrategy) {
        expression.in(index, getPropertyMapping(value), value, ignoreStrategy);
    }

}
