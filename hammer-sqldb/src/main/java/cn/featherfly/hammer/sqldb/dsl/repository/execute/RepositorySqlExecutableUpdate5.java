
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableUpdate5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlOn5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository sql executable update5 .
 *
 * @author zhongj
 */
public class RepositorySqlExecutableUpdate5 implements RepositorySqlUpdate5, RepositoryExecutableUpdate5 {

    protected RepositorySqlExecutableUpdate update;

    /**
     * Instantiates a new repository sql executable update 5.
     *
     * @param update the update
     */
    public RepositorySqlExecutableUpdate5(RepositorySqlExecutableUpdate update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate5 set(String name, V value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate5 set(String name, V value, Predicate<V> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate5 set(SerializableFunction<T, R> name, R value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate5 set(SerializableFunction<T, R> name, R value,
        Predicate<R> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate5 set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate5 set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlExecutableUpdate5 set(Consumer<RepositoryExecutableUpdate5> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate5 increase(String name, N value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> RepositorySqlExecutableUpdate5 increase(SerializableFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate5 increase(String name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> RepositorySqlExecutableUpdate5 increase(SerializableFunction<T, R> name, R value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate5 increase(SerializableSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate5 increase(SerializableSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValueExpression<Serializable, RepositoryExecutableUpdate5,
        RepositoryExecutableConditionsGroup5<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig>> field(String name) {
        return new RepositoryUpdateValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValueExpression<Number, RepositoryExecutableUpdate5,
        RepositoryExecutableConditionsGroup5<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig>> fieldAsNumber(String name) {
        return new RepositoryUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Serializable> UpdateValueExpression<R, RepositoryExecutableUpdate5,
            RepositoryExecutableConditionsGroup5<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig>> field(SerializableFunction<T, R> name) {
        return new RepositoryUpdateValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Number> UpdateNumberValueExpression<R, RepositoryExecutableUpdate5,
            RepositoryExecutableConditionsGroup5<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig>> fieldAsNumber(
                SerializableFunction<T, R> name) {
        return new RepositoryUpdateNumberValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup5<UpdateConditionConfig> where() {
        return new RepositorySqlUpdateConditions5(update.updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig> where(
        FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        RepositorySqlUpdateConditions5 sqlUpdateExpression = new RepositorySqlUpdateConditions5(update.updateRelation);
        if (repositoriesCondtionFuntion != null) {
            //filterable.apply(sqlUpdateExpression);
            sqlUpdateExpression.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(3, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(4, update.updateRelation) //
                ));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdateExpression<RepositoryExecutableUpdate5,
        RepositoryExecutableConditionsGroup5<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig>> configure(Consumer<UpdateConfig> configure) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression5<RepositoryUpdate6> join(Repository repository) {
        return new RepositorySqlOn5<RepositoryUpdate6, UpdateConditionConfig, RepositorySqlUpdateRelation,
            SqlUpdateSetBasicBuilder>(repository, new RepositorySqlExecutableUpdate6(update), update.updateRelation);
    }
}
