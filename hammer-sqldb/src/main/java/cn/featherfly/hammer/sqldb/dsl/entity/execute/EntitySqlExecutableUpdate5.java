
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression5;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup5;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic5;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableUpdate5;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate6;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNestedValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateSetExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn5;

/**
 * sql entity executable update .
 *
 * @author zhongj
 * @param <E> the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 */
public class EntitySqlExecutableUpdate5<E, J1, J2, J3, J4>
    implements EntitySqlUpdate5<E, J1, J2, J3, J4>, EntityExecutableUpdate5<E, J1, J2, J3, J4> {

    private EntitySqlExecutableUpdate<E> update;

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param update the update
     */
    public EntitySqlExecutableUpdate5(EntitySqlExecutableUpdate<E> update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UpdateValueExpression<R, EntityExecutableUpdate5<E, J1, J2, J3, J4>,
        EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig>> property(
            SerializableFunction<E, R> property) {
        return new EntityUpdateValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R,
        O extends Serializable> UpdateValueExpression<O, EntityExecutableUpdate5<E, J1, J2, J3, J4>,
            EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig>,
            EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig>> property(
                SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty) {
        return new EntityUpdateNestedValueImpl<>(property, nestedProperty, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UpdateNumberValueExpression<R, EntityExecutableUpdate5<E, J1, J2, J3, J4>,
        EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig>> property(
            SerializableToNumberFunction<E, R> property) {
        return new EntityUpdateNumberValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate5<E, J1, J2, J3, J4> set(
        Consumer<EntityUpdateSetExpression<E, EntityExecutableUpdate5<E, J1, J2, J3, J4>,
            EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig>,
            EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig>>> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(SerializableFunction<E, R> property,
        R value) {
        update.set(property, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(SerializableFunction<E, R> property,
        R value, Predicate<R> ignoreStrategy) {
        update.set(property, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(
        SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty, O value) {
        update.set(property, nestedProperty, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(
        SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty, O value,
        Predicate<O> ignoreStrategy) {
        update.set(property, nestedProperty, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(SerializableSupplier<R> property,
        Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty) {
        update.set(property, nestedProperty);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate5<E, J1, J2, J3, J4> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty, Predicate<O> ignoreStrategy) {
        update.set(property, nestedProperty, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(SerializableFunction<E, N> property,
        N value) {
        update.increase(property, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(SerializableFunction<E, N> property,
        N value, Predicate<N> ignoreStrategy) {
        update.increase(property, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(
        SerializableFunction<E, R> property, SerializableFunction<R, N> nestedProperty, N value) {
        update.increase(property, nestedProperty, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(
        SerializableFunction<E, R> property, SerializableFunction<R, N> nestedProperty, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(property, nestedProperty, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(SerializableSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(SerializableSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty) {
        update.increase(property, nestedProperty);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate5<E, J1, J2, J3, J4> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty, Predicate<N> ignoreStrategy) {
        update.increase(property, nestedProperty, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityUpdateExpression<E, EntityExecutableUpdate5<E, J1, J2, J3, J4>,
        EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig>> configure(
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
    public EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig> where(
        FiveArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<J1, ?, ?>,
            EntityConditionsGroupExpression<J2, ?, ?>, EntityConditionsGroupExpression<J3, ?, ?>,
            EntityConditionsGroupExpression<J4, ?, ?>, LogicExpression<?, ?>> entitiesCondtionFuntion) {
        EntitySqlUpdateConditions5<E, J1, J2, J3, J4> expr = createSqlUpdateExpression();
        if (entitiesCondtionFuntion != null) {
            expr.addCondition(entitiesCondtionFuntion.apply(
                new EntitySqlConditionsGroupExpression<>(0, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(1, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(2, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(3, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(4, update.factory, update.relation)));
        }
        return expr;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig> where() {
        return createSqlUpdateExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression5<E, J1, J2, J3, J4, J, EntityUpdate6<E, J1, J2, J3, J4, J>> join(Class<J> joinType) {
        return new EntitySqlOn5<>(joinType, new EntitySqlExecutableUpdate6<>(update), update.factory, update.relation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return createSqlUpdateExpression().execute();
    }

    private EntitySqlUpdateConditions5<E, J1, J2, J3, J4> createSqlUpdateExpression() {
        return new EntitySqlUpdateConditions5<>(update.factory, update.relation);
    }
}
