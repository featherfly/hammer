
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup2;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic2;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableUpdate2;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate3;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNestedValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateSetExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn2;

/**
 * sql entity executable update .
 *
 * @author zhongj
 * @param <E> the update type
 */
public class EntitySqlExecutableUpdate2<E, J1> implements EntitySqlUpdate2<E, J1>, EntityExecutableUpdate2<E, J1> {

    private EntitySqlExecutableUpdate<E> update;

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param jdbc         the jdbc
     * @param classMapping the class mapping
     * @param factory      the factory
     * @param updateConfig the update config
     */
    public EntitySqlExecutableUpdate2(EntitySqlExecutableUpdate<E> update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UpdateValueExpression<R, EntityExecutableUpdate2<E, J1>,
        EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig>> property(
            SerializableFunction<E, R> property) {
        return new EntityUpdateValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R,
        O> UpdateValueExpression<O, EntityExecutableUpdate2<E, J1>,
            EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig>,
            EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig>> property(
                SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty) {
        return new EntityUpdateNestedValueImpl<>(property, nestedProperty, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UpdateNumberValueExpression<R, EntityExecutableUpdate2<E, J1>,
        EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig>> property(
            SerializableToNumberFunction<E, R> property) {
        return new EntityUpdateNumberValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate2<E, J1> set(Consumer<EntityUpdateSetExpression<E, EntityExecutableUpdate2<E, J1>,
        EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig>>> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate2<E, J1> set(SerializableFunction<E, R> property, R value) {
        update.set(property, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate2<E, J1> set(SerializableFunction<E, R> property, R value,
        Predicate<R> ignoreStrategy) {
        update.set(property, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O> EntityExecutableUpdate2<E, J1> set(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value) {
        update.set(property, nestedProperty, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O> EntityExecutableUpdate2<E, J1> set(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value, Predicate<O> ignoreStrategy) {
        update.set(property, nestedProperty, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate2<E, J1> set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityExecutableUpdate2<E, J1> set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O> EntityExecutableUpdate2<E, J1> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty) {
        update.set(property, nestedProperty);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O> EntityExecutableUpdate2<E, J1> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty, Predicate<O> ignoreStrategy) {
        update.set(property, nestedProperty, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableFunction<E, N> property, N value) {
        update.increase(property, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableFunction<E, N> property, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(property, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value) {
        update.increase(property, nestedProperty, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value, Predicate<N> ignoreStrategy) {
        update.increase(property, nestedProperty, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty) {
        update.increase(property, nestedProperty);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate2<E, J1> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty, Predicate<N> ignoreStrategy) {
        update.increase(property, nestedProperty, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityUpdateExpression<E, EntityExecutableUpdate2<E, J1>,
        EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig>> configure(
            Consumer<UpdateConfig> configure) {
        if (configure != null) {
            configure.accept(update.relation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig> where(
        BiFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<J1, ?, ?>,
            LogicExpression<?, ?>> entitiesCondtionFuntion) {
        EntitySqlUpdateConditions2<E, J1> expr = createSqlUpdateExpression();
        if (entitiesCondtionFuntion != null) {
            expr.addCondition(entitiesCondtionFuntion.apply(
                new EntitySqlConditionsGroupExpression<>(0, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(1, update.factory, update.relation)));
        }
        return expr;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig> where() {
        return createSqlUpdateExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression2<E, J1, J, EntityUpdate3<E, J1, J>> join(Class<J> joinType) {
        return new EntitySqlOn2<>(joinType, new EntitySqlExecutableUpdate3<>(update), update.factory, update.relation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return createSqlUpdateExpression().execute();
    }

    private EntitySqlUpdateConditions2<E, J1> createSqlUpdateExpression() {
        return new EntitySqlUpdateConditions2<>(update.factory, update.relation);
    }

}
