
package cn.featherfly.hammer.sqldb.dsl.entity.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression4;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup4;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic4;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableUpdate4;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate5;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdateNestedNumberValueImpl;
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
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn4;

/**
 * sql entity executable update .
 *
 * @author zhongj
 * @param <E> the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 */
public class EntitySqlExecutableUpdate4<E, J1, J2, J3>
    implements EntitySqlUpdate4<E, J1, J2, J3>, EntityExecutableUpdate4<E, J1, J2, J3> {

    private EntitySqlExecutableUpdate<E> update;

    /**
     * Instantiates a new sql entity executable update.
     *
     * @param update the update
     */
    public EntitySqlExecutableUpdate4(EntitySqlExecutableUpdate<E> update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UpdateValueExpression<R, EntityExecutableUpdate4<E, J1, J2, J3>,
        EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>> property(
            SerializableFunction<E, R> property) {
        return new EntityUpdateValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R,
        O extends Serializable> UpdateValueExpression<O, EntityExecutableUpdate4<E, J1, J2, J3>,
            EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
            EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>> property(
                SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty) {
        return new EntityUpdateNestedValueImpl<>(property, nestedProperty, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R,
        O extends Number> UpdateNumberValueExpression<O, EntityExecutableUpdate4<E, J1, J2, J3>,
            EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
            EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>> property(
                SerializableFunction<E, R> property, SerializableToNumberFunction<R, O> nestedProperty) {
        return new EntityUpdateNestedNumberValueImpl<>(property, nestedProperty, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UpdateNumberValueExpression<R, EntityExecutableUpdate4<E, J1, J2, J3>,
        EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>> property(
            SerializableToNumberFunction<E, R> property) {
        return new EntityUpdateNumberValueImpl<>(property, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate4<E, J1, J2, J3> set(Consumer<EntityUpdateSetExpression<E,
        EntityExecutableUpdate4<E, J1, J2, J3>, EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>>> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableFunction<E, R> property,
        R value) {
        update.set(property, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableFunction<E, R> property,
        R value, Predicate<R> ignoreStrategy) {
        update.set(property, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value) {
        update.set(property, nestedProperty, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value, Predicate<O> ignoreStrategy) {
        update.set(property, nestedProperty, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableSupplier<R> property,
        Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty) {
        update.set(property, nestedProperty);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, O extends Serializable> EntityExecutableUpdate4<E, J1, J2, J3> set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty, Predicate<O> ignoreStrategy) {
        update.set(property, nestedProperty, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableFunction<E, N> property,
        N value) {
        update.increase(property, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableFunction<E, N> property,
        N value, Predicate<N> ignoreStrategy) {
        update.increase(property, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value) {
        update.increase(property, nestedProperty, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value, Predicate<N> ignoreStrategy) {
        update.increase(property, nestedProperty, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableNumberSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty) {
        update.increase(property, nestedProperty);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, N extends Number> EntityExecutableUpdate4<E, J1, J2, J3> increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty, Predicate<N> ignoreStrategy) {
        update.increase(property, nestedProperty, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityUpdateExpression<E, EntityExecutableUpdate4<E, J1, J2, J3>,
        EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>> configure(
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
    public EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig> where(
        FourArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<J1, ?, ?>,
            EntityConditionsGroupExpression<J2, ?, ?>, EntityConditionsGroupExpression<J3, ?, ?>,
            LogicExpression<?, ?>> entitiesCondtionFuntion) {
        EntitySqlUpdateConditions4<E, J1, J2, J3> expr = createSqlUpdateExpression();
        if (entitiesCondtionFuntion != null) {
            expr.addCondition(entitiesCondtionFuntion.apply(
                new EntitySqlConditionsGroupExpression<>(0, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(1, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(2, update.factory, update.relation),
                new EntitySqlConditionsGroupExpression<>(3, update.factory, update.relation)));
        }
        return expr;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig> where() {
        return createSqlUpdateExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression4<E, J1, J2, J3, J, EntityUpdate5<E, J1, J2, J3, J>> join(Class<J> joinType) {
        return new EntitySqlOn4<>(joinType, new EntitySqlExecutableUpdate5<>(update), update.factory, update.relation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return createSqlUpdateExpression().execute();
    }

    private EntitySqlUpdateConditions4<E, J1, J2, J3> createSqlUpdateExpression() {
        return new EntitySqlUpdateConditions4<>(update.factory, update.relation);
    }

}
