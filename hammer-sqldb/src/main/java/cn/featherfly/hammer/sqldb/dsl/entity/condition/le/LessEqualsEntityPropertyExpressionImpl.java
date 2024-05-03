
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityPropertyExpressionImpl.java
 * @Description: EqualsEntityPropertyExpressionImpl
 * @author: zhongj
 * @date: 2023-09-20 16:08:20
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.le;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
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
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.AbstractMulitiEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * The Class LessEqualsEntityPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LessEqualsEntityPropertyExpressionImpl<V, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityPropertyExpression<V, C, L> implements LessEqualsEntityPropertyExpression<V> {

    /**
     * Instantiates a new less equals entity property expression impl.
     *
     * @param index         the index
     * @param name          the name
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public LessEqualsEntityPropertyExpressionImpl(int index, SerializableFunction<?, V> name,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(new AtomicInteger(index), name, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new less equals entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public LessEqualsEntityPropertyExpressionImpl(int index, List<Serializable> propertyList,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(new AtomicInteger(index), propertyList, expression, factory, queryRelation);
    }

    /**
     * Instantiates a new less equals entity property expression impl.
     *
     * @param index         the index
     * @param propertyList  the property list
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public LessEqualsEntityPropertyExpressionImpl(AtomicInteger index, List<Serializable> propertyList,
            InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> CompareEntityPropertyExpression<R> property(SerializableFunction<V, R> name) {
        propertyList.add(name);
        return new LessEqualsEntityPropertyExpressionImpl<>(index, propertyList, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> CompareEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntExpression property(SerializableToIntFunction<V> name) {
        propertyList.add(name);
        return new SetIntExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongExpression property(SerializableToLongFunction<V> name) {
        propertyList.add(name);
        return new SetLongExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetDoubleExpression property(SerializableToDoubleFunction<V> name) {
        propertyList.add(name);
        return new SetDoubleExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateExpression<D> property(SerializableToDateFunction<V, D> name) {
        propertyList.add(name);
        return new SetDateExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateExpression property(SerializableToLocalDateFunction<V> name) {
        propertyList.add(name);
        return new SetLocalDateExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalTimeExpression property(SerializableToLocalTimeFunction<V> name) {
        propertyList.add(name);
        return new SetLocalTimeExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateTimeExpression property(SerializableToLocalDateTimeFunction<V> name) {
        propertyList.add(name);
        return new SetLocalDateTimeExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberExpression<N> property(SerializableToNumberFunction<V, N> name) {
        propertyList.add(name);
        return new SetNumberExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumExpression<E> property(SerializableToEnumFunction<V, E> name) {
        propertyList.add(name);
        return new SetEnumExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetStringExpression property(SerializableToStringFunction<V> name) {
        propertyList.add(name);
        return new SetStringExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, match, ignore, pm) -> expression.le(index, pm, value, match, ignore));
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression int property expression
     */
    private SetIntExpression property(SerializableIntSupplier name) {
        propertyList.add(name);
        return new SetIntExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression long property expression
     */
    private SetLongExpression property(SerializableLongSupplier name) {
        propertyList.add(name);
        return new SetLongExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression double property expression
     */
    private SetDoubleExpression property(SerializableDoubleSupplier name) {
        propertyList.add(name);
        return new SetDoubleExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the condition entity expression date property expression
     */
    private <D extends Date> SetDateExpression<D> property(SerializableDateSupplier<D> name) {
        propertyList.add(name);
        return new SetDateExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression local date property expression
     */
    private SetLocalDateExpression property(SerializableLocalDateSupplier name) {
        propertyList.add(name);
        return new SetLocalDateExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression local time property expression
     */
    private SetLocalTimeExpression property(SerializableLocalTimeSupplier name) {
        propertyList.add(name);
        return new SetLocalTimeExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression local date time property
     *         expression
     */
    private SetLocalDateTimeExpression property(SerializableLocalDateTimeSupplier name) {
        propertyList.add(name);
        return new SetLocalDateTimeExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param <N>  the number type
     * @param name the name
     * @return the condition entity expression number property expression
     */
    private <N extends Number> SetNumberExpression<N> property(SerializableNumberSupplier<N> name) {
        propertyList.add(name);
        return new SetNumberExpressionImpl<>(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, ignore, pm) -> expression.le(index, pm, value, ignore));
    }

    /**
     * Property.
     *
     * @param name the name
     * @return the condition entity expression string property expression
     */
    private SetStringExpression property(SerializableStringSupplier name) {
        propertyList.add(name);
        return new SetStringExpressionImpl(v -> getPropertyMapping(v), expression.getIgnoreStrategy(),
                (value, match, ignore, pm) -> expression.le(index, pm, value, match, ignore));
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
    public <N extends Number> void accept(SerializableToNumberFunction<V, N> name, N value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableToNumberFunction<V, N> name, N value,
            Predicate<N> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableToDateFunction<V, D> name, D value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableToDateFunction<V, D> name, D value, Predicate<D> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalTimeFunction<V> name, LocalTime value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalTimeFunction<V> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateFunction<V> name, LocalDate value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateFunction<V> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateTimeFunction<V> name, LocalDateTime value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateTimeFunction<V> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String value) {
        property(name).value(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<V> name, String value, Predicate<String> ignoreStrategy) {
        property(name).value(value, ignoreStrategy);
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
    public <R extends Date> void accept(SerializableDateSupplier<R> property) {
        property(property).value(property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> void accept(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        property(property).value(property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> void accept(SerializableNumberSupplier<R> property) {
        property(property).value(property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> void accept(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        property(property).value(property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateSupplier property) {
        property(property).value(property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        property(property).value(property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalTimeSupplier property) {
        property(property).value(property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        property(property).value(property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateTimeSupplier property) {
        property(property).value(property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        property(property).value(property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier property) {
        property(property).value(property.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        property(property).value(property.get(), ignoreStrategy);
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
}
