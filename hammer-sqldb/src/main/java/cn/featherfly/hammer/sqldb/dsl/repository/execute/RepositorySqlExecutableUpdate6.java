
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableUpdate6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository sql executable update6 .
 *
 * @author zhongj
 */
public class RepositorySqlExecutableUpdate6 implements RepositorySqlUpdate6, RepositoryExecutableUpdate6 {

    protected RepositorySqlExecutableUpdate update;

    /**
     * Instantiates a new repository sql executable update 6.
     *
     * @param update the update
     */
    public RepositorySqlExecutableUpdate6(RepositorySqlExecutableUpdate update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate6 set(String name, V value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate6 set(String name, V value, Predicate<V> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate6 set(SerializableFunction<T, R> name, R value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate6 set(SerializableFunction<T, R> name, R value,
        Predicate<R> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate6 set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate6 set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlExecutableUpdate6 set(Consumer<RepositoryExecutableUpdate6> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate6 increase(String name, N value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> RepositorySqlExecutableUpdate6 increase(SerializableFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate6 increase(String name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> RepositorySqlExecutableUpdate6 increase(SerializableFunction<T, R> name, R value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate6 increase(SerializableSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate6 increase(SerializableSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValueExpression<Object, RepositoryExecutableUpdate6,
        RepositoryExecutableConditionsGroup6<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig>> field(String name) {
        return new RepositoryUpdateValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValueExpression<Number, RepositoryExecutableUpdate6,
        RepositoryExecutableConditionsGroup6<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig>> fieldAsNumber(String name) {
        return new RepositoryUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R> UpdateValueExpression<R, RepositoryExecutableUpdate6,
            RepositoryExecutableConditionsGroup6<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig>> field(SerializableFunction<T, R> name) {
        return new RepositoryUpdateValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Number> UpdateNumberValueExpression<R, RepositoryExecutableUpdate6,
            RepositoryExecutableConditionsGroup6<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig>> fieldAsNumber(
                SerializableFunction<T, R> name) {
        return new RepositoryUpdateNumberValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup6<UpdateConditionConfig> where() {
        return new RepositorySqlUpdateConditions6(update.updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig> where(
        SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        RepositorySqlUpdateConditions6 sqlUpdateExpression = new RepositorySqlUpdateConditions6(update.updateRelation);
        if (repositoriesCondtionFuntion != null) {
            //filterable.apply(sqlUpdateExpression);
            sqlUpdateExpression.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(3, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(4, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(5, update.updateRelation) //
                ));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdateExpression<RepositoryExecutableUpdate6,
        RepositoryExecutableConditionsGroup6<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig>> configure(Consumer<UpdateConfig> configure) {
        if (configure != null) {
            configure.accept(update.updateRelation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return update.execute();
    }
}
